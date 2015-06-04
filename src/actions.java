import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import javax.swing.UIManager;
import java.io.FileNotFoundException;
import java.awt.Toolkit;
import java.awt.datatransfer.*;




public class actions implements ActionListener{

	private String copyString = "";
	private String path = "";
	Toolkit tk = Toolkit.getDefaultToolkit();
	private Clipboard c = tk.getSystemClipboard();

	
	private gui gui;
	
	
	
	public actions()
	{
		
		
	    try {
		 
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	    } 
	    catch (Exception e) {
	    }
	    gui = new gui();
		
		gui.PrintBtn.addActionListener(this);
		gui.SaveAsBtn.addActionListener(this);
		gui.SaveBtn.addActionListener(this);
		gui.SaveAs.addActionListener(this);
		gui.Close.addActionListener(this);
		gui.Open.addActionListener(this);
		gui.OpenBtn.addActionListener(this);
		gui.About.addActionListener(this);
		gui.Version.addActionListener(this);
		gui.Exit.addActionListener(this);
		gui.CopyBtn.addActionListener(this);
		gui.PasteBtn.addActionListener(this);
		gui.ClearBtn.addActionListener(this);
		gui.CutBtn.addActionListener(this);
		gui.NewBtn.addActionListener(this);
		gui.New.addActionListener(this);
		gui.CutM.addActionListener(this);
		gui.CopyM.addActionListener(this);
		gui.PasteM.addActionListener(this);
	
		gui.txt.addMouseListener(ms);
		//gui.txt.addKeyListener(kl);
		
	}
/*
	
		KeyListener kl = new KeyAdapter()
		{
				
				 public void keyPressed(KeyEvent e) {
			        
			         if (e.getKeyCode() == KeyEvent.VK_ENTER) {  
			            System.out.println(gui.txt.getLineCount()+1);
			            }
			         
				 else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				 {
					 System.out.println(gui.txt.getLineCount()-1);
				 }
				 else if (e.getKeyCode() == KeyEvent.VK_DELETE)
				 {
					 System.out.println(gui.txt.getLineCount());

				 }
				 }
		};
	
*/
	
	
	MouseListener ms = new MouseAdapter()
	{
		
	
		public void mouseClicked(MouseEvent e)
		{
			
			if (SwingUtilities.isRightMouseButton(e))
			{
				gui.jp.show(e.getComponent(), e.getX(), e.getY());
			}
			
			
			
		}
		
	};
	
	public void actionPerformed(ActionEvent e)
	{
		
	
		if(e.getSource() == gui.About)
		{
		ActionAbout();
		}
		else if(e.getSource() == gui.Version)
		{
		ActionVersion();
		}
		else if (e.getSource() == gui.Exit)
		{
			ActionExit();
		}
		else if (e.getSource() == gui.CopyBtn || e.getSource() == gui.CopyM)
		{
			ActionCopyBtn();
		}
		else if (e.getSource() == gui.PasteBtn || e.getSource() == gui.PasteM)
		{
			
		ActionPasteBtn();
			
		}
		else if (e.getSource() == gui.ClearBtn)
		{
			ActionClearBtn();
		}
		else if (e.getSource() == gui.CutBtn || e.getSource() == gui.CutM)
		{
			ActionCutBtn();
		}
		else if (e.getSource() == gui.Open || e.getSource() == gui.OpenBtn )
		{
			ActionOpen();
			 //System.out.println(gui.txt.getLineCount());
			
		}
		else if (e.getSource() == gui.Close)
		{
			ActionClose();
		}
		else if (e.getSource() == gui.SaveAs || e.getSource() == gui.SaveAsBtn)
		{
			ActionSaveAs();
			
		}
		else if (e.getSource() == gui.New || e.getSource() == gui.NewBtn)
		{
			ActionNew();
			gui.SaveBtn.setEnabled(false);
			gui.Save.setEnabled(false);
		}
		else if (e.getSource() == gui.PrintBtn)
		{
			ActionPrint();
		}
		else if (e.getSource() == gui.SaveBtn || e.getSource() == gui.Save)
		{
			ActionSave();
		}
		
		
		
	}
	
	private void ActionOpen()
	{
		 int result = gui.fc.showOpenDialog(null);
		String theText = "";
		 
		 switch(result)
		 {
		 case JFileChooser.APPROVE_OPTION:
		
		 path = gui.fc.getSelectedFile().getAbsolutePath();
		 
		 try
		 {
		 Scanner sc = new Scanner(new FileReader(path));
		 
		 while(sc.hasNext())
		 {
			 theText = theText + sc.nextLine() + "\n";
		 }
		 sc.close();
		 gui.txt.setText(theText);
		 gui.SaveBtn.setEnabled(true);
		 gui.Save.setEnabled(true);
		 }
		 catch (FileNotFoundException FnF)
		 {
			 JOptionPane.showMessageDialog(null, "Error reading file!");
		 }
		 break;
		 default:
		 }
		 
		 
	}
	
	private void ActionNew()
	{
		
		if (gui.txt.getText().compareTo("") != 0)
		{
		
		int k = JOptionPane.showConfirmDialog(null, "Do you want to save the current file?");
		
		if (k == JOptionPane.YES_OPTION)
		{
			ActionSaveAs();
			gui.txt.setText(null);
			
		}
		else if (k == JOptionPane.NO_OPTION)
		{
			gui.txt.setText(null);
		}
		
		
		}
		
	}
	
	private void ActionAbout()
	{
		JOptionPane.showMessageDialog(null, "JavTxt" + "\n\n" + "The simple JAVA text editor!");

	}
	
	private void ActionVersion()
	{
		JOptionPane.showMessageDialog(null, "JavTxt" + "\n\n" + "Version: 1.0"
				+ "\n\n" + "Made by: Krko");
	}
	
	private void ActionExit()
	{
		System.exit(0);
	}
	
	private void ActionCopyBtn()
	{
		copyString = gui.txt.getSelectedText();
		
		c.setContents(new StringSelection(copyString), null);
	}
	
	private void ActionPasteBtn()
	{
		Transferable d = c.getContents(null);
		try{
		String t = d.getTransferData(DataFlavor.stringFlavor).toString();
		gui.txt.replaceSelection(t);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Error, could not paste!");
		}
	}
	
	private void ActionClearBtn()
	{
		gui.txt.setText("");
		gui.SaveBtn.setEnabled(false);
		gui.Save.setEnabled(false);
	}
	
	private void ActionCutBtn()
	{
		if (gui.txt.getSelectedText() != null)
		{
		copyString = gui.txt.getSelectedText();
		c.setContents(new StringSelection(copyString),  null);
		gui.txt.replaceSelection("");
		}
	}
	private void ActionClose()
	{
		gui.txt.setText("");
		gui.SaveBtn.setEnabled(false);
		gui.Save.setEnabled(false);
	}
	private void ActionSaveAs()
	{
		int result = gui.fc.showSaveDialog(null);
		String saveString = "";
		
		switch(result)
		{
		case JFileChooser.APPROVE_OPTION:
			saveString = gui.txt.getText();
	
				saveString = saveString.trim();
			
			
			
			path = gui.fc.getSelectedFile().getAbsolutePath();
			
			try{
				BufferedWriter bf = new BufferedWriter(new FileWriter(path));  
				bf.write(saveString);
				bf.close();
				gui.SaveBtn.setEnabled(true);
				gui.Save.setEnabled(true);
			}
			catch(IOException ie)
			{
				JOptionPane.showMessageDialog(null, "Error writing file!");
			}
			break;
			default:
		}
		
		
	}
	
	private void ActionPrint()
	{
	
		try{
			gui.txt.print();
			}
		catch(Exception ex)
			{
			JOptionPane.showMessageDialog(null, "Error printing page!");
			}
		
	}
	
	private void ActionSave()
	{
		try{
			BufferedWriter bf = new BufferedWriter(new FileWriter(path));
			String saveString = gui.txt.getText();
			saveString = saveString.trim();
			bf.write(saveString);
			bf.close();
		}
		catch(IOException f)
		{
			JOptionPane.showMessageDialog(null, "Error saving file!");
		}
	}




}
