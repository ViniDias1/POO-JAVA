public class Especial extends Conta {
    public double limite; 
    public Especial(String identificador){
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
    public double jurosEspecial(double taxaE){
        return taxaE = (1+(taxaE/100));
    }
}
