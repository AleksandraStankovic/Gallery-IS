package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Racun_Stavka;

import entity.Racun;

import util.Utilities;
import entity.Proizvod;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;


@SuppressWarnings("serial")
public class RacunDialog extends JDialog {
	
	private RacunDialog ovaj;
	private String dialogResult = "Cancel";

	private final JPanel contentPanel = new JPanel();
	private JComboBox cbProizvodi;
	private JComboBox cbRacuni;
	private JTextField tfKolicina;
	
	
	public RacunDialog() {
		ovaj = this;
		

		initialize();
	}

	public RacunDialog(Racun Racun) {  
		ovaj = this;
		
		initialize();

	}

	public String getDialogResult() {
		return dialogResult;
	}



	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Racun");
		setBounds(100, 100, 355, 220);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(this.contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblIdRacun = new JLabel("IdRacun");
			lblIdRacun.setBounds(10, 11, 327, 14);
			contentPanel.add(lblIdRacun);
		}
		
		{
			this.cbRacuni = new JComboBox(Utilities 
					.getDataAccessFactory().getRacunDataAccess().Racuni()
					.toArray(new Racun[] {})); 
			this.cbRacuni.setBounds(10, 25, 327, 20);
			contentPanel.add(this.cbRacuni);
		}
		
		
		
		
		{
			JLabel lblProizvodi = new JLabel("Proizvodi:");
			lblProizvodi.setBounds(10, 55, 254, 20);
			contentPanel.add(lblProizvodi);
		}
		
		{
			this.cbProizvodi = new JComboBox(Utilities 
					.getDataAccessFactory().getProizvodDataAccess().Proizvodi()
					.toArray(new Proizvod[] {})); 
			this.cbProizvodi.setBounds(10, 72, 327, 20);
			contentPanel.add(this.cbProizvodi);
		}
		
		{
			JLabel lblKolicina = new JLabel("KOLICINA"); 
			lblKolicina.setBounds(10, 104, 80, 14);
			contentPanel.add(lblKolicina);
		}
		{
			this.tfKolicina = new JTextField();
			this.tfKolicina.setColumns(10);
			this.tfKolicina.setBounds(10, 118, 30, 20);
			contentPanel.add(this.tfKolicina);
		}
	
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Sačuvati");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						
						Racun r = (Racun)cbRacuni.getSelectedItem();
						Proizvod p = (Proizvod)cbProizvodi.getSelectedItem();
						BigDecimal cijena = new BigDecimal(p.getCijena());
						int kolicina = Integer.valueOf(tfKolicina.getText());
						
						Racun_Stavka racun_stavka = new Racun_Stavka(r,p, kolicina,cijena); 
						
						
						boolean rezultat;
						rezultat = Utilities.getDataAccessFactory().getRacun_StavkaDataAccess().dodaj_stavku(racun_stavka);
						if (!rezultat)
							JOptionPane.showMessageDialog(ovaj, "Stavka nije uspješno dodana!", "Poruka", JOptionPane.INFORMATION_MESSAGE);
						if (rezultat) {
							dialogResult = e.getActionCommand();
							ovaj.getToolkit().getSystemEventQueue().postEvent(new WindowEvent(ovaj, WindowEvent.WINDOW_CLOSING));
						}

					}
				}
				);
				okButton.setIcon(new ImageIcon(RacunDialog.class.getResource(Utilities.IMAGE_RESOURCES_PATH + "Check_14.png")));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Otkazati");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dialogResult = e.getActionCommand();
						ovaj.getToolkit().getSystemEventQueue().postEvent(new WindowEvent(ovaj, WindowEvent.WINDOW_CLOSING));
					}
				});
				cancelButton.setIcon(new ImageIcon(RacunDialog.class.getResource(Utilities.IMAGE_RESOURCES_PATH + "Cancel_14.png")));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
}
	
			
