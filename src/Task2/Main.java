package Task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void saveGame(String path, GameProgress gameProgress){
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
             oos.writeObject(gameProgress);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void zipFiles(String path, List<String> list){
            try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(path))) {
                for (int i = 0; i <  list.size(); i++){
                    try (FileInputStream fis = new FileInputStream(list.get(i))){
                        ZipEntry entry = new ZipEntry("save" + (i + 1) + ".dat");
                        zout.putNextEntry(entry);
                        byte[] buffer = new byte[fis.available()];
                        fis.read(buffer);
                        zout.write(buffer);
                        zout.closeEntry();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
    }

    public static void main(String[] args) {
        GameProgress progress1 = new GameProgress(100, 2, 3, 34);
        GameProgress progress2 = new GameProgress(101, 3, 4, 39);
        GameProgress progress3 = new GameProgress(102, 1, 4, 38);
        Main.saveGame("C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\savegames\\save1.dat", progress1);
        Main.saveGame("C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\savegames\\save2.dat", progress2);
        Main.saveGame("C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\savegames\\save3.dat", progress3);
        List<String> list = new ArrayList<>(Arrays.asList("C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\savegames\\save1.dat", "C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\savegames\\save2.dat", "C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\savegames\\save3.dat"));
        Main.zipFiles("C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\savegames\\zip.zip", list);
        System.out.println(list);
        File file1 = new File("C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\savegames\\save1.dat");
        file1.delete();
        File file2 = new File("C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\savegames\\save2.dat");
        file2.delete();
        File file3 = new File("C:\\Users\\1\\OneDrive\\Рабочий стол\\Games\\savegames\\save3.dat");
        file3.delete();
    }

}
