package hellofx;
import java.util.Random;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Multiplication extends App {

    private Label question;
    private Label answer;
    private Text flag;
    private TextField resu1lt;

    Random rand;
    
    Multiplication(TextField resu1lt, Label answer, Label question, Text flag) {
        this.question = question;
        this.answer = answer;
        this.resu1lt = resu1lt;
        this.flag = flag;
    }

    public void loadText(Pane gp) {

      
         Label yay = new Label();
       
        gp.getChildren().add(question);
        gp.getChildren().add(resu1lt);
        gp.getChildren().add(answer);
        gp.getChildren().add(flag);
        gp.getChildren().add(yay);

        
        question.setLayoutX(60);
        question.setLayoutY(200);

      
        answer.setLayoutX(120);
        answer.setLayoutY(200);
        flag.setLayoutX(210);
        flag.setLayoutY(215);

        resu1lt.setLayoutX(60);
        resu1lt.setLayoutY(220);

        rand = new Random(); 
        number1 = rand.nextInt(12);
        number2 = rand.nextInt(12);
        question.setText(number1 + " x " + number2);
    }

    public void submitBtn(Pane gp) {
        
        Button submit = new Button("Submit");
        TranslateTransition transition = new TranslateTransition();
        ImageView rocket = new ImageView(getClass().getResource("rocket.png").toExternalForm());

        gp.getChildren().add(submit);
        gp.getChildren().add(rocket);

        submit.setLayoutX(230);
        submit.setLayoutY(220);

        rocket.setLayoutX(400);
        rocket.setLayoutY(550);
        rocket.setFitHeight(120);
        rocket.setFitWidth(60);


        submit.setDefaultButton(true);
        submit.setOnAction(e -> {

           if(counter==LEVEL) {
            transition.setAutoReverse(false);
                transition.setNode(rocket);

                rocket.setLayoutX(400);
                rocket.setLayoutY(550 - 50 * counter);

                transition.play();
            display();
        }
            if (counter < LEVEL) { 

                try {

                    if (resu1lt.getText().isEmpty()) {

                        Alert alert = new Alert(AlertType.ERROR, "Please enter a number");
                        alert.showAndWait();
                        resu2 = -1;
                        answer.setText("");
                        Platform.runLater(() -> resu1lt.requestFocus());

                    } else {
                        resu1=number1*number2;
                        resu2 = Integer.parseInt(resu1lt.getText());

                        if (resu1 == resu2) {
                                    
                            transition.setAutoReverse(false);
                            transition.setNode(rocket);
                            
                            rocket.setLayoutX(400);
                            rocket.setLayoutY(550 - 50 * counter);

                            transition.play();

                            counter++;
                            
                            answer.setText(number1 + "x" + number2 + " = " + resu1lt.getText());
                            flag.setText("Correct");
                            
                            flag.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
                            flag.setFill(Color.GREEN);
                            resu1lt.clear();
                        }
                        else if(resu1!=resu2) {
                            answer.setText(number1 + "x" + number2 + " = " + resu1lt.getText());
                            flag.setText("Incorrect");
                            flag.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
                            flag.setFill(Color.RED);
                            resu1lt.clear();
                        } 
                    }
                    
                } catch(NumberFormatException ex){ 
                ;}
            }

            });}

    public void renewBtn(Pane gp) {

        Button continuebtn = new Button("Continue");
        
        continuebtn.setOnAction(e -> {
            number1 = rand.nextInt(0,12);
            number2 = rand.nextInt(0,12);
            
            resu1lt.clear();
            question.setText(number1 + " x " + number2);
            answer.setText("");
            flag.setText("");
            resu1=0;
            resu2=0;
            Platform.runLater(() -> resu1lt.requestFocus());
        });

        gp.getChildren().add(continuebtn);
        continuebtn.setLayoutX(60);
        continuebtn.setLayoutY(250);
    }
    
    public void homeBtn(Pane gp, Stage primaryStage) {
        Button btnExit = new Button("Home");
        gp.getChildren().add(btnExit);
        btnExit.setLayoutX(50);
        btnExit.setLayoutY(610);
        btnExit.setOnAction(e -> {
        primaryStage.setScene(new Scene(createContent(primaryStage)));
        primaryStage.getScene().getStylesheets().add(App.class.getResource("Main.css").toExternalForm());
        primaryStage.show();
        });
    }}

