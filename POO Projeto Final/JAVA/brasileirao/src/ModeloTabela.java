import javax.swing.table.AbstractTableModel;

public class ModeloTabela extends AbstractTableModel{//modelo utilizado para extracao de dados para a JTable
    private String colunas[] = {"Time", "Pontos", "Partidas", "Vitórias", "Empates", "Derrotas",
    "Saldo de Gols", "Gols Pró", "Gols Contra", " "};//ultima coluna vazia para botao
    //SOBRESCREVENDO OS METODOS DE AbstractTableModel
    @Override
    public int getRowCount() {
        return Dados.array_siglas.length;
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    @Override
    public String getColumnName(int num){
        return colunas[num];
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {//desligando a edicao de celula
        return false;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0){//retornando para a coluna 0 dados formatados com a colocacao
            String time = Dados.getTimeBySigla(Dados.chaves_ordenadas[rowIndex]).getNome();
            return (rowIndex + 1) + "º " + time;
        }
        else if (columnIndex == 9){//caso a coluna seja a ultima, e retornado valor nulo para 
            return null;//ser renderizado como botao
        }
        else{
            return Dados.getTimeBySigla(Dados.chaves_ordenadas[rowIndex]).getStats()[columnIndex -1];
        }
    }
}
