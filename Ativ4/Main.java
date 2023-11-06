import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.Arrays;


public class Main {

    public static void main(String args[]) throws FileNotFoundException {
        File entrada = new File("c:/Programas Java/entrada4.txt");
        Scanner linhasEnt = new Scanner(entrada);
        int i = 0;
        String aux1 = "";
        String identificador = "1";
        String[] dados = new String[(int)entrada.length()];
        Conta contaC = new Conta(identificador);
        Especial contaE = new Especial(identificador);
        Poupanca contaP = new Poupanca(identificador);
        double valor;
        double taxaP = 0;
        double taxaE= 0 ;
        double limite = 0;
        String[] paraOrdenar = new String[3] ;
        while(linhasEnt.hasNext()) {
            aux1 = linhasEnt.nextLine();
            dados[i]= aux1;
            i++;
        }
        linhasEnt.close();
        for (i = 0;i<dados.length;i++){
            if (dados[i] == null) {
                break;
            }
            else{
                identificador = dados[i];
                int tamanhoIdent = identificador.length();
                int pontVir1 = dados[i].indexOf(";");
                int pontVir2 = dados[i].indexOf(";", pontVir1+1);
                int pontVir3 = dados[i].indexOf(";", pontVir2+1);
                String operacao = "";
                if ((dados[i].substring(pontVir1+1,tamanhoIdent)).equals("RO")){
                    operacao = "RO";
                }
                else{
                    operacao = (dados[i]).substring(pontVir1+1, pontVir2);
                }
                
                switch (operacao){
                    case "CA":
                        
                        String data = dados[i].substring(0,pontVir1);
                        String nome = dados[i].substring(pontVir2+1,dados[i].length());
                        Agencia agencia = new Agencia(nome);
                        break;
                    
                    case "CC":
                        identificador = dados[i].substring(pontVir2+1,tamanhoIdent);
                        contaC = new Conta(identificador);
                        
                        break;
                    case "CE":
                        identificador = dados[i].substring(pontVir2+1,pontVir3);
                        limite = Double.parseDouble(dados[i].substring(pontVir3+1,tamanhoIdent));
                        contaE = new Especial(identificador);
                        break;
                    case "CP":
                        identificador = dados[i].substring(pontVir2+1,tamanhoIdent);
                        contaP = new Poupanca(identificador);
                        break;

                    case "D":
                        identificador = dados[i].substring(pontVir2+1,pontVir3);
                        valor = Double.parseDouble(dados[i].substring(pontVir3+1,tamanhoIdent));
                        if (identificador.equals(contaC.ident())){
                            contaC.deposito(valor);
                        }
                        else{
                            if (identificador.equals(contaE.ident())){
                                contaE.deposito(valor); 
                            }
                            else {
                                if(identificador.equals(contaP.ident())){
                                    contaP.deposito(valor); 
                                }
                            }
                        }
                        break;

                    case "R":
                        identificador = dados[i].substring(pontVir2+1,pontVir3);
                        valor = Double.parseDouble(dados[i].substring(pontVir3+1,tamanhoIdent));
                        if (identificador.equals(contaC.ident())){
                            contaC.retirada(valor);
                        }
                        else{
                            if (identificador.equals(contaE.ident())){
                                contaE.retirada(valor); 
                            }
                            else {
                                if(identificador.equals(contaP.ident())){
                                    contaP.retirada(valor); 
                                }
                            }
                        }
                        break;
                        
                    case "VP":
                        taxaP = Double.parseDouble(dados[i].substring(pontVir2+1,tamanhoIdent));
                        contaP.rendimento(taxaP);
                        break;

                    case "VE":
                        taxaE = Double.parseDouble(dados[i].substring(pontVir2+1,tamanhoIdent));
                        contaE.jurosEspecial(taxaE);
                        break;


                    case "RO":
                        paraOrdenar[0] = contaC.ident()+" "+ contaC.getSaldo();
                        paraOrdenar[1] = contaE.ident()+" "+ (contaE.getSaldo() * contaE.jurosEspecial(taxaE)-limite);
                        paraOrdenar[2] = contaP.ident()+" "+ contaP.getSaldo() * contaP.rendimento(taxaP);
                        Arrays.sort(paraOrdenar);
                        for (int r = 0;r<paraOrdenar.length;r++){
                            System.out.println(paraOrdenar[r]);

                        }



                }
                
            }
            
        }
        

    }
    
}

