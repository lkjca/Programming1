
public class testing {

	public static void main(String[] args) {
		//isAlphaNum test
		boolean result = isAlphaNum('t');
		System.out.println(result); 
		
		//isSpecialChar test
		char ch1 = '/';
        boolean result1 = isSpecialChar( ch1, true);
        System.out.println(result1);
        
        //isPrefixChar test
        boolean result2 = isPrefixChar('/');
        System.out.println(result2);   

        //isDomainChar test
        boolean result3 = isDomainChar('_');
        System.out.println(result3);
    
        
	}
	
	
	// Method to check if a character is alphanumeric
	public static boolean isAlphaNum(char i) {
	    if ((i >= 'a' && i <= 'z') || (i >= 'A' && i <= 'Z') || (i >= '0' && i <= '9')){
	        return true;
	      	    } 
	    else {
	        return false;}
	  
	    }
	// Method to check if a character is an acceptable special character
	public static boolean isSpecialChar(char ch, boolean specialUnderscore) {
	    		if (ch == '-' || ch == '.') {
	    			return true;
	    		}
	    		if (specialUnderscore && ch == '_') {
	    			return true;	
	    		}
	    		return false;
}
	 //Method to check if a character is allowed in the prefix
	public static boolean isPrefixChar(char c) {
	    if (isAlphaNum(c) || isSpecialChar(c, true)) {
	        return true;
	    } else {
	        return false;
	    }
	}	
	// Method to check if a character is allowed in the domain
	public static boolean isDomainChar(char character ) {
	if ( isAlphaNum (character) ||  isSpecialChar(character,false) ) {
		return true;
		
	}
	return false;
}
}