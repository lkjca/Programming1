//Student ID 2457453 - Jenny Kawadoi and Kejia Li, ID XXXXXX
public class Validator {

		public static void main(String[] args) {
			//isAlphaNum test
			boolean result = isAlphaNum('t');
		//	System.out.println(result); 
			
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
	        
	       //Testing usernames 
	        String[] testUsernames = {"-User2", ".cc123", "userName", "#sd99"};
	        
	        // Testing isUsername
	        for (String username : testUsernames) {
	            System.out.println("Username: " + username);
	        }

	        // Testing validUsernames
	        String[] validUsernames = validUsernames(testUsernames);
	        System.out.println("\nValid Usernames:");
	        for (String username : validUsernames) {
	            System.out.println(username);
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
				
			}else {
			return false;
		}	
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

	}


