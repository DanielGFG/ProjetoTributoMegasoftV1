//-----------------------------------------------------------------------------------------------------------------------//
// Projeto Megasoft 1 Versão 1.0 do Sistema de Tributos Municipais: IPTU. ITBI e ISS, com implementação básica do REFIS;
// Autor: Daniel Guedes Fukuyoshi Garcia;
//-----------------------------------------------------------------------------------------------------------------------//
// Pacote projetotributo0.1;
package projetotributo0.pkg1;
//-----------------------------------------------------------------------------------------------------------------------//
// SubClasse Iss recebendo atributos e métodos da SuperClasse Tributo;
public class Iss extends Tributo{
    //-------------------------------------------------------------------------------------------------------------------//
    // Construtor Iss que recebe parâmetros que irão settar os atributos;
    public Iss(String pag, String cn, float val, String dataPag, String dataVenc, String porc) {
        this.setPagador        (pag)     ;  // Setter da referência pag do construtor para o atributo pagador instanciado na SuperClasse           ;
        this.setCnpj           (cn)      ;  // Setter da referência cn do construtor para o atributo cnpj instanciado na SuperClasse               ;
        this.setDataPagamento  (dataPag) ;  // Setter da referência dataPag do construtor para o atributo dataPagamento instanciado na SuperClasse ;
        this.setDataVencimento (dataVenc);  // Setter da referência dataVenc do construtor para o atributo datainstanciado na SuperClasse          ;
        this.setValor          (val)     ;  // Setter da referência val do construtor para o atributo valor instanciado na SuperClasse             ;
        if(porc.isEmpty() || porc == null){                              // Se a referência porc não receber valor;
            this.setPorcento(0);                       // O atributo porcento instanciado na SuperClasse recebe 0;
        } else{                                        // Senão
            this.setPorcento(Integer.parseInt(porc));  // O atributo porcento instanciado na SuperClasse recebe porc convertido para int;
        }
    }
    // Função abstrata de calcular os juros recebida da SuperClasse e implemetada;
    @Override
    public void CalculaJuros() {
        // Variável que calcula o valor do juros por dia;
        double valorJurosDia = this.getValor() * (0.33 / 100);
        // Variável Juros recebe via setter o valor do juros por dia e multiplica pela quantidade de dias recebida pelo atributo DiferencaData via getter;
        this.setJuros( (float) (valorJurosDia * this.getDiferencaData() ) );
    }
    //-------------------------------------------------------------------------------------------------------------------//
    // Fim da SubClasse Iss;
}
//-----------------------------------------------------------------------------------------------------------------------//