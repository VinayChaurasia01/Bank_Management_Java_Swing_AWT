
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Withdrawl extends JFrame implements ActionListener {
 
    JTextField tf;
    JButton withdrawl,back;
    
    
    String pinnumber;
     Withdrawl(String pinnumber){
         
         this.pinnumber = pinnumber;
         
         setLayout(null);
         
         ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Atm2.jpg"));
         Image i1 = img.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
         ImageIcon i2 = new ImageIcon(i1);
         JLabel image = new JLabel(i2);
         image.setBounds(0,0,900,900);
         add(image);
         
         
         JLabel text = new JLabel("Enter your amounnt you want to Withdraw ");
         text.setFont(new Font("Releway" , Font.BOLD , 14));
         text.setForeground(Color.WHITE);
         text.setBounds(290,340,350,20);
         image.add(text);
         
         
         tf = new JTextField();
         tf.setFont(new Font("Releway" , Font.BOLD , 20));
         tf.setBounds(290,370,310,20);
         image.add(tf);
         
         withdrawl = new JButton("Withdraw");
         withdrawl.setBounds(520,460,100,20);
         withdrawl.setFont(new Font("Releway" , Font.BOLD , 14));
         withdrawl.addActionListener(this);
         image.add(withdrawl);
         
         back = new JButton("Back");
         back.setBounds(520,490,100,20);
         back.setFont(new Font("Releway" , Font.BOLD , 14));
         back.addActionListener(this);
         image.add(back);
         
         setSize(900,900);
         setLocation(300,0);
         setVisible(true);
     }
    
      @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == withdrawl){
            String amo = tf.getText();
            Date date = new Date();
            
            if(amo == null){
                JOptionPane.showMessageDialog(null, "Please Enter the Amount");
            }else {
                try{
                Conn co = new Conn();
                String query = "insert into bank values ('" + pinnumber + "' , '" + date + "' , 'Withdraw' , '" + amo + "')";
                co.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs" + amo +"Successfully Withdraw");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                
                }catch(Exception ex){
                    System.out.println(ex);
                }
            }
        }else if(e.getSource() == back){
            setVisible(true);
            new Transaction(pinnumber).setVisible(true);
        }
    }
     
     public static void main (String [] args){
         
         new Withdrawl("");
     }

   
}
