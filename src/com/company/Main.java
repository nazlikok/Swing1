package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Main {
    public static String fileName = "filename.txt";

    public static void main(String [] args) {
        GridLayout layout = new GridLayout(4,2);

        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(layout);

        JTextField jTextField= new JTextField();
        jTextField.setText(fileName);

        JButton readButton=new JButton("Read");

        JLabel vowelsCount = new JLabel();
        vowelsCount.setVerticalAlignment(JLabel.CENTER);
        vowelsCount.setHorizontalAlignment(JLabel.CENTER);

        JLabel vowels = new JLabel("Vowels");
        vowels.setVerticalAlignment(JLabel.CENTER);
        vowels.setHorizontalAlignment(JLabel.CENTER);


        JLabel consonantsCount = new JLabel();
        consonantsCount.setVerticalAlignment(JLabel.CENTER);
        consonantsCount.setHorizontalAlignment(JLabel.CENTER);
        JLabel consonants = new JLabel("Consonants");
        consonants.setVerticalAlignment(JLabel.CENTER);
        consonants.setHorizontalAlignment(JLabel.CENTER);

        JLabel resultText = new JLabel("Reading complete");
        resultText.setHorizontalAlignment(JLabel.CENTER);
        resultText.setVisible(false);

        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CountChars cw=new CountChars();
                    CountResult countResult = cw.countInFile(jTextField.getText());
                    vowelsCount.setText(String.valueOf(countResult.vowelsCount));
                    consonantsCount.setText(String.valueOf(countResult.consonantsCount));
                    resultText.setVisible(true);
                } catch (IOException ioException) {
                    resultText.setVisible(false);
                    JOptionPane.showMessageDialog(null, ioException.getMessage());
                }
            }
        });

        frame.add(jTextField);
        frame.add(readButton);
        frame.add(vowelsCount);
        frame.add(vowels);
        frame.add(consonantsCount);
        frame.add(consonants);
        frame.add(resultText);

        frame.setSize(400,500);
        frame.setVisible(true);

    }
}
