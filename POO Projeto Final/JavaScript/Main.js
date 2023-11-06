  
  
// Para instalar a biblioteca Chart.js, basta digitar "npm install chart.js" no terminal.


// --------------------------------------------------------------------- //
// ##################################################################### //
//                            Classe Observador                          //
// ##################################################################### //
// --------------------------------------------------------------------- //

// Ideia desse Padrão de Projeto:
// Toda vez que um evento acontece, os observadores desse evento    serão notificados e executados.

class Observador{

  constructor(){
    this.inscritos = [];  
  }

  adiciona(funcao){
    this.inscritos.push(funcao)
  }

  remove(){
    this.inscritos = this.inscritos.filter((f)=> f !== funcao);
  }

  notifica(id,mapa_dados){

    for (let i = 0;i<this.inscritos.length;i++){
        this.inscritos[i](id,mapa_dados);
    }
  }
}

  // --------------------------------------------------------------------- //
  // ##################################################################### //
  //                               Clase Time                              //
  // ##################################################################### //
  // --------------------------------------------------------------------- //

class Time{

  constructor(nome,sigla){
    this.nome = nome;
    this.sigla = sigla;
    this.n_rodadas = 33;
    this.historico = new Array(this.n_rodadas);
    this.stats = new Array(8);
    for (let i = 0;i<8;i++){
      this.stats[i] = 0;
    }
  }

  setHistorico(rodada,pos){
    this.historico[rodada] = pos;
  }

  setStats(estatisticas){
    this.stats = estatisticas;
  }

  getStats(){
    return this.stats;
  }

  getPontos(){
    return this.stats[0];
  }

  getPartidas(){
    return this.stats[1];
  }
  getVitorias(){
      return this.stats[2];
  }
  getEmpates(){
      return this.stats[3];
  }
  getDerrotas(){
      return this.stats[4];
  }
  getSaldo(){
      return this.stats[5];
  }
  getGolsPro(){
      return this.stats[6];
  }
  getGolsContra(){
      return this.stats[7];
  }
  setPontos(x){
      this.stats[0] = x;
  }
  setPartidas(x){
      this.stats[1] = x;
  }
  setVitorias(x){
      this.stats[2] = x;
  }
  setEmpates(x){
      this.stats[3] = x;
  }
  setDerrotas(x){
      this.stats[4] = x;
  }
  setSaldo(x){
      this.stats[5] = x;
  }
  setGolsPro(x){
      this.stats[6] = x;
  }
  setGolsContra(x){
      this.stats[7] = x;
  }
  getHistorico(){
      return this.historico;
  }
  getNome(){
      return this.nome;
  }
  getSigla(){
      return this.sigla;
  }

}
// --------------------------------------------------------------------- //
// ##################################################################### //
//                             Classe Dados                              //
// ##################################################################### //
// --------------------------------------------------------------------- //

class Dados extends Time {

    
    array_siglas = ["FLA", "PAL", "FLU", "SAO", "SAN", "CAM","CFC", "COR", "CAP", "FOR", "BOT", "JUV",
      "CUI", "GOI", "BRA", "ACG", "INT", "CEA", "AVA", "AMG"];
    array_nomes = ["Flamengo","Palmeiras","Fluminense","São Paulo","Santos","Atlético-MG","Coritiba","Corinthians","Athlético-PR","Fortaleza",
      "Botafogo","Juventude","Cuiabá","Goiás","Bragantino","Atlético-GO","Internacional","Ceará","Avaí","América-MG"];
    
  
    constructor() { 
      super();
      this.calculador_Historico = new Historico(this.array_siglas);
      this.times = new Array(20);
      for (let i = 0;i<20;i++) {
        this.times[i] = new Time(this.array_nomes[i],this.array_siglas[i]);
      };
    };

    getTimeBySigla(sigla){
      return this.times[this.array_siglas.indexOf(sigla)];
    }

    static getTimeByNome(nome){
      return this.times[this.array_nomes.indexOf(nome)];
    }

    computaDados() {
  
      //FORMATACAO DO HASHMAP "nome": [pontos, partidas, vitorias, empates, derrotas, saldo_de_gols, gols_pro, gols_contra]
  
      let time1 = this.time1; let time2 = this.time2; 
      let gol_time1 = this.gol_time1; let gol_time2 = this.gol_time2;
  
      for (let i = 0; i < 33; i++) {
        for (let j = 0; j < 10; j++) {
          
          time1 = this.getTimeBySigla(jogos[i][j].substring(0, 3));
          time2 = this.getTimeBySigla(jogos[i][j].substring(6, 9));
          gol_time1 = parseInt(jogos[i][j].substring(4, 5));
          gol_time2 = parseInt(jogos[i][j].substring(10, 11));
  
          if (gol_time1 > gol_time2) {
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

        } else {

            if (gol_time1 < gol_time2) {  

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
            else {

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

            };
          };
        };
        this.calculador_Historico.calculaHistorico(i,this); 
      };
    };
    escrevaDados(chaves_ordenadas,mapa_dados){
      let ids = ["primeiro","segundo","terceiro","quarto","quinto","sexto",
                  "setimo","oitavo","nono","decimo","decimoPrimeiro","decimoSegundo",
                  "decimoTerceiro","decimoQuarto","decimoQuinto","decimoSexto","decimoSetimo",
                  "decimoOitavo","decimoNono","vigesimo"];
      let timeIndice = 0;
      
      for (let id of ids){  
        let tSigla = chaves_ordenadas[timeIndice]
        let tObjt = mapa_dados.getTimeBySigla(tSigla)
        let stats = tObjt.getStats();
        document.getElementById(id).innerHTML = tSigla;
        document.getElementById(id+"PTS").innerHTML = stats[0] // ou tObjt.getPontos();
        document.getElementById(id+"Partidas").innerHTML = stats[1]// ou tObjt.getPartidas();
        document.getElementById(id+"Vitorias").innerHTML =stats[2] // ou tObjt.getVitorias();
        document.getElementById(id+"Empates").innerHTML = stats[3]// ou tObjt.getEmpates();
        document.getElementById(id+"Derrotas").innerHTML = stats[4]// ou tObjt.getDerrotas();
        document.getElementById(id+"Saldo").innerHTML = stats[5]// ou tObjt.getSaldo();
        document.getElementById(id+"ProGols").innerHTML = stats[6 ]// ou tObjt.getGolsPro();
        document.getElementById(id+"ContraGols").innerHTML = stats[7]// ou tObjt.getGolsContra();
        timeIndice += 1;
      };
    };  
  };

// --------------------------------------------------------------------- //
// ##################################################################### //
//                         Classe Ordena Mapa                            //
// ##################################################################### //
// --------------------------------------------------------------------- //

  class OrdenaTimes extends Time{
    
      constructor(array_siglas){
        super();
        this.chaves = new Array(20);
        for (let k=0; k<20; k++){//fazendo uma copia das siglas
          this.chaves[k] = array_siglas[k];
        }
      };
    
      inOrder(times){
        
        for (let i=1;i<20;i++){
          for (let j=0; j<i; j++){

              this.time1 = times.getTimeBySigla(this.chaves[i]);
              this.time2 = times.getTimeBySigla(this.chaves[j]);
              
              if (this.time1.getPontos() > this.time2.getPontos()){//ordena por pontos
                  let temp = this.chaves[i];
                  this.chaves[i] = this.chaves[j];
                  this.chaves[j] = temp;
              }
              else if(this.time1.getVitorias() > this.time2.getVitorias() && this.time1.getPontos() == this.time2.getPontos()){//ordena por saldo
                  let temp = this.chaves[i];
                  this.chaves[i] = this.chaves[j];
                  this.chaves[j] = temp;
              }
              else if (this.time1.getSaldo() > this.time2.getSaldo() && this.time1.getPontos() == this.time2.getPontos() && this.time1.getVitorias() == this.time2.getVitorias()){//ordena por vitoria
                  let temp = this.chaves[i];
                  this.chaves[i] = this.chaves[j];
                  this.chaves[j] = temp;
              }
              else if (this.time1.getSaldo() == this.time2.getSaldo() && this.time1.getPontos() == this.time2.getPontos() && this.time1.getGolsPro() > this.time2.getGolsPro() && this.time1.getVitorias() == this.time2.getVitorias()){
                  let temp = this.chaves[i];
                  this.chaves[i] = this.chaves[j];
                  this.chaves[j] = temp;
              };
          };
        };
        return this.chaves;
      };
  };

