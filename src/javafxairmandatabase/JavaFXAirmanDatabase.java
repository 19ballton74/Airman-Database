/*
 * Author: Brock A. Allton
 * Purpose: Setup a GUI interface for a database to be used to track Airmen assigned
 *          to a work area
 */
package javafxairmandatabase;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;


public class JavaFXAirmanDatabase extends Application {
    
    private Stage stage;
    private Label insertLabel, searchLabel;
    private BorderPane introPane;
    private Button introInsertBtn, introSearchBtn, exitBtn;
    private Text introHeading;
    private Scene introScene;
    private HBox introTopPane, introInsertPane, introSearchPane, introExitPane;
    private VBox introSelectPane;
    private BorderPane mainPane;
    
    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        
        //------Setup the Intro screen that will display when started-----------
        
        //Create top pane for the introduction screen, add to HBox
        introHeading = new Text("Welcome To the Airman's Database");
        introHeading.setFont(Font.font("Verdana",FontWeight.BOLD, 15));//set the font size, set bold, and set as Verdana
        introHeading.setFill(Color.BLUE);
        introTopPane = new HBox(introHeading);//Create top pane and add intro
                                                   //heading
        introTopPane.setAlignment(Pos.CENTER);//Center the text
        introTopPane.setPadding(new Insets(20,10,20,10));/*Set padding around the top
                                                           pane*/
        
        //Create the insert label and insert button, add to introInsertPane 
        //add that pane to a HBox
        insertLabel = new Label("Insert A New Airman");
        insertLabel.setPadding(new Insets(10));
        introInsertBtn = new Button("Insert");
        introInsertBtn.setPrefWidth(80);
        introInsertBtn.setOnAction(e -> introInsertBtn_Click());
        introInsertPane = new HBox(30,insertLabel, introInsertBtn);
        introInsertPane.setPadding(new Insets(5));//Set padding around pane
        
        //Create the search label, search button, add to introSearchPane, add that
        //pane to a HBox
        searchLabel = new Label("Search the Database");
        searchLabel.setPadding(new Insets(10));
        introSearchBtn = new Button("Search");
        introSearchBtn.setPrefWidth(80);
        introSearchBtn.setOnAction(e -> introSearchBtn_Click());
        introSearchPane = new HBox(30, searchLabel, introSearchBtn);
        introSearchPane.setPadding(new Insets(5));//Set padding around pane
        
        //Create the exit button for the intro screen, add to an HBox
        exitBtn = new Button("Exit");
        exitBtn.setPrefWidth(80);
        exitBtn.setOnAction(e -> exitBtn_Click());
        introExitPane = new HBox(exitBtn);
        introExitPane.setPadding(new Insets(5));//Set the padding around pane
        introExitPane.setAlignment(Pos.CENTER);
        
        //Create a VBox called introSelectPane, add the introInsertPane and 
        //introSearchPane
        introSelectPane = new VBox(introInsertPane, introSearchPane, introExitPane);
        
        //Create a BorderPane called mainPane which will be the first screen
        //shown when the program starts, add introTopPane and intoSelectPane
        mainPane = new BorderPane();
        mainPane.setTop(introTopPane);
        mainPane.setCenter(introSelectPane);
     
        //Add the mainPane to the introScence
        introScene = new Scene(mainPane, 320, 200);
        
        //Set up so the introScene starts up first for selection
        primaryStage.setScene(introScene);
        primaryStage.setTitle("Airman's Database");
        primaryStage.show();
      
  
    }

    private void introInsertBtn_Click() {
        
    }
    
    private void introSearchBtn_Click() {
        
    }
    
    private void exitBtn_Click() {
        stage.close();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

    

    

    
    
}
