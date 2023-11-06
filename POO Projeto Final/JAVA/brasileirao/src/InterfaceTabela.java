import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JScrollPane;


public class InterfaceTabela extends JFrame{
    private int largura_linha = 34;//em pixels
    private JTable tbl;
    private JScrollPane scroll;

    public InterfaceTabela(){
        initComponents();//inicializa os componentes
    }

    private void initComponents(){//inicializa os componentes da tabela
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fecha a janela ao sair
        tbl = new JTable();
        scroll = new JScrollPane(tbl);
        tbl.setModel(new ModeloTabela());
        tbl.setRowHeight(largura_linha);
        this.add(scroll);
        this.setVisible(true);
        this.setResizable(true);
        this.setBackground(new Color(34, 40, 49));
        tbl.setDefaultRenderer(Object.class, new RenderizaTabela());//setando renderizador
        tbl.getTableHeader().setReorderingAllowed(false);//desligando realinhamento de coluna!
        EventoDeMouse k = new EventoDeMouse(tbl);
        tbl.addKeyListener(k);
        tbl.addMouseListener(k);
        this.setTitle("Brasileirão Série A 2022");
    }
}