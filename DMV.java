import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DMV {
    public static Queue<String> license = new LinkedList<>();
    public static JLabel dmvQueue = new JLabel("");
    public static void main(String[] args) {
        // Components
        JFrame frame = new JFrame("Queue Structure");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new OverlayLayout(mainPanel));
        JPanel contentPanel = new JPanel(new GridBagLayout());

        JButton addQueue = new JButton("Add");
        addQueue.addActionListener(e -> addToQueue());

        JButton removeQueue = new JButton("Next");
        removeQueue.addActionListener(e-> upNext());

        // Layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);

        dmvQueue.setAlignmentY(0.0f);
        dmvQueue.setAlignmentX(0.5f);
        mainPanel.add(dmvQueue);

        JLabel select = new JLabel("Add to queue or call next up.", SwingConstants.CENTER);
        select.setAlignmentY(1.0f);
        select.setAlignmentX(0.5f);
        mainPanel.add(select);

        contentPanel.setAlignmentY(0.2f);
        contentPanel.setAlignmentX(0.5f);
        mainPanel.add(contentPanel);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        contentPanel.add(addQueue, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        contentPanel.add(removeQueue, gbc);

        frame.setSize(new Dimension(600, 300));
        frame.setContentPane(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void addToQueue() {
        String str = JOptionPane.showInputDialog(null, "Add To Queue");
        license.offer(str);
        dmvQueue.setText(license.toString());
    }
    public  static void upNext() {
        if (license.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Queue is empty!");
        } else {
            // Convert queue to arraylist to display the name of who is next.
            ArrayList<String> list = new ArrayList<>(license);
            JOptionPane.showMessageDialog(null, list.get(0) + " is next.");
            // Remove head of queue
            license.poll();
            dmvQueue.setText(license.toString());
        }
    }
}
