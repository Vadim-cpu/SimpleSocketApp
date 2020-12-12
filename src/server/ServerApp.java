package server;

import java.io.IOException;

public class ServerApp {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Server =-> Starting ");
				
		DataServer dataServer = new DataServer();
		dataServer.start();
		System.out.println("Server =-> Ending ");
	}

}
