
import java.util.Scanner;

public class Demo{

    public static void palindrome(String str){
        char[] strArray = str.toCharArray();
        int left = 0;
        int right  = strArray.length-1;
        boolean flag =true;

      while(left < right){

     if(strArray[left] != strArray[right]){
        flag = false;
        break;
    }
    left++;
    right--;
      }
      if(flag == true){
        System.out.println(str+" is a plindrome string");
      }
      else{
        System.out.println(str+" is not a palindrome");
      }

      

      
    }

      public static void main(String[] Args){
        // String str = "aba";

        Scanner scan = new Scanner(System.in);

        System.out.println("enter String");
        String st = scan.next();

        palindrome(st);


      }
    }


    
    
