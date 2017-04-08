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
    public void saveApplicationState(ConnectionData connectionData) {
        try (FileOutputStream fs = new FileOutputStream(Strings.connectionFileName);
                ObjectOutputStream os = new ObjectOutputStream(fs);) {
            os.writeObject(connectionData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveApplicationState(Data data) {
        savePipeCableList(data);
        saveElementList(data);
        saveValveMotorList(data);
    }

    public ConnectionData loadApplicationState() {
        ConnectionData connectionData = null;

        try (FileInputStream fis = new FileInputStream(Strings.connectionFileName);
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

    public Data loadApplicationState(Data data) {
       data.setPipeCableList(loadPipeCableList(data));
       data.setElementList(loadElementList(data));
       data.setValveMotorList(loadValveMotorList(data));
       return data;
    }

    private ObservableList<PipeCable> loadPipeCableList(Data data) {
        try {
            Path path = Paths.get(Strings.dataPipeCableFileName);
            InputStream in = Files.newInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(in);
            List<PipeCable> list = (List<PipeCable>) ois.readObject();

            return FXCollections.observableList(list);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList();
    }

    private ObservableList<Element> loadElementList(Data data) {
        try {
            Path path = Paths.get(Strings.dataElementFileName);
            InputStream in = Files.newInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(in);
            List<Element> list = (List<Element>) ois.readObject();

            return FXCollections.observableList(list);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList();
    }

    private ObservableList<ValveMotor> loadValveMotorList(Data data) {
        try {
            Path path = Paths.get(Strings.dataValveMotorFileName);
            InputStream in = Files.newInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(in);
            List<ValveMotor> list = (List<ValveMotor>) ois.readObject();

            return FXCollections.observableList(list);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList();
    }

    private void savePipeCableList(Data data) {
        try {
            Path path = Paths.get(Strings.dataPipeCableFileName);
            OutputStream fos = Files.newOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(new ArrayList<PipeCable>(data.getPipeCableList()));
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveElementList(Data data) {
        try {
            Path path = Paths.get(Strings.dataElementFileName);
            OutputStream fos = Files.newOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(new ArrayList<Element>(data.getElementList()));
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveValveMotorList(Data data) {
        try {
            Path path = Paths.get(Strings.dataValveMotorFileName);
            OutputStream fos = Files.newOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(new ArrayList<ValveMotor>(data.getValveMotorList()));
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