  // --------------------------------------------------------------------- //
  // ##################################################################### //
  //                          Classe Historico                             //
  // ##################################################################### //
  // --------------------------------------------------------------------- //

  class Historico{  

      constructor(array_siglas){
        this.times_ordenados = new OrdenaTimes(array_siglas);
      }
    
      calculaHistorico(rodada,times){
        let chaves = this.times_ordenados.inOrder(times)
        
        for (let p of chaves){
          times.getTimeBySigla(p).setHistorico(rodada,chaves.indexOf(p) + 1);
        }

        if ((rodada + 1) == times.n_rodadas){
          times.chaves_ordenadas = chaves;
        }

      };
  };
// --------------------------------------------------------------------- //
// ##################################################################### //
//                               Classe CriaGrafico                      //
// ##################################################################### //
// --------------------------------------------------------------------- //
class CriaGrafico{
  constructor(){
    this.myChart = null;
    this.posAnt = this.posAnt;
  }

  criaGrafico(id,mapa_dados){

    let img;
    let pos = ((id.id)[0]).toUpperCase() + (id.id).slice(1);

    if (this.myChart != null){
      // Limpa o grafico e arruma os valores do botoes.
      this.myChart.destroy();
      this.myChart = null;

      document.getElementById("button"+pos).value = "Detalhes";
      if (document.getElementById("button"+this.posAnt).value == "Voltar"){
        document.getElementById("button"+this.posAnt).value = "Detalhes";
      };
      
      img = document.getElementById("escudo");
      document.getElementById("ClubeEscudo").removeChild(img);  
      document.getElementById("clube").innerHTML = "Clique em Detalhes!"; 

    }
    else{

      // Desenha o grafico
      document.getElementById("clube").innerHTML = "";
      let time = id.innerText;
      this.posAnt = pos;
      img = document.createElement("img");
      img.src = "Escudos/"+time+".png";
      img.style.width = "48px"; 
      img.style.height = "48px";
      img.id = "escudo";
      document.getElementById("clube").innerHTML = mapa_dados.getTimeBySigla(time).getNome();
      document.getElementById('ClubeEscudo').appendChild(img);
      
      
      let posicoes = mapa_dados.getTimeBySigla(time).getHistorico();
      let rodadas = ['1', '2', '3', '4', '5',
        '6', '7', '8', '8', '9', '10', '11', '12', '13', '14', '15', '16',
        '17', '18', '19', '20', '21','22', '23', '24', '25', '26', '27', '28', '29', '30', '31', '32', '33'];

      const data = {

        labels: rodadas,
        datasets: [{
          label: time,
          backgroundColor: 'rgb(0, 173, 181)',
          borderColor: 'rgb(0, 173, 181)',
          pointBackgroundColor:'rgb(57, 62, 70)',
          pointBorderColor:'rgb(0, 173, 181)',  
          data: posicoes,
          pointRadius:5,
          borderColor:"rgba(0,173,181,1.000)"
        }]
      };
      const config = {
        type: 'line',
        data: data,
        options: {
          responsive:true,
          scales: {
            y: {
              reverse: true,
              max: 20,
              min: 0,
              ticks: {color:"gray"},
              grid:{borderColor:'gray',color:"gray"}
            },
            x:{
              title:{display:true,text:"Rodadas X Posição",font:{weight:"bold",size:18},color:"white"},
              grid:{borderColor:'gray',color:"gray"},
              ticks: {color:"gray"}
            }
          }
        }
      };
      this.myChart = new Chart(document.getElementById('canva'),config);
      document.getElementById("button"+pos).value = "Voltar";
    };
  };
};

  // --------------------------------------------------------------------- //
  // ##################################################################### //
  //                                "MAIN"                                 //
  // ##################################################################### //
  // --------------------------------------------------------------------- //

class Main{
  constructor(){
    this.mapa_dados = new Dados();
    this.mapa_dados.computaDados();
    this.mapa_dados.escrevaDados(this.mapa_dados.chaves_ordenadas,this. mapa_dados);
    this.observador = new Observador();
    this.grafico = new CriaGrafico();
    this.observador.adiciona(this.grafico.criaGrafico)
  };
};

//-------------------------------------------------------------------------//

let jogos = JSON.parse(localStorage.getItem('jogos'));
let main = new Main();
function detalhesClicado(id,main){
  main.observador.notifica(id,main.mapa_dados)
}


