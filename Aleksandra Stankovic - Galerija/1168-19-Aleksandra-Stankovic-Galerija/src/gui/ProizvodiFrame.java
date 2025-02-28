package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;

import javax.swing.ImageIcon;
import entity.Proizvod;
import util.Utilities;

import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

@SuppressWarnings("serial")
public class ProizvodiFrame extends JFrame {
	
	private ProizvodiFrame ovaj;
	private List<Proizvod> Proizvodi;

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panelPodaci;
	private JPanel panelOpcije;
	private JButton btnDodati;
	private JButton btnIzmeniti;
	private JButton btnObrisati;
	private JScrollPane scrollPane;
	private JTable table;


	public ProizvodiFrame() {
		ovaj = this;
		Proizvodi = Utilities.getDataAccessFactory().getProizvodDataAccess()
				.Proizvodi();

		initialize();
	}

	private void osveziTabelu() { 
		 {
			Proizvodi = Utilities.getDataAccessFactory().getProizvodDataAccess()
					.Proizvodi();

			ProizvodTableModel ftm = (ProizvodTableModel) table.getModel();
			ftm.setPodaci(Proizvodi);
			ftm.fireTableDataChanged();
		}
	}

	private void initialize() {
		setTitle("Proizvodi");
		setBounds(100, 100, 815, 420);
		setLocationRelativeTo(null);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.contentPane.add(getPanel(), BorderLayout.NORTH);
		this.contentPane.add(getPanelPodaci(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getPanelOpcije(), BorderLayout.NORTH);
			
		}
		return panel;
	}

	private JPanel getPanelPodaci() {
		if (panelPodaci == null) {
			panelPodaci = new JPanel();
			panelPodaci.setLayout(new BorderLayout(0, 0));
			panelPodaci.add(getScrollPane(), BorderLayout.CENTER);
		}
		return panelPodaci;
	}

	private JPanel getPanelOpcije() {
		if (panelOpcije == null) {
			panelOpcije = new JPanel();
			panelOpcije.setLayout(null);
			panelOpcije.setPreferredSize(new Dimension(200, 68));
			panelOpcije.add(getBtnDodati());
			panelOpcije.add(getBtnIzmeniti());
			panelOpcije.add(getBtnObrisati());
		}
		return panelOpcije;
	}


	
	private JButton getBtnDodati() {
		if (btnDodati == null) {
			btnDodati = new JButton("");
			btnDodati.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ProizvodDialog fd = new ProizvodDialog();
					fd.setVisible(true);
					if (fd.getDialogResult().equalsIgnoreCase("OK")) {
						osveziTabelu();
						JOptionPane.showMessageDialog(ovaj,
								"Novi Proizvod je uspešno dodan!", "Poruka",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			btnDodati.setToolTipText("Dodati novi proizvod");
			btnDodati.setIcon(new ImageIcon(ProizvodiFrame.class
					.getResource(Utilities.IMAGE_RESOURCES_PATH + "Add_32.png")));
			btnDodati.setBounds(0, 0, 58, 58);
		}
		return btnDodati;
	}

	
	
	
	private JButton getBtnIzmeniti() {
		if (btnIzmeniti == null) {
			btnIzmeniti = new JButton("");
			btnIzmeniti.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (table.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(ovaj, "Proizvod nije odabran!", "Greška", JOptionPane.ERROR_MESSAGE);
					} else {
						Proizvod odabraniProizvod = ((ProizvodTableModel) table.getModel()).getProizvodAtRow(table.getSelectedRow());
						ProizvodDialog fd = new ProizvodDialog(odabraniProizvod);
						fd.setVisible(true);
						if (fd.getDialogResult().equalsIgnoreCase("OK")) {
							osveziTabelu();
							JOptionPane.showMessageDialog(ovaj, "Proizvod je uspješno ažuriran!", "Poruka", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			});
			btnIzmeniti.setToolTipText("Izmijeniti odabrani proizvod");
			btnIzmeniti.setIcon(new ImageIcon(ProizvodiFrame.class.getResource(Utilities.IMAGE_RESOURCES_PATH + "Edit_32.png")));
			btnIzmeniti.setBounds(68, 0, 58, 58);
		}
		return btnIzmeniti;
	}
	
	
	
	

	private JButton getBtnObrisati() {
		if (btnObrisati == null) {
			btnObrisati = new JButton("");
			btnObrisati.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (table.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(ovaj,
								"Proizvod nije odabran!", "Greška",
								JOptionPane.ERROR_MESSAGE);
					} else {
						Proizvod odabraniProizvod = ((ProizvodTableModel) table
								.getModel()).getProizvodAtRow(table
								.getSelectedRow());
						int odabir = JOptionPane
								.showOptionDialog(
										ovaj,
										"Da li ste sigurni da želite obrisati odabrani Proizvod?",
										"Potvrda brisanja",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.QUESTION_MESSAGE, null,
										Utilities.YES_NO_OPTIONS,
										Utilities.YES_NO_OPTIONS[1]);
						if (odabir == JOptionPane.YES_OPTION) {
							if (Utilities
									.getDataAccessFactory()
									.getProizvodDataAccess()
									.obrisiProizvod(odabraniProizvod.getIdProizvod())) {
								osveziTabelu();
								JOptionPane.showMessageDialog(ovaj,
										"Proizvod je uspešno obrisan!",
										"Poruka",
										JOptionPane.INFORMATION_MESSAGE);
							} else
								JOptionPane.showMessageDialog(ovaj,
										"Proizvod nije uspešno obrisan!",
										"Poruka",
										JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			});
			btnObrisati.setToolTipText("Obrisati odabrani Proizvod");
			btnObrisati.setIcon(new ImageIcon(ProizvodiFrame.class
					.getResource(Utilities.IMAGE_RESOURCES_PATH + "Delete_32.png")));
			btnObrisati.setBounds(136, 0, 58, 58);
		}
		return btnObrisati;
	}



	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane
					.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable(new ProizvodTableModel(Proizvodi));
			table.setFillsViewportHeight(true);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.getColumnModel().getColumn(0).setPreferredWidth(300);
			table.getColumnModel().getColumn(1).setPreferredWidth(450);
		}
		return table;
	}
	
}
