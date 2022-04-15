package fr.legrain.lib.data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;
import org.apache.log4j.Logger;

public class UtilHTTP {
	
	static Logger logger = Logger.getLogger(UtilHTTP.class.getName());
	
	static private BasicHttpContext localcontext = null;
	static private String user;
	static private String password;
	static private String hostname;
	static private String lastStatusLineText;
	static private int lastStatusLineCode;
	
	static public void initCredential(DefaultHttpClient httpclient,String user, String password, String hostname) {
		
		HttpHost targetHost = new HttpHost(hostname, 80, "http");

		httpclient.getCredentialsProvider().setCredentials(
				new AuthScope(targetHost.getHostName(), targetHost.getPort()),
				new UsernamePasswordCredentials(user, password));

		// Create AuthCache instance
		AuthCache authCache = new BasicAuthCache();
		// Generate BASIC scheme object and add it to the local
		// auth cache
		BasicScheme basicAuth = new BasicScheme();
		authCache.put(targetHost, basicAuth);

		// Add AuthCache to the execution context
		localcontext = new BasicHttpContext();
		localcontext.setAttribute(ClientContext.AUTH_CACHE, authCache);
	}
	
	static private void updateLastStatusInformations(StatusLine sl) {
		lastStatusLineText = sl.toString();
		lastStatusLineCode = sl.getStatusCode();
	}
	
	static public String post(String url) {
		return post(url,null);
	}
	
