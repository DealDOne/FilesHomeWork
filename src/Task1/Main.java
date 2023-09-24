package Task1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static StringBuilder stringBuilder = new StringBuilder();
    public static void fileCreator1 (File file) {
        if (file.getPath().contains(".")) {
            try {
                if (file.exists() || file.createNewFile()) {
                    stringBuilder.append(file.getName() + " is created" + ";" + "\n");
                } else {
                    stringBuilder.append(file.getName() + " is not created" + ";" + "\n");
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            if (file.exists() || file.mkdir()) {
                stringBuilder.append(file.getName() + " is created" + ";" + "\n");
            } else {
                stringBuilder.append(file.getName() + " is not created" + ";" + "\n");
            }
        }
    }
    public static void main(String[] args) {
        File src = new File("C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\src");
        File res = new File("C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\res");
        File savegames = new File("C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\savegames");
        File temp = new File("C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\temp");
        File main = new File("C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\src\\main");
        File test = new File("C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\src\\test");
        File mainMain = new File("C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\src\\main\\Main.java");
        File mainUtils = new File("C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\src\\main\\Utils.java");
        File drawables = new File("C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\res\\drawables");
        File vectors = new File("C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\res\\vectors");
        File icons = new File("C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\res\\icons");
        File tempTemp = new File("C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\temp\\temp.txt");
        Main.fileCreator1(src);
        Main.fileCreator1(res);
        Main.fileCreator1(savegames);
        Main.fileCreator1(temp);
        Main.fileCreator1(main);
        Main.fileCreator1(mainMain);
        Main.fileCreator1(mainUtils);
        Main.fileCreator1(drawables);
        Main.fileCreator1(vectors);
        Main.fileCreator1(icons);
        Main.fileCreator1(tempTemp);
        String text = Main.stringBuilder.toString();
        System.out.println(Main.stringBuilder.toString());
        try (FileWriter writer = new FileWriter("C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\temp\\temp.txt", false)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

