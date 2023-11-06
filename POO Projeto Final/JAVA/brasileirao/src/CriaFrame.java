import java.awt.Color;

import javax.swing.JFrame;

public class CriaFrame{//cria o frame do grafico!
    private JFrame frame;
    
    public CriaFrame(CriaGrafico grafico){

        frame = new JFrame("Brasileirão Série A 2022");
        frame.add(grafico);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setBackground(new Color(34, 40, 49));//cor do frame
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//não encerra o programa apenas fecha a janela

    }
}