package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ConexaoPostgresDB {
    private static final String URL = "jdbc:postgresql://localhost:5432/JurassicWorld";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "root";

public static Connection conectar() {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o bd: " + e.getMessage());
        }
        return conexao;
    }

public static void fecharConexao(Connection conexao) {
    if (conexao != null) {
        try {
            conexao.close();
            System.out.println("Conexão com o bd fechada!");

        } catch (SQLException e) {
            System.err.println("Erro ao fechar a conexão com o bd: " + e.getMessage());
        }
    }
}

public static void setDinossauros(
            String nome,
            String especie,
            String dieta,
            int idade_estimada,
            int idade_dinossauro,
            String status_cercado)
            throws SQLException {
        String sql = "INSERT INTO dinossauros (nome, especie, dieta, idade_estimada, idade_dinossauro, status_cercado) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conexao = null;
        PreparedStatement stmt = null;
        try {
            conexao = conectar();
            if (conexao != null) {
                stmt = conexao.prepareStatement(sql);
                stmt.setString(1, nome);
                stmt.setString(2, especie);
                stmt.setString(3, dieta);
                stmt.setInt(4, idade_estimada);
                stmt.setInt(5, idade_dinossauro);
                stmt.setString(6, status_cercado);

                int linhasAfetadas = stmt.executeUpdate(); // Executa o INSERT
                if (linhasAfetadas > 0) {
                    System.out.println("Dinossauro " + nome + " inserido no BD com sucesso!");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir Dinossauro no Postgresql: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) fecharConexao(conexao);
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos após inserção: " + e.getMessage());
            }
        }
    }


public static void main (String[]args) throws SQLException {
       Connection testeConexao = conectar();
       if (testeConexao != null) {
       ConexaoPostgresDB.fecharConexao(testeConexao);
       }

    ConexaoPostgresDB.setDinossauros("Jorge", "Tiranossauro Rex", "Carnívoro", 30, 23, "Em fuga");
    ConexaoPostgresDB.setDinossauros("Max", "Velociraptor", "Carnívoro", 15, 10, "Seguro");
    ConexaoPostgresDB.setDinossauros("Zara", "Estegossauro", "Herbívoro", 20, 12, "Contido");
    ConexaoPostgresDB.setDinossauros("Rex", "Espinossauro", "Carnívoro", 28, 22, "Seguro");
    ConexaoPostgresDB.setDinossauros("Mila", "Anquilossauro", "Herbívoro", 18, 14, "Em laboratório");
}

}
