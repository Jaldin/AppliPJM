package com.example.applicationfinale;


public class ActionneurAN extends Actionneur {
protected int etatI;
	
	protected int getEtat(){
		return etatI;
	}
	private void setEtat(int etatVrai){
		etatI = etatVrai;
	}
	private void commander(int consigne){
		etatI = etatI + consigne;
	}
	
}
