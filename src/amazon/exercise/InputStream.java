package amazon.exercise;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This class represents stream of characters and provides methods to access/process the stream
 * 
 * getNext()
 * hasNext()
 * firstChar()
 * getFirstNonRepeatedChar()
 *  
 * @author anu
 *
 */
public class InputStream implements Stream {

	private int charIndex;
	private String inputString;
	
	public InputStream(String inputString)
	{
		this.charIndex = 0;
		this.inputString = inputString;
	}
	
	/**
	 * Returns next character in the stream.
	 * This method should be called after verifying  the result of hasNext()
	 */
	@Override
	public char getNext() {
	
		this.charIndex++;
		return this.inputString.charAt(this.charIndex);
	
	
	}

	
	/**
	 * Returns if the stream has any character after current index
	 */
	@Override
	public boolean hasNext() {
		
		if(null == this.inputString || this.inputString.isEmpty() || (this.charIndex >= this.inputString.length()-1))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * 
	 * @param input
	 * @return  first character in the stream if stream is not empty
	 */
	
    public static char firstChar ( Stream input ){
    	
    	if(input instanceof InputStream){
    		
    		InputStream inputStream = (InputStream)input;
    		
    		if( null != inputStream.inputString && !inputStream.inputString.isEmpty()){
    			
    			return inputStream.inputString.charAt(0);
    		}
    		else{
    			
    			return 0;
    		}
    		
    	}
    	
    	return 0;
    }

    
    /**
     * 
     * @return First non repeated character in the stream
     */
    public char getFirstNonRepeatedChar()
	{
		
		char firstChar = InputStream.firstChar(this); //get first char in the stream
				
		Map<Character, Boolean> streamMap = new LinkedHashMap<Character, Boolean>();
		
		
		if(firstChar == '0') //if first char is null , it means the stream is empty return NUL
		{
			return 0;
		}
		else{
		  
			streamMap.put(firstChar, false); //If first char is present put it in the map
			
			
			while(hasNext())   //go through the complete stream and add chars in the map 
			{
				char currChar = this.getNext();
				if(streamMap.containsKey(currChar))
				{
					streamMap.put(currChar, true); // if the char is already present in the map, set value as true, indicating its a repeated character
				}
				else
				{
					streamMap.put(currChar, false); // if the char is not present in the map, set value as false, indicating its a new nonrepeated character
				}
			}
			
			
			/**
			 * Loop through the linkedHashMap. It maintains the insertion order. 
			 * Hence the first char we find in the map with value = false, is the first 
			 * non repeated char in the stream. 
			 */
			if(!streamMap.isEmpty()) 
			{
			
				for(Character firstNonRepeatedChar : streamMap.keySet())
				{
					if(!streamMap.get(firstNonRepeatedChar))
					{
						return firstNonRepeatedChar;
					}
				}
			}
			
			return 0; //If no char is found in the map with value = false return NUL
		}	
	}
    
	
}
