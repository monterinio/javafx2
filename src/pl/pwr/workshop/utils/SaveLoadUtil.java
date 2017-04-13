package pl.pwr.workshop.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.pwr.workshop.data.ConnectionData;
import pl.pwr.workshop.data.Data;
import pl.pwr.workshop.data.Element;
import pl.pwr.workshop.data.PipeCable;
import pl.pwr.workshop.data.Strings;
import pl.pwr.workshop.data.ValveMotor;

public class SaveLoadUtil {

    private SaveLoadUtil() {
    }

    public static void saveApplicationState(ConnectionData connectionData) {
        try (FileOutputStream fs = new FileOutputStream(Strings.CONNECTION_FILE_NAME);
                ObjectOutputStream os = new ObjectOutputStream(fs);) {
            os.writeObject(connectionData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionData loadApplicationState() {
        ConnectionData connectionData = null;

        try (FileInputStream fis = new FileInputStream(Strings.CONNECTION_FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            connectionData = (ConnectionData) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connectionData;
    }

    public static Data loadApplicationState(Data data) {
        loadPipeCableList(data);
        loadElementList(data);
        loadValveMotorList(data);
        return data;
    }


    private static void loadPipeCableList(Data data) {
        data.setPipeCableList(loadGeneric(new PipeCable(), Paths.get(Strings.DATA_PIPECABLE_FILE_NAME)));
    }

    private static void loadElementList(Data data) {
        data.setElementList(loadGeneric(new Element(), Paths.get(Strings.DATA_ELEMENT_FILE_NAME)));
    }

    private static void loadValveMotorList(Data data) {
        data.setValveMotorList(loadGeneric(new ValveMotor(), Paths.get(Strings.DATA_VALVEMOTOR_FILE_NAME)));
    }

    private static <T> ObservableList<T> loadGeneric(T t, Path path) {
        try (InputStream in = Files.newInputStream(path); ObjectInputStream ois = new ObjectInputStream(in);) {
            List<T> list = (List<T>) ois.readObject();
            return FXCollections.observableList(list);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList();
    }

    public static void saveApplicationState(Data data) {
        savePipeCableList(data);
        saveElementList(data);
        saveValveMotorList(data);
    }

    private static void savePipeCableList(Data data) {
        saveGeneric(new ArrayList<PipeCable>(data.getPipeCableList()), Paths.get(Strings.DATA_PIPECABLE_FILE_NAME));
    }

    private static void saveElementList(Data data) {
        saveGeneric(new ArrayList<Element>(data.getElementList()), Paths.get(Strings.DATA_ELEMENT_FILE_NAME));
    }

    private static void saveValveMotorList(Data data) {
        saveGeneric(new ArrayList<ValveMotor>(data.getValveMotorList()), Paths.get(Strings.DATA_VALVEMOTOR_FILE_NAME));
    }

    private static <T> void saveGeneric(ArrayList<T> data, Path path) {
        try (OutputStream fos = Files.newOutputStream(path); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
