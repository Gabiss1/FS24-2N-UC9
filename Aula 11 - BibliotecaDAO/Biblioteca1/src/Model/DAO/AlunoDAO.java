package Model.DAO;

import Conexao.ConexaoPostgresDB;
import Model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Conexao.ConexaoPostgresDB.conectar;
import static Conexao.ConexaoPostgresDB.fecharConexao;

public class AlunoDAO {

    public void setAluno(Aluno aluno){
        String sql = "INSERT INTO aluno (nome, idade, telefone) VALUES (?, ?, ?)";
        Connection conexao = null;
        PreparedStatement stmt = null;
        try {
            conexao = ConexaoPostgresDB.conectar();
            if (conexao != null) {
                stmt = conexao.prepareStatement(sql);
                stmt.setString(1, aluno.getNome());
                stmt.setInt(2, aluno.getIdade());
                stmt.setString(3, aluno.getTelefone());

                int linhasAfetadas = stmt.executeUpdate(); // Executa o INSERT
                if (linhasAfetadas > 0) {
                    System.out.println("Aluno " + aluno.getNome() + " inserido no BD com sucesso!");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir aluno no Postgresql: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) fecharConexao(conexao);
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos após inserção: " + e.getMessage());
            }
        }
    }

    public List<Aluno> getAlunos() {
        String sql = "SELECT id_aluno, nome, idade, telefone FROM aluno ORDER BY id_aluno";
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aluno> alunos = new ArrayList<>();

        try {
            conexao = ConexaoPostgresDB.conectar();
            if (conexao != null) {
                stmt = conexao.prepareStatement(sql);
                rs = stmt.executeQuery();
                System.out.println("\n--- Alunos Cadastrados no DB ---");
                boolean encontrouAluno = false;
                while (rs.next()) {
                    encontrouAluno = true;
                    int id_aluno = rs.getInt("id_aluno");
                    String nome = rs.getString("nome");
                    int idade = rs.getInt("idade");
                    String telefone = rs.getString("telefone");

                    Aluno aluno = new Aluno(id_aluno, nome, idade, telefone);
                    alunos.add(aluno);
                }
                if (!encontrouAluno) {
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
        return alunos;

    }

    public void atualizar(Aluno aluno) {
        String sql = "UPDATE aluno SET nome = ?, idade = ?, telefone = ? WHERE id_aluno = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;
        try {
            conexao = ConexaoPostgresDB.conectar();
            if (conexao != null) {
                stmt = conexao.prepareStatement(sql);
                stmt.setString(1, aluno.getNome());
                stmt.setInt(2, aluno.getIdade());
                stmt.setString(3, aluno.getTelefone());
                stmt.setInt(4, aluno.getId_aluno()); //O ID DO ALUNO QUE QUEREMOS ATUALIZAR
                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Aluno com ID " + aluno.getId_aluno() + " atualizado com sucesso!");
                } else {
                    System.out.println("Nenhum aluno encontrado com ID " + aluno.getId_aluno() + " para atualização.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar aluno no PostgreSQL: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) fecharConexao(conexao);
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos após atualização: " + e.getMessage());
            }
        }
    }

    public void removerAluno(int id_aluno) {
        String sql = "DELETE FROM aluno WHERE id_aluno = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;
        try {
            conexao = conectar();
            if (conexao != null) {
                stmt = conexao.prepareStatement(sql);
                stmt.setInt(1, id_aluno);

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Aluno com ID " + id_aluno + " removido com sucesso!");
                } else {
                    System.out.println("Nenhum aluno encontrado com ID " + id_aluno + " para remoção.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao remover aluno no PostgreSQL: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) fecharConexao(conexao);
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos após remoção: " + e.getMessage());
            }
        }
    }

    public Aluno buscarPorId(int idAluno) {
    }
}


