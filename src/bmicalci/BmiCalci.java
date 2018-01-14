
package bmicalci;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author jaybhay-PC
 */
public class BmiCalci extends JFrame {

Container c;
	JLabel lblWeight, lblHeight, lblResult;
	JTextField txtWeight, txtFeet, txtInch;
	JButton btnCalculate;
	
	JPanel p1, p2, p3, p4;

	BmiCalci()
	{
		c=getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

		p1=new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblWeight=new JLabel("Enter Weight in kgs");
		txtWeight=new JTextField(5);	
		p1.add(lblWeight);
		p1.add(txtWeight);
		c.add(p1);
		
		p2=new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblHeight=new JLabel("Enter Height in feet and inches");
		txtFeet=new JTextField(5);	
		txtInch=new JTextField(5);
		p2.add(lblHeight);
		p2.add(txtFeet);
		p2.add(txtInch);
		c.add(p2);

		p3=new JPanel();
		btnCalculate=new JButton("Calculate");
		
		p3.add(btnCalculate);
		
		c.add(p3);
	
		p4=new JPanel();
		lblResult=new JLabel("");
		p4.add(lblResult);
		c.add(p4);


		btnCalculate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				double feet, weight, inch;
				try{	
					weight=Double.parseDouble(txtWeight.getText());
					feet=Double.parseDouble(txtFeet.getText());
					inch=Double.parseDouble(txtInch.getText());
					while(feet>0) { inch+=12;	feet--; }
					double height=inch*0.0254;
					double bmi=weight/(height*height);
					String msg="";
					if(bmi<18)				msg="Underweight";					
					else if(bmi>=18 && bmi<=25)		msg="Normal";
					else msg="Overweight";
					lblResult.setText("Your BMI is "+bmi+" "+msg);
				
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(new JDialog(),"Invalid data entered");
				}
					
			}	
		});

	}

	public static void main(String args[])
	{
		BmiCalci b=new BmiCalci();
		b.setSize(400, 400);
		b.setTitle("BMI Calci");
		b.setLocationRelativeTo(null);
		b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b.setVisible(true);
	}
    
}
