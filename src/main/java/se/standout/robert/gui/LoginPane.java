package se.standout.robert.gui;

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
  private static final long serialVersionUID = 1L;
  private final JTextField userName;
  private final JPasswordField password;
  private final JButton submit;

  /**
   * Displays a username/password field.
   */
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
    submit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // this is an example of how to hide a panel;
        // we probably want to send in the submit button listener so that it
        // has access to an outer scope that controls the pane and switches
        // to a progress pane?
        JButton source = (JButton) e.getSource();
        source.getParent().setVisible(false);
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
}
