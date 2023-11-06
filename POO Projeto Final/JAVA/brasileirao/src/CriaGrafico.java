import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;


public class CriaGrafico extends JPanel{
    private String sigla_time;
    private int largura_linhas_eixos = 2;//largura das linha utilizadas nos eixos
    private int qtd_rodadas = 33;
    private int distancia_rotulos = 22;//OBS NÃO ALTERAR POIS É O VALOR BASE USADO NO GRAFICO
    private int pos_x;
    private int pos_y;
    private int baseY = 94;//valor base usados para acrescentar a distância dos rotulos
    private int baseX = 30;
    private int margemY = 65;//valor usado para padronizar as escalas dos elementos do grafico
    private int discrepancia_indicadores = -5;//discrepancia de posicao entre os distintos elementos do grafico

    public int[] historico;

    CriaGrafico(String sigla_time, int[] historico){
        setPreferredSize(new Dimension(800, 600));
        this.sigla_time = sigla_time;
        this.historico = historico;
    }
    
    @Override
    public void paint(Graphics g){
        insereEixos(g);
        insereRotulos(g);
        insereIndicadores(g);
        insereEscudo(g);
        insereLegendas(g);
    }

    public void insereEixos(Graphics g){
        Graphics2D g2d = (Graphics2D) g;//downcasting
        g2d.setStroke(new BasicStroke(largura_linhas_eixos));
        g2d.setPaint(new Color(238, 238, 238));
        g2d.drawLine(25, 85, 25, 515);//desenha eixo Y do grafico
        g2d.drawLine(25, 515, 600 + (5 * qtd_rodadas), 515);//desenha eixo X do grafico eixo X é variável de acordo com a quantidade de rodadas
    }

    public void insereRotulos(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        pos_x = 8;
        pos_y = baseY;
        for(int i=1; i<21; i++){//insere os rotulos de posicao(varia sobre o eixo Y)
            g2d.drawString(i + "", pos_x, pos_y);
            pos_y += distancia_rotulos;
        }
        pos_x = baseX + discrepancia_indicadores;
        pos_y = 528;
        for (int j=1; j < qtd_rodadas + 1; j++){//insere os rotulos de rodadas (varia sobre o eixo X)
            g2d.drawString(j + "", pos_x, pos_y);
            pos_x += distancia_rotulos;
        }
    }
    public void insereIndicadores(Graphics g){//dado historico(posicoes ao longo do campeonato)
        Graphics2D g2d = (Graphics2D) g;
        int contador = baseX;
        
        int buffer_x = baseX;
        int buffer_y = 0;

        for (int k=0; k < historico.length-1;k++){//insere as linhas do grafico
            buffer_x += distancia_rotulos;
            buffer_y  = margemY + (distancia_rotulos * historico[k + 1]);//armazena o valor da posicao na proxima rodada
            g2d.setPaint(new Color(0, 173, 181));
            g2d.drawLine(contador, margemY + (distancia_rotulos * historico[k]), buffer_x, buffer_y);
            contador += distancia_rotulos;
        }

        int contador2 = baseX;
        int buffer_posicao = 0;
        for (int x : historico){//insere os indicadores de vitoria(discrepancia adicionada ao calculo)
            if (buffer_posicao < x && buffer_posicao != 0){
                g2d.setPaint(Color.red);
                g2d.fillOval(contador2 + discrepancia_indicadores, margemY + discrepancia_indicadores + (distancia_rotulos * x), 10, 10);
            }
            else if (buffer_posicao > x && buffer_posicao != 0){
                g2d.setPaint(Color.green);
                g2d.fillOval(contador2 + discrepancia_indicadores, margemY + discrepancia_indicadores + (distancia_rotulos * x), 10, 10);
            }
            else{
                g2d.setPaint(Color.lightGray);
                g2d.fillOval(contador2 + discrepancia_indicadores, margemY + discrepancia_indicadores + (distancia_rotulos * x), 10, 10);
            }
            buffer_posicao = x;//atualizando o buffer
            contador2 += distancia_rotulos;
        }
    }
    public void insereLegendas(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(new Color(238, 238, 238));
        g2d.setFont(new Font("Serif", Font.BOLD, 20));
        g2d.drawString("RODADA x POSIÇÃO", 280, 570);
        g2d.drawString(Dados.traducao(sigla_time), 350, 30);
    }
    public void insereEscudo(Graphics g){
        Graphics g2d = (Graphics2D) g;
        Image escudo = new ImageIcon("../brasileirao/img/" + sigla_time + ".png").getImage();
        g2d.drawImage(escudo, 310, 10, null);
    }
    
    public void setRodadaFinal(int x){
        qtd_rodadas = x;
    }
}