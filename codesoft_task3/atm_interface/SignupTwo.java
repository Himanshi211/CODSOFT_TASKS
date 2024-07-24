package atm_interface;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class SignupTwo extends JFrame implements ActionListener{
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion ,category, occupation, education, income;
    String formno;
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");


        JLabel additionalDetails =new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Railway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel religionLabel =new JLabel("Religion: ");
        religionLabel.setFont(new Font("Railway", Font.BOLD, 20));
        religionLabel.setBounds(100, 140, 100, 30);
        add(religionLabel);

        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        religion =new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel incomeLabel =new JLabel("Income: ");
        incomeLabel.setFont(new Font("Railway", Font.BOLD, 20));
        incomeLabel.setBounds(100, 190, 200, 30);
        add(incomeLabel);

        String incomecategory[]={"Null","< 1,50,000","< 2,50,0000","< 5,00,000","Upto 10,00,000"};
        income =new JComboBox(incomecategory);
        income.setBounds(300, 190, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel educationLabel =new JLabel("Educational");
        educationLabel.setFont(new Font("Railway", Font.BOLD, 20));
        educationLabel.setBounds(100, 240, 200, 30);
        add(educationLabel);
        JLabel qualificationLabel =new JLabel("Qualification: ");
        qualificationLabel.setFont(new Font("Railway", Font.BOLD, 20));
        qualificationLabel.setBounds(100, 265, 200, 30);
        add(qualificationLabel);

        String educationValues[]={"Non Graduation","Graduate","Post Graduation","Doctrate","Others"};
        education =new JComboBox(educationValues);
        education.setBounds(300, 260, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel occupationLabel =new JLabel("Occupation: ");
        occupationLabel.setFont(new Font("Railway", Font.BOLD, 20));
        occupationLabel.setBounds(100, 340, 200, 30);
        add(occupationLabel);

        String occupationValues[]={"Salaried","Self Employed","Bussiness","Student","Retired","Others"};
        occupation =new JComboBox(occupationValues);
        occupation.setBounds(300, 340, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        

        JLabel panLabel =new JLabel("PAN Number: ");
        panLabel.setFont(new Font("Railway", Font.BOLD, 20));
        panLabel.setBounds(100, 390, 200, 30);
        add(panLabel);

        pan=new JTextField();
        pan.setFont(new Font("Railway", Font.BOLD, 14));
        pan.setBounds(300, 390, 400, 30);
        add(pan);


        JLabel aadharLabel =new JLabel("Aadhar Number: ");
        aadharLabel.setFont(new Font("Railway", Font.BOLD, 20));
        aadharLabel.setBounds(100, 440, 200, 30);
        add(aadharLabel);

        aadhar=new JTextField();
        aadhar.setFont(new Font("Railway", Font.BOLD, 14));
        aadhar.setBounds(300, 440, 400, 30);
        add(aadhar);

        JLabel citizenLabel =new JLabel("Senior Citizen: ");
        citizenLabel.setFont(new Font("Railway", Font.BOLD, 20));
        citizenLabel.setBounds(100, 490, 200, 30);
        add(citizenLabel);

        syes =new JRadioButton("Yes");
        syes.setBounds(300, 490, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        sno =new JRadioButton("No");
        sno.setBounds(450, 490, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        ButtonGroup maritalGroup=new ButtonGroup();
        maritalGroup.add(syes);
        maritalGroup.add(sno);

        

        JLabel accountLabel =new JLabel("Existing Account: ");
        accountLabel.setFont(new Font("Railway", Font.BOLD, 20));
        accountLabel.setBounds(100, 540, 200, 30);
        add(accountLabel);

        eyes =new JRadioButton("Yes");
        eyes.setBounds(300, 540, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        eno =new JRadioButton("No");
        eno.setBounds(450, 540, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
        ButtonGroup accountGroup=new ButtonGroup();
        accountGroup.add(eyes);
        accountGroup.add(eno);



        next =new JButton("Next");
        next.setBackground(Color.DARK_GRAY);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String sreligion = (String)religion.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation =(String) education.getSelectedItem();
        String soccupation =(String) occupation.getSelectedItem();
        String seniorcitizen =null;
        if(syes.isSelected()){
            seniorcitizen="Yes";
        }else if(sno.isSelected()){
            seniorcitizen="No";
        }
        
        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount="Yes";
        }else if(eno.isSelected()){
            existingaccount="No";
        }

        String span=pan.getText();
        String saadhar=aadhar.getText();
        

        try{
            Conn c=new Conn();
            String query ="insert into signuptwo values ('"+formno+"', '"+sreligion+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorcitizen+"', '"+existingaccount+"')";
            c.s.executeUpdate(query);
            //create SignUp3 object
            setVisible(false);
            new SignupThree(formno).setVisible(true);;
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new SignupTwo("");
    }
}
