import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Dados extends Time{//A classe dados contém times
    private Historico calculador_historico;
    protected static String chaves_ordenadas[];
    protected static Time times[];//array de times
    protected static final String array_siglas[] = {"FLA", "PAL", "FLU", "SAO", "SAN", "CAM", "CAP", "CFC", "COR", "FOR", "BOT", "JUV",
    "CUI", "GOI", "BRA", "ACG", "INT", "CEA", "AVA", "AMG"};
    protected static final String array_nomes[] = {"Flamengo", "Palmeiras", "Fluminense", "São Paulo", "Santos", "Atlético Mineiro",
    "Athlético Paranaense", "Coritiba", "Corinthians", "Fortaleza", "Botafogo", "Juventude", "Cuiabá", "Goiás", "Bragantino", "Atlético Goianiense", "Internacional", "Ceará", "Avaí", "América Mineiro"};

    public Dados(){
        calculador_historico = new Historico();
        times = new Time[20];
        for (int i=0; i<20; i++){//CRIA O OBJETO TIME COM O NOME, SIGLA E POSICAO DOS ARRAYS ACIMA
            times[i] = new Time(array_nomes[i], array_siglas[i]);
        }
    }

    public static Time getTimeBySigla(String sigla){//retorna um Objeto Time de acordo com a sigla
        return times[Arrays.asList(array_siglas).indexOf(sigla)];
    }

    public static Time getTimeByNome(String nome){//retorna um Objeto time de acordo com o nome
        return times[Arrays.asList(array_nomes).indexOf(nome)];
    }

    public static String traducao(String traducao){//se passada uma sigla retorna o nome e vice-versa
        if (traducao.length() == 3){
            return array_nomes[Arrays.asList(array_siglas).indexOf(traducao)];
        }
        else{
            return array_siglas[Arrays.asList(array_nomes).indexOf(traducao)];

        }
        
    }
    public void computaDados(String nome_arq) throws IOException{//realiza os calculos de dados
        BufferedReader buffer = new BufferedReader(new FileReader(nome_arq));
        for(int i=0; i<33; i++){
            String jogos[] = buffer.readLine().split(",");
            for (int j=0; j<10; j++){
                Time time1 = getTimeBySigla(jogos[j].substring(0, 3));
                Time time2 = getTimeBySigla(jogos[j].substring(6, 9));

                int gol_time1 = Integer.parseInt(jogos[j].substring(4, 5));
                int gol_time2 = Integer.parseInt(jogos[j].substring(10,11));

                if (gol_time1 > gol_time2){
                    //TIME 1 VENCEU
                    time1.setPontos(time1.getPontos() + 3);//contabiliza pontos
                    time1.setPartidas(time1.getPartidas() + 1);//contabiliza partidas
                    time1.setVitorias(time1.getVitorias() + 1);//VITORIA
                    time1.setSaldo(time1.getSaldo() + (gol_time1 - gol_time2));//contabiliza saldo
                    time1.setGolsPro(time1.getGolsPro() + gol_time1);//contabiliza gols pro
                    time1.setGolsContra(time1.getGolsContra() + gol_time2);//contabiliza gols contra

                    //TIME 2 PERDEU
                    time2.setPontos(time2.getPontos() + 0);//contabiliza pontos
                    time2.setPartidas(time2.getPartidas() + 1);//contabiliza partidas
                    time2.setDerrotas(time2.getDerrotas() + 1);//DERROTA
                    time2.setSaldo(time2.getSaldo() + (gol_time2 - gol_time1));//contabiliza saldo
                    time2.setGolsPro(time2.getGolsPro() + gol_time2);//contabiliza gols pro
                    time2.setGolsContra(time2.getGolsContra() + gol_time1);//contabiliza gols contra
                }
                else if (gol_time1 < gol_time2){
                    //TIME 2 VENCEU
                    time2.setPontos(time2.getPontos() + 3);//contabiliza pontos
                    time2.setPartidas(time2.getPartidas() + 1);//contabiliza partidas
                    time2.setVitorias(time2.getVitorias() + 1);//VITORIA
                    time2.setSaldo(time2.getSaldo() + (gol_time2 - gol_time1));//contabiliza saldo
                    time2.setGolsPro(time2.getGolsPro() + gol_time2);//contabiliza gols pro
                    time2.setGolsContra(time2.getGolsContra() + gol_time1);//contabiliza gols contra 

                    //TIME 1 PERDEU
                    time1.setPontos(time1.getPontos() + 0);//contabiliza pontos
                    time1.setPartidas(time1.getPartidas() + 1);//contabiliza partidas
                    time1.setDerrotas(time1.getDerrotas() + 1);//DERROTA
                    time1.setSaldo(time1.getSaldo() + (gol_time1 - gol_time2));//contabiliza saldo
                    time1.setGolsPro(time1.getGolsPro() + gol_time1);//contabiliza gols pro
                    time1.setGolsContra(time1.getGolsContra() + gol_time2);//contabiliza gols contra
                }
                else{
                    //TIME 1 EMPATOU
                    time1.setPontos(time1.getPontos() + 1);//contabiliza pontos
                    time1.setPartidas(time1.getPartidas() + 1);//contabiliza partidas
                    time1.setEmpates(time1.getEmpates() + 1);//EMPATE
                    time1.setSaldo(time1.getSaldo() + (gol_time1 - gol_time2));//contabiliza saldo
                    time1.setGolsPro(time1.getGolsPro() + gol_time1);//contabiliza gols pro
                    time1.setGolsContra(time1.getGolsContra() + gol_time2);//contabiliza gols contra

                    //TIME 2 EMPATOU
                    time2.setPontos(time2.getPontos() + 1);//contabiliza pontos
                    time2.setPartidas(time2.getPartidas() + 1);//contabiliza partidas
                    time2.setEmpates(time2.getEmpates() + 1);//EMPATE
                    time2.setSaldo(time2.getSaldo() + (gol_time2 - gol_time1));//contabiliza saldo
                    time2.setGolsPro(time2.getGolsPro() + gol_time2);//contabiliza gols pro
                    time2.setGolsContra(time2.getGolsContra() + gol_time1);//contabiliza gols contra 
                }
            }
            calculador_historico.calculaHistorico(i);
        }
        buffer.close();
    }

    public class OrdenaTimes{
        protected String chaves[];
        OrdenaTimes(){
            chaves = new String[20];
            for (int k=0; k<20; k++){//fazendo uma copia das siglas
                chaves[k] = array_siglas[k];
            }
        }
        public String[] inOrder(){
            for (int i=1;i<chaves.length;i++){
                for (int j=0; j<i; j++){
                    Time time1 = getTimeBySigla(chaves[i]);
                    Time time2 = getTimeBySigla(chaves[j]);
                    try{//Aplicacao do algoritmo de ordenacao BUBBLE SORT com 3 criterios de desempate
                        if (time1.getPontos() > time2.getPontos()){
                            String temp = chaves[i];
                            chaves[i] = chaves[j];
                            chaves[j] = temp;
                        }
                        else if (time1.getVitorias() > time2.getVitorias() && time1.getPontos() == time2.getPontos()){
                            String temp = chaves[i];
                            chaves[i] = chaves[j];
                            chaves[j] = temp;
                        }
                        else if(time1.getSaldo() > time2.getSaldo() && time1.getPontos() == time2.getPontos() && time1.getVitorias() == time2.getVitorias()){
                            String temp = chaves[i];
                            chaves[i] = chaves[j];
                            chaves[j] = temp;
                        }
                        else if (time1.getSaldo() == time2.getSaldo() && time1.getPontos() == time2.getPontos() && time1.getGolsPro() > time2.getGolsPro() && time1.getVitorias() == time2.getVitorias()){
                            String temp = chaves[i];
                            chaves[i] = chaves[j];
                            chaves[j] = temp;
                        }
                    }
                    catch(NullPointerException exception){
                        System.out.println("Ponteiro Nulo");
                    }
                }
            }
        return chaves;
        }

    }
    public class Historico{//cria um array de inteiros pra cada objeto time
        protected OrdenaTimes times_ordenados;
        public Historico(){
            times_ordenados = new OrdenaTimes();
        }

        public void calculaHistorico(int rodada){//funcao usada a cada rodada
            String chaves[] = times_ordenados.inOrder();
            for (String p : chaves){
                getTimeBySigla(p).setHistorico(rodada, Arrays.asList(chaves).indexOf(p) + 1);//atualizando historico a cada rodada
            }
            if ((rodada + 1) == Dados.n_rodadas){
                chaves_ordenadas = chaves;
            }
        }
    }
}