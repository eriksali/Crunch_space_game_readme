package hellofx;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Spinner;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class App extends Application {
   @Override
    public void start(Stage primaryStage) throws Exception {

      
      primaryStage.setScene(new Scene(createContent(primaryStage)));
      primaryStage.getScene().getStylesheets().add(App.class.getResource("Main.css").toExternalForm());
      primaryStage.show();
    }

    public int resu1;
    public int resu2 = -1;
    public int number1;
    public int number2;
    public int counter = 1;
    public int LEVEL = 10;
    public int gameSize = 5;

    public Parent createContent(Stage primaryStage) {
      
      Menu menu = new Menu("Click for Options!");
      
      MenuItem item1 = new MenuItem("Addition");
      MenuItem item2 = new MenuItem("Subtraction");
      MenuItem item3 = new MenuItem("Multiplication");
      MenuItem item4 = new MenuItem("Division");
      Label welcome = new Label("Welcome to Calculation Crunch");
      welcome.setId("welcome");
      welcome.setStyle("-fx-text-fill: white;-fx-font-size: 20px;");
   
      menu.getItems().addAll(item1, item2,item3,item4);
      
   
      MenuBar menuBar = new MenuBar(menu);
      menuBar.setTranslateX(220);
      menuBar.setTranslateY(350);
      
      welcome.setTranslateX(155);
      welcome.setTranslateY(313);
     
      item1.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent event) {


            //int gameSize = 5;
            VBox gameStartPane = new VBox(10);
            gameStartPane.setAlignment(Pos.CENTER);
            HBox hBoxStartButtons = new HBox(10);
            hBoxStartButtons.setAlignment(Pos.CENTER);
            Button btnExit = new Button("Exit");
            Button btnStartGame = new Button("Start");
            hBoxStartButtons.getChildren().addAll(btnStartGame, btnExit);
            HBox hBoxGameOptions = new HBox(10);
            hBoxGameOptions.setAlignment(Pos.CENTER);
            Spinner<Integer> startGameSize = new Spinner<>(1, 100, gameSize, 1);
            hBoxGameOptions.getChildren().addAll(new Label("Game Level:"), startGameSize);
            gameStartPane.getChildren().addAll(new Label("Calculation Crunch"), new Label(""), hBoxGameOptions, hBoxStartButtons);

            gameStartPane.setAlignment(Pos.CENTER);
            Scene startGameScene = new Scene(gameStartPane, 300, 150);

            btnExit.setOnAction(e -> {
                  primaryStage.close();
            });

            btnStartGame.setOnAction(e -> {
               gameSize = startGameSize.getValue();


               primaryStage.setTitle("Space game!");
               primaryStage.setScene(startGameScene);
               primaryStage.show();


               Pane pane = new Pane();
               Label question = new Label();
               question.setText("");
               Label answer = new Label();
               TextField result = new TextField();
               Text flag = new Text();
               Addition addition = new Addition(result, answer, question, flag, gameSize);
               Scene scene = new Scene(pane, 600, 700);
               scene.getStylesheets().add(App.class.getResource("Game.css").toExternalForm());
               primaryStage.setTitle("Space game!");
               primaryStage.setScene(scene);
               primaryStage.show();

               addition.loadText(pane);
               addition.submitBtn(pane);
               addition.renewBtn(pane);
               addition.homeBtn(pane, primaryStage);

               // Pane pane = new Pane();
               // Label question = new Label("");
               // Label answer = new Label();

               // Text flag = new Text();
               // TextField result = new TextField();

               
               // Addition gamepane = new Addition(result, answer, question, flag, gameSize);
               // //GamePane gamepane = new GamePane(result, answer, question, flag, gameSize);

               // Scene gameScene = new Scene(pane, 600, 600);
               
               // primaryStage.setScene(gameScene);

               // gamepane.loadText(pane);
               // gamepane.submitBtn(pane);
               // gamepane.renewBtn(pane);
               // gamepane.homeBtn(pane, primaryStage);
            });

            primaryStage.setTitle("Space game!");
            primaryStage.setScene(startGameScene);
            primaryStage.show();
            


        }
     });
        
     item2.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent event) {
            
            Pane pane = new Pane();
            Label question = new Label();
            question.setText("");
            Label answer = new Label();
            Text flag = new Text();
            TextField result = new TextField();
            Subtract subtraction = new Subtract(result, answer, question, flag);

            Scene scene = new Scene(pane, 600, 700);
            scene.getStylesheets().add(App.class.getResource("Game.css").toExternalForm());
            primaryStage.setTitle("Space game!");
            primaryStage.setScene(scene);
            primaryStage.show();
            subtraction.loadText(pane);
            subtraction.submitBtn(pane);
            subtraction.renewBtn(pane);
            subtraction.homeBtn(pane, primaryStage);

         }
      });
      item3.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent event) {
            
            Pane pane = new Pane();
            Label question = new Label();
            question.setText("");
            Label answer = new Label();
            Text flag = new Text();
            TextField result = new TextField();
            Multiplication multiply = new Multiplication(result, answer, question, flag);

            Scene scene = new Scene(pane, 600, 700);
            scene.getStylesheets().add(App.class.getResource("Game.css").toExternalForm());
            primaryStage.setTitle("Space game!");
            primaryStage.setScene(scene);
            primaryStage.show();

            multiply.loadText(pane);
            multiply.submitBtn(pane);
            multiply.renewBtn(pane);
            multiply.homeBtn(pane, primaryStage);
         }
      });
      item4.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent event) {
            
            Pane pane = new Pane();
            Label question = new Label();
            question.setText("");
            Label answer = new Label();
            TextField result = new TextField();
            Text flag = new Text(); 
            Division divide = new Division(result,answer, question, flag); 

            Scene scene = new Scene(pane, 600, 700);
           scene.getStylesheets().add(App.class.getResource("Game.css").toExternalForm());
            primaryStage.setTitle("Space game!");
            primaryStage.setScene(scene);
            primaryStage.show();

            divide.loadText(pane);
            divide.submitBtn(pane);
            divide.renewBtn(pane);
            divide.homeBtn(pane, primaryStage);
         }
      }); 
      var root = new Pane(menuBar, welcome);
      root.setPrefSize(600, 700);
      return root;
   }

   public static void display() {
        Stage popupwindow=new Stage();
            
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Finish Line");   
        popupwindow.setHeight(300);
        popupwindow.setWidth(300);
       
        
        Label label2 = new Label ("");
        label2.setFont(new Font("Arial", 30)); 
        label2.setTextFill(Color.color(0, 0, 1));    
        label2.setText("Good job");  
            
        Label label= new Label(""); 
        //label.setStyle("-fx-color: blue");
        label.setFont(new Font("Arial", 30)); 
        label.setTextFill(Color.color(0, 0, 1));    
        label.setText("You made it to the moon!");   
            
        Button button= new Button("OK");   
        button.setOnAction(e -> popupwindow.close());
        VBox layout= new VBox(10);
       
        layout.getChildren().addAll(label,label2, button);
        layout.setAlignment(Pos.CENTER);
        Scene scene1= new Scene(layout, 250, 160);
        scene1.getStylesheets().add(App.class.getResource("congrats.css").toExternalForm());
        popupwindow.setScene(scene1);
        popupwindow.showAndWait(); 
    }

   public static void main(String args[]){
      launch(args);
   }
}
