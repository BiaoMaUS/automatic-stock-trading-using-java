
import java.io.BufferedReader;
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
//public class yahooTester {
	//public static void main(String[] args) {
		//create yahooData object 
		//DownLoader dl = new DownLoader("C:/ProfOmar/stocks.txt", "C:/ProfOmar/newnewData", 
		//		"04/01/2017", "04/18/2017");
		//dl.loadAll();
		//System.out.println("hi");
//	}
//}
		public class yahooTester {
			public static void main(String[] args) {
				//create yahooData object 
				DownLoader dl = new DownLoader("C:/ProfOmar/stocks.txt","C:/ProfOmar/Data/", 
						"01/01/2006", "12/31/2016");
				dl.loadAll();
			}
		}