package fr.legrain.bdg.lib.osgi;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;



/**
 * <p>Title: Gestion Commerciale</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author Le Grain S.A
 * @version 1.0
 */
public class Const {
	/*
	public static String C_FICHIER_BDD = null;

	static { 
		System.out.println("C_FICHIER_BDD :");
		Properties fListeIDBD = new Properties();
		try {
			if (!new File("bd.properties").exists()) {
				System.out.println(new File(".").getCanonicalFile());
			} else {
				fListeIDBD.load(new FileInputStream("bd.properties"));
				C_FICHIER_BDD = fListeIDBD.getProperty("bd.fichier");
				System.out.println("C_FICHIER_BDD :"+C_FICHIER_BDD);
			}
		}
	catch(Exception e){
		e.printStackTrace();
	}
	}
	 */		

//ejb
//	static private IScopeContext projectScopeContext = null;
	static private String projectName = null;

	static final public String finDeLigne = "\r\n";
	
//ejb	
//	static final public String C_RCP_INSTANCE_LOCATION = Platform.getInstanceLocation().getURL().getFile(); //=Workspace
//	static final public String C_RCP_INSTALL_LOCATION  = Platform.getInstallLocation().getURL().getFile();
//	static final public String C_RCP_USER_LOCATION     = Platform.getUserLocation().getURL().getFile();

	////CHEMIN ABSOLU
	//Connection base de données
	// public static String C_REPERTOIRE_BASE = "C:\Projet\Java\Eclipse\GestionCommerciale\@Run\lgrWorkspace\dossier\Bd";
	// public static String C_REPERTOIRE_BASE = "C:/Projet/Java/Eclipse/GestionCommerciale/GestionCommerciale/Bd";
	public static boolean C_REPERTOIRE_PROJET_IN_WORKSPACE = true;
	public static String C_REPERTOIRE_PROJET = "";
//ejb
//	public static String C_REPERTOIRE_BASE   = C_RCP_INSTANCE_LOCATION;
	public static String C_NOM_PROJET_TMP   = "tmp";

//ejb
//	public static String C_FICHIER_GESTCODE 	  = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/GestCode.properties";
//	public static String C_FICHIER_INI_CTRL       = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/CtrlBD.ini";
//	public static String C_FICHIER_INI_IDBD       = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/IDBD.ini";
//	public static String C_FICHIER_BDD            = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/GEST_COM.FDB";
//	public static String C_FICHIER_LISTE_TITRE_BD = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/TitreBD2.lst";
//	public static String C_FICHIER_CONF_LOG4J     = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/log4j.properties"; //log
//	public static String C_FICHIER_MODIF     	  = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/Modif.properties"; //log
//	public static String C_FICHIER_INI_CHAMPMAJ   = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/ChampMaj.ini";
//	public static String C_FICHIER_INI_TOUTVENANT   = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/ToutVenant.ini";
//	public static String C_FICHIER_LISTE_CHAMP_GRILLE   = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/ListeChampGrille.properties";
//	public static String C_FICHIER_LISTE_ATTRIBUTE_EDITION   = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/AttributeTableEdition.properties";
//	public static String C_FICHIER_LISTE_ATTRIBUTE_LETTRE   = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/AttributeModelLettre.properties";
//	public static String C_FICHIER_LISTE_ATTRIBUTE_ETIQUETTE   = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/AttributeEtiquette.properties";
//	public static String C_FICHIER_PREFERENCE_PAGE   = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/PreferencePage.properties";
//	public static String C_FICHIER_PREFERENCE_PAGE_FTP   = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/sauvegardeFTP.properties";
	public static String C_SERVEUR_BDD = "localhost";
	public static final String PLUGIN_EDITIONSPECIFIQUES = "EditionsSpecifiques";
	public static final String FOLDER_EDITION = "Editions";
	public static final String FOLDER_EDITION_SUPP = "EditionsSupp";
	public static final String FOLDER_EDITION_CLIENT = "EditionsClient";
	public static final String FOLDER_IMAGES_EDITIONS = "Images";
	public static final String FOLDER_IMAGES = "images";
	public static final String FOLDER_IMAGES_ARTICLES = "images_articles";
	public static final String FOLDER_IMAGES_CATEGORIES = "images_catégories";
	public static final String FOLDER_IMAGES_LABELS = "images_labels";
//ejb
//	public static final String C_CHEMIN_REP_TMP_COMPLET=C_REPERTOIRE_BASE+"/"+C_NOM_PROJET_TMP;
	
	public static final String RECHARGE_ADR_FACT="recharger Adresse facturation";
	public static final String RECHARGE_ADR_LIV="recharger Adresse livraison";
	public static final String RECHARGE_C_PAIEMENT="recharger condition paiement";
	public static final String RECHARGE_INFOS_TIERS="recharger infos tiers";
	
	
	public static String C_CHEMIN_REP_DOSSIER_COMPLET="";
	/**
	 * constants pour ModelLettre 
	 */
	public static final String FOLDER_MODEL_LETTRE= "ModelLettre";
	public static final String MODEL_LETTRE_OO= "OO";
	public static final String MODEL_LETTRE_WO= "WO";
	public static final String FOLDER_PARAM_LETTRE_OO = "paramModelLettreOO";
	public static final String FOLDER_PARAM_LETTRE_WO = "paramModelLettreWO";
	public static String PATH_FOLDER_MODEL_LETTRE_DOSSIER = null;
	
	/**
	 * Constants pour parametre etiquette
	 */
	public static final String FOLDER_PARAMETRES_ETIQUETTE = "parametresEtiquette";
	public static final String FOLDER_PARAMETRES_ETIQUETTE_TIERS = "tiers";
	public static final String FOLDER_PARAMETRES_ETIQUETTE_ARTICLE = "article";
	public static String PATH_FOLDER_PARAMETRES_ETIQUETTE = "";
	public static String PATH_FOLDER_EDITION_SUPP = "";
	public static String PATH_FOLDER_DOSSIER = "";
	
//	// à enlever, juste pour tester la saisie en réseau
//	public static String C_FICHIER_BDD            = "C:/Projet/Java/Eclipse/GestionCommerciale/@Run/lgrWorkspace/dossier/Bd/GEST_COM.FDB";
//	public static String C_FICHIER_MODIF     	  = "C:/Projet/Java/Eclipse/GestionCommerciale/@Run/lgrWorkspace/dossier/Bd/Modif.properties"; //log
	private static Properties FichierCheminIni;
	private static Properties FichierToutVenant;

