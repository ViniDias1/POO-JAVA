import java.util.Scanner;

class revisaoPROF{
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        Pilha <Integer> pi = new Pilha <> (100);
        String linha = keyboard.next();

        while (!linha.equals("F")){
            String[] termo = linha.split(",");

            for (int i = 0;i<termo.length;i++){
                if (termo[i].equals("+")){
                    Integer op1 = pi.desempilha();
                    Integer op2 = pi.desempilha();
                    Integer resultado = op1 + op2;
                    pi.empilha(resultado);
                }
                else if (termo[i].equals("")){
                    Integer op1 = pi.desempilha();
                    Integer op2 = pi.desempilha();
                    Integer resultado = op2 - op1;
                    pi.empilha(resultado);
                }
                else if (termo[i].equals("*")){
                    Integer op1 = pi.desempilha();
                    Integer op2 = pi.desempilha();
                    Integer resultado = op1 * op2;
                    pi.empilha(resultado);
                }
                else if (termo[i].equals("/")){
                    Integer op1 = pi.desempilha();
                    Integer op2 = pi.desempilha();
                    Integer resultado = op2 / op1;
                    pi.empilha(resultado);
                }
                else{
                    Integer op = Integer.parseInt(termo[i]);
                    pi.empilha(op);
                }
            }
            System.out.println(pi);
            pi.clear();
            
        }
        linha = keyboard.next();
        keyboard.close();
    }
    

    
}