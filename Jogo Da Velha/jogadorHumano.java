/*
 * NOME: VINICIUS DIAS VALENCA
 * MATRICULA: 202100048850
 */
public class jogadorHumano {

    private char simbolo;
    int linha;
    int coluna;

    public jogadorHumano() {
        this.simbolo = ' ';
    }

    public jogadorHumano(char simbolo,int linha,int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public char obterSimbolo() { //!
            return simbolo;
        }

    public char obterSimbolo(char simbolo) {
        return simbolo;
    }

    public int obterLinha(int linha) {

        return this.linha = linha;
    }

    public int obterColuna(int coluna) {
        return this.coluna = coluna;
        
    }

    
}