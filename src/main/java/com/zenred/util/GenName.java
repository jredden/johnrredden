package com.zenred.util;

public class GenName {
	
	/*
	 * tool currently does not have safeguards to keep it from being a potty mouth ...
	 */
	
	private static String prefix;
	
	private static int chanceOfSpecialChara = 0;
	private static int vowelFrequency = 2; // flip a coin
	
	private static String[] stringArrayVowel = new String[]{"a", "aa", "e", "ee", "i", "ii", "o", "oo", "u", "uu"};
	private static String[] stringArrayConsanant  = new String[]{"b", "bc", "cb", "c", "cd", "dc", "d", "df", "fd", "f",
				"fg", "gf", "g", "gh", "hg", "h", "hj", "jh", "j", "jk", "kj", "k", "kl", "lk", "l","lm",
				"ml", "m", "mn", "nm", "n", "np", "pn", "p", "pq", "qp", "q", "qr", "rq", "r", "rs", "sr", "s",
				"st", "ts", "t", "tv", "vt", "v", "vw", "wv", "w", "wx", "xw", "x", "xy", "yx", "y", "yz", "zy", "z"
				};
	private static String[]  specialCharArray = new String[]{"Á","É","Í","Ó","Ú","á","é","í","ó","ú","¿","Ñ", "ñ", "¡"};
	// cap and lower case acute a e i o u,  upside-down ?, cap and lower case tilde n,   
	
	private static int sav_size = stringArrayVowel.length;
	private static int sac_size = stringArrayConsanant.length;
	private static int sca_size = specialCharArray.length;
	
	private static int drawRand(int range){
		int answer = (int)(Math.random() * new Double(range));
		return answer;
	}
	
	/**
	 * generate a random name limited to size.
	 * 
	 * @param size
	 * @return
	 */
	private static String randomName(int size){
		if(size < 0){return "";}  // huh? negative size has no meaning here
		String answer = "";
		while (true){
			int currentSize = answer.length();
			int flipACoin = drawRand(2);
			String nextChunk = "";
			if(flipACoin == 1){
				nextChunk = stringArrayVowel[drawRand(sav_size)];
				if(nextChunk.length() + currentSize > size){
					nextChunk = nextChunk.substring(0, 1);
				}
			}
			else{
				nextChunk = stringArrayConsanant[drawRand(sac_size)];
				if(nextChunk.length() + currentSize > size){
					nextChunk = nextChunk.substring(0, 1);
				}				
			}
			int chance = drawRand(100);
			if(chance < chanceOfSpecialChara && nextChunk.length() + currentSize +1 <= size){
				String specialChar = specialCharArray[drawRand(sca_size)];
				System.out.println("adding special char:"+specialChar);
				nextChunk += specialChar;
			}
			answer += nextChunk;
			if(answer.length() >= size){break;}
		}
		return answer;
	}

	public GenName() {
	}
	
	public GenName(String _prefix) {
		prefix = _prefix;
	}
	
	public static void setPrefix(String _prefix){
		prefix = _prefix;
	}
	
	public static void setSpecialCharaChance(int chance){
		if(chance > 99){
			chanceOfSpecialChara = 99;
		}
		else{
			chanceOfSpecialChara = chance;
		}
	}
	
	/**
	 * the higher the frequency, the less the number of vowels
	 */
	public static void setVowelFrequency(int frequency){
		vowelFrequency = frequency;
	}
	
	/**
	 * Generates a name for testing with a length of "size" added to the prefix
	 * 
	 * @param size
	 * @return
	 */
	public static String generate(int size){
		StringBuffer sbuf = new StringBuffer().append(prefix).append(randomName(size))
		;
		return sbuf.toString();
	}

}
