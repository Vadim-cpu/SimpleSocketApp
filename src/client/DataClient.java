package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

public class DataClient {
	public List<Integer> data;

	public DataClient(List<Integer> data) {
		
		this.data = data;
	}

	public List<Integer> getData() throws UnknownHostException, IOException {
		
		System.out.println("Client >> starting");

		Socket clientSocket = new Socket("localhost", 8888);//80,443
		
		System.out.println("Client >> sending");
		DataOutputStream dout = new DataOutputStream(clientSocket.getOutputStream());
		DataInputStream din = new DataInputStream(clientSocket.getInputStream());
		
		System.out.println("Client sending list>> " + dSt());
		
		dout.writeUTF(dSt());
		dout.flush();
		
		System.out.println("Client received from Server >> "+ din.readUTF());
		
		
		return data;
		
	}
	
	
	private String dSt() {

		StringBuffer sd = new StringBuffer();

		this.data.forEach(i -> sd
				.append(i)
				.append(","));

		return sd.substring(0, sd.length() - 1);
	}

}
