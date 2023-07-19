import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class WordList {
    WordMeaningNode head;

    void addWordMeaning(WordMeaning wordMeaning) {
        WordMeaningNode newNode = new WordMeaningNode(wordMeaning);

        if (head == null) {
            // If the linked list is empty, make the new node the head
            head = newNode;
        } else {
            WordMeaningNode current = head;
            while (current.next != null) {
                // Traverse to the end of the linked list
                current = current.next;
            }
            // Add the new node at the end of the linked list
            current.next = newNode;
        }
    }

    void displayWordsInOrder() {
        List<String> words = new ArrayList<>();
        WordMeaningNode current = head;
        while (current != null) {
            // Collect all the words from the linked list
            words.add(current.data.word);
            current = current.next;
        }
        Collections.sort(words); // Sort the words in lexicographical order

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append(" - ");
            current = head;
            while (current != null) {
                if (current.data.word.equals(word)) {
                    // Append each meaning for the current word
                    for (String meaning : current.data.meanings) {
                        sb.append(meaning).append("\n- ");
                    }
                }
                current = current.next;
            }
            sb.delete(sb.length() - 3, sb.length()).append("\n"); // Remove the trailing dash and add a new line
        }

        JTextArea textArea = new JTextArea(sb.toString());
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new java.awt.Dimension(500, 300));
        JOptionPane.showMessageDialog(null, scrollPane); // Display the sorted words and meanings in a scrollable list
    }

    void removeWord(String wordToRemove) {
        WordMeaningNode current = head;
        WordMeaningNode previous = null;

        while (current != null) {
            if (current.data.word.equals(wordToRemove)) {
                if (previous == null) {
                    // If the word to remove is the head, update the head to the next node
                    head = current.next;
                } else {
                    // Remove the word by updating the previous node's next pointer
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
    }
}