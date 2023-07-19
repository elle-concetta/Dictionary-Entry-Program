import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
class Dictionary {
    WordList wordList;
    List<String> deletedWords;

    Dictionary() {
        wordList = new WordList();
        deletedWords = new ArrayList<>();
    }
    void addWordMeaning() {
        String word = JOptionPane.showInputDialog("Enter the word:");
        List<String> meanings = new ArrayList<>();
        String meaning = JOptionPane.showInputDialog("Enter the meaning or press 'cancel' to stop entering:");
        while (meaning != null) {
            // Collect all the meanings of the word
            meanings.add(meaning);
            meaning = JOptionPane.showInputDialog("Enter the next meaning or press 'cancel' to stop entering:");
        }
        wordList.addWordMeaning(new WordMeaning(word, meanings));
        // Add the word and meanings to the dictionary
    }
    void displayCurrentWords() {
        wordList.displayWordsInOrder();
        // Display the current words and meanings in lexicographical order
    }
    void removeWord() {
        String wordToRemove = JOptionPane.showInputDialog("Enter the word to remove:");

        wordList.removeWord(wordToRemove);
        // Remove the specified word from the dictionary

        deletedWords.add(wordToRemove);
        // Add the removed word to the list of deleted words
    }
    void displayDeletedWords() {
        StringBuilder sb = new StringBuilder();
        for (String word : deletedWords) {
            // Append each deleted word to the string
            sb.append(word).append("\n");
        }
        JOptionPane.showMessageDialog(null, new JTextArea(sb.toString()));
        // Display the list of deleted words
    }
}