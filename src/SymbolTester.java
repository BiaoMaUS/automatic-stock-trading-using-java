import java.io.*;

	
class SymbolTester {
private TradeArray mTrade;
private String mSymbol;
private BarArray mBars;

private static BufferedReader buf;
private static FileReader fr;
public SymbolTester(){
	mTrade=new TradeArray();
	this.mSymbol="no";
	mBars=new BarArray();
}
	public void setMSymbol(String nmSymbol){
		this.mSymbol=nmSymbol;
	}
	public void setMTrades(TradeArray nmTrades){
		this.mTrade=nmTrades;
	}
public void setMBars(BarArray nmBars){
	this.mBars=nmBars;
}
public String getMSymbol(){
	return mSymbol;
}
public TradeArray getMTrades(){
	return mTrade;
}
public BarArray getMBars(){
	return mBars;
}
public void loadBars(){
	try {
		fr = new FileReader(mSymbol);
		buf = new BufferedReader(fr);
		//read one symbol at a time and download it 
		String line;
		while((line = buf.readLine()) != null) {
			Bar b= new Bar(line);
			mBars.insertTail(b);
		
		}
		buf.close();
		fr.close();
	}catch(IOException e) {
		System.out.println("Message1 : " + e.getMessage());
	}
	
}

public void test(){
	for(int i=mBars.size()-1;i>6;i--){
		
		
		/*if(((mBars.At(i)).low
				()<(mBars.At(i-1)).low())&&((mBars.At(i)).high()<(mBars.At(i-1)).high())
				&&(((mBars.At(i)).low()<(mBars.At(i-2)).low())||((mBars.At(i)).low()<(mBars.At(i-3)).low())
				||((mBars.At(i)).low()<(mBars.At(i-4)).low())||((mBars.At(i)).low()<(mBars.At(i-5)).low())
				||((mBars.At(i)).low()<(mBars.At(i-6)).low()))&&(((mBars.At(i)).high()<(mBars.At(i-2)).high())
			    ||((mBars.At(i)).high()<(mBars.At(i-3)).high())||((mBars.At(i)).high()<(mBars.At(i-4)).high())
			    ||((mBars.At(i)).high()<(mBars.At(i-5)).high())||((mBars.At(i)).high()<(mBars.At(i-6)).high()))){*/
		//int w=i;
		float maxHigh=0;
		float minLow=0;
		for( int w=i-1;w>=(i-7);w--){
			if(mBars.At(w).high()>=maxHigh)
				maxHigh=mBars.At(w).high();
			if(mBars.At(w).low()<=minLow)
				minLow=mBars.At(w).low();	
		}
		//Trade T=new Trade((mBars.At(i)).date(),((mBars.At(i-1)).high())+0.1f,((mBars.At(i-1)).low())-0.1f,(maxHigh-(mBars.At(i-1)).high()),"long");
		
		if((mBars.At(i-1)).low()>(mBars.At(i-2)).low()&&(mBars.At(i-1)).high()<(mBars.At(i-2)).high()
				&&(mBars.At(i-1)).low()>minLow&&(mBars.At(i-1)).high()<maxHigh&&(mBars.At(i).high()>mBars.At(i-1).high())){
		Trade T=new Trade((mBars.At(i)).date(),((mBars.At(i-1)).high())+0.1f,(((mBars.At(i-1)).low()-5)),(((mBars.At(i-1)).high()+3)),"long");
		for(int r=i+1;r<mBars.size();r++){
			if((mBars.At(r)).high()>T.getTarget()){
				T.setExitDate((mBars.At(r)).date());
				T.setExitPrice(T.getTarget());
				mTrade.insert(T);
				break;
			}else if
			((mBars.At(r)).low()<T.getStopLoss()){
				T.setExitDate((mBars.At(r)).date());
				T.setExitPrice(T.getStopLoss());
				mTrade.insert(T);
				break;
		}
	}
		}
		//if((mBars.At(i)).low()>(mBars.At(i-1)).low()&&(mBars.At(i)).high()<(mBars.At(i-1)).high()
			//	&&(mBars.At(i)).low()>minLow&&(mBars.At(i)).high()<maxHigh){
		if((mBars.At(i-1)).low()>(mBars.At(i-2)).low()&&(mBars.At(i-1)).high()<(mBars.At(i-2)).high()
				&&(mBars.At(i-1)).low()>minLow&&(mBars.At(i-1)).high()<maxHigh&&(mBars.At(i).open()<mBars.At(i-1).low())){
		Trade T2=new Trade((mBars.At(i)).date(),(mBars.At(i-1).low()-0.1f),((mBars.At(i-1)).high())+5,((mBars.At(i-1)).low()-3),"short");
			for(int r=i+1;r<mBars.size();r++){
				if((mBars.At(r)).low()<T2.getTarget()){
					T2.setExitDate((mBars.At(r)).date());
					T2.setExitPrice(T2.getTarget());
					mTrade.insert(T2);
					break;
				}else if
				((mBars.At(r)).high()>T2.getStopLoss()){
					T2.setExitDate((mBars.At(r)).date());
					T2.setExitPrice(T2.getStopLoss());
					mTrade.insert(T2);
					break;
			}
	}
}
	
}
	}
}





