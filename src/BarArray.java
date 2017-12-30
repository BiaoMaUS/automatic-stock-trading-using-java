import java.util.Vector;
import java.util.*;
import java.io.*;
public class BarArray {
	private Vector<Bar> Arr;
	public BarArray(){
		Arr= new Vector<Bar>(5000);
	}
	//public BarArray(int size){
	//	Arr=new Vector<Bar>(size);
	//}
	public boolean isEmpty() {
		return Arr.isEmpty();
	}
	//isFull() returns true if full otherwise false 
	public boolean isFull() {
		if(Arr.size() == Arr.capacity())
			return true;
		return false;
	}
	//size return the number of elements
	public int size() {
		return Arr.size();
	}
	public boolean insertTail(Bar x){
		return Arr.add(x);
	}
	public boolean insertHead(Bar x){
		 Arr.add(0, x);
		 if( Arr.firstElement()==x)
			 return true;
		 return false;
	}
	public boolean insert(Bar x, int index){
		Arr.insertElementAt(x, index);
		if(Arr.indexOf(x)==index) 
			return true;
		return false;	
	}
	public Bar remove(int index){
		return Arr.remove(index);
	}
	public Bar removeHead(){
		Bar t=Arr.firstElement();
		Arr.removeElementAt(0);
		return t;
	}
    public Bar removeTail(){
    	Bar t=Arr.lastElement();
    	Arr.removeElementAt(Arr.size()-1);
    	return t;
    }
    public Bar At(int index) {
		return Arr.elementAt(index);
	}
	public Bar get(int i) {
		// TODO Auto-generated method stub
		return Arr.get(i);
	}
}
	