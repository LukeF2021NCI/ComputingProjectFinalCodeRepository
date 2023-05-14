import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordStrength implements ActionListener {
    JFrame strength_check_frame = new JFrame();

    //getting access to the screen using Frame object
    Container strength_check_window = strength_check_frame.getContentPane();

    //text fields
    JTextField password = new JTextField("Enter password");
    JButton check = new JButton("Get result");
    JButton main_page = new JButton("Back");

    void checkStrength(){
        strength_check_frame.setBounds(50,50,250, 250);

        password.setBounds(50,20, 150, 25);
        strength_check_window.add(password);

        check.setBounds(70, 90, 120,25);
        strength_check_window.add(check);

        check.addActionListener(this);

        main_page.setBounds(70, 130, 80,25);
        strength_check_window.add(main_page);

        main_page.addActionListener(this);

        strength_check_window.setLayout(null);
        //setting the UI to become visible true
        strength_check_frame.setVisible(true);
        //on closing window app should close in background
        strength_check_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == check){
            String pass = password.getText();
            boolean hasLowercase = false;
            boolean hasUppercase = false;
            boolean hasSpecialChar = false;

            for (int i = 0; i < pass.length(); i++) {
                char c = pass.charAt(i);
                if (Character.isLowerCase(c)) {
                    hasLowercase = true;
                } else if (Character.isUpperCase(c)) {
                    hasUppercase = true;
                } else if (!Character.isLetterOrDigit(c)) {
                    hasSpecialChar = true;
                }


            }
            if (hasLowercase && hasUppercase && hasSpecialChar) {
                JOptionPane.showMessageDialog(strength_check_frame, "password strength is strong");
            } else {
                JOptionPane.showMessageDialog(strength_check_frame, "password strength is " +
                        "not strong i.e include special characters, lower case ,  upper case letter combination to" +
                        " make it strong");
            }
        }else if(e.getSource() == main_page){
            strength_check_frame.dispose();

        }
    }
}
