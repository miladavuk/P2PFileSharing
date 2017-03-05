package klijent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class FileKlijent implements Runnable {
	
	
	//deklaracija promenljivih
	static Socket soketZaKomunikaciju = null;
	//ulaz-izlaz za soket
	static PrintStream izlazniTokKaServeru = null;
	static BufferedReader ulazniTokOdServera = null;
	//ulaz sa konzole
	static BufferedReader ulazKonzola=null;
	//da li je korisnik izasao iz chat sobe
	static boolean kraj = false;

	public static void main(String[] args) {
		try {
			//broj porta file servera
			int port = 5555;
			
			
			//povezujemo se na host
			soketZaKomunikaciju = new Socket("localhost", port);
			
			//inicijalizacija ulaza sa konzole
			ulazKonzola = new BufferedReader(new InputStreamReader(System.in));
			
			//inicijalizacija ulazno-izlaznih tokova
			izlazniTokKaServeru = new PrintStream(soketZaKomunikaciju.getOutputStream());
			ulazniTokOdServera = new BufferedReader
					(new InputStreamReader(soketZaKomunikaciju.getInputStream()));
			
			//pravi se nit koja ce da cita poruke
			new Thread(new FileKlijent()).start();
			
			//dokle god nije kraj pise serveru ono sto ucitava sa konzole, liniju po liniju
			while(!kraj){
				izlazniTokKaServeru.println(ulazKonzola.readLine());
			}
			///zatvaramo soket
			soketZaKomunikaciju.close();
			
			
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host ");
		} catch (IOException e) {
			System.err.println("IOException: " + e);
		}

	}
	
	
	
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
