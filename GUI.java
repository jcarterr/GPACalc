package gpaCalc;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame{
	
	private JPanel contentPane;
	private JLabel id;
	private JTextField idText;
	private JLabel name;
	private JTextField nameTxt;
	private JLabel major;
	private JTextField majorTxt;
	private JLabel choose;
	private JComboBox optionBox;
	private JButton processReq;
	private String[] grade = {"A", "B", "C", "D", "F"}; 
	private Double[] hours = {3.0, 6.0};
	
	public static void main(String[] args){
		GUI frame = new GUI("GPA");
		frame.setVisible(true);
	}
	
	//GUI Frame constructor
	public GUI(String title){
		super(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 450, 300);
		
		//Create content pane
		contentPane = new JPanel();
		contentPane.setLayout(new GridBagLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridheight = 5;
		gbc.gridwidth= 2;
		
		//Add ID label
		id = new JLabel("ID: ");
		GridBagConstraints IDlabel = new GridBagConstraints();
		IDlabel.fill = GridBagConstraints.HORIZONTAL;
		IDlabel.insets = new Insets(5, 5, 5, 5);
		IDlabel.gridx = 0;
		IDlabel.gridy = 0;
		contentPane.add(id, IDlabel);
		
		//Add ID text field
		idText = new JTextField();
		GridBagConstraints IDTextGbc = new GridBagConstraints();
		IDTextGbc.fill = GridBagConstraints.HORIZONTAL;
		IDTextGbc.insets = new Insets(5,5,5,5);
		IDTextGbc.gridx = 1;
		IDTextGbc.gridy = 0;
		IDTextGbc.weighty = 1.0;
		IDTextGbc.weightx = 1.0;
		idText.setEditable(true);
		contentPane.add(idText, IDTextGbc);
		
		//Add Name label
		name = new JLabel("Name: ");
		GridBagConstraints Namelabel = new GridBagConstraints();
		Namelabel.fill = GridBagConstraints.HORIZONTAL;
		Namelabel.insets = new Insets(5, 5, 5, 5);
		Namelabel.gridx = 0;
		Namelabel.gridy = 1;
		contentPane.add(name, Namelabel);
		
		//Add Name text field
		nameTxt = new JTextField();
		GridBagConstraints NameTextGbc = new GridBagConstraints();
		NameTextGbc.fill = GridBagConstraints.HORIZONTAL;
		NameTextGbc.insets = new Insets(5,5,5,5);
		NameTextGbc.gridx = 1;
		NameTextGbc.gridy = 1;
		NameTextGbc.weighty = 1.0;
		NameTextGbc.weightx = 1.0;
		nameTxt.setEditable(true);
		contentPane.add(nameTxt, NameTextGbc);
		
		//Add Major label
		major = new JLabel("Major: ");
		GridBagConstraints Majorlabel = new GridBagConstraints();
		Majorlabel.fill = GridBagConstraints.HORIZONTAL;
		Majorlabel.insets = new Insets(5, 5, 5, 5);
		Majorlabel.gridx = 0;
		Majorlabel.gridy = 2;
		contentPane.add(major, Majorlabel);
		
		//Add Name text field
		majorTxt = new JTextField();
		GridBagConstraints MajorTextGbc = new GridBagConstraints();
		MajorTextGbc.fill = GridBagConstraints.HORIZONTAL;
		MajorTextGbc.insets = new Insets(5,5,5,5);
		MajorTextGbc.gridx = 1;
		MajorTextGbc.gridy = 2;
		MajorTextGbc.weighty = 1.0;
		MajorTextGbc.weightx = 1.0;
		majorTxt.setEditable(true);
		contentPane.add(majorTxt, MajorTextGbc);
		
		//Add Major label
		choose = new JLabel("Choose Selection: ");
		GridBagConstraints Chooselabel = new GridBagConstraints();
		Chooselabel.fill = GridBagConstraints.HORIZONTAL;
		Chooselabel.insets = new Insets(5, 5, 5, 5);
		Chooselabel.gridx = 0;
		Chooselabel.gridy = 3;
		contentPane.add(choose, Chooselabel);
		
		//Add Combo box
		String[] options = { "Insert", "Delete", "Find", "Update" };
		optionBox = new JComboBox(options);
		optionBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				 JComboBox optionBox = (JComboBox)ae.getSource();
			     String options = (String)optionBox.getSelectedItem();
			}
		});
		GridBagConstraints optionGBC = new GridBagConstraints();
		optionGBC.fill = GridBagConstraints.HORIZONTAL;
		optionGBC.insets = new Insets(5,5,5,5);
		optionGBC.gridx = 1;
		optionGBC.gridy = 3;
		optionGBC.weighty = 1.0;
		optionGBC.weightx = 1.0;
		contentPane.add(optionBox, optionGBC);
		
		//Add Process Request button
		processReq = new JButton("Process Request");
		GridBagConstraints prGBC = new GridBagConstraints();
		prGBC.fill = GridBagConstraints.HORIZONTAL;
		prGBC.insets = new Insets(5,5,5,5);
		prGBC.gridx = 0;
		prGBC.gridy = 4;
		prGBC.weighty = 1.0;
		prGBC.weightx = 1.0;
		contentPane.add(processReq, prGBC);
		processReq.addActionListener(new ActionListener(){
			//Action listener for the button
			public void actionPerformed(ActionEvent actE){
				int index = optionBox.getSelectedIndex();
				switch(index){
				
					//Input
					case 0:
						if (idText.getText().isEmpty()){
							JOptionPane.showMessageDialog(null, "Please add an id.");
						}else if(nameTxt.getText().isEmpty()){
							JOptionPane.showMessageDialog(null, "Please add a name.");
						}else if(majorTxt.getText().isEmpty()){
							JOptionPane.showMessageDialog(null,  "Please enter a major.");
						}else if(Student.studentData.containsKey(idText.getText())){
							JOptionPane.showMessageDialog(null, "ID already exists.\nBummer,dude.");
						}else{
							Student student1 = new Student(idText.getText(), nameTxt.getText(), majorTxt.getText());
							Student.studentData.put(idText.getText(), student1);
							JOptionPane.showMessageDialog(null, "Success! Student data inserted.");
							idText.setText(""); nameTxt.setText(""); majorTxt.setText("");
						}
						break;
					
					//Delete
					case 1:
						if(idText.getText().isEmpty()){
							JOptionPane.showMessageDialog(null, "Please enter an ID.");
						}else if(!Student.studentData.containsKey(idText.getText())){
							JOptionPane.showMessageDialog(null, "ID does not exist.");
						}else{
							Student student4 = Student.studentData.get(idText.getText());
							int confirm = JOptionPane.showConfirmDialog(null, 
									"Do you want to delete the record for " +
									student4.getName() + "?", "Confirm deletion", JOptionPane.YES_NO_OPTION);
							if (confirm == JOptionPane.YES_OPTION){
								Student.studentData.remove(idText.getText());
								JOptionPane.showMessageDialog(null, "Student deleted.");
								idText.setText(""); nameTxt.setText(""); majorTxt.setText("");
							}else{
							}
						}
						break;
						
					//Find
					case 2:
						if(idText.getText().isEmpty()){
							JOptionPane.showMessageDialog(null, "Please enter an ID.");
						}else if(!Student.studentData.containsKey(idText.getText())){
							JOptionPane.showMessageDialog(null, "ID does not exist.");
						}else{
						String studentID2 = idText.getText();
						Student student2 = Student.studentData.get(studentID2);
						JOptionPane.showMessageDialog(null, "Success!\n" + student2.toString());
						idText.setText(""); nameTxt.setText(""); majorTxt.setText("");
						}
						break;
						
					//Update
					case 3:
						if(idText.getText().isEmpty()){
							JOptionPane.showMessageDialog(null, "Please enter an ID.");
						}else if(!Student.studentData.containsKey(idText.getText())){
							JOptionPane.showMessageDialog(null, "ID does not exist.");
						}else{
						String studentID3 = idText.getText();
						Student student3 = Student.studentData.get(studentID3);
						
						//Option pane for grades
						String gradeSelection = (String)JOptionPane.showInputDialog(null,
								"Please choose a grade for the course: ",
								"Grade",
								JOptionPane.PLAIN_MESSAGE,
								null,
								grade,
								"A");
						
						//Translate String to numbers
						switch(gradeSelection){
							case "A":
								gradeSelection = "4.0";
								break;
							case "B":
								gradeSelection = "3.0";
								break;
							case "C":
								gradeSelection = "2.0";
								break;
							case "D":
								gradeSelection = "1.0";
								break;
							case "F":
								gradeSelection = "0.0";
								break;
						}
						
						//Option pane for hours 
						double creditSelection = (double)JOptionPane.showInputDialog(null,
								"Please choose the credit hours for the course: ",
								"Credit Hours",
								JOptionPane.PLAIN_MESSAGE,
								null,
								hours,
								"3");
						Student.courseCompleted(Double.parseDouble(gradeSelection), creditSelection, student3);
						JOptionPane.showMessageDialog(null,  "Success! \nStudent " + student3.getName() + 
								"'s entry has been updated.");
						idText.setText(""); nameTxt.setText(""); majorTxt.setText("");
						}
						break;
				}
			};
		});
	}
	
	
}
