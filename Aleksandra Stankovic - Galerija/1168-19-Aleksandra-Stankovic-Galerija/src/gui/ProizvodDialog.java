package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import entity.Proizvod;
import entity.Kategorija;
import util.Utilities;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class ProizvodDialog extends JDialog {
	
	private ProizvodDialog ovaj;
	private boolean izmena;
	private String dialogResult = "Cancel";

	private final JPanel contentPanel = new JPanel();
	private JTextField tfIdProizvoda; 
	private JTextField tfNazivProizvoda;
	private JTextField tfCijena;
	
	@SuppressWarnings("rawtypes")
	private JComboBox cbKategorija; 

	/**
	 * Create the dialog.
	 */
	public ProizvodDialog() {
		ovaj = this;
		izmena = false;

		initialize();
	}

	public ProizvodDialog(Proizvod proizvod) { //ovo je za izmjenu 
		ovaj = this;
		izmena = true;

		initialize();

		tfIdProizvoda.setText(Integer.toString(proizvod.getIdProizvod()));
		tfIdProizvoda.setEditable(false);
		tfNazivProizvoda.setText(proizvod.getIme());
		tfCijena.setText(Float.toString(proizvod.getCijena()));
		cbKategorija.setSelectedItem(proizvod.getKategorija().getNaziv()); 
	}

	public String getDialogResult() {
		return dialogResult;
	}
	

	private boolean proveriValidnostPolja() {
		if (tfIdProizvoda.getText().length() == 0) {
			JOptionPane.showMessageDialog(ovaj,
					"Identifikator proizvoda nije popunjen!", "Greška",
					JOptionPane.ERROR_MESSAGE);
		} else if (!(Utilities.tryParseInt(tfIdProizvoda.getText()))
				|| Integer.valueOf(tfIdProizvoda.getText()) < 1) {  
			JOptionPane.showMessageDialog(ovaj,
					"Identifikator proizvoda nije pravilno popunjen!", "Greška",
					JOptionPane.ERROR_MESSAGE);
		} else if (tfNazivProizvoda.getText().length() == 0) {
			JOptionPane.showMessageDialog(ovaj,
					"Naziv proizvoda nije popunjen!", "Greška",
					JOptionPane.ERROR_MESSAGE);
		} else if (!(Utilities.isTextValid(tfNazivProizvoda.getText()))) {
			JOptionPane.showMessageDialog(ovaj,
					"Naziv proizvoda nije pravilno popunjen!", "Greška", 
					JOptionPane.ERROR_MESSAGE);
		} else if (tfCijena.getText().length() == 0) {
			JOptionPane.showMessageDialog(ovaj, "Cijena nije upisana!",
					"Greška", JOptionPane.ERROR_MESSAGE);
		} else if (!(Utilities.tryParseFloat(tfCijena.getText()))
				|| Float.valueOf(tfCijena.getText()) <= 0) {
			JOptionPane.showMessageDialog(ovaj,
					"Cijena nije pravilno popunjena!", "Greška",
					JOptionPane.ERROR_MESSAGE);
		}  else
			return true;
		return false;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Proizvod");
		setBounds(100, 100, 355, 220);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(this.contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblIdentifikator = new JLabel("Identifikator:");
			lblIdentifikator.setBounds(10, 11, 327, 14);
			contentPanel.add(lblIdentifikator);
		}
		{
			this.tfIdProizvoda = new JTextField();
			this.tfIdProizvoda.setColumns(10);
			this.tfIdProizvoda.setBounds(10, 25, 327, 20);
			contentPanel.add(this.tfIdProizvoda);
		}
		{
			JLabel lblNazivProizvoda = new JLabel("Naziv proizvoda:");
			lblNazivProizvoda.setBounds(10, 59, 327, 14);
			contentPanel.add(lblNazivProizvoda);
		}
		{
			this.tfNazivProizvoda = new JTextField();
			this.tfNazivProizvoda.setColumns(10);
			this.tfNazivProizvoda.setBounds(10, 73, 327, 20);
			contentPanel.add(this.tfNazivProizvoda);
		}
		{
			JLabel lblCijena = new JLabel("CIJENA"); 
			lblCijena.setBounds(10, 104, 80, 14);
			contentPanel.add(lblCijena);
		}
		{
			this.tfCijena = new JTextField();
			this.tfCijena.setColumns(10);
			this.tfCijena.setBounds(10, 118, 30, 20);
			contentPanel.add(this.tfCijena);
		}
		{
			JLabel lblKategorija = new JLabel("Kategorija:"); 
			lblKategorija.setBounds(60, 104, 277, 14);
			contentPanel.add(lblKategorija);
		}
		{
			this.cbKategorija = new JComboBox(Utilities 
					.getDataAccessFactory().getKategorijaDataAccess().Kategorije("*")
					.toArray(new Kategorija[] {})); 
			this.cbKategorija.setBounds(60, 118, 277, 20);
			contentPanel.add(this.cbKategorija);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
				JButton okButton = new JButton("Sačuvati"); 
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (proveriValidnostPolja()) {
							
							int idProizvod = Integer.valueOf(tfIdProizvoda.getText());
							Kategorija k = (Kategorija)cbKategorija.getSelectedItem();
							
							String ime = tfNazivProizvoda.getText();
							float cijena = Float.valueOf(tfCijena.getText());
							
							Proizvod proizvod = new Proizvod(idProizvod,k,ime,cijena);  
							
							boolean rezultat;
							
							if (izmena) { 
								rezultat = Utilities.getDataAccessFactory()
										.getProizvodDataAccess() 
										.azurirajProizvod(proizvod);
								if (!rezultat)
									JOptionPane.showMessageDialog(ovaj,
											"Proizvod nije uspešno ažuriran!",
											"Poruka",
											JOptionPane.INFORMATION_MESSAGE);
							} else {
								rezultat = Utilities.getDataAccessFactory()
										.getProizvodDataAccess().dodajProizvod(proizvod);
								if (!rezultat)
									JOptionPane.showMessageDialog(ovaj,
											"Proizvod nije uspešno dodan!",
											"Poruka",
											JOptionPane.INFORMATION_MESSAGE);
							}
							if (rezultat) {
								dialogResult = e.getActionCommand();
								ovaj.getToolkit()
										.getSystemEventQueue()
										.postEvent(
												new WindowEvent(
														ovaj,
														WindowEvent.WINDOW_CLOSING));
							}

						}
					}
				});
				okButton.setIcon(new ImageIcon(ProizvodDialog.class
						.getResource(Utilities.IMAGE_RESOURCES_PATH + "Check_14.png")));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Otkazati");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dialogResult = e.getActionCommand();
						ovaj.getToolkit()
								.getSystemEventQueue()
								.postEvent(
										new WindowEvent(ovaj,
												WindowEvent.WINDOW_CLOSING));
					}
				});
				cancelButton
						.setIcon(new ImageIcon(
								ProizvodDialog.class
										.getResource(Utilities.IMAGE_RESOURCES_PATH + "Cancel_14.png")));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
}
