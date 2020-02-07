package sample;

import javafx.event.ActionEvent;

// ci je male alebo velke pismena len text sa bude
public class Controller {


    public void showInfo(ActionEvent actionEvent) {
        ReadFile priecinok = new ReadFile();
        priecinok.printdocument();
    }
}
