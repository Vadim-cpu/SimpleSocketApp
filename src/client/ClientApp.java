package client;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public class ClientApp {

	public static void main(String[] args) throws UnknownHostException, IOException {
		List<Integer> ints = Arrays.asList(2,4,6);

		DataClient dataClient = new DataClient(ints);

		dataClient.getData();

	}

}