	static public String get(String url) {
		try {
			// prepare post method  
			HttpGet get = new HttpGet(url);

//			// add parameters to the post method  
//			if(param!=null) {
//				List <NameValuePair> parameters = new ArrayList <NameValuePair>();  
//				for (String paramName : param.keySet()) {
//					parameters.add(new BasicNameValuePair(paramName, param.get(paramName)));  
//				}
//				UrlEncodedFormEntity sendentity = new UrlEncodedFormEntity(parameters, HTTP.UTF_8);  
//				post.setEntity(sendentity);   
//			}

			// create the client and execute the post method  
			HttpClient client = new DefaultHttpClient();  
			HttpResponse response = null;
			
			if(user!=null && password!=null && hostname!=null) {
				initCredential((DefaultHttpClient)client, user, password, hostname);
				response = client.execute(get,localcontext);
			} else {
				response = client.execute(get);  
			}
			
			 BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),"UTF-8"));
		      String line = "";
		      String lineComplet = "";
		
		      while ((line = rd.readLine()) != null) {
		    	  lineComplet+=line;
		      }
			
			//retrieve the output and display it in console
			logger.debug("URL GET appellée : "+url);
			updateLastStatusInformations(response.getStatusLine());
			logger.debug(response.getStatusLine());
			
			client.getConnectionManager().shutdown();
			
			return lineComplet;
		} catch (Exception e) {
			logger.error("", e);
		}
		return null;
	}

	static public String post(String url, String paramName, String paramValue) {
		Map<String,String> param = new HashMap<String, String>();
		param.put(paramName, paramValue);
		return post(url,param);
	}
	
	static public String put(String url, String paramName, String paramValue) {
		Map<String,String> param = new HashMap<String, String>();
		param.put(paramName, paramValue);
		return put(url,param);
	}
	
	/**
	 * Envoi d'un requete HTTP en post à l'url indiquée avec les paramètres présent dans la map
	 * @param url
	 * @param param - Map - clé => nom_du_parametre, valeur => valeur du paramètre
	 */
	static public String post(String url, Map<String,String> param) {
		try {
			// prepare post method  
			HttpPost post = new HttpPost(url);

			// add parameters to the post method  
			if(param!=null) {
				List <NameValuePair> parameters = new ArrayList <NameValuePair>();  
				for (String paramName : param.keySet()) {
					parameters.add(new BasicNameValuePair(paramName, param.get(paramName)));  
				}
				UrlEncodedFormEntity sendentity = new UrlEncodedFormEntity(parameters, HTTP.UTF_8);  
				post.setEntity(sendentity);   
			}

			// create the client and execute the post method  
			HttpClient client = new DefaultHttpClient();  
			HttpResponse response = null;
			
			if(user!=null && password!=null && hostname!=null) {
				initCredential((DefaultHttpClient)client, user, password, hostname);
				response = client.execute(post,localcontext);
			} else {
				response = client.execute(post);  
			}

			//retrieve the output and display it in console
			logger.debug("URL POST appellée : "+url);
			updateLastStatusInformations(response.getStatusLine());
			logger.debug(response.getStatusLine());
			
			if(response!=null){
                InputStream in = response.getEntity().getContent();
                StringWriter writer = new StringWriter();
        		IOUtils.copy(in, writer, "UTF-8");
        		String res = writer.toString();
                return res;
			}
			
			client.getConnectionManager().shutdown();  
			
		} catch (Exception e) {
			logger.error("", e);
		}
		return null;
	}
	
	static public String put(String url, Map<String,String> param) {
		try {
			// prepare post method  
			HttpPut put = new HttpPut(url);

			// add parameters to the post method  
			if(param!=null) {
				List <NameValuePair> parameters = new ArrayList <NameValuePair>();  
				for (String paramName : param.keySet()) {
					parameters.add(new BasicNameValuePair(paramName, param.get(paramName)));  
				}
				//UrlEncodedFormEntity sendentity = new UrlEncodedFormEntity(parameters, HTTP.UTF_8);
				//put.setEntity(sendentity);
				for (String paramName : param.keySet()) {
					//put.setEntity(new StringEntity(param.get(paramName),HTTP.UTF_8));
					put.setEntity(new StringEntity(param.get(paramName),"UTF-8"));
					//put.setEntity(new StringEntity(param.get(paramName),"ISO-8859-1"));
				}
			}

			// create the client and execute the post method  
			HttpClient client = new DefaultHttpClient();  
			HttpResponse response = null;
			
			if(user!=null && password!=null && hostname!=null) {
				initCredential((DefaultHttpClient)client, user, password, hostname);
				response = client.execute(put,localcontext);
			} else {
				response = client.execute(put);  
			}

			System.out.println("URL PUT appellée : "+url+" ****** "+response.getStatusLine());
			//retrieve the output and display it in console
			logger.debug("URL PUT appellée : "+url);
			updateLastStatusInformations(response.getStatusLine());
			logger.debug(response.getStatusLine());
			
			if(response!=null){
                InputStream in = response.getEntity().getContent();
                StringWriter writer = new StringWriter();
        		IOUtils.copy(in, writer, "UTF-8");
        		String res = writer.toString();
                return res;
			}

			client.getConnectionManager().shutdown();  
		} catch (Exception e) {
			logger.error("", e);
		}
		return null;
	}
	
	static public String postImage(String url, Map<String,String> param, File img) {
		try {
			// prepare post method  
			HttpPost post = new HttpPost(url);
			
			// add parameters to the post method  
//			if(param!=null) {
//				List <NameValuePair> parameters = new ArrayList <NameValuePair>();  
//				for (String paramName : param.keySet()) {
//					parameters.add(new BasicNameValuePair(paramName, param.get(paramName)));  
//				}
//				//UrlEncodedFormEntity sendentity = new UrlEncodedFormEntity(parameters, HTTP.UTF_8);
//				//put.setEntity(sendentity);
//				for (String paramName : param.keySet()) {
//					put.setEntity(new StringEntity(param.get(paramName)));
//				}
				MultipartEntity entity = new MultipartEntity( HttpMultipartMode.BROWSER_COMPATIBLE );
				 
				// For File parameters
				entity.addPart( "image", new FileBody((( File ) img ), "image/jpeg" ));
				//entity.addPart( "cover", new StringBody("true"));
				 
				// For usual String parameters
				//entity.addPart( paramName, new StringBody( paramValue.toString(), "text/plain",
				//                                           Charset.forName( "UTF-8" )));
				 
				post.setEntity( entity );
				 
				// Here we go!
				//String response = EntityUtils.toString( client.execute( post ).getEntity(), "UTF-8" );
//			}

			// create the client and execute the post method  
			HttpClient client = new DefaultHttpClient();  
			HttpResponse response = null;
			
			if(user!=null && password!=null && hostname!=null) {
				initCredential((DefaultHttpClient)client, user, password, hostname);
				response = client.execute(post,localcontext);
			} else {
				response = client.execute(post);  
			}
			
			System.out.println("URL POST appellée : "+url+" ****** "+response.getStatusLine());
			//retrieve the output and display it in console
			logger.debug("URL POST appellée : "+url);
			updateLastStatusInformations(response.getStatusLine());
			logger.debug(response.getStatusLine());
			
			if(response!=null){
                InputStream in = response.getEntity().getContent();
                StringWriter writer = new StringWriter();
        		IOUtils.copy(in, writer, "UTF-8");
        		String res = writer.toString();
                return res;
			}

			client.getConnectionManager().shutdown();  
		} catch (Exception e) {
			logger.error("", e);
		}
		return null;
	}
	
	static public void delete(String url) {
		try {
			
			// prepare post method  
			HttpDelete delete = new HttpDelete(url);

			// create the client and execute the post method  
			HttpClient client = new DefaultHttpClient();  
			HttpResponse response = null;
			
			if(user!=null && password!=null && hostname!=null) {
				initCredential((DefaultHttpClient)client, user, password, hostname);
				response = client.execute(delete,localcontext);
			} else {
				response = client.execute(delete);  
			}

			System.out.println("URL DELETE appellée : "+url+" ****** "+response.getStatusLine());
			//retrieve the output and display it in console
			logger.debug("URL DELETE appellée : "+url);
			updateLastStatusInformations(response.getStatusLine());
			logger.debug(response.getStatusLine());

			client.getConnectionManager().shutdown();  
		} catch (Exception e) {
			logger.error("", e);
		}
	}
	
	public static String downloadFile(String url, String cheminFichierLocal) {
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet httpget = new HttpGet(url);
			HttpResponse response = httpclient.execute(httpget);
			System.out.println(response.getStatusLine());
			HttpEntity entity = response.getEntity();
			String filePath = null;
			if(cheminFichierLocal!=null) {
				filePath = cheminFichierLocal;
			} else {
				//créer le fichier dans /tmps
				String nomFichier = url.substring(url.lastIndexOf("/"));
				filePath = "/tmp/"+nomFichier;
				//géré tmp sur toutes les plateformes
			}
			
			if (entity != null) {
				InputStream instream = entity.getContent();
				try {
					BufferedInputStream bis = new BufferedInputStream(instream);

					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
					int inByte;
					while ((inByte = bis.read()) != -1 ) {
						bos.write(inByte);
					}
					bis.close();
					bos.close();
				} catch (IOException ex) {
					throw ex;
				} catch (RuntimeException ex) {
					httpget.abort();
					throw ex;
				} finally {
					instream.close();
				}
				httpclient.getConnectionManager().shutdown();
				return filePath;
			}
			return null;
		} catch(Exception e) {
			logger.error("", e);
			return null;
		}
		
	}

	public static void setUser(String user) {
		UtilHTTP.user = user;
	}

	public static void setPassword(String password) {
		UtilHTTP.password = password;
	}

	public static void setHostname(String hostname) {
		UtilHTTP.hostname = hostname;
	}

}
