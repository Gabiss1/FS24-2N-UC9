package Model.Biblioteca;

import Conexao.ConexaoPostgresDB;
import Model.Emprestimo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Conexao.ConexaoPostgresDB.conectar;
import static Conexao.ConexaoPostgresDB.fecharConexao;

public class EmprestimoDAO {
    public void setEmprestimo(Emprestimo emprestimo){
        String sql = "INSERT INTO emprestimo (data_emprestimo, data_devolucao, id_livro, id_aluno, id_emprestimo) VALUES (?, ?, ?, ?, ?)";
        Connection conexao = null;
        PreparedStatement stmt = null;
        try {
            conexao = ConexaoPostgresDB.conectar();
            if (conexao != null) {
                stmt = conexao.prepareStatement(sql);
                stmt.setString(1, emprestimo.getData_emprestimo());
                stmt.setString(2, emprestimo.getData_devolucao());
                stmt.setInt(3, emprestimo.getId_livro());
                stmt.setInt(4, emprestimo.getId_aluno());
                stmt.setInt(5, emprestimo.getId_emprestimo());


                int linhasAfetadas = stmt.executeUpdate(); // Executa o INSERT
                if (linhasAfetadas > 0) {
                    System.out.println("Emprestimo " + emprestimo.getId_emprestimo() + " inserido no BD com sucesso!");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir emprestimo no Postgresql: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) fecharConexao(conexao);
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos após inserção: " + e.getMessage());
            }
        }
    }

    public List<Emprestimo> getEmprestimo() {
        String sql = "SELECT data_emprestimo, data_devolucao, id_livro, id_aluno FROM emprestimo ORDER BY id_emprestimo";
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Emprestimo> emprestimos = new ArrayList<>();

        try {
            conexao = ConexaoPostgresDB.conectar();
            if (conexao != null) {
                stmt = conexao.prepareStatement(sql);
                rs = stmt.executeQuery();
                System.out.println("\n--- Emprestimos Cadastrados no DB ---");
                boolean encontrouEmprestimo = false;
                while (rs.next()) {
                    encontrouEmprestimo = true;
                     String data_emprestimo = rs.getString("data_emprestimo");
                     String data_devolucao = rs.getString("data_devolucao");
                     int id_livro = rs.getInt("id_livro");
                     int id_aluno = rs.getInt("id_aluno");
                     int id_emprestimo = rs.getInt("id_emprestimo");

                    Emprestimo emprestimo = new Emprestimo(data_emprestimo, data_devolucao, id_livro, id_aluno, id_emprestimo);
                    emprestimos.add(emprestimo);
                }
                if (!encontrouEmprestimo) {
                    System.out.println("Nenhum aluno encontrado.");
                }
                System.out.println("---------------------------\n");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao consultar alunos no DB: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conexao != null) fecharConexao(conexao);
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos após consulta: " + e.getMessage());
            }

        }
        return emprestimos;

    }

    public void atualizarEmprestimo(Emprestimo emprestimo) {
        String sql = "UPDATE emprestimo SET data_emprestimo = ?, data_devolucao = ?, id_livro = ?, id_aluno = ? WHERE id_emprestimo = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;
        try {
            conexao = ConexaoPostgresDB.conectar();
            if (conexao != null) {
                stmt = conexao.prepareStatement(sql);
                stmt.setString(1, emprestimo.getData_emprestimo());
                stmt.setString(2, emprestimo.getData_devolucao());
                stmt.setInt(3, emprestimo.getId_livro());
                stmt.setInt(4, emprestimo.getId_aluno());
                stmt.setInt(5, emprestimo.getId_emprestimo()); //O ID DO QUE QUEREMOS ATUALIZAR
                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Emprestimo com ID " + emprestimo.getId_emprestimo() + " atualizado com sucesso!");
                } else {
                    System.out.println("Nenhum emprestimo encontrado com ID " + emprestimo.getId_emprestimo() + " para atualização.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar emprestimo no PostgreSQL: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) fecharConexao(conexao);
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos após atualização: " + e.getMessage());
            }
        }
    }

    public void removerEmprestimo(int id_emprestimo) {
        String sql = "DELETE FROM emprestimo WHERE id_emprestimo = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;
        try {
            conexao = conectar();
            if (conexao != null) {
                stmt = conexao.prepareStatement(sql);
                stmt.setInt(1, id_emprestimo);

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Emprestimo com ID " + id_emprestimo + " removido com sucesso!");
                } else {
                    System.out.println("Nenhum emprestimo encontrado com ID " + id_emprestimo + " para remoção.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao remover emprestimo no PostgreSQL: " + e.getMessage());
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
