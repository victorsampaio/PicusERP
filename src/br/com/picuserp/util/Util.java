package br.com.picuserp.util;

/**
 * @author Victor Sampaio
 *
 */

import java.sql.DriverManager;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import br.com.picuserp.constants.Constants;

import java.sql.Connection;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


public class Util {

	public Date formataDateTime(String date) {
		Calendar calendarDate= Calendar.getInstance();
		int year,month,day;
		year=month=day=0;
		if (!date.equalsIgnoreCase("")){
			day = Integer.parseInt(date.substring(0,2));
			month = Integer.parseInt(date.substring(2,4));	
			year = Integer.parseInt(date.substring(4,8));	
		}
		calendarDate.set(Calendar.YEAR,year);
		calendarDate.set(Calendar.MONTH,month-1);
		calendarDate.set(Calendar.DAY_OF_MONTH,day);
		return calendarDate.getTime();	
	}
	
	public static String getDscMes(Date date) {
		String returnMonth = new String();
		int month = Integer.parseInt(Util.getDataMM(date));
		switch(month) {	 
        	case 1:
	 	 		returnMonth = "Janeiro";
	 	 		break;
        	case 2:
	    	    returnMonth = "Fevereiro";
	 	 		break;
        	case 3:
	    	    returnMonth = "Mar�o";
	 	 		break;
        	case 4:
	    	    returnMonth = "Abril";
	 	 		break;
        	case 5:
	    	    returnMonth = "Maio";
	 	 		break;
        	case 6:
	    	    returnMonth = "Junho";
	 	 		break;
        	case 7:
	    	    returnMonth = "Julho";
	 	 		break;
        	case 8:
	    	    returnMonth = "Agosto";
	 	 		break;
        	case 9:
	    	    returnMonth = "Setembro";
	 	 		break;
        	case 10:
	    	    returnMonth = "Outubro";
	 	 		break;
        	case 11:
	      	    returnMonth = "Novembro";
	 	 		break;
        	case 12:
	    	    returnMonth = "Dezembro";
	 	 		break;
		}
		return  returnMonth ;
      }
	
	public static String getDayOfTheWeek(Date date){
		String returnDayOfTheWeek = null;
		Calendar dateInicial = Calendar.getInstance();
		int dia=0;
		dateInicial.setTime(date);
		dia = dateInicial.get(Calendar.DAY_OF_WEEK);
		switch(dia) {	 
    		case 1:
    			returnDayOfTheWeek = "Domingo";
    			break;
    		case 2:
    			returnDayOfTheWeek = "Segunda-Feira";
    			break;
    		case 3:
    			returnDayOfTheWeek = "Ter�a-Feira";
    			break;
    		case 4:
    			returnDayOfTheWeek = "Quarta-Feira";
    			break;
    		case 5:
    			returnDayOfTheWeek = "Quinta-Feira";
    			break;
    		case 6:
    			returnDayOfTheWeek = "Sexta-Feira";
    			break;
    		case 7:
    			returnDayOfTheWeek = "Sabado";
    			break;
		} 

		return returnDayOfTheWeek;
	}
	
	 	 	 
	 public static String getDatayyyy(java.util.Date date) {
		 SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy");
		 return date!= null ? simpleDate.format(date) : "";
	 } 
	 public static String getDataMM(java.util.Date date) {
		 SimpleDateFormat simpleDate = new SimpleDateFormat("MM");
		 return date!= null ? simpleDate.format(date) : "";
	 } 
	 public static String getDatadd(java.util.Date date) {
		 SimpleDateFormat simpleDate = new SimpleDateFormat("dd");
		 return date!= null ? simpleDate.format(date) : "";
	 } 
	
	 public static String simpleDateToString(java.util.Date date) {
		 SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		 return date!= null ? simpleDate.format(date) : "";
	 }
	 
	 public static String getDatayyyymmdd(java.util.Date date) {
		 SimpleDateFormat simpleDate = new SimpleDateFormat("yyyyMMdd");
		 return date!= null ? simpleDate.format(date) : "";
	 }
	 
	 public static String coinDecimalFormat(float v) {
			DecimalFormat coin = new DecimalFormat("#,##0.00");    
			return coin.format(v);
		}
		public static String coinFormat(double v) {
			DecimalFormat coin = new DecimalFormat("#,##0.00");    
			return coin.format(v);
		}
	 	 	/**
	 	 	 * This method is responsible for generate to Reports
	 	 	 * - Este metodo é responsavel por gerar de relatorios  
	 	 	 * */ 
	public String generateReport(String reportName, HashMap paramRel, List listaRel){
		   String returnReport = null;
		   FacesContext context = FacesContext.getCurrentInstance();   
		   HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse(); 
		   ServletContext sc = (ServletContext) context.getExternalContext().getContext();   
		   String relPath = sc.getRealPath("/");  
	       String imageLogo = relPath+ "recursos/imagem/logo_mmo.jpg";
	       paramRel.put("imagemLogo", imageLogo);
		   paramRel.put("nmSistema", Constants.SYSTEM_NAME);
		   paramRel.put("REPORT_LOCALE", new Locale("pt", "BR"));
		   try  {
			   JasperPrint print = null;
			   if (listaRel != null){
				   JRBeanCollectionDataSource rel = new JRBeanCollectionDataSource(listaRel);
				   print = JasperFillManager.fillReport(relPath + "relatorios/"+reportName+".jasper", paramRel,rel);				   
			   } else {
				   Class.forName("org.postgresql.Driver");
					String url = "jdbc:postgresql://localhost:5432/PICUSERP";
					String user = "root";
					String pass = "victor";
					Connection connection = DriverManager.getConnection(url, user,
							pass);
				    print = JasperFillManager.fillReport(relPath + "relatorios/"+reportName+".jasper", paramRel,connection);
				  
			   }
			   byte[] bytes = JasperExportManager.exportReportToPdf(print);			  
			   // Exibe o relatorio no formato PDF
			   /**
			    *  Show report in pdf format
			    **/
			   response.setContentType("application/pdf");
			   response.setContentLength(bytes.length);
			   ServletOutputStream ouputStream = response.getOutputStream();
			   ouputStream.write(bytes, 0, bytes.length);
			   ouputStream.flush();
			   ouputStream.close();
			   FacesContext.getCurrentInstance().responseComplete(); 
			} catch (Exception e) { 
				//String texterro = e.toString();
				returnReport = e.toString();
				System.out.println(e.toString()); 
			} 
		return returnReport;
		}
	
	public static boolean hasValue(String str)
	{
		if (str != null && !str.trim().equals(""))
			return true;

		return false;
	}
 
	public static boolean hasValue(Object obj)
	{
		if (obj != null)
			return true;

		return false;
	}	
	
	//calcularDiasCorridos
	public long convertSequentialDays(Date initial, Date finish)
	{
		Calendar initialDate = Calendar.getInstance();
		Calendar finishDate = Calendar.getInstance();
		long hours = 0;
		// dataInicio.set(anoI, mesI, diaI, horaI, minI);
		// dataFim.set(anoF, mesF, diaF, horaF, minF);
		initialDate.setTime(initial);
		finishDate.setTime(finish);
		hours = finishDate.getTimeInMillis() - initialDate.getTimeInMillis();
		// milisegundos para segundos e segundos para
		/**
		 * Milisecond to seconds and seconds to minutes
		 **/
		hours = hours / 1000 / 60; 
		hours = hours / 60; 
		// minuto para hora
		/**
		 * Minute to hour 
		 **/
		long days = hours / 24;
		days = Math.round(days);

		return days;
	}

}
