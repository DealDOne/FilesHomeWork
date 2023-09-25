package Task1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void fileCreator(String path){
        File file = new File(path);
        try {
            if (file.exists() || file.createNewFile()) {
                stringBuilder.append(file.getName() + " is created" + ";" + "\n");
            } else {
                stringBuilder.append(file.getName() + " is not created" + ";" + "\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void directoryCreator(String path) {
        File file = new File(path);
        if (file.exists() || file.mkdir()) {
            stringBuilder.append(file.getName() + " is created" + ";" + "\n");
        } else {
            stringBuilder.append(file.getName() + " is not created" + ";" + "\n");
        }
    }

    public static void main(String[] args) {

        List<String> fileList = new ArrayList<>(Arrays.asList(
                "C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\src\\main\\Main.java",
                "C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\src\\main\\Utils.java",
                "C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\temp\\temp.txt"));

        List<String> directoryList = new ArrayList<>(Arrays.asList(
                "C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\src",
                "C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\res",
                "C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\savegames",
                "C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\temp",
                "C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\src\\main",
                "C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\src\\test",
                "C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\res\\drawables",
                "C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\res\\vectors",
                "C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\res\\icons"));

        for (String path: directoryList) {
            Main.directoryCreator(path);
        }

        for (String path: fileList) {
            Main.fileCreator(path);
        }

        String text = Main.stringBuilder.toString();
        System.out.println(text);
        try (FileWriter writer = new FileWriter("C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\temp\\temp.txt", false)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

