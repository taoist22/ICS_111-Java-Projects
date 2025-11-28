package edu.hawaii.ics111.h14;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

/**
 * A login system program in Java.
 * Extra Credit: Implemented feature to disable login button until after text is
 * entered in
 * both username and password fields.
 *
 * @author CT Reatherford.
 */
public class LoginPanel extends JPanel
{
    /**
     * The authorized username.
     */
    private String username = "admin";
    /**
     * The authorized password.
     */
    private String password = "secret";
    /**
     * The text field for user input.
     */
    private JTextField userNameField;
    /**
     * The password field for user input.
     */
    private JPasswordField passwordField;
    /**
     * The button to initiate the login check.
     */
    private JButton loginButton;

    /**
     * Constructor LoginPanel, initializes the layout and adds components to the
     * layout.
     */
    public LoginPanel()
    {
        super();

        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JLabel label1 = new JLabel("Username:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(label1, constraints);

        userNameField = new JTextField(15);
        constraints.gridx = 1;
        this.add(userNameField, constraints);

        JLabel label2 = new JLabel("Password:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(label2, constraints);

        passwordField = new JPasswordField(15);
        constraints.gridx = 1;
        this.add(passwordField, constraints);

        loginButton = new JButton("Login");

        loginButton.setEnabled(false);

        /**
         * The loginButton listener logic
         */
        loginButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String enteredUser = userNameField.getText();
                String enteredPass = new String(passwordField.getPassword());

                if (enteredUser.equals(username) && enteredPass.equals(password))
                {
                    LoginPanel.this.removeAll();
                    LoginPanel.this.add(new JLabel("Login successful"));
                    LoginPanel.this.revalidate();
                    LoginPanel.this.repaint();
                }
                else
                {
                    JOptionPane.showMessageDialog(LoginPanel.this, "Incorrect username or password",
                                                  "Invalid Login", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        /**
         * The text insertion listener logic.
         */
        TextInsertedListener listener = new TextInsertedListener();
        userNameField.getDocument().addDocumentListener(listener);
        passwordField.getDocument().addDocumentListener(listener);

        /**
         * Adds button to the panel.
         */
        constraints.gridx = 1;
        constraints.gridy = 2;
        this.add(loginButton, constraints);

    }

    /**
     * Enables the login button if both username and password have text.
     */
    private void checkLoginButtonState()
    {
        String user = userNameField.getText();
        char[] pass = passwordField.getPassword();

        if (!user.isEmpty() && pass.length > 0)
        {
            loginButton.setEnabled(true);
        }
        else
        {
            loginButton.setEnabled(false);
        }
    }

    /**
     * Implement Document Listener to determine if user has entered something in
     * username
     * and password fields.
     */
    private class TextInsertedListener implements DocumentListener
    {
        /**
         * Listens for insertion of text into the document.
         *
         * @param e The document event.
         */
        @Override
        public void insertUpdate(DocumentEvent e)
        {
            checkLoginButtonState();
        }

        /**
         * Listens for the removal of text from the document.
         *
         * @param e The document event.
         */
        @Override
        public void removeUpdate(DocumentEvent e)
        {
            checkLoginButtonState();
        }

        /**
         * Listens for changes in the document.
         *
         * @param e The document event.
         */
        @Override
        public void changedUpdate(DocumentEvent e)
        {
            checkLoginButtonState();
        }
    }

}
