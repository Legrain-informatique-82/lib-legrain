package fr.legrain.lib.data;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.joda.time.DateTime;

import fr.legrain.bdg.lib.osgi.Const;

import java.util.GregorianCalendar;

public class LibDate {
	
	private static long C_DATE_DEFAUT = 0;
	private static String mois;
	private static String jour;
	private static String annee;
	private static String heure;
	private static String minute;
	private static String seconde;
	private static String millis;
	
	
	static public Date getDateDefaut() {
		return new Date(C_DATE_DEFAUT);
	}
	
	static public Date getDateLGR(Date date) {
//		Calendar d =Calendar.getInstance();
//		d.setTime(date);
//		String newDate =String.valueOf(d.get(d.YEAR))+"/"+String.valueOf(d.get(d.MONTH)+1)+"/"+String.valueOf(d.get(d.DAY_OF_MONTH)); 
////		d.set(d.get(d.YEAR), d.get(d.MONTH), d.get(d.DAY_OF_MONTH),0,0,0);
////		return d.getTime();
		return getDateLGR(date,"/");
	}
	static public Date getDateLGR(Date date,String separateur) {
		Calendar d =Calendar.getInstance();

		d.setTime(date);
		
		String newDate =String.valueOf(d.get(Calendar.YEAR))+separateur+String.valueOf(d.get(Calendar.MONTH)+1)+separateur+String.valueOf(d.get(Calendar.DAY_OF_MONTH)); 
//		d.set(d.get(d.YEAR), d.get(d.MONTH), d.get(d.DAY_OF_MONTH),0,0,0);
//		return d.getTime();
		return new Date(newDate);
	}
	
	
	static public String DateToEdi(Date valeur ) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");		
		if (valeur !=null && valeur.after(new Date(0))) 
			return format.format(valeur);
		else return "";
		
	};

	/**
	 * 
	 * @param date
	 * @param anotherDate
	 * @return 0 si date égale, -1 si date < anotherDate et 
	 * 1 si date > anotherDate
	 */
	static public Integer quantieme(Date date){
		Calendar d =Calendar.getInstance();
		d.setTime(date);
		
		return d.get(Calendar.DAY_OF_YEAR);
		}
	static public int compareTo(Date date,Date anotherDate) {
    	int result = -1;
    	if(date==null) date = new Date();
    	if(anotherDate==null) anotherDate = new Date();
		Calendar d =Calendar.getInstance();
		d.setTime(date);
		Calendar d2 =Calendar.getInstance();
		d2.setTime( anotherDate);
//		System.out.println("Date : "+String.valueOf( d.get(Calendar.DATE)));
//		System.out.println("Date : "+String.valueOf( d.get(Calendar.MONTH)));
//		System.out.println("Date : "+String.valueOf( d.get(Calendar.DAY_OF_MONTH)));
//		System.out.println("Date : "+String.valueOf( d.get(Calendar.YEAR)));
		if(d.get(Calendar.YEAR)==d2.get(Calendar.YEAR)) {
			if(d.get(Calendar.DAY_OF_YEAR)==d2.get(Calendar.DAY_OF_YEAR))
				return 0;
			else if(d.get(Calendar.DAY_OF_YEAR)<d2.get(Calendar.DAY_OF_YEAR))
				return -1;
			else if(d.get(Calendar.DAY_OF_YEAR)>d2.get(Calendar.DAY_OF_YEAR)) return 1;
		} else 
			if(d.get(Calendar.YEAR)<d2.get(Calendar.YEAR)) {
				return -1;
			}else return 1;

		
		
		return result;
	}
	
	static public String customFormatDate(Date date) {
		if (date != null) {
		    DateFormat format = new SimpleDateFormat(Const.C_DATE_PATTERN);
		    TimeZone timeZone = TimeZone.getTimeZone(Const.C_TIME_ZONE);
		    format.setTimeZone(timeZone);
		    return format.format(date);
		 }
		return "";
	}

	static public int compareTo(String date,String anotherDate) {
		Date d1 = null;
		Date d2 = null;
		try {
			d1 = stringToDate(date);
			d2 = stringToDate(anotherDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return compareTo(d1, d2);
	}	
	
	static public int compareTo(String date,Date anotherDate) {
		Date d1 = null;
		try {
			d1 = stringToDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return compareTo(d1, anotherDate);
	}	
	
	
	
	static public int compareTo(Date date, String anotherDate) {
		Date d2 = null;
		try {
			d2 = stringToDate(anotherDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return compareTo(date, d2);
	}

	/**
	 * 
	 * @param d
	 * @param separateur
	 * @return jj/MM/aaaa
	 */
	static public String dateToString(Date d,String separateur) {
		if(d!=null) {
			Calendar date = Calendar.getInstance();
			date.setTime(d);
			//TODO Gestion des symbols
			jour=String.valueOf(date.get(Calendar.DAY_OF_MONTH));
			mois=String.valueOf(date.get(Calendar.MONTH)+1);
			annee=String.valueOf(date.get(Calendar.YEAR));
			
			while (mois.length()<2)
				mois="0"+mois;
			
			while (jour.length()<2)
				jour="0"+jour;
			while (annee.length()<4)
				annee="0"+annee;
	
			return jour+separateur+mois+separateur+annee;
		} else {
			return "";
		}
	}
	
	static public String dateToStringTimeStamp(Date d,String separateurDate,String separateurDateTime, String separateurTime) {
		Calendar date = Calendar.getInstance();
		date.setTime(d);
		
		String dateString = dateToString(d,separateurDate);
		heure=String.valueOf(date.get(Calendar.HOUR_OF_DAY));
		minute=String.valueOf(date.get(Calendar.MINUTE));
		seconde=String.valueOf(date.get(Calendar.SECOND));
		millis=String.valueOf(date.get(Calendar.MILLISECOND));
		
		//return dateString+separateurDateTime+heure+separateurTime+minute+separateurTime+seconde;
		return dateString+separateurDateTime+heure+separateurTime+minute+separateurTime+seconde+separateurTime+millis;
	}
	
	static public String dateToStringTimeStampSansMillis(Date d) {
		return dateToStringTimeStampSansMillis(d,"-"," ",":");
	}
	static public String dateToStringTimeStampSansMillis(Date d,String separateurDate,String separateurDateTime, String separateurTime) {
		Calendar date = Calendar.getInstance();
		date.setTime(d);
		
		String dateString = dateToString(d,separateurDate);
		heure=String.valueOf(date.get(Calendar.HOUR_OF_DAY));
		minute=String.valueOf(date.get(Calendar.MINUTE));
		seconde=String.valueOf(date.get(Calendar.SECOND));

		
		return dateString+separateurDateTime+heure+separateurTime+minute+separateurTime+seconde;
	}
	
	static public String dateToStringTimeStampSansSeconde(Date d,String separateurDate,String separateurDateTime, String separateurTime) {
		Calendar date = Calendar.getInstance();
		date.setTime(d);
		
		String dateString = dateToString(d,separateurDate);
		heure=String.valueOf(date.get(Calendar.HOUR_OF_DAY));
		minute=String.valueOf(date.get(Calendar.MINUTE));

		
		return dateString+separateurDateTime+heure+separateurTime+minute;
	}
	
	static public Date StringToDateTimeStamp(String d) {
		return StringToDateTimeStamp(d,"-"," ",":");
	}
	
	static public Date StringToDateTimeStamp(String d,String separateurDate,String separateurDateTime, String separateurTime) {
		SimpleDateFormat df = new SimpleDateFormat("dd"+separateurDate+"MM"+separateurDate+"yyyy"+separateurDateTime+"HH"+separateurTime+"mm"+separateurTime+"ss");	
		try {
			return new Date(df.parse(d).getTime());
		} catch (ParseException e) {
			return null;
		}
	}
	
	/**
	 * 
	 * @param d
	 * @param separateur
	 * @return jj/MM/aaaa
	 */
	static public String dateToString(Date d) {
		return dateToString(d,"/");
	}
	/**
	 * 
	 * @param d
	 * @return jj/MM/aaaa
	 */
	static public String dateToStringAA(Date d) {
		if(d!=null){
		String[] res = dateToString(d).split("/");
		res[2] = res[2].substring(2,4);
		return res[0]+"/"+res[1]+"/"+res[2];
		}
		return null;
	}
	

	static public String dateToStringSql(Date d) {
		Calendar date =Calendar.getInstance();
		date.setTime(d);
		
		jour=String.valueOf(date.get(Calendar.DAY_OF_MONTH));
		mois=String.valueOf(date.get(Calendar.MONTH)+1);
		annee=String.valueOf(date.get(Calendar.YEAR));
		
		while (mois.length()<2)
			mois="0"+mois;
		
		while (jour.length()<2)
			jour="0"+jour;
		
		return annee+"/"+mois+"/"+jour;
	}
	
	static public String StringDateToStringSql(String dateValeur, Date defaut) throws ParseException {
			String jourLoc,moisLoc,anneeLoc;
			String dateTmp;
			String[] part,tmp;
			if(dateValeur!=null && !dateValeur.equals("")) {
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				df.setCalendar(Calendar.getInstance());
				df.getCalendar().setTime(defaut);
				
				part = dateValeur.split("/"); 
				jourLoc="";
				moisLoc="";
				anneeLoc="";
				if (part.length>0) jourLoc=part[0];
				if (part.length>1) moisLoc=part[1];
				if (part.length>2) anneeLoc=part[2];
				
				tmp=dateToString(defaut).split("/");
				jourLoc=jourLoc.replaceAll("-","");
				moisLoc=moisLoc.replaceAll("-","");
				anneeLoc=anneeLoc.replaceAll("-","");
				if (jourLoc.equals("") || jourLoc.equals("0")){
					jourLoc =tmp[0]; 
				}
				if (moisLoc.equals("")|| moisLoc.equals("0")){
					moisLoc = tmp[1];
				}
				if (anneeLoc.equals("")|| anneeLoc.equals("0")){
					anneeLoc = tmp[2];
				}
				while (moisLoc.length()<2)
					moisLoc="0"+moisLoc;
				
				while (jourLoc.length()<2)
					jourLoc="0"+jourLoc;
				
				while (anneeLoc.length()<4)
					if (anneeLoc.length()<2)
					anneeLoc="0"+anneeLoc;
					else if (anneeLoc.length()<3)
						anneeLoc="0"+anneeLoc;
						else anneeLoc="2"+anneeLoc;

					dateTmp = moisLoc+"/"+jourLoc+"/"+anneeLoc;
			} else {
				dateTmp = dateToString(defaut);
			}
			return dateTmp;
		}

	
	static public Date stringToDate(String date) throws ParseException {
		return stringToDate(date,new Date());
	}
	
	static public Date stringToDate2(String date)  {
		try {
			return stringToDate(date,new Date());
		} catch (ParseException e) {
			return new Date();
		}
	}
	static public Date stringToDate_old(String date) throws ParseException {
		return stringToDate_old(date,new Date());
	}
	
	static public Date stringToDate_old(String date, Date defaut) throws ParseException {
		if(date!=null && !date.equals("")) {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy  ");

			return new Date(df.parse(date).getTime());
		} else {
			return defaut;
		}
	}
	static public Date stringToDateNew(String date){
		//DateFormat df = DateFormat.getDateInstance( DateFormat.FULL , Locale.FRANCE );	
		try {
			return LibDate.stringToDate(date.replace(".", "/"));
		} catch (ParseException e) {
			return null;
		}
	}
	
	static public Date stringToDate(String dateValeur, Date defaut) throws ParseException {
		String jourLoc,moisLoc,anneeLoc;
		Date dateTmp;
		String[] part,tmp;
		if(dateValeur!=null && !dateValeur.equals("")) {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			df.setCalendar(Calendar.getInstance());
			df.getCalendar().setTime(defaut);
			
			part = dateValeur.split("/"); 
			jourLoc="";
			moisLoc="";
			anneeLoc="";
			if (part.length>0) jourLoc=part[0];
			if (part.length>1) moisLoc=part[1];
			if (part.length>2) anneeLoc=part[2];
			
			tmp=dateToString(defaut).split("/");
			jourLoc=jourLoc.replaceAll("-","");
			moisLoc=moisLoc.replaceAll("-","");
			anneeLoc=anneeLoc.replaceAll("-","");
			if (jourLoc.equals("") || jourLoc.equals("0")){
				jourLoc =tmp[0]; 
			}
			if (moisLoc.equals("")|| moisLoc.equals("0")){
				moisLoc = tmp[1];
			}
			if (anneeLoc.equals("")|| anneeLoc.equals("0")){
				anneeLoc = tmp[2];
			}
			while (moisLoc.length()<2)
				moisLoc="0"+moisLoc;
			
			while (jourLoc.length()<2)
				jourLoc="0"+jourLoc;
			
			while (anneeLoc.length()<4)
				if (anneeLoc.length()<2)
				anneeLoc="0"+anneeLoc;
				else if (anneeLoc.length()<3)
					anneeLoc="0"+anneeLoc;
					else anneeLoc="2"+anneeLoc;

				dateTmp = new Date(df.parse(jourLoc+"/"+moisLoc+"/"+anneeLoc).getTime());
		} else {
			dateTmp = defaut;
		}
		return dateTmp;
	}

//	static public Date stringToDate(String dateValeur, Date defaut) throws ParseException {
//		Calendar d =Calendar.getInstance();
//		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");		
//		d.setTime(new Date(dateValeur));
//		return  df.parse(d.get(d.DATE)+"/"+d.get(d.MONTH)+"/"+ d.get(d.YEAR));
//	}
	
	
	static public Date stringToDateSql(String date) throws ParseException {
		return stringToDateSql(date,new Date(C_DATE_DEFAUT));
	}
	static public Date stringToDateSql(String date, Date defaut) throws ParseException {
		if(date!=null && !date.equals("")) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			return new Date(df.parse(date).getTime());
		} else {
			return defaut;
		}
	}
	
	
	public static String getAnnee(Date d) {
		Calendar date =Calendar.getInstance();
		date.setTime(d);
		annee=String.valueOf(date.get(Calendar.YEAR));
		return annee;
	}
	
	public static String getCodeAnnee(Date d) {
		Calendar date =Calendar.getInstance();
		date.setTime(d);
		annee=String.valueOf(date.get(Calendar.YEAR));
		
		return annee.substring(2);
	}
	
	public static String getMois(Date d) {
		Calendar date =Calendar.getInstance();
		date.setTime(d);
		mois=String.valueOf(date.get(Calendar.MONTH)+1);		
		while (mois.length()<2)
			mois="0"+mois;
		return mois;
	}

	public static String getJour(Date d) {
		Calendar date =Calendar.getInstance();
		date.setTime(d);
		jour=String.valueOf(date.get(Calendar.DAY_OF_MONTH));		
		while (jour.length()<2)
			jour="0"+jour;
		return jour;
	}


	public static String getHeure(Date d) {
		Calendar date =Calendar.getInstance();
		date.setTime(d);
		heure=String.valueOf(date.get(Calendar.HOUR_OF_DAY));
		return heure;
	}
	
	public static String getHeureSeule(Date d) {
		Calendar date =Calendar.getInstance();
		date.setTime(d);
		heure=String.valueOf(date.get(Calendar.HOUR));
		return heure;
	}
	public static String getMinute(Date d) {
		Calendar date =Calendar.getInstance();
		date.setTime(d);
		minute=String.valueOf(date.get(Calendar.MINUTE));
		return minute;
	}


	public static String getSeconde(Date d) {
		Calendar date =Calendar.getInstance();
		date.setTime(d);
		seconde=String.valueOf(date.get(Calendar.SECOND));
		return seconde;
	}
	
	public static String getMilliseconde(Date d) {
		Calendar date =Calendar.getInstance();
		date.setTime(d);
		millis=String.valueOf(date.get(Calendar.MILLISECOND));
		return millis;
	}
	
	
	public static Date incrementDate(Date date,int incJour,int incMois,int incAnnee){
		Calendar dateTmp =Calendar.getInstance();
		dateTmp.setTime(date);
		
		dateTmp.add(Calendar.DATE, incJour);		  
		dateTmp.add(Calendar.MONTH, incMois);
		dateTmp.add(Calendar.YEAR, incAnnee);
		
		
		int jour=LibConversion.stringToInteger(LibDate.getJour(dateTmp.getTime()));
		int mois=LibConversion.stringToInteger(LibDate.getMois(dateTmp.getTime()));
		int annee=LibConversion.stringToInteger(LibDate.getAnnee(dateTmp.getTime()));
//		int jour=dateTmp.get(Calendar.DATE);
//		int mois=dateTmp.get(Calendar.MONTH);
//		int annee=dateTmp.get(Calendar.YEAR);
		
		String dateTemp =LibConversion.integerToString(mois)+"/"
		  +LibConversion.integerToString(jour)+"/"+LibConversion.integerToString(annee);

		return new Date(dateTemp);
	}

	public static Date DernierJourMoisPrecedent(Date maDate){
	Calendar c = Calendar.getInstance();
	 
	// on se place à la date utilisée comme base de calcul
	c.setTime(maDate);
	 
	// on se place au premier jour du mois en cours
	c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
	Date debutMois = c.getTime();
	 
	// premier jour du mois en cours moins un jour = dernier jour du mois précédent
	c.add(Calendar.DAY_OF_MONTH, -1);

	return c.getTime();
}

	public static Date PremierJourMoisSuivant(Date maDate){
		Calendar c = Calendar.getInstance();
		 
		// on se place à la date utilisée comme base de calcul
		c.setTime(maDate);
		 
		// on se place au premier jour du mois en cours
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		c.add(Calendar.DAY_OF_MONTH, 1);

		return c.getTime();
	}
	
	public static Date PremierJourMois(Date maDate){
		Calendar c = Calendar.getInstance();
		 
		// on se place à la date utilisée comme base de calcul
		c.setTime(maDate);
		 
		// on se place au premier jour du mois en cours
		c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));		 

		return c.getTime();
	}
	
	public static Date DernierJourMois(Date maDate){
		Calendar c = Calendar.getInstance();
		 
		// on se place à la date utilisée comme base de calcul
		c.setTime(maDate);
		 
		// on se place au premier jour du mois en cours
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));		 

		return c.getTime();
	}
	public static Integer nbMois(Date date1, Date date2){
//		Integer retour=0;
//		Boolean negatif=false;
//		Date dateTmp=null;
//		negatif=date2.after(date1);
//		if(negatif){
//			dateTmp=date1;
//			while (dateTmp.before(date2)){
//				dateTmp=incrementDate(dateTmp, 0, 1, 0);
//				retour++;
//			}
//		}else{
//			dateTmp=date2;
//			while (dateTmp.before(date1)){
//				dateTmp=incrementDate(dateTmp, 0, 1, 0);
//				retour++;
//			}
//		}
		return nbMonthBetween2Dates(date1, date2);
	}
	

	public static int nbJoursBetween2Dates(Date date1, Date date2) {
		Calendar dateTmp1 =Calendar.getInstance();
		dateTmp1.setTime(date1);
		Calendar dateTmp2 =Calendar.getInstance();
		dateTmp2.setTime(date2);
		

        int gap = 0;
        dateTmp1.add(Calendar.DAY_OF_YEAR, 1);
        while(dateTmp1.compareTo(dateTmp2)<=0) {
            gap++;
            dateTmp1.add(Calendar.DAY_OF_YEAR, 1);
        }
        
        
        return gap;
    }	
	public static int nbMonthBetween2Dates(Date date1, Date date2) {
		Calendar dateTmp1 =Calendar.getInstance();
		dateTmp1.setTime(date1);
		Calendar dateTmp2 =Calendar.getInstance();
		dateTmp2.setTime(date2);
		

        int gap = 0;
        dateTmp1.add(Calendar.MONTH, 1);
        while(dateTmp1.compareTo(dateTmp2)<=0) {
            gap++;
            dateTmp1.add(Calendar.MONTH, 1);
        }
        return gap;
    }
	public static List<InfosMois> listeMoisEntreDeuxDate(Date datedeb, Date datefin)
	{
//		SimpleDateFormat.("MMM").format(format, args);
		Calendar mCalendar = Calendar.getInstance();
		if (datedeb == null)  {
			datedeb = (mCalendar.getTime());
		}
		if (datefin == null)  {
			datefin = (mCalendar.getTime());
		}
		int nbMois = nbMonthBetween2Dates(datedeb, datefin);
		
		//Date ldatedeb = new Date();
		
		List<InfosMois> listeInfoMois = new ArrayList<InfosMois>();
		for (int i = 0; i <= nbMois; i++) {
			mCalendar.setTime(datedeb);
			InfosMois infomois = new InfosMois();
//			String month = mCalendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
			infomois.setNomLong(mCalendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()));
			infomois.setNomCourt(mCalendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault()));
			infomois.setIndex(i);
			infomois.setAnnee(getAnnee(datedeb));
			infomois.setMois(getMois(datedeb));
			infomois.setCodeMoisAnnee(getMois(datedeb) + getAnnee(datedeb));
			if (i==0){
				infomois.setPremierJourMois(datedeb);
			} else {
				infomois.setPremierJourMois(PremierJourMois(datedeb));
			}
			if (i==nbMois){
				infomois.setDernierJourMois(datefin);
			}
			else {
				infomois.setDernierJourMois(DernierJourMois(datedeb));
			}
			datedeb = PremierJourMoisSuivant(datedeb);
			listeInfoMois.add(infomois);
		}
		return listeInfoMois;
		
	}
	public static String moisStringPourMoisInt(int num) {
        String month = "erreur";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11 ) {
            month = months[num];
        }
        return month;
    }
	public static List<InfosJours> listeJoursEntreDeuxDate(Date debutDePeriode, Date finDePeriode)
	{
		Calendar mCalendar = Calendar.getInstance();
		Calendar mCalDebutPeriode = Calendar.getInstance();
		mCalDebutPeriode.setTime(debutDePeriode);
		Calendar mCalFinPeriode = Calendar.getInstance();
		mCalFinPeriode.setTime(finDePeriode);
		
		int	debPeriode = mCalDebutPeriode.get(Calendar.DAY_OF_MONTH);
		int finPeriode = mCalFinPeriode.get(Calendar.DAY_OF_MONTH);
		
		if (debutDePeriode == null)  {
			debutDePeriode = (mCalendar.getTime());
		}
		if (finDePeriode == null)  {
			finDePeriode = (mCalendar.getTime());
		}
		int nbJour = nbJoursBetween2Dates(debutDePeriode, finDePeriode);
		
		Date encours = debutDePeriode;
		
		List<InfosJours> listeInfoJours = new ArrayList<InfosJours>();
		
		for (int j = 0; j <= nbJour; j++) {
//		for (int j = debPeriode; j <= finPeriode; j++) {

			mCalendar.setTime(encours);
			 InfosJours infojours = new InfosJours();
			
			 infojours.setIndex(j);
//			 infojours.setNumeroJour(j+debPeriode);
			 infojours.setNomCourt(mCalendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault()));
			 infojours.setNomLong(mCalendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()));
			 infojours.setCodeJourMoisAnnee((getJour(encours)+getMois(encours)+getAnnee(encours)));
			 infojours.setCodeJour(getJour(encours));
			 infojours.setCodeMois(getMois(encours));
			 infojours.setCodeAnnee(getAnnee(encours));
			 infojours.setDateDuJour(encours);
			 listeInfoJours.add(infojours);
			 mCalendar.add(Calendar.DATE, 1);
			 encours = mCalendar.getTime();
			 
		}
				
		return listeInfoJours;
		
	}
	
	public static String gregorianCalendar(String date){
		
		GregorianCalendar dateGreg = new GregorianCalendar();
		 
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date dateDate = dateGreg.getTime();
		 
		String retour = dateFormat.format(dateDate);
		
		return retour;
	}

	public static Date dateDuJour(){
		return new Date();
	}
	
//	Créer le 06/09/2017 Jean Marc méthode permettant de récuperer le nombre de jour du mois et de l'année passer en parametre
	public static int numberOfDaysInMonth(int month, int year) {
	    Calendar monthStart = new GregorianCalendar(year, month, 0);
	    return monthStart.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	public static LocalDateTime dateToLocalDateTime(Date date) {
		LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		return localDateTime;
	}
	
	
	public static Date localDateTimeToDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}
	
	public static LocalDate dateToLocalDate(Date date) {
		LocalDate localDate = LibDate.dateToLocalDateTime(new Date(date.getTime())).toLocalDate();
		return localDate;
	}
	
	
	public static Date localDateToDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay()
			      .atZone(ZoneId.systemDefault())
			      .toInstant());
	}
	
}



