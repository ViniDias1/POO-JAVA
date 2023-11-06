
public class Comum extends Conta {
    
    public Comum(String identificador){
        super(identificador);
    }   
    public void deposito(double valor) {
        super.deposito(valor);
    } 
    public void retirada(double valor){
        super.retirada(valor);
    }
    public double getSaldo() {
        return super.getSaldo();
    }
}
