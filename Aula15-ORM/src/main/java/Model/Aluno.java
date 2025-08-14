package Model;

import jakarta.persistence.*;

@Entity
@Table(name="aluno")

public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PARA ID TIPO SERIAL
    private int id_aluno;

    @Column(name = "nome_aluno", nullable = false)
    private String nome;

    @Column(name = "idade_aluno", nullable = false)
    private int idade;

    @Column(name = "contato_aluno", nullable = false)
    private String contato;


    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public int getId_aluno() {
        return id_aluno;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getContato() {
        return contato;
    }
}
