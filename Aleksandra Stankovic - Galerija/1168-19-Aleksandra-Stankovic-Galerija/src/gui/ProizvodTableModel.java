package gui;

import java.util.List;
import javax.swing.table.AbstractTableModel;

import entity.Proizvod;

@SuppressWarnings("serial")
public class ProizvodTableModel extends AbstractTableModel {
	
	List<Proizvod> podaci;
	String[] kolone = new String[] { "Id Proizvoda", "Kategorija", "Ime", "Cijena" };

	public ProizvodTableModel(List<Proizvod> podaci) {
		setPodaci(podaci);
	}

	public void setPodaci(List<Proizvod> podaci) {
		this.podaci = podaci;
	}

	public Proizvod getProizvodAtRow(int rowIndex) {
		return podaci.get(rowIndex);
	}

	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}

	@Override
	public int getRowCount() {
		return podaci.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Proizvod red = podaci.get(rowIndex);
		if (columnIndex == 0)
			return red.getIdProizvod();
		else if (columnIndex == 1)
			return red.getKategorija().getNaziv();
		else if (columnIndex == 2)
			return red.getIme();
		else if (columnIndex == 3)
			return red.getCijena();
		
		else
			return null;
	}
	
}
