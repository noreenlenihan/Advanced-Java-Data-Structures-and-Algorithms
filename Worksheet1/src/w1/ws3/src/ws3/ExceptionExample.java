package ws3;

public class ExceptionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}
	
	public static void test(){
		try {
		throw new Exception("An exception");
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
