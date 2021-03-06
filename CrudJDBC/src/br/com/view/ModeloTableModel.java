/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.view;

import br.com.modelo.negocio.Marca;
import br.com.modelo.negocio.Modelo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author anderson_feliciano
 */
public class ModeloTableModel extends AbstractTableModel {
                                    //COLUNAS
    private static final int COL_ID = 0;
    private static final int COL_DESCRICAO = 1;
    private static final int COL_POTENCIA = 2;
    private static final int COL_MARCA = 3;
    private List<Modelo> linhas;
    private String[] colunas = {"Id", "Descricao", "Potencia","Marca"};

    public ModeloTableModel() {
        linhas = new ArrayList<Modelo>();
    }

    public ModeloTableModel(List<Modelo> modelos) {
        linhas = modelos;
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

    public Class getColumnClass(int columnIndex) {
        if (columnIndex == COL_ID) {
            return Integer.class;
        } else if (columnIndex == COL_DESCRICAO) {
            return String.class;

        } else if (columnIndex == COL_POTENCIA) {
            return Integer.class;

        } else if (columnIndex == COL_MARCA) {
            return Marca.class;

        }
        return null;
    }

    /**
     * Retorna os dados do abjeto da linha
     *
     */
    public Object getValueAt(int rowIndex, int columnIndex) {
        //Pegar conteudo da linha
        Modelo m = linhas.get(rowIndex);

        if (columnIndex == COL_ID) {
            return m.getId();

        } else if (columnIndex == COL_DESCRICAO) {
            return m.getDescrição();

        } else if (columnIndex == COL_POTENCIA) {
            return m.getPotencia();

        } else if (columnIndex == COL_MARCA) {
            return m.getMarca();

        }
        return " ";

    }

    /*
     * Altera os dados de uma linha 
     */
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Modelo m = linhas.get(rowIndex);
        if (columnIndex == COL_ID) {
            m.setId((Integer) aValue);
        } else if (columnIndex == COL_DESCRICAO) {
            m.setDescrição(aValue.toString());
        }
         else if (columnIndex == COL_POTENCIA) {
            m.setPotencia((Integer)aValue);
        }
         else if (columnIndex == COL_MARCA) {
            m.setMarca((Marca)aValue);
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

    public Modelo getModelo(int indiceLinha) {
        return linhas.get(indiceLinha);
    }
    /*
     * Adiciona a modelo especifica ao modelo
     */

    public void addModelo(Modelo modelo) {
        //Adiciona o registro
        linhas.add(modelo);

        //Pega a quantidade de registros (Os registros começam com zero)
        int ultimoIndice = getRowCount() - 1;

        //Notifica a mudança
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    /*
     * Atualiza uma linha
     */
    public void updateModelo(int indiceLinha, Modelo modelo) {
        linhas.set(indiceLinha, modelo);
        fireTableRowsUpdated(indiceLinha, indiceLinha);
    }
    /*
     * Remove uma linha
     */

    public void removeModelo(int indiceLinha) {
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
