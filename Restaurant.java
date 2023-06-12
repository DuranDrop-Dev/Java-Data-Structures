import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Stack;

public class Restaurant {
    public static Stack<String> seating = new Stack<>();
    public static JLabel seatLabel = new JLabel("Seating");
    public static void main(String[] args) {
        // Components
        JFrame frame = new JFrame("Seat Wait Time");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new OverlayLayout(mainPanel));
        JPanel contentPanel = new JPanel(new GridBagLayout());

        // Layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);

        mainPanel.add(seatLabel);
        seatLabel.setAlignmentY(0.0f);
        seatLabel.setAlignmentX(0.5f);

        mainPanel.add(contentPanel);
        contentPanel.setAlignmentY(0.1f);
        contentPanel.setAlignmentX(0.5f);

        JButton addName = new JButton("Add Name");
        addName.addActionListener(e -> addName());

        gbc.gridy=0;
        gbc.gridx=0;
        contentPanel.add(addName, gbc);

        frame.setSize(new Dimension(500, 350));
        frame.setContentPane(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void addName() {
        // Enter name
        String str = JOptionPane.showInputDialog("Enter name");
        seating.push(str);

        // Random wait time generator
        Random rand = new Random();
        int waitTime = rand.nextInt(30);
        JOptionPane.showMessageDialog(null,"Your wait time is " + waitTime + " minutes.");

        // Update seating label
        seatLabel.setText(seating.toString());

        // Prompt client to choose to wait or not
        int toWait = JOptionPane.showConfirmDialog(null, "Would you like to wait?");
        if (toWait == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null,"Thank you for waiting.");
        } else {
            seating.pop();
            seatLabel.setText(seating.toString());
            JOptionPane.showMessageDialog(null,"Your name has been removed.");
        }
    }
}
