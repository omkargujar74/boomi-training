import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
    private String filename;

    public FileHandling(String filename) {
        this.filename = filename;
    }

    public boolean createFile(){
        File newFile = new File(filename);
        try {
            newFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFile.exists();
    }

    public boolean addPersonalInfoToFile(PersonalInfo personalInfo){
        boolean status = false;
        try {
            FileWriter fileWriter = new FileWriter(filename);
            fileWriter.write(personalInfo.toString());
            fileWriter.close();
            status =true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return status;
    }

    public String getPersonalInfoFromFile(){
        StringBuilder info = new StringBuilder();
        File readfile = new File(filename);
        try {
            Scanner scanner = new Scanner(readfile);
            while (scanner.hasNextLine())
            {
                info.append(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return info.toString();
    }

    public boolean isExist(String filename){
        File checkFile = new File(filename);
        return checkFile.exists();
    }
}
