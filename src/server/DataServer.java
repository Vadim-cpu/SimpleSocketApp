package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DataServer {
	
	private ServerSocket serverSocket;
	private Socket clientSocket;
	
	public void start() throws IOException  {

		serverSocket = new ServerSocket(8888);

		System.out.println("Server =-> Client Waiting");
		clientSocket = serverSocket.accept();
		
		DataInputStream din = new DataInputStream(clientSocket.getInputStream());
		DataOutputStream dout = new DataOutputStream(clientSocket.getOutputStream());

		String data = din.readUTF();
		
		System.out.println("Server =-> received: " + data);

		System.out.println("Server =-> Sent : " + getAverage(data));
		dout.writeUTF(getAverage(data));
	}
		private String getAverage(String data) {

			int summ = 0;
			int i = 0;
			
			for (String n : data.split(",")) {
				summ = summ + Integer.parseInt(n) ;
				i ++;
			}


			return "Average is " + summ / i;

		}

}
