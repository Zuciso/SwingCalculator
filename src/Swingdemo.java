import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Swingdemo {
    public static void main(String[] args) {
        System.out.println("Hello");
        Addition obj = new Addition();


    }
}

class Addition extends JFrame implements ActionListener{
    String s0,s1,s2;
    JTextField t1;
    JButton b1,b2,b3,b4;
    JLabel l;
    JRadioButton rb,rb2;
    public Addition(){
        s0=s1=s2="";

        try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        t1= new JTextField(20);
        t1.setEditable(false);
        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1;
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        beq1 = new JButton("=");
        ba = new JButton("+");
        bs = new JButton("-");
        bd = new JButton("/");
        bm = new JButton("*");
        beq = new JButton("C");
        be = new JButton(".");
        Container mainContainer = getContentPane();
        mainContainer.setLayout(new BorderLayout(8,6));

        getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.green));
        JPanel top = new JPanel();
        top.setBorder(new LineBorder(Color.BLACK,3));

        top.setLayout(new FlowLayout());

        top.add(t1);
        mainContainer.add(top,BorderLayout.NORTH);
        JPanel temp = new JPanel();
        temp.setLayout(new FlowLayout());
        JPanel mid = new JPanel();
        mid.setLayout(new GridLayout(4,4,4,4));

        mid.add(ba);
        mid.add(b1);
        mid.add(b2);
        mid.add(b3);
        mid.add(bs);
        mid.add(b4);
        mid.add(b5);
        mid.add(b6);
        mid.add(bm);
        mid.add(b7);
        mid.add(b8);
        mid.add(b9);
        mid.add(bd);
        mid.add(be);
        mid.add(b0);
        mid.add(beq);
        temp.add(mid);
        mainContainer.add(temp,BorderLayout.WEST);
        JPanel bot = new JPanel();
        bot.add(beq1);
        mainContainer.add(bot,BorderLayout.SOUTH);

        bm.addActionListener(this);
        bd.addActionListener(this);
        bs.addActionListener(this);
        ba.addActionListener(this);
        b9.addActionListener(this);
        b8.addActionListener(this);
        b7.addActionListener(this);
        b6.addActionListener(this);
        b5.addActionListener(this);
        b4.addActionListener(this);
        b3.addActionListener(this);
        b2.addActionListener(this);
        b1.addActionListener(this);
        b0.addActionListener(this);
        be.addActionListener(this);
        beq.addActionListener(this);
        beq1.addActionListener(this);






        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y=e.getY();
                System.out.println(x+ " " +y);
            }
        });
        setLocation(500,300);

        setLayout(new FlowLayout());
        setVisible(true);
        setSize(200,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            // if operand is present then add to second no
            if (!s1.equals(""))
                s2 = s2 + s;
            else
                s0 = s0 + s;

            // set the value of text
            t1.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == 'C') {

            s0 = s1 = s2 = "";
            l.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == '=') {

            double te;


            if (s1.equals("+"))
                te = (Double.parseDouble(s0) + Double.parseDouble(s2));
            else if (s1.equals("-"))
                te = (Double.parseDouble(s0) - Double.parseDouble(s2));
            else if (s1.equals("/"))
                te = (Double.parseDouble(s0) / Double.parseDouble(s2));
            else
                te = (Double.parseDouble(s0) * Double.parseDouble(s2));

            t1.setText(s0 + s1 + s2 + "=" + te);

            s0 = Double.toString(te);

            s1 = s2 = "";
        }
        else {

            if (s1.equals("") || s2.equals(""))
                s1 = s;

            else {
                double te;


                if (s1.equals("+"))
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if (s1.equals("-"))
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                else if (s1.equals("/"))
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                else
                    te = (Double.parseDouble(s0) * Double.parseDouble(s2));


                s0 = Double.toString(te);


                s1 = s;


                s2 = "";
            }


            t1.setText(s0 + s1 + s2);
        }
    }
}
