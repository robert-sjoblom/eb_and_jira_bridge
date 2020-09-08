package se.standout.robert;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

public class MainPane extends JPanel {
  private final LoginPane loginPane;

  /**
   * This holds the layout for the entire application.
   */
  public MainPane() {
    setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.weightx = 1;
    gbc.weighty = 0.33;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.insets = new Insets(4, 4, 4, 4);

    add((loginPane = new LoginPane()), gbc);
  }
}
