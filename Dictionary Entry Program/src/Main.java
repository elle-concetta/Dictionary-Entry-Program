import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        while (true) {
            String[] options = {"Add Word and Meaning", "Display Current Words",
                    "Remove Word", "Display Deleted Words", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Select an option:",
                    "Dictionary Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);

            switch (choice) {
                case 0:
                    dictionary.addWordMeaning();
                    break;
                case 1:
                    dictionary.displayCurrentWords();
                    break;
                case 2:
                    dictionary.removeWord();
                    break;
                case 3:
                    dictionary.displayDeletedWords();
                    break;
                case 4:
                    System.exit(0);
                    // Exit the program
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        }
    }
}
