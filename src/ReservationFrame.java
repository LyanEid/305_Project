import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class ReservationFrame extends JFrame implements ActionListener {

    JTextField tfName, tfPassport, tfPhone, tfEmail, tfNationality;
    JComboBox<String> cbLuggage, cbSeatClass;
    JButton btnConfirm, btnClear;

    public ReservationFrame() {
        super("Flight Reservation - Passenger Details");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(460, 520);
        setLocationRelativeTo(null);
        setResizable(false);
        buildUI();
        setVisible(true);
    }

    void buildUI() {
        setLayout(new BorderLayout());

        // Header
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(0x2E4156));
        header.setBorder(BorderFactory.createEmptyBorder(14, 20, 14, 20));

        JLabel logo = new JLabel("✈  Flight Reservation");
        logo.setFont(new Font("SansSerif", Font.BOLD, 16));
        logo.setForeground(Color.WHITE);
        header.add(logo, BorderLayout.WEST);

        JLabel flight = new JLabel("JED → DXB | AD 4821");
        flight.setFont(new Font("SansSerif", Font.PLAIN, 11));
        flight.setForeground(new Color(0xB0BEC5));
        header.add(flight, BorderLayout.EAST);

        add(header, BorderLayout.NORTH);

        // Form
        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(new Color(0xF5F7FA));
        form.setBorder(BorderFactory.createEmptyBorder(20, 28, 10, 28));

        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(7, 6, 7, 6);
        g.fill = GridBagConstraints.HORIZONTAL;

        // Section: Personal Info
        g.gridy=0; g.gridx=0; g.gridwidth=2;
        form.add(sectionLabel("Personal Information"), g);
        g.gridwidth=1;

        g.gridy=1; g.gridx=0; form.add(fieldLabel("Full Name"), g);
        g.gridx=1; tfName = inputField("Enter full name"); form.add(tfName, g);

        g.gridy=2; g.gridx=0; form.add(fieldLabel("Nationality"), g);
        g.gridx=1; tfNationality = inputField("e.g. Saudi"); form.add(tfNationality, g);

        g.gridy=3; g.gridx=0; form.add(fieldLabel("Passport"), g);
        g.gridx=1; tfPassport = inputField("e.g. A12345678"); form.add(tfPassport, g);

        // Section: Contact
        g.gridy=4; g.gridx=0; g.gridwidth=2;
        form.add(sectionLabel("Contact Details"), g);
        g.gridwidth=1;

        g.gridy=5; g.gridx=0; form.add(fieldLabel("Phone"), g);
        g.gridx=1; tfPhone = inputField("+966..."); form.add(tfPhone, g);

        g.gridy=6; g.gridx=0; form.add(fieldLabel("Email"), g);
        g.gridx=1; tfEmail = inputField("name@email.com"); form.add(tfEmail, g);

        // Section: Preferences
        g.gridy=7; g.gridx=0; g.gridwidth=2;
        form.add(sectionLabel("Flight Preferences"), g);
        g.gridwidth=1;

        g.gridy=8; g.gridx=0; form.add(fieldLabel("Seat Class"), g);
        g.gridx=1; cbSeatClass = new JComboBox<>(new String[]{"Economy", "Business", "First Class"}); form.add(cbSeatClass, g);

        g.gridy=9; g.gridx=0; form.add(fieldLabel("Luggage"), g);
        g.gridx=1; cbLuggage = new JComboBox<>(new String[]{"0 KG","20 KG","30 KG","40 KG"}); form.add(cbLuggage, g);

        JScrollPane scroll = new JScrollPane(form);
        scroll.setBorder(null);
        add(scroll, BorderLayout.CENTER);

        // Footer
        JPanel footer = new JPanel(new GridLayout(1, 2, 12, 0));
        footer.setBackground(new Color(0xECEFF1));
        footer.setBorder(BorderFactory.createEmptyBorder(12, 28, 12, 28));

        btnConfirm = makeButton("Confirm Reservation", new Color(0x4A6FA5), Color.WHITE);
        btnConfirm.addActionListener(this);

        btnClear = makeButton("Clear", new Color(0xE0E0E0), Color.DARK_GRAY);
        btnClear.addActionListener(this);

        footer.add(btnConfirm);
        footer.add(btnClear);
        add(footer, BorderLayout.SOUTH);
    }

    // Helpers
    JLabel sectionLabel(String text) {
        JLabel l = new JLabel(text);
        l.setFont(new Font("SansSerif", Font.BOLD, 12));
        l.setForeground(new Color(0x4A6FA5));
        l.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0xCFD8DC)));
        return l;
    }

    JLabel fieldLabel(String text) {
        JLabel l = new JLabel(text);
        l.setFont(new Font("SansSerif", Font.PLAIN, 12));
        return l;
    }

    JTextField inputField(String tooltip) {
        JTextField tf = new JTextField(18);
        tf.setToolTipText(tooltip);
        return tf;
    }

    JButton makeButton(String text, Color bg, Color fg) {
        JButton b = new JButton(text);
        b.setBackground(bg);
        b.setForeground(fg);
        b.setFocusPainted(false);
        b.setOpaque(true);
        b.setBorderPainted(false);
        return b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnConfirm) {
            confirmAction();
        } else if (e.getSource() == btnClear) {
            clearFields();
        }
    }

    void confirmAction() {
        if (tfName.getText().trim().isEmpty() || tfEmail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in the required fields.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //
        new PaymentFrame().setVisible(true);
        this.dispose();
    }

    void clearFields() {
        tfName.setText("");
        tfNationality.setText("");
        tfPassport.setText("");
        tfPhone.setText("");
        tfEmail.setText("");
        cbSeatClass.setSelectedIndex(0);
        cbLuggage.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
        catch (Exception ignored) {}
        SwingUtilities.invokeLater(ReservationFrame::new);
    }
}