import java.io.*;

class Tester {
private TradeArray mTrades;
private static BufferedReader buf;
private static FileReader fr;
public Tester(){
	mTrades=new TradeArray();
}
	public Tester(TradeArray nmTrades){
		this.mTrades=nmTrades;
	
	}
	
	
	public TradeArray tesAll() {
		 try {
				fr = new FileReader("C:/stocks/stocks.txt");
				buf = new BufferedReader(fr);
				//read one symbol at a time and download it 
				String sc;
				while((sc = buf.readLine())!= null) {
					//change the symbol to current symbol and the output file as well
					//just call setSymbol on yahooData
					 //yahooData object=new yahooData(sc,Directory,startDate,endDate);
			//		DownLoader B=new DownLoader("C:/ProfOmar/New folder/stock.txt",Y,"01/01/2015", "12/31/2016","C:/ProfOmar/Data/");
					SymbolTester w=new SymbolTester();
					System.out.println("c:/date/"+sc+".txt");
					
					w.setMSymbol("c:/date/"+sc+".txt");
					//w.setMTrades(mTrades);
					w.loadBars();
					w.test();
					//return mTrades;
	for(int i=0;i<( w.getMTrades()).size();i++){
		mTrades.insert((w.getMTrades()).At(i));
		
	}
					
					//mTrades=w.getMTrades();
					
			}
				
				buf.close();
				fr.close();
			}catch(IOException e) {
				System.out.println("Message : " + e.getMessage());
			}
			return mTrades;
		}
		
		
	}
	


