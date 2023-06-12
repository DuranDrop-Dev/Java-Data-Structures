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
        String str = JOptionPane.showInputDialog("Add Movie");
        movieList.add(str);
        movieLabel.setText(movieList.toString());
    }
    public static void deleteFromList() {
        String str = JOptionPane.showInputDialog("Delete Movie\n" + movieList.toString());
        movieList.removeIf(el -> el.equals(str));
        movieLabel.setText(movieList.toString());
    }
    public static void updateList() {
        String str = JOptionPane.showInputDialog("Edit Movie\n" + movieList.toString());
        for (String el : movieList) {
            if (el.equals(str)) {
                String newStr = JOptionPane.showInputDialog("New Movie");
                int index = movieList.indexOf(el);
                movieList.set(index, newStr);
            }
        }
        movieLabel.setText(movieList.toString());
    }
}