import javax.swing.*;
import java.awt.*;

public class Home {

    public static void main(String[] args) {
        showHome();
    }

    static void showHome() {
        JFrame frame = new JFrame("Home");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 450);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel main = new JPanel(null);
        main.setBackground(new Color(0xD4D8DD));
        frame.setContentPane(main);

        JLabel title = new JLabel("Airline Ticket Reservation", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 22));
        title.setForeground(new Color(0x1A2D42));
        title.setBounds(0, 30, 400, 30);
        main.add(title);

        JLabel welcome = new JLabel("Welcome Back!", SwingConstants.CENTER);
        welcome.setFont(new Font("SansSerif", Font.PLAIN, 14));
        welcome.setForeground(new Color(0x2E4156));
        welcome.setBounds(0, 65, 400, 20);
        main.add(welcome);

        JButton profileBtn = new JButton("Profile");
        profileBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
        profileBtn.setBackground(new Color(0x1A2D42));
        profileBtn.setForeground(Color.WHITE);
        profileBtn.setFocusPainted(false);
        profileBtn.setBorderPainted(false);
        profileBtn.setEnabled(false);
        profileBtn.setBounds(60, 120, 280, 45);
        main.add(profileBtn);

        JButton searchBtn = new JButton("Search for flights");
        searchBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
        searchBtn.setBackground(new Color(0x1A2D42));
        searchBtn.setForeground(Color.WHITE);
        searchBtn.setFocusPainted(false);
        searchBtn.setBorderPainted(false);
        searchBtn.setEnabled(false);
        searchBtn.setBounds(60, 185, 280, 45);
        main.add(searchBtn);

        JButton reservationBtn = new JButton("Your Reservations");
        reservationBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
        reservationBtn.setBackground(new Color(0x1A2D42));
        reservationBtn.setForeground(Color.WHITE);
        reservationBtn.setFocusPainted(false);
        reservationBtn.setBorderPainted(false);
        reservationBtn.setEnabled(false);
        reservationBtn.setBounds(60, 250, 280, 45);
        main.add(reservationBtn);

        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
        logoutBtn.setBackground(new Color(0x1A2D42));
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.setFocusPainted(false);
        logoutBtn.setBorderPainted(false);
        logoutBtn.setEnabled(false);
        logoutBtn.setBounds(60, 315, 280, 45);
        main.add(logoutBtn);

        frame.setVisible(true);
    }
}

