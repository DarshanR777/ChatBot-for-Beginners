import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalTime;
import java.awt.Desktop;
import java.net.URI;

    public class ChatBot {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Map<String, String> responses = new HashMap<>();

            // Predefined responses
            responses.put("hi", "Hi user, How can I help you?");
            responses.put("hello", "Hello! What do you need?");
            responses.put("how are you", "I'm just a bot, but I'm doing great!");
            responses.put("time", "The current time is " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm a")));
            responses.put("date", "The current time is " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy  eeee")));
            responses.put("exit", "Thank you! Have a great day!");

            System.out.println("Welcome to Java ChatBot! Type 'exit' to quit.");

            while (true) {
                System.out.print("User ==> ");
                String userInput = scanner.nextLine().toLowerCase();

                // Exit condition
                if (userInput.equalsIgnoreCase("exit")) {
                    System.out.println("Bot ==> " + responses.get("exit"));
                    break;
                }

                // Check if input matches a predefined response
                if (responses.containsKey(userInput)) {
                    System.out.println("Bot ==> " + responses.get(userInput));
                }

                // Open browser for 'YouTube'
                else if (userInput.equalsIgnoreCase("open youtube") || userInput.equalsIgnoreCase("yt")) {
                    System.out.println("Bot ==> Opening YouTube...");
                    openWebsite("https://www.youtube.com");
                }

                // Open Chrome
                else if (userInput.equalsIgnoreCase("open chrome") || userInput.equalsIgnoreCase("chrome")) {
                    System.out.println("Bot ==> Opening Chrome...");
                    openApplication("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
                }

                else {
                    System.out.println("Bot ==> Sorry, I don't understand that.");
                }
            }
            scanner.close();
        }

        // Method to open websites
        public static void openWebsite(String url) {
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (Exception e) {
                System.out.println("Bot ==> Unable to open website.");
            }
        }

        // Method to open applications
        public static void openApplication(String path) {
            try {
                ProcessBuilder process = new ProcessBuilder(path);
                process.start();
            } catch (Exception e) {
                System.out.println("Bot ==> Unable to open application.");
            }
        }
    }


