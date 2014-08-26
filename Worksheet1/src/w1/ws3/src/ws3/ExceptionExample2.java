package ws3;

public class ExceptionExample2 {
		// best solution

			public static void main(String[] args) {
				// TODO Auto-generated method stub
				try {
					test();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			public static void test() throws Exception{
				
				throw new Exception("An exception");
				
			}

		

	

}
