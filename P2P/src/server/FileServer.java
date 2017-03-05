package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.LinkedList;

public class FileServer {
	
	static int maxBrKlijenata=50;
	static ServerNit klijenti[] = new ServerNit[maxBrKlijenata];
	static String dostupniFajlovi = ""; 
	
	public static void main(String[] args) throws IOException {
		int serverPort = 5555;
		Socket klijentSoket = null;
		ServerSocket serverSoket;
		try {
			serverSoket = new ServerSocket(serverPort);
			while (true) {
				klijentSoket = serverSoket.accept();
				for (int i = 0; i <maxBrKlijenata; i++) {
					//na slobodnom mestu pravimo nit koja ce raditi sa klijentom i
					//pokrecemo je
					if (klijenti[i]==null){
						klijenti[i]=new ServerNit(klijentSoket, klijenti);
						klijenti[i].start();
						break;
					}
					
				}			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

