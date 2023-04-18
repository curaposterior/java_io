import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JTable;


public class GUI extends JFrame {
	public static ClassContainer book = new ClassContainer();
	public Class currClass = null;
	private JTextField textFieldBirthDate;
	private JTextField textFieldSurname;
	private JTextField textFieldName;
	private JTextField textFieldStudentStatus;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JTextField textFieldGroupName;
	private JTextField textFieldMaxNumberOfStudents;
	private JList listGroups;
	private JList listStudents;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JButton btnListGroups;
	private JButton btnChangeGrSize;
	private JTextField textFieldEditStudentPoints;
	private JTextField textField;
	private JLabel lblNewLabel_13;
	private JTable table;
	private JFrame fr;
	
	public GUI() {
		getContentPane().setLayout(null);
		
		JButton btnAddStudent = new JButton("Dodaj");
		btnAddStudent.setBounds(29, 617, 89, 23);
		getContentPane().add(btnAddStudent);
		
		textFieldStudentStatus = new JTextField();
		textFieldStudentStatus.setBounds(76, 588, 86, 20);
		getContentPane().add(textFieldStudentStatus);
		textFieldStudentStatus.setColumns(10);
		
		textFieldBirthDate = new JTextField();
		textFieldBirthDate.setBounds(76, 557, 86, 20);
		getContentPane().add(textFieldBirthDate);
		textFieldBirthDate.setColumns(10);
		
		textFieldSurname = new JTextField();
		textFieldSurname.setBounds(76, 526, 86, 20);
		getContentPane().add(textFieldSurname);
		textFieldSurname.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(76, 495, 86, 20);
		getContentPane().add(textFieldName);
		textFieldName.setColumns(10);

		JLabel lblNewLabel = new JLabel("Lista grup");
		lblNewLabel.setBounds(10, 11, 110, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lista studentów");
		lblNewLabel_1.setBounds(214, 11, 122, 14);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Dodaj studenta");
		lblNewLabel_2.setBounds(29, 470, 89, 14);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Imie");
		lblNewLabel_3.setBounds(10, 498, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Nazwisko");
		lblNewLabel_4.setBounds(10, 529, 56, 14);
		getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Rok ur.");
		lblNewLabel_5.setBounds(10, 560, 56, 14);
		getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Status");
		lblNewLabel_6.setBounds(10, 591, 56, 14);
		getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Dodaj grupę");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(214, 470, 89, 14);
		getContentPane().add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Nazwa grupy");
		lblNewLabel_8.setBounds(186, 498, 79, 14);
		getContentPane().add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Liczebność");
		lblNewLabel_9.setBounds(186, 529, 69, 14);
		getContentPane().add(lblNewLabel_9);
		
		textFieldGroupName = new JTextField();
		textFieldGroupName.setBounds(265, 495, 86, 20);
		getContentPane().add(textFieldGroupName);
		textFieldGroupName.setColumns(10);
		
		textFieldMaxNumberOfStudents = new JTextField();
		textFieldMaxNumberOfStudents.setBounds(265, 526, 86, 20);
		getContentPane().add(textFieldMaxNumberOfStudents);
		textFieldMaxNumberOfStudents.setColumns(10);
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currClass != null) {
					StudentCondition condition = StudentCondition.PRESENT;
					//check specified condition:
					if (textFieldStudentStatus.getText().equals("CHORY")) {
						condition = StudentCondition.SICK;
					}
					else if (textFieldStudentStatus.getText().equals("NIEOBECNY")) {
						condition  = StudentCondition.ABSENT;
					}
					else if (textFieldStudentStatus.getText().equals("ODRABIAJACY")) {
						condition = StudentCondition.MAKINGUP;
					}
					//create new student
					try {
					Student newStud = new Student(textFieldName.getText(), textFieldSurname.getText(),
							condition, Integer.parseInt(textFieldBirthDate.getText()), 0.0);
					currClass.addStudent(newStud);
					loadStudents(currClass.getGroupName());
					} catch (final NumberFormatException ex) {
						JOptionPane.showMessageDialog(fr, "Złe dane w polu rok urodzenia", "Invalid data", JOptionPane.ERROR_MESSAGE);
						System.err.println(ex.getMessage());
					}
					
				}
			}
		});
		
		
		
		
		JButton btnAddGroup = new JButton("Dodaj");
		btnAddGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel list = new DefaultListModel();
				if (textFieldGroupName.getText().equals("")) {
					JOptionPane.showMessageDialog(fr, "Złe dane w polu nazwa grupy", "Invalid data", JOptionPane.ERROR_MESSAGE);
					System.err.println("Group name is empty");
				}
				
				try {
					book.addClass(textFieldGroupName.getText(), 
							      Integer.parseInt(textFieldMaxNumberOfStudents.getText()));
				} catch (final NumberFormatException ex) {
					JOptionPane.showMessageDialog(fr, "Złe dane w polu liczebność", "Invalid data", JOptionPane.ERROR_MESSAGE);
					System.err.println(ex.getMessage());
				}
				reload();
			}
		});
		btnAddGroup.setBounds(214, 555, 85, 22);
		getContentPane().add(btnAddGroup);
		
		JLabel lblNewLabel_12 = new JLabel("Sortowanie studentów");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(695, 26, 132, 13);
		getContentPane().add(lblNewLabel_12);
		
		
		JButton btnSortByName = new JButton("Po nazwisku");
		btnSortByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currClass != null) {
					renderStudents(currClass.sortByName());
				}
				else {
					JOptionPane.showMessageDialog(fr, "Nie wybrano grupy", "Invalid data", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		btnSortByName.setBounds(707, 50, 107, 21);
		getContentPane().add(btnSortByName);
		
		
		JButton btnSortByPoints = new JButton("Po punktach");
		btnSortByPoints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currClass != null) {
					renderStudents(currClass.sortByPoints(currClass.getStudentList()));
				} else {
					JOptionPane.showMessageDialog(fr, "Nie wybrano grupy", "Invalid data", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		btnSortByPoints.setBounds(708, 81, 106, 21);
		getContentPane().add(btnSortByPoints);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 37, 122, 147);
		getContentPane().add(scrollPane);
		
		listGroups = new JList();
		scrollPane.setViewportView(listGroups);
		listGroups.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				JList list =  (JList)e.getSource();
				int index = list.locationToIndex(e.getPoint());
                if (index >=0){
                    Object o = list.getModel().getElementAt(index);
                    loadStudents(o.toString());
                }
			}
		});
		
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(171, 37, 204, 214);
		getContentPane().add(scrollPane_1);
		
		listStudents = new JList();
		scrollPane_1.setViewportView(listStudents);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(519, 310, 308, 318);
		getContentPane().add(scrollPane_2);
		
		textArea = new JTextArea();
		scrollPane_2.setViewportView(textArea);
		
		JLabel lblNewLabel_10 = new JLabel("Funkcjonalności");
		lblNewLabel_10.setBounds(519, 25, 107, 14);
		getContentPane().add(lblNewLabel_10);
		
		
		JButton btnSumaryGroups = new JButton("Podsumowanie grup");
		btnSumaryGroups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renderGroups(book.summaryToGroups());
				renderTextArea();
			}
		});
		
		
		btnSumaryGroups.setBounds(488, 49, 153, 23);
		getContentPane().add(btnSumaryGroups);
		
		
		
		btnListGroups = new JButton("wyświetl");
		btnListGroups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reload();
			}
		});
		
		
		btnListGroups.setBounds(22, 195, 89, 23);
		getContentPane().add(btnListGroups);
		
		
		JButton btnDeleteGroup = new JButton("Usuń grupę");
		btnDeleteGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listGroups.isSelectionEmpty() != true) {
					book.removeClass(listGroups.getSelectedValue().toString());
				}
				reload();
			}
		});
		
		btnDeleteGroup.setBounds(488, 80, 153, 23);
		getContentPane().add(btnDeleteGroup);
		
		
		JButton btnShowEmpty = new JButton("Wyświetl puste grupy");
		btnShowEmpty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renderGroups(book.findEmptyString());
			}
		});
		
		
		btnShowEmpty.setBounds(488, 115, 153, 23);
		getContentPane().add(btnShowEmpty);
		
		
		JButton btnStudentMax = new JButton("Student z max pkt");
		btnStudentMax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (currClass != null) {
					renderStudents(Arrays.asList(currClass.max()));
				}
				else {
					JOptionPane.showMessageDialog(fr, "Wybierz studenta", "Invalid data", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnStudentMax.setBounds(488, 149, 153, 23);
		getContentPane().add(btnStudentMax);
		
		btnChangeGrSize = new JButton("Zmień liczebność");
		btnChangeGrSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currClass != null && !textFieldMaxNumberOfStudents.getText().equals("")) {
					try {
						currClass.setMaxStudents(Integer.parseInt(textFieldMaxNumberOfStudents.getText()));
					} catch (final NumberFormatException ex) {}
					
					
				}
			}
		});
		btnChangeGrSize.setBounds(214, 587, 137, 22);
		getContentPane().add(btnChangeGrSize);
		
		JLabel lblNewLabel_11 = new JLabel("Podsumowanie");
		lblNewLabel_11.setBounds(635, 285, 110, 14);
		getContentPane().add(lblNewLabel_11);
		
		textFieldEditStudentPoints = new JTextField();
		textFieldEditStudentPoints.setBounds(171, 262, 86, 20);
		getContentPane().add(textFieldEditStudentPoints);
		textFieldEditStudentPoints.setColumns(10);
		
		JButton btnEditPoints = new JButton("Edytuj punkty");
		btnEditPoints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currClass != null && !listStudents.isSelectionEmpty() 
						&& !textFieldEditStudentPoints.getText().equals("")) {
					String[] stud = listStudents.getSelectedValue().toString().split("/");
					currClass.searchPartial(stud[0]).forEach(stud1->{
						currClass.searchPartial(stud[1]).forEach(stud2->{
                            if(stud1.compareTo(stud2)==0) {
                                try {
                                	currClass.setStudentPoints(stud1, Integer.parseInt(textFieldEditStudentPoints.getText()));
                                } catch (final NumberFormatException exception) {
                                }
                            }
                        });
                    });
                    loadStudents(currClass.getGroupName());
				}
			}
		});
		btnEditPoints.setBounds(265, 262, 110, 23);
		getContentPane().add(btnEditPoints);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currClass != null)
					renderStudents(currClass.searchPartial(textField.getText()));
			}
		});
		
		textField.setBounds(171, 321, 204, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		lblNewLabel_13 = new JLabel("Wyszukaj studenta");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setBounds(214, 296, 122, 14);
		getContentPane().add(lblNewLabel_13);
		
		table = new JTable();
		table.setBounds(147, 416, 34, -10);
		getContentPane().add(table);
	}
	
	
	public static void main(String[] args) {
	    ArrayList<Student> studentListAddToClassContainer = new ArrayList<Student>();
	    studentListAddToClassContainer.add(new Student("Test1", "Test1", StudentCondition.ABSENT,
	                1997, 231));
	    studentListAddToClassContainer.add(new Student("Test3", "Test3", StudentCondition.SICK,
	                2001, 2342));
	    studentListAddToClassContainer.add(new Student("Test4", "Test4", StudentCondition.ABSENT,
	                1998, 2135));
	    studentListAddToClassContainer.add(new Student("Test2", "Test2", StudentCondition.MAKINGUP,
	                2002, 545));

	    
	    book.addClass("test1", 5);
	    book.addClass("test2", 10);
	    Class klasa = book.get("test1");
	    studentListAddToClassContainer.forEach(student -> {
	    	klasa.addStudent(student);
	    });
	    klasa.summary();
	    
	    ImageIcon icon = new ImageIcon("C:\\Users\\empo1\\eclipse-workspace\\StudentBookGui\\src\\icons8-outline-50.png");
	    
		GUI cos = new GUI();
		cos.setTitle("System zarządzania grupami");

		cos.setSize(886,700);
		cos.setIconImage(icon.getImage());
		cos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cos.setVisible(true);
	}
	
	public void loadStudents(String groupName) {
		DefaultListModel list = new DefaultListModel();
        book.getGroups().forEach((name,klasa)->{
            if(name.equals(groupName)){
                currClass = klasa;
                klasa.getStudentList().forEach(student->{
                    list.addElement(student);
                });
            }
        });
        listStudents.setModel(list);
	}	
	
	public void renderStudents(List<Student> list){
        DefaultListModel defList = new DefaultListModel();
        list.forEach(student->{
            defList.addElement(student);
        });
        listStudents.setModel(defList);
    }
	
	public void renderGroups(List<String> list){
        DefaultListModel defaultList = new DefaultListModel();
        list.forEach((name)->{
        	defaultList.addElement(name);
        });
        listGroups.setModel(defaultList);
    }
	public void renderTextArea() {
		textArea.setText(book.summaryToString());
	}
	
	public void reload() {
		DefaultListModel list = new DefaultListModel();
		book.getGroups().forEach((name, klasa) -> {
			list.addElement(klasa.getGroupName());
		});
		listGroups.setModel(list);
	}
}
