package fr.legrain.lib.data;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

//import org.apache.commons.codec.binary.Base64;

public class LibCrypto {
	
	//OSS_REMOVE
	private static String key = "Bar12345Bar12345"; // 128 bit key
	private static String initVector = "RandomInitVector"; // 16 bytes IV
	private static String cypherParam = "AES/CBC/PKCS5PADDING"; 
//	private static String cypherParam = "AES/EBC/PKCS5"; 
//	private static String cypherParam = "AES/CBC/NoPadding"; 
	private static String characterEncoding = "UTF-8"; 
	private static String algo = "AES"; 
	
	public static String encrypt(String value) {
		return encrypt(key, initVector, value);
	}

	public static String encrypt(String key, String initVector, String value) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(characterEncoding));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(characterEncoding), algo);

			Cipher cipher = Cipher.getInstance(cypherParam);
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

			byte[] encrypted = cipher.doFinal(value.getBytes());
			
			// encode with padding JAVA 8
//			String encoded = Base64.getEncoder().encodeToString(someByteArray);
			// encode without padding JAVA 8
//			String encoded = Base64.getEncoder().withoutPadding().encodeToString(someByteArray);
			
			System.out.println("encrypted string: " + Base64.getEncoder().encodeToString(encrypted));
			return Base64.getEncoder().encodeToString(encrypted);

//			System.out.println("encrypted string: " + Base64.encodeBase64String(encrypted));
//			return Base64.encodeBase64String(encrypted);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public static String decrypt(String value) {
		return decrypt(key, initVector, value);
	}
	
	public static String decrypt(String key, String initVector, String encrypted) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(characterEncoding));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(characterEncoding), algo);

			Cipher cipher = Cipher.getInstance(cypherParam);
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

			// decode a String JAVA 8
//			byte [] barr = Base64.getDecoder().decode(encoded);
			
			byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));
			
//			byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

			return new String(original);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}
	
	public static void main(String[] args) {
		//OSS_REMOVE
		System.out.println("Test encrypt : "+encrypt("lgr82*serviceclient@legrain.fr*serviceclient@legrain.fr"));
		
		System.out.println("Test decrypt : "+decrypt("/vNNTnezsLjvWWgGWomkh9RnMEZ7/abqNgcSvQ5JR0+bU2gHtaf7MKXuHX3/G4fHMvFFoLYwCZOdg41jockMNw=="));
	}

}
