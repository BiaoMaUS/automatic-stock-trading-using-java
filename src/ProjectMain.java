
class ProjectMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//DownLoader B=new DownLoader("C:/ProfOmar/stocks.txt","01/01/2015", "12/31/2016","C:/ProfOmar/Data/");
//	B.loadAll();
		//SymbolTester A=new SymbolTester();
	//	A.setMSymbol("C:/ProfOmar/Data/IBM.csv");
		//A.loadBars();
		//A.test();
		Tester t=new Tester();
		//t.tesAll();
		TradeArray c=new TradeArray();
		 c=t.tesAll(); 
	
		
		c.stats("C:/ProfOma/Newfolder/tradestocks.txt");
		 
	}

}
