package gui;

import java.util.List;
import javax.swing.table.AbstractTableModel;

import entity.Racun;


@SuppressWarnings("serial")
public class RacunTableModel extends AbstractTableModel {
	
	List<Racun> podaci;
	String[] kolone = new String[] { "Id Racuna", "Cijena", "Vrijeme", "Zaposleni" };

	public RacunTableModel(List<Racun> podaci) {
		setPodaci(podaci);
	}

	public void setPodaci(List<Racun> podaci) {
		this.podaci = podaci;
	}

	public Racun getRacunAtRow(int rowIndex) {
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
		Racun red = podaci.get(rowIndex);
		
		if (columnIndex == 0)
			return red.getIdRacun();
		else if (columnIndex == 1)
			return red.getCijena();
		else if (columnIndex == 2)
			return red.getVrijeme();
		else if (columnIndex == 3)
			return red.getZaposleni(); 
		
		else
			return null;
	}
	
}
