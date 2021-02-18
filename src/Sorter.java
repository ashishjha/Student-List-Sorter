import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Sorter {

	private JFrame frmListSorter;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JRadioButton rad_roll;
	private JRadioButton rad_name;
	private JRadioButton rad_marks;
	int roll;
	String name;
	double marks;
	
	ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("sort.png"));
	
	ArrayList<Sorter> al =new ArrayList<Sorter>();
	private JTextField textField_4;

	
	public Sorter(int roll, String name, double marks) 
	{
		// TODO Auto-generated constructor stub
		this.roll = roll;
		this.name = name;
		this.marks = marks;
	}
	
	@Override
	public String toString() 
	{
	return "roll=" + roll + ", name=" + name + ", marks=" + marks +"\n";
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		 try {
	            //here you can put the selected theme class name in JTattoo
	            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
	 
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(Sorter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(Sorter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(Sorter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(Sorter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
		
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Sorter window = new Sorter();
					window.frmListSorter.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Sorter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListSorter = new JFrame();
		frmListSorter.setTitle("List Sorter");
		frmListSorter.setBounds(100, 100, 610, 547);
		frmListSorter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListSorter.getContentPane().setLayout(null);
		frmListSorter.setIconImage(logo.getImage());
		
		JLabel lblNewLabel = new JLabel("Roll Number");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 89, 14);
		frmListSorter.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(194, 11, 46, 14);
		frmListSorter.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Marks");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(436, 11, 46, 14);
		frmListSorter.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 36, 133, 20);
		frmListSorter.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(194, 36, 185, 20);
		frmListSorter.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(436, 36, 133, 20);
		frmListSorter.getContentPane().add(textField_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(8, 277, 574, 165);
		frmListSorter.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		
		JButton btn_add = new JButton("Add to List");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if ( (textField_1.getText() == null || textField_1.getText().trim().isEmpty()) && (textField_2.getText() == null || textField_2.getText().trim().isEmpty()) ) 
				{
					if( (textField_3.getText() == null || textField_3.getText().trim().isEmpty()) )
					{
						textArea.setText("\nRoll Number , Name And Marks Are Empty\n");
					}
					else
					{
						textArea.setText("\nRoll Number And Name Are Empty\n");
					}
				}
				else if ( (textField_2.getText() == null || textField_2.getText().trim().isEmpty()) && (textField_3.getText() == null || textField_3.getText().trim().isEmpty()) ) 
				{
					if( (textField_1.getText() == null || textField_1.getText().trim().isEmpty()) )
					{
						textArea.setText("\nRoll Number , Name And Marks Are Empty\n");
					}
					else
					{
						textArea.setText("\nName And Marks Are Empty\n");
					}
				}
				else if ( (textField_1.getText() == null || textField_1.getText().trim().isEmpty()) && (textField_3.getText() == null || textField_3.getText().trim().isEmpty()) ) 
				{
					if( (textField_2.getText() == null || textField_2.getText().trim().isEmpty()) )
					{
						textArea.setText("\nRoll Number , Name And Marks Are Empty\n");
					}
					else
					{
						textArea.setText("\nRoll Number And Marks Are Empty\n");
					}
				}
				else if (textField_1.getText() == null || textField_1.getText().trim().isEmpty()) 
				{
					textArea.setText("\nRoll Number Is Empty\n");
				}
				else if (textField_2.getText() == null || textField_2.getText().trim().isEmpty()) 
				{
					textArea.setText("\nName Is Empty\n");
				}
				else if (textField_3.getText() == null || textField_3.getText().trim().isEmpty()) 
				{
					textArea.setText("\nMarks Is Empty\n");
				}
				else
				{
				Sorter o1 = new Sorter(Integer.parseInt(textField_1.getText()),textField_2.getText(),Double.parseDouble(textField_3.getText()));
				
				al.add(o1);
				
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				}
				
			}
		});
		btn_add.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_add.setBounds(10, 90, 133, 23);
		frmListSorter.getContentPane().add(btn_add);
		
		rad_roll = new JRadioButton("Roll Number");
		rad_roll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rad_roll.isSelected())
				{
					rad_name.setSelected(false);
					rad_marks.setSelected(false);
				}
			}
		});
		rad_roll.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rad_roll.setBounds(6, 185, 109, 23);
		frmListSorter.getContentPane().add(rad_roll);
		
		rad_name = new JRadioButton("Name");
		rad_name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rad_name.isSelected())
				{
					rad_roll.setSelected(false);
					rad_marks.setSelected(false);
				}
			}
		});
		rad_name.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rad_name.setBounds(239, 185, 109, 23);
		frmListSorter.getContentPane().add(rad_name);
		
		rad_marks = new JRadioButton("Marks");
		rad_marks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rad_marks.isSelected())
				{
					rad_name.setSelected(false);
					rad_roll.setSelected(false);
				}
			}
		});
		rad_marks.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rad_marks.setBounds(436, 185, 109, 23);
		frmListSorter.getContentPane().add(rad_marks);
		
		JLabel lblNewLabel_3 = new JLabel("Sort on the basis of :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 164, 164, 14);
		frmListSorter.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Sort");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(rad_name.isSelected())
				{
					Collections.sort(al,new NameComparator());
					if(al.isEmpty())
					{
						textArea.append("\nList Is Empty\n");
					}
					else
					{
					textArea.append("\nSorted Lisrt According to Name\n");
					}
				}
				else if(rad_roll.isSelected())
				{
					Collections.sort(al,new RollComparator());
					if(al.isEmpty())
					{
						textArea.append("\nList Is Empty\n");
					}
					else
					{
					textArea.append("\nSorted Lisrt According to Roll Number\n");
					}
				}
				else if(rad_marks.isSelected())
				{
					Collections.sort(al,new MarksComparator());
					if(al.isEmpty())
					{
						textArea.append("\nList Is Empty\n");
					}
					else
					{
					textArea.append("\nSorted Lisrt According to Marks\n");
					}
				}
				else
				{
					if(al.isEmpty())
					{
						textArea.append("\nList Is Empty\n");
					}
					else
					{
					textArea.append("\nPlease Select A Category , The Unsoetrd List Is As Follows\n");
					}
				}
				
				Iterator<Sorter> itr = al.iterator();
				while (itr.hasNext()) 
				{ 
					Sorter st = (Sorter)itr.next();
					String str = st.toString();
					 textArea.append(str);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(239, 227, 100, 23);
		frmListSorter.getContentPane().add(btnNewButton);
		
		JButton btn_save = new JButton("Save");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				 JFileChooser fileChooser = new JFileChooser();
				    int retval = fileChooser.showSaveDialog(btn_save);
				    if (retval == JFileChooser.APPROVE_OPTION) {
				      File file = fileChooser.getSelectedFile();
				      if (file == null) {
				        return;
				      }
				      if (!file.getName().toLowerCase().endsWith(".txt")) {
				        file = new File(file.getParentFile(), file.getName() + ".dox");
				      }
				      try {
				        textArea.write(new OutputStreamWriter(new FileOutputStream(file),
				            "utf-8"));
				        Desktop.getDesktop().open(file);
				      } catch (Exception e1) {
				        e1.printStackTrace();
				      }
				    }
			}
		});
		btn_save.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_save.setBounds(259, 463, 89, 23);
		frmListSorter.getContentPane().add(btn_save);
		
		JButton btn_removelast = new JButton("Remove Last Element");
		btn_removelast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int index = al.size() - 1;
				al.remove(index);
			}
		});
		btn_removelast.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_removelast.setBounds(208, 90, 157, 23);
		frmListSorter.getContentPane().add(btn_removelast);
		
		JButton btn_display = new JButton("Display List");
		btn_display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				textArea.append("\nThe List Is As Follows :\n");
				Iterator<Sorter> itr = al.iterator();
				while (itr.hasNext()) 
				{ 
					Sorter st = (Sorter)itr.next();
					String str = st.toString();
					 textArea.append(str);
				}
			}
		});
		btn_display.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_display.setBounds(239, 135, 100, 23);
		frmListSorter.getContentPane().add(btn_display);
		
		JLabel lblNewLabel_4 = new JLabel("Remove At:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(407, 90, 71, 23);
		frmListSorter.getContentPane().add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(475, 91, 25, 22);
		frmListSorter.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btn_remove = new JButton("Remove");
		btn_remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int index = Integer.parseInt(textField_4.getText());
				int rIndex = index - 1;
				al.remove(rIndex);
			}
		});
		btn_remove.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_remove.setBounds(502, 91, 80, 23);
		frmListSorter.getContentPane().add(btn_remove);
		
		
	}
}

class NameComparator implements Comparator<Sorter>
{  
	public int compare(Sorter s1,Sorter s2)
	{  
		return s1.name.compareTo(s2.name);  
	}  
}  

class RollComparator implements Comparator<Sorter>
{  
	public int compare(Sorter s1,Sorter s2)
	{  
			if(s1.roll==s2.roll) 
			{
				return 0;  
			}
			else if(s1.roll>s2.roll)  
			{
				return 1;  
			}
			else  
			{
				return -1;  
			}
	}  
}  

class MarksComparator implements Comparator<Sorter>
{  
	public int compare(Sorter s1,Sorter s2)
	{  
		if((s1.marks-s2.marks)==0.00000)
		{
			return 0;
		}
		else if((s1.marks-s2.marks)<0.00001)
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}  
}  
