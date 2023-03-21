package UI;

import java.util.List;
import java.util.Scanner;

import Configs.Config;
import Core.MVP.IView;
import Core.Models.Toy;

public class ConsoleView implements IView {
    Scanner in;

    public ConsoleView() {
        in = new Scanner(System.in);
    }

    @Override
    public int getToyId() {
        System.out.print("Toy ID: ");
        return Integer.parseInt(in.nextLine());
    }

    @Override
    public String getToyNaming() {
        System.out.print("Name of the toy: ");
        return in.nextLine();
    }

    @Override
    public int getToyWeight() {
        System.out.print("Toy Weight: ");
        return Integer.parseInt(in.nextLine());
    }
/**
    @Override
    public void setToyWeight(int value) {
        System.out.printf("Вес игрушки: %s\n", value);
    }
*/
    @Override
    public void showAll(List<Toy> toys) {
        System.out.println("\nAll toys for drawing:");
        for (Toy toy : toys) {
            System.out.println(toy);
        }

    }

    @Override
    public void showGetToy(Toy toy) {
        System.out.print("\nDraw results: ");
        System.out.println(toy);
    }

    @Override
    public void loadMessage() {
        System.out.println("\nFile is loaded to current session");
    }

    @Override
    public boolean clearAllDecision() {
        boolean f = false;
        System.out.print("\nAre you sure you have cleared all the records (y/n): ");
        if (in.nextLine().equalsIgnoreCase("Y")) {
            f = true;
        }
        return f;
    }

    @Override
    public void savedAll() {
        System.out.println("\nAll entries are saved to a file: " + Config.pathDb);
    }

    @Override
    public void savedItem() {
        System.out.println("\nSuccessfully added to the current service");
    }

    @Override
    public void saveError() {
        System.out.println("\nFailed to add current service");
    }

    @Override
    public void emptyListMessage() {
        System.out.println("The toy list is empty!");
    }

    @Override
    public int getDrawTimes() {
        System.out.print("How many times do you want to draw: ");
        return Integer.parseInt(in.nextLine());
    }

}