
class Pilha<T> {
    /* Atributo */
    private T[] vet;
    private int topo;

    /* Metodos */
    public Pilha (int size) {
        vet = (T[]) new Object[size];
        topo = 0;
    }

    public void empilha (T item) {
        if (topo < vet.length)
        {
            vet[topo] = item;
            topo++;
        }
    }

    public T desempilha () {
        if (topo > 0) {
            topo--;
            return vet[topo];
        }
        else
            throw new ArrayIndexOutOfBoundsException();
    }

    public void clear () {
        topo = 0;
    }

    public String toString () {
        String aux = "";
        if (topo == 0)
            return "";
        for (int i=0; i<topo-1; i++)
            aux += vet[i].toString() + " - "; 
        aux += vet[topo-1];
        return aux;
    }
}