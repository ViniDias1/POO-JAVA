/*
 * NOME: VINICIUS DIAS VALENCA
 * MATRICULA: 202100048850
 */


import java.util.Scanner;
public class Gerenciador {
    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        jogadorHumano p1 = new jogadorHumano();
        jogadorHumano p2 = new jogadorHumano();
        Tabuleiro tab = new Tabuleiro();
        System.out.println("     JOGO DA VELHA\n");
        System.out.println("REGRAS:\n-DIGITE A LINHA (0 - 2), DIGITE A COLUNA (0 - 2) E O SIMBOLO QUE ESCOLHEU EM |MAIUSCULO|");
        System.out.println("-OS SIMBOLOS DISPONIVEIS SAO: X e O\n");
        tab.apresentarPecas();
        
        for (int i = 0; i<6;i++){
            //System.out.println();
            tab.inserirPecas(p1.obterLinha(ent.nextInt()),p1.obterColuna(ent.nextInt()),p1.obterSimbolo(ent.next().charAt(0)));
            tab.apresentarPecas();
            if (tab.jogoEmpate() == true) {
                System.out.println("EMPATE");
            }
            if (tab.existeVencedor() == true) {
                System.out.println("PLAYER X WINS");
            }
            if (tab.fimJogo() == true) {
                System.out.println("JOGO ENCERRADO");
                break;
            }
            tab.inserirPecas(p2.obterLinha(ent.nextInt()),p2.obterColuna(ent.nextInt()),p2.obterSimbolo(ent.next().charAt(0)));
            tab.apresentarPecas();
            if (tab.jogoEmpate() == true) {
                System.out.println("EMPATE");
            }
            if (tab.existeVencedor() == true) {
                System.out.println("PLAYER O WINS");
            }
            if (tab.fimJogo() == true) {
                System.out.println("JOGO ENCERRADO");
                break;
            }

        }
        ent.close();
    }

}