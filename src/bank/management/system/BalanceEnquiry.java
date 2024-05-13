
package bank.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;


public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton back;
    String pinnumber;
    
    BalanceEnquiry(String pinnumber){
        
        this.pinnumber = pinnumber;
         setLayout(null);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Atm2.jpg"));
        Image i1 = img.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(0,0,900,900);
        add(image);
        
        back = new JButton("Back");
        back.setBounds(520,490,100,20);
        back.addActionListener(this);
        image.add(back);
        
        Conn co = new Conn();
         int balan = 0;
        try{
            ResultSet rs = co.s.executeQuery("select * from bank where pin = '" + pinnumber + "' ");
           
            while(rs.next()){
                if(rs.getString("type").equals("Deposite")){
                    balan += Integer.parseInt(rs.getString("amount"));
                }else{
                    balan -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        JLabel text = new JLabel("Your Current Account Balance is : RS " + balan);
        text.setForeground(Color.WHITE);
        text.setBounds(330,330,700,35);
        image.add(text);
        
        
        setLocation(300,0);
        setSize(900,900);
        setUndecorated(true);
        setVisible(true);
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
    
    public static void main(String [] args){
        new BalanceEnquiry("");
    }

   
}
