package view;


import ctrl.Ctrl;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Matches;
import model.Tournoi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fontaine César
 */
public final class View implements Observer {
    
    //TITLE + FENETRE SIZE
    private final int HEIGHT = 690;
    private final int WIDTH = 750;
    private final String TITLE = "Gestion de tournois";
    
    //ObservableList
    public List<Tournoi> tournoiList;
    ObservableList<Tournoi> olTournoi = FXCollections.observableList(tournoiList);
    
    //GRIDPANE
    GridPane gpTournoi = new GridPane();
    GridPane gpInscrit = new GridPane();
    GridPane gpMatch = new GridPane();
    Ctrl ctrl;

    
    public View(Stage ps, Ctrl ctrl) throws Exception{
    
        
        this.ctrl = ctrl;
        //Boutons 
        Button btnAddMatch = new Button("Ajouter");
        btnAddMatch.setPadding(new Insets(5));
        
        Button btnDelMatch = new Button("Editer");
        btnDelMatch.setPadding(new Insets(5));
        
        Button btnEditMatch = new Button("Supprimer");
        btnEditMatch.setPadding(new Insets(5));  
        
        //Label
        Label labelTournoi = new Label("Tournois");
        labelTournoi.setStyle("-fx-font-weight: bold");
        labelTournoi.setTextFill(Color.web("#f48024"));
        labelTournoi.setFont(new Font("Arial",20));
        
        Label labelInscrit = new Label("Inscrits");
        labelInscrit.setStyle("-fx-font-weight: bold");
        labelInscrit.setTextFill(Color.web("#f48024"));
        labelInscrit.setFont(new Font("Arial",20));
        
        Label labelMatch = new Label("Matchs");
        labelMatch.setStyle("-fx-font-weight: bold");
        labelMatch.setTextFill(Color.web("#f48024"));
        labelMatch.setFont(new Font("Arial",20));
        
        //LIST + OBSERVABLE
        ListView<Tournoi> lvTournoi = new ListView<>(olTournoi);
        //ObservableList<Tournoi> olTournoi = 
        lvTournoi.setMaxHeight(280);
        ListView<String> lvInscrit = new ListView<>();
        
        //TABLE
        TableView<Matches> tvMatch = new TableView<>();
        
        //HBOX & VBOX
        HBox hboxTournoi = new HBox();
        
        HBox hboxInscrit = new HBox();
        
        HBox hboxMatchBtn = new HBox();
        hboxMatchBtn.getChildren().addAll(btnAddMatch, btnEditMatch, btnDelMatch); 
        hboxMatchBtn.setPadding(new Insets(10,5,10,5));
        hboxMatchBtn.setSpacing(30.0);
        hboxMatchBtn.setAlignment(Pos.CENTER);
        
        // CONTENEUR TOURNOI
        BorderPane bpTournoi = new BorderPane();
        lvTournoi.setOrientation(Orientation.HORIZONTAL);
        bpTournoi.setTop(labelTournoi);
        bpTournoi.setCenter(lvTournoi);
        bpTournoi.setPadding(new Insets(5));
        BorderPane.setAlignment(labelTournoi,Pos.TOP_CENTER);
        
        //CONTENEUR INSCRIT
                
        BorderPane bpInscrit = new BorderPane();
        bpInscrit.setTop(labelInscrit);
        bpInscrit.setCenter(lvInscrit);
        bpInscrit.setPadding(new Insets(5));
        BorderPane.setAlignment(labelInscrit,Pos.TOP_CENTER);
        
        
        //CONTAINER MATCH
        BorderPane bpMatch = new BorderPane();
        bpMatch.setTop(labelMatch);
        bpMatch.setCenter(tvMatch);
        bpMatch.setBottom(hboxMatchBtn);
        bpMatch.setPadding(new Insets(5));
        BorderPane.setAlignment(labelMatch,Pos.TOP_CENTER);
        
        //BORDERPANE ROOT
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(5));
        root.setTop(bpTournoi);
        root.setLeft(bpInscrit);
        root.setCenter(bpMatch);
        root.setStyle("-fx-background-color: #222426");
        
        //SCENE      
        Scene scene = new Scene(root, HEIGHT, WIDTH);
        
        //PRIMARYSTAGE
        ps.setScene(scene);
        ps.setTitle(TITLE);
        ps.setResizable(false); 
        ps.getIcons().add(new Image("file:icon.png"));
        ps.show();
        
        
        
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
