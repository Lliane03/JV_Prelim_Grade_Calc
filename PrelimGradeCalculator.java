import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;

public class PrelimGradeCalculator extends JFrame {

    private JTextField lectureExamField, essayField, pvmField, javaBasicsField, introJSField;
    private JCheckBox[] lectureAttendanceCheckboxes;
    private JTextField labJava1Field, labJava2Field, labJS1Field, labJS2Field, labMP1Field, labMP2Field, labMP3Field, labMPDocField;
    private JCheckBox[] labAttendanceCheckboxes;
    private JLabel lectureGradeLabel, labGradeLabel;
    private BufferedImage lectureFormulaImage, labFormulaImage, backgroundImage;

    public PrelimGradeCalculator() {
        setTitle("2nd Semester Prelim Grade Computations");
        setSize(1275, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load the background image
        try {
            URL backgroundImageUrl = getClass().getResource("/bg1.png");
            if (backgroundImageUrl != null) {
                backgroundImage = ImageIO.read(backgroundImageUrl);
            } else {
                JOptionPane.showMessageDialog(this, "Background image not found!");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading background image: " + e.getMessage());
        }

        // Load the formula images
        try {
            URL lectureImageUrl = getClass().getResource("/lecture_formula.png");
            URL labImageUrl = getClass().getResource("/lab_formula.png");

            if (lectureImageUrl == null || labImageUrl == null) {
                JOptionPane.showMessageDialog(this, "Formula image(s) not found!");
            } else {
                lectureFormulaImage = ImageIO.read(lectureImageUrl);
                labFormulaImage = ImageIO.read(labImageUrl);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading formula image(s): " + e.getMessage());
        }

        // Custom JPanel with background image
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        backgroundPanel.setLayout(new GridLayout(1, 2));

        // Set a larger bold font
        Font font = new Font("Verdana", Font.BOLD, 16);

        // Lecture Panel
        JPanel lecturePanel = new JPanel();
        lecturePanel.setLayout(new GridLayout(16, 2)); // Increased rows for formula button
        lecturePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "PROGRAMMING 2 - LECTURE", TitledBorder.CENTER, 
        TitledBorder.DEFAULT_POSITION, font));
        lecturePanel.setOpaque(false); // Make the panel transparent

        JLabel lecExamPercentageLabel = new JLabel("60% PRELIM EXAM", SwingConstants.CENTER);
        lecExamPercentageLabel.setFont(font);
        lecExamPercentageLabel.setForeground(new Color(39, 5, 19));
        lecturePanel.add(lecExamPercentageLabel);
        lecturePanel.add(new JLabel()); // Empty label for spacing

        JLabel lectureExamLabel = new JLabel("Prelim Exam (100 points):");
        lectureExamLabel.setFont(font);
        lecturePanel.add(lectureExamLabel);
        lectureExamField = new JTextField();
        lectureExamField.setFont(font);
        lectureExamField.setOpaque(false);
        lectureExamField.setBackground(new Color(0, 0, 0, 0)); // Transparent background
        lecturePanel.add(lectureExamField);

        JLabel lecQuizzesPercentageLabel = new JLabel("60% PRELIM QUIZZES", SwingConstants.CENTER);
        lecQuizzesPercentageLabel.setFont(font);
        lecQuizzesPercentageLabel.setForeground(new Color(39, 5, 19));
        lecturePanel.add(lecQuizzesPercentageLabel);
        lecturePanel.add(new JLabel()); // Empty label for spacing

        JLabel essayLabel = new JLabel("Quiz 1 - Essay (100 points):");
        essayLabel.setFont(font);
        lecturePanel.add(essayLabel);
        essayField = new JTextField();
        essayField.setFont(font);
        essayField.setOpaque(false);
        essayField.setBackground(new Color(0, 0, 0, 0)); // Transparent background
        lecturePanel.add(essayField);

        JLabel pvmLabel = new JLabel("Quiz 2 - PVM (60 points):");
        pvmLabel.setFont(font);
        lecturePanel.add(pvmLabel);
        pvmField = new JTextField();
        pvmField.setFont(font);
        pvmField.setOpaque(false);
        pvmField.setBackground(new Color(0, 0, 0, 0)); // Transparent background
        lecturePanel.add(pvmField);

        JLabel javaBasicsLabel = new JLabel("Quiz 3 - Java Basics (40 points):");
        javaBasicsLabel.setFont(font);
        lecturePanel.add(javaBasicsLabel);
        javaBasicsField = new JTextField();
        javaBasicsField.setFont(font);
        javaBasicsField.setOpaque(false);
        javaBasicsField.setBackground(new Color(0, 0, 0, 0)); // Transparent background
        lecturePanel.add(javaBasicsField);

        JLabel introJSLabel = new JLabel("Quiz 4 - Intro to JS (40 points):");
        introJSLabel.setFont(font);
        lecturePanel.add(introJSLabel);
        introJSField = new JTextField();
        introJSField.setFont(font);
        introJSField.setOpaque(false);
        introJSField.setBackground(new Color(0, 0, 0, 0)); // Transparent background
        lecturePanel.add(introJSField);

        JLabel lecAttendancePercentageLabel = new JLabel("40% ATTENDANCE", SwingConstants.CENTER);
        lecAttendancePercentageLabel.setFont(font);
        lecAttendancePercentageLabel.setForeground(new Color(39, 5, 19));
        lecturePanel.add(lecAttendancePercentageLabel);
        lecturePanel.add(new JLabel()); // Empty label for spacing

        JLabel attendanceLabel = new JLabel("Attendance:");
        attendanceLabel.setFont(font);
        lecturePanel.add(attendanceLabel);
        lectureAttendanceCheckboxes = new JCheckBox[5];
        String[] lectureAttendanceDates = {"February 03, 2025", "January 20, 2025", "February 10, 2025", "January 27, 2025", "February 17, 2025"};
        for (int i = 0; i < 5; i++) {
            lectureAttendanceCheckboxes[i] = new JCheckBox(lectureAttendanceDates[i]);
            lectureAttendanceCheckboxes[i].setFont(font);
            lectureAttendanceCheckboxes[i].setOpaque(false); // Make the checkbox transparent
            lecturePanel.add(lectureAttendanceCheckboxes[i]);
        }

        JButton lectureCalculateButton = new JButton("Calculate Lecture Grade");
        lectureCalculateButton.setFont(font);
        lectureCalculateButton.setBackground(new Color(255, 143, 211)); // Set button color
        lectureCalculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateLectureGrade();
            }
        });
        lecturePanel.add(lectureCalculateButton);

        JButton lectureFormulaButton = new JButton("Grade Formula");
        lectureFormulaButton.setFont(font);
        lectureFormulaButton.setBackground(new Color(255, 143, 211)); // Set button color
        lectureFormulaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showFormulaImage(lectureFormulaImage, "Lecture Formula");
            }
        });
        lecturePanel.add(lectureFormulaButton);

        backgroundPanel.add(lecturePanel);

        // Laboratory Panel
        JPanel labPanel = new JPanel();
        labPanel.setLayout(new GridLayout(16, 2)); // Increased rows for formula button
        labPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "PROGRAMMING 2 - LABORATORY", TitledBorder.CENTER, 
        TitledBorder.DEFAULT_POSITION, font));
        labPanel.setOpaque(false); // Make the panel transparent

        JLabel labExamPercentageLabel = new JLabel("60% PRELIM EXAM", SwingConstants.CENTER);
        labExamPercentageLabel.setFont(font);
        labExamPercentageLabel.setForeground(new Color(39, 5, 19));
        labPanel.add(labExamPercentageLabel);
        labPanel.add(new JLabel()); // Empty label for spacing
        
        JLabel labJava1Label = new JLabel("Java 1 (100 points):");
        labJava1Label.setFont(font);
        labPanel.add(labJava1Label);
        labJava1Field = new JTextField();
        labJava1Field.setFont(font);
        labJava1Field.setOpaque(false);
        labJava1Field.setBackground(new Color(0, 0, 0, 0)); // Transparent background
        labPanel.add(labJava1Field);

        JLabel labJava2Label = new JLabel("Java 2 (100 points):");
        labJava2Label.setFont(font);
        labPanel.add(labJava2Label);
        labJava2Field = new JTextField();
        labJava2Field.setFont(font);
        labJava2Field.setOpaque(false);
        labJava2Field.setBackground(new Color(0, 0, 0, 0)); // Transparent background
        labPanel.add(labJava2Field);

        JLabel labJS1Label = new JLabel("JavaScript 1 (100 points):");
        labJS1Label.setFont(font);
        labPanel.add(labJS1Label);
        labJS1Field = new JTextField();
        labJS1Field.setFont(font);
        labJS1Field.setOpaque(false);
        labJS1Field.setBackground(new Color(0, 0, 0, 0)); // Transparent background
        labPanel.add(labJS1Field);

        JLabel labJS2Label = new JLabel("JavaScript 2 (100 points):");
        labJS2Label.setFont(font);
        labPanel.add(labJS2Label);
        labJS2Field = new JTextField();
        labJS2Field.setFont(font);
        labJS2Field.setOpaque(false);
        labJS2Field.setBackground(new Color(0, 0, 0, 0)); // Transparent background
        labPanel.add(labJS2Field);

        JLabel labWorkPercentageLabel = new JLabel("60% LAB WORK", SwingConstants.CENTER);
        labWorkPercentageLabel.setFont(font);
        labWorkPercentageLabel.setForeground(new Color(39, 5, 19));
        labPanel.add(labWorkPercentageLabel);
        labPanel.add(new JLabel()); // Empty label for spacing
        
        JLabel labMP1Label = new JLabel("MP1 (100 points):");
        labMP1Label.setFont(font);
        labPanel.add(labMP1Label);
        labMP1Field = new JTextField();
        labMP1Field.setFont(font);
        labMP1Field.setOpaque(false);
        labMP1Field.setBackground(new Color(0, 0, 0, 0)); // Transparent background
        labPanel.add(labMP1Field);

        JLabel labMP2Label = new JLabel("MP2 (100 points):");
        labMP2Label.setFont(font);
        labPanel.add(labMP2Label);
        labMP2Field = new JTextField();
        labMP2Field.setFont(font);
        labMP2Field.setOpaque(false);
        labMP2Field.setBackground(new Color(0, 0, 0, 0)); // Transparent background
        labPanel.add(labMP2Field);

        JLabel labMP3Label = new JLabel("MP3 (100 points):");
        labMP3Label.setFont(font);
        labPanel.add(labMP3Label);
        labMP3Field = new JTextField();
        labMP3Field.setFont(font);
        labMP3Field.setOpaque(false);
        labMP3Field.setBackground(new Color(0, 0, 0, 0)); // Transparent background
        labPanel.add(labMP3Field);

        JLabel labMPDocLabel = new JLabel("MP3 Documentation (100 points):");
        labMPDocLabel.setFont(font);
        labPanel.add(labMPDocLabel);
        labMPDocField = new JTextField();
        labMPDocField.setFont(font);
        labMPDocField.setOpaque(false);
        labMPDocField.setBackground(new Color(0, 0, 0, 0)); // Transparent background
        labPanel.add(labMPDocField);

        JLabel labAttendancePercentageLabel = new JLabel("40% ATTENDANCE", SwingConstants.CENTER);
        labAttendancePercentageLabel.setFont(font);
        labAttendancePercentageLabel.setForeground(new Color(39, 5, 19));
        labPanel.add(labAttendancePercentageLabel);
        labPanel.add(new JLabel()); // Empty label for spacing
        
        JLabel labAttendanceLabel = new JLabel("Attendance:");
        labAttendanceLabel.setFont(font);
        labPanel.add(labAttendanceLabel);
        labAttendanceCheckboxes = new JCheckBox[5];
        String[] labAttendanceDates = {"February 03, 2025", "January 20, 2025", "February 10, 2025", "January 27, 2025", "February 17, 2025"};
        for (int i = 0; i < 5; i++) {
            labAttendanceCheckboxes[i] = new JCheckBox(labAttendanceDates[i]);
            labAttendanceCheckboxes[i].setFont(font);
            labAttendanceCheckboxes[i].setOpaque(false); // Make the checkbox transparent
            labPanel.add(labAttendanceCheckboxes[i]);
        }

        JButton labCalculateButton = new JButton("Calculate Lab Grade");
        labCalculateButton.setFont(font);
        labCalculateButton.setBackground(new Color(255, 143, 211)); // Set button color
        labCalculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateLabGrade();
            }
        });
        labPanel.add(labCalculateButton);

        JButton labFormulaButton = new JButton("Grade Formula");
        labFormulaButton.setFont(font);
        labFormulaButton.setBackground(new Color(255, 143, 211)); // Set button color
        labFormulaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showFormulaImage(labFormulaImage, "Laboratory Formula");
            }
        });
        labPanel.add(labFormulaButton);

        backgroundPanel.add(labPanel);

        setContentPane(backgroundPanel);
        setVisible(true);
    }

    private void calculateLectureGrade() {
        try {
            double lectureExam = validateInput(lectureExamField.getText(), 100);
            double essay = validateInput(essayField.getText(), 100);
            double pvm = validateInput(pvmField.getText(), 60);
            double javaBasics = validateInput(javaBasicsField.getText(), 40);
            double introJS = validateInput(introJSField.getText(), 40);

            if (lectureExam == -1 || essay == -1 || pvm == -1 || javaBasics == -1 || introJS == -1) {
                return; // Input validation failed, stop calculation
            }

            double prelimExam = (lectureExam / 100.0) * 100.0;
            double essayGrade = (essay / 100.0) * 100.0;
            double pvmGrade = (pvm / 60.0) * 100.0;
            double javaBasicsGrade = (javaBasics / 40.0) * 100.0;
            double introJSGrade = (introJS / 40.0) * 100.0;

            double quizzes = (essayGrade + pvmGrade + javaBasicsGrade + introJSGrade) / 4.0;
            double attendance = 100.0;
            for (JCheckBox checkBox : lectureAttendanceCheckboxes) {
                if (!checkBox.isSelected()) {
                    attendance -= 10.0;
                }
            }

            double classStanding = (0.6 * quizzes) + (0.4 * attendance);
            double prelimGrade = (0.6 * prelimExam) + (0.4 * classStanding);

            // Show grade in a pop-up
            JOptionPane.showMessageDialog(this, "Lecture Prelim Grade: " + String.format("%.2f", prelimGrade), "Lecture Grade", JOptionPane.INFORMATION_MESSAGE);

            lectureGradeLabel.setText("Lecture Prelim Grade: " + String.format("%.2f", prelimGrade));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for all fields.");
        }
    }

    private void calculateLabGrade() {
        try {
            double labJava1 = validateInput(labJava1Field.getText(), 100);
            double labJava2 = validateInput(labJava2Field.getText(), 100);
            double labJS1 = validateInput(labJS1Field.getText(), 100);
            double labJS2 = validateInput(labJS2Field.getText(), 100);
            double labMP1 = validateInput(labMP1Field.getText(), 100);
            double labMP2 = validateInput(labMP2Field.getText(), 100);
            double labMP3 = validateInput(labMP3Field.getText(), 100);
            double labMPDoc = validateInput(labMPDocField.getText(), 100);

            if (labJava1 == -1 || labJava2 == -1 || labJS1 == -1 || labJS2 == -1 || labMP1 == -1 || labMP2 == -1 || labMP3 == -1 || labMPDoc == -1) {
                return; // Input validation failed, stop calculation
            }

            double prelimExam = (0.2 * labJava1) + (0.3 * labJava2) + (0.2 * labJS1) + (0.3 * labJS2);
            double labWork = (labMP1 + labMP2 + labMP3 + labMPDoc) / 4.0;
            double attendance = 100.0;
            for (JCheckBox checkBox : labAttendanceCheckboxes) {
                if (!checkBox.isSelected()) {
                    attendance -= 10.0;
                }
            }

            double prelimClassStanding = (0.6 * labWork) + (0.4 * attendance);
            double prelimGrade = (0.6 * prelimExam) + (0.4 * prelimClassStanding);

            // Show grade in a pop-up
            JOptionPane.showMessageDialog(this, "Laboratory Prelim Grade: " + String.format("%.2f", prelimGrade), "Laboratory Grade", JOptionPane.INFORMATION_MESSAGE);

            labGradeLabel.setText("Lab Prelim Grade: " + String.format("%.2f", prelimGrade));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for all fields.");
        }
    }

    private double validateInput(String input, int maxValue) {
        try {
            double value = Double.parseDouble(input);
            if (value < 0 || value > maxValue) {
                JOptionPane.showMessageDialog(this, "Please enter a value between 0 and " + maxValue + ".");
                return -1; // Indicate invalid input
            }
            return value;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
            return -1; // Indicate invalid input
        }
    }

    private void showFormulaImage(BufferedImage image, String title) {
        if (image != null) {
            // Resize the image
            int newWidth = 500; // Desired width
            int newHeight = (image.getHeight() * newWidth) / image.getWidth(); // Maintain aspect ratio
            Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(scaledImage);
            JLabel imageLabel = new JLabel(icon);
            JScrollPane scrollPane = new JScrollPane(imageLabel);
            JOptionPane.showMessageDialog(this, scrollPane, title, JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PrelimGradeCalculator();
            }
        });
    }
}