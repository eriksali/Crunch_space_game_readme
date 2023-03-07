package hellofx;
import java.util.Random;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

class Addition extends App {
    private Label question;
    private Label answer;
    private Text flag;
    private TextField result;
    private int level;

    Random rand;
    
    Addition(TextField result, Label answer, Label question, Text flag, int level) {
        this.question = question;
        this.answer = answer;
        this.result = result;
        this.flag = flag;
        this.level = level;
    }


    public void loadText(Pane gp) {

      
        gp.getChildren().add(question);
        gp.getChildren().add(result);
        gp.getChildren().add(answer);
        gp.getChildren().add(flag);

      
        question.setLayoutX(60);
        question.setLayoutY(200);

        answer.setLayoutX(120);
        answer.setLayoutY(200);
        flag.setLayoutX(210);
        flag.setLayoutY(215);

        result.setLayoutX(60);
        result.setLayoutY(220);

        rand = new Random(); 
    }

    public void submitBtn(Pane gp) {

        number1 = rand.nextInt(100);
        number2 = rand.nextInt(100);
        question.setText(number1 + " + " + number2);
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

            //if(counter==LEVEL) {
            if(counter==level) {
                transition.setAutoReverse(false);
                transition.setNode(rocket);

                rocket.setLayoutX(400);
                rocket.setLayoutY(550 - 500/level * counter);

                transition.play();
                display();
            }
            else if (counter < level) { 

                try {

                    if (result.getText().isEmpty()) {

                        Alert alert = new Alert(AlertType.ERROR, "Please enter a number");
                        alert.showAndWait();
                        resu2 = -1;
                        answer.setText("");
                        Platform.runLater(() -> result.requestFocus());

                    } else {
                        resu1=number1+number2;
                        resu2 = Integer.parseInt(result.getText());

                        if (resu1 == resu2) {
                                    
                            transition.setAutoReverse(false);
                            transition.setNode(rocket);
                            
                            rocket.setLayoutX(400);
                            rocket.setLayoutY(550 - 500/level * counter);

                            transition.play();

                            counter++;
                            
                            answer.setText(number1 + " + " + number2 + " = " + result.getText());
                            flag.setText("Correct");
                           
                            flag.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
                            flag.setFill(Color.GREEN);
                            result.clear();
                        }
                        else if(resu1!=resu2){
                            answer.setText(number1 + " + " + number2 + " = " + result.getText());
                            flag.setText("Incorrect");
                            flag.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
                            flag.setFill(Color.RED);
                            result.clear();
                        } 
                    }
                    
                } catch(NumberFormatException ex){ 
                    ;}
                }});}

    public void renewBtn(Pane gp) {

        Button continuebtn = new Button("Continue");
        
        continuebtn.setOnAction(e -> {
            number1 = rand.nextInt(0,100);
            number2 = rand.nextInt(0,100);
            
            result.clear();
            question.setText(number1 + " + " + number2);
            answer.setText("");
            flag.setText("");
            resu1=0;
            resu2=0;
            Platform.runLater(() -> result.requestFocus());
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
    }
}
