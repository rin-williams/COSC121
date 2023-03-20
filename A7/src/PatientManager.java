import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PatientManager {
    static PriorityQueue<Patient> waitingList = new PriorityQueue<>();
    static int userInput;

    // made new vars for conveniency since user is inputting them.
    static String name;
    static int urgency;
    static int orderNumber = 0;

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        System.out.print("--------------------\n");
        System.out.print("(1)  New Patient.\n(2)  Next Patient.\n(3)  Waiting List.\n(4)  Exit.\n");
        System.out.print("--------------------\n");
        Scanner in = new Scanner(System.in);

        menu: while (true) {

            // a condition to check and see if the user input is valid or not.
            option1: while (true) {
                try {
                    System.out.print("* Choose an item from the menu: ");
                    userInput = in.nextInt();
                    if (userInput >= 1 && userInput <= 4) {
                        break option1;
                    } else {
                        System.out.print("(x) Wrong choice. \n");
                    }
                } catch (InputMismatchException e) {
                    System.out.print("(x) Wrong choice. \n");
                    in.nextLine();
                }
            }

            // what to do after the user inputs the right number
            switch (userInput) {
                case 1:
                    // get name
                    System.out.print("      Enter the patient's name: ");
                    name = in.next();

                    // get urgency number
                    System.out.print("      Enter emergency [1 (low) to 5 (life-and-death)]: ");
                    while (true) {
                        try {
                            urgency = in.nextInt();
                            if (urgency >= 1 && urgency <= 5) {
                                break;
                            } else {
                                System.out.print("      (x) Wrong value. Try again: ");
                            }
                        } catch (InputMismatchException e) {
                            System.out.print("      (x) Wrong value. Try again: ");
                            in.nextLine();
                        }
                    }

                    // adding to priority queue
                    orderNumber++;
                    waitingList.offer(new Patient(orderNumber, name, urgency));
                    System.out.print("      Patient added to the waiting list.\n");
                    break;
                case 2:
                    if (waitingList.size() == 0) {
                        System.out.print("      None to treat since list is empty, please add patients.\n");
                        break;
                    } else {
                        System.out.print("      - " + waitingList.poll() + " was treated.\n");
                        break;
                    }
                case 3:
                    if (waitingList.size() == 0) {
                        System.out.print("      Waiting list is empty, please add patients.\n");
                        break;
                    } else {
                        System.out.print("      Waiting list includes: \n");
                        // i made a temporary list to store the waitingList patients in it because
                        // we do not want to mess with the original waiting list when we do .poll()
                        // waiting list should only change when the patients are treated
                        // but these patients arent treated, we are just collecting their names.
                        PriorityQueue<Patient> temp = new PriorityQueue<>();
                        for (Patient p : waitingList) {
                            temp.add(p);
                        }

                        while (!temp.isEmpty()) {
                            System.out.print("      - " + temp.poll() + "\n");
                        }
                        break;
                    }
                case 4:
                    System.out.print("--------------------\nProgram terminated. Goodbye :3");
                    break menu;

            }
        }
        in.close();

    }

}
