package PerformanceMonitor.GUI;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;


public class Temiz extends JFrame {
	public Temiz()
	{
		initGUI();
	}

	public void initGUI() {
		
		setTitle("Performance Monitor");
		
		JPanel panel = new JPanel(new GridBagLayout());
		this.getContentPane().add(panel);
		
		JTable table = new JTable(null);
		
		JLabel label = new JLabel("Performance Monitor");
		
		JPanel tableButtonPanel = new JPanel();
		tableButtonPanel.add(new JButton("Add Thing"));
		tableButtonPanel.add(new JButton("Delete Thing"));
		tableButtonPanel.add(new JButton("Modify Thing"));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(new JToggleButton("Print"));
		buttonPanel.add(new JButton("History"));
		buttonPanel.add(new JButton("Preferences"));
		buttonPanel.add(new JButton("Another Button"));
		buttonPanel.add(new JButton("Add Another"));
		buttonPanel.add(new JButton("Yet Another"));
		
	
		
		JPanel detailsPanel = new JPanel();
		detailsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JMenuBar jmb = new JMenuBar();
		JMenu jm = new JMenu("File");
		JMenuItem jmi = new JMenuItem("Open");
		JMenuItem jmiSave = new JMenuItem("Save");
		jmb.add(jm);
		jm.add(jmi);
		jmiSave.setAccelerator(KeyStroke.getKeyStroke(
                 KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		jm.add(jmiSave);
		GridBagConstraints gbc = new GridBagConstraints();
		
//		System.out.println(gbc.anchor);
		System.out.println(gbc.fill);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.anchor=GridBagConstraints.WEST;
		gbc.fill=GridBagConstraints.BOTH;
		panel.add(jmb, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor=GridBagConstraints.CENTER;
		panel.add(label, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(new JScrollPane(table), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(tableButtonPanel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		panel.add(buttonPanel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 2;
		gbc.gridwidth = 1;
		panel.add(detailsPanel, gbc);
		
		this.pack();
		
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

		Temiz temiz=new Temiz();
		temiz.pack();
		temiz.setVisible(true);
	}
	
	

}
