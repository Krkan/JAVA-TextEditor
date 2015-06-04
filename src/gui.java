import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.KeyEvent;
public class gui extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container c = getContentPane();
	private BorderLayout L = new BorderLayout();
	private JToolBar P = new JToolBar();
	
	private JMenuBar B = new JMenuBar();
	private JMenu F = new JMenu(" File"); 
	private JMenu F2 = new JMenu(" About");
	
	public JPopupMenu jp = new JPopupMenu();
	
	public JMenuItem Open = new JMenuItem("Open", new ImageIcon("icons/Open_file.gif")); 
	public JMenuItem Close = new JMenuItem("Close", new ImageIcon("icons/Closed folder.gif")); 
	public JMenuItem Exit = new JMenuItem("Exit", new ImageIcon("icons/Exit button.gif")); 
	public JMenuItem New = new JMenuItem("New", new ImageIcon("icons/Document.gif"));
	public JMenuItem SaveAs = new JMenuItem("Save As", new ImageIcon("icons/Save as.gif"));

	public JFileChooser fc = new JFileChooser();
	private FileNameExtensionFilter f1 = new FileNameExtensionFilter("Text files (*.txt)","txt");
	private FileNameExtensionFilter f2 = new FileNameExtensionFilter("PHP files (*.php)", "php");
	private FileNameExtensionFilter f3 = new FileNameExtensionFilter("C/C++ files (*.cpp,*.c,*.h)", "cpp", "c", "h");
	private FileNameExtensionFilter f4 = new FileNameExtensionFilter("JAVA files (*.java)", "java");
	private FileNameExtensionFilter f5 = new FileNameExtensionFilter("HTML files (*.html)", "html");
	private FileNameExtensionFilter f6 = new FileNameExtensionFilter("CSS files (*.css)", "css");
	
	public JMenuItem About = new JMenuItem("About", new ImageIcon("icons/Question.gif"));
	public JMenuItem Version = new JMenuItem("Version", new ImageIcon("icons/Info.gif"));
	public JMenuItem Save = new JMenuItem("Save", new ImageIcon("icons/Save.gif"));

	//Buttons
	
	public JButton OpenBtn = new JButton("Open", new ImageIcon("icons/Open_file.gif")); 
	public JButton SaveBtn = new JButton("Save", new ImageIcon("icons/Save.gif"));
	public JButton NewBtn = new JButton("New", new ImageIcon("icons/Document.gif"));
	public JButton SaveAsBtn = new JButton("Save as", new ImageIcon("icons/Save as.gif"));
	public JButton PrintBtn = new JButton("Print", new ImageIcon("icons/Print.gif"));
	
	
	public JButton CopyBtn =  new JButton("Copy", new ImageIcon("icons/Copy.gif"));
	public JButton CutBtn =  new JButton("Cut", new ImageIcon("icons/Cut.gif"));
	public JButton PasteBtn =  new JButton("Paste", new ImageIcon("icons/Paste.gif"));
	public JButton ClearBtn =  new JButton("Clear All", new ImageIcon("icons/Delete.gif"));
	
	public JMenuItem CopyM =  new JMenuItem("Copy", new ImageIcon("icons/Copy.gif"));
	public JMenuItem CutM =  new JMenuItem("Cut", new ImageIcon("icons/Cut.gif"));
	public JMenuItem PasteM =  new JMenuItem("Paste", new ImageIcon("icons/Paste.gif"));
	
	
	public JTextPane txt = new JTextPane();
	private JScrollPane Pane = new JScrollPane(txt);
	private JLabel Label1 = new JLabel("Don't forget to save your work!");
	private JLabel Label_WEST = new JLabel("");
	private JLabel Label_EAST = new JLabel("");
	

	
	public gui()
	{

		
		setSize(768, 800);
		setVisible(true);
		SaveBtn.setEnabled(false);
		Save.setEnabled(false);
		//Layout
		c.setLayout(L);
		setTitle("JavTxt 1.0");
		InitToolBar();
		 
		CopyM.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, 2));
		CutM.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, 2));
		
		
		jp.add(CopyM);
		jp.add(CutM);
		jp.add(PasteM);
		
		setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("icons/JavTxt.gif"));
		
		add(Pane, BorderLayout.CENTER);
		add(Label1, BorderLayout.SOUTH);
		add(Label_WEST, BorderLayout.WEST);
		add(Label_EAST, BorderLayout.EAST);
		
		fc.addChoosableFileFilter(f6);
		fc.addChoosableFileFilter(f5);
		fc.addChoosableFileFilter(f4);
		fc.addChoosableFileFilter(f3);
		fc.addChoosableFileFilter(f2);
		fc.addChoosableFileFilter(f1);
	
		//Menu Bar
		InitMenuBar();
	
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}
	
	private void InitToolBar()
	{
		add(P, BorderLayout.NORTH);
		P.setFloatable(false);
		P.add(NewBtn);
		P.add(OpenBtn);
		P.add(SaveBtn);
		P.add(SaveAsBtn);
		P.addSeparator();
		P.add(CopyBtn);
		P.add(CopyBtn);
		P.add(CutBtn);
		P.add(PasteBtn);
		P.add(PrintBtn);
		P.addSeparator();
		P.add(ClearBtn);
	}
	
	private void InitMenuBar()
	{
		setJMenuBar(B);
		
		Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, 2));
		New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, 2));
		
		B.add(F);
		B.add(F2);
		F.add(New);
		F.add(Open);
		F.add(Save);
		F.add(SaveAs);
		F.addSeparator();
		F.add(Close);
		F.addSeparator();
		F.add(Exit);
		
		F2.add(About);
		F2.add(Version);
		
	}
	
	
	
}
