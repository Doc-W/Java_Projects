/**
 * A class that is a singlebuffer that holds one object at a time
 * @author Drew Merrill
 * CS 2420 spring 2019
 * 
 */
public class SingleBuffer<any> {

	private boolean isEmpty;
	private any anItem;
	
	public SingleBuffer(){
		anItem = null;
		isEmpty = true;
	}
	public SingleBuffer(any a) {
		anItem = a;
		if(anItem != null) {
			isEmpty = false;
		}
		else {
			isEmpty = true;
		}
	}
	
	public any get() throws Exception {
		if(isEmpty == true) {
			throw new Exception("Buffer has nothing to give");
		}
		isEmpty = true;
		any item = anItem;
		anItem = null;
		return item;
	}
	public void put(any item) throws Exception {
		if(isEmpty == false) {
			throw new Exception("The buffer is full right now");
		}
		anItem = item;
		isEmpty = false;
		
		
		
	}

	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		SingleBuffer sb1 = new SingleBuffer();
		SingleBuffer sb2 = new SingleBuffer(22);
		sb1.put(25);
		System.out.println(sb1.get());
		System.out.println(sb2.get());
		sb2.put(65);
		sb2.put("just to test stuff");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
