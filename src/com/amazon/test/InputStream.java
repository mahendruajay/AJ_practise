package com.amazon.test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This class stores an input stream (String) and provides operations on the
 * input stream.
 * 
 * The operations are:
 * 
 * getNext() hasNext()
 * 
 * 
 * @author ajay
 * 
 */
public class InputStream implements Stream
{

	private int index;
	private String inputStream;

	public InputStream(String inputStream)
	{
		index = 0;
		this.inputStream = inputStream;
	}

	/**
	 * Returns the first character in the input stream.
	 * 
	 * This method returns the character '\0' if the input stream is null or
	 * empty.
	 * 
	 * @param input
	 * @return
	 */
	public static char firstChar(Stream input)
	{
		if (input instanceof InputStream)
		{
			InputStream ipStream = (InputStream) input;
			if (null != ipStream.inputStream && !ipStream.inputStream.isEmpty())
			{
				return ipStream.inputStream.charAt(0);
			} else
			{
				return '\0';
			}
		}
		return '\0';
	}

	/**
	 * Returns the next character in the input stream.
	 */
	@Override
	public char getNext()
	{
		index++;
		return this.inputStream.charAt(index);
	}

	/**
	 * Returns whether the input stream has a next character.
	 */
	@Override
	public boolean hasNext()
	{
		if (null == this.inputStream || this.inputStream.isEmpty())
		{
			return false;
		}
		if (index >= this.inputStream.length() - 1)
		{
			return false;
		} else
		{
			return true;
		}
	}

	/**
	 * Returns the first non repeating character in the input stream.
	 * 
	 * Returns null if the input stream is null, empty or does not containing a
	 * single non repeating character.
	 * 
	 * @return Character or null
	 */
	public Character getFirstNonRepeatingCharacter()
	{
		// get the first character.
		char firstChar = InputStream.firstChar(this);

		// LinkedHashMap so the insertion order is maintained.
		Map<Character, Boolean> charMap = new LinkedHashMap<Character, Boolean>();

		// input stream is null or empty.
		if (firstChar == '\0')
		{
			return null;
		}

		// put the first character in the HashMap.
		charMap.put(firstChar, false);

		/*
		 * if the map already contains the character, put the value against the
		 * character as true, otherwise the character is being inserted in the
		 * map for the first time and put the value against this character as
		 * false.
		 */
		while(hasNext())
		{
			char current = this.getNext();
			if (charMap.containsKey(current))
			{
				charMap.put(current, true);
			} else
			{
				charMap.put(current, false);
			}
		}

		/*
		 * Iterate the map and return the first key that has a value false.
		 */
		if (!charMap.isEmpty())
		{
			// Returns the very first key (Character).
			for (Character nonRepeatedChar : charMap.keySet())
			{
				if (!charMap.get(nonRepeatedChar))
				{
					return nonRepeatedChar;
				}
			}
		}

		return null;

	}

}
