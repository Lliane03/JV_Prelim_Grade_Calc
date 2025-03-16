import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondSemPrelimGradeCalculator extends JFrame {

    private JTextField lectureExamField, lectureEssayField, lecturePVMField, lectureJavaBasicsField, lectureIntroJSField, lectureAttendanceField;
    private JTextField labJava1Field, labJava2Field, labJS1Field, labJS2Field, labMP1Field, labMP2Field, labMP3Field, labMPDocField, labAttendanceField;
    private JLabel lectureResultLabel, labResultLabel;

    public SecondSemPrelimGradeCalculator() {
        setTitle("2nd Semester Prelim Grade Computations");
        setSize(980, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main content panel with padding
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1, 10, 10));
        mainPanel.setBorder(new EmptyBorder(20, 15, 20, 15));
        mainPanel.setBackground(new Color(218, 119, 129));

        // Create a font for labels and text fields
        Font componentFont = new Font("Verdana", Font.BOLD, 17);

        // Create a Color object for the desired font color
        Color fontColor = new Color(86, 43, 33); // RGB(86, 43, 33)
        
        // Lecture Panel
        JPanel lecturePanel = new JPanel(new GridLayout(8, 2));
        lecturePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        lecturePanel.setBackground(new Color(218, 119, 129));
        lecturePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add inner border

        JLabel lectureExamLabel = new JLabel("Prelim Examination: 100 points");
        lectureExamLabel.setFont(componentFont);
        lectureExamLabel.setForeground(fontColor);
        lecturePanel.add(lectureExamLabel);
        lectureExamField = new JTextField();
        lectureExamField.setFont(componentFont);
        lecturePanel.add(lectureExamField);

        JLabel lectureEssayLabel = new JLabel("(Quiz 1) Essay: 100 points");
        lectureEssayLabel.setFont(componentFont);
        lectureEssayLabel.setForeground(fontColor);
        lecturePanel.add(lectureEssayLabel);
        lectureEssayField = new JTextField();
        lectureEssayField.setFont(componentFont);
        lecturePanel.add(lectureEssayField);

        JLabel lecturePVMLabel = new JLabel("(Quiz 2) PVM: 60 points");
        lecturePVMLabel.setFont(componentFont);
        lecturePVMLabel.setForeground(fontColor);
        lecturePanel.add(lecturePVMLabel);
        lecturePVMField = new JTextField();
        lecturePVMField.setFont(componentFont);
        lecturePanel.add(lecturePVMField);

        JLabel lectureJavaBasicsLabel = new JLabel("(Quiz 3) Java Basics: 40 points");
        lectureJavaBasicsLabel.setFont(componentFont);
        lectureJavaBasicsLabel.setForeground(fontColor);
        lecturePanel.add(lectureJavaBasicsLabel);
        lectureJavaBasicsField = new JTextField();
        lectureJavaBasicsField.setFont(componentFont);
        lecturePanel.add(lectureJavaBasicsField);

        JLabel lectureIntroJSLabel = new JLabel("(Quiz 4) Intro to JS: 40 points");
        lectureIntroJSLabel.setFont(componentFont);
        lectureIntroJSLabel.setForeground(fontColor);
        lecturePanel.add(lectureIntroJSLabel);
        lectureIntroJSField = new JTextField();
        lectureIntroJSField.setFont(componentFont);
        lecturePanel.add(lectureIntroJSField);

        JLabel lectureAttendanceLabel = new JLabel("Absences:");
        lectureAttendanceLabel.setFont(componentFont);
        lectureAttendanceLabel.setForeground(fontColor);
        lecturePanel.add(lectureAttendanceLabel);
        lectureAttendanceField = new JTextField();
        lectureAttendanceField.setFont(componentFont);
        lecturePanel.add(lectureAttendanceField);

        JButton lectureCalculateButton = new JButton("CALCULATE");
        lectureCalculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateLectureGrade();
            }
        });
        lectureCalculateButton.setFont(componentFont);
        lectureCalculateButton.setBackground(new Color(114, 66, 53));
        lectureCalculateButton.setForeground(Color.WHITE); // Set font color
        lecturePanel.add(lectureCalculateButton);

        lectureResultLabel = new JLabel("Lecture Result:");
        lectureResultLabel.setFont(componentFont);
        lectureResultLabel.setForeground(fontColor); 
        lecturePanel.add(lectureResultLabel);

        mainPanel.add(lecturePanel);

        // Laboratory Panel
        JPanel labPanel = new JPanel(new GridLayout(10, 2));
        labPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        labPanel.setBackground(new Color(218, 119, 129));
        labPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add inner border

        JLabel labJava1Label = new JLabel("Java 1: 100 points");
        labJava1Label.setFont(componentFont);
        labJava1Label.setForeground(fontColor);
        labPanel.add(labJava1Label);
        labJava1Field = new JTextField();
        labJava1Field.setFont(componentFont);
        labPanel.add(labJava1Field);

        JLabel labJava2Label = new JLabel("Java 2: 100 points");
        labJava2Label.setFont(componentFont);
        labJava2Label.setForeground(fontColor);
        labPanel.add(labJava2Label);
        labJava2Field = new JTextField();
        labJava2Field.setFont(componentFont);
        labPanel.add(labJava2Field);

        JLabel labJS1Label = new JLabel("JavaScript 1: 100 points");
        labJS1Label.setFont(componentFont);
        labJS1Label.setForeground(fontColor);
        labPanel.add(labJS1Label);
        labJS1Field = new JTextField();
        labJS1Field.setFont(componentFont);
        labPanel.add(labJS1Field);

        JLabel labJS2Label = new JLabel("JavaScript 2: 100 points");
        labJS2Label.setFont(componentFont);
        labJS2Label.setForeground(fontColor);
        labPanel.add(labJS2Label);
        labJS2Field = new JTextField();
        labJS2Field.setFont(componentFont);
        labPanel.add(labJS2Field);

        JLabel labMP1Label = new JLabel("Machine Problem 1: 100 points");
        labMP1Label.setFont(componentFont);
        labMP1Label.setForeground(fontColor);
        labPanel.add(labMP1Label);
        labMP1Field = new JTextField();
        labMP1Field.setFont(componentFont);
        labPanel.add(labMP1Field);

        JLabel labMP2Label = new JLabel("Machine Problem 2: 100 points");
        labMP2Label.setFont(componentFont);
        labMP2Label.setForeground(fontColor);
        labPanel.add(labMP2Label);
        labMP2Field = new JTextField();
        labMP2Field.setFont(componentFont);
        labPanel.add(labMP2Field);

        JLabel labMP3Label = new JLabel("Machine Problem 3: 100 points");
        labMP3Label.setFont(componentFont);
        labMP3Label.setForeground(fontColor);
        labPanel.add(labMP3Label);
        labMP3Field = new JTextField();
        labMP3Field.setFont(componentFont);
        labPanel.add(labMP3Field);

        JLabel labMPDocLabel = new JLabel("Machine Problem 3 Documentation: 100 points");
        labMPDocLabel.setFont(componentFont);
        labMPDocLabel.setForeground(fontColor);
        labPanel.add(labMPDocLabel);
        labMPDocField = new JTextField();
        labMPDocField.setFont(componentFont);
        labPanel.add(labMPDocField);

        JLabel labAttendanceLabel = new JLabel("Absences:");
        labAttendanceLabel.setFont(componentFont);
        labAttendanceLabel.setForeground(fontColor);
        labPanel.add(labAttendanceLabel);
        labAttendanceField = new JTextField();
        labAttendanceField.setFont(componentFont);
        labPanel.add(labAttendanceField);

        JButton labCalculateButton = new JButton("CALCULATE");
        labCalculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateLabGrade();
            }
        });
        labCalculateButton.setFont(componentFont);
        labCalculateButton.setBackground(new Color(114, 66, 53));
        labCalculateButton.setForeground(Color.WHITE); // Set font color
        labPanel.add(labCalculateButton);

        labResultLabel = new JLabel("Lab Result:");
        labResultLabel.setFont(componentFont);
        labResultLabel.setForeground(fontColor);
        labPanel.add(labResultLabel);

        mainPanel.add(labPanel);

        setContentPane(mainPanel);
        setVisible(true);
    }


    private void calculateLectureGrade() {
        try {
            // Get input values with validation
            double lectureExam = getValidatedInput(lectureExamField.getText(), 0, 100);
            double essay = getValidatedInput(lectureEssayField.getText(), 0, 100);
            double pvm = getValidatedInput(lecturePVMField.getText(), 0, 60);
            double javaBasics = getValidatedInput(lectureJavaBasicsField.getText(), 0, 40);
            double introJS = getValidatedInput(lectureIntroJSField.getText(), 0, 40);
            int lectureAbsences = Integer.parseInt(lectureAttendanceField.getText()); // Get absences directly

            // Calculate Percentage Scores
            double essayPercentage = (essay / 100.0) * 100.0;
            double pvmPercentage = (pvm / 60.0) * 100.0;
            double javaBasicsPercentage = (javaBasics / 40.0) * 100.0;
            double introJSPercentage = (introJS / 40.0) * 100.0;

            // Calculate Lecture Attendance
            double lectureAttendance = Math.max(0, 100 - (lectureAbsences * 10)); // Ensure attendance is not negative

            // Calculate Prelim Quizzes (using percentage scores)
            double prelimQuizzes = (essayPercentage + pvmPercentage + javaBasicsPercentage + introJSPercentage) / 4.0;

            // Calculate Prelim Class Standing
            double prelimClassStanding = (0.6 * prelimQuizzes) + (0.4 * lectureAttendance);

            // Calculate Prelim Grade
            double prelimGrade = (0.6 * lectureExam) + (0.4 * prelimClassStanding);

            // Display the result
            lectureResultLabel.setText("LECTURE PRELIM GRADE: " + String.format("%.2f", prelimGrade));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for Lecture inputs.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calculateLabGrade() {
        try {
            // Get input values with validation
            double labJava1 = getValidatedInput(labJava1Field.getText(), 0, 100);
            double labJava2 = getValidatedInput(labJava2Field.getText(), 0, 100);
            double labJS1 = getValidatedInput(labJS1Field.getText(), 0, 100);
            double labJS2 = getValidatedInput(labJS2Field.getText(), 0, 100);
            double labMP1 = getValidatedInput(labMP1Field.getText(), 0, 100);
            double labMP2 = getValidatedInput(labMP2Field.getText(), 0, 100);
            double labMP3 = getValidatedInput(labMP3Field.getText(), 0, 100);
            double labMPDock = getValidatedInput(labMPDocField.getText(), 0, 100);
            int labAbsences = Integer.parseInt(labAttendanceField.getText()); // Get absences directly

            // Calculate Prelim Exam
            double prelimExam = (0.2 * labJava1) + (0.3 * labJava2) + (0.2 * labJS1) + (0.3 * labJS2);

            // Calculate Lab Work
            double labWork = (labMP1 + labMP2 + labMP3 + labMPDock) / 4.0;

            // Calculate Lab Attendance
            double labAttendance = Math.max(0, 100 - (labAbsences * 10)); // Ensure attendance is not negative

            // Calculate Prelim Class Standing
            double prelimClassStanding = (0.6 * labWork) + (0.4 * labAttendance);

            // Calculate Prelim Grade
            double prelimGrade = (0.6 * prelimExam) + (0.4 * prelimClassStanding);

            // Display the result
            labResultLabel.setText("LAB PRELIM GRADE: " + String.format("%.2f", prelimGrade));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for Lab inputs.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Helper function to validate input within a range
    private double getValidatedInput(String input, double min, double max) {
        double value = Double.parseDouble(input);
        if (value < min || value > max) {
            throw new IllegalArgumentException("Input must be between " + min + " and " + max);
        }
        return value;
    }

    public static void main(String[] args) {
        new SecondSemPrelimGradeCalculator();
    }
}
