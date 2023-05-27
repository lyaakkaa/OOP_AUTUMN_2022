

import java.util.*;

public class Ex
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
    	  System.out.println(tokenizer.nextToken());
      }
       
      
    }
}
