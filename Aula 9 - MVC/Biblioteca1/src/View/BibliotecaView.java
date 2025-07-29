package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BibliotecaView extends JFrame {
    private JLabel lblCounter;
    private JButton btnIncrement;
    private JButton btnDecrement;

    public BibliotecaView(){
        setTitle("Biblioteca");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        lblCounter = new JLabel("0");
        lblCounter.setFont(new Font("Times New Roman", Font.BOLD, 48));

        btnIncrement = new JButton("Increment");
        btnIncrement.setFont(new Font("Times New Roman", Font.BOLD, 18));

        btnDecrement = new JButton("Decrement");
        btnDecrement.setFont(new Font("Times New Roman", Font.BOLD, 18));

        add(lblCounter);
        add(btnIncrement);
        add(btnDecrement);
    }

    public void setValor(int value){
        lblCounter.setText(String.valueOf(value));
    }

    public void incrementListener(ActionListener listener){
        btnIncrement.addActionListener(listener);
    }

    public void decrementListener(ActionListener listener){
        btnDecrement.addActionListener(listener);
    }
}
