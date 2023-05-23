import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProcessingTimeCalculator extends JFrame {
    private JTextField lengthField;
    private JTextField feedField;
    private JTextField speedField;
    private JLabel resultLabel;

    public ProcessingTimeCalculator() {
        setTitle("Processing Time Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(5, 3));

        JLabel lengthLabel = new JLabel("Machined Length (mm):");
        lengthField = new JTextField();
        JLabel feedLabel = new JLabel("Feed per Revolution (mm):");
        feedField = new JTextField();
        JLabel speedLabel = new JLabel("Spindle Speed (RPM):");
        speedField = new JTextField();
        JLabel timeLabel = new JLabel("Machining Time (min):");
        resultLabel = new JLabel();

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());

        add(lengthLabel);
        add(lengthField);
        add(feedLabel);
        add(feedField);
        add(speedLabel);
        add(speedField);
        add(timeLabel);
        add(resultLabel);
        add(calculateButton);

        setVisible(true);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double length = Double.parseDouble(lengthField.getText());
                double feed = Double.parseDouble(feedField.getText());
                double speed = Double.parseDouble(speedField.getText());

                double time = length / (feed * speed);
                resultLabel.setText(String.format("%.2f", time));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid numeric values for all fields.",
                        "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProcessingTimeCalculator());
    }
}