import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.awt.event.*;

public class GraphicalCalculator{

    public static int status = 0;
    public static String storedText = null;
    public static float storedValue;

    public static void CreateGraphicalCalculator(){
        JFrame frame = new JFrame("GraphicalCalculatorShow");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7,1));
        
        JTextField t1 = new JTextField();
        panel.add(t1);
        frame.add(panel);


        JButton b1 = new JButton("Clear");
        class Actionclear implements ActionListener{
            public void actionPerformed(ActionEvent e){
                t1.setText("");  
                status = 0; 
                storedText = "0"; 
            }
        }
        b1.addActionListener(new Actionclear());
        b1.setBackground(Color.pink);
        panel.add(b1);


        JButton b2 = new JButton("Add (+)");
        class Actionadd implements ActionListener{
            public void actionPerformed(ActionEvent e){
                storedText = t1.getText();
                storedValue = storedValue + Float.parseFloat(storedText);
                t1.setText("");
                status = 1;  
            }
        }
        b2.addActionListener(new Actionadd());       
        panel.add(b2);


        JButton b3 = new JButton("Subtract(-)");
        class Actionsubtract implements ActionListener{
            public void actionPerformed(ActionEvent e){
                storedText = t1.getText();

                storedValue = storedValue - Float.parseFloat(storedText);
                t1.setText("");
                status = 2;  
            }
        }
        b3.addActionListener(new Actionsubtract());
        panel.add(b3);


        JButton b4 = new JButton("Multiply(*)");
        class Actionmultiply implements ActionListener{
            public void actionPerformed(ActionEvent e){
                storedText = t1.getText();
                storedValue = storedValue * Float.parseFloat(storedText);
                t1.setText("");
                status = 3;

            }
        }
        b4.addActionListener(new Actionmultiply());
        panel.add(b4);


        JButton b5 = new JButton("Divide(-)");
        class Actiondivide implements ActionListener{
            public void actionPerformed(ActionEvent e){
                storedText = t1.getText();
                storedValue = storedValue / Float.parseFloat(storedText);
                t1.setText("");
                status = 4;
            }
        }
        b5.addActionListener(new Actiondivide());
        panel.add(b5);


        JButton b6 = new JButton("Result(=)");
        class Actionresult implements ActionListener{
            public void actionPerformed(ActionEvent e){
                if (status == 0) {
                    return;
                }

            try{
                float firstValue = Float.parseFloat(storedText);
                float secondValue = Float.parseFloat(t1.getText());
                float resultValue = 0F;
                switch(status){
                    case 1:
                    resultValue = firstValue + secondValue;
                    break;

                    case 2:
                    resultValue = firstValue - secondValue;
                    break;

                    case 3:
                    resultValue = firstValue * secondValue;
                    break;

                    case 4:
                    resultValue = firstValue / secondValue;
                    break;
                    
                }
                String value = String.valueOf(resultValue);
                t1.setText(value);
                status = 0;
                storedValue = resultValue;
            }

            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(frame,"Invalid input for calculation. Please enter valid numbers.");
                status = 0;
                storedText = "null";
                t1.setText("");
            }
            }
        }
        b6.addActionListener(new Actionresult());
        b6.setBackground(Color.pink);
        panel.add(b6);

        frame.pack();
        frame.setSize(300,300);
        frame.setVisible(true);
      
    }

    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                CreateGraphicalCalculator();
            }
        });
    }

}