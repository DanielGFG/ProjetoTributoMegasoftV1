//-----------------------------------------------------------------------------------------------------------------------//
// Projeto Megasoft 1 Versão 1.0 do Sistema de Tributos Municipais: IPTU. ITBI e ISS, com implementação básica do REFIS;
// Autor: Daniel Guedes Fukuyoshi Garcia;
//-----------------------------------------------------------------------------------------------------------------------//
// Pacote projetotributo0.1;
package projetotributo0.pkg1;
// Importações de códigos para implementação na SuperClasse;
import java.text.ParseException           ;
import java.time.LocalDate                ;
import java.time.format.DateTimeFormatter ;
import java.time.temporal.ChronoUnit      ;
//-----------------------------------------------------------------------------------------------------------------------//
// SuperClasse Tributo fornecendo atributos e métodos para as SubClasses Iptu, Itbi e Iss;
public abstract class Tributo{
    //-------------------------------------------------------------------------------------------------------------------//
    // Atributos
    protected String pagador        ;    // Proprietário do Débito Tributário;
    protected String cnpj           ;    // CNPJ do Proprietário
    protected String dataPagamento  ;    // Data de Pagamento do Tributo;
    protected String dataVencimento ;    // Data de Vencimento do Tributo;
    protected int    diferencaData  ;    // Diferença entre as datas de pagamento e vencimento em dias;
    protected float  valor          ;    // Valor do tributo;
    protected float  multa          ;    // Valor da multa efetuada sobre o tributo;
    protected float  juros          ;    // Valor do juros efetuado sobre o tributo;
    protected float  refis          ;    // Valor do Refis a ser descontado sobre a soma da multa e do juros;
    protected int    porcento       ;    // Valor inteiro da % do Refis;
    //-------------------------------------------------------------------------------------------------------------------//
    // Métodos
    // Função que calcula a diferença entre as datas de pagamento e vencimento do tributo;
    protected void CalculaDiferencaDatas() throws ParseException{
        // Criação de duas classes para transformar datas de formato String em LocalDates
        LocalDate date, date2;
        // LocalDates formatarão as datas recebidas em String no formato "dd/MM/yyyy(dia/mês/ano)";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern ("dd/MM/yyyy"), formatter2 = DateTimeFormatter.ofPattern ("dd/MM/yyyy");
        date  = LocalDate.parse (this.getDataPagamento(),  formatter  );
        date2 = LocalDate.parse (this.getDataVencimento(), formatter2 );
        // Variável DiferencaData recebe via set a uma classe que calcula a diferença entre a LocalDate(vencimento) e a LocalDate(pagamento);
        this.setDiferencaData ( (int) ChronoUnit.DAYS.between (date2, date) );
    }
    // Função que calcula a multa efetuada sobre diferença entre as datas de pagamento e vencimento do tributo;
    public void CalculaMulta() {
        // Ponto flutuante para efetuar a porcentagem da multa sobre o valor do tributo;
        float porcentagemMulta = (float) (2.00 / 100);
        this.setMulta (this.valor * porcentagemMulta);
    }
    // Função abstrata a ser codificada em cada SubClasse pela sua variação de valores de porcentagem de juros;
    public abstract void CalculaJuros();
    // Função que calcula o Refis, caso tenha, a ser descontado na soma da multa com o juros;
    public void CalculaRefis() {
        // Variável Refis recebe via setter o valor a ser descontado entre a soma de multa e juros;
        this.setRefis ( ( (this.getMulta() + this.getJuros()) / 100) * this.getPorcento() );
    }
    //-------------------------------------------------------------------------------------------------------------------//
    // Métodos Especiais
    // Função para mostrar as informações finais após a execução de todos os métodos das Super e SubClasses;
    @Override
    public String toString() {
        // Variável para calcular o valor final da DUAM;
        float total = this.getValor() + this.getJuros() + this.getMulta() - this.getRefis();
        // Retorna uma String com todas as informações;
        return "Pagador: " + this.getPagador() + "\nCNPJ: " + this.getCnpj()
                + "\nData de Pagamento: " + this.getDataPagamento() + "\nData de Vencimento: "
                + this.getDataVencimento() + "\nValor: " + this.getValor() + "\nMulta: "
                + String.format("%.2f", this.getMulta()) + "\nJuros: " + String.format("%.2f", this.getJuros()) + "\nValor do Refis: " + String.format("%.2f", this.getRefis())
                + "\nValor Total do DUAM: " + String.format("%.2f",total);
    }
    // Todos os getters e setters dos atributos da SuperClasse;
    // Pagador;
    public String getPagador() {
        return pagador;
    }
    public void setPagador(String pagador) {
        this.pagador = pagador;
    }
    // CNPJ
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    // DataPagamento
    public String getDataPagamento() {
        return dataPagamento;
    }
    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    // DataVencimento
    public String getDataVencimento() {
        return dataVencimento;
    }
    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    // DiferencaData
    public int getDiferencaData() {
        return diferencaData;
    }
    public void setDiferencaData(int diferencaData) {
        this.diferencaData = diferencaData;
    }
    // Valor
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    // Multa
    public float getMulta() {
        return multa;
    }
    public void setMulta(float multa) {
        this.multa = multa;
    }
    // Juros
    public float getJuros() {
        return juros;
    }
    public void setJuros(float juros) {
        this.juros = juros;
    }
    // Refis
    public float getRefis() {
        return refis;
    }
    public void setRefis(float refis) {
        this.refis = refis;
    }
    // Porcento
    public int getPorcento() {
        return porcento;
    }
    public void setPorcento(int porcento) {
        this.porcento = porcento;
    }
    //-------------------------------------------------------------------------------------------------------------------//
    // Fim da SuperClasse Tributo;
}
//-----------------------------------------------------------------------------------------------------------------------//