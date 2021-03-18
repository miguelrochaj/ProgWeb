package br.edu.cesmac.si.nolapi;

import javax.persistence.*;
import java.util.List;

@Entity
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMarca;
    private String nome;
    private String site;
    private String email;

    @OneToMany(mappedBy = "carros")
    private List<Carro> carros;

    public Marca(){

    }

    public Marca(Long idMarca, String nome, String site, String email){
        this.idMarca = idMarca;
        this.nome = nome;
        this.site = site;
        this.email = email;
    }

    public Long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
}
