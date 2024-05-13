
package bank.management.system;


import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener {
    
    JButton RS100 , RS200 , RS500 , RS1000, RS5000 , RS10000 , back;
    String pinnumber;
    
    FastCash(String pinnumber){
         
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Atm2.jpg"));
        Image i1 = img.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Please select your Amount ");
        text.setBounds(335,330,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Releway" , Font.BOLD , 16));
        image.add(text);
        
        RS100 = new JButton("RS 100");
        RS100.setBounds(280,400,100,20);
        RS100.addActionListener(this);
        image.add(RS100);
        
        RS200 = new JButton("RS 200");
        RS200.setBounds(520,400,100,20);
        RS200.addActionListener(this);
        image.add(RS200);
        
        RS500 = new JButton("RS 500");
        RS500.setBounds(280,430,100,20);
        RS500.addActionListener(this);
        image.add(RS500);
        
        RS1000 = new JButton("RS 1000");
        RS1000.setBounds(520,430,100,20);
        RS1000.addActionListener(this);
        image.add(RS1000);
        
        RS5000 = new JButton("RS 5000");
        RS5000.setBounds(280,460,100,20);
        RS5000.addActionListener(this);
        image.add(RS5000);
        
        RS10000 = new JButton("RS 10000");
        RS10000.setBounds(520,460,100,20);
        RS10000.addActionListener(this);
        image.add(RS10000);
        
        back = new JButton("Back");
        back.setBounds(520,490,100,20);
        back.addActionListener(this);
        image.add(back);
        
        setLocation(300,0);
        setSize(900,900);
        setUndecorated(true);
        setVisible(true);

        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else {
            String amount = ((JButton) e.getSource()).getText().substring(3);
            Conn co = new Conn();
            
            try{
                ResultSet rs = co.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
                int balance = 0;
                
                while(rs.next()){
                    if(rs.getString("type").equals("Deposite")){
                        balance += Integer.parseInt(rs.getString("amount"));
                        
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(e.getSource() != back && balance < Integer.parseInt(amount)){
                    
                    JOptionPane.showMessageDialog(null, "Insufficiant Balance ");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values ('" + pinnumber + "' , '" + date + "' , 'Withdraw' , '" +  amount + "')";
                co.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null , "RS " + amount + " is successfully debited " );
                
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
    }
    
    public static void main(String [] args){
        
       new FastCash("");
    }

}
