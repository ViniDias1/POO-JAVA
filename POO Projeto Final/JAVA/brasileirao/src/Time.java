public class Time{
    
    protected String nome;
    protected String sigla;
    public static int n_rodadas;
    protected int historico[];
    protected int stats[];

    public Time(){//provocando uma sobrecarga de construtor!
    }//FORMATACAO "nome": [pontos, partidas, vitorias, empates, derrotas, saldo_de_gols, gols_pro, gols_contra]

    public Time(String nome, String sigla){

        this.nome = nome;
        this.sigla = sigla;
        historico = new int[n_rodadas];
        stats = new int[8];
        for (int i=0; i<8;i++){//zerando as estatisticas do time como default
            stats[i] = 0;
        }
    }

    public void setHistorico(int rodada, int pos){//em que 0 == rodada 1
        historico[rodada] = pos;//atualizacao do historico
    }

    public void setStats(int estatisticas[]){//atualizacao total
        this.stats = estatisticas;
    }
    public int[] getStats(){
        return stats;
    }
    public int getPontos(){
        return stats[0];
    }
    public int getPartidas(){
        return stats[1];
    }
    public int getVitorias(){
        return stats[2];
    }
    public int getEmpates(){
        return stats[3];
    }
    public int getDerrotas(){
        return stats[4];
    }
    public int getSaldo(){
        return stats[5];
    }
    public int getGolsPro(){
        return stats[6];
    }
    public int getGolsContra(){
        return stats[7];
    }
    public void setPontos(int x){
        stats[0] = x;
    }
    public void setPartidas(int x){
        stats[1] = x;
    }
    public void setVitorias(int x){
        stats[2] = x;
    }
    public void setEmpates(int x){
        stats[3] = x;
    }
    public void setDerrotas(int x){
        stats[4] = x;
    }
    public void setSaldo(int x){
        stats[5] = x;
    }
    public void setGolsPro(int x){
        stats[6] = x;
    }
    public void setGolsContra(int x){
        stats[7] = x;
    }

    public int[] getHistorico(){
        return historico;
    }
    public String getNome(){
        return nome;
    }
    public String getSigla(){
        return sigla;
    }
}