/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.view;

import br.com.modelo.negocio.Marca;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author anderson_feliciano
 */
public class MarcaTableModel extends AbstractTableModel {

    private static final int COL_ID = 0;
    private static final int COL_NOME = 1;
    private List<Marca> linhas;
    private String[] colunas = {"Id", "Nome"};

    public MarcaTableModel() {
        linhas = new ArrayList<Marca>();
    }

    public MarcaTableModel(List<Marca> marcas) {
        linhas = marcas;
    }

    /**
     * Retorna a quantidade de linhas da tabela
     */
    public int getRowCount() {
        return linhas.size();
    }

    /**
     * Retorna a quantidade de colunas
     */
    public int getColumnCount() {
        return colunas.length;
    }
    /*
     * Retorna o nome da coluna
     */

    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];

    }
    /*
     * Retorna a classe de cada coluna
     */

    public Class getColumnClass(int columnindex) {
        if (columnindex == COL_ID) {
            return Integer.class;
        } else if (columnindex == COL_NOME) {
            return String.class;

        }
        return null;
    }

    /**
     * Retorna os dados do abjeto da linha
     *
     */
    public Object getValueAt(int rowIndex, int columnIndex) {
        //Pegar conteudo da linha
        Marca m = linhas.get(rowIndex);

        if (columnIndex == COL_ID) {
            return m.getId();

        } else if (columnIndex == COL_NOME) {
            return m.getNome();

        }
        return " ";

    }

    /*
     * Altera os dados de uma linha 
     */
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Marca m = linhas.get(rowIndex);
        if (columnIndex == COL_ID) {
            m.setId((Integer) aValue);
        } else if (columnIndex == COL_NOME) {
            m.setNome(aValue.toString());
        }
    }
    /*
     * Indica se a célula é editavel
     */

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    /*
     * Retorna a merca referente a linha especifica
     */

    public Marca getMarca(int indiceLinha) {
        return linhas.get(indiceLinha);
    }
    /*
     * Adiciona a marca especifica ao modelo
     */

    public void addMarca(Marca marca) {
        //Adiciona o registro
        linhas.add(marca);

        //Pega a quantidade de registros (Os registros começam com zero)
        int ultimoIndice = getRowCount() - 1;

        //Notifica a mudança
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    /*
     * Atualiza uma linha
     */
    public void updateMarca(int indiceLinha, Marca marca) {
        linhas.set(indiceLinha, marca);
        fireTableRowsUpdated(indiceLinha, indiceLinha);
    }
    /*
     * Remove uma linha
     */

    public void removeMarca(int indiceLinha) {
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);

    }

    /*
     * Remove todos os registros
     */
    public void limpar() {
        linhas.clear();
    }
}
