package View;

import Controller.PokemonController;
import Model.Pokemon;
import Model.Treinador;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListaPokemonsPanel extends JInternalFrame {
    private PokemonController controller;
    private JTable tabelaPokemons;
    private DefaultTableModel tableModel;
    private JButton btnAtualizar, btnRemover, btnBuscar, btnEditar;
    private JTextField txtBuscaNome;
    private JTextField txtBuscaPorTreinador;

    public ListaPokemonsPanel(PokemonController controller) {
        super("Lista de Pokémons", true, true, true, true);
        this.controller = controller;

        setSize(900, 500);
        setLayout(new BorderLayout());

        String[] colunas = {"ID", "Nome", "Tipo Primário", "Tipo Secundário", "Nível", "HP Máximo", "Treinador"};
        tableModel = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabelaPokemons = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabelaPokemons);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelAcoes = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtBuscaNome = new JTextField(20);
        txtBuscaPorTreinador = new JTextField(20);
        btnBuscar = new JButton("Buscar por Nome");
        btnBuscar = new JButton("Buscar por Treinador");
        btnAtualizar = new JButton("Atualizar Tabela");
        btnRemover = new JButton("Remover Selecionado");
        btnEditar = new JButton("Editar Selecionado");

        panelAcoes.add(new JLabel("Nome:"));
        panelAcoes.add(txtBuscaNome);
        panelAcoes.add(txtBuscaPorTreinador);
        panelAcoes.add(btnBuscar);
        panelAcoes.add(btnAtualizar);
        panelAcoes.add(btnRemover);
        panelAcoes.add(btnEditar);
        add(panelAcoes, BorderLayout.NORTH);

        btnAtualizar.addActionListener(e -> carregarPokemonsNaTabela());
        btnRemover.addActionListener(e -> removerPokemonSelecionado());
        btnBuscar.addActionListener(e -> buscarPokemonsPorNome());
        btnBuscar.addActionListener(e -> buscarPokemonsPorTreinador());
        btnEditar.addActionListener(e -> editarPokemonSelecionado());


    }

    private void carregarPokemonsNaTabela() {
        tableModel.setRowCount(0);
        List<Pokemon> pokemons = controller.listarTodosPokemons();
        for (Pokemon pokemon : pokemons) {
            tableModel.addRow(new Object[]{
                    pokemon.getId(),
                    pokemon.getNome(),
                    pokemon.getTipoPrimario(),
                    pokemon.getTipoSecundario() != null ? pokemon.getTipoSecundario() : "",
                    pokemon.getNivel(),
                    pokemon.getHpMaximo()
            });
        }
    }

    private void removerPokemonSelecionado() {
        int selectedRow = tabelaPokemons.getSelectedRow();
        if (selectedRow >= 0) {
            int idPokemon = (int) tableModel.getValueAt(selectedRow, 0);

            int confirm = JOptionPane.showConfirmDialog(this,
                    "Tem certeza que deseja remover o Pokémon ID: " + idPokemon + "?",
                    "Confirmar Remoção", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    controller.removerPokemon(idPokemon);
                    JOptionPane.showMessageDialog(this, "Pokémon removido com sucesso!");
                    carregarPokemonsNaTabela();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao remover Pokémon: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um Pokémon para remover.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void buscarPokemonsPorNome() {
        String nomeBusca = txtBuscaNome.getText().trim();
        tableModel.setRowCount(0);

        Pokemon pokemons = controller.buscarPokemonPorNome(nomeBusca);

        if (pokemons.getNome().isEmpty() && !nomeBusca.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum Pokémon encontrado com o nome: '" + nomeBusca + "'", "Busca", JOptionPane.INFORMATION_MESSAGE);
        }

        tableModel.addRow(new Object[]{
                pokemons.getId(),
                pokemons.getNome(),
                pokemons.getTipoPrimario(),
                pokemons.getTipoSecundario() != null ? pokemons.getTipoSecundario() : "",
                pokemons.getNivel(),
                pokemons.getHpMaximo(),
                pokemons.getFK_Treinador()
        });
    }

    private void buscarPokemonsPorTreinador() {
        String nomeTreinadorBusca = txtBuscaPorTreinador.getText().trim();
        tableModel.setRowCount(0);

        Treinador pokemons = controller.buscarPokemonsPorTreinador(nomeTreinadorBusca);

        if (pokemons.getNome().isEmpty() && !nomeTreinadorBusca.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum Pokémon encontrado com o nome: '" + nomeTreinadorBusca + "'", "Busca", JOptionPane.INFORMATION_MESSAGE);
        }

        tableModel.addRow(new Object[]{
                pokemons.getId_treinador(),
                pokemons.getNome(),
                pokemons.getCidade()

        });
        }

    private void editarPokemonSelecionado() {
        int selectedRow = tabelaPokemons.getSelectedRow();
        if (selectedRow >= 0) {
            int idPokemon = (int) tableModel.getValueAt(selectedRow, 0);

            PokemonForm pokemonForm = new PokemonForm(controller, idPokemon);
            this.getDesktopPane().add(pokemonForm);
            pokemonForm.setVisible(true);
            pokemonForm.toFront();

            pokemonForm.addInternalFrameListener(new InternalFrameAdapter() {
                @Override
                public void internalFrameClosed(InternalFrameEvent e) {
                    carregarPokemonsNaTabela();
                }
            });

        } else {
            JOptionPane.showMessageDialog(this, "Selecione um Pokémon para editar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

}