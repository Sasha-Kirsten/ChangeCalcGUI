// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;
// //import java.awt.event.ActionListener;

// public class ChangeCalcGUI  extends JFrame{
//     JFrame calFrame = new JFrame("Calculator");

//     //private final JTextField priceField;
//     //private final JTextField paidField;

//     ChangeCalcGUI(){
//         calFrame.setSize(400, 400);
//         calFrame.getContentPane().setBackground(Color.orange);
//         calFrame.setLocationRelativeTo(null);
//         calFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//         JPanel panelScreen = new JPanel();
//         panelScreen.setLayout(new GridLayout());
//         JTextArea textArea = new JTextArea();
//         //panelScreen.add(textArea);

//         //calFrame.setTitle("Change Color Calculator");
//         //calFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


//         JPanel panelButtons = new JPanel(new GridLayout(3,3));
//         //this.setLayout(new GridLayout(3,3));

//         JButton f1 = new JButton("1");
//         //f1.setBounds(10, 120, 50, 50);
//         panelButtons.add(f1);
// //        convert.addActionListener(this);

//         JButton f2 = new JButton("2");
//         //f2.setBounds(20, 120, 50, 50);
//         panelButtons.add(f2);
// //        convert.addActionListener(this);

//         JButton f3 = new JButton("3");
//         //f3.setBounds(30, 120, 50, 50);
//         panelButtons.add(f3);
// //        convert.addActionListener(this);

//         JButton f4 = new JButton("4");
//         //f4.setBounds(40, 120, 50, 50);
//         panelButtons.add(f4);
// //        convert.addActionListener(this);

//         JButton f5 = new JButton("5");
//         //f5.setBounds( 10, 150, 50, 50);
//         panelButtons.add(f5);
// //        convert.addActionListener(this);

//         JButton f6 = new JButton("6");
//         //f6.setBounds(20, 150, 50, 50);
//         panelButtons.add(f6);
// //        convert.addActionListener(this);

//         JButton f7 = new JButton("7");
//         //f7.setBounds( 30, 150, 50, 50);
//         panelButtons.add(f7);
// //        convert.addActionListener(this);

//         JButton f8 = new JButton("8");
//         //f8.setBounds( 40, 150, 50, 50);
//         panelButtons.add(f8);
// //        convert.addActionListener(this);

//         JButton f9 = new JButton("9");
//         //f9.setBounds( 10, 180, 50, 50);
//         panelButtons.add(f9);
// //        convert.addActionListener(this);

//         JButton fPlus = new JButton("+");
//         //fPlus.setBounds( 20, 180, 50, 50);
//         panelButtons.add(fPlus);
// //        convert.addActionListener(this);

//         JButton fMinus = new JButton("-");
//         //fMinus.setBounds( 30, 180, 50, 50);
//         panelButtons.add(fMinus);
// //        convert.addActionListener(this);

//         JButton fDivide = new JButton("/");
//         //fDivide.setBounds( 40, 180, 50, 50);
//         panelButtons.add(fDivide);
// //        convert.addActionListener(this);

//         JButton f0 = new JButton("0");
//         //f0.setBounds(10, 210, 50, 50);
//         panelButtons.add(f0);
// //        convert.addActionListener(this);

//         JButton fMultiply = new JButton("*");
//         //fMultiply.setBounds( 20, 210, 50, 50);
//         panelButtons.add(fMultiply);
// //        convert.addActionListener(this);

//         JButton fDEL = new JButton("DEL");
//         //fDEL.setBounds(30, 210, 50, 50);
//         panelButtons.add(fDEL);
// //        convert.addActionListener(this)


//         JButton fEqual = new JButton("=");
//         //fEqual.setBounds(40, 210, 50, 50);
//         panelButtons.add(fEqual);

//         this.setVisible(true);
//     }


//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(new Runnable() {
//             public void run() {
//                 new ChangeCalcGUI();
//             }
//             });
//     }

//     //@Override
//     public void actionPerformed(ActionEvent e) {

//         int f0 = 0;
//         int f1 = 1;
//         int f2 = 2;
//         int f3 = 3;
//         int f4 = 4;
//         int f5 = 5;
//         int f6 = 6;
//         int f7 = 7;
//         int f8 = 8;
//         int f9 = 9;

//     }
// }












import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;


public class ChangeCalcGUI extends JFrame {

    private JTextField priceField;
    private JTextField paidField;
    private JButton calculateButton;
    private JButton clearButton;
    private JTextArea resultArea;

    public ChangeCalcGUI() {
        setTitle("Change Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Price:"));
        priceField = new JTextField(5);
        add(priceField);

        add(new JLabel("Paid:"));
        paidField = new JTextField(5);
        add(paidField);

        calculateButton = new JButton("Calculate Change");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double price = Double.parseDouble(priceField.getText());
                    double paid = Double.parseDouble(paidField.getText());
                    TreeMap<NotesAndCoins, Integer> change = MainChange.calcChange(price, paid);

                    StringBuilder result = new StringBuilder();
                    for (Map.Entry<NotesAndCoins, Integer> entry : change.entrySet()) {
                        result.append(entry.getKey()).append("=").append(entry.getValue()).append("\n");
                    }
                    resultArea.setText(result.toString());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numeric values.");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        add(calculateButton);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                        priceField.setText("");
                        paidField.setText("");
                        resultArea.setText("");
                }
        });
        add(clearButton);

        resultArea = new JTextArea(12, 20);
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea));

        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ChangeCalcGUI();
            }
        });
    }
}


































