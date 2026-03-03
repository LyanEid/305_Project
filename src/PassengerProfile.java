import javax.swing.*;
import java.awt.*;

public class PassengerProfile {

    public static void main(String[] args) {
        showProfile();
    }

    static void showProfile() {
        JFrame frame = new JFrame("My Profile");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(420, 580);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel main = new JPanel(null);
        main.setBackground(Color.WHITE);
        frame.setContentPane(main);

        // header background
        JPanel header = new JPanel(null);
        header.setBackground(new Color(0x2E4156));
        header.setBounds(0, 0, 420, 55);
        main.add(header);

        JLabel title = new JLabel("My Profile");
        title.setFont(new Font("SansSerif", Font.BOLD, 15));
        title.setForeground(Color.WHITE);
        title.setBounds(20, 15, 200, 25);
        header.add(title);

        JButton btnEdit = new JButton("Edit");
        btnEdit.setFont(new Font("SansSerif", Font.PLAIN, 12));
        btnEdit.setForeground(new Color(0xB0BEC5));
        btnEdit.setBackground(new Color(0x3D566E));
        btnEdit.setFocusPainted(false);
        btnEdit.setBorderPainted(false);
        btnEdit.setBounds(320, 13, 70, 28);
        header.add(btnEdit);
//_______________________________________________________
        // avatar circle
        JLabel avatar = new JLabel("?", SwingConstants.CENTER);
        avatar.setFont(new Font("SansSerif", Font.BOLD, 18));
        avatar.setForeground(Color.WHITE);
        avatar.setOpaque(true);
        avatar.setBackground(new Color(0x4A6FA5));
        avatar.setBounds(20, 75, 44, 44);
        main.add(avatar);

        JLabel lblName = new JLabel("—");
        lblName.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblName.setForeground(new Color(0x263238));
        lblName.setBounds(74, 80, 200, 18);
        main.add(lblName);

        JLabel lblNationality = new JLabel("—");
        lblNationality.setFont(new Font("SansSerif", Font.PLAIN, 11));
        lblNationality.setForeground(new Color(0x90A4AE));
        lblNationality.setBounds(74, 100, 200, 15);
        main.add(lblNationality);
//_______________________________________________________
        // passport row
        JLabel passportKey = new JLabel("Passport");
        passportKey.setFont(new Font("SansSerif", Font.PLAIN, 12));
        passportKey.setForeground(new Color(0x90A4AE));
        passportKey.setBounds(20, 140, 90, 20);
        main.add(passportKey);

        JLabel passportVal = new JLabel("—");
        passportVal.setFont(new Font("SansSerif", Font.PLAIN, 12));
        passportVal.setForeground(new Color(0x263238));
        passportVal.setBounds(115, 140, 200, 20);
        main.add(passportVal);
//_______________________________________________________
        // phone row
        JLabel phoneKey = new JLabel("Phone");
        phoneKey.setFont(new Font("SansSerif", Font.PLAIN, 12));
        phoneKey.setForeground(new Color(0x90A4AE));
        phoneKey.setBounds(20, 165, 90, 20);
        main.add(phoneKey);

        JLabel phoneVal = new JLabel("—");
        phoneVal.setFont(new Font("SansSerif", Font.PLAIN, 12));
        phoneVal.setForeground(new Color(0x263238));
        phoneVal.setBounds(115, 165, 200, 20);
        main.add(phoneVal);
//_______________________________________________________
        // email row
        JLabel emailKey = new JLabel("Email");
        emailKey.setFont(new Font("SansSerif", Font.PLAIN, 12));
        emailKey.setForeground(new Color(0x90A4AE));
        emailKey.setBounds(20, 190, 90, 20);
        main.add(emailKey);

        JLabel emailVal = new JLabel("—");
        emailVal.setFont(new Font("SansSerif", Font.PLAIN, 12));
        emailVal.setForeground(new Color(0x263238));
        emailVal.setBounds(115, 190, 200, 20);
        main.add(emailVal);
//_______________________________________________________
        // divider
        JSeparator sep = new JSeparator();
        sep.setForeground(new Color(0xE0E0E0));
        sep.setBounds(20, 225, 380, 10);
        main.add(sep);
//_______________________________________________________
        // tickets section
        JLabel ticketsTitle = new JLabel("My Tickets");
        ticketsTitle.setFont(new Font("SansSerif", Font.BOLD, 13));
        ticketsTitle.setForeground(new Color(0x263238));
        ticketsTitle.setBounds(20, 240, 200, 20);
        main.add(ticketsTitle);

        JLabel noTickets = new JLabel("No tickets yet — book a flight to see history.");
        noTickets.setFont(new Font("SansSerif", Font.PLAIN, 12));
        noTickets.setForeground(new Color(0xB0BEC5));
        noTickets.setBounds(20, 268, 380, 20);
        main.add(noTickets);

        frame.setVisible(true);
    }
}