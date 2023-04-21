import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class PasswordManagerGUI extends JFrame implements ActionListener {
// public static Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
 //   public static int windowwidth = (int)size.getWidth();
//    public static int windowheight = (int)size.getHeight();

    private JTextField websiteField;
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton addButton;
   // private JTextField emptyField;
    private JButton viewButton;
    private JTextArea passwordList;

    public PasswordManagerGUI() {
    // System.out.println(windowwidth+""+windowheight);
       // setLocation(windowwidth/2-400,windowheight/2-200);

        setTitle("Password Manager");
        setSize(1366, 786);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout( 6,4));

        JLabel websiteLabel = new JLabel("Website:");
        websiteField = new JTextField(20);
        add(websiteLabel);
        add(websiteField);

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        add(usernameLabel);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JTextField(20);
        add(passwordLabel);
        add(passwordField);

        addButton = new JButton("Add Password");
        addButton.addActionListener(this);
        add(addButton);

       //JLabel emptyLabel = new JLabel("");
        //emptyField = new JTextField(20);
        //add(emptyLabel);
       // add(emptyField);

        viewButton = new JButton("View Passwords");
        viewButton.addActionListener(this);
        add(viewButton);

        passwordList = new JTextArea();
        passwordList.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(passwordList);
        add(scrollPane);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            addPassword();
        } else if (e.getSource() == viewButton) {
            viewPasswords();
        }
    }

    private void addPassword() {
        String website = websiteField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (website.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter website, username, and password.");
            return;
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("passwords.txt", true));
            writer.write(website + "," + username + "," + password);
            writer.newLine();
            writer.close();
            JOptionPane.showMessageDialog(this, "Password added successfully.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error adding password: " + ex.getMessage());
        }

        websiteField.setText("");
        usernameField.setText("");
        passwordField.setText("");
    }

    private void viewPasswords() {
        passwordList.setText("");

        try {
            BufferedReader reader = new BufferedReader(new FileReader("passwords.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                passwordList.append("Website: " + parts[0] + "\n");
                passwordList.append("Username: " + parts[1] + "\n");
                passwordList.append("Password: " + parts[2] + "\n\n");
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error viewing passwords: " + ex.getMessage());
        }

 }

    public static void main(String[] args) {
        new PasswordManagerGUI();
    }
}