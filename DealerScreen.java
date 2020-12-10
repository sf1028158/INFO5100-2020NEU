
/* Use Case I Screen */
package ui;
import incentive.*;
import dao.*;

import service.*;
//import ui.*; 
import validation.*;
import dto.*;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
public class DealerScreen {
    private JFrame frame;
    private JPanel panelLeft, panelRight;
    private JTextField textFieldDealerName;
    private JTextField textFieldZipCode;
   // private JComboBox<String> comboBox;
   // private JButton btnSearch;
    ArrayList<Dealer> searchList;  
    ArrayList<Dealer> dealerList1;
    private JTable table;
    int signal = 0;
    private JRadioButton c1,c2;
    private JButton c3,jbtn;
    String[][] obj;
    
    //private ArrayList<Dealer> dealerList=new ArrayList<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DealerScreen window = new DealerScreen();
                    window.frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private DealerScreen() {
        frameAndPanel();
        dealerName();
        zipCode();
        searchBtn();
    }

    // complete frame
    private void frameAndPanel() {
        frame = new JFrame();
        frame.setTitle("Dealer Locator Website");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,650);
        frame.getContentPane().setLayout(new BorderLayout());
        initializeLeftPanel();
        initializeRightPanel();
    }
    
    // left panel containing the form
    private void initializeLeftPanel() {
        panelLeft= new JPanel();
        panelLeft.setBackground(new Color(165, 194, 147));
        panelLeft.setLayout(null);
        panelLeft.setPreferredSize(new Dimension(280,650));
        frame.getContentPane().add(panelLeft,BorderLayout.WEST);
    }

    // right panel containing the table
    private void initializeRightPanel() {
        panelRight= new JPanel();
        panelRight.setPreferredSize(new Dimension(720,650));
      //  panelRight.setBackground(new Color(192,192,192));
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
       
        frame.getContentPane().add(panelRight,BorderLayout.CENTER);
    }

    // initializing dealer's name
    private void dealerName() {
        JLabel lblName = new JLabel("Search by Dealers Name: ");
        lblName.setBounds(10, 50, 200, 14);
        lblName.setForeground(Color.WHITE);
        panelLeft.add(lblName,BorderLayout.NORTH);

        textFieldDealerName = new JTextField();
        textFieldDealerName.setBounds(10, 90, 200, 20);
        textFieldDealerName.setColumns(10);
        panelLeft.add(textFieldDealerName);
        highlightDealerName();
        dealerNameValidation();
    }

    // validating dealer's name
    private void dealerNameValidation(){
        textFieldDealerName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                String dealerName = textFieldDealerName.getText();
                // !dealerName.isEmpty()&&!Validator.isValidDealerName(dealerName)
                if(!dealerName.isEmpty()&&!Validator.isValidDealerName(dealerName)) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please try again.");
                }
            }

        });
    }

    // highlighting if dealer's name textfield is empty
    private void highlightDealerName(){
        Border defaultBorder = textFieldDealerName.getBorder();
        textFieldDealerName.setBorder(BorderFactory.createLineBorder(new Color(0, 113, 238), 3));
        textFieldDealerName.getDocument().addDocumentListener(new DocumentListener() {
        // Interface DocumentListener
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                maybeHighlight();
            }
            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                maybeHighlight();
            }
            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                maybeHighlight();
            }

            private void maybeHighlight() {
                if (textFieldDealerName.getText().trim().length() != 0) {
                    textFieldDealerName.setBorder(defaultBorder);
                } else {
                    textFieldDealerName.setBorder(BorderFactory.createLineBorder(new Color(0, 113, 238), 3));
                }
            }
        });
    }

    // handling zip code
    private void zipCode() {
        JLabel lblPhone = new JLabel("Search by Zipcode: ");
        lblPhone.setBounds(10, 190, 270, 14);
        lblPhone.setForeground(Color.WHITE);
        panelLeft.add(lblPhone);
        textFieldZipCode = new JTextField();
        textFieldZipCode.setBounds(10, 230, 200, 20);
        textFieldZipCode.setColumns(10);
        panelLeft.add(textFieldZipCode);
        
        highlightZipCode();
        validateZipCode();
    }

    // highlighting zipcode textfield if it is empty
    private void highlightZipCode(){
        Border defaultBorder2 = textFieldZipCode.getBorder();
        textFieldZipCode.setBorder(BorderFactory.createLineBorder(new Color(0, 113, 238), 3));
        textFieldZipCode.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                maybeHighlight();
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                maybeHighlight();
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                maybeHighlight();
            }

            private void maybeHighlight() {
                if (textFieldZipCode.getText().trim().length() != 0)
                {
                    textFieldZipCode.setBorder(defaultBorder2);
                }
                else
                {
                    textFieldZipCode.setBorder(BorderFactory.createLineBorder(new Color(0, 113, 238), 3));
                }
            }
        });
    }

    // validation for zip code'e length
    private void validateZipCode(){
        textFieldZipCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                String zipCode=textFieldZipCode.getText();
                try {
                //  && !Validator.isValidZipCodeRange(zipCode)
	                if(!textFieldZipCode.getText().isEmpty()&& !Validator.isValidZipCodeRange(zipCode)) {
	                	// if zip code is invalid
	                    JOptionPane.showMessageDialog(frame, "This is a invalid Zip Code, Please enter again \nHint: Zip Code should be 5-digit or 9-digit (ZIP+4)."); 
	                }
                }
                catch(Exception e) {
                	e.printStackTrace();
                }
            }
        });
    }
    
    private ArrayList<Dealer> searchBtn(){
    	//int signal = 0;   	
    	
    	SearchDealer s1 = new SearchDealer();
    	JLabel l1 = new JLabel("");
    	 c1=new JRadioButton("Zipcode",true);
    	 c2=new JRadioButton("Dealer Name");
    	c1.setVisible(true);
    	c2.setVisible(true);
    	 c3=new JButton("Search");
    	
    		c1.setBackground(new Color(192,192,192));
        	c2.setBackground(new Color(192,192,192));
        	c3.setBackground(new Color(192,192,192));
        	c1.setBorder(BorderFactory.createLineBorder(new Color(210,105,30), 3));
        	c2.setBorder(BorderFactory.createLineBorder(new Color(210,105,30), 3));
        	
        c1.setActionCommand("Zipcode");
        c2.setActionCommand("Dealer Name");
    	l1.setBounds(10, 300, 150, 14);
    	c1.setBounds(10, 350, 100, 30);
    
    	c2.setBounds(120, 350, 100, 30);
    	c3.setBounds(10,480,100,30);
    	ButtonGroup group = new ButtonGroup();  
    	group.add(c1);
    	group.add(c2);  
    	panelLeft.add(l1,BorderLayout.CENTER);
    	panelLeft.add(c1);
    	panelLeft.add(c2,BorderLayout.SOUTH);	
    	panelLeft.add(c3);
    	setJTable();
    	SelectAndView();
		c1.addActionListener((ActionEvent ae) ->{signal=0;});
		
		c1.addActionListener((ActionEvent ae) ->{signal=1;});
		c3.addActionListener((ActionEvent ae) ->{
	
			//if(signale==0)
			if(c1.isSelected()){
				ArrayList<Dealer> searchList1=(ArrayList<Dealer>) s1.searchByZipCode(textFieldZipCode.getText());
				searchList=searchList1;
				try {
					createTable();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				}
			//if(signal==1)
			if(c2.isSelected()){
				
				ArrayList<Dealer> searchList2=(ArrayList<Dealer>)s1.searchByName(textFieldDealerName.getText());
				 searchList=searchList2;
			 try {
				createTable();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				}	
		});	
		return searchList;
    }
    
    private void createTable() throws Exception { 	
    	ArrayList<Dealer> dealerList1=searchBtn();
    	
    	 String[] columnNames = { "ID", "Name","ZipCode","Distance","City","State","Address"};
    
    			 
    	 int n= dealerList1.size();   
    	 obj=new String[n][6];
    	 for(int i=0;i<n;i++){
    		 obj[i][0]=dealerList1.get(i).getDealerId();
    		 obj[i][1]=dealerList1.get(i).getDealerName();
    		 obj[i][2]=dealerList1.get(i).getDealerAddress().getZipCode();
    		 obj[i][3]=dealerList1.get(i).getDistanceInMiles()+"";
    		 obj[i][4]=dealerList1.get(i).getDealerAddress().getCity();
    		 obj[i][5]=dealerList1.get(i).getDealerAddress().getState();
    		 obj[i][6]=dealerList1.get(i).getDealerAddress().getAddressInfo();
    	 }
    	 TableModel tm = new DefaultTableModel(obj, columnNames); 	
    	 JTable temp=new JTable();
    	 temp.setModel(tm);
    	table=temp;
 	 this.table.repaint();
      this.table.updateUI();
    	
    	   
    	 try {
             if(dealerList1.isEmpty()) {
                 JOptionPane.showMessageDialog(frame, "There is no dealer satisfied your requirement."); 
             }
         }
         catch(Exception e) {
         	e.printStackTrace();
         }
    	 
    }

    private  void setJTable() {
    	 
        String[] columnNames = { "ID", "Name","ZipCode","Distance","City","State","Address"};
       // String[][] obj=null;
        this.obj = new String[][]{ { " ", " ", " ", " ", " " ," "},
        		 { " ", " ", " ", " ", " " ," "},
        		 };
        
        this.table = new JTable(new DefaultTableModel(obj, columnNames));
    	table.setRowHeight(60);
    	 table.getColumnModel().getColumn(6).setPreferredWidth(300);
    	table.setVisible(true);
      	
    /*	try {
			createTable();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    
    
        table.setBackground(new Color(192,192,192));
        panelRight.add(new JScrollPane(table)); 
    
        
        // 创建包含表格的滚动窗格
JScrollPane scrollPane = new JScrollPane(table);
scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        // 定义 topPanel 的布局为 BoxLayout，BoxLayout 为垂直排列
//panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
     
// 先加入一个不可见的 Strut，从而使 topPanel 对顶部留出一定的空间
panelRight.add(Box.createVerticalStrut(5));



        // 加入包含表格的滚动窗格
panelRight.add(scrollPane);
        // 再加入一个不可见的 Strut，从而使 topPanel 和 middlePanel 之间留出一定的空间
panelRight.add(Box.createVerticalStrut(10));





/*	//int columncount = table.getColumnCount();

for (int i = 1; i < columncount; i++) {
    table.getColumnModel().getColumn(i).setPreferredWidth(300);

}*/
}
       
 
   private void SelectAndView() {
	 //   int count=table.getSelectedRow();
	    
	  //  int getID= Integer.parseInt((String) table.getValueAt(count, 0));
	    jbtn= new JButton("View Inventory");
	    panelRight.add(jbtn);
	    jbtn.setBounds(10, 630, 80, 14);
	    jbtn.addActionListener((ActionEvent ae) ->{
	    	
	    	System.out.println("Dealer"+"getID"+"is selected, and view inventory.");
	    	
	    });
   }       
}