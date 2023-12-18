import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NotificationWindow extends JFrame {

    private JLabel backgroundLabel;
    private JLabel titleLabel;
    private JLabel messageLabel;
    private JButton closeButton;

    public NotificationWindow(String title, String message, ImageIcon backgroundIcon) {
        initializeUI(title, message, backgroundIcon);
    }

    private void initializeUI(String title, String message, ImageIcon backgroundIcon) {
        setTitle("Ur  Notification");
        setUndecorated(true);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Background Image Label
        backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setLayout(new BorderLayout());

        // Title Label
        titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Message Label
        messageLabel = new JLabel(message);
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Close Button
        closeButton = new JButton("Close");
        closeButton.setBackground(Color.BLUE);
        closeButton.setForeground(Color.WHITE);
        closeButton.setFocusPainted(false);
        closeButton.addActionListener(e -> dispose());

        // Add components to the background label
        backgroundLabel.add(titleLabel, BorderLayout.NORTH);
        backgroundLabel.add(messageLabel, BorderLayout.CENTER);
        backgroundLabel.add(closeButton, BorderLayout.SOUTH);

        // Add the background label to the content pane
        getContentPane().add(backgroundLabel, BorderLayout.CENTER);

        // Make the window draggable
        addMouseListener(new MouseAdapter() {
            private int mouseX, mouseY;

            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen() - mouseX;
                int y = e.getYOnScreen() - mouseY;
                setLocation(x, y);
            }
        });
    }

    public static void main(String[] args) {
        String imagePath = "C:\\Users\\VINEET KUMAR SINGH\\Downloads\\backgrdphoto.jpg";
        ImageIcon customBackground = new ImageIcon(imagePath);

        SwingUtilities.invokeLater(() -> {
            NotificationWindow combinedNotification = new NotificationWindow("Ur Notifications", "Missed Call: John Doe - 2 missed calls \n Email: You have a new email", customBackground);
            combinedNotification.setVisible(true);
        });
    }
}
