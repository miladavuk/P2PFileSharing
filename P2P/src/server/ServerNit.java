package server;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerNit extends Thread{
	
	    //ulazni i izlazni tok
		BufferedReader ulazniTokOdKlijenta = null;
		PrintStream izlazniTokKaKlijentu = null;
		
		Socket soketZaKom = null;
		//atributi korisnika
		String username = null;
		String nazivFajla=null;
			
		
		
		//niz svih klijenata na serveru
		ServerNit[] klijenti;
		
		public ServerNit(Socket soket, ServerNit[] klijent){
			this.soketZaKom = soket;
			this.klijenti = klijent;
			
		}
		
		public void run(){
			
			
			
		}

}
