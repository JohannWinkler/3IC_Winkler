import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener {
    private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bC, bPlus, bMinus, bMal, bGeteilt, bGleich;
    private JTextField tf;
    private int num1, num2, result;
    private char operator;

    public Main() {
        setTitle("Taschenrechner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);

        tf = new JTextField(10);
        tf.setEditable(false);

        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b0 = new JButton("0");
        bC = new JButton("C");
        bPlus = new JButton("+");
        bMinus = new JButton("-");
        bMal = new JButton("*");
        bGeteilt = new JButton("/");
        bGleich = new JButton("=");

        JPanel panel = new JPanel(new GridLayout(4, 4));
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(bPlus);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(bMinus);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(bMal);
        panel.add(b0);
        panel.add(bC);
        panel.add(bGeteilt);
        panel.add(bGleich);

        add(tf, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        bPlus.addActionListener(this);
        bMinus.addActionListener(this);
        bMal.addActionListener(this);
        bGeteilt.addActionListener(this);
        bGleich.addActionListener(this);
        bC.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            tf.setText(tf.getText() + "1");
        } else if (e.getSource() == b2) {
            tf.setText(tf.getText() + "2");
        } else if (e.getSource() == b3) {
            tf.setText(tf.getText() + "3");
        } else if (e.getSource() == b4) {
            tf.setText(tf.getText() + "4");
        } else if (e.getSource() == b5) {
            tf.setText(tf.getText() + "5");
        } else if (e.getSource() == b6) {
            tf.setText(tf.getText() + "6");
        } else if (e.getSource() == b7) {
            tf.setText(tf.getText() + "7");
        } else if (e.getSource() == b8) {
            tf.setText(tf.getText() + "8");
        } else if (e.getSource() == b9) {
            tf.setText(tf.getText() + "9");
        } else if (e.getSource() == b0) {
            tf.setText(tf.getText() + "0");
        } else if (e.getSource() == bC) {
            tf.setText("");
        } else if (e.getSource() == bPlus) {
            num1 = Integer.parseInt(tf.getText());
            operator = '+';
            tf.setText("");
        } else if (e.getSource() == bMinus) {
            num1 = Integer.parseInt(tf.getText());
            operator = '-';
            tf.setText("");
        } else if (e.getSource() == bMal) {
            num1 = Integer.parseInt(tf.getText());
            operator = '*';
            tf.setText("");
        } else if (e.getSource() == bGeteilt) {
            num1 = Integer.parseInt(tf.getText());
            operator = '/';
            tf.setText("");
        } else if (e.getSource() == bGleich) {
            num2 = Integer.parseInt(tf.getText());
            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
            }
            tf.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) {
        Main taschenrechner = new Main();
        taschenrechner.setVisible(true);
    }
}
