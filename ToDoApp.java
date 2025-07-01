package com.App;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ToDoApp extends JFrame implements ActionListener {

    JTextField taskField;
    DefaultListModel<String> taskList;
    JList<String> taskJList;
    JButton addBtn, deleteBtn;

    public ToDoApp() {
        setTitle("Simple To-Do App");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        taskField = new JTextField(20);
        add(taskField);

        addBtn = new JButton("Add");
        addBtn.addActionListener(this);
        add(addBtn);

        deleteBtn = new JButton("Delete");
        deleteBtn.addActionListener(this);
        add(deleteBtn);

        taskList = new DefaultListModel<>();
        taskJList = new JList<>(taskList);
        add(new JScrollPane(taskJList));

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            String task = taskField.getText();
            if (!task.isEmpty()) {
                taskList.addElement(task);
                taskField.setText("");
            }
        } else if (e.getSource() == deleteBtn) {
            int index = taskJList.getSelectedIndex();
            if (index != -1) {
                taskList.remove(index);
            }
        }
    }

    public static void main(String[] args) {
        new ToDoApp();
    }
}

