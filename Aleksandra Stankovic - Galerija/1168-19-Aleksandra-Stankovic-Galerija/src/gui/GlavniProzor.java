package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;      
         
import java.awt.Graphics;          
import java.awt.Image;





import util.Utilities;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GlavniProzor extends JFrame {
	
	private JFrame ovaj;

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnAplikacija;
	private JMenuItem mntmIzlaz;
	private JMenu mnSifarnici;
	
	private JMenuItem mntmProizvodi;
	private JMenuItem mntmRacuni;
	

	/**
	 * Create the frame.
	 */
	public GlavniProzor() {
		initialize();
	}

	private void initialize() {
		ovaj = this;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				int rezultat = JOptionPane.showOptionDialog(ovaj,
						"Da li ste sigurni da želite zatvoriti aplikaciju?",
						"Potvrda zatvaranja", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null,
						Utilities.YES_NO_OPTIONS,
						Utilities.YES_NO_OPTIONS[1]);
				if (rezultat == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		setTitle("Galerija");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 815, 420);
		setLocationRelativeTo(null);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setJMenuBar(getMenuBar_1());
		
		
		
		
		JPanel contentPaneWithBackground = new JPanel() {
            private Image backgroundImage = new ImageIcon("/PovezivanjeProba2/src/img/GALERIJA.png").getImage(); 

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        contentPaneWithBackground.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPaneWithBackground.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPaneWithBackground); // Set the custom panel as the content pane
    
		

		
		

		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnAplikacija());
			menuBar.add(getMnSifarnici());
		}
		return menuBar;
	}

	private JMenu getMnAplikacija() {
		if (mnAplikacija == null) {
			mnAplikacija = new JMenu("Aplikacija");
			mnAplikacija.setMnemonic('A');
			mnAplikacija.add(getMntmIzlaz());
		}
		return mnAplikacija;
	}

	private JMenuItem getMntmIzlaz() {
		if (mntmIzlaz == null) {
			mntmIzlaz = new JMenuItem("Izlaz");
			mntmIzlaz.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ovaj.getToolkit()
							.getSystemEventQueue()
							.postEvent(
									new WindowEvent(ovaj,
											WindowEvent.WINDOW_CLOSING));
				}
			});
			mntmIzlaz.setMnemonic('I');
			mntmIzlaz.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
					InputEvent.ALT_MASK));
		}
		return mntmIzlaz;
	}

	private JMenu getMnSifarnici() {
		if (mnSifarnici == null) {
			mnSifarnici = new JMenu("Šifarnici");
			mnSifarnici.setMnemonic('F');
			mnSifarnici.add(getmntmProizvodi());
			mnSifarnici.add(getmntmRacuni());
			//mnSifarnici.add(getMntmStudijskiProgrami());
		}
		return mnSifarnici;
	}

	private JMenuItem getmntmProizvodi() {
		if (mntmProizvodi == null) {
			mntmProizvodi = new JMenuItem("Proizvodi");
			mntmProizvodi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new ProizvodiFrame().setVisible(true);
				}
			});
			mntmProizvodi.setMnemonic('F');
		}
		return mntmProizvodi;
	}

	private JMenuItem getmntmRacuni() {
		if (mntmRacuni == null) {
			mntmRacuni = new JMenuItem("Racuni");
			mntmRacuni.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new RacuniFrame().setVisible(true);
				}
			});
			mntmRacuni.setMnemonic('P');
		}
		return mntmRacuni;
	}


}
