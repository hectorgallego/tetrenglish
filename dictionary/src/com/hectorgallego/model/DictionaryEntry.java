package com.hectorgallego.model;

public class DictionaryEntry {

	
	private int nMatches;
	private String enWord;
	private String esWord;
	
	public DictionaryEntry(int pNMatches, String pEnWord, String pEsWord){
		nMatches = pNMatches;
		enWord = pEnWord;
		esWord = pEsWord;
	}
	
	public int getnMatches() {
		return nMatches;
	}
	public void setnMatches(int nMatches) {
		this.nMatches = nMatches;
	}
	public String getEnWord() {
		return enWord;
	}
	public void setEnWord(String enWord) {
		this.enWord = enWord;
	}
	public String getEsWord() {
		return esWord;
	}
	public void setEsWord(String esWord) {
		this.esWord = esWord;
	}

	
}
