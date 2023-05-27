package problem4;

import java.util.*;

public class Example4
{
    public static void main(String[] args)
    {
       double                 leftOperand, result, rightOperand;
       String                 leftString, operator, rightString;
       StringTokenizer        tokenizer;
       String delim = "+-*/";
       Scanner in = new Scanner(System.in);
       
       tokenizer = new StringTokenizer(in.nextLine(), " ");
       System.out.println(tokenizer.countTokens());
       
       while(tokenizer.hasMoreTokens()) {
//           System.out.println(tokenizer.nextToken());
    	   StringTokenizer mytokenizer = new StringTokenizer(tokenizer.nextToken(),delim, true);
    	   try
           {
              leftString   = mytokenizer.nextToken();
              operator     = mytokenizer.nextToken();
              rightString  = mytokenizer.nextToken();

              
           
              
              try {
            	  leftOperand  = Double.parseDouble(leftString);
              }
                catch (NumberFormatException e) {
                  System.out.println("Error, leftOperand is not number");
                  leftOperand  = Double.parseDouble("0");
                }
              
              try {
            	  rightOperand = Double.parseDouble(rightString);
              }
                catch (NumberFormatException e) {
                  System.out.println("Error, rightOperand is not number");
                  rightOperand = Double.parseDouble("0");
                }

              if (operator.equals("+")) {
            	  System.out.println("Result: " + (leftOperand + rightOperand));
              }
              
              
              if (operator.equals("-")) {
            	  System.out.println("Result: " + (leftOperand -rightOperand));
              }
              
              if (operator.equals("*")) {
            	  System.out.println("Result: " + (leftOperand * rightOperand));
              }
              if (operator.equals("/")) {
            	  try {
              		System.out.println("Result: " + (leftOperand / rightOperand));
          		}
          		catch (ArithmeticException ae) {
          			System.out.print("Divide by 0.");
          			ae.printStackTrace();
          		}
              }

           }
           catch (NoSuchElementException nsee)
           {
              System.out.println("Invalid syntax");
           }
           catch (NumberFormatException nfe)
           {
              System.out.println("One or more operands is not a number");
           }
    	   
       }
       
      
    }
}


