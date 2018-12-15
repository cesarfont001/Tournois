/*
package view;

import ctrl.Ctrl;
import java.util.Observable;
import java.util.Observer;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Text;

public class ViewSimpleDemo extends VBox implements Observer {

    private static final int TEXTSIZE = 400, SPACING = 10;

    private final HBox editionZone = new HBox(), textZone = new HBox();
    private final TextField editLine = new TextField();
    private final ListView<String> lvLines = new ListView<>();
    private final Label lbNbLines = new Label();
    private final Button btAddLine = new Button();

    private final Ctrl ctrl;

    public ViewSimpleDemo(Stage primaryStage, Ctrl ctrl) {
        this.ctrl = ctrl;
        configComponents();
        configListeners();
        Scene scene = new Scene(this, 600, 400);
        primaryStage.setTitle("Gestion de texte - MVC");
        primaryStage.setScene(scene);
    }

    private void configComponents() {
        configEditZone();
        configTextZone();
        configWindow();
    }

    private void configEditZone() {
        editionZone.setSpacing(SPACING);
        editLine.setPrefWidth(TEXTSIZE);
        btAddLine.setText("Nouvelle ligne");
        editionZone.getChildren().addAll(editLine, btAddLine);
    }

    private void configTextZone() {
        textZone.setSpacing(SPACING);
        lvLines.setPrefWidth(TEXTSIZE);
        textZone.getChildren().addAll(lvLines, lbNbLines);
    }

    private void configWindow() {
        this.setPadding(new Insets(SPACING));
        this.setSpacing(10);
        this.getChildren().addAll(editionZone, textZone);
    }

    private void configListeners() {
        configListenersEditZone();
        configListenersTextZone();
    }

    private void configListenersEditZone() {
        configListenerEditLine();
        configListenerBtAddLine();
    }

    private void configListenerEditLine() {
        editLine.setOnAction(e -> {
            if (editLine.isEditable()) {
                ctrl.updateSelectedLine(editLine.getText());
            }
        });
    }

    private void configListenerBtAddLine() {
        btAddLine.setOnAction((ActionEvent event) -> {
            ctrl.addLine();
        });
    }

    private void configListenersTextZone() {
        configFocusListener();
        configListenerSelectionLine();
    }

    private void configFocusListener() {
        lvLines.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) 
                editLine.requestFocus();
        });
        editLine.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) 
                editLine.selectAll();
        });
    }

    private void configListenerSelectionLine() {
        getListViewModel().selectedIndexProperty()
                .addListener(o -> {
                    ctrl.lineSelection(getListViewModel().getSelectedIndex());
                });
    }

    @Override
    public void update(Observable o, Object arg) {
        Text text = (Text) o;
        Text.TypeNotif typeNotif = (Text.TypeNotif) arg;
        switch (typeNotif) {
            case INIT:
                lvLines.getItems().setAll(text.getLines());
                lbNbLines.setText("Nombre de lignes : " + text.nbLines());
                setTextZoneEditable(false);
                break;
            case LINE_SELECTED:
                setTextZoneEditable(true);
                editLine.setText(getListViewModel().getSelectedItem());
                break;
            case LINE_UNSELECTED:
                setTextZoneEditable(false);
                getListViewModel().select(-1);
                break;
            case LINE_UPDATED:
                lvLines.getItems().set(text.SelectedIndex(), text.SelectedLine());
                editLine.setText("");
                setTextZoneEditable(false);
                getListViewModel().select(-1);
                break;
            case LINE_ADDED:
                lvLines.getItems().add(text.SelectedLine());
                lbNbLines.setText("Nombre de lignes : " + text.nbLines());
                getListViewModel().select(text.SelectedIndex());
                setTextZoneEditable(true);
                break;
        }
    }

    private SelectionModel<String> getListViewModel() {
        return lvLines.getSelectionModel();
    }

    private void setTextZoneEditable(boolean b) {
        editLine.setEditable(b);
        btAddLine.setDisable(b);
    }

}
*/
