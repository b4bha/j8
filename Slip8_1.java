import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Slip8_1 implements ItemListener
{
	JComboBox combo,combo1;
  	JTextField txt,txt1;
  	JLabel style,ft,sz;
  	JCheckBox c1,c2;

	public Slip8_1()
	{
    	String font[] = {"Arial","Times New Roman","Berlin Sans FB","Microsoft Sans Serif ","Stencil"};
     	String size[]={"10","12","15","18","20","25","30","36","40","46","55","64","72","86"};
     	JFrame f = new JFrame("Font Type & Size Selection Window");
   		Container cp=f.getContentPane();	
		f.setLayout(null);

      	combo = new JComboBox(font);
	  	combo1 = new JComboBox(size);
      	txt = new JTextField(10);
 	  	ft = new JLabel("Font");
	  	sz = new JLabel("Size");
	  	style = new JLabel("Style");
		c1= new JCheckBox("Bold");
		c2= new JCheckBox("Italic");
		ft.setBounds(10,20,25,30);
		combo.setBounds(10,60,200,30);
		sz.setBounds(10,100,25,30);
		combo1.setBounds(10,140,100,30);
		txt.setBounds(10,180,300,30);
		
		style.setBounds(235,20,50,30);
		c1.setBounds(235,60,80,30);
		c2.setBounds(235,100,80,30);
	    
	    f.add(ft);
    	f.add(combo);
    	f.add(sz);
   		f.add(combo1);
		combo1.addItemListener(this);
		f.add(txt);
		combo.addItemListener(this);
		c1.addItemListener(this);
		c2.addItemListener(this);
		f.add(style);
		f.add(c1);
		f.add(c2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400,400);
		f.setLocation(200,200);
		f.setVisible(true);
	}

	public void itemStateChanged(ItemEvent ie)
	{
		if(c1.isSelected() && !c2.isSelected() )
			txt.setFont(new Font((String)combo.getSelectedItem(),Font.BOLD,Integer.parseInt((String)combo1.getSelectedItem())));
    	if(!c1.isSelected()  && c2.isSelected())
			txt.setFont(new Font((String)combo.getSelectedItem(),Font.ITALIC,Integer.parseInt((String)combo1.getSelectedItem())));
    	if(c1.isSelected()  && c2.isSelected())
			txt.setFont(new Font((String)combo.getSelectedItem(),Font.ITALIC|Font.BOLD,Integer.parseInt((String)combo1.getSelectedItem())));
    	if(!c1.isSelected() )
    		if(!c2.isSelected())
				txt.setFont(new Font((String)combo.getSelectedItem(),Font.PLAIN,Integer.parseInt((String)combo1.getSelectedItem())));
	}

	public static void main(String[] args) 
	{
    	new Slip8_1();
  	}
}