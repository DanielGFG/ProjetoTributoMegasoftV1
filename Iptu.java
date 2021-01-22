//-----------------------------------------------------------------------------------------------------------------------//
// Projeto Megasoft 1 Versão 1.0 do Sistema de Tributos Municipais: IPTU. ITBI e ISS, com implementação básica do REFIS;
// Autor: Daniel Guedes Fukuyoshi Garcia;
//-----------------------------------------------------------------------------------------------------------------------//
// Pacote projetotributo0.1;
package projetotributo0.pkg1;
//-----------------------------------------------------------------------------------------------------------------------//
// SubClasse Iptu recebendo atributos e métodos da SuperClasse Tributo;
public class Iptu extends Tributo {
    //-------------------------------------------------------------------------------------------------------------------//
    // Construtor Iptu que recebe parâmetros que irão settar os atributos;
    public Iptu (String pag, String cn, float val, String dataPag, String dataVenc, String porc) {
        // Verificação Text Field vazio;
        if(pag.isEmpty() || pag == null) {                                      // Se a referência pag não receber valor;
            this.setPagador("Erro! Nome não digitado!");                        // O atributo pagador instanciado na SuperClasse recebe mensagem de erro;
        } else {                                                                // Senão
            this.setPagador(pag);                                               // Setter da referência pag do construtor para o atributo pagador instanciado na SuperClasse           ;
        }
        // Verificação Text Field vazio;
        if(cn.isEmpty() || cn == null){                                         // Se a referência cn não receber valor;
            this.setCnpj("Erro! CNPJ não digitado!");                           // O atributo cnpj instanciado na SuperClasse recebe mensagem de erro;
        } else {                                                                // Senão
            this.setCnpj(cn);                                                   // Setter da referência cn do construtor para o atributo cnpj instanciado na SuperClasse               ;
        }
        // Verificação Text Field vazio;
        if(dataPag.isEmpty() || dataPag == null){                               // Se a referência dataPag não receber valor;
            this.setDataPagamento("Erro! Data de Pagamento não fornecida!");    // O atributo dataPagamento instanciado na SuperClasse recebe mensagem de erro;
        } else {                                                                // Senão
            this.setDataPagamento(dataPag);                                     // Setter da referência dataPag do construtor para o atributo dataPagamento instanciado na SuperClasse ;
        }
        // Verificação Text Field vazio;
        if(dataVenc.isEmpty() || dataVenc == null) {                            // Se a referência dataVenc não receber valor;
            this.setDataVencimento("Erro! Data de Vencimento não fornecida!");  // O atributo dataVencimento instanciado na SuperClasse recebe mensagem de erro;
        } else {                                                                // Senão
            this.setDataVencimento(dataVenc);                                   // Setter da referência dataVenc do construtor para o atributo datainstanciado na SuperClasse          ;
        }
        // Verificação Text Field vazio;
        if(porc.isEmpty() || porc == null){                                     // Se a referência porc não receber valor;
            this.setPorcento(0);                                                // O atributo porcento instanciado na SuperClasse recebe 0;
        } else{                                                                 // Senão
            this.setPorcento(Integer.parseInt(porc));                           // O atributo porcento instanciado na SuperClasse recebe porc convertido para int;
        }
        this.setValor(val);                                                     // Setter da referência val do construtor para o atributo valor instanciado na SuperClasse             ;
    }
    // Função abstrata de calcular os juros recebida da SuperClasse e implemetada;
    @Override
    public void CalculaJuros() {
        // Variável que calcula o valor do juros por dia;
        double valorJurosDia = this.getValor() * (0.20 / 100);
        // Variável Juros recebe via setter o valor do juros por dia e multiplica pela quantidade de dias recebida pelo atributo DiferencaData via getter;
        this.setJuros( (float) (valorJurosDia * this.getDiferencaData() ) );
    }
    //-------------------------------------------------------------------------------------------------------------------//
    // Fim da SubClasse Iptu;
}
//-----------------------------------------------------------------------------------------------------------------------//