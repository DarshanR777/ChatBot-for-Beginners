import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

public class ChatBot extends Application {
    
    private VBox chatBox;
    private TextField userInput;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ChatBot Application");

        chatBox = new VBox(10);
        chatBox.setPadding(new Insets(10));

        ScrollPane scrollPane = new ScrollPane(chatBox);
        scrollPane.setFitToWidth(true);
        
        userInput = new TextField();
        userInput.setPromptText("Type a command...");
        userInput.setOnAction(event -> handleUserInput());
        userInput.setPrefHeight(30);
        
        VBox layout = new VBox(10, scrollPane, userInput);
        layout.setPadding(new Insets(10));

        Scene scene = new Scene(layout, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleUserInput() {
        String input = userInput.getText().trim().toLowerCase();
        if (input.isEmpty()) return;

        displayMessage(input, Pos.CENTER_RIGHT, Color.BLACK);
        String response = getBotResponse(input);
        displayMessageBot(response, Pos.CENTER_LEFT, Color.BLACK);

        userInput.clear();
    }

    private void displayMessage(String message, Pos position, Color color) {
        Text text = new Text(message);
        text.setFill(color);
        TextFlow textFlow = new TextFlow(text);
        textFlow.setPadding(new Insets(7));
        textFlow.setStyle("-fx-background-color: #01d08c; -fx-background-radius: 10px;");
        
        HBox messageContainer = new HBox(textFlow);
        messageContainer.setAlignment(position);
        
        chatBox.getChildren().add(messageContainer);
    }
    
    private void displayMessageBot(String message, Pos position, Color color) {
        Text text = new Text(message);
        text.setFill(color);
        TextFlow textFlow = new TextFlow(text);
        textFlow.setPadding(new Insets(8));
        textFlow.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 10px; ");
        
        HBox messageContainer = new HBox(textFlow);
        messageContainer.setAlignment(position);
        
        chatBox.getChildren().add(messageContainer);
    }

    private String getBotResponse(String input) {
        switch (input) {
            case "hello":
                return "Hello! How can I assist you today?";
            case "notepad":
                openApplication("notepad.exe");
                return "Opening Notepad...";
            case "calculator":
                openApplication("calc.exe");
                return "Opening Calculator...";
            case "open browser":
            case "google":
                openApplication("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
                return "Opening Browser...";
            case "youtube":
                openWebsite("https://www.youtube.com");
                return "Opening YouTube...";
            case "linkedin":
                openWebsite("https://www.linkedin.com");
                return "Opening LinkedIn";
            case "exit":
                System.exit(0);
                return "Exiting...";
            default:
                return "Sorry, I don't understand that command.";
        }
    }

    private void openApplication(String appPath) {
        try {
            Runtime.getRuntime().exec(appPath);
        } catch (IOException e) {
            displayMessage("Bot: Failed to open application.", Pos.CENTER_LEFT, Color.RED);
        }
    }

    private void openWebsite(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            displayMessage("Bot: Failed to open website.", Pos.CENTER_LEFT, Color.RED);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
