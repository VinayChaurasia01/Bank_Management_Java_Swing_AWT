
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;                    
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SignupTwo extends JFrame implements ActionListener{
    
   // long random;
    JComboBox religi , categ , inc , educa ,occup ;
    JRadioButton yes,no,eyes,eno;
    JTextField panno , Adhaar;
    String formno;
    JButton next;
    
    SignupTwo(String formno){
        
        this.formno = formno;
        
        
        setTitle("New Account Application Form - Page:2 ");
        setLayout(null);
        
        
        JLabel additionalDetails = new JLabel("Page:2 Additional details");
        additionalDetails.setFont(new Font("Raleway" , Font.BOLD , 22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel religion = new JLabel("Religion :");
        religion.setFont(new Font("Raleway" , Font.BOLD , 22));
        religion.setBounds(100,140,200,30);
        add(religion);
        
        String relig[] = {"Hindu" , "Sikkh" , "Esai" ,"Muslim" , "jain" };
        religi = new  JComboBox(relig);
        religi.setBounds(300,140,400,30);
        religi.setBackground(Color.WHITE);
        add(religi);
        
        
        JLabel cat = new JLabel("Category :");
        cat.setFont(new Font("Raleway" , Font.BOLD , 22));
        cat.setBounds(100,190,200,30);
        add(cat);
        
        String cate[] = {"OBC" ,"GENERAL" , "ST" ,"SC"};
        categ = new JComboBox(cate);
        categ.setBounds(300 , 190 , 400 , 30);
        categ.setBackground(Color.WHITE);
        add(categ);
        
         
        JLabel inco = new JLabel("Income :");
        inco.setFont(new Font("Raleway" , Font.BOLD , 22));
        inco.setBounds(100,240,200,30);
        add(inco);
        
        String in[] = {"NULL" ,"< 1,50,000" , "< 2,50,000" ,"<5,00,000" ,"upto 10,00,000"};
        inc = new JComboBox(in);
        inc.setBounds(300 , 240 , 400 , 30);
        inc.setBackground(Color.WHITE);
        add(inc);
        
       
       /* JLabel edu = new JLabel("Educational :");
        edu.setFont(new Font("Raleway" , Font.BOLD , 22));
        edu.setBounds(100,290,200,30);
        add(edu);
*/
        
    
         
        JLabel qua = new JLabel("Qualifications :");
        qua.setFont(new Font("Raleway" , Font.BOLD , 22));
        qua.setBounds(100,290,200,30);
        add(qua);
        
        String eduval[] = {"12th pass" ,"Under-Graduate" , "Non-Graduate" ,"Post-Graduate" ,"Other"};
        educa = new JComboBox(eduval);
        educa.setBounds(300 , 290 , 400 , 30);
        educa.setBackground(Color.WHITE);
        add(educa);
        
        JLabel occu = new JLabel("Occupation :");
        occu.setFont(new Font("Raleway" , Font.BOLD , 22));
        occu.setBounds(100,340,200,30);
        add(occu);
        
        String occval[] = {"Salaried" ,"Self-Employee" , "Bussiness" ,"Student" ,"Other"};
        occup = new JComboBox(occval);
        occup.setBounds(300 , 340 , 400 , 30);
        occup.setBackground(Color.WHITE);
        add(occup);
         
        JLabel pan = new JLabel("Pan No. :");
        pan.setFont(new Font("Raleway" , Font.BOLD , 22));
        pan.setBounds(100,390,200,30);
        add(pan);
        
        panno = new JTextField();
        panno.setFont(new Font("Releway" , Font.BOLD , 20));
        panno.setBounds(300 , 390 , 400 , 30);
        add(panno);
        
         
        JLabel AdhNo = new JLabel("Adhaar No. :");
        AdhNo.setFont(new Font("Raleway" , Font.BOLD , 22));
        AdhNo.setBounds(100,440,200,30);
        add(AdhNo);
        
        Adhaar = new JTextField();
        Adhaar.setFont(new Font("Releway" , Font.BOLD , 20));
        Adhaar.setBounds(300 , 440 , 400 , 30);
        add(Adhaar);
        
         
        JLabel SeCi = new JLabel("Senior CItizen :");
        SeCi.setFont(new Font("Raleway" , Font.BOLD , 22));
        SeCi.setBounds(100,490,200,30);
        add(SeCi);
        
        yes = new JRadioButton("YES");
        yes.setBounds(300,490,100,30);
        add(yes);
        
        no = new JRadioButton("NO");
        no.setBounds(450,490,100,30);
        add(no);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(yes);
        bg.add(no); 
        
        JLabel exAcc = new JLabel("Exixtiong Account: ");
        exAcc.setFont(new Font("Raleway" , Font.BOLD , 22));
        exAcc.setBounds(100,540,200,30);
        add(exAcc);
        
        eyes = new JRadioButton("YES");
        eyes.setBounds(300,540,100,30);
        add(eyes);
        
        eno = new JRadioButton("NO");
        eno.setBounds(450,540,100,30);
        add(eno);
        
        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(eyes);
        bg2.add(eno); 
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Releway" , Font.BOLD , 14));
        next.setBounds(650,700,80,30);
        add(next);  
        
        setSize(800,800);
        setLocation(350,10);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        String rel = (String) religi.getSelectedItem();
        String catego = (String) categ.getSelectedItem();
        String income = (String) inc.getSelectedItem();
        String education = (String) educa.getSelectedItem();
        String occupation = (String) occup.getSelectedItem();
        
        String senior = null;
        if(yes.isSelected()){
            senior = "Yes";
        }else if(no.isSelected()){
            senior = "No";
        }
        
        String existingAcc = null;
        if(eyes.isSelected()){
            existingAcc = "Yes";
        }else if(eno.isSelected()){
            existingAcc = "No";
        }
        
        String pancard = panno.getText();
        String Adharcard = Adhaar.getText();
        
        
        try{
           
                Conn c = new Conn();
                String query = "insert into signuptwo values('" + formno + "' , '" + rel + "' , '" +  catego + "' , '" + income + "' , '" + education + "' , '" +occupation + "' , '" + pancard + "' , '" +Adharcard + "' , '" + senior + "' , '" +existingAcc + "')"; 

                c.s.executeUpdate(query);                
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
        }
        catch(Exception ee){
            System.out.println(ee);
        }
    
    }
    
    public static void main(String [] args){
        new SignupTwo("");
    }

}
