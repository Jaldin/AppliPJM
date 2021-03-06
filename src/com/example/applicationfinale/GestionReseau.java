package com.example.applicationfinale;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GestionReseau implements Runnable{
	private static final int SERVERPORT = 9999;
	private static final String SERVER_IP = "192.168.167.102";
	private Socket socket;
	private String str;
	private BufferedReader bReader;
	private String on;
	private String off;
	private EditText et;
	private TextView tv;
	private Runnable edit;
	final Handler handler = new Handler();
	
			
	
	
	
	@Override
	public void run() {
		
		on = "a";
		off = "b";
		
		//D�finition de la connexion et appel de la socket
		try {
			InetAddress serverAddr = InetAddress.getByName(SERVER_IP);
			socket = new Socket(serverAddr, SERVERPORT);
			Log.v("moi","Socket cr��e");
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//
		try {
			//Cr�ation du Reader
			Log.v("moi","debut");
			InputStream is = socket.getInputStream();
			Log.v("moi", "InputStream cr��");
			Reader reader = new InputStreamReader(new BufferedInputStream(is));
			bReader = new BufferedReader(reader);
			Log.v("moi", "Le Reader est cr��");
			
			//Edition en temps r�el du TextView
			while(true){
				str = bReader.readLine();
				Log.v("Log","Dans while true, c'est apr�s readLine !!!");
				//editerTexte();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.v("moi","Exception dans la main");
		}			
	}
	
	
	
	
	
	
	

	//M�thode qui se d�clenche quand on appuie sur send
	public void siClic(View view) {
		try {
			Log.v("moi", "Message envoy�");
			String str = et.getText().toString();
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream())),
					true);
			out.println(str);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//M�thode de on
	public void clicOn(){
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream())),
					true);
			out.println(on);
			Log.v("moi", "LED allum�e");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//M�thode de off
	
	public void clicOff(){
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream())),
					true);
			out.println(off);
			Log.v("moi", "Led �teinte");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	//M�thode qui se d�clenche quand on appuie sur read
	public void siClicR(View view){
		try{
			//String str = bReader.readLine();
			//Log.v("moi","C'est arriv� apr�s readLine");
			tv.setText(str);
			Log.v("moi","C'est arriv� � la fin de clickR");
		} catch(Exception ex) {
			System.out.println("Error creating input stream");
			Log.v("moi","C'est arriv� � la fin de l'exception clickR");
		}
	}
	*/

	
	
	//Socket & Getters

	public Socket getSocket() {
		return socket;
	}





	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
}


