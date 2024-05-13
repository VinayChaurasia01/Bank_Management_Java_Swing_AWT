
package bank.management.system;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;


public class MiniStatement extends JFrame {
    
    MiniStatement(String pinnumber){
        
        setTitle("Mini Statement");
        setLayout(null);
        
        JLabel mini = new JLabel();
        add(mini);
        
        JLabel bank = new JLabel("Indian bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,200,20);
        add(card);
        
        JLabel balan = new JLabel("Balance");
        balan.setBounds(20,400,300,20);
        add(balan);
        
        
        try{
            Conn co = new Conn();
            ResultSet rs = co.s.executeQuery("select * from login where pin = '" + pinnumber + "'");
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("CardNumber").substring(0,4) + "XXXXXXXXX" +rs.getString("CardNumber").substring(12));
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        
        try{
            Conn con = new Conn();
            int balance = 0;
            ResultSet rs = con.s.executeQuery("select * from bank where pin= '" + pinnumber + "'");
            while(rs.next()){
                mini.setText(mini.getText()+ "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br>" );
                if(rs.getString("type").equals("Deposite")){
                        balance += Integer.parseInt(rs.getString("amount"));
                        
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
            
            }
            balan.setText("Your current balance is RS " + balance);
            
        }catch (Exception ee){
            System.out.println(ee);
        }
        
        mini.setBounds(20,140,400,200);
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
        
    }
    public static void main(String [] args){
        
        new MiniStatement("");
    }
}
