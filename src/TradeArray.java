/*import java.util.Vector;
import java.io.*;
class TradeArray {
	private Vector<Trade> vec;
	TradeArray(){
		vec=new Vector<Trade>(5000);
	}
	TradeArray(int size){
		vec=new Vector<Trade>(size);
	}
	public void setVec(Trade Nvec){
		vec.add(Nvec);
	}
	public Vector<Trade> getVec(){
		return vec;
	}
	public boolean insert(Trade x){
		return vec.add(x);
	}
	public boolean remove(Trade x){
		return vec.remove(x);
		
	}
	public void stats(String TfileName){
		BufferedWriter bufferedWriter=null;
		try{
			bufferedWriter=new BufferedWriter(new FileWriter(TfileName));
		
		for(int i=0;i<vec.size(); i++){
			Trade tem=new Trade();
			tem=vec.get(i);
			Date temD=new Date();
			temD=tem.getEntryDate();
			Date temE=new Date();
			temE=tem.getExitDate();
			Float temve=tem.getEntryPrice();
			Float temvx=tem.getexitPrice();
			Float temvs=tem.getStopLoss();
			Float temvt=tem.getTarget();
			bufferedWriter.write(temD.toString()+temE.toString()+tem.getDirection()+temve.toString()+temvx.toString()+temvs.toString()+temvt.toString());
			bufferedWriter.write(vec.get(i).toString());
			bufferedWriter.newLine();
			
			
		}
		}catch(FileNotFoundException ex){
			ex.printStackTrace();
		}catch(IOException ex){
			ex.printStackTrace();
		}finally{
			try{
				if (bufferedWriter !=null){
					bufferedWriter.flush();
					bufferedWriter.close();
				}
			}catch(IOException ex){
					ex.printStackTrace();
				}
			}
		}
	public int size() {
		
		// TODO Auto-generated method stub
		return vec.size();
	}
	public Trade get(int i) {
		// TODO Auto-generated method stub
		return vec.get(i);
	}
				}
				*/
import java.util.*;
import java.io.*;
public class TradeArray {
	
