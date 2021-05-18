package modelo.tablas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class FormatoTabla {

    public void llenarTabla(JTable tabla, ArrayList<Object> columnas, ArrayList<Object[]> filas) {
        DefaultTableModel modeloLista = new DefaultTableModel();

        for (Object columna : columnas) {
            modeloLista.addColumn(columna);
        }
        for (Object[] fila : filas) {
            modeloLista.addRow(fila);
        }
        tabla.setModel(modeloLista);
    }
}
