//package battleshipsJava.mvc;
//
//
//import org.practise.fifteen.util.PropertyReader;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.util.Properties;
//
//public class LoginView extends JFrame implements ActionListener {
//    JTextField text1, text2;
//
//    public LoginView() {
//        JLabel label1 = new JLabel();
//        label1.setText("Username:");
//        text1 = new JTextField(15);
//
//        JLabel label2 = new JLabel();
//        label2.setText("Password:");
//        text2 = new JPasswordField(15);
//
//        JButton startGame = new JButton("Start game");
//
//        JPanel panel = new JPanel(new GridLayout(3, 1));
//        panel.add(label1);
//        panel.add(text1);
//        panel.add(label2);
//        panel.add(text2);
//        panel.add(startGame);
//        add(panel, BorderLayout.CENTER);
//        startGame.addActionListener(this);
//
//        setTitle("LOGIN FORM");
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        String value1 = text1.getText();
//        String value2 = text2.getText();
//        Properties prop = PropertyReader.readGameProperties();
//        String allowedLoginName = prop.getProperty("login");
//        String allowedPassword = prop.getProperty("password");
//
//        if (value1.equals(allowedLoginName) && value2.equals(allowedPassword)) {
//
//            this.dispose();
//            Fifteen game1 = new Fifteen();
//            game1.setTitle("Fifteen");
//            game1.setSize(400, 400);
//            game1.setVisible(true);
//            game1.random();
//        } else {
//            JOptionPane.showMessageDialog(this, "Incorrect login or password",
//                    "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//}
