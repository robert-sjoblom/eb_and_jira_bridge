package se.standout.robert;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPane extends JPanel {
  private JTextField userName;
  private JPasswordField password;
  private JButton submit;

  public LoginPane() {
    setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.WEST;

    add(new JLabel("Username: "), gbc);
    gbc.gridy++;
    add(new JLabel("Password: "), gbc);
    gbc.gridy++;
    gbc.gridx++;
    submit = new JButton("Submit");
    submit.addActionListener( new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("The current panel is " + this);
        LoginPane.this.dispose();
      }

    });
    add(submit, gbc);

    gbc.gridy = 0;
    gbc.weightx = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;

    add((userName = new JTextField(10)), gbc);
    gbc.gridy++;
    add((password = new JPasswordField(10)), gbc);
  }

  private void dispose() {
    this.setVisible(false);
  }
}
