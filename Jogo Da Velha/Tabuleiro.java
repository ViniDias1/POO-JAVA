/*
 * NOME: VINICIUS DIAS VALENCA
 * MATRICULA: 202100048850
 */

public class Tabuleiro {

    private char[][] peca = new char[3][3];

    public Tabuleiro() {
        this.peca[0][0] = peca[0][0];
    }

    public int inserirPecas(int linha,int coluna,char simbolo) {
  
        int verf = 0;
        if (linha+coluna>4 || linha+coluna<0) {
            verf = -1;
        }

        else if (simbolo != 'X' && simbolo != 'O'){
            verf = -1;
        }

        else if (peca[linha][coluna] == 'X' || peca[linha][coluna] == 'O'){
            verf = -1;
        }

        else {
            verf = 1;
        }

        if (verf == 1){
            peca[linha][coluna] = simbolo;
        }
        return verf;
    }
    
    public void apresentarPecas() {

        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (peca[i][j] != 'X' && peca[i][j] != 'O'){
                    peca[i][j] = '-';
                }
            }
        }
        System.out.println("     "+"C0"+"   C1"+ "  C2");
        System.out.println("L0" +"    " + peca[0][0]+" "+"|" +" "+peca[0][1]+" " + "|"+" "+peca[0][2]+"   ");
        System.out.println("   "+"-----+---+-----");
        System.out.println("L1" +"    " + peca[1][0]+" "+"|" +" "+peca[1][1]+" " + "|"+" "+peca[1][2]+"   ");
        System.out.println("   "+"-----+---+-----");
        System.out.println("L2" +"    " + peca[2][0]+" "+"|" +" "+peca[2][1]+" " + "|"+" "+peca[2][2]+"   \n");

    }

    public boolean existeVencedor() {
        boolean vence = false;
        //por linha
        if (peca[0][0] == 'X' && peca[0][1] == 'X' && peca[0][2] == 'X' || peca[0][0] == 'O' && peca[0][1] == 'O' && peca[0][2] == 'O'){
            vence = true;
        }
        else if (peca[1][0] == 'X' && peca[1][1] == 'X' && peca[1][2] == 'X' || peca[1][0] == 'O' && peca[1][1] == 'O' && peca[1][2] == 'O'){
            vence = true;
        }
        else if (peca[2][0] == 'X' && peca[2][1] == 'X' && peca[2][2] == 'X' || peca[2][0] == 'O' && peca[2][1] == 'O' && peca[2][2] == 'O'){
            vence = true;
        }
        
        //por coluna
        else if (peca[0][0] == 'X' && peca[1][0] == 'X' && peca[2][0] == 'X' || peca[0][0] == 'O' && peca[1][0] == 'O' && peca[2][0] == 'O'){
            vence = true;
        }
        else if (peca[0][1] == 'X' && peca[1][1] == 'X' && peca[2][1] == 'X' || peca[0][1] == 'O' && peca[1][1] == 'O' && peca[2][1] == 'O'){
            vence = true;
        }
        else if (peca[0][2] == 'X' && peca[1][2] == 'X' && peca[2][2] == 'X' || peca[0][2] == 'O' && peca[1][2] == 'O' && peca[2][2] == 'O'){
            vence = true;
        }

        //por diagonal
        else if (peca[0][0] == 'X' && peca[1][1] == 'X' && peca[2][2] == 'X' || peca[0][0] == 'O' && peca[1][1] == 'O' && peca[2][2] == 'O'){
            vence = true;
        }
        else if (peca[0][2] == 'X' && peca[1][1] == 'X' && peca[2][0] == 'X' || peca[0][2] == 'O' && peca[1][1] == 'O' && peca[2][0] == 'O'){
            vence = true;
        }

        return vence;
    }

    public boolean jogoEmpate() {
        int cont = 0;
        for (int k=0;k<3;k++){
            for (int l=0;l<3;l++){
                if (peca[k][l] == '-'){
                    cont++;
                    break;
                }
            }
        }
        if (cont == 0 && this.existeVencedor() == false) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean fimJogo() {
        if (this.existeVencedor() == true || this.jogoEmpate() == true) {
            return true;
        }
        else {
            return false;
        }
    }
}