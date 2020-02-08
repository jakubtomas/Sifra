package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Files {

    private String path;
    private String parent;

    private File myFile ;
    private String nameFile;

    public Files(String path, String parent) {
        this.path = path;
        this.parent = parent;
        this.myFile = new File(path);
        this.nameFile = deleteTxtCharacter(myFile.getName());
    }

    public String getPath() {
        return this.path;
    }
    public String getParent() {
        return this.parent;
    }

    public String getNameFile() {
        return this.nameFile;
    }

    private String deleteTxtCharacter (String filename) {

        return filename.substring(0, filename.length() - 4);
    }


    public String getFileContent(){
        StringBuilder data = new StringBuilder();
        try{

            Scanner myReader = new Scanner(myFile);
            while(myReader.hasNextLine()){
                data.append("\n").append(myReader.nextLine());
            }


            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data.toString();
    }






}
