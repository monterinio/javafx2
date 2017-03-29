package pl.pwr.workshop.utils;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import pl.pwr.workshop.data.ConnectionData;
import pl.pwr.workshop.data.Data;
import pl.pwr.workshop.data.Strings;

public class ConnectionUtil {
	private Socket socket;
	private OutputStream outputStream;
	private ObjectOutputStream objectOutputStream;

	public void run(ConnectionData connectionData, Data data) {
		try {
			socket = new Socket(connectionData.getServerIP(),Strings.portNumber);
			outputStream = socket.getOutputStream();
			objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(data);
			closeConnection();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		try {
			objectOutputStream.close();
			outputStream.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
