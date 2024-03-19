/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lat.kuis.pbo;

/**
 *
 * @author HP
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CompetitionProgram extends JFrame {

private JComboBox<String> categoryComboBox;
    private JTextField nameField, schoolField;
    private JTextField[] scoreFields;
    private JLabel[] scoreLabels;
    private JButton calculateButton;
    private JTextArea resultArea;
    private Participant participant;

    public CompetitionProgram() {
        setTitle("Competition Program");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 5, 5));

        // Components
        add(new JLabel("Category:"));
        categoryComboBox = new JComboBox<>(new String[]{"Animation", "Letter Writing"});
        add(categoryComboBox);

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("School:"));
        schoolField = new JTextField();
        add(schoolField);

        scoreFields = new JTextField[4];
        scoreLabels = new JLabel[4];
        String[] criteria = {"Plot", "Content", "Creativity", "Cinematography / Language Rules"};

        for (int i = 0; i < 4; i++) {
            add(new JLabel(criteria[i] + ":"));
            scoreFields[i] = new JTextField();
            add(scoreFields[i]);
        }

        calculateButton = new JButton("Calculate Score");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double[] scores = new double[4];
                    for (int i = 0; i < 4; i++) {
                        scores[i] = Double.parseDouble(scoreFields[i].getText());
                    }

                    if (categoryComboBox.getSelectedItem().equals("Animation")) {
                        participant = new Participant(nameField.getText(), schoolField.getText(), new AnimationScoring(scores[0], scores[1], scores[2], scores[3]));
                    } else {
                        participant = new Participant(nameField.getText(), schoolField.getText(), new LetterWritingScoring(scores[0], scores[1], scores[2], scores[3]));
                    }

                    double finalScore = participant.getScore();
                    if (finalScore >= 85) {
                        resultArea.setText("Congratulations! " + participant.getName() + " from " + participant.getSchool() + " has passed with a score of " + finalScore);
                    } else {
                        resultArea.setText("Sorry, " + participant.getName() + " from " + participant.getSchool() + " has not passed with a score of " + finalScore);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(CompetitionProgram.this, "Please enter valid numerical values for scores.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(calculateButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(resultArea);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CompetitionProgram();
    }
    
}
