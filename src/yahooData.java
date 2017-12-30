

	import java.io.*;
	
	import java.net.*;
	public class yahooData {
		private String mSymbol;
		private String mDirectory;
		private Date mStartDate, mEndDate;
		private String mFileName;
		//constructors
		public yahooData(){
			mSymbol = " ";
			mDirectory = "./";
			mStartDate = new Date("0/0/0");
			mEndDate = new Date("0/0/0");
			mFileName = mDirectory + mSymbol + ".csv";
		}
		public yahooData(String s, String d, Date st, Date end){
			mSymbol = s;
			mDirectory = d;
			mStartDate = new Date(st);
			mEndDate = new Date(end);
			mFileName = mDirectory + mSymbol + ".csv";
		}
		public yahooData(String s, String d, String sta, String end){
			mSymbol = s;
			mDirectory = d;
			mStartDate = new Date(sta);
			mEndDate = new Date(end);
			mFileName = mDirectory + mSymbol + ".csv";
		}
		public yahooData(String s, String d, String f, Date st, Date end){
			mSymbol = s;
			mDirectory = d;
			mStartDate = new Date(st);
			mEndDate = new Date(end);
			mFileName = mDirectory + f;
		}
		//public yahooData(yahooData newOb) {
	
		// TODO Auto-generated constructor stub
		//}
		//load the data from yahoo//////http://chart.finance.yahoo.com/table.csv?s=^IXIC&a=3&b=1&c=2017&d=3&e=19&f=2017&g=d&ignore=.csv
		//The re is a class File is to manipulate files, creation deletion moving etc..
		//fileReader allows you to read character by character from a file, or an array of characters
		//bufferreader allows you to read a line from fileReader
		public boolean load() {
			//create a URL a string 
			String strUrl = "http://chart.finance.yahoo.com/table.csv?s=";
			strUrl += mSymbol + "&a=" + (mStartDate.getMonth()-1) + "&b=" + 
					+ mStartDate.getDay() + "&c="+mStartDate.getYear();
			strUrl += "&d=" + (mEndDate.getMonth() -1) + "&e=" + 
					+ mEndDate.getDay() + "&f="+mEndDate.getYear();
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
				//read line by line and store them in a file mFileName
				//create an output file 
				/*//if you want to verify if the file exists
				File outputFile = new File(mFileName);
				if (outputFile.exists()) {
					System.out.println("File exists! Do you want to override it [y/n]? :");
					Scanner sc = new Scanner(System.in);
					char ans = sc.nextLine().charAt(0);
					if (ans == 'n' || ans == 'N') {
						return true;
					}
				}*/
				FileWriter outFile = new FileWriter(mFileName);
				BufferedWriter bOut = new BufferedWriter(outFile);
				//now we need a loop to go throu input line by lie and store them in outFile
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
		}
		
		 

		//accessors
		public String getSymbol() {
			return mSymbol;
		}
		public String getDirectory() {
			return mDirectory;
		}
		public Date getStartDate() {
			return mStartDate;
		}
		public Date getEndDate() {
			return mEndDate;
		}
		public String getFileName() {
			return mFileName;
		}
		//mutators
		public void setSymbol(String s) {
			mSymbol = s;
		}
		public void setDirectory(String d){
			mDirectory = d;
		}
		public void setStartDate(Date d) {
			mStartDate = new Date(d);
		}
		public void setEndDate(Date d) {
			mEndDate = new Date(d);
		}
		public void setFileName(String f){
			mFileName = f;
		}
		public void setData(String s, String d, Date st, Date end){
			mSymbol = s;
			mDirectory = d;
			mStartDate = new Date(st);
			mEndDate = new Date(end);
			mFileName = mDirectory + mSymbol + ".csv";
		}
		public void setData(String s, String d, String f, Date st, Date end){
			mSymbol = s;
			mDirectory = d;
			mStartDate = new Date(st);
			mEndDate = new Date(end);
			mFileName = mDirectory + f;
		}
	
	
	
	
	
	
		//public static void main(String[] args) {
		//	yahooData A=new yahooData ("IBM","C:/profOma/Data/","05/08/2016", "05/08/2017");
		//A.load() ;
			
		//}
	}

