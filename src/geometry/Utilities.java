package geometry;

public class Utilities {
	public static boolean isNumeric(String strNum){
		  boolean isNumeric = true;
		  for(int i = 0; i < strNum.length(); i++){
		    if(strNum.charAt(i) < '0' || strNum.charAt(i) > '9'){
		       isNumeric = false;
		       break;
		    }
		  }
		  return isNumeric;
		}
}
