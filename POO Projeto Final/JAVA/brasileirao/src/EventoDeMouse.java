import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

public class EventoDeMouse extends MouseAdapter implements KeyListener{
    private JTable tabela;

    public EventoDeMouse(JTable tabela){
        this.tabela = tabela;

    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){//tecla clicada (ENTER) na coluna 9
            if (tabela.getSelectedColumn() == 9){
                String sigla_time = "";
                String pos_time = (String) tabela.getValueAt(tabela.getSelectedRow(), 0);
                if (pos_time.substring(1, 2).equals("º")){
                    sigla_time = Dados.traducao(pos_time.substring(3, pos_time.length()));//ignorando a posicao do time
                }
                else{
                    sigla_time = Dados.traducao(pos_time.substring(4, pos_time.length()));//ignorando a posicao do time
                }
                new CriaFrame(new CriaGrafico(sigla_time, Dados.getTimeBySigla(sigla_time).getHistorico()));//cria o gráfico
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {   
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (tabela.getSelectedColumn() == 9){//mouse clicado na coluna 9
            String sigla_time = "";
            String pos_time = (String) tabela.getValueAt(tabela.getSelectedRow(), 0);
            if (pos_time.substring(1, 2).equals("º")){
                sigla_time = Dados.traducao(pos_time.substring(3, pos_time.length()));//ignorando a posicao do time
            }
            else{
                sigla_time = Dados.traducao(pos_time.substring(4, pos_time.length()));//ignorando a posicao do time
            }
            new CriaFrame(new CriaGrafico(sigla_time, Dados.getTimeBySigla(sigla_time).getHistorico()));//cria o gráfico
        }
    }
}