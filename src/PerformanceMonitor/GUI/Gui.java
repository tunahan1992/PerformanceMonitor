package PerformanceMonitor.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.plaf.SliderUI;
import javax.swing.table.DefaultTableModel;

import PerformanceMonitor.Utilities.JSwitchBox;
import PerformanceMonitor.Utilities.Java2sAutoComboBox;
import PerformanceMonitor.Utilities.Utilities;

public class Gui extends JFrame {
	
	private JPanel mainPanel;
	private JPanel menuPanel;
	private JPanel comboBoxPanel;
	private JPanel performanceForcePanel;
	private JPanel performanceConfigPanel;
	
	private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenuItem itemOpen;
    private JMenuItem itemSave;
	
    private JTabbedPane ResultTabs;
    
    private JTable CPUResults;
    private JTable networkResults;
    private JTable diskResults;
    private JTable memoryResults;
    
    private Object[][] CPUObjects;
    private Object[][] networkObjects;
    private Object[][] diskObjects;
    private Object[][] memoryObjects;
    
    private String[] CPUTitle;
    private String[] networkTitle;
    private String[] diskTitle;
    private String[] memoryTitle;
   
    private JScrollPane CPUTablePane;
    private JScrollPane networkTablePane;
    private JScrollPane diskTablePane;
    private JScrollPane memoryTablePane;

    private Java2sAutoComboBox performanceCounterChooser;
    
    private JButton addPerformanceCounterButton;
	private JButton forceCPU;
	private JButton forceNetWork;
	private JButton forceMemory;
	private JButton forceDisk;
	
	private JSwitchBox typeChooserSlider; // time or percent 
	
	private JTextField percentChooser; // specify the increasing percent of counter
	private JLabel percentLabel; // label for percentChooser
    
    
	public Gui()
	{
		initGUI();
	}

	public void initGUI() {
        

		mainPanel = new JPanel(new GridBagLayout());
		this.getContentPane().add(mainPanel);
		//mainPanel.add(performanceCounterChooser);		
	
		/* Panel Initializing */
		
		menuPanel = new JPanel();	
		ResultTabs = new JTabbedPane();
		comboBoxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		performanceForcePanel =  new JPanel(new FlowLayout(FlowLayout.LEFT));
		performanceConfigPanel =  new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		/* Initialize the menu bar */
		
		menuBar = new JMenuBar();
		menuFile = new JMenu("File");
		itemOpen = new JMenuItem("Open");
		itemSave = new JMenuItem("Save");
		menuBar.add(menuFile);
		menuFile.add(itemOpen);
		menuFile.add(itemSave);

		itemOpen.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		itemSave.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		//comboBoxPanel.setBackground(Color.black);
		//performanceForcePanel.setBackground(Color.BLUE);
		//performanceConfigPanel.setBackground(Color.yellow);
		mainPanel.add(menuBar,Utilities.formatConfig(0, 0, 1, 3, GridBagConstraints.WEST, GridBagConstraints.BOTH));
		mainPanel.add(ResultTabs,Utilities.formatConfig(0, 1, 1 , 3, GridBagConstraints.WEST, GridBagConstraints.BOTH));
		mainPanel.add(comboBoxPanel, Utilities.formatConfig(0, 2, 3, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH));
		mainPanel.add(performanceForcePanel, Utilities.formatConfig(0, 5, 3, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH));
		mainPanel.add(performanceConfigPanel, Utilities.formatConfig(0, 8, 3, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH));
			
		
		
		/*Initialize the tables and scrollPanes*/
		
		CPUResults = new JTable();
		CPUObjects= new Object[][]{{3}};
		CPUTitle= new String[]{"Ayþe","Fatma","Hayriye"};
		CPUResults.setModel(new DefaultTableModel(CPUObjects,CPUTitle));
		CPUResults.setColumnSelectionAllowed(true);
		CPUResults.setCellSelectionEnabled(true);
		
		memoryResults = new JTable();
		memoryResults.setModel(new DefaultTableModel(memoryObjects,memoryTitle));
		memoryResults.setColumnSelectionAllowed(true);
		memoryResults.setCellSelectionEnabled(true);
		
		networkResults = new JTable();
		networkResults.setModel(new DefaultTableModel(networkObjects,networkTitle));
		networkResults.setColumnSelectionAllowed(true);
		networkResults.setCellSelectionEnabled(true);
		
		diskResults	= new JTable();
		diskResults = new JTable();
		diskResults.setModel(new DefaultTableModel(diskObjects,diskTitle));
		diskResults.setColumnSelectionAllowed(true);
		diskResults.setCellSelectionEnabled(true);
		
		CPUTablePane = new JScrollPane(CPUResults);
		memoryTablePane = new JScrollPane(memoryResults);
		networkTablePane = new JScrollPane(networkResults);
		diskTablePane = new JScrollPane(diskResults);
		
		/*TabbedPane*/
		
		ResultTabs.addTab("CPU",null,CPUTablePane,null);
		ResultTabs.addTab("Memory",null,memoryTablePane,null);
		ResultTabs.addTab("Disk",null,diskTablePane,null);
		ResultTabs.addTab("Network",null,networkTablePane,null);
		
		/*Combobox Menu */
		
		List<String> liste = new ArrayList<String>();
		liste.add("Ali");
		liste.add("Veli");
		liste.add("Kezbahasdfgyadsugfoasdygfoasdgfoasdfads");
		performanceCounterChooser = new Java2sAutoComboBox(liste);
		
		comboBoxPanel.add(performanceCounterChooser);
		comboBoxPanel.add(addPerformanceCounterButton = new JButton("Add"));
		
		/*PerformanceForcerButton*/
		
		
		
		performanceForcePanel.add(forceCPU = new JButton("CPU"));
		performanceForcePanel.add(forceNetWork = new JButton("Network"));
		performanceForcePanel.add(forceDisk = new JButton("Disk"));
		performanceForcePanel.add(forceMemory = new JButton("RAM"));
		
		
		
		
		/*Slider - Timer and Percent Side*/
		performanceConfigPanel.add(typeChooserSlider = new JSwitchBox("TIME", "PERCENT"));
		performanceConfigPanel.add(percentChooser = new JTextField());
		percentChooser.setPreferredSize( new Dimension( 40, 24 ) );
		performanceConfigPanel.add(percentLabel = new JLabel("%"));
		
	
		
		
	
	
		
		
		
	}
	
	public static void main(String[] args) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look and feel.
		}

		Gui mainFrame = new Gui();
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
}
