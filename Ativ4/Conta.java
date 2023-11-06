
class Conta {
    protected double saldo;
    protected String identificador;
    


    public Conta(String identificador) {
        this.identificador = identificador;
    }
    public String ident(){
        return identificador;
    }

    public void deposito(double valor) {
        saldo = saldo + valor;
    }
    public void retirada(double valor){
        this.saldo = saldo - valor;
    }
    public double getSaldo() {
        return this.saldo;
    }
}