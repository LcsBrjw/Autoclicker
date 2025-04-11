import javax.swing.*;
import java.awt.*;

public class AutoClickerGUI extends JFrame {
    private JTextField intervalField;
    private JTextField durationField;
    private JTextField xField;
    private JTextField yField;
    private JComboBox<String> clickTypeComboBox;
    private JButton startButton;
    private JButton stopButton;
    private JButton setLocationButton;
    private JLabel mousePositionLabel;
    private JTextArea logArea;

    public AutoClickerGUI() {
        setTitle("Autoclicker");
        setSize(320, 500); // Taille de la fenêtre 320x500
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal avec BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panel gauche : Interval, Duration, X, Y, Click Type, Mouse Position
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbcLeft = new GridBagConstraints();
        gbcLeft.anchor = GridBagConstraints.WEST;
        gbcLeft.insets = new Insets(5, 5, 5, 5);

        // Interval
        gbcLeft.gridx = 0;
        gbcLeft.gridy = 0;
        leftPanel.add(new JLabel("Interval (s):"), gbcLeft);
        gbcLeft.gridx = 1;
        intervalField = new JTextField(10);
        leftPanel.add(intervalField, gbcLeft);

        // Duration
        gbcLeft.gridx = 0;
        gbcLeft.gridy = 1;
        leftPanel.add(new JLabel("Duration (s):"), gbcLeft);
        gbcLeft.gridx = 1;
        durationField = new JTextField(10);
        leftPanel.add(durationField, gbcLeft);

        // X
        gbcLeft.gridx = 0;
        gbcLeft.gridy = 2;
        leftPanel.add(new JLabel("X:"), gbcLeft);
        gbcLeft.gridx = 1;
        xField = new JTextField(10);
        leftPanel.add(xField, gbcLeft);

        // Y
        gbcLeft.gridx = 0;
        gbcLeft.gridy = 3;
        leftPanel.add(new JLabel("Y:"), gbcLeft);
        gbcLeft.gridx = 1;
        yField = new JTextField(10);
        leftPanel.add(yField, gbcLeft);

        // Click Type
        gbcLeft.gridx = 0;
        gbcLeft.gridy = 4;
        leftPanel.add(new JLabel("Click Type:"), gbcLeft);
        gbcLeft.gridx = 1;
        clickTypeComboBox = new JComboBox<>(new String[]{"Single Click", "Double Click"});
        leftPanel.add(clickTypeComboBox, gbcLeft);

        // Mouse Position Label
        gbcLeft.gridx = 0;
        gbcLeft.gridy = 5;
        leftPanel.add(new JLabel("Mouse Position:"), gbcLeft);
        gbcLeft.gridx = 1;
        mousePositionLabel = new JLabel("Mouse Position: (0, 0)");
        leftPanel.add(mousePositionLabel, gbcLeft);

        // Ajout du leftPanel à gauche du mainPanel
        mainPanel.add(leftPanel, BorderLayout.WEST);

        // Panel boutons (Start, Stop, Set Location)
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Bouton "Start" rond vert
        startButton = new JButton();
        startButton.setPreferredSize(new Dimension(40, 40));
        startButton.setBackground(Color.GREEN);
        buttonPanel.add(startButton);

        // Bouton "Stop" carré rouge avec coins arrondis
        stopButton = new JButton();
        stopButton.setPreferredSize(new Dimension(40, 40));
        stopButton.setBackground(Color.RED);
        stopButton.setOpaque(true);
        stopButton.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        buttonPanel.add(stopButton);

        // Bouton "Set Location"
        setLocationButton = new JButton("Set Location");
        setLocationButton.setPreferredSize(new Dimension(120, 40));
        setLocationButton.setBackground(new Color(173, 216, 230)); // Bleu clair
        buttonPanel.add(setLocationButton);

        // Ajout du buttonPanel à droite du mainPanel
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Mouse Position Label
        mousePositionLabel = new JLabel("Mouse Position: (0, 0)");
        mainPanel.add(mousePositionLabel, BorderLayout.SOUTH);

        // Log Area en bas de l'application
        logArea = new JTextArea(5, 20);
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        // Bouton carré en bas à droite avec le signe "+"
        JButton addButton = new JButton("+");
        addButton.setPreferredSize(new Dimension(40, 40));
        addButton.setBackground(Color.GRAY);
        addButton.setForeground(Color.WHITE);
        addButton.setFont(addButton.getFont().deriveFont(Font.BOLD, 20f));

        // Ajout du bouton à l'angle bas droit
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(addButton, BorderLayout.EAST);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Ajout du mainPanel à la JFrame
        add(mainPanel);

        // Afficher la fenêtre
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AutoClickerGUI();
        });
    }
}
