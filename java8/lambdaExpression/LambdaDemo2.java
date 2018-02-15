package java8.lambdaExpression;

public class LambdaDemo2 {
	
	public static void main(String[] arg) {
	
	 MathOperation addition = (int a, int b) -> a + b;
		
     MathOperation subtraction = (a, b) -> a - b;
		
     MathOperation multiplication = (int a, int b) -> { return a * b; };
		
     MathOperation division = (int a, int b) -> a / b ;
		
     System.out.println("15 + 5 = " + operate(15, 5, addition));
     System.out.println("15 - 5 = " + operate(15, 5, subtraction));
     System.out.println("15 x 5 = " + operate(15, 5, multiplication));
     System.out.println("15 / 5 = " + operate(15, 5, division));
  }
	
  private static int operate(int a, int b, MathOperation mathOperation) {
     return mathOperation.operation(a, b);
  }

}
