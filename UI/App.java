package UI;

import Configs.Config;
import Core.MVP.Presenter;
import Core.Models.Toy;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class App {
    public static void buttonClick() {
        Presenter presenter = new Presenter(new ConsoleView(), Config.pathDb);
        presenter.loadFromFile();

        String command;

        while (true) {

            command = prompt("""

                     1 - Add a toy to the drawing
                     2 - Remove the toy from the drawing
                     3 - Make a drawing 
                     4 - Show the drawing toys
                     5 - Clear all entries
                     6 - Save all entries to a file
                     7 - Download all entries from the file
                     8 - Exit
                     Make your choice:\s""");
                    
            if (command.equals("8")) {
                return;
            }
            try {
                switch (command) {
                    case "1" -> presenter.putForDrawing();
                    case "2" -> presenter.deleteFromDrawing();
                    case "3" -> presenter.getDrawing(); 
                    case "4" -> presenter.showAll();
                    case "5" -> presenter.clearAll();
                    case "6" -> presenter.saveToFile();
                    case "7" -> presenter.loadFromFile();
                    default -> System.out.println("\n Command not found!");
                }
            } catch (Exception e) {
                System.out.println("Error. " + e.getMessage());
            }
        }
    }

    private static String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private static Toy toyCreate() {
        int id = Integer.parseInt(prompt("Toy ID: "));
        String name = prompt("Name of the toy: ");
        String weight = prompt("Toy Weight: ");
        return (new Toy(id, name, Integer.parseInt(weight)));
    }
}