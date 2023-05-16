/** UserGUI.java
 *  This class displays the GUI
 *  Andrea Jacobs 218024266
 *  16 May 2023 */

package za.ac.cput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserGUI extends JFrame implements ActionListener {
    private JPanel panelNorth, panelSouth;
    private JLabel lblUsername, lblPassword;
    private JTextField txtUsername;
    private JPasswordField txtPassword;

    private JMenu fileMenu;
    private JMenuBar menuBar;
    private JMenuItem loginItem, clearItem, exitItem;

    private JButton btnLogin, btnClear, btnExit;
    private Font ft, btnFt;

    public UserGUI() {
        super("User Authentication");

        panelNorth = new JPanel();
        panelSouth = new JPanel();

        fileMenu = new JMenu("File");
        menuBar = new JMenuBar();

        loginItem = new JMenuItem("Login");
        clearItem = new JMenuItem("Clear");
        exitItem = new JMenuItem("Exit");

        lblUsername = new JLabel("Username: ");
        lblPassword = new JLabel("Password: ");

        txtUsername = new JTextField(15);

        txtPassword = new JPasswordField();

        btnLogin = new JButton("Login");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");

        ft = new Font("Arial", Font.PLAIN, 22);
        btnFt = new Font("Arial", Font.BOLD, 20);
    }

    public  void setGUI(){
        panelNorth.setLayout(new GridLayout(2, 2));
        panelSouth.setLayout(new GridLayout(1, 3));

        this.setJMenuBar(menuBar);

        fileMenu.add(loginItem);
        fileMenu.add(clearItem);
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        loginItem.addActionListener(this);
        clearItem.addActionListener(this);
        exitItem.addActionListener(this);

        panelNorth.add(lblUsername);
        lblUsername.setFont(ft);
        panelNorth.add(txtUsername);
        txtUsername.setFont(ft);
        panelNorth.add(lblPassword);
        lblPassword.setFont(ft);
        panelNorth.add(txtPassword);
        txtPassword.setFont(ft);

        panelSouth.add(btnLogin);
        btnLogin.setBackground(Color.GREEN);
        btnLogin.setFont(btnFt);
        panelSouth.add(btnClear);
        btnClear.setBackground(Color.BLUE);
        btnClear.setFont(btnFt);
        panelSouth.add(btnExit);
        btnExit.setBackground(Color.RED);
        btnExit.setFont(btnFt);

        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelSouth, BorderLayout.SOUTH);

        btnLogin.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        this.setVisible(true);
        this.setSize(400, 175);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private boolean isValidUser(String username, String password) {
        String[] user = {"andreajacobs", "meshaanbailey", "jasonclaasen", "genayjulies", "aidenjacobs", "phiwemkhondo"};
        String[] pass = {"123", "456", "789", "000", "111", "222"};

        boolean found = false;

        for(int i = 0; i < user.length; i++){
            if(username.equals(user[i]) && password.equals(pass[i])){
                found = true;
                break;
            }
        }
        return found;
    }

    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Login")){
            String username = txtUsername.getText();
            String password = String.valueOf(txtPassword.getPassword());

            if(isValidUser(username, password)){
                JOptionPane.showMessageDialog(null, "Welcome "+ username + ".Login success!");
            }
            else {
                JOptionPane.showMessageDialog(null, "Username/Password is incorrect");
            }

        }
        else if (e.getActionCommand().equals("Clear")){
            txtUsername.setText("");
            txtPassword.setText("");
        }
        else if (e.getActionCommand().equals("Exit")){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new UserGUI().setGUI();
    }


}
