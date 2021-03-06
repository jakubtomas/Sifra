package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    public TextField passwordTextField;
    public Label notification;
    public Label message;


    private Files files;

    public void showInfo(ActionEvent actionEvent) {


    }


    public void openFileChooser() {
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

            System.out.println("get name file " + "  " + files.getNameFile());


        } else if (status == JFileChooser.CANCEL_OPTION) {
            System.out.println("canceled");
        }
    }

    /*
     * Its necessary to create condition what when will happen if the password text field  will be empty   Text field   */


    public void encryptText() {
        Cipher file = new Cipher();
        System.out.println("EncryptText");


        System.out.println(filePath.getText());

        if (passwordTextField.getText().equals("")) {
            notification.setText("Warning  Password is empty");
            System.out.println("Warning  Password is empty  ");
        } else if (filePath.getText().equals("...")) {


            notification.setText("Warning You didn't choose the file");
            System.out.println("Warning You didn't choose the file");

        } else {
            System.out.println(file.encryptText(passwordTextField.getText(), filePath.getText()));
/*
            System.out.println(filePath.getText());
            file.printFileInfo();
*/

            file.createEncryptTxt(file.getResultSentence(), files.getNameFile());
            notification.setText("The process _encrypt is successfully done my friend ");
            ;
        }


    }

    public void decryptText() {
        Cipher file = new Cipher();


        if (passwordTextField.getText().equals("")) {
            System.out.println("Warning  Password is empty");
            notification.setText("Warning Password is empty");

        } else if (filePath.getText().equals("...")) {
            System.out.println("Warning  You didn't choose the file please select file.txt");
            notification.setText("Warning You didn't choose the file");
        } else {
            System.out.println(file.DecryptedText(passwordTextField.getText(), filePath.getText()));
            file.createDecryptTxt(file.getResultSentence(), files.getNameFile());
            notification.setText("The process _encrypt is successfully done my friend ");
        }

        //file.printFileInfo();

        // file.createDecryptTxt(file.getResultSentence(),files.getNameFile());


    }
}
