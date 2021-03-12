package pwdconv;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Date;

public class PwdChange
{
	/************ 비밀번호 암호화 *******************/
   public static String getPassWordToXEMD5String(String password) { 
       
    MessageDigest md_Md5 = null;  
      
    try { 
          
    md_Md5 = MessageDigest.getInstance("MD5"); 
      
      } catch (Exception e) { 
          
      e.printStackTrace(); 
       
    }         
 
      
    String resultString; 
      
    byte[] byteArr; 
       
   String temp = ""; 
         
       
    byteArr = md_Md5.digest(password.getBytes());          
 
       
   for (int i = 0; i < byteArr.length; i++) {             
   resultString = "" + Integer.toHexString((int)byteArr[i] & 0x000000ff);          
 
         
  if( resultString.length() < 2 ) {  
               
   resultString = "0" + resultString; 
           
   }                 
    temp = temp + resultString; 
   }  
       
   return temp;   
  }
   
	/************ 임시 비밀번호 생성 *******************/
   public static String getRandomPassword(int size) {
	   char[] charSet = new char[] { 
			   '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
			   'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 
			   'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 
			   '!', '@', '#', '$', '%', '^', '&' }; 
	   StringBuffer sb = new StringBuffer(); 
	   SecureRandom sr = new SecureRandom(); 
	   sr.setSeed(new Date().getTime());
	   int idx = 0; 
	   int len = charSet.length; 
	   for (int i=0; i<size; i++) { 
		   // idx = (int) (len * Math.random()); 
		   idx = sr.nextInt(len); // 강력한 난수를 발생시키기 위해 SecureRandom을 사용한다. 
		   sb.append(charSet[idx]); 
	   }
	   return sb.toString();
	   }

}
