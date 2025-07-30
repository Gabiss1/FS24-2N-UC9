package Model.DAO;

import Conexao.ConexaoPostgresDB;
import Model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Conexao.ConexaoPostgresDB.conectar;
import static Conexao.ConexaoPostgresDB.fecharConexao;

public class LivroDAO {
    public void setLivro(Livro livro){
        String sql = "INSERT INTO livro (titulo, autor, genero, ISBN) VALUES (?, ?, ?, ?)";
        Connection conexao = null;
        PreparedStatement stmt = null;
        try {
            conexao = ConexaoPostgresDB.conectar();
            if (conexao != null) {
                stmt = conexao.prepareStatement(sql);
                stmt.setString(1, livro.getTitulo());
                stmt.setString(2, livro.getAutor());
                stmt.setString(3, livro.getGenero());
                stmt.setString(4, livro.getISBN());

                int linhasAfetadas = stmt.executeUpdate(); // Executa o INSERT
                if (linhasAfetadas > 0) {
                    System.out.println("Livro " + livro.getTitulo() + " inserido no BD com sucesso!");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir livro no Postgresql: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) fecharConexao(conexao);
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos após inserção: " + e.getMessage());
            }
        }
    }

    public List<Livro> getLivro() {
        String sql = "SELECT titulo, autor, genero, ISBN FROM livro ORDER BY id_livro";
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Livro> livros = new ArrayList<>();

        try {
            conexao = ConexaoPostgresDB.conectar();
            if (conexao != null) {
                stmt = conexao.prepareStatement(sql);
                rs = stmt.executeQuery();
                System.out.println("\n--- Livros Cadastrados no DB ---");
                boolean encontrouLivro = false;
                while (rs.next()) {
                    encontrouLivro = true;
                    int id_livro = rs.getInt("id_livro");
                    String titulo = rs.getString("titulo");
                    String autor = rs.getString("autor");
                    String genero = rs.getString("genero");
                    String ISBN = rs.getString("ISBN");

                    Livro livro = new Livro(id_livro, titulo, autor, genero, ISBN);
                    livros.add(livro);
                }
                if (!encontrouLivro) {
                    System.out.println("Nenhum livro encontrado.");
                }
                System.out.println("---------------------------\n");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao consultar livros no DB: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conexao != null) fecharConexao(conexao);
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos após consulta: " + e.getMessage());
            }

        }
        return livros;

    }

    public void atualizarLivro(Livro livro) {
        String sql = "UPDATE livro SET titulo = ?, autor = ?, genero = ?, ISBN = ? WHERE id_livro = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;
        try {
            conexao = ConexaoPostgresDB.conectar();
            if (conexao != null) {
                stmt = conexao.prepareStatement(sql);
                stmt.setString(1, livro.getTitulo());
                stmt.setString(2, livro.getAutor());
                stmt.setString(3, livro.getGenero());
                stmt.setString(4, livro.getISBN()); //O ID DO QUE QUEREMOS ATUALIZAR
                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Livro com ID " + livro.getId_livro() + " atualizado com sucesso!");
                } else {
                    System.out.println("Nenhum livro encontrado com ID " + livro.getId_livro() + " para atualização.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar livro no PostgreSQL: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) fecharConexao(conexao);
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos após atualização: " + e.getMessage());
            }
        }
    }

    public void removerLivro(int id_livro) {
        String sql = "DELETE FROM livro WHERE id_livro = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;
        try {
            conexao = conectar();
            if (conexao != null) {
                stmt = conexao.prepareStatement(sql);
                stmt.setInt(1, id_livro);

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Livro com ID " + id_livro + " removido com sucesso!");
                } else {
                    System.out.println("Nenhum livro encontrado com ID " + id_livro + " para remoção.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao remover livro no PostgreSQL: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) fecharConexao(conexao);
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos após remoção: " + e.getMessage());
            }
        }
    }
}
