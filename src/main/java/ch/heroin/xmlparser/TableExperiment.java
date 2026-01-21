package ch.heroin.xmlparser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TableExperiment extends JFrame {

    public TableExperiment() {
        setTitle("JTable Experiment");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnNames = {"ID", "Name", "Phone", "Email"};
        Object[][] data = {
            {1, "Alice Smith", "0780070289", "alice@example.com"},
            {2, "Bob Johnson", "0780070289", "bob@example.com"},
            {3, "Carol Williams", "0780070289", "carol@example.com"},
            {4, "David Brown", "0780070289", "david@example.com"},
            {5, "Eve Davis", "0780070289", "eve@example.com"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);

        table.setRowHeight(25);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Row");
        JButton removeButton = new JButton("Remove Selected");
        JButton printButton = new JButton("Print Selected");

        addButton.addActionListener(e -> {
            int newId = model.getRowCount() + 1;
            model.addRow(new Object[]{newId, "New Person", "0780070289", "new@example.com"});
        });

        removeButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                model.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row to remove");
            }
        });

        printButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                StringBuilder sb = new StringBuilder("Selected row:\n");
                for (int i = 0; i < table.getColumnCount(); i++) {
                    sb.append(columnNames[i])
                      .append(": ")
                      .append(model.getValueAt(selectedRow, i))
                      .append("\n");
                }
                JOptionPane.showMessageDialog(this, sb.toString());
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row");
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(printButton);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TableExperiment frame = new TableExperiment();
            frame.setVisible(true);
        });
    }
}
