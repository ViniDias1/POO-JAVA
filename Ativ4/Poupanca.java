
class Poupanca extends Conta {

   public Poupanca(String identificador) {
      super(identificador);
   }  

   public void deposito(double valor) {
      super.deposito(valor);
   } 
   public void retirada(double valor){
      super.retirada(valor);
   }

   public double rendimento(double taxaP){
     return taxaP = (1+(taxaP/100));
   }
   public double getSaldo() {
      return super.getSaldo();
  }
   

}
