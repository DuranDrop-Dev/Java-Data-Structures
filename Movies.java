import java.awt.*;
import java.util.LinkedList;
import javax.swing.*;

public class Movies {
    public static LinkedList<String> movieList = new LinkedList<>();
    public static JLabel movieLabel = new JLabel("", SwingConstants.CENTER);
    public static void main(String []args) {
        // Components
        JFrame frame = new JFrame("MovieLinkedList");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new OverlayLayout(mainPanel));
        JPanel contentPanel = new JPanel(new GridBagLayout());

        JButton addMovie = new JButton("Add");
        JButton deleteMovie = new JButton("Delete");
        JButton updateMovie = new JButton("Edit");

        // Layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);

        mainPanel.add(movieLabel);
        movieLabel.setAlignmentY(0.0f);
        movieLabel.setAlignmentX(0.5f);

        mainPanel.add(contentPanel);
        contentPanel.setAlignmentY(0.1f);
        contentPanel.setAlignmentX(0.5f);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        contentPanel.add(addMovie, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        contentPanel.add(deleteMovie, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        contentPanel.add(updateMovie, gbc);

        frame.setSize(new Dimension(600, 200));
        frame.setContentPane(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Action Listeners
        addMovie.addActionListener(e-> addToList());
        deleteMovie.addActionListener(e-> deleteFromList());
        updateMovie.addActionListener(e -> updateList());
    }
    public static void addToList() {
        try {
            String str = JOptionPane.showInputDialog("Add Movie");
            movieList.add(str);
            movieLabel.setText(movieList.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Input is incorrect.");
        }
    }
    public static void deleteFromList() {
        StringBuilder list = new StringBuilder();
        int movieListIndex = 0;

        // Display movies in a list with their index #
        for (String movie : movieList) {
            list.append(movieListIndex++).append(" : ").append(movie).append("\n");
        }

        try {
            String str = JOptionPane.showInputDialog("Delete by index number or movie name\n" + list);

            // Check if string input is a #
            if (str.length() > 0) {
                char c = str.charAt(0);
                if (Character.isDigit(c)) {
                    int i = Character.getNumericValue(c);
                    String removeEl = movieList.get(i);
                    movieList.remove(removeEl);
                    movieLabel.setText(movieList.toString());
                } else {
                    movieList.removeIf(el -> el.contentEquals(str));
                    movieLabel.setText(movieList.toString());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Input is incorrect.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Input is incorrect.");
        }
    }
    public static void updateList() {
        StringBuilder list = new StringBuilder();
        int movieListIndex = 0;

        // Display movies in a list with their index #
        for (String movie : movieList) {
            list.append(movieListIndex++).append(" : ").append(movie).append("\n");
        }

        try {
            String str = JOptionPane.showInputDialog("Edit by index number or movie name\n" + list);

            // Check if string input is a #
            if (str.length() > 0) {
                char c = str.charAt(0);
                if (Character.isDigit(c)) {
                    int i = Character.getNumericValue(c);
                    String newStr = JOptionPane.showInputDialog("New Movie Name");
                    movieList.set(i, newStr);
                } else {
                    int i = movieList.indexOf(str);
                    String newStr = JOptionPane.showInputDialog("New Movie Name");
                    movieList.set(i, newStr);
                }
                movieLabel.setText(movieList.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Input is incorrect.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Input is incorrect.");
        }
    }
}