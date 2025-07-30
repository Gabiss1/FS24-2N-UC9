package Model;

public class Emprestimo {
    private String data_emprestimo;
    private String data_devolucao;
    private int id_livro;
    private int id_aluno;
    private int id_emprestimo;

    public Emprestimo(String data_emprestimo, String data_devolucao, int id_livro, int id_aluno, int id_emprestimo){
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
        this.id_livro = id_livro;
        this.id_aluno = id_aluno;
        this.id_emprestimo = id_emprestimo;
    }

    public String getData_emprestimo(){
        return data_emprestimo;
    }

    public String getData_devolucao(){
        return data_devolucao;
    }

    public int getId_livro(){
        return id_livro;
    }

     public int getId_aluno(){
        return id_aluno;
    }

     public int getId_emprestimo(){
        return id_emprestimo;
    }

}
