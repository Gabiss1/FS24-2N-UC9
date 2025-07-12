package Model;

public class Dinossauro {
    private int id;
    private String nome;
    private String especie;
    private String dieta;
    private String idade_estimada_anos;
    private int idade_dinossauro;
    private String status_cercado;

    public Dinossauro(int id, String nome, String especie, String dieta, String idade_estimada_anos, int idade_dinossauro, String status_cercado) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.dieta = dieta;
        this.idade_estimada_anos = idade_estimada_anos;
        this.idade_dinossauro = idade_dinossauro;
        this.status_cercado = status_cercado;
    }

    public Dinossauro(String nome, String especie, String dieta, String idade_estimada_anos, int idade_dinossauro, String status_cercado) {
        this.nome = nome;
        this.especie = especie;
        this.dieta = dieta;
        this.idade_estimada_anos = idade_estimada_anos;
        this.idade_dinossauro = idade_dinossauro;
        this.status_cercado = status_cercado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }

    public String getIdade_estimada_anos() {
        return idade_estimada_anos;
    }

    public void setIdade_estimada_anos(String idade_estimada_anos) {
        this.idade_estimada_anos = idade_estimada_anos;
    }

    public int getIdade_dinossauro() {
        return idade_dinossauro;
    }

    public void setIdade_dinossauro(int idade_dinossauro) {
        this.idade_dinossauro = idade_dinossauro;
    }

    public String getStatus_cercado() {
        return status_cercado;
    }

    public void setStatus_cercado(String status_cercado) {
        this.status_cercado = status_cercado;
    }
}