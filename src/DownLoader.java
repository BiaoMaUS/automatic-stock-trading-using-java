
import java.io.*;
public class DownLoader extends yahooData {
	private String mFileName;
	private BufferedReader buf;
	private FileReader fr;
	
	//constructor 
	public DownLoader(String f, String D, String start, String last){
		super("unknown", D, start, last);
		mFileName = f;
	}
	//accessors
	public String getmFileName() {
		return mFileName;
	}
	//mutators
	public void setmFileName(String mFileName) {
		this.mFileName = mFileName;
	}
	//method Download all
	public boolean loadAll() {
		//open the symbol file
		try {
			fr = new FileReader(mFileName);
			buf = new BufferedReader(fr);
			//read one symbol at a time and download it 
			String symbol;
			while((symbol = buf.readLine()) != null) {
				//change the symbol to current symbol and the output file as well
				//just call setSymbol on yahooData
				this.setSymbol(symbol);
				if (!this.load()) {
					System.out.println("Unable to load " + symbol);
					return false;
				}
			}
			buf.close();
			fr.close();
		}catch(IOException e) {
			System.out.println("Message : " + e.getMessage());
		}
		return true;
	}
}












/*import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.*;
public class DownLoader {
	private static BufferedReader buf;
	private static FileReader fr;
	
		private String fileNameT;
		//private yahooData object;
		private Date startDate;
		private Date endDate;
		private String Directory;
		//String endFileName;
		
	public DownLoader(){
		fileNameT=" ";
		//object=new yahooData();
		startDate=new Date();
		endDate=new Date();
		Directory=" ./";
		//endFileName=Directory+fileName+"Daily.cvs";
	}
	public DownLoader(String newFN,String SD,String ED,String DT){
		fileNameT=newFN;
		//object=new yahooData(newOb);
		startDate=new Date(SD);
		endDate=new Date(ED);
		Directory=DT;	
		//endFileName=DT+newFN+"Daily.cvs";
	}
	
	public void setDownLoader(String fileNameT,yahooData object,Date  startDate,Date endDate,String Directory){
		this.fileNameT=fileNameT;
		//this.object=new yahooData(object);
		this.startDate=new Date(startDate);
		this.endDate=new Date(endDate);
		this.Directory=Directory;
	}
	public void setFileNameT(String FileNameT){
		this.fileNameT=FileNameT;
	}
	//public void setYahooData(yahooData object){
	//	this.object=new yahooData(object);
	//}
	public String getFileNameT(){
		return fileNameT;
	}
	public String getDirectory(){
		return Directory;
	}
	//public yahooData getObject(){
	//	return object;
	//}
	public Date getStartDate(){
		return startDate;
	}
	public Date getEndDate(){
		return endDate;
	}
	
	 public boolean loadAll(){
		 try {
				fr = new FileReader(fileNameT);
				buf = new BufferedReader(fr);
				//read one symbol at a time and download it 
				String sc;
				while((sc = buf.readLine()) != null) {
					//change the symbol to current symbol and the output file as well
					//just call setSymbol on yahooData
					 yahooData object=new yahooData(sc,Directory,startDate,endDate);
			//		DownLoader B=new DownLoader("C:/ProfOmar/New folder/stock.txt",Y,"01/01/2015", "12/31/2016","C:/ProfOmar/Data/");
					object.load();
					if (!object.load()) {
						System.out.println("Unable to load " + sc);
					return false;
					}
				}
				buf.close();
				fr.close();
			}catch(IOException e) {
				System.out.println("Message : " + e.getMessage());
			}
			return true;
		}
		
		/* String strUrl = "http://chart.finance.yahoo.com/table.csv?s=";
			strUrl += object.getSymbol() + "&a=" + (startDate.getMonth()-1) + "&b=" + 
					+ startDate.getDay() + "&c="+startDate.getYear();
			strUrl += "&d=" + (endDate.getMonth() -1) + "&e=" + 
					+ endDate.getDay() + "&f="+endDate.getYear();
			strUrl += "&g=d&ignore=.csv";
			//System.out.println(strUrl);
			try {
				//create a URL object and connect to yahoo
				URL urlYahoo = new URL(strUrl);
				//open the connection
				URLConnection urlConn = urlYahoo.openConnection();
				//get the data from yahoo
				InputStream inSt = urlConn.getInputStream();
				//read the data
				InputStreamReader inStream = new InputStreamReader(inSt);
				BufferedReader buf = new BufferedReader(inStream);
				
				FileWriter outFile = new FileWriter(object.getSymbol()+object.getDirectory()+"_Daily.cvs");
				BufferedWriter bOut = new BufferedWriter(outFile);
				//now we need a loop to go throu input line by lie and store them ine outFile
				String lineStr; 
				while((lineStr = buf.readLine()) != null){
					bOut.write(lineStr+"\n");
				}
				bOut.close();
			
			}catch(MalformedURLException e ) {
				System.out.println("Exception: " + e.getMessage());
				return false;
			}catch (IOException e) { //for exception from file handling
				System.out.println("Exception: " + e.getMessage());
				return false;
			}
			return true;
			*/
		
		

     
	//public static void main(String[] args) {
	//DownLoader B=new DownLoader("C:/ProfOmar/stocks.txt","01/01/2015", "12/31/2016","C:/ProfOmar/newnewData/");
	//	B.loadAll();
	//DownLoader A=new DownLoader();
	
	//A.setFileNameT("C:/ProfOmar/New folder/stock.txt");
	//String H=A.getFileNameT();
	
	//Scanner inputStream=null;
	
	
	
	/*try {
		fr = new FileReader("C:/ProfOmar/New folder/stock.txt");
		buf = new BufferedReader(fr);
		//read one symbol at a time and download it 
		String sc;
		while((sc = buf.readLine()) != null) {
			//change the symbol to current symbol and the output file as well
			//just call setSymbol on yahooData
			yahooData Y=new yahooData(sc,"C:/ProfOmar/Data/", "01/01/2015", "12/31/2016");
	//		DownLoader B=new DownLoader("C:/ProfOmar/New folder/stock.txt",Y,"01/01/2015", "12/31/2016","C:/ProfOmar/Data/");
			Y.load();
			if (!Y.load()) {
				System.out.println("Unable to load " + sc);
//				return false;
			}
		}
		buf.close();
		fr.close();
	}catch(IOException e) {
		System.out.println("Message : " + e.getMessage());
	}
	//return true;
}

}
*/


