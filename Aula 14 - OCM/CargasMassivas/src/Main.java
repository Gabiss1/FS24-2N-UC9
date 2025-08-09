import Controller.PokemonController;
import Model.Pokemon;
import View.ListaPokemonsPanel;
import View.PokemonForm;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {

    private JDesktopPane desktopPane;
    private PokemonController pokemonController;

    public Main() {
        super("Sistema de Gerenciamento de Pokémons");
        this.pokemonController = new PokemonController();

        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        desktopPane = new JDesktopPane();
        setContentPane(desktopPane);

        createMenuBar();
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // Menu Pokémons
        JMenu menuPokemons = new JMenu("Pokémons");
        JMenuItem itemCadastrarPokemon = new JMenuItem("Cadastrar Pokémon");
        JMenuItem itemListarPokemons = new JMenuItem("Listar Pokémons");
        JMenuItem itemInserirListarPokemons = new JMenuItem("Insere Lista de Pokemons");

        itemCadastrarPokemon.addActionListener(e -> openPokemonForm(null));
        itemListarPokemons.addActionListener(e -> openListaPokemonsPanel());
        itemInserirListarPokemons.addActionListener(e -> {
            try {
                InsereListaPokemons();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        menuPokemons.add(itemCadastrarPokemon);
        menuPokemons.add(itemListarPokemons);
        menuPokemons.add(itemInserirListarPokemons);

        menuBar.add(menuPokemons);

        // Menu Sair
        JMenu menuSair = new JMenu("Sair");
        JMenuItem itemSair = new JMenuItem("Sair do Sistema");
        itemSair.addActionListener(e -> System.exit(0));

        menuSair.add(itemSair);
        menuBar.add(menuSair);

        setJMenuBar(menuBar);
    }

    private void openPokemonForm(Integer idPokemon) {
        PokemonForm pokemonForm = new PokemonForm(pokemonController, idPokemon);
        desktopPane.add(pokemonForm);
        pokemonForm.setVisible(true);
        pokemonForm.toFront();
    }

    private void openListaPokemonsPanel() {
        ListaPokemonsPanel listaPokemons = new ListaPokemonsPanel(pokemonController);
        desktopPane.add(listaPokemons);
        listaPokemons.setVisible(true);
        listaPokemons.toFront();
    }

    private void InsereListaPokemons() throws Exception {
        List<Pokemon> listaPokemon = new ArrayList<>();
        Pokemon pikachu = new Pokemon("Pikachu", "Elétrico", null, 1, 100);
        Pokemon evee = new Pokemon("Evee", "Normal", null, 1, 100);
        listaPokemon.add(pikachu);
        listaPokemon.add(evee);
        pokemonController.insereListaPokemons(listaPokemon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }


}