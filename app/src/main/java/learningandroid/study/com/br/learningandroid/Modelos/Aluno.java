package learningandroid.study.com.br.learningandroid.Modelos;

import java.io.Serializable;

/**
 * Created by heitorpaino on 12/12/17.
 */

public class Aluno implements Serializable{
    private Long id;
    private String Nome;
    private String Endereco;
    private String Telefone;
    private String site;
    private double Rate;

    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
    }

    private String caminhoFoto;

    public String getSite() { return site; }

    public void setSite(String site) { this.site = site; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public double getRate() {
        return Rate;
    }

    public void setRate(double rate) {
        Rate = rate;
    }

    @Override
    public String toString() {
        return getId() + " - " + getNome();
    }
}
