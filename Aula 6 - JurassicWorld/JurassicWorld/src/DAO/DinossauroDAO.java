package DAO;

import Model.Dinossauro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Conexao.ConexaoPostgresDB.conectar;
import static Conexao.ConexaoPostgresDB.fecharConexao;

public class DinossauroDAO {

    public static ArrayList<Dinossauro> getDinossauro() {
    }

    public void setDino(Dinossauro dinossauro) {
        String sql = "INSERT INTO dinossauro (nome, especie, dieta, idade_estimdada_anos, idade_dinossauro, status_cercado) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conexao = conectar(); PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, dinossauro.getNome());
            ps.setString(2, dinossauro.getEspecie());
            ps.setString(3, dinossauro.getIdade_estimada_anos());
            ps.setInt(4, dinossauro.getIdade_dinossauro());
            ps.setString(5, dinossauro.getStatus_cercado());

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) System.out.println("Relação inserida com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        public List<Dinossauro> getDinossauros() {
            String sql = "SELECT id_dinossauro, nome, especie, dieta, idade_estimada, idade_dinossauro, status_cercado ORDER BY id_dinossauro";
            Connection conexao = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            List<Dinossauro> dinossauros = new ArrayList<>();

            try {
                conexao = conectar();
                if (conexao != null) {
                    stmt = conexao.prepareStatement(sql);
                    rs = stmt.executeQuery();
                    System.out.println("\n--- Dinossauros Cadastrados no DB ---");
                    boolean encontrouDinossauro = false;
                    while (rs.next()) {
                        encontrouDinossauro = true;
                        int id_dinossauro = rs.getInt("id_dinossauro");
                        String nome = rs.getString("nome");
                        String especie = rs.getString("especie");
                        String dieta = rs.getString("dieta");
                        String idade_estimada = rs.getString("idade_estimada");
                        int idade_dinossauro = rs.getInt("idade_dinossauro");
                        String status_cercado = rs.getString("status_cercado");

                        System.out.println("ID: " + id_dinossauro + ", Nome: " + nome + ", Espécie: " + especie + ", Dieta: " + dieta + ", Idade Estimada: " + idade_estimada + ", Idade Atual: " + idade_dinossauro + ", Status: " + status_cercado);
                    }
                    if (!encontrouDinossauro) {
                        System.out.println("Nenhum dinossauro encontrado.");
                    }
                    System.out.println("---------------------------\n");
                }
            } catch (SQLException e) {
                System.err.println("Erro ao consultar dinossauros no DB: " + e.getMessage());
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    if (conexao != null) fecharConexao(conexao);
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar recursos após consulta: " + e.getMessage());
                }

            }
        }
    }
