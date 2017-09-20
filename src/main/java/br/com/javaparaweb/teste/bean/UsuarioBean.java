package br.com.javaparaweb.teste.bean;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import java.text.SimpleDateFormat;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean {

    
    
//    Dados profissionais
    private String posto;
    private String arma;
    private String nome;
    private String guerra;
    private String su;
    private Date praca;
    private String email;
    private String senha;
    private String confirmaSenha;
    private List<SelectItem> armas;
    private List<SelectItem> postos;

//    Dados pessoais 
    private Date nascimento;
    private String sexo;
    private String nome_pai;
    private String nome_mae;

//    Dados bancários   
    private String banco;
    private String agencia;
    private String cpf;

//    Plano de chamada  
    private String endereco;
    private String bairro;
    private String complemento;
    private String cep;
    private String phone;

//    Ficha de entrevista     
    private String fundamental;
    private String medio;
    private String escolaridade;
    
    
// Métodos get and set"

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGuerra() {
        return guerra;
    }

    public void setGuerra(String guerra) {
        this.guerra = guerra;
    }

    public String getSu() {
        return su;
    }

    public void setSu(String su) {
        this.su = su;
    }

    public Date getPraca() {
        return praca;
    }

    public void setPraca(Date praca) {
        this.praca = praca;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    public List<SelectItem> getArmas() {
        return armas;
    }

    public void setArmas(List<SelectItem> armas) {
        this.armas = armas;
    }

    public List<SelectItem> getPostos() {
        return postos;
    }

    public void setPostos(List<SelectItem> postos) {
        this.postos = postos;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNome_pai() {
        return nome_pai;
    }

    public void setNome_pai(String nome_pai) {
        this.nome_pai = nome_pai;
    }

    public String getNome_mae() {
        return nome_mae;
    }

    public void setNome_mae(String nome_mae) {
        this.nome_mae = nome_mae;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFundamental() {
        return fundamental;
    }

    public void setFundamental(String fundamental) {
        this.fundamental = fundamental;
    }

    public String getMedio() {
        return medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

       
    
    
    
    
// Método "novo"
    public String novo() {
        return "usuario";
    }
    
// Método "salvar"
    public String salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (!this.senha.equalsIgnoreCase(this.confirmaSenha)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Senha confirmada incorretamente", ""));
            return "usuario";
        }
// FUTURO - salva o usuário
        return "mostrausuario";
    }

// Métodos date
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }

    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }

    public void save() {
        addMessage("Success", "Data saved");
    }

    public void update() {
        addMessage("Success", "Data updated");
    }

    public void delete() {
        addMessage("Success", "Data deleted");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    @PostConstruct
    public void init() {
// postos
        SelectItemGroup g1 = new SelectItemGroup("Oficiais Generais");
        g1.setSelectItems(new SelectItem[]{
            new SelectItem("Gen", "General Exército"),
            new SelectItem("Gen", "General Divisão"),
            new SelectItem("Gen", "General Brigada"),});
           
                
        SelectItemGroup g2 = new SelectItemGroup("Oficiais Superiores");
        g2.setSelectItems(new SelectItem[]{
            new SelectItem("Cel", "Coronel"),
            new SelectItem("Cel", "Tenente Coronel"),
            new SelectItem("Maj", "Major"),});
            
            
        SelectItemGroup g3 = new SelectItemGroup("Oficiais Subalternos");
        g3.setSelectItems(new SelectItem[]{
            new SelectItem("Cap", "Capitão"),});
        
        
        SelectItemGroup g4 = new SelectItemGroup("Oficiais intermediários");
        g4.setSelectItems(new SelectItem[]{            
            new SelectItem("1º Ten", "1º Tenente"),
            new SelectItem("2º Ten", "2º Tenente"),
            new SelectItem("Asp", "Aspirante"),});
        
           
        SelectItemGroup g5 = new SelectItemGroup("Praças");
        g5.setSelectItems(new SelectItem[]{              
            new SelectItem("Sub Ten", "Subtenente"),
            new SelectItem("1º Sgt", "1º Sargento"),
            new SelectItem("2º Sgt", "2º Sargento"),
            new SelectItem("3º Sgt", "3º Sargento"),
            new SelectItem("Cb", "Cabo"),
            new SelectItem("Sd", "Soldado"),});
        
        
        SelectItemGroup g6 = new SelectItemGroup("Arma");
        g6.setSelectItems(new SelectItem[]{              
            new SelectItem("Inf", "Infantaria"),     
            new SelectItem("Art", "Artilharia"),     
            new SelectItem("Com", "Comunicações"),     
            new SelectItem("Eng", "Engenharia"),     
            new SelectItem("Cav", "Cavalaria"),});

        
        SelectItemGroup g7 = new SelectItemGroup("Quadro");
        g7.setSelectItems(new SelectItem[]{   
            new SelectItem("QAO", "Quadro Auxiliar de Oficiais"),
            new SelectItem("QCO", "Quadro Complementar de Oficiais"),
            new SelectItem("QMB", "Quadro de Material Bélico"),           
            new SelectItem("QEM", "Quado de Engenheiros Militares"),});
        armas = new ArrayList<SelectItem>();
        armas.add(g6);
        armas.add(g7);
       
        postos = new ArrayList<SelectItem>();
        postos.add(g1);
        postos.add(g2);
        postos.add(g3);
        postos.add(g4);
        postos.add(g5);
       
    }

}
