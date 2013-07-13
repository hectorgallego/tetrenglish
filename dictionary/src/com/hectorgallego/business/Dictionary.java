package com.hectorgallego.business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.hectorgallego.model.DictionaryEntry;
import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;



public class Dictionary {
	
	private String fileName;
	
	public Dictionary(String pFileName){
		
		fileName = pFileName;
		
	}
	
	public void Proccess() {
		BufferedReader bf = getFile(fileName);
		ArrayList<DictionaryEntry> words = getWords(bf);
		words = getTranslatedWords(words);

	}

	
	private BufferedReader getFile(String fileName){
		File file = new File (fileName);
		FileReader fr=null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			System.exit(1);
		}
		BufferedReader br = new BufferedReader(fr);
		return br;
	}
	

	private ArrayList<DictionaryEntry> getWords(BufferedReader pbf){
		String line = null;
		ArrayList<DictionaryEntry> aList = new ArrayList<DictionaryEntry>();
		
		
		try {
			DictionaryEntry dE = null;
			
			while ((line = pbf.readLine())!=null){
				
				String token[] = line.split(" ");
				
				try{
					int nMatches = new Integer(token[0]).intValue();
					String enWord = token[1];
					dE = new DictionaryEntry(nMatches,token[1],null);
				} catch (ArrayIndexOutOfBoundsException e){
					System.out.print(line);
				}
				
				
				aList.add(dE);
				
				
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return aList;
		
	}
	

	
	private ArrayList<DictionaryEntry> getTranslatedWords(ArrayList<DictionaryEntry> pDE){
		
		DictionaryEntry dE=null;
		ArrayList<DictionaryEntry> lDE = new ArrayList<DictionaryEntry>();
		
		for (int i =0; i <pDE.size();i++){
			dE = getTranslatedWord(pDE.get(i));
			lDE.add(dE);
		}	
		
		return lDE;
			
	}
	
	private DictionaryEntry getTranslatedWord(DictionaryEntry pDictionaryEntry){
		Translate.setClientId("87e17d8a-da25-44c8-9791-274c115c8fe2");
	    Translate.setClientSecret("wS3qTqsRzw/d8PnHmuvga8dCKR2nqWazIhEXP/7GoNY=");
	    
	    String translatedText = null;
	    
	    try {
			translatedText = Translate.execute(pDictionaryEntry.getEnWord(), Language.ENGLISH, Language.SPANISH);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		pDictionaryEntry.setEsWord(translatedText);
		
		return pDictionaryEntry;
	}
	



}