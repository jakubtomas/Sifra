package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import javax.swing.JFileChooser;
import java.io.File;
/*import java.nio.file.Files;*/

// ci je male alebo velke pismena len text sa bude
public class Controller {

    public Pane mainPane;
    public Label filePath;
    public Label fileContent;

    public javafx.scene.control.Button Button;
    public javafx.scene.control.Button Button2;
    public javafx.scene.control.Button Button3;


    private Files files;
    public void showInfo(ActionEvent actionEvent) {


    }


    public void openFileChooser(){
        JFileChooser fileChooser = new JFileChooser("C:\\Users\\install\\IdeaProjects\\Sifra\\src\\");
        int status = fileChooser.showOpenDialog(null);

        if (status == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            //function getParent    Parent
            //function getAbsolutePath    absolute Path
            files = new Files(selectedFile.getAbsolutePath(), selectedFile.getParent());

            System.out.println(files.getPath() + "   " + files.getParent());

            filePath.setText(files.getPath()); // show text
           // filePath.setText(files.getParent()); // show text

            fileContent.setText(files.getFileContent()); // show text

            System.out.println(files.getFileContent());

            System.out.println("get name file " + "  " +  files.getNameFile());



        } else if (status == JFileChooser.CANCEL_OPTION) {
            System.out.println("canceled");
        }
    }


    public void encryptText() {
        Cipher file = new Cipher();
        System.out.println("vypis");
        System.out.println(file.encryptText("Zebra",filePath.getText()));
        System.out.println(filePath.getText());
        file.printFileInfo();

        file.createEncryptTxt(file.getResultSentence(),files.getNameFile());

    }

    public void decryptText() {
        Cipher file = new Cipher();
        System.out.println(file.DecryptedText("Zebra",filePath.getText()));
        //file.printFileInfo();

       // file.createDecryptTxt(file.getResultSentence(),files.getNameFile());


    }
}
