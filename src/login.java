import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;

public class login extends JFrame {

    public static void main(String[] args) {
        showSplash();
    }

    static void showSplash() {


            JFrame splash = new JFrame();
            splash.setSize(400, 420);
            splash.setLocationRelativeTo(null);
            splash.setUndecorated(true);
            splash.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel container = new JPanel();
            container.setBackground(Color.WHITE);
            container.setLayout(new BorderLayout());

            JPanel centerPanel = new JPanel();
            centerPanel.setBackground(Color.WHITE);
            centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

            JLabel title = new JLabel("Airline Ticket Reservation");
            title.setFont(new Font("SansSerif", Font.BOLD, 20));
            title.setForeground(new Color(0x1A2D42));
            title.setAlignmentX(Component.CENTER_ALIGNMENT);
//adding logo imaeg
            ImageIcon originalIcon = new ImageIcon("p1.jpg");
            Image scaledImage = originalIcon.getImage()
                    .getScaledInstance(300, -1, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            JLabel imageLabel = new JLabel(scaledIcon);
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            centerPanel.add(Box.createVerticalGlue());
            centerPanel.add(title);
            centerPanel.add(Box.createVerticalStrut(20));
            centerPanel.add(imageLabel);
            centerPanel.add(Box.createVerticalGlue());

            container.add(centerPanel, BorderLayout.CENTER);

            splash.setContentPane(container);
            splash.setVisible(true);

            Timer t = new Timer(1000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    splash.dispose();
                    showLogin();
                }
            });
            t.setRepeats(false);
            t.start();


    }

    static void showLogin() {
        JFrame frame = new JFrame("Airline Ticket Reservation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 420);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel main = new JPanel(null);
        main.setBackground(new Color(0xD4D8DD));
        frame.setContentPane(main);

        JLabel title = new JLabel(" Welcome to Airline Ticket Reservation", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        title.setForeground(new Color(0x1A2D42));
        title.setBounds(0, 20, 400, 30);
        main.add(title);

// username field
        JLabel uLabel = new JLabel("Username");
        uLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        uLabel.setForeground(new Color(0x1A2D42));
        uLabel.setBounds(60, 95, 150, 20);
        main.add(uLabel);


        JTextField userField = new JTextField();
        userField.setFont(new Font("SansSerif", Font.PLAIN, 13));
        userField.setBounds(60, 118, 280, 30);
        main.add(userField);
//--------------------------------------------------------
        //password field
        JLabel pLabel = new JLabel("Password");
        pLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        pLabel.setForeground(new Color(0x1A2D42));
        pLabel.setBounds(60, 162, 150, 20);
        main.add(pLabel);

        JPasswordField passField = new JPasswordField();
        passField.setFont(new Font("SansSerif", Font.PLAIN, 13));
        passField.setBounds(60, 185, 280, 30);
        main.add(passField);
//--------------------------------------------------------
        //forget password botton
        JLabel forgot = new JLabel("<html><u>forget password</u></html>");
        forgot.setFont(new Font("SansSerif", Font.PLAIN, 12));
        forgot.setForeground(new Color(0x2E4156));
        forgot.setBounds(60, 224, 150, 18);
        main.add(forgot);
//--------------------------------------------------------
        //login button
        JButton loginBtn = new JButton("Login");
        loginBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
        loginBtn.setBackground(new Color(0x1A2D42));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFocusPainted(false);
        loginBtn.setBorderPainted(false);
        loginBtn.setBounds(60, 258, 280, 35);
        main.add(loginBtn);
//--------------------------------------------------------
        //register button
        JLabel noAcc = new JLabel("you don't have an account?");
        noAcc.setFont(new Font("SansSerif", Font.PLAIN, 13));
        noAcc.setForeground(new Color(0x1A2D42));
        noAcc.setBounds(60, 308, 195, 20);
        main.add(noAcc);

        JLabel regLink = new JLabel("<html><u>Register</u></html>");
        regLink.setFont(new Font("SansSerif", Font.BOLD, 13));
        regLink.setForeground(new Color(0x1A2D42));
        regLink.setBounds(255, 308, 70, 20);
        main.add(regLink);

        frame.setVisible(true);
    }
}