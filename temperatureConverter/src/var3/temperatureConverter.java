package var3;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class temperatureConverter extends JFrame{
	
	private JButton saveB, clearB, exeB;
	private JCheckBox celCB, farCB, kCB;
	private JRadioButton celRB, farRB, kRB;
	private JTextField userTF;
	private JTextArea sysTA;
	
	public temperatureConverter() {
		
		saveB = new JButton("Save");
		clearB = new JButton("Clear");
		exeB = new JButton("Convert");
		
		celCB = new JCheckBox("Celsius");
		farCB = new JCheckBox("Fahrenheit");
		kCB = new JCheckBox("Kelvin");
		
		celRB = new JRadioButton("Celsius");
		farRB = new JRadioButton("Fahrenheit");
		kRB = new JRadioButton("Kelvin");
		
		//only 1 RB can be selected at a time
		ButtonGroup from = new ButtonGroup();
		from.add(celRB);
		from.add(farRB);
		from.add(kRB);	
		
		userTF = new JTextField(20);
		sysTA = new JTextArea(20,30);
		
		setTitle("Temperature Converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//Container settings
		Container cp = getContentPane();
		cp.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10,10,10,10);
		
//add menu bar, file and help
		JMenuBar men = new JMenuBar();
		JMenu file = new JMenu("File");		
		JMenuItem help = new JMenuItem("Help");
		
		JMenuItem open = new JMenuItem("Open");
		JMenuItem exit = new JMenuItem("Exit");
		
		file.add(open);
		file.add(exit);
		
		men.add(file);
		men.add(help);
		
		setJMenuBar(men);

//set layout for buttons, fields and labels
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		cp.add(new JLabel("Convert From: "), gbc);
		
		//group RB together for layout purposes 
		JPanel rb = new JPanel(new FlowLayout());
		rb.add(celRB);
		rb.add(farRB);
		rb.add(kRB);
		gbc.gridx = 1;
		gbc.gridy = 0;
		cp.add(rb,gbc);
		celRB.setSelected(true);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		cp.add(new JLabel("Convert to: "), gbc);
		
		//group CB together for layout purposes 		
		JPanel cb = new JPanel(new FlowLayout());
		cb.add(celCB);
		cb.add(farCB);
		cb.add(kCB);
		gbc.gridx = 1;
		gbc.gridy = 1;
		cp.add(cb,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		cp.add(new JLabel("Input: "), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		cp.add(userTF, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		cp.add(exeB, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.NORTH;//align label to top of row
		cp.add(new JLabel("Sys msg: "), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		JScrollPane scroll = new JScrollPane(sysTA);//make sysTA Scrollable
		cp.add(scroll, gbc);
		
		//group save clear together for layout purposes 
		JPanel sc = new JPanel(new FlowLayout());
		sc.add(saveB);
		sc.add(clearB);
		gbc.gridx = 1;
		gbc.gridy = 5;
		cp.add(sc, gbc);

//Button Listeners
		
		//for click
		exeB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				convert();
				
			}
			
		});
		
		//for enter
		userTF.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				convert();
				
			}
			
		});
		
		clearB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				userTF.setText("");
				sysTA.setText("");
				farCB.setSelected(false);
				celCB.setSelected(false);
				kCB.setSelected(false);
				
			}
			
		});
		
		
		//Mouse Hover 
		clearB.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				clearB.setBackground(Color.GRAY);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				clearB.setBackground(UIManager.getColor(""));
			}
			
		});
		
		
		saveB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				save();
				
			}
			
		});
		
		//Mouse Hover
		saveB.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				saveB.setBackground(Color.GRAY);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				saveB.setBackground(UIManager.getColor(""));
			}
		});
		
		//enter to save after tab
		saveB.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					save();
				}
			}
		});
		
		
//Menu listeners
		open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				read();
				
			}
			
		});
		
		help.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(temperatureConverter.this, "Help Message....", "Help", JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		});
		
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
				
			}
			
		});
		
		
		pack();
		setLocationRelativeTo(null);

	}
	
	private void convert() {
		try {
			
			double input = Double.parseDouble(userTF.getText());
			
			sysTA.append("=======\n");
			sysTA.append("Input: " + String.format("%.2f", input) + (celRB.isSelected() ? "C" : (farRB.isSelected() ? "F" : "K")) + "\n");
			sysTA.append("=======\n");
			
			if(celRB.isSelected()) {
				
				if(celCB.isSelected())
					sysTA.append("Celsius: "+String.format("%.2f", input)+"\n");
				if(farCB.isSelected())
					sysTA.append("Fahrenheit: "+String.format("%.2f", input*9/5+32)+"\n");
				if(farCB.isSelected())
					sysTA.append("Kelvin: "+String.format("%.2f", input+273.15)+"\n");
				
			}else if(farRB.isSelected()) {
				if(celCB.isSelected())
					sysTA.append("Celsius: "+String.format("%.2f", (input-32)* 5/9)+"\n");
				if(farCB.isSelected())
					sysTA.append("Fahrenheit: "+String.format("%.2f", input)+"\n");
				if(farCB.isSelected())
					sysTA.append("Kelvin: "+String.format("%.2f", (input-32)* 5/9 + 273.15 )+"\n");
				
			}else {
				if(celCB.isSelected())
					sysTA.append("Celsius: "+String.format("%.2f", input-237.15)+"\n");
				if(farCB.isSelected())
					sysTA.append("Fahrenheit: "+String.format("%.2f", (input - 273.15) * 9/5 + 32)+"\n");
				if(farCB.isSelected())
					sysTA.append("Kelvin: "+String.format("%.2f", input )+"\n");
				
			}
			
			sysTA.append("\n");
			
			
			
		}catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Please enter a number", "Input error", JOptionPane.ERROR_MESSAGE);
		}
	}
	

	private void save() {
		try(PrintWriter writer = new PrintWriter(new FileWriter("temperature.txt",true))){
			
			writer.append(sysTA.getText());
			JOptionPane.showMessageDialog(this, "File Saved sucessfully", "Save", JOptionPane.INFORMATION_MESSAGE);
			
		}catch(IOException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Save Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	private void read() {
		
		JFileChooser fo = new JFileChooser();
		fo.showOpenDialog(this);
		String line;

		
		try(BufferedReader read = new BufferedReader(new FileReader(fo.getSelectedFile()))) {
			
			sysTA.setText("");
			while((line = read.readLine())!=null) {
				sysTA.append(line+"\n");
			}
						
			
		}catch(IOException ex) {
			JOptionPane.showMessageDialog(this, "Error reading file", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new temperatureConverter().setVisible(true);
			}
		});

	}

}
