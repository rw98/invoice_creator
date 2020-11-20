
package ui;

import input.CsvInput;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Slf4j
public class MainFrame extends JFrame {

    private JPanel mainPanel;
    private Color background = new Color(66, 66, 66);
    private Color secondary = new Color(245, 0, 87);
    private GridBagLayout gridBagLayout = new GridBagLayout();
    private GridBagConstraints constraints = new GridBagConstraints();
    private JFileChooser fileChooser = new JFileChooser();

    public MainFrame() {
        this.setSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBackground(background);
        this.setLocationRelativeTo(null);
        this.setTitle("CSV to Rechnungen");
        this.setIconImage(new ImageIcon("hannya.jpg").getImage());
        this.setLayout(new BorderLayout());
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        setUpMainPanel();
        addHeader();
        modConstraints(0, 2);
        addFileChooser();
        modConstraints(1, 2);
        addButtonTransform();
        this.add(mainPanel,BorderLayout.NORTH);
        this.setVisible(true);

    }

    private void modConstraints(int x, int y) {
        constraints.gridy = y;
        constraints.gridx = x;
        constraints.anchor = GridBagConstraints.WEST;
    }

    private void setUpMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setBackground(background);
        mainPanel.setLayout(gridBagLayout);
        constraints.gridx = 0;
        constraints.gridy = 0;
    }

    private void addFileChooser() {
        JButton button = new JButton("Datei auswählen");
        button.setForeground(Color.white);
        button.setBackground(secondary);
        button.setSize(new Dimension(200, 50));
        button.setBorder(BorderFactory.createMatteBorder(20, 20, 20, 20, secondary));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Datei auswählen")) {
                  int accept = fileChooser.showOpenDialog(null);
                  if (accept == JFileChooser.APPROVE_OPTION){
                      System.out.println(fileChooser.getSelectedFile().getPath());
                          CsvInput.createInvoices(fileChooser.getSelectedFile().getPath());

                  }
                }
            }
        });
        mainPanel.add(button, constraints);
    }


    private void addHeader() {
        JLabel label = new JLabel("Rechnungen aus CSV importieren");
        label.setForeground(Color.white);
        mainPanel.add(label, constraints);
    }

    private void addButtonTransform() {
        JButton button = new JButton("Transform");
        button.setForeground(Color.white);
        button.setBackground(secondary);
        button.setSize(new Dimension(200, 50));
        button.setBorder(BorderFactory.createMatteBorder(20, 20, 20, 20, secondary));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        mainPanel.add(button, constraints);
    }
}
