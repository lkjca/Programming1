package Project;
import java.util.Arrays;

public class Validator {
	
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
        
        boolean result4 = safePassword("PawRDisk-2");
        System.out.println(result4);
        
        //isDomain test
        boolean result5 = isDomain("o-j.com");
        System.out.println("the domain is: " + result5);
        
        //singleAtSign() test
        boolean result6 = singleAtSign("gma@il.com");
        System.out.println("@:   " + result6);
        
        //isEmail test
        boolean result7 = isEmail("user..name@fakemail.com");
        System.out.println("isEmail:  " + result7);
        
        //isPrefixChar
        boolean result8 = isPrefixChar('[');
        System.out.println("isPrefixChar  " + result8);
        
        // isPrefix
        boolean result9 = isPrefix("the_st");
        System.out.println("isPrefix  " + result9);
        
        //validPassword test
        String[]passwords = {"H3l10-WoRld","W0w.Pr0ject","A1.b2-","D1nn3r-T1m3","Pa55w0RDis0k"};
        String[]validPassword = validPassword (passwords);
        System.out.println("Valid Passwords:");
        for (String pw : validPassword) {
            System.out.println(pw);
        }
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
	    if ( ch == '_' && specialUnderscore) {
	    	return true;	
	    }
	    return false;
	}
	 //Method to check if a character is allowed in the prefix
	public static boolean isPrefixChar(char c) {
	    if (isAlphaNum(c) || isSpecialChar(c, true)) {
	        return true;
	    } 
	    return false;
	}
		
	// Method to check if a character is allowed in the domain
	public static boolean isDomainChar(char character ) {
		if ( isAlphaNum (character) ||  isSpecialChar(character,false) ) {
		return true;	
		}
		return false;
	}
	
	// singleAtSign()
	public static boolean singleAtSign(String address) {
		int count = 0;
		for ( int i = 0; i < address.length(); i++) {
			char c = address.charAt(i);
			if (c == '@') {
				count++;
			}
		}
		return count == 1;
	}
	
	
	// fetchBeforeAt()
	public static String fetchBeforeAt(String email) {
        int index = email.indexOf('@');
        return email.substring(0, index);
    }

	
	// fetchAfterAt()
    public static String fetchAfterAt(String email) {
        int index = email.indexOf('@');
        return email.substring(index + 1);
    }

    // isPrefix()
    public static boolean isPrefix(String prefix) {
        // check if the prefix is empty and if the first character is alphanumeric
    	if (prefix.isEmpty() || !isAlphaNum(prefix.charAt(0))) {
            return false;
        }
    	// for loop the string
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!isPrefixChar(c)) {// alphanumeric and special character
            	return false;
            }
            if (isSpecialChar(c, true)) {
            	if (i == prefix.length()-1 || !isAlphaNum(prefix.charAt(i+1))) {
            		return false;
            	}
            }     
        }
        return true;
    }
		
	
	// isDomain()
	public static boolean isDomain(String domain) {
		int dotIndex = domain.indexOf('.');
		if (dotIndex == -1 ||  dotIndex == domain.length()-1 ||  dotIndex == 0) {
			return false;
		}	
		String firstPortion = domain.substring(0, dotIndex);
		String secondPortion = domain.substring(dotIndex+1);
		
		// check the first portion
		if (!isDomainChar(firstPortion.charAt(0))) {
			return false;
		}
		for (int i = 0; i < firstPortion.length(); i++) {
			char c = firstPortion.charAt(i);
			if (!isAlphaNum(c) && c != '.' && c != '-') {
				return false;
			}
			if ( (c == '-' || c == '.') && (i == 0 || i == firstPortion.length()-1)) {
				return false;
			}
			if ( (c == '-' || c == '.') && (!isAlphaNum(firstPortion.charAt(i+1)))) {
				return false;
			}	
		}
		// check the second portion
		if (secondPortion.length()<2 ) {
			return false;
		}
		for (int i = 0; i < secondPortion.length(); i++) {
			char c = secondPortion.charAt(i);
			if ( !Character.isLetter(c)){
				return false;
			}
		}
		return true;
	}
	
	
	// isEmail
	public static boolean isEmail (String email) {
		int atIndex = email.indexOf('@');
		if (atIndex == -1 || atIndex == 0 || atIndex == email.length() - 1) {
			return false;
		}
		String prefix = fetchBeforeAt( email );
		String domain = fetchAfterAt( email );
		
		if (!isPrefix( prefix )) {
			return false;
		}
		if (!isDomain( domain )) {
			return false;
		}
		return true;
	}
	
	
	// Method to check if a string is a valid username
    public static String isUsername(String username) {
       if (username.isEmpty() || username.length() > 7 || !isPrefixChar(username.charAt(0)))
    	   return "";

    	    boolean prevCharValid = true;
    	    String validUsername = "";

    	for (int i = 0; i < username.length(); i++) {
    	    char c = username.charAt(i);
    	    System.out.println(c);
    	    if (!isPrefixChar(c) && !isDomainChar(c)) {
    	    	if (prevCharValid)
    	            return "";
    	        System.out.println(c);       
    	       
    	     } else {
    	         validUsername += Character.toLowerCase(c);
    	         prevCharValid = true;
    	        }
    	    }
    	    return validUsername;
    	}
	
	
	// safePassword()
	public static boolean safePassword(String password) {
		char c;
		int i;
		boolean hasUpperCase = false;
		boolean hasLowerCase = false;
		boolean hasDigit = false;
		
		if ((password.length() < 7) || password.length() > 15) {
			return false;
		}	
		for ( i=0; i < password.length(); i++) {
			c = password.charAt(i);
		
			if ( !isAlphaNum (c) && !isSpecialChar (c, true)) {
				return false;
			}
			if (i > 0 && c == password.charAt( i - 1 )) {
				return false;
			}
			if (Character.isUpperCase(c)) {
				hasUpperCase = true;
			}
			if (Character.isLowerCase(c)) {
				hasLowerCase = true;
			}
			if (Character.isDigit(c)) {
				hasDigit = true;
			}
		}if (!hasUpperCase  || !hasLowerCase || !hasDigit) {
			return false;
		}
		return true;
	}
	
	// validEmails()
	public static String[] validEmails(String[] emails) {
		int count = 0;
		for (String em: emails) {
			if (isEmail(em)) {
				count++; 
			}
		}
		String[] validEmails = new String[count];
		int index = 0;
		for (String em: emails) {
			if (isEmail(em)) {
				validEmails[index++] = em;
			}
		}
		return validEmails;	
	}
	
    

    // Method to check if Strings in an array are valid usernames
    public static String[] validUsernames(String[] usernames) {
        int count = 0;
        for (String username : usernames) {
            if (!isUsername(username).isEmpty()) {
                count++;
            }
        }
        String[] validUsernames = new String[count];
        int index = 0;
        for (String username : usernames) {
            String validUsername = isUsername(username);
            if (!validUsername.isEmpty()) {
                validUsernames[index++] = validUsername;
            }
        }
        return validUsernames;
    }
    
    
	// validPassword()
	public static String[] validPassword(String[] passwords) {
		int count = 0;
		for (String pw: passwords) {
			if (safePassword(pw)) {
				count++; 
			}
		}
		String[] validPassword = new String[count];
		int index = 0;
		for (String pw: passwords) {
			if (safePassword(pw)) {
				validPassword[index++] = pw;
			}
		}
		return validPassword;	
	}
}
