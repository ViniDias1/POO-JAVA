import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class RenderizaTabela implements TableCellRenderer{//renderiza a tabela

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,int row, int column){
        table.getTableHeader().setBackground(new Color(57, 62, 70));//seta cor do background do header
        table.getTableHeader().setForeground(new Color(238, 238, 238));//seta cor da fonte do header
        if (value != null){//caso nao seja a ultima coluna cria um label dentro de um panel com o valor de value
            JPanel p = new JPanel();
            p.setBackground(new Color(34, 40, 49));
            JLabel l = new JLabel(value.toString());
            l.setForeground(new Color(238, 238, 238));
            p.add(l);
            return p;
        }
        JButton b = new JButton("Detalhes");
        b.setBackground(new Color(0, 173, 181));
        return b;//retorna o botao detalhes
    }
}