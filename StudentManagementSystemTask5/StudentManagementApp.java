package StudentManagementSystemTask5;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;

public class StudentManagementApp extends JFrame {

    private StudentManagementSystem sms;
    private JTable table;
    private DefaultTableModel tableModel;

    public StudentManagementApp() {
        sms = new StudentManagementSystem();
        try {
            sms.loadFromCSV(); // Load existing students
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
        }

        setTitle("Student Management System");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Table setup
        String[] columns = {"Roll", "Name", "Grade", "Email", "Phone"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel();
        JButton addBtn = new JButton("Add");
        JButton removeBtn = new JButton("Remove");
        JButton searchBtn = new JButton("Search");
        JButton refreshBtn = new JButton("Refresh");
        buttonPanel.add(addBtn);
        buttonPanel.add(removeBtn);
        buttonPanel.add(searchBtn);
        buttonPanel.add(refreshBtn);
        add(buttonPanel, BorderLayout.SOUTH);

        // Load data into table
        refreshTable();

        // Button actions
        addBtn.addActionListener(e -> addStudent());
        removeBtn.addActionListener(e -> removeStudent());
        searchBtn.addActionListener(e -> searchStudent());
        refreshBtn.addActionListener(e -> refreshTable());
    }

    // Refresh table data
    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Student s : sms.getAllStudents()) {
            tableModel.addRow(new Object[]{s.getRollNumber(), s.getName(), s.getGrade(), s.getEmail(), s.getPhone()});
        }
    }

    // Add a student
    private void addStudent() {
        JTextField nameField = new JTextField();
        JTextField rollField = new JTextField();
        JTextField gradeField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField phoneField = new JTextField();

        Object[] message = {
                "Name:", nameField,
                "Roll Number:", rollField,
                "Grade:", gradeField,
                "Email:", emailField,
                "Phone:", phoneField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Add Student", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                int roll = Integer.parseInt(rollField.getText().trim());
                Student s = new Student(nameField.getText().trim(),roll,gradeField.getText().trim(),emailField.getText().trim(),phoneField.getText().trim());
                sms.addStudent(s);
                sms.saveToCSV();
                refreshTable();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Roll must be a number");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage());
            }
        }
    }

    // Remove a student by entering roll number
    private void removeStudent() {
        String input = JOptionPane.showInputDialog(this, "Enter roll number to remove:");
        if (input != null) {
            try {
                int roll = Integer.parseInt(input.trim());
                Student s = sms.searchStudent(roll);
                if (s != null) {
                    int confirm = JOptionPane.showConfirmDialog(this,
                            "Are you sure you want to remove: " + s + "?",
                            "Confirm Removal",
                            JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        sms.removeStudent(roll);   // backend removal
                        sms.saveToCSV();           // save to CSV
                        refreshTable();            // update table in GUI
                        JOptionPane.showMessageDialog(this, "Student removed successfully!");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Student with roll " + roll + " not found.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid roll number.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage());
            }
        }
    }

    // Search student by roll
    private void searchStudent() {
        String input = JOptionPane.showInputDialog(this, "Enter roll number to search:");
        if (input != null) {
            try {
                int roll = Integer.parseInt(input.trim());
                Student s = sms.searchStudent(roll);
                if (s != null) {
                    JOptionPane.showMessageDialog(this, "Found: " + s);
                } else {
                    JOptionPane.showMessageDialog(this, "Student not found");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid roll number");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentManagementApp().setVisible(true));
    }
}
