package Model;

public class Livro {
    private int id_livro;
    private String titulo;
    private String autor;
    private String genero;
    private String ISBN;

    public Livro(int id_livro, String titulo, String autor, String genero, String ISBN){
        this.id_livro = id_livro;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.ISBN = ISBN;
    }

    public int getId_livro(){
        return id_livro;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public String getGenero(){
        return genero;
    }

    public String getISBN(){
        return ISBN;
    }


}