	private Vector <Trade> vec;
	//constructor
	public TradeArray() {
		vec = new Vector<Trade>(3000);
	}
	//accessors
	public int size() {
		return vec.size();
	}
	public int capacity() {
		return vec.capacity();
	}
	//mutators
	public void resize(int newCapacity){
		vec.setSize(newCapacity);
	}
	//methods insert
	public void insert(int ind, Trade T){
		vec.add(ind, T);
	}
	public void insertFront(Trade T){
		vec.add(0, T);
	}
	public void insertTail(Trade T){
		vec.add(vec.size(), T);
	}
	//method remove
	public Trade remove(int ind){
		return vec.remove(ind);
	}
	public Trade removeFront(){
		return vec.remove(0);
	}
	public Trade removeTail(){
		return vec.remove(vec.size()-1);
	}
	public Trade At(int ind) {
		return vec.elementAt(ind);
	}
	public void setVec(Trade Nvec){
		vec.add(Nvec);
	}
	public Vector<Trade> getVec(){
		return vec;
	}
	public Trade get(int i) {
		// TODO Auto-generated method stub
		return vec.get(i);
	}
	public boolean insert(Trade x){
		return vec.add(x);
	}
	//The most important method is method that computes the statistics and 
	//records them in a file (passed a parmater)
	/*public void stats(String fileName) {
		//go through all trades and record stats
		//open the file in write mode FileWriter
		File outFile;
		try{ 
			
			//print all trades to a file
			FileWriter ft = new FileWriter(fileName + ".txt");
			BufferedWriter bf = new BufferedWriter(ft);
			for (int i =0; i < this.size(); i++){
				bf.write(this.At(i).toString()+"\n");
			
			}
			bf.close();
			
			outFile = new File(fileName+".txt");
			int counter = 1;
			while (outFile.exists()) {
				outFile = new File(fileName+".txt" + "("+counter+")");
				counter++;
			}
			FileWriter fw = new FileWriter(outFile);
			bf = new BufferedWriter(fw);
			
			int numberWin= 0, numberLoss = 0, numberLongWin = 0, numberShortWin = 0;
			int numberLongLoss = 0, numberShortLoss = 0;
			double percentWin = 0.0, percentLoss = 0.0, percentLongWin = 0, percentLongLoss = 0;
			double percentShortWin = 0.0, percentShortLoss = 0;
			double maxWin = 0.0, maxLoss = 0.0;
			for (int i=0; i<this.size(); i++){
				if (this.At(i).getDirection().equalsIgnoreCase("long")){
					if (this.At(i).percentPL() >= 0){
						numberWin++;
						numberLongWin++;
						percentWin += this.At(i).percentPL();
						percentLongWin += this.At(i).percentPL();
						if (this.At(i).percentPL() > maxWin) {
							maxWin = this.At(i).percentPL();
						}
					}else {//it is a loss	
						numberLoss++;
						numberLongLoss++;
						//loss is negative
						percentLoss += this.At(i).percentPL();
						percentLongLoss += this.At(i).percentPL();
						if (this.At(i).percentPL() < maxLoss) {
							maxLoss = this.At(i).percentPL();
						}
					}
				}else {//it is a short trade
					if (this.At(i).percentPL() >= 0){//it a win
						numberWin++;
						numberShortWin++;
						percentWin += this.At(i).percentPL();
						percentShortWin += this.At(i).percentPL();
						if (this.At(i).percentPL() > maxWin) {
							maxWin = this.At(i).percentPL();
						}
					}else {//it is a loss	
						numberLoss++;
						numberShortLoss++;
						//loss is negative
						percentLoss += this.At(i).percentPL();
						percentShortLoss += this.At(i).percentPL();
						if (this.At(i).percentPL()< maxLoss) {
							maxLoss = this.At(i).percentPL();
						}
					}
				}
			}
			//write the stats to the file and we are done!!
			bf.write("Number Trades = " + this.size()+ "\n" + " Number Wins = " + numberWin + "\n" +
			"number Losses = " + numberLoss + "\n" + "Total Wining = " + percentWin + " % \n" +
					"Total Loss = " + percentLoss + " %\n" + "Average PL = " + (percentWin+percentLoss)/this.size() + "\n" +
			"Average Win for wins = " + percentWin/numberWin + "\n" + "AverageLoss for Losers = " + percentLoss/numberLoss + "\n" +
					"numberLongWin = " + numberLongWin + "   numberLongLoss = " + numberLongLoss + "\n" + 
					"PL for Longs = " + (percentLongWin + percentLongLoss)/(numberLongWin + numberLongLoss) + "\n" + 
					"numberShortWin = " + numberShortWin + "   numberShortLoss = " + numberShortLoss + "\n" + 
					"PL for Shorts = " + (percentShortWin + percentShortLoss)/(numberShortWin + numberShortLoss) + "\n" +
					"maxWin = " + maxWin + ",   maxLoss = " + maxLoss);
			bf.close();		
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
	*/		
		
	
	
	
	public void stats(String TfileName){
		BufferedWriter bufferedWriter=null;
		try{
			bufferedWriter=new BufferedWriter(new FileWriter(TfileName));
			bufferedWriter.write("entrydate"+","+"exitdate"+","+"entryprice"+","+"exitprice"+","+"stoploss"+","+"target"+","+"diretcion"+"\n");
			//bufferedWriter.write(vec.get(i).toString()+"\n");
			bufferedWriter.newLine();
			
		for(int i=0;i<vec.size(); i++){
			Trade tem=new Trade();
			tem=vec.get(i);
			Date temD=new Date();
			temD=tem.getEntryDate();
			Date temE=new Date();
			temE=tem.getExitDate();
			Float temve=tem.getEntryPrice();
			Float temvx=tem.getexitPrice();
			Float temvs=tem.getStopLoss();
			Float temvt=tem.getTarget();
			bufferedWriter.write(temD.toString()+","+temE.toString()+","+temve.toString()+","+temvx.toString()+","+temvs.toString()+","+temvt.toString()+","+tem.getDirection()+"\n");
			//bufferedWriter.write(vec.get(i).toString()+"\n");
			bufferedWriter.newLine();
			
			
		}
		
		int numberWin= 0, numberLoss = 0, numberLongWin = 0, numberShortWin = 0;
		int numberLongLoss = 0, numberShortLoss = 0;
		double percentWin = 0.0, percentLoss = 0.0, percentLongWin = 0, percentLongLoss = 0;
		double percentShortWin = 0.0, percentShortLoss = 0;
		double maxWin = 0.0, maxLoss = 0.0;
		for (int i=0; i<this.size(); i++){
			if (this.At(i).getDirection().equalsIgnoreCase("long")){
				if (this.At(i).percentPL() >= 0){
					numberWin++;
					numberLongWin++;
					percentWin += this.At(i).percentPL();
					percentLongWin += this.At(i).percentPL();
					if (this.At(i).percentPL() > maxWin) {
						maxWin = this.At(i).percentPL();
					}
				}else {//it is a loss	
					numberLoss++;
					numberLongLoss++;
					//loss is negative
					percentLoss += this.At(i).percentPL();
					percentLongLoss += this.At(i).percentPL();
					if (this.At(i).percentPL() < maxLoss) {
						maxLoss = this.At(i).percentPL();
					}
				}
			}else {//it is a short trade
				if (this.At(i).percentPL() >= 0){//it a win
					numberWin++;
					numberShortWin++;
					percentWin += this.At(i).percentPL();
					percentShortWin += this.At(i).percentPL();
					if (this.At(i).percentPL() > maxWin) {
						maxWin = this.At(i).percentPL();
					}
				}else {//it is a loss	
					numberLoss++;
					numberShortLoss++;
					//loss is negative
					percentLoss += this.At(i).percentPL();
					percentShortLoss += this.At(i).percentPL();
					if (this.At(i).percentPL()< maxLoss) {
						maxLoss = this.At(i).percentPL();
					}
				}
			}
		}
		//write the stats to the file and we are done!!
		bufferedWriter.write("Number Trades = " + this.size()+ "\n" + " Number Wins = " + numberWin + "\n" +
		"number Losses = " + numberLoss + "\n" + "Total Wining = " + percentWin + " % \n" +
				"Total Loss = " + percentLoss + " %\n");
		bufferedWriter.newLine();
		bufferedWriter.write("Average PL = " + (percentWin+percentLoss)/this.size() + "\n" +
		"Average Win for wins = " + percentWin/numberWin + "\n" + "AverageLoss for Losers = " + percentLoss/numberLoss + "\n" +
				"numberLongWin = " + numberLongWin + "   numberLongLoss = " + numberLongLoss + "\n");
		bufferedWriter.newLine();
		bufferedWriter.write("PL for Longs = " + (percentLongWin + percentLongLoss)/(numberLongWin + numberLongLoss) + "\n" + 
				"numberShortWin = " + numberShortWin + "   numberShortLoss = " + numberShortLoss + "\n" + 
				"PL for Shorts = " + (percentShortWin + percentShortLoss)/(numberShortWin + numberShortLoss) + "\n" +
				"maxWin = " + maxWin + ",   maxLoss = " + maxLoss);
		bufferedWriter.newLine();
		}catch(FileNotFoundException ex){
			ex.printStackTrace();
		}catch(IOException ex){
			ex.printStackTrace();
		}finally{
			try{
				if (bufferedWriter !=null){
					bufferedWriter.flush();
					bufferedWriter.close();
				}
			}catch(IOException ex){
					ex.printStackTrace();
				}
			}
		}
}

	

