package com.example.applicationfinale;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;



public class SecuriteWindow extends Activity {
	


		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.securitewindow);
        
        
		Bundle paille = getIntent().getExtras();								//Cr�ation du bundle de r�ception des donn�es
		String captp =paille.getString("CapteurP");								//R�cuperation des donn�es par appel de leurs identifiants
		String captf =paille.getString("CapteurF");
 
       
        
        
    

	 
	 ImageView iconeporte = (ImageView) findViewById(R.id.porteicone);
	 TextView resultporte = (TextView) findViewById(R.id.porte);
	 
	 
    if(captp.equals("ouvert"))																//Affichage de l'�tat des capteurs dans l'activit�
    		{resultporte.setText("Ouverte");
    		resultporte.setTextColor(Color.parseColor("#FF0000"));
    		iconeporte.setImageDrawable(getResources().getDrawable(R.drawable.refuse));}
    else if(captp.equals("ferm�"))
    		{resultporte.setText("Ferm�e");
    		resultporte.setTextColor(Color.parseColor("#3AF24B"));
    		iconeporte.setImageDrawable(getResources().getDrawable(R.drawable.valide));}
    else
    		{resultporte.setText("Erreur");}
    		
    
    
    ImageView iconefenetre = (ImageView) findViewById(R.id.fenetreicone);
    TextView resultfenetre = (TextView) findViewById(R.id.fenetre);
	 
	 
    if(captf.equals("ouvert"))
    		{resultfenetre.setText("Ouverte");
    		resultfenetre.setTextColor(Color.parseColor("#FF0000"));
    		iconefenetre.setImageDrawable(getResources().getDrawable(R.drawable.refuse));}
    else if(captf.equals("ferm�"))
    		{resultfenetre.setText("Ferm�e");
    		resultfenetre.setTextColor(Color.parseColor("#3AF24B"));
    		iconefenetre.setImageDrawable(getResources().getDrawable(R.drawable.valide));}
    else
    	resultfenetre.setText("Erreur");
 
    
    }
}