	public static void setFichierCheminIni(String value) {  
//ejb
//		try {
//			if (new File(value).exists()) {	
//				FileInputStream file = new FileInputStream(value);
//				if (FichierCheminIni==null)FichierCheminIni=new Properties();
//				if (FichierCheminIni.isEmpty())
//					FichierCheminIni.load(file);
//				file.close();
//				if (!FichierCheminIni.isEmpty()){
//					Iterator iteNomFichier = FichierCheminIni.keySet().iterator();
//					String cle = null;
//					while (iteNomFichier.hasNext()) { //(int i = 0; i<FListeChampValue.size(); i++) { // i: = 0 to FListeChampValue.Count - 1 {
//						//"transfert des données de l'objet vers le DataSet"
//						cle=((String)iteNomFichier.next());
//						if (cle.equals("C_FICHIER_GESTCODE"))
//							C_FICHIER_GESTCODE=((String)FichierCheminIni.get(cle));
//						if (cle.equals("C_FICHIER_INI_CTRL"))
//							C_FICHIER_INI_CTRL=((String)FichierCheminIni.get(cle));
//						if (cle.equals("C_FICHIER_INI_IDBD"))
//							C_FICHIER_INI_IDBD=((String)FichierCheminIni.get(cle));
//						if (cle.equals("C_FICHIER_BDD"))
//							C_FICHIER_BDD=((String)FichierCheminIni.get(cle));
//						if (cle.equals("C_FICHIER_LISTE_TITRE_BD"))
//							C_FICHIER_LISTE_TITRE_BD=((String)FichierCheminIni.get(cle));
//						if (cle.equals("C_FICHIER_CONF_LOG4J"))
//							C_FICHIER_CONF_LOG4J=((String)FichierCheminIni.get(cle));
//						if (cle.equals("C_FICHIER_MODIF"))
//							C_FICHIER_MODIF=((String)FichierCheminIni.get(cle));
//						if (cle.equals("C_FICHIER_INI_CHAMPMAJ"))
//							C_FICHIER_INI_CHAMPMAJ=((String)FichierCheminIni.get(cle));
//					}
//				}
//			}
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	public static void setFichierToutVenant(String value) {  
		try {
			if (new File(value).exists()) {
				FileInputStream file = new FileInputStream(value);
				if (FichierToutVenant==null)FichierToutVenant=new Properties();
				if (FichierToutVenant.isEmpty())
					FichierToutVenant.load(file);
				file.close();
				if (!FichierToutVenant.isEmpty()){
					Iterator iteNomFichier = FichierToutVenant.keySet().iterator();
					String cle = null;
					while (iteNomFichier.hasNext()) { //
						cle=((String)iteNomFichier.next());
						if (cle.equals("C_CPT_ESCOMPTE_DEBIT"))
							C_CPT_ESCOMPTE_DEBIT=((String)FichierToutVenant.get(cle));
						if (cle.equals("C_CPT_ESCOMPTE_CREDIT"))
							C_CPT_ESCOMPTE_CREDIT=((String)FichierToutVenant.get(cle));
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updatePath() {
//ejb
//		if(C_REPERTOIRE_PROJET_IN_WORKSPACE) {
//			C_CHEMIN_REP_DOSSIER_COMPLET = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET;
//			C_FICHIER_GESTCODE 		   = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/Bd/GestCode.properties";
//			C_FICHIER_INI_CTRL         = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/Bd/CtrlBD.ini";
//			C_FICHIER_INI_IDBD         = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/Bd/IDBD.ini";
//			C_FICHIER_BDD              = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/Bd/GEST_COM.FDB";
//			C_FICHIER_LISTE_TITRE_BD   = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/Bd/TitreBD2.lst";
//			C_FICHIER_CONF_LOG4J = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/Bd/log4j.properties";
//			C_FICHIER_MODIF = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/Bd/Modif.properties";
//			C_FICHIER_INI_CHAMPMAJ         = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/Bd/ChampMaj.ini";
//			C_FICHIER_INI_TOUTVENANT   = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/Bd/ToutVenant.ini";
//			C_FICHIER_LISTE_CHAMP_GRILLE   = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/Bd/ListeChampGrille.properties";
//			C_FICHIER_LISTE_ATTRIBUTE_EDITION   = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/Bd/AttributeTableEdition.properties";
//			C_FICHIER_LISTE_ATTRIBUTE_LETTRE   = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/Bd/AttributeModelLettre.properties";
//			C_FICHIER_LISTE_ATTRIBUTE_ETIQUETTE = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/Bd/AttributeEtiquette.properties";
//			C_FICHIER_PREFERENCE_PAGE   = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/Bd/PreferencePage.properties";
//			C_FICHIER_PREFERENCE_PAGE_FTP   = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/Bd/sauvegardeFTP.properties";
//			PATH_FOLDER_MODEL_LETTRE_DOSSIER = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/"+FOLDER_MODEL_LETTRE;
//			PATH_FOLDER_PARAMETRES_ETIQUETTE = C_REPERTOIRE_BASE+C_REPERTOIRE_PROJET+"/"+FOLDER_PARAMETRES_ETIQUETTE;
//			PATH_FOLDER_EDITION_SUPP = Const.C_REPERTOIRE_BASE+Const.C_REPERTOIRE_PROJET+"/"+Const.FOLDER_EDITION_SUPP;
//			
//		} else {
//			C_CHEMIN_REP_DOSSIER_COMPLET = C_REPERTOIRE_PROJET;
//			C_FICHIER_GESTCODE 		   = C_REPERTOIRE_PROJET+"/Bd/GestCode.properties";
//			C_FICHIER_INI_CTRL         = C_REPERTOIRE_PROJET+"/Bd/CtrlBD.ini";
//			C_FICHIER_INI_IDBD         = C_REPERTOIRE_PROJET+"/Bd/IDBD.ini";
//			C_FICHIER_BDD              = C_REPERTOIRE_PROJET+"/Bd/GEST_COM.FDB";
//			C_FICHIER_LISTE_TITRE_BD   = C_REPERTOIRE_PROJET+"/Bd/TitreBD2.lst";
//			C_FICHIER_CONF_LOG4J = C_REPERTOIRE_PROJET+"/Bd/log4j.properties"; //log
//			C_FICHIER_MODIF = C_REPERTOIRE_PROJET+"/Bd/Modif.properties";
//			C_FICHIER_INI_CHAMPMAJ         = C_REPERTOIRE_PROJET+"/Bd/ChampMaj.ini";
//			C_FICHIER_INI_TOUTVENANT	= C_REPERTOIRE_PROJET+"/Bd/ToutVenant.ini";
//			C_FICHIER_LISTE_CHAMP_GRILLE   = C_REPERTOIRE_PROJET+"/Bd/ListeChampGrille.properties";
//			C_FICHIER_LISTE_ATTRIBUTE_EDITION   = C_REPERTOIRE_PROJET+"/Bd/AttributeTableEdition.properties";
//			C_FICHIER_LISTE_ATTRIBUTE_LETTRE   = C_REPERTOIRE_PROJET+"/Bd/AttributeModelLettre.properties";
//			C_FICHIER_LISTE_ATTRIBUTE_ETIQUETTE = C_REPERTOIRE_PROJET+"/Bd/AttributeEtiquette.properties";
//			C_FICHIER_PREFERENCE_PAGE   = C_REPERTOIRE_PROJET+"/Bd/PreferencePage.properties";
//			C_FICHIER_PREFERENCE_PAGE_FTP   = C_REPERTOIRE_PROJET+"/Bd/sauvegardeFTP.properties";
//			PATH_FOLDER_MODEL_LETTRE_DOSSIER = C_REPERTOIRE_PROJET+"/"+FOLDER_MODEL_LETTRE;
//			PATH_FOLDER_PARAMETRES_ETIQUETTE = C_REPERTOIRE_PROJET+"/"+FOLDER_PARAMETRES_ETIQUETTE;
//			PATH_FOLDER_EDITION_SUPP = Const.C_REPERTOIRE_PROJET+"/"+Const.FOLDER_EDITION_SUPP;
//			
//		}
	}

//	//CHEMIN RELATIF
//	//Connection base de données
//	public static String C_FICHIER_INI_CTRL = "./Bd/CtrlBD.ini";
//	public static String C_FICHIER_INI_IDBD = "./Bd/IDBD.ini";
//	public static String C_FICHIER_BDD            = "./Bd/GEST_COM.FDB";
//	public static String C_FICHIER_LISTE_TITRE_BD = "./Bd/TitreBD2.lst";
//	public static String C_REPERTOIRE_BASE = ".";
//	public final static String C_FICHIER_CONF_LOG4J = "./Bd/log4j.properties"; //log

//	public static final String C_URL_BDD          = "jdbc:firebirdsql://localhost/";
	public static final String C_URL_BDD          = "jdbc:firebirdsql:";
//	public static final String C_URL_BDD          = "jdbc:firebirdsql://192.168.0.6/";
//	public static final String C_USER             = "SYSDBA";
	public static final String C_USER             = "###_LOGIN_FB_BDG_###";
	public static final String C_PASS             = "###_PASSWORD_FB_BDG_###";
//	public static final String C_PASS             = "masterkey";
	public static final String C_DRIVER_JDBC      = "org.firebirdsql.jdbc.FBDriver";

	public static final Integer C_NB_CHAR_LIBELLE_FAMILLE_CHART = 20;

	/**
	 * Spécifique aux messages d'erreurs pour débuggage
	 */
	public static final String C_A_IMPLEMENTER = "Non implémenté";
	public static final String C_ERR_TITRE_GRILLE_INCOMPLET = "Titre grille incomplet !!!";


	/**
	 * Spécifique aux tables de la base 
	 * Début Requete général
	 */  
	public static final String C_Debut_Requete = "select * from ";
	public static final String C_Ip_Acces = "IP_ACCES";

	public static final int C_LOCATE_OPTION_BORLAND_FIRST = 32;
	
	public static final String C_ID_DTO_GENERAL   = "id";

	//TA_TIERS
	public static final String C_NOM_TA_TIERS = "TA_TIERS";
	public static final String C_NOM_VU_TIERS = "V_TIERS";
	public static final String C_NOM_VU_TIERS_COMMERCIAL = "V_TIERS_COMMERCIAL";
	public static final String C_NOM_VU_COMMERCIAL = "V_COMMERCIAL";
	public static final String C_NOM_P_TIERS = "P_TIERS";
//	public static final String C_ID_TIERS     = "ID_TIERS";
//	public static final String C_CODE_COMPTA   = "CODE_COMPTA";
//	public static final String C_CODE_TIERS   = "CODE_TIERS";
//	public static final String C_COMPTE   = "COMPTE";
//	public static final String C_NOM_TIERS   = "NOM_TIERS";
//	public static final String C_PRENOM_TIERS   = "PRENOM_TIERS";
//	public static final String C_SURNOM_TIERS   = "SURNOM_TIERS";
//	public static final String C_ACTIF_TIERS   = "ACTIF_TIERS";
//	public static final String C_TTC_TIERS   = "TTC_TIERS";
//	public static final String C_ID_I_COMMENTAIRE   = "ID_I_COMMENTAIRE";
//	public static final String C_ID_I_BANQUE   = "ID_I_BANQUE";
//	public static final String C_COMMERCIAL   = "COMMERCIAL";
	public static final String C_ID_TIERS     = "idTiers";
	public static final String C_CODE_COMPTA   = "codeCompta";
	public static final String C_CODE_TIERS   = "codeTiers";
	public static final String C_CODE_TIERS_PRESTATION   = "codeTiersPrestation";
	public static final String C_COMPTE   = "compte";
	public static final String C_NOM_TIERS   = "nomTiers";
	public static final String C_PRENOM_TIERS   = "prenomTiers";
	public static final String C_DATE_ANNIV = "dateAnniv";
	public static final String C_SURNOM_TIERS   = "surnomTiers";
	public static final String C_ACTIF_TIERS   = "actifTiers";
	public static final String C_TTC_TIERS   = "ttcTiers";
	//public static final String C_ID_I_COMMENTAIRE   = "ID_I_COMMENTAIRE";
	public static final String C_ID_I_BANQUE   = "taBanque";
	//public static final String C_COMMERCIAL   = "COMMERCIAL";
	public static final String C_TVA = "tva";
	public static final String C_ID_T_TVA_DOC   = "idTTvaDoc";
	public static final String C_CODE_T_TVA_DOC   = "codeTTvaDoc";
	public static final String C_COMPTE_T_TVA_DOC   = "journalTTvaDoc";
	public static final String C_LIBELLE_T_TVA_DOC   = "libelleTTvaDoc";
	
	//C_NOM_TA_T_TVA
	public static final String C_NOM_TA_T_TVA = "TA_T_TVA";
	public static final String C_NOM_VU_T_TVA = "V_T_TVA";
//	public static final String C_ID_T_TVA     = "ID_T_TVA";
//	public static final String C_CODE_T_TVA   = "CODE_T_TVA";
//	public static final String C_LIB_T_TVA   = "LIB_T_TVA";
	public static final String C_ID_T_TVA     = "idTTva";
	public static final String C_CODE_T_TVA   = "codeTTva";
	public static final String C_LIB_T_TVA   = "libTTva";
	
	//C_NOM_TA_CHAMP_SUPP_ART
	public static final String C_NOM_TA_CHAMP_SUPP_ART 			= "TA_CHAMP_SUPP_ART";
	public static final String C_ID_CHAMP_SUPP_ART     			= "idChampSuppArt";
	public static final String C_NOM_CHAMP_SUPP_ART   			= "nomChampSuppArt";
	public static final String C_TYPE_VALEUR_CHAMP_SUPP_ART   	= "typeValeurChampSuppArt";
	public static final String C_DESCRIPTION_CHAMP_SUPP_ART   	= "descriptionChampSuppArt";
	public static final String C_DEFAUT_CHAMP_SUPP_ART   		= "defautChampSuppArt";

	//C_NOM_TA_REF_PRIX
	public static final String C_NOM_TA_REF_PRIX = "TA_REF_PRIX";
	public static final String C_NOM_VU_REF_PRIX = "V_REF_PRIX";
//	public static final String C_ID_REF_PRIX     = "ID_REF_PRIX";
	public static final String C_ID_REF_PRIX     = "idRefPrix";

	//C_NOM_TA_COMPL
	public static final String C_NOM_TA_COMPL = "TA_COMPL";
	public static final String C_NOM_VU_COMPL = "V_COMPL";
	public static final String C_ID_COMPL     = "idCompl";
	public static final String C_TVA_I_COM_COMPL   = "tvaIComCompl";
	public static final String C_SIRET_COMPL   = "siretCompl";
	public static final String C_ACCISE   = "accise";
	public static final String C_NUM_AGREMENT_SANITAIRE = "numAgrementSanitaire";

	//TA_Civilite
	public static final String C_NOM_TA_T_CIVILITE = "TA_T_CIVILITE";
	public static final String C_NOM_VU_T_CIVILITE = "V_T_CIVILITE";
//	public static final String C_ID_T_CIVILITE     = "ID_T_CIVILITE";
//	public static final String C_CODE_T_CIVILITE   = "CODE_T_CIVILITE";
	public static final String C_ID_T_CIVILITE     = "idTCivilite";
	public static final String C_CODE_T_CIVILITE   = "codeTCivilite";
	
	//TA_T_LIENS
	public static final String C_NOM_TA_T_LIENS = "TA_T_LIENS";
	//public static final String C_NOM_VU_T_LIENS = "V_T_LIENS";
	public static final String C_ID_T_LIENS     = "idTLiens";
	public static final String C_CODE_T_LIENS   = "codeTLiens";
	public static final String C_LIBL_T_LIENS   = "liblTLiens";
	
	//TA_T_RELANCE
	public static final String C_ID_T_RELANCE     = "idTRelance";
	public static final String C_CODE_T_RELANCE   = "codeTRelance";
	public static final String C_ORDRE_T_RELANCE   = "ordreTRelance";
	public static final String C_ACTIF   = "actif";
	public static final String C_LIBELLE_T_RELANCE   = "libelleTRelance";
	public static final String C_CHEMIN_MODEL_RELANCE   = "cheminModelRelance";
	public static final String C_CHEMIN_CORRESP_RELANCE   = "cheminCorrespRelance";
	public static final String C_ACCEPTE = "accepte";
	
	//TA_DOCUMENT_TIERS
	public static final String C_ID_DOCUMENT_TIERS     = "idDocumentTiers";
	public static final String C_CODE_DOCUMENT_TIERS   = "codeDocumentTiers";
	public static final String C_ACTIF_DOCUMENT_TIERS   = "actif";
	public static final String C_LIBELLE_DOCUMENT_TIERS   = "libelleDocumentTiers";
	public static final String C_CHEMIN_MODEL_DOCUMENT_TIERS   = "cheminModelDocumentTiers";
	public static final String C_CHEMIN_CORRESP_DOCUMENT_TIERS   = "cheminCorrespDocumentTiers";
	public static final String C_ACCEPTE_DOCUMENT_TIERS = "accepte";
	
	//TA_DOCUMENT_DOC
	public static final String C_ID_DOCUMENT_DOC     = "idDocumentDoc";
	public static final String C_CODE_DOCUMENT_DOC   = "codeDocumentDoc";
	public static final String C_ACTIF_DOCUMENT_DOC   = "actif";
	public static final String C_LIBELLE_DOCUMENT_DOC   = "libelleDocumentDoc";
	public static final String C_CHEMIN_MODEL_DOCUMENT_DOC   = "cheminModelDocumentDoc";
	public static final String C_CHEMIN_CORRESP_DOCUMENT_DOC   = "cheminCorrespDocumentDoc";
	public static final String C_DEFAUT_DOCUMENT_DOC = "defaut";
	public static final String C_NUMERO_COMMANDE_FOURNISSEUR = "numeroCommandeFournisseur";
	public static final String C_GESTION_LOT = "gestionLot";
	
	//TA_RELANCE
	public static final String C_DATE_DEBUT   = "dateDebut";
	public static final String C_CODE_RELANCE   = "codeRelance";
	public static final String C_LIMITE = "limite";
	
	
	public static final String C_CODE_REMISE   = "codeRemise";
	
	//TA_T_TIERS
	public static final String C_NOM_TA_T_TIERS = "TA_T_TIERS";
	public static final String C_NOM_VU_T_TIERS = "V_T_TIERS";
//	public static final String C_ID_T_TIERS          = "ID_T_TIERS";
//	public static final String C_CODE_T_TIERS        = "CODE_T_TIERS";
//	public static final String C_LIBELLE_T_TIERS        = "LIBELLE_T_TIERS";
//	public static final String C_COMPTE_T_TIERS        = "COMPTE_T_TIERS";
	public static final String C_ID_T_TIERS          = "idTTiers";
	public static final String C_CODE_T_TIERS        = "codeTTiers";
	public static final String C_LIBELLE_T_TIERS        = "libelleTTiers";
	public static final String C_COMPTE_T_TIERS        = "compteTTiers";
	
	
	//TA_T_TARIF
	public static final String C_NOM_TA_T_TARIF = "TA_T_TARIF";
	public static final String C_ID_T_TARIF          = "idTTarif";
	public static final String C_CODE_T_TARIF        = "codeTTarif";
	public static final String C_CODE_T_TARIF_REMPLACEMENT        = "codeTTarifRemplacement";
	public static final String C_LIBL_T_TARIF        = "liblTTarif";
	
	//TA_T_EMAIL
	public static final String C_NOM_TA_T_EMAIL = "TA_T_EMAIL";
	public static final String C_NOM_VU_T_EMAIL = "V_T_EMAIL";
	public static final String C_ID_T_EMAIL          = "idTEmail";
	public static final String C_CODE_T_EMAIL        = "codeTEmail";
	public static final String C_LIBL_T_EMAIL        = "liblTEmail";

	//TA_T_WEB
	public static final String C_NOM_TA_T_WEB  = "TA_T_WEB";
//	public static final String C_ID_T_ENTITE      = "ID_T_ENTITE";
//	public static final String C_CODE_T_ENTITE    = "CODE_T_ENTITE";
//	public static final String C_LIBL_T_ENTITE    = "LIBL_T_ENTITE";
	public static final String C_ID_T_WEB      = "idTWeb";
	public static final String C_CODE_T_WEB    = "codeTWeb";
	public static final String C_LIBL_T_WEB    = "liblTWeb";
	
	//TA_T_NOTE_TIERS
	public static final String C_NOM_TA_T_NOTE_TIERS  = "TA_T_NOTE_TIERS";
	public static final String C_NOM_VU_T_NOTE_TIERS  = "V_T_NOTE_TIERS";
	public static final String C_ID_T_NOTE_TIERS      = "idTNoteTiers";
	public static final String C_CODE_T_NOTE_TIERS    = "codeTNoteTiers";
	public static final String C_LIBL_T_NOTE_TIERS    = "liblTNoteTiers";
	
	//TA_T_NOTE_ARTICLE
	public static final String C_NOM_TA_T_NOTE_ARTICLE  = "TA_T_NOTE_ARTICLE";
	public static final String C_NOM_VU_T_NOTE_ARTICLE  = "V_T_NOTE_ARTICLE";
	public static final String C_ID_T_NOTE_ARTICLE     = "idTNoteArticle";
	public static final String C_CODE_T_NOTE_ARTICLE    = "codeTNoteArticle";
	public static final String C_LIBL_T_NOTE_ARTICLE    = "liblTNoteArticle";
	
	//TA_T_NOTE_ARTICLE
	public static final String C_NOM_TA_TITRE_TRANSPORT  = "TA_TITRE_TRANSPORT";
	public static final String C_NOM_VU_TITRE_TRANSPORT  = "V_TITRE_TRANSPORT";
	public static final String C_ID_TITRE_TRANSPORT      = "idTitreTransport";
	public static final String C_CODE_TITRE_TRANSPORT    = "codeTitreTransport";
	public static final String C_LIBELLE_TITRE_TRANSPORT = "libelleTitreTransport";
	public static final String C_QTE_MIN_TITRE_TRANSPORT = "qteMinTitreTransport";
	
	//TA_T_ENTITE
	public static final String C_NOM_TA_T_ENTITE  = "TA_T_ENTITE";
	public static final String C_NOM_VU_T_ENTITE  = "V_T_ENTITE";
//	public static final String C_ID_T_ENTITE      = "ID_T_ENTITE";
//	public static final String C_CODE_T_ENTITE    = "CODE_T_ENTITE";
//	public static final String C_LIBL_T_ENTITE    = "LIBL_T_ENTITE";
	public static final String C_ID_T_ENTITE      = "idTEntite";
	public static final String C_CODE_T_ENTITE    = "codeTEntite";
	public static final String C_LIBL_T_ENTITE    = "liblTEntite";

	//TA_ENTREPRISE
	public static final String C_NOM_TA_ENTREPRISE  = "TA_ENTREPRISE";
	public static final String C_NOM_VU_ENTREPRISE  = "V_ENTREPRISE";
//	public static final String C_ID_ENTREPRISE      = "ID_ENTREPRISE";
//	public static final String C_CODE_ENTREPRISE    = "CODE_ENTREPRISE";
//	public static final String C_LIBL_ENTREPRISE    = "LIBL_ENTREPRISE";
//	public static final String C_CODE_T_ENTITE_ENTREPRISE    = "CODE_T_ENTITE_ENTREPRISE";
//	public static final String C_ID_I_RESP_TIERS  = "ID_I_RESP_TIERS";
	public static final String C_ID_ENTREPRISE      = "idEntreprise";
	public static final String C_NOM_ENTREPRISE    = "nomEntreprise";
	public static final String C_LIBL_ENTREPRISE    = "liblEntreprise";
	
//	public static final String C_CODE_T_ENTITE_ENTREPRISE    = "taTEntite";
	//public static final String C_ID_I_RESP_TIERS  = "idIRespTiers";

	//TA_COMMENTAIRE
	public static final String C_NOM_TA_COMMENTAIRE = "TA_COMMENTAIRE";
	public static final String C_NOM_VU_COMMENTAIRE = "V_COMMENTAIRE";
//	public static final String C_ID_COMMENTAIRE     = "ID_COMMENTAIRE";
//	public static final String C_LIBL_COMMENTAIRE   = "LIBL_COMMENTAIRE";
	public static final String C_ID_COMMENTAIRE     = "idCommentaire";
	public static final String C_LIBL_COMMENTAIRE   = "commentaire";

	//TA_BANQUE
	public static final String C_NOM_TA_BANQUE = "TA_COMPTE_BANQUE";
	public static final String C_NOM_VU_BANQUE = "V_BANQUE";
//	public static final String C_ID_BANQUE     = "ID_BANQUE";
//	public static final String C_CODE_BANQUE   = "CODE_BANQUE";
//	public static final String C_LIBC_BANQUE   = "LIBC_BANQUE";
//	public static final String C_LIBL_BANQUE   = "LIBL_BANQUE";
	public static final String C_ID_COMPTE_BANQUE     = "idCompteBanque";
	public static final String C_NOM_BANQUE   = "nomBanque";
	public static final String C_COMPTE_BANQUE   = "compte";
	public static final String C_CODE_BANQUE   = "codeBanque";
	public static final String C_CODE_GUICHET_BANQUE   = "codeGuichet";
	public static final String C_CLE_RIB_BANQUE   = "cleRib";
	public static final String C_ADRESSE1_BANQUE   = "adresse1Banque";
	public static final String C_ADRESSE2_BANQUE   = "adresse2Banque";
	public static final String C_CP_BANQUE   = "cpBanque";
	public static final String C_VILLE_BANQUE   = "villeBanque";
	public static final String C_IBAN_BANQUE   = "iban";
	public static final String C_CODE_B_I_C_BANQUE   = "codeBIC";
	public static final String C_TITULAIRE_BANQUE   = "titulaire"; 
	

	//TA_ADRESSE
	public static final String C_NOM_TA_ADRESSE = "TA_ADRESSE";
	public static final String C_NOM_VU_ADRESSE = "V_ADRESSE";
//	public static final String C_ID_ADRESSE     = "ID_ADRESSE";
//	public static final String C_ADRESSE1_ADRESSE   = "ADRESSE1_ADRESSE";
//	public static final String C_ADRESSE2_ADRESSE   = "ADRESSE2_ADRESSE";
//	public static final String C_ADRESSE3_ADRESSE   = "ADRESSE3_ADRESSE";
//	public static final String C_CODEPOSTAL_ADRESSE   = "CODEPOSTAL_ADRESSE";
//	public static final String C_VILLE_ADRESSE   = "VILLE_ADRESSE";
//	public static final String C_PAYS_ADRESSE   = "PAYS_ADRESSE";
	public static final String C_ID_ADRESSE     = "idAdresse";
	public static final String C_ADRESSE1_ADRESSE   = "adresse1Adresse";
	public static final String C_ADRESSE2_ADRESSE   = "adresse2Adresse";
	public static final String C_ADRESSE3_ADRESSE   = "adresse3Adresse";
	public static final String C_CODEPOSTAL_ADRESSE   = "codepostalAdresse";
	public static final String C_VILLE_ADRESSE   = "villeAdresse";
	public static final String C_PAYS_ADRESSE   = "paysAdresse";

	//TA_R_ADR
	public static final String C_NOM_TA_R_ADR = "TA_R_ADR";
	public static final String C_NOM_VU_R_ADR = "V_R_ADR";
	//public static final String C_ID_R_ADR     = "ID_R_ADR";
	public static final String C_ID_R_ADR     = "idRAdr";

	//TA_T_ADR
	public static final String C_NOM_TA_T_ADR = "TA_T_ADR";
	public static final String C_NOM_VU_T_ADR = "V_T_ADR";
//	public static final String C_ID_T_ADR     = "ID_T_ADR";
//	public static final String C_CODE_T_ADR   = "CODE_T_ADR";
//	public static final String C_LIBL_T_ADR   = "LIBL_T_ADR";
	public static final String C_ID_T_ADR     = "idTAdr";
	public static final String C_CODE_T_ADR   = "codeTAdr";
	public static final String C_LIBL_T_ADR   = "liblTAdr";

	//TA_T_BANQUE
	public static final String C_NOM_TA_T_BANQUE = "TA_T_BANQUE";
	public static final String C_NOM_VU_T_BANQUE = "V_T_BANQUE";
	public static final String C_ID_T_BANQUE     = "idTBanque";
	public static final String C_CODE_T_BANQUE   = "codeTBanque";
	public static final String C_LIBL_T_BANQUE   = "liblTBanque";
	public static final String C_CPTCOMPTABLE   = "cptcomptable";
	
	
	//TA_R_ADR_T_ADR
	public static final String C_NOM_TA_R_ADR_T_ADR = "TA_R_ADR_T_ADR";
	public static final String C_NOM_VU_R_ADR_T_ADR = "V_R_ADR_T_ADR";
	//public static final String C_ID_R_ADR_T_ADR     = "ID_R_ADR_T_ADR";
	public static final String C_ID_R_ADR_T_ADR     = "idRAdrTAdr";

	//TA_TELEPHONE
	public static final String C_NOM_TA_TELEPHONE = "TA_TELEPHONE";
	public static final String C_NOM_VU_TELEPHONE = "V_TELEPHONE";
//	public static final String C_ID_TELEPHONE     = "ID_TELEPHONE";
//	public static final String C_NUMERO_TELEPHONE   = "NUMERO_TELEPHONE";
//	public static final String C_POSTE_TELEPHONE   = "POSTE_TELEPHONE";
//	public static final String C_ID_I_TIERS   = "ID_I_TIERS";
	public static final String C_ID_TELEPHONE     = "idTelephone";
	public static final String C_NUMERO_TELEPHONE   = "numeroTelephone";
	public static final String C_POSTE_TELEPHONE   = "posteTelephone";
	public static final String C_ID_I_TIERS   = "taTiers";
	public static final String C_CONTACT   = "contact";
	public static final String C_COMM_ADMINISTRATIF_TELEPHONE   = "commAdministratifTelephone";
	public static final String C_COMM_COMMERCIAL_TELEPHONE   = "commCommercialTelephone";

	//TA_R_TEL
	public static final String C_NOM_TA_R_TEL = "TA_R_TEL";
	public static final String C_NOM_VU_R_TEL = "V_R_TEL";
	//public static final String C_ID_R_TEL     = "ID_R_TEL";
	public static final String C_ID_R_TEL     = "idRTel";

	public static final String C_NOM_VU_COND_PAIE = "V_C_PAIE";
	//TA_T_TEL
	public static final String C_NOM_TA_T_TEL = "TA_T_TEL";
	public static final String C_NOM_VU_T_TEL = "V_T_TEL";
//	public static final String C_ID_T_TEL     = "ID_T_TEL";
//	public static final String C_CODE_T_TEL   = "CODE_T_TEL";
//	public static final String C_LIBL_T_TEL   = "LIBL_T_TEL";
	public static final String C_ID_T_TEL     = "idTTel";
	public static final String C_CODE_T_TEL   = "codeTTel";
	public static final String C_LIBL_T_TEL   = "liblTTel";
	//TA_T_WEB
	public static final String C_NOM_VU_T_WEB = "V_T_WEB";
	
	public static final String C_NOM_VU_T_TARIF = "V_T_TARIF";
	
	
	//TA_R_TEL_T_TEL
	public static final String C_NOM_TA_R_TEL_T_TEL = "TA_R_TEL_T_TEL";
	public static final String C_NOM_VU_R_TEL_T_TEL = "V_R_TEL_T_TEL";
	//public static final String C_ID_R_TEL_T_TEL     = "ID_R_TEL_T_TEL";
	public static final String C_ID_R_TEL_T_TEL     = "idRTelTTel";

	//TA_EMAIL
	public static final String C_NOM_TA_EMAIL = "TA_EMAIL";
	public static final String C_NOM_VU_EMAIL = "V_EMAIL";
//	public static final String C_ID_EMAIL     = "ID_EMAIL";
//	public static final String C_ADRESSE_EMAIL   = "ADRESSE_EMAIL";
	public static final String C_ID_EMAIL     = "idEmail";
	public static final String C_ADRESSE_EMAIL   = "adresseEmail";
	public static final String C_COMM_ADMINISTRATIF_EMAIL   = "commAdministratifEmail";
	public static final String C_COMM_COMMERCIAL_EMAIL   = "commCommercialEmail";

	//TA_LIENS
	public static final String C_NOM_TA_LIENS = "TA_LIENS";
	public static final String C_NOM_VU_LIENS = "V_LIENS";
//	public static final String C_ID_LIENS     = "ID_LIENS";
//	public static final String C_ADRESSE_LIENS   = "ADRESSE_LIENS";
	public static final String C_ID_LIENS     = "idLiens";
	public static final String C_ADRESSE_LIENS   = "adresseLiens";

	//TA_R_EMAIL
	public static final String C_NOM_TA_R_EMAIL = "TA_R_EMAIL";
	public static final String C_NOM_VU_R_EMAIL = "V_R_EMAIL";
	//public static final String C_ID_R_EMAIL     = "ID_R_EMAIL";
	public static final String C_ID_R_EMAIL     = "idREmail";

	//TA_WEB
	public static final String C_NOM_TA_WEB = "TA_WEB";
	public static final String C_NOM_VU_WEB = "V_WEB";
//	public static final String C_ID_WEB     = "ID_WEB";
//	public static final String C_ADRESSE_WEB   = "ADRESSE_WEB";
	public static final String C_ID_WEB     = "idWeb";
	public static final String C_ADRESSE_WEB   = "adresseWeb";
	
	//TA_NOTE_TIERS
	public static final String C_NOM_TA_NOTE_TIERS = "TA_NOTE_TIERS";
	public static final String C_NOM_VU_NOTE_TIERS = "V_NOTE_TIERS";
	public static final String C_ID_NOTE_TIERS     = "idNoteTiers";
	public static final String C_NOTE_TIERS   = "noteTiers";
	public static final String C_DATE_NOTE_TIERS = "dateNoteTiers";
	
	//TA_PARAM_CREE_DOC_TIERS
	public static final String C_ID_PARAM_CREE_DOC_TIERS = "idParamCreeDocTiers";
	public static final String C_CODE_PARAM   = "codeParam";
	public static final String C_TIERS = "tiers";
	public static final String C_DOCUMENT = "document";
	public static final String C_SEMAINE = "semaine";
	public static final String C_DEUX_SEMAINES = "deuxSemaines";
	public static final String C_DECADE = "decade"; 
	public static final String C_X_JOURS = "xJours";
	public static final String C_NB_JOURS = "nbJours";
	
	//TA_NOTE_ARTICLE
	public static final String C_NOM_TA_NOTE_ARTICLE = "TA_NOTE_ARTICLE";
	public static final String C_NOM_VU_NOTE_ARTICLE = "V_NOTE_ARTICLE";
	public static final String C_ID_NOTE_ARTICLE     = "idNoteArticle";
	public static final String C_NOTE_ARTICLE   = "noteArticle";
	public static final String C_DATE_NOTE_ARTICLE = "dateNoteArticle";
	

	//TA_R_WEB
	public static final String C_NOM_TA_R_WEB = "TA_R_WEB";
	public static final String C_NOM_VU_R_WEB = "V_R_WEB";
	//public static final String C_ID_R_WEB     = "ID_R_WEB";
	public static final String C_ID_R_WEB     = "idRWeb";

	//TA_R_COMMERCIAL
	public static final String C_NOM_TA_R_COMMERCIAL = "TA_R_COMMERCIAL";
	public static final String C_NOM_VU_R_COMMERCIAL = "V_R_COMMERCIAL";
//	public static final String C_ID_TIERS_COM     = "idTiersCom";
	public static final String C_ID_R_COMMERCIAL     = "idRCommercial";
	public static final String C_COMMERCIAL_DEFAUT     = "defaut";

	//Gestion des Articles/////// 

	//TA_ARTICLES
	public static final String C_NOM_TA_ARTICLE = "TA_ARTICLE";
	public static final String C_NOM_VU_ARTICLE = "V_ARTICLE";
//	public static final String C_ID_ARTICLE     = "ID_ARTICLE";
//	public static final String C_CODE_ARTICLE = "CODE_ARTICLE";
//	public static final String C_LIBELLEC_ARTICLE = "LIBELLEC_ARTICLE";
//	public static final String C_LIBELLEL_ARTICLE = "LIBELLEL_ARTICLE";
//	public static final String C_NUMCPT_ARTICLE = "NUMCPT_ARTICLE";
//	public static final String C_DIVERS_ARTICLE = "DIVERS_ARTICLE";
//	public static final String C_COMMENTAIRE_ARTICLE = "COMMENTAIRE_ARTICLE";
//	public static final String C_STOCK_MIN_ARTICLE = "STOCK_MIN_ARTICLE";
	public static final String C_ID_ARTICLE     = "idArticle";
	public static final String C_CODE_ARTICLE = "codeArticle";
	public static final String C_LIBELLEC_ARTICLE = "libellecArticle";
	public static final String C_LIBELLEL_ARTICLE = "libellelArticle";
	public static final String C_NUMCPT_ARTICLE = "numcptArticle";
	public static final String C_HAUTEUR_ARTICLE = "hauteur";
	public static final String C_LONGUEUR_ARTICLE = "longueur";
	public static final String C_LARGEUR_ARTICLE = "largeur";
	public static final String C_POIDS_ARTICLE = "poids";
	public static final String C_DIVERS_ARTICLE = "diversArticle";
	public static final String C_COMMENTAIRE_ARTICLE = "commentaireArticle";
	public static final String C_STOCK_MIN_ARTICLE = "stockMinArticle";
	public static final String C_ACTIF_ARTICLE = "actif";
	public static final String C_PARAM_DLUO = "paramDluo";
	//public static final String C_TITRE_TRANSPORT_ARTICLE_VITI = "titreTransport";


	//TA_PRIX
	public static final String C_NOM_TA_PRIX = "TA_PRIX";
	public static final String C_NOM_VU_PRIX = "V_PRIX";
//	public static final String C_ID_PRIX = "ID_PRIX";
//	public static final String C_PRIX_PRIX = "PRIX_PRIX";
//	public static final String C_PRIXTTC_PRIX = "PRIXTTC_PRIX";
	public static final String C_ID_PRIX = "idPrix";
	public static final String C_PRIX_PRIX = "prixPrix";
	public static final String C_PRIXTTC_PRIX = "prixttcPrix";
	
	//TA_CONDITIONNEMENT_ARTICLE
	public static final String C_NOM_TA_CONDITIONNEMENT_ARTICLE = "TA_CONDITIONNEMENT_ARTICLE";
	public static final String C_NOM_VU_CONDITIONNEMENT_ARTICLE = "V_CONDITIONNEMENT_ARTICLE";
	public static final String C_ID_CONDITIONNEMENT_ARTICLE = "idConditionnementArticle";
	public static final String C_CODE_CONDITIONNEMENT_ARTICLE = "code";
	public static final String C_LIBELLE_CONDITIONNEMENT_ARTICLE = "libelle";
	public static final String C_NB_UNITE_CONDITIONNEMENT_ARTICLE ="nbUnite";
	public static final String C_HAUTEUR_CONDITIONNEMENT_ARTICLE ="hauteur";
	public static final String C_LONGUEUR_CONDITIONNEMENT_ARTICLE ="longueur";
	public static final String C_LARGEUR_CONDITIONNEMENT_ARTICLE ="largeur";
	public static final String C_POIDS_CONDITIONNEMENT_ARTICLE ="poids";
	public static final String C_REDUCTION_CONDITIONNEMENT_ARTICLE ="reduction";
	
	//TA_T_CONDITIONNEMENT
	public static final String C_NOM_TA_T_CONDITIONNEMENT = "TA_T_CONDITIONNEMENT";
	public static final String C_NOM_VU_T_CONDITIONNEMENT = "V_T_CONDITIONNEMENT";
	public static final String C_ID_T_CONDITIONNEMENT = "id";
	public static final String C_CODE_T_CONDITIONNEMENT = "codeType";
	public static final String C_LIBELLE_T_CONDITIONNEMENT = "libelle";
	public static final String C_HAUTEUR_T_CONDITIONNEMENT ="hauteur";
	public static final String C_LONGUEUR_T_CONDITIONNEMENT ="longueur";
	public static final String C_LARGEUR_T_CONDITIONNEMENT ="largeur";
	public static final String C_POIDS_T_CONDITIONNEMENT ="poids";
	
	//TA_IMAGE_ARTICLE
	public static final String C_NOM_TA_IMAGE_ARTICLE = "TA_IMAGE_ARTICLE";
	public static final String C_NOM_VU_IMAGE_ARTICLE = "V_IMAGE_ARTICLE";
	public static final String C_ID_IMAGE_ARTICLE = "idImageArticle";
	public static final String C_CHEMIN_IMAGE_ARTICLE = "cheminImageArticle";
	public static final String C_NOM_IMAGE_ARTICLE = "nomImageArticle";
	public static final String C_DEFAUT_IMAGE_ARTICLE ="defautImageArticle";
	
	//TA_T_ARTICLE
	public static final String C_ID_T_ARTICLE = "idTArticle";
	public static final String C_CODE_T_ARTICLE = "codeTArticle";
	
	
	//TA_CATEGORIE_ARTICLE
	public static final String C_NOM_TA_CATEGORIE_ARTICLE = "TA_CATEGORIE_ARTICLE";
	public static final String C_NOM_VU_CATEGORIE_ARTICLE = "V_CATEGORIE_ARTICLE";
	public static final String C_ID_CATEGORIE_ARTICLE = "idCategorieArticle";
	public static final String C_CODE_CATEGORIE_ARTICLE = "codeCategorieArticle";
	public static final String C_LIBELLE_CATEGORIE_ARTICLE = "libelleCategorieArticle";
	public static final String C_DESCRIPTION_CATEGORIE_ARTICLE ="desciptionCategorieArticle";
	public static final String C_URL_REWRITING_CATEGORIE_ARTICLE ="urlRewritingCategorieArticle";
	public static final String C_CHEMIN_IMAGE_CATEGORIE_ARTICLE = "cheminImageCategorieArticle";
	public static final String C_NOM_IMAGE_CATEGORIE_ARTICLE = "nomImageCategorieArticle";
	public static final String C_ID_PARENT_CATEGORIE_ARTICLE ="categorieMereArticle";
	
	//TA_CATALOGUE_WEB
	public static final String C_NOM_TA_CATALOGUE_WEB = "TA_CATALOGUE_WEB";
	public static final String C_NOM_VU_CATALOGUE_WEB = "V_CATALOGUE_WEB";
	public static final String C_ID_CATALOGUE_WEB 			= "idCatalogueWeb";
	public static final String C_URL_REWRITING_CATALOGUE_WEB = "urlRewritingCatalogueWeb";
	public static final String C_NOUVEAUTE_CATALOGUE_WEB 	= "nouveauteCatalogueWeb";
	public static final String C_PROMOTION_CATALOGUE_WEB 	= "promotionCatalogueWeb";
	public static final String C_PROMOTION_U2_CATALOGUE_WEB 	= "promotionU2CatalogueWeb";
	public static final String C_DESCRIPTION_LONGUE_CAT_WEB = "descriptionLongueCatWeb";
	public static final String C_EXPORTATION_CATALOGUE_WEB 	= "exportationCatalogueWeb";
	public static final String C_EXPEDIABLE_CATALOGUE_WEB 	= "expediableCatalogueWeb";
	public static final String C_SPECIAL_CATALOGUE_WEB 	= "specialCatalogueWeb";
	
	//TA_LABEL_ARTICLE
	public static final String C_NOM_TA_LABEL_ARTICLE = "TA_LABEL_ARTICLE";
	public static final String C_NOM_VU_LABEL_ARTICLE = "V_LABEL_ARTICLE";
	public static final String C_ID_LABEL_ARTICLE = "idLabelArticle";
	public static final String C_CODE_LABEL_ARTICLE = "codeLabelArticle";
	public static final String C_LIBELLE_LABEL_ARTICLE = "libelleLabelArticle";
	public static final String C_DESCRIPTION_LABEL_ARTICLE ="desciptionLabelArticle";
	public static final String C_CHEMIN_IMAGE_LABEL_ARTICLE = "cheminImageLabelArticle";
	public static final String C_NOM_IMAGE_LABEL_ARTICLE = "nomImageLabelArticle";
	
	//TA_TVA
	public static final String C_NOM_TA_TVA = "TA_TVA";
	public static final String C_NOM_VU_TVA = "V_TVA";
//	public static final String C_ID_TVA = "ID_TVA";
//	public static final String C_CODE_TVA = "CODE_TVA";
//	public static final String C_TAUX_TVA = "TAUX_TVA";
//	public static final String C_NUMCPT_TVA = "NUMCPT_TVA";
//	public static final String C_LIBELLE_TVA = "LIBELLE_TVA";
	public static final String C_ID_TVA = "idTva";
	public static final String C_CODE_TVA = "codeTva";
	public static final String C_TAUX_TVA = "tauxTva";
	public static final String C_NUMCPT_TVA = "numcptTva";
	public static final String C_LIBELLE_TVA = "libelleTva";



	//TA_FAMILLE
	public static final String C_NOM_TA_FAMILLE = "TA_FAMILLE";
	public static final String C_NOM_VU_FAMILLE = "V_FAMILLE";
//	public static final String C_ID_FAMILLE = "ID_FAMILLE";
//	public static final String C_CODE_FAMILLE = "CODE_FAMILLE";
//	public static final String C_LIBC_FAMILLE = "LIBC_FAMILLE";
//	public static final String C_LIBL_FAMILLE = "LIBL_FAMILLE";
	public static final String C_ID_FAMILLE = "idFamille";
	public static final String C_CODE_FAMILLE = "codeFamille";
	public static final String C_LIBC_FAMILLE = "libcFamille";
	public static final String C_LIBL_FAMILLE = "liblFamille";
	
	//TA_ETAT
	public static final String C_NOM_TA_ETAT = "TA_ETAT";
	public static final String C_NOM_VU_ETAT = "V_ETAT";
	public static final String C_ID_ETAT = "idEtat";
	public static final String C_CODE_ETAT = "codeEtat";
	public static final String C_LIBL_ETAT = "libEtat";

	//TA_UNITE
	public static final String C_NOM_TA_UNITE = "TA_UNITE";
	public static final String C_NOM_VU_UNITE = "V_UNITE";
	//public static final String C_ID_UNITE = "ID_UNITE";
	//public static final String C_CODE_UNITE = "CODE_UNITE";
	//public static final String C_LIBL_UNITE = "LIBL_UNITE";
	public static final String C_ID_UNITE = "idUnite";
	public static final String C_CODE_UNITE = "codeUnite";
	public static final String C_LIBL_UNITE = "liblUnite";
	public static final String C_NB_UNITE_UNITE ="nbUnite";
	public static final String C_HAUTEUR_UNITE ="hauteur";
	public static final String C_LONGUEUR_UNITE ="longueur";
	public static final String C_LARGEUR_UNITE ="largeur";
	public static final String C_POIDS_UNITE ="poids";
	public static final String C_REDUCTION_UNITE ="reduction";
	
	//TA_DEVIS
	public static final String C_NOM_TA_DEVIS = "TA_DEVIS";
	public static final String C_NOM_VU_DEVIS = "V_DEVIS";
	public static final String C_NOM_VU_DEVIS_REDUIT = "V2_DEVIS";

	//TA_PROFORMA
	public static final String C_NOM_TA_PROFORMA = "TA_PROFORMA";
	public static final String C_NOM_VU_PROFORMA = "V_PROFORMA";
	public static final String C_NOM_VU_PROFORMA_REDUIT = "V2_PROFORMA";
//	public static final String C_ID_PROFORMA = "idProforma";
//	public static final String C_CODE_PROFORMA = "codeProforma";
//	public static final String C_DATE_PROFORMA = "dateProforma";
//	public static final String C_DATE_ECH_PROFORMA = "dateEchProforma";
//	public static final String C_DATE_LIV_PROFORMA = "dateLivProforma";
//	public static final String C_LIBELLE_PROFORMA = "libelleProforma";
//	public static final String C_REM_HT_PROFORMA = "remHtProforma";
//	public static final String C_TX_REM_HT_PROFORMA = "txRemHtProforma";
//	public static final String C_REM_TTC_PROFORMA = "remTtcProforma";
//	public static final String C_TX_REM_TTC_PROFORMA = "txRemTtcProforma";
//	public static final String C_NB_E_PROFORMA = "nbEProforma";

	//TA_BONCDE
	public static final String C_NOM_TA_BONCDE = "TA_BONCDE";
	public static final String C_NOM_VU_BONCDE = "V_BONCDE";
	public static final String C_NOM_VU_BONCDE_REDUIT = "V2_BONCDE";
//	public static final String C_ID_BONCDE = "idBoncde";
//	public static final String C_CODE_BONCDE = "codeBoncde";
//	public static final String C_DATE_BONCDE = "dateBoncde";
//	public static final String C_DATE_ECH_BONCDE = "dateEchBoncde";
//	public static final String C_DATE_LIV_BONCDE = "dateLivBoncde";
//	public static final String C_LIBELLE_BONCDE = "libelleBoncde";
//	public static final String C_REM_HT_BONCDE = "remHtBoncde";
//	public static final String C_TX_REM_HT_BONCDE = "txRemHtBoncde";
//	public static final String C_REM_TTC_BONCDE = "remTtcBoncde";
//	public static final String C_TX_REM_TTC_BONCDE = "txRemTtcBoncde";
//	public static final String C_NB_E_BONCDE = "nbEBoncde";
	
	//TA_BONLIV
	public static final String C_NOM_TA_BONLIV = "TA_BONLIV";
	public static final String C_NOM_VU_BONLIV = "V_BONLIV";
	public static final String C_NOM_VU_BONLIV_REDUIT = "V2_BONLIV";
//	public static final String C_ID_BONLIV = "idBonliv";
//	public static final String C_CODE_BONLIV = "codeBonliv";
//	public static final String C_DATE_BONLIV = "dateBonliv";
////	public static final String C_DATE_ECH_BONLIV = "DATE_ECH_BONLIV";
//	public static final String C_DATE_LIV_BONLIV = "dateLivBonliv";
//	public static final String C_LIBELLE_BONLIV = "libelleBonliv";
//	public static final String C_REM_HT_BONLIV = "remHtBonliv";
//	public static final String C_TX_REM_HT_BONLIV = "txRemHtBonliv";
//	public static final String C_REM_TTC_BONLIV = "remTtcBonliv";
//	public static final String C_TX_REM_TTC_BONLIV = "txRemTtcBonliv";
//	public static final String C_NB_E_BONLIV = "nbEBonliv";

	//TA_L_FACTURE
	public static final String C_NOM_TA_L_FACTURE = "TA_L_FACTURE";
	public static final String C_NOM_VU_L_FACTURE = "V_L_FACTURE";
//	public static final String C_NUM_LIGNE_L_DOCUMENT = "numLigneLFacture";
//	public static final String C_ID_L_DOCUMENT = "idLFacture";
//	public static final String C_LIB_L_DOCUMENT = "libLFacture";
//	public static final String C_QTE_L_DOCUMENT = "qteLFacture";
//	public static final String C_QTE2_L_DOCUMENT = "qte2LFacture";
//	public static final String C_U1_L_DOCUMENT = "u1LFacture";
//	public static final String C_U2_L_DOCUMENT = "u2LFacture";
//	public static final String C_PRIX_U_L_DOCUMENT = "prixULFacture";
//	public static final String C_TAUX_TVA_L_DOCUMENT = "tauxTvaLFacture";
//	public static final String C_CODE_TVA_L_DOCUMENT = "codeTvaLFacture";
//	public static final String C_CODE_T_TVA_L_DOCUMENT = "codeTTvaLFacture";
//	public static final String C_MT_HT_L_DOCUMENT = "mtHtLFacture";
//	public static final String C_MT_TTC_L_DOCUMENT = "mtTtcLFacture";
//	public static final String C_REM_TX_L_DOCUMENT = "remTxLFacture";
//	public static final String C_REM_HT_L_DOCUMENT = "remHtLFacture";
	
	//TA_L_APPORTEUR
	public static final String C_NOM_TA_L_APPORTEUR = "TA_L_APPORTEUR";
	public static final String C_NOM_VU_L_APPORTEUR = "V_L_APPORTEUR";
	//public static final String C_NUM_LIGNE_L_APPORTEUR = "numLigneLApporteur";
//	public static final String C_ID_L_APPORTEUR = "idLApporteur";
//	public static final String C_LIB_L_APPORTEUR = "libLApporteur";
//	public static final String C_QTE_L_APPORTEUR = "qteLApporteur";
//	public static final String C_QTE2_L_APPORTEUR = "qte2LApporteur";
//	public static final String C_U1_L_APPORTEUR = "u1LApporteur";
//	public static final String C_U2_L_APPORTEUR = "u2LApporteur";
//	public static final String C_PRIX_U_L_APPORTEUR = "prixULApporteur";
//	public static final String C_TAUX_TVA_L_APPORTEUR = "tauxTvaLApporteur";
//	public static final String C_CODE_TVA_L_APPORTEUR = "codeTvaLApporteur";
//	public static final String C_CODE_T_TVA_L_APPORTEUR = "codeTTvaLApporteur";
//	public static final String C_MT_HT_L_APPORTEUR = "mtHtLApporteur";
//	public static final String C_MT_TTC_L_APPORTEUR = "mtTtcLApporteur";
//	public static final String C_REM_TX_L_APPORTEUR = "remTxLApporteur";
//	public static final String C_REM_HT_L_APPORTEUR = "remHtLApporteur";
	
	//TA_L_AVOIR
	public static final String C_NOM_TA_L_AVOIR = "TA_L_AVOIR";
	public static final String C_NOM_VU_L_AVOIR = "V_L_AVOIR";
	//public static final String C_NUM_LIGNE_L_AVOIR = "numLigneLAvoir";
//	public static final String C_ID_L_AVOIR = "idLAvoir";
//	public static final String C_LIB_L_AVOIR = "libLAvoir";
//	public static final String C_QTE_L_AVOIR = "qteLAvoir";
//	public static final String C_QTE2_L_AVOIR = "qte2LAvoir";
//	public static final String C_U1_L_AVOIR = "u1LAvoir";
//	public static final String C_U2_L_AVOIR = "u2LAvoir";
//	public static final String C_PRIX_U_L_AVOIR = "prixULAvoir";
//	public static final String C_TAUX_TVA_L_AVOIR = "tauxTvaLAvoir";
//	public static final String C_CODE_TVA_L_AVOIR = "codeTvaLAvoir";
//	public static final String C_CODE_T_TVA_L_AVOIR = "codeTTvaLAvoir";
//	public static final String C_MT_HT_L_AVOIR = "mtHtLAvoir";
//	public static final String C_MT_TTC_L_AVOIR = "mtTtcLAvoir";
//	public static final String C_REM_TX_L_AVOIR = "remTxLAvoir";
//	public static final String C_REM_HT_L_AVOIR = "remHtLAvoir";
	
	
	//TA_L_FACTURE_TEMP
	public static final String C_NOM_TA_L_FACTURE_TEMP = "TA_L_FACTURE_TEMP";
	public static final String C_NOM_VU_L_FACTURE_TEMP = "V_L_FACTURE_TEMP";

	//TA_FACTURE
	public static final String C_NOM_TA_FACTURE = "TA_FACTURE";
	public static final String C_NOM_VU_FACTURE = "V_FACTURE";
	public static final String C_NOM_VU_FACTURE_REDUIT = "V2_FACTURE";
//	public static final String C_ID_FACTURE = "idFacture";
//	public static final String C_CODE_FACTURE = "codeFacture";
//	public static final String C_DATE_FACTURE = "dateFacture";
//	public static final String C_DATE_ECH_FACTURE = "dateEchFacture";
//	public static final String C_DATE_LIV_FACTURE = "dateLivFacture";
//	public static final String C_LIBELLE_FACTURE = "libelleFacture";
//	//public static final String C_ID_ADRESSE_LIV = "ID_ADRESSE_LIV";
//	public static final String C_ID_ADRESSE_LIV = "idAdresse";

	
//	public static final String C_REM_HT_FACTURE = "remHtFacture";
//	public static final String C_TX_REM_HT_FACTURE = "txRemHtFacture";
//	public static final String C_REM_TTC_FACTURE = "remTtcFacture";
//	public static final String C_TX_REM_TTC_FACTURE = "txRemTtcFacture";
//	public static final String C_NB_E_FACTURE = "nbEFacture";
	public static final String C_TTC = "ttc";
	public static final String C_EXPORT = "export";
	
	//TA_APPORTEUR
	public static final String C_NOM_TA_APPORTEUR = "TA_APPORTEUR";
	public static final String C_NOM_VU_APPORTEUR = "V_APPORTEUR";
	public static final String C_NOM_VU_APPORTEUR_REDUIT = "V2_APPORTEUR";
//	public static final String C_ID_APPORTEUR = "idApporteur";
//	public static final String C_CODE_APPORTEUR = "codeApporteur";
//	public static final String C_DATE_APPORTEUR = "dateApporteur";
//	public static final String C_DATE_ECH_APPORTEUR = "dateEchApporteur";
//	public static final String C_DATE_LIV_APPORTEUR = "dateLivApporteur";
//	public static final String C_LIBELLE_APPORTEUR = "libelleApporteur";
//
//	public static final String C_REGLE_APPORTEUR = "regleApporteur";
//	public static final String C_REM_HT_APPORTEUR = "remHtApporteur";
//	public static final String C_TX_REM_HT_APPORTEUR = "txRemHtApporteur";
//	public static final String C_REM_TTC_APPORTEUR = "remTtcApporteur";
//	public static final String C_TX_REM_TTC_APPORTEUR = "txRemTtcApporteur";
//	public static final String C_NB_E_APPORTEUR = "nbEApporteur";

	//TA_AVOIR
	public static final String C_NOM_TA_AVOIR = "TA_AVOIR";
	public static final String C_NOM_VU_AVOIR = "V_AVOIR";
	public static final String C_NOM_VU_AVOIR_REDUIT = "V2_AVOIR";
//	public static final String C_ID_AVOIR = "idAvoir";
//	public static final String C_CODE_AVOIR = "codeAvoir";
//	public static final String C_DATE_AVOIR = "dateAvoir";
//	public static final String C_DATE_ECH_AVOIR = "dateEchAvoir";
//	public static final String C_DATE_LIV_AVOIR = "dateLivAvoir";
//	public static final String C_LIBELLE_AVOIR = "libelleAvoir";

//	public static final String C_REGLE_AVOIR = "regleAvoir";
//	public static final String C_REM_HT_AVOIR = "remHtAvoir";
//	public static final String C_TX_REM_HT_AVOIR = "txRemHtAvoir";
//	public static final String C_REM_TTC_AVOIR = "remTtcAvoir";
//	public static final String C_TX_REM_TTC_AVOIR = "txRemTtcAvoir";
//	public static final String C_NB_E_AVOIR = "nbEAvoir";	
	//TA_L_DEVIS
	public static final String C_NOM_TA_L_DEVIS = "TA_L_DEVIS";
	public static final String C_NOM_VU_L_DEVIS = "V_L_DEVIS";
	public static final String C_NUM_LIGNE_L_DOCUMENT = "numLigneLDocument";
	public static final String C_ID_L_DOCUMENT = "idLDocument";
	public static final String C_LIB_L_DOCUMENT = "libLDocument";
	public static final String C_QTE_SAISIE_L_DOCUMENT = "qteSaisieLDocument";
	public static final String C_QTE_L_DOCUMENT = "qteLDocument";
	public static final String C_QTE2_L_DOCUMENT = "qte2LDocument";
	public static final String C_U_SAISIE_L_DOCUMENT = "uSaisieLDocument";
	public static final String C_U1_L_DOCUMENT = "u1LDocument";
	public static final String C_U2_L_DOCUMENT = "u2LDocument";
	public static final String C_PRIX_U_L_DOCUMENT = "prixULDocument";
	public static final String C_TAUX_TVA_L_DOCUMENT = "tauxTvaLDocument";
	public static final String C_CODE_TVA_L_DOCUMENT = "codeTvaLDocument";
	public static final String C_CODE_T_TVA_L_DOCUMENT = "codeTTvaLDocument";
	public static final String C_MT_HT_L_DOCUMENT = "mtHtLDocument";
	public static final String C_MT_TTC_L_DOCUMENT = "mtTtcLDocument";
	public static final String C_MT_HT_L_APRES_REMISE_GLOBALE_DOCUMENT = "mtHtLApresRemiseGlobaleDocument";
	public static final String C_MT_TTC_L_APRES_REMISE_GLOBALE_DOCUMENT = "mtTtcLApresRemiseGlobaleDocument";	
	public static final String C_REM_TX_L_DOCUMENT = "remTxLDocument";
	public static final String C_REM_HT_L_DOCUMENT = "remHtLDocument";
	public static final String C_QTE_TITRE_TRANSPORT_L_DOCUMENT = "qteTitreTransport";
	public static final String C_COEF_MULTIPLICATEUR = "coefMultiplicateur";
	public static final String C_COMMISSION_BANCAIRE_L_ABONNEMENT = "commissionBancaire";
	public static final String C_COMMISSION_PANIER_L_ABONNEMENT = "commissionPanier";
	
	//TA_L_PROFORMA
	public static final String C_NOM_TA_L_PROFORMA = "TA_L_PROFORMA";
	public static final String C_NOM_VU_L_PROFORMA = "V_L_PROFORMA";
	//public static final String C_NUM_LIGNE_L_PROFORMA = "numLigneLProforma";
//	public static final String C_ID_L_PROFORMA = "idLProforma";
//	public static final String C_LIB_L_PROFORMA = "libLProforma";
//	public static final String C_QTE_L_PROFORMA = "qteLProforma";
//	public static final String C_QTE2_L_PROFORMA = "qte2LProforma";
//	public static final String C_U1_L_PROFORMA = "u1LProforma";
//	public static final String C_U2_L_PROFORMA = "u2LProforma";
//	public static final String C_PRIX_U_L_PROFORMA = "prixULProforma";
//	public static final String C_TAUX_TVA_L_PROFORMA = "tauxTvaLProforma";
//	public static final String C_CODE_TVA_L_PROFORMA = "codeTvaLProforma";
//	public static final String C_CODE_T_TVA_L_PROFORMA = "codeTTvaLProforma";
//	public static final String C_MT_HT_L_PROFORMA = "mtHtLProforma";
//	public static final String C_MT_TTC_L_PROFORMA = "mtTtcLProforma";
//	public static final String C_REM_TX_L_PROFORMA = "remTxLProforma";
//	public static final String C_REM_HT_L_PROFORMA = "remHtLProforma";
	
	
	//TA_L_BONCDE
	public static final String C_NOM_TA_L_BONCDE = "TA_L_BONCDE";
	public static final String C_NOM_VU_L_BONCDE = "V_L_BONCDE";
	//public static final String C_NUM_LIGNE_L_BONCDE = "numLigneLBoncde";
//	public static final String C_ID_L_BONCDE = "idLBoncde";
//	public static final String C_LIB_L_BONCDE = "libLBoncde";
//	public static final String C_QTE_L_BONCDE = "qteLBoncde";
//	public static final String C_QTE2_L_BONCDE = "qte2LBoncde";
//	public static final String C_U1_L_BONCDE = "u1LBoncde";
//	public static final String C_U2_L_BONCDE = "u2LBoncde";
//	public static final String C_PRIX_U_L_BONCDE = "prixULBoncde";
//	public static final String C_TAUX_TVA_L_BONCDE = "tauxTvaLBoncde";
//	public static final String C_CODE_TVA_L_BONCDE = "codeTvaLBoncde";
//	public static final String C_CODE_T_TVA_L_BONCDE = "codeTTvaLBoncde";
//	public static final String C_MT_HT_L_BONCDE = "mtHtLBoncde";
//	public static final String C_MT_TTC_L_BONCDE = "mtTtcLBoncde";
//	public static final String C_REM_TX_L_BONCDE = "remTxLBoncde";
//	public static final String C_REM_HT_L_BONCDE = "remHtLBoncde";
	
	//TA_L_DEVIS_TEMP
	public static final String C_NOM_TA_L_DEVIS_TEMP = "TA_L_DEVIS_TEMP";
	public static final String C_NOM_VU_L_DEVIS_TEMP = "V_L_DEVIS_TEMP";

	  //TA_L_BONLIV
	public static final String C_NOM_TA_L_BONLIV = "TA_L_BONLIV";
	public static final String C_NOM_VU_L_BONLIV = "V_L_BONLIV";
//	public static final String C_NUM_LIGNE_L_BONLIV = "numLigneLBonliv";
//	public static final String C_ID_L_BONLIV = "idLBonliv";
//	public static final String C_LIB_L_BONLIV = "libLBonliv";
//	public static final String C_QTE_L_BONLIV = "qteLBonliv";
//	public static final String C_QTE2_L_BONLIV = "qteLBonliv";
//	public static final String C_U1_L_BONLIV = "u1LBonliv";
//	public static final String C_U2_L_BONLIV = "u2LBonliv";
//	public static final String C_PRIX_U_L_BONLIV = "prixULBonliv";
//	public static final String C_TAUX_TVA_L_BONLIV = "tauxTvaLBonliv";
//	public static final String C_CODE_TVA_L_BONLIV = "codeTvaLBonliv";
//	public static final String C_CODE_T_TVA_L_BONLIV = "codeTTvaLBonliv";
//	public static final String C_MT_HT_L_BONLIV = "mtHtLBonliv";
//	public static final String C_MT_TTC_L_BONLIV = "mtTtcLBonliv";
//	public static final String C_REM_TX_L_BONLIV = "remTxLBonliv";
//	public static final String C_REM_HT_L_BONLIV = "remHtLBonliv";
	
	//TA_L_BONLIV_TEMP
	public static final String C_NOM_TA_L_BONLIV_TEMP = "TA_L_BONLIV_TEMP";
	public static final String C_NOM_VU_L_BONLIV_TEMP = "V_L_BONLIV_TEMP";	
	//TA_T_LIGNE
	public static final String C_NOM_TA_T_LIGNE = "TA_T_LIGNE";
	public static final String C_NOM_VU_T_LIGNE = "V_T_LIGNE";
	public static final String C_ID_T_LIGNE = "ID_T_LIGNE";
	public static final String C_CODE_T_LIGNE = "CODE_T_LIGNE";
	public static final String C_LIB_T_LIGNE = "LIB_T_LIGNE";
	
	//TA_T_LIENS
	public static final String C_NOM_VU_T_LIEN = "V_T_LIEN";

	public static final String C_ID = "id";
	public static final String C_ID_UNITE1 = "idUnite1";
	public static final String C_CODE_UNITE1 = "codeUnite1";
	public static final String C_CODE_UNITE2 = "codeUnite2";
	public static final String C_CODE_UNITE_REFERENCE = "codeUniteReference";
	public static final String C_ID_UNITE2 = "idUnite2";
	public static final String C_RAPPORT = "rapport";
	public static final String C_NB_DECIMAL = "nbDecimal";
	public static final String C_SENS_RAPPORT = "sens";
	public static final String C_CODE_UNITE_STOCK = "codeUniteStock";
	public static final String C_CODE_UNITE_SAISIE = "codeUniteSaisie";
	
	//Type de lignes document
	public static final String C_CODE_T_LIGNE_H = "H"; //HT (normale)
	public static final String C_CODE_T_LIGNE_T = "T"; //ligne TVA
	public static final String C_CODE_T_LIGNE_C = "C"; //commentaire
	public static final String C_CODE_T_LIGNE_ST = "ST"; //Sous Total

	//TA_T_PAIEMENT
	public static final String C_NOM_TA_T_PAIEMENT = "TA_T_PAIEMENT";
	public static final String C_NOM_VU_T_PAIEMENT = "V_T_PAIEMENT";
	public static final String C_ID_T_PAIEMENT = "idTPaiement";
	public static final String C_CODE_T_PAIEMENT = "codeTPaiement";
	public static final String C_LIB_T_PAIEMENT = "libTPaiement";
	public static final String C_COMPTE_T_PAIEMENT = "compte";
	public static final String C_REPORT_T_PAIEMENT = "reportTPaiement";
	public static final String C_FIN_MOIS_T_PAIEMENT = "finMoisTPaiement";
	
	//TA_C_PAIEMENT
	public static final String C_NOM_TA_C_PAIEMENT = "TA_C_PAIEMENT";
	public static final String C_NOM_VU_C_PAIEMENT = "V_C_PAIEMENT";
//	public static final String C_ID_C_PAIEMENT = "ID_C_PAIEMENT";
//	public static final String C_CODE_C_PAIEMENT = "CODE_C_PAIEMENT";
//	public static final String C_LIB_C_PAIEMENT = "LIB_C_PAIEMENT";
//	public static final String C_REPORT_C_PAIEMENT = "REPORT_C_PAIEMENT";
//	public static final String C_FIN_MOIS_C_PAIEMENT = "FIN_MOIS_C_PAIEMENT";
	public static final String C_ID_C_PAIEMENT = "idCPaiement";
	public static final String C_CODE_C_PAIEMENT = "codeCPaiement";
	public static final String C_LIB_C_PAIEMENT = "libCPaiement";
	public static final String C_REPORT_C_PAIEMENT = "reportCPaiement";
	public static final String C_FIN_MOIS_C_PAIEMENT = "finMoisCPaiement";
	public static final String C_DEFAUT_C_PAIEMENT = "defaut";
	
	
	//TA_T_C_PAIEMENT
	public static final String C_NOM_TA_T_C_PAIEMENT = "TA_T_C_PAIEMENT";
	public static final String C_NOM_VU_T_C_PAIEMENT = "V_T_C_PAIEMENT";
	public static final String C_ID_T_C_PAIEMENT = "idTCPaiement";
	public static final String C_CODE_T_C_PAIEMENT = "codeTCPaiement";
	public static final String C_LIBL_T_C_PAIEMENT = "liblTCPaiement";
	
	public static final String C_NOM_TA_INFO_JURIDIQUE = "TA_INFO_JURIDIQUE";
	public static final String C_NOM_VU_INFO_JURIDIQUET = "V_INFO_JURIDIQUE";
	public static final String C_ID_INFO_JURIDIQUE = "idInfoJuridique";
	public static final String C_APE_INFO_JURIDIQUE = "apeInfoJuridique";
	public static final String C_CAPITAL_INFO_JURIDIQUE = "capitalInfoJuridique";
	public static final String C_RCS_INFO_JURIDIQUE = "rcsInfoJuridique";
	public static final String C_SIRET_INFO_JURIDIQUE = "siretInfoJuridique";

	//TA_INFO_ENTREPRISE
	public static final String C_NOM_TA_INFO_ENTREPRISE = "TA_INFO_ENTREPRISE";
	public static final String C_NOM_VU_INFO_ENTREPRISE = "V_INFO_ENTREPRISE";

	public static final String C_ID_INFO_ENTREPRISE = "idInfoEntreprise";
	public static final String C_NOM_INFO_ENTREPRISE = "nomInfoEntreprise";
	public static final String C_ADRESSE1_INFO_ENTREPRISE = "adresse1InfoEntreprise";
	public static final String C_ADRESSE2_INFO_ENTREPRISE = "adresse2InfoEntreprise";
	public static final String C_ADRESSE3_INFO_ENTREPRISE = "adresse3InfoEntreprise";
	public static final String C_CODEPOSTAL_INFO_ENTREPRISE="codepostalInfoEntreprise";
	public static final String C_VILLE_INFO_ENTREPRISE="villeInfoEntreprise";
	public static final String C_PAYS_INFO_ENTREPRISE="paysInfoEntreprise";
	public static final String C_TEL_INFO_ENTREPRISE="telInfoEntreprise";
	public static final String C_FAX_INFO_ENTREPRISE="faxInfoEntreprise";
	public static final String C_EMAIL_INFO_ENTREPRISE="emailInfoEntreprise";
	public static final String C_WEB_INFO_ENTREPRISE="webInfoEntreprise";
	public static final String C_RCS_INFO_ENTREPRISE="rcsInfoEntreprise";
	public static final String C_SIRET_INFO_ENTREPRISE = "siretInfoEntreprise";
	public static final String C_CAPITAL_INFO_ENTREPRISE = "capitalInfoEntreprise";
	public static final String C_APE_INFO_ENTREPRISE = "apeInfoEntreprise";
	public static final String C_TVA_INTRA_INFO_ENTREPRISE = "tvaIntraInfoEntreprise";
	public static final String C_DATEDEB_INTRA_INFO_ENTREPRISE = "datedebInfoEntreprise";
	public static final String C_DATEFIN_INTRA_INFO_ENTREPRISE = "datefinInfoEntreprise";
	public static final String C_DATEDEB_REG_INFO_ENTREPRISE = "datedebRegInfoEntreprise";
	public static final String C_DATEDEB_REL_INFO_ENTREPRISE = "datedebRelInfoEntreprise";
	public static final String C_CODEXO_INTRA_INFO_ENTREPRISE = "codexoInfoEntreprise";
	//TA_MAIL_MAJ
	public static final String C_NOM_TA_MAIL_MAJ = "TA_MAIL_MAJ";
	public static final String C_NOM_VU_MAIL_MAJ = "V_MAIL_MAJ";
	public static final String C_ID_MAIL_MAJ = "idMailMaj";
	public static final String C_SUJET_MAIL_MAJ = "sujetMailMaj";   
	public static final String C_NOM_SITE_MAIL_MAJ = "nomSiteMailMaj";  
	public static final String C_URL_MAIL_MAJ = "urlMailMaj";
	public static final String C_FAIT_MAIL_MAJ = "faitMailMaj";
	public static final String C_A_FAIRE_MAIL_MAJ = "AFaireMailMaj";
	public static final String C_FROM_MAIL_MAJ = "fromMailMaj";
	public static final String C_DATE_MAIL_MAJ = "dateMailMaj";

	//TA_INFOS_FACTURE
	public static final String C_NOM_TA_INFOS_FACTURE = "TA_INFOS_FACTURE";
	public static final String C_NOM_VU_INFOS_FACTURE = "V_INFOS_FACTURE";
	public static final String C_NOM_PROCEDURE_INFOS_FACTURE = "INFOSFACTURE";
	public static final String C_NOM_PROCEDURE_INFOS_C_PAIEMENT = "INFOSCPAIEMENT";

	
	//TA_INFOS_DEVIS
	public static final String C_NOM_TA_INFOS_DEVIS = "TA_INFOS_DEVIS";
	public static final String C_NOM_VU_INFOS_DEVIS = "V_INFOS_DEVIS";
	public static final String C_NOM_PROCEDURE_INFOS_DEVIS = "INFOSDEVIS";
	
	//TA_INFOS_BONCDE
	public static final String C_NOM_TA_INFOS_BONCDE = "TA_INFOS_BONCDE";
	public static final String C_NOM_VU_INFOS_BONCDE = "V_INFOS_BONCDE";
	public static final String C_NOM_PROCEDURE_INFOS_BONCDE = "INFOSBONCDE";

	//TA_INFOS_PROFORMA
	public static final String C_NOM_TA_INFOS_PROFORMA = "TA_INFOS_PROFORMA";
	public static final String C_NOM_VU_INFOS_PROFORMA = "V_INFOS_PROFORMA";
	public static final String C_NOM_PROCEDURE_INFOS_PROFORMA = "INFOSPROFORMA";
	
	//TA_INFOS_BONLIV
	public static final String C_NOM_TA_INFOS_BONLIV = "TA_INFOS_BONLIV";
	public static final String C_NOM_VU_INFOS_BONLIV = "V_INFOS_BONLIV";
	public static final String C_NOM_PROCEDURE_INFOS_BONLIV = "INFOSBONLIV";
	
	//TA_VERSION
	public static final String C_NOM_TA_VERSION = "TA_VERSION";
	//public static final String C_NOM_VU_VERSION = "V_VERSION";
	public static final String C_ID_VERSION_VERSION = "ID_VERSION";
	public static final String C_NUM_VERSION_VERSION = "NUM_VERSION";
	public static final String C_OLD_VERSION_VERSION = "OLD_VERSION";

	//TA_STOCK
	public static final String C_NOM_TA_STOCK = "TA_STOCK";
	public static final String C_NOM_VU_STOCK = "V_STOCK";
	public static final String C_ID_STOCK = "idStock";
	public static final String C_ID_ARTICLE_STOCK = "idArticleStock";
	public static final String C_MOUV_STOCK = "mouvStock"	;
	public static final String C_DATE_STOCK = "dateStock";
	public static final String C_LIBELLE_STOCK = "libelleStock";
	public static final String C_QTE1_STOCK = "qte1Stock";
	public static final String C_QTE2_STOCK = "qte2Stock";
	public static final String C_UN1_STOCK = "un1Stock";
	public static final String C_UN2_STOCK = "un2Stock";
	
	public static final String C_DATE_DEB = "dateDeb";
	public static final String C_DATE_FIN = "dateFin";
	
	public static final String C_MOIS = "mois";
	public static final String C_ANNEE = "annee";
	
	//TA_ROLE
	public static final String C_Role = "role";
	public static final String C_Description = "description";
	public static final String C_MESSAGE_CHAMP_OBLIGATOIRE="Attention, champ obligatoire.";
	
	//public static final String C_ID_GENERE_INFOS_FACTURE = "ID";
	public static final String C_ID_INFOS_FACTURE = "ID_INFOS_FACTURE";
	public static final String C_ID_INFOS_DOCUMENT = "ID_INFOS_DOCUMENT";
	public static final String C_ID_INFOS_BONLIV = "ID_INFOS_BONLIV";
	public static final String C_ADRESSE1 = "adresse1Adresse";
	public static final String C_ADRESSE2 = "adresse2Adresse";
	public static final String C_ADRESSE3 = "adresse3Adresse";
	public static final String C_CODEPOSTAL = "codepostalAdresse";
	public static final String C_VILLE = "villeAdresse";
	public static final String C_PAYS = "paysAdresse";
	public static final String C_ADRESSE1_LIV = "adresse1AdresseLiv";
	public static final String C_ADRESSE2_LIV = "adresse2AdresseLiv";
	public static final String C_ADRESSE3_LIV = "adresse3AdresseLiv";
	public static final String C_CODEPOSTAL_LIV = "codepostalAdresseLiv";
	public static final String C_VILLE_LIV = "villeAdresseLiv";
	public static final String C_PAYS_LIV = "paysAdresseLiv";
	
	/*
	 * Principalement utilisé dans les methodes initVerifySaisie() dans les controller
	 * car les constantes au dessus (C_ADRESSE1, C_ADRESSE2, ...) ne correspondent pas aux nom
	 * des proprietes dans les entités TaInfosXXX
	 */
	public static final String C_ADRESSE1_INFOS_DOCUMENT = "adresse1";
	public static final String C_ADRESSE2_INFOS_DOCUMENT = "adresse2";
	public static final String C_ADRESSE3_INFOS_DOCUMENT = "adresse3";
	public static final String C_CODEPOSTAL_INFOS_DOCUMENT = "codepostal";
	public static final String C_VILLE_INFOS_DOCUMENT = "ville";
	public static final String C_PAYS_INFOS_DOCUMENT = "pays";
	public static final String C_ADRESSE1_LIV_INFOS_DOCUMENT = "adresse1Liv";
	public static final String C_ADRESSE2_LIV_INFOS_DOCUMENT = "adresse2Liv";
	public static final String C_ADRESSE3_LIV_INFOS_DOCUMENT = "adresse3Liv";
	public static final String C_CODEPOSTAL_LIV_INFOS_DOCUMENT = "codepostalLiv";
	public static final String C_VILLE_LIV_INFOS_DOCUMENT = "villeLiv";
	public static final String C_PAYS_LIV_INFOS_DOCUMENT = "paysLiv";

	public static  String C_CPT_ESCOMPTE_DEBIT = "";
	public static  String C_CPT_ESCOMPTE_CREDIT = "";
	
	public static final String C_LIBELLE_ARTICLE ="libelleArticle";
	
    public static final String C_ID_T_OPERATION = "idTOperation";
	public static final String C_CODE_T_OPERATION = "codeTOperation";
    public static final String C_LIBL_T_OPERATION = "liblTOperation";
    
    public static final String C_ID_DEPOT = "idDepot";
    public static final String C_DATE_DEPOT = "dateDepot";
    public static final String C_MONTANT_DEPOT = "montantDepot";
    public static final String C_LIBL_DEPOT = "liblDepot";
    
    public static final String C_ID_OPERATION = "idOperation";
    public static final String C_DATE_OPERATION = "dateOperation";
    public static final String C_MONTANT_OPERATION = "montantOperation";
    public static final String C_LIBL_OPERATION = "liblOperation";
    
    public static final String C_ID_ETABLISSEMENT = "idEtablissement";
    public static final String C_NOM_ETABLISSEMENT = "nomEtablissement";
    public static final String C_JOURNAL_CAISSE = "codeJournalCaisse";

	public static final String C_ID_VERSION = "idVersion";
	public static final String C_NUM_VERSION = "numVersion";
	public static final String C_OLD_VERSION = "oldVersion";
	public static final String C_DATE_VERSION = "dateVersion";
	
	public static final String C_DATE_DEB_RELLE_FABRICATION="dateDebR";
	//document
	public static final String C_ID_DOCUMENT = "idDocument";
	public static final String C_CODE_DOCUMENT = "codeDocument";
	public static final String C_DATE_DOCUMENT = "dateDocument";
	public static final String C_DATE_ECH_DOCUMENT = "dateEchDocument";
	public static final String C_DATE_LIV_DOCUMENT = "dateLivDocument";
	public static final String C_LIBELLE_DOCUMENT = "libelleDocument";
	public static final String C_REM_HT_DOCUMENT = "remHtDocument";
	public static final String C_TX_REM_HT_DOCUMENT = "txRemHtDocument";
	public static final String C_REM_TTC_DOCUMENT = "remTtcDocument";
	public static final String C_TX_REM_TTC_DOCUMENT = "txRemTtcDocument";
	public static final String C_NB_E_DOCUMENT = "nbEDocument";
	public static final String C_COMMENTAIRE = "commentaire";
	public static final String C_MONTANT_REGLEMENT = "montantReglement";
	public static final String C_MONTANT_AFFECTE = "affectation";
//	public static final String C_MONTANT_AFFECTE_AVOIR = "affectationAvoir";
	//public static final String C_CODE_REGLEMENT = "codeReglement";
	public static final String C_DATE_REGLEMENT = "dateReglement";
	public static final String C_DATE_ENCAISSEMENT = "dateEncaissement";
	public static final String C_LIBELLE_REGLEMENT = "libelleReglement";
//	public static final String C_MT_REMISE = "mtRemise";
	//champs calculés
	public static final String C_MT_TTC_CALC = "mtTtcCalc";
	public static final String C_MT_TTC_AVANTREMISEGLOBALE_CALC="mtTtcAvantRemiseGlobaleCalc";
	public static final String C_MT_HT_CALC  = "mtHtCalc";
	public static final String C_MT_TVA_CALC = "mtTvaCalc";
//	public static final String C_MT_ESCOMPTE = "mtEscompte";
	public static final String C_NET_TTC_CALC = "netTtcCalc";
	public static final String C_NET_HT_CALC  = "netHtCalc";
	public static final String C_NET_TVA_CALC = "netTvaCalc";

	public static final String C_NET_A_PAYER = "netAPayer";
	public static final String C_RESTE_A_REGLER = "resteARegler";
	public static final String C_REGLE_DOCUMENT = "regleDocument";
	public static final String C_ACOMPTES = "acomptes";
	public static final String C_AVOIRS = "avoirs";
	public static final String C_LIBELLE_PAIEMENT ="libellePaiement";
	
	public static final String C_CODE_REGLEMENT = "codeReglement";
	public static final String C_NB_JOUR = "nbJours";
	
	public static final String C_ID_SUPPORT_ABON = "idSupportAbon";
	public static final String C_CODE_SUPPORT_ABON = "codeSupportAbon";
	
	public static final String C_DATE_ACQUISITION = "dateAcquisition";
	public static final String C_DATE_DEB_ABON = "dateDebAbon";
	public static final String C_DATE_FIN_ABON = "dateFinAbon";
	public static final String C_LIBELLE = "libelle";
	public static final String C_COMMERCIAL = "commercial";
	public static final String C_ID_COMMERCIAL = "idCommercial";
	public static final String C_ID_UTILISATEUR = "idUtilisateur";
	public static final String C_NOM = "nom";
	public static final String C_PRENOM = "prenom";
	public static final String C_TEL = "tel";
	public static final String C_EMAIL = "email";
	public static final String C_SERVEUR = "serveur";	
	
	
	public static final String C_NOM_VU_ACOMPTE = "V_ACOMPTE";
	
	
	public static final String C_CODE_TYPE_MOUVEMENT = "code";
	public static final String C_CODE_TYPE_MOUVEMENT_STOCK = "codetypeMouvStock";
	public static final String C_CODE_ENTREPOT = "codeEntrepot";
	public static final String C_CODE_ENTREPOT_DEST = "codeEntrepotDest";
	public static final String C_CODE_ENTREPOT_LIGNE = "codeEntrepotLigne";
	public static final String C_ENTREPOT_LIBELLE = "libelle";
	public static final String C_EMPLACEMENT="emplacement";
	public static final String C_EMPLACEMENT_DEST="emplacementDest";
	
	public static final String C_CODE_BARRE = "codeBarre";
	public static final String C_CODE_TYPE_CODE_BARRE = "codeTypeCodeBarre";
	public static final String C_LIBEL_TYPE_CODE_BARRE = "libelle";

	public static final String C_NUM_LOT = "numLot";
	public static final String C_DLUO = "dluo";

	// -- Dima - Début --
	
	//TA_TYPE_CODE_BARRE
	public static final String C_TYPE_CODE_BARRE_ARTICLE = "codeTypeCodeBarre";
	public static final String C_TYPE_CODE_BARRE_LIBELLE = "libelle";
	
	//TA_FAMILLE_UNITE
	public static final String C_TYPE_CODE_FAMILLE_UNITE = "codeFamille"; 
	public static final String C_TYPE_LIB_C_FAMILLE_UNITE = "libcFamille";
	public static final String C_TYPE_LIB_L_FAMILLE_UNITE = "liblFamille";
	
	//TA_FAMILLE_TIERS
	public static final String C_CODE_FAMILLE_TIERS = "codeFamille";
	public static final String C_LIBC_FAMILLE_TIERS = "libcFamille";
	public static final String C_LIBL_FAMILLE_TIERS = "liblFamille";
	
	//TA_GEN_CODE_EX
	public static final String C_CLE_GENCODE="cleGencode";
	public static final String C_VALEUR_GENCODE="valeurGenCode";
	
	// -- Dima -  Fin  --
	
	public static final String C_ID_T_FABRICATION="idTFabrication";
	public static final String C_CODE_T_FABRICATION="codeTFabrication";
	public static final String C_LIBL_T_FABRICATION="liblTFabrication";
	
	public static final String C_ID_T_RECEPTION="idTReception";
	public static final String C_CODE_T_RECEPTION="codeTReception";
	public static final String C_LIBL_T_RECEPTION="liblTReception";

	public static final String C_NOM_REDACTEUR = "redacteur";
	public static final String C_NOM_CONTROLEUR = "controleur";
	
	public static final String C_ID_T_SERVICE_WEB_EXTERNE = "idTServiceWebExterne";
	public static final String C_CODE_T_SERVICE_WEB_EXTERNE = "codeTServiceWebExterne";
	public static final String C_LIBELLE_T_SERVICE_WEB_EXTERNE = "libelleTServiceWebExterne";
	public static final String C_DESCRIPTION_T_SERVICE_WEB_EXTERNE = "descriptionTServiceWebExterne";
	
	public static final String C_ID_T_AUTHENTIFICATION = "idTAuthentification";
	public static final String C_CODE_T_AUTHENTIFICATION = "codeTAuthentification";
	public static final String C_LIBELLE_T_AUTHENTIFICATION = "libelleTAuthentification";
	public static final String C_DESCRIPTION_T_AUTHENTIFICATION = "descriptionTAuthentification";
	
	public static final String C_ID_COMPTE_SERVICE_WEB_EXTERNE = "idCompteServiceWebExterne";
	public static final String C_CODE_COMPTE_SERVICE_WEB_EXTERNE = "codeCompteServiceWebExterne";
	public static final String C_LIBELLE_COMPTE_SERVICE_WEB_EXTERNE = "libelleCompteServiceWebExterne";
	public static final String C_DESCRIPTION_COMPTE_SERVICE_WEB_EXTERNE = "descriptionCompteServiceWebExterne";
	public static final String C_URL_SERVICE_COMPTE_SERVICE_WEB_EXTERNE = "urlService";
	public static final String C_LOGIN_COMPTE_SERVICE_WEB_EXTERNE = "login";
	public static final String C_PASSWORD_COMPTE_SERVICE_WEB_EXTERNE = "password";
	public static final String C_API_KEY_1_COMPTE_SERVICE_WEB_EXTERNE = "apiKey1";
	public static final String C_API_KEY_2_COMPTE_SERVICE_WEB_EXTERNE = "apiKey2";
	public static final String C_VALEUR_1_COMPTE_SERVICE_WEB_EXTERNE = "valeur1";
	public static final String C_VALEUR_2_COMPTE_SERVICE_WEB_EXTERNE = "valeur2";
	public static final String C_VALEUR_3_COMPTE_SERVICE_WEB_EXTERNE = "valeur3";
	public static final String C_VALEUR_4_COMPTE_SERVICE_WEB_EXTERNE = "valeur4";
	public static final String C_VALEUR_5_COMPTE_SERVICE_WEB_EXTERNE = "valeur5";
	public static final String C_VALEUR_6_COMPTE_SERVICE_WEB_EXTERNE = "valeur6";
	public static final String C_VALEUR_7_COMPTE_SERVICE_WEB_EXTERNE = "valeur7";
	public static final String C_VALEUR_8_COMPTE_SERVICE_WEB_EXTERNE = "valeur8";
	public static final String C_VALEUR_9_COMPTE_SERVICE_WEB_EXTERNE = "valeur9";
	public static final String C_VALEUR_10_COMPTE_SERVICE_WEB_EXTERNE = "valeur10";
	public static final String C_ACTIF_COMPTE_SERVICE_WEB_EXTERNE = "actif";
	public static final String C_DEFAUT_COMPTE_SERVICE_WEB_EXTERNE = "defaut";
	public static final String C_SYSTEME_COMPTE_SERVICE_WEB_EXTERNE = "systeme";
	public static final String C_COMPTE_TEST_COMPTE_SERVICE_WEB_EXTERNE = "compteTest";
	public static final String C_DEBUT_COMPTE_SERVICE_WEB_EXTERNE = "debut";
	public static final String C_FIN_COMPTE_SERVICE_WEB_EXTERNE = "fin";
	public static final String C_DERNIERE_UTILISATION_COMPTE_SERVICE_WEB_EXTERNE = "derniereUtilisation";
	
	public static final String C_ID_SERVICE_WEB_EXTERNE = "idServiceWebExterne";
	public static final String C_CODE_SERVICE_WEB_EXTERNE = "codeServiceWebExterne";
	public static final String C_LIBELLE_SERVICE_WEB_EXTERNE = "libelleServiceWebExterne";
	public static final String C_DESCRIPTION_SERVICE_WEB_EXTERNE = "descriptionServiceWebExterne";
	public static final String C_URL_EDITEUR_SERVICE_WEB_EXTERNE = "urlEditeur";
	public static final String C_URL_SERVICE_SERVICE_WEB_EXTERNE = "urlService";
	public static final String C_DEFAUT_SERVICE_WEB_EXTERNE = "defaut";
	public static final String C_TYPE_API_SERVICE_WEB_EXTERNE = "typeAPI";
	public static final String C_VERSION_API_SERVICE_WEB_EXTERNE = "versionAPI";
	public static final String C_ACTIF_SERVICE_WEB_EXTERNE = "actif";
	public static final String C_API_MULTICOMPTE_SERVICE_WEB_EXTERNE = "apiMulticompte";
	public static final String C_SYSTEME_SERVICE_WEB_EXTERNE = "systeme";
	public static final String C_LOGO_SERVICE_WEB_EXTERNE = "logo";
	
	public static final String C_ID_EDITION_CATALOGUE = "id";
	public static final String C_CODE_EDITION_CATALOGUE = "codeEdition";
	public static final String C_LIBELLE_EDITION_CATALOGUE = "libelleEdition";
	public static final String C_DESCRIPTION_EDITION_CATALOGUE = "descriptionEdition";
	public static final String C_MINIATURE_EDITION_CATALOGUE = "miniature";
	public static final String C_FICHIER_EDITION_CATALOGUE = "fichierBlob";
	public static final String C_CHEMIN_EDITION_CATALOGUE = "fichierChemin";
	public static final String C_NOM_FICHIER_EDITION_CATALOGUE = "fichierNom";
	public static final String C_DEFAUT_EDITION_CATALOGUE = "defaut";
	public static final String C_ACTIF_EDITION_CATALOGUE = "actif";
	public static final String C_SYSTEME_EDITION_CATALOGUE = "systeme";
	public static final String C_IMPORTATION_MANUELLE_EDITION_CATALOGUE = "importationManuelle";
	public static final String C_DATE_IMPORTATION_EDITION_CATALOGUE = "dateImportation";
	public static final String C_VERSION_EDITION_EDITION_CATALOGUE = "versionEdition";
	public static final String C_CODE_DOSSIER_EDITION_CATALOGUE = "codeDossierEditionPersonalisee";
	public static final String C_PAYANT_EDITION_CATALOGUE = "payant";

	public static final String C_ID_T_EDITION_CATALOGUE = "idTEdition";
	public static final String C_CODE_T_EDITION_CATALOGUE = "codeTEdition";
	
	public static final String C_ID_T_TRANSPORT = "idTTransport";
	public static final String C_CODE_T_TRANSPORT = "codeTTransport";
	public static final String C_LIBL_T_TRANSPORT = "liblTTransport";

	public static final String C_ID_TRANSPORTEUR = "idTransporteur";
	public static final String C_CODE_TRANSPORTEUR = "codeTransporteur";
	public static final String C_LIBL_TRANSPORTEUR = "liblTransporteur";
	
	public static final String C_NOMFOURNISSEUR="@nom";
	public static final String C_CODEFOURNISSEUR="@codef";
	public static final String C_CODEDOCUMENT="@coded";
	public static final String C_EXO="@exo";
	public static final String C_NUM="@num";
	public static final String C_DATE="@date";
	public static final String C_QUANT="@quant";
	public static final String C_HEURE="@heure";
	public static final String C_DESC="@desc";
	public static final String C_CODETYPE="@codetype";
	public static final String C_VIRTUEL="@virtuel";
	public static final String C_IDARTICLEVIRTUEL="@codea";
	public static final String C_DATEDOCUMENT="@dated";
	public static final String C_DATEDOCUMENT_QUANT="@dated_quant";

	
	public static final String C_AUCUN = "<vide>";
	
	public static final String C_CODE_GROUPE_CTRL="codeGroupe";
	public static final String C_LIBELLE_GROUPE_CTRL="libelle";
	
	
	public static final String C_CODE_MARQUE_ARTICLE = "codeMarqueArticle";
	public static final String C_COEFFICIENT = "coefficient";
	public static final String C_COEFFICIENT_PRIX_CALC = "coefficientPrixCalc";
	
	public static final String C_ID_STRIPE_PLAN = "idStripePlan";
	public static final String C_ID_EXTERNE_PLAN = "idExterne";
	public static final String C_NICKNAME_PLAN = "nickname";
	public static final String C_INTEVAL_PLAN = "interval";
	public static final String C_INTEVAL_COUNT_PLAN = "intervalCount";
	public static final String C_CURRENCY_PLAN = "currency";
	public static final String C_ACTIVE_PLAN = "active";
	public static final String C_AMOUNT_PLAN = "amount";
	public static final String C_TRIAL_PERIOD_DAYS_PLAN = "trialPrediodDays";
	// Inventaire
	public static final String C_LIBELLE_INVENTAIRE= "libelleInventaire";
	public static final String C_DATE_INVENTAIRE= "dateInventaire";
	public static final String C_CODE_INVENTAIRE= "codeInventaire";
	
	public static final String C_MESSAGE_CHANGEMENT_CODE="Attention, la modification d'un code est automatiquement répercutée\r\n"
			+ "partout où ce code est utilisé.";
	
	public static final String C_MESSAGE_FIN_EXPORTATION1="L'exportation est terminée.Elle s'est déroulée correctement." +
			" Le fichier se trouve à l'adresse suivante : ";
	public static final String C_MESSAGE_FIN_EXPORTATION2=" Vous pouvez le télécharger en cliquant sur le bouton 'Télécharger le fichier'";
	
	public static final String C_MESSAGE_SUPPRESSION_DOCUMENT="Etes-vous sur de vouloir supprimer le document ?";
	public static final String C_MESSAGE_MODIFIFCATION_DOCUMENT="Etes-vous sur de vouloir modifier le document ?";
	
	public static final String C_MESSAGE_SUPPRESSION_LIGNE_DOCUMENT="Etes-vous sur de vouloir supprimer la ligne courante ?";
	public static final String C_MESSAGE_MODIFIFCATION_LIGNE_DOCUMENT="Etes-vous sur de vouloir modifier la ligne courante ?";
	public static final String C_MESSAGE_TERMINER_LIGNE_DOCUMENT="Etes-vous sur de vouloir terminer la ligne courante ?";
	public static final String C_MESSAGE_REINTEGRER_LIGNE_DOCUMENT="Etes-vous sur de vouloir réintégrer la ligne courante ?";
	
	public static String C_CHOISIR="-Choisir-";
	
	public static  String C_TYPEADRESSEFACTURATION="FACT";
	public static  String C_TYPEADRESSELIVRAISON="LIV";
	
	public static  String C_TYPETELEPHONEBUREAU="B";
	public static  String C_TYPETELEPHONEPORTABLE="P";
	public static  String C_TYPETELEPHONEDOMICILE="D";
	
	public static  String C_TYPEEMAILBUREAU="B";
	public static  String C_TYPEEMAILPERSONNEL="P";

	
	public static final String OUVERTUREDIALOGUE = "ouvertureDialogue";
	
	public static final String PAR_TIERS="parTiers";
	public static final String PAR_ARTICLE="parArticle";
	public static final String PAR_FAMILLE_TIERS="parFamilleTiers";
	public static final String PAR_FAMILLE_ARTICLE="parFamilleArticle";
	public static final String PAR_TYPE_PAIEMENT="parTypePaiement";
	public static final String PAR_TAUX_TVA="parTauxTva";
	public static final String PAR_VENDEUR="parVendeur";
	public static final String PAR_ETAT="parEtat";
	
	public static final String C_SAISIE_SIMPLE="saisieSimple";
	public static final String C_SAISIE_DETAIL="saisieDetail";
	
	public static final String C_SAISIE_HT="saisieHt";
	public static final String C_SAISIE_TTC="saisieTtc";
	public static final String C_SAISIE_COEF="saisieCoefficient";
	
	public static final String C_DATE_PATTERN="dd/MM/yyyy";
	public static final String C_TIME_ZONE="Europe/Paris";
	
	public static final String C_GROUPE="groupe";

	
//	public static final int C_VALEUR_NB_DECIMALES_PRIX = 2;
//	public static final int C_VALEUR_NB_DECIMALES_QTE = 3;

	
	
//ejb
//    private static Map<String,IPreferenceStore> mapStore = null;

	public Const() {}
	
//ejb	
//	public static String pathRepertoireSpecifiques(String nomPlugin,String repertoire){
//		Bundle bundlePlugin = Platform.getBundle(nomPlugin);
//		if(bundlePlugin==null)return null;
//		URL urlFile;
//		try {
//		urlFile = FileLocator.find(bundlePlugin,new Path(repertoire),null);
//		urlFile = FileLocator.toFileURL(urlFile);
//		
//		URI uriFile = new URI("file", urlFile.getAuthority(),
//				urlFile.getPath(), urlFile.getQuery(), null);
//		File reportFile = new File(uriFile);
//		return reportFile.getAbsolutePath();
//		} catch (Exception e) {
//			//logger.error("",e);
//			return null;
//		}		
//	}

//private static IPreferenceStore store = null;

//ejb
//	static public IPreferenceStore getStore(String qualifier) {
//		if(mapStore==null) {
//			mapStore = new HashMap<String,IPreferenceStore>();
//		}
//		if(mapStore.get(qualifier)==null) {
//			ScopedPreferenceStore preferences = new ScopedPreferenceStore(Const.getProjectScopeContext(),qualifier);
//			preferences.setSearchContexts(new IScopeContext[]{Const.getProjectScopeContext(),new InstanceScope()});
//			mapStore.put(qualifier, preferences);
//		}
//		return mapStore.get(qualifier);
//	}
//
//	static public IScopeContext getProjectScopeContext() {
//		return projectScopeContext;
//	}
//
//	static public void setProjectScopeContext(IScopeContext projectScopeContext) {
//		Const.projectScopeContext = projectScopeContext;
//	}

	public static String getProjectName() {
		return projectName;
	}

	public static void setProjectName(String projectName) {
		Const.projectName = projectName;
	}
}
