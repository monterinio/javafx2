package pl.pwr.workshop.utils;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import pl.pwr.workshop.data.ConnectionData;
import pl.pwr.workshop.data.Data;
import pl.pwr.workshop.data.OrderedItemsData;
import pl.pwr.workshop.data.Strings;

public class ConnectionUtil {

    private ConnectionUtil() {  }
    //Dodane try-with-resources
    public static void run(ConnectionData connectionData, Data data, OrderedItemsData orderedItemsData) {
        try (
            Socket socket = new Socket(connectionData.getServerIP(), Strings.PORT_NUMBER);
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);) {
            objectOutputStream.writeObject(data);
            objectOutputStream.writeObject(orderedItemsData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
