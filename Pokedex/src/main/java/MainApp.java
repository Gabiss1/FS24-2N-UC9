
import Controller.PokemonController;
import Model.Pokemon;
import Util.HibernateUtil;
import View.ListaPokemonPanel;
import View.PokemonForm;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class MainApp extends JFrame {

    private JDesktopPane desktopPane;
    private static PokemonController controller;

    public MainApp() {
        super("Sistema de Gerenciamento de Pokémons");
        this.controller = new PokemonController();

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
        JMenuItem itemInserirListaPokemons = new JMenuItem("Inserir Lista de Pokémons");

        itemCadastrarPokemon.addActionListener(e -> openPokemonForm(null));
        itemListarPokemons.addActionListener(e -> openListaPokemonsPanel());

        menuPokemons.add(itemCadastrarPokemon);
        menuPokemons.add(itemListarPokemons);
        menuPokemons.add(itemInserirListaPokemons);

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
        PokemonForm pokemonForm = new PokemonForm(controller, idPokemon);
        desktopPane.add(pokemonForm);
        pokemonForm.setVisible(true);
        pokemonForm.toFront();
    }

    private void openListaPokemonsPanel() {
        ListaPokemonPanel listaPokemons = new ListaPokemonPanel(controller);
        desktopPane.add(listaPokemons);
        listaPokemons.setVisible(true);
        listaPokemons.toFront();
    }

    public static void main(String[] args) {
        try {
            PokemonController controller = new PokemonController();

            controller.cadastrarPokemon("Bounsweet", "Grama", null, 15, 120);
            controller.cadastrarPokemon("Buizel", "Água", null, 36, 250);

            System.out.println("Pokémons cadastrados com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }

        SwingUtilities.invokeLater(() -> {
            new MainApp().setVisible(true);
        });
    }

    
}


//        public static void cadastrar () throws Exception {
//            controller.cadastrarPokemon("Torkoal", "Fire", null, 22, 65);
//        }

