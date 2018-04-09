
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import mu.*;
public class ModifyFrame extends JFrame
{
	JPanel jp1,jp2;
	JButton modify,back;
	JLabel l1,l2;
	JTextField t1,t2;
	public ModifyFrame()
	{
		super("Modify Employee");
		setSize(500,150);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		jp1=new JPanel();
		jp1.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));
		
		modify=new JButton("MODIFY");
		back=new JButton("BACK");
		
		l1= new JLabel("ID:");
		l2= new JLabel("NAME:");
		t1= new JTextField(6);
		t2= new JTextField(12);
		jp1.add(l1);
		jp1.add(t1);
		jp1.add(l2);
		jp1.add(t2);
		add(jp1);
		
		jp2=new JPanel();
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));
		jp2.add(modify);
		jp2.add(back);
		add(jp2,BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		setVisible(true);
		
		back.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			HomeFrame a=new HomeFrame();
			dispose();
		}});

		modify.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			String id=t1.getText();
			String name=t2.getText();
			
			if(id.matches("\\d*")){}
			else{Sound.failure();
			JOptionPane.showMessageDialog(new JDialog(),"ID should only contain NUMBERS");
			t1.setText("");
			 t2.setText("");}
			boolean i= isletters(name);
			if(i==false)
	{Sound.failure();
	JOptionPane.showMessageDialog(new JDialog(),"Name Should not contain numbers");
	 t1.setText("");
	 t2.setText("");
	return;
	}

			if(id.length()==0 ||name.length()==0)
				{
				Sound.failure();
				JOptionPane.showMessageDialog(new JDialog(),"All Fields are Manatory");
				return;
				}
			else
				//DatabaseHandler q=new DatabaseHandler();
				DatabaseHandler.update(Integer.parseInt(id),name);
				t1.setText("");t2.setText("");
		}});

	}

public boolean isletters(String name) {
    char[] chars = name.toCharArray();

    for (char c : chars) {
        if(!Character.isLetter(c) && c!=' ') {
            return false;
        }
    }

    return true;
}

public static void main(String args[])
	{
		ModifyFrame h=new ModifyFrame();
	}
}