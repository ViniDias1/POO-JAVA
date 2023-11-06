

public class Conjunto {

    //Classe conjunto

    //atributos da classe
    private int [] elementos;


    //metodos da classe

    public Conjunto () {
        elementos = new int [0];
    }

    public Conjunto(int [] vet) {
        int aux [] = new int[vet.length];
        int tamanho = 0;
        for (int i=0; i<vet.length;i++) {
            boolean achou = false;
            for (int j=0; j<tamanho;j++) {
                if (aux[j] == vet[i]) {
                    achou = true;
                    break;
                }
            }
            if (! achou) {
                aux[tamanho] = vet[i];
                tamanho += 1;
            }
        }
        elementos = new int[tamanho];
        for (int i=0; i<tamanho;i++) {
            elementos[i] = aux[i];
        }
    }

    public void atribuicao(int [] vet) {
        elementos = vet;
    }

    public Conjunto uniao(Conjunto outroConjunto) {
        Conjunto resultado = new Conjunto();
        int aux [] = new int[this.elementos.length + outroConjunto.elementos.length];
        int tamanho = elementos.length;



        for (int i=0; i<this.elementos.length;i++) {
            aux[i] = this.elementos[i];
        }

        for (int i = 0; i<outroConjunto.elementos.length; i++) {
            boolean achou = false;
            for (int j = 0; j<elementos.length;j++) {
                if (outroConjunto.elementos[i] == elementos[j]) {
                    achou = true;
                    break;
                }
            }
            if (achou == false) {
                aux[tamanho] = outroConjunto.elementos[i];
                tamanho += 1;
            }
        }
        int vetResultado [] = new int [tamanho];
        for (int i=0; i<tamanho;i++) {
            vetResultado[i] = aux[i];
        }
        resultado.atribuicao(vetResultado);

        return resultado;
    }
        
    public static void main(String[] args) {
        Conjunto A = new Conjunto();
        Conjunto B = new Conjunto();
        int vetA [] = {0,1,2};
        int vetB [] = {2,4};

        A.atribuicao(vetA);
        B.atribuicao(vetB);
        Conjunto C = A.uniao(B);

        System.out.print("A:");
        for (int i=0;i<A.elementos.length;i++) {
            System.out.print(""+ A.elementos[i]);
        }
        for (int i=0;i<B.elementos.length;i++) {
            System.out.print(""+ B.elementos[i]);
        }
        for (int i=0;i<C.elementos.length;i++) {
            System.out.print(""+ C.elementos[i]);
        }
    }
}
