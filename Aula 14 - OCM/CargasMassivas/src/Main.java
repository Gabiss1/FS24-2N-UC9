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
        Pokemon alolanRattata = new Pokemon("Alolan Rattata", "Dark", "Normal", 1, 100);
        Pokemon alolanRaticate = new Pokemon("Alolan Raticate", "Dark", "Normal", 1, 100);
        Pokemon alolanRaichu = new Pokemon("Alolan Raichu", "Electric", "Psychic", 1, 100);
        Pokemon alolanSandshrew = new Pokemon("Alolan Sandshrew", "Ice", "Steel", 1, 100);
        Pokemon alolanSandslash = new Pokemon("Alolan Sandslash", "Ice", "Steel", 1, 100);
        Pokemon alolanVulpix = new Pokemon("Alolan Vulpix", "Ice", null, 1, 100);
        Pokemon alolanNinetales = new Pokemon("Alolan Ninetales", "Ice", "Fairy", 1, 100);
        Pokemon alolanDiglett = new Pokemon("Alolan Diglett", "Ground", "Steel", 1, 100);
        Pokemon alolanDugtrio = new Pokemon("Alolan Dugtrio", "Ground", "Steel", 1, 100);
        Pokemon alolanMeowth = new Pokemon("Alolan Meowth", "Dark", null, 1, 100);
        Pokemon alolanPersian = new Pokemon("Alolan Persian", "Dark", null, 1, 100);
        Pokemon alolanGeodude = new Pokemon("Alolan Geodude", "Rock", "Electric", 1, 100);
        Pokemon alolanGraveler = new Pokemon("Alolan Graveler", "Rock", "Electric", 1, 100);
        Pokemon alolanGolem = new Pokemon("Alolan Golem", "Rock", "Electric", 1, 100);
        Pokemon alolanGrimer = new Pokemon("Alolan Grimer", "Poison", "Dark", 1, 100);
        Pokemon alolanMuk = new Pokemon("Alolan Muk", "Poison", "Dark", 1, 100);
        Pokemon alolanExeggutor = new Pokemon("Alolan Exeggutor", "Grass", "Dragon", 1, 100);
        Pokemon alolanMarowak = new Pokemon("Alolan Marowak", "Fire", "Ghost", 1, 100);

        listaPokemon.add(alolanRattata);
        listaPokemon.add(alolanRaticate);
        listaPokemon.add(alolanRaichu);
        listaPokemon.add(alolanSandshrew);
        listaPokemon.add(alolanSandslash);
        listaPokemon.add(alolanVulpix);
        listaPokemon.add(alolanNinetales);
        listaPokemon.add(alolanDiglett);
        listaPokemon.add(alolanDugtrio);
        listaPokemon.add(alolanMeowth);
        listaPokemon.add(alolanPersian);
        listaPokemon.add(alolanGeodude);
        listaPokemon.add(alolanGraveler);
        listaPokemon.add(alolanGolem);
        listaPokemon.add(alolanGrimer);
        listaPokemon.add(alolanMuk);
        listaPokemon.add(alolanExeggutor);
        listaPokemon.add(alolanMarowak);


        Pokemon pikachu = new Pokemon("Pikachu", "Elétrico", null, 1, 100);
        Pokemon evee = new Pokemon("Evee", "Normal", null, 1, 100);
        Pokemon bulbasaur = new Pokemon("Bulbasaur", "Grass", "Poison", 5, 150);
        Pokemon ivysaur = new Pokemon("Ivysaur", "Grass", "Poison", 16, 200);
        Pokemon venusaur = new Pokemon("Venusaur", "Grass", "Poison", 32, 250);
        Pokemon charmander = new Pokemon("Charmander", "Fire", null, 5, 120);
        Pokemon charmeleon = new Pokemon("Charmeleon", "Fire", null, 16, 180);
        Pokemon charizard = new Pokemon("Charizard", "Fire", "Flying", 36, 300);
        Pokemon squirtle = new Pokemon("Squirtle", "Water", null, 5, 130);
        Pokemon wartortle = new Pokemon("Wartortle", "Water", null, 16, 190);
        Pokemon blastoise = new Pokemon("Blastoise", "Water", null, 36, 290);
        Pokemon caterpie = new Pokemon("Caterpie", "Bug", null, 3, 80);
        Pokemon metapod = new Pokemon("Metapod", "Bug", null, 7, 90);
        Pokemon butterfree = new Pokemon("Butterfree", "Bug", "Flying", 10, 140);
        Pokemon weedle = new Pokemon("Weedle", "Bug", "Poison", 3, 80);
        Pokemon kakuna = new Pokemon("Kakuna", "Bug", "Poison", 7, 90);
        Pokemon beedrill = new Pokemon("Beedrill", "Bug", "Poison", 10, 160);
        Pokemon pidgey = new Pokemon("Pidgey", "Normal", "Flying", 3, 100);
        Pokemon pidgeotto = new Pokemon("Pidgeotto", "Normal", "Flying", 18, 160);
        Pokemon pidgeot = new Pokemon("Pidgeot", "Normal", "Flying", 36, 230);
        Pokemon rattata = new Pokemon("Rattata", "Normal", null, 2, 90);
        Pokemon raticate = new Pokemon("Raticate", "Normal", null, 20, 170);
        Pokemon spearow = new Pokemon("Spearow", "Normal", "Flying", 5, 110);
        Pokemon fearow = new Pokemon("Fearow", "Normal", "Flying", 20, 190);
        Pokemon ekans = new Pokemon("Ekans", "Poison", null, 6, 120);
        Pokemon arbok = new Pokemon("Arbok", "Poison", null, 22, 220);
        Pokemon raichu = new Pokemon("Raichu", "Electric", null, 26, 210);
        Pokemon sandshrew = new Pokemon("Sandshrew", "Ground", null, 5, 110);
        Pokemon sandslash = new Pokemon("Sandslash", "Ground", null, 22, 200);
        Pokemon nidoranf = new Pokemon("Nidoran♀", "Poison", null, 5, 105);
        Pokemon nidorina = new Pokemon("Nidorina", "Poison", null, 16, 165);
        Pokemon nidoqueen = new Pokemon("Nidoqueen", "Poison", "Ground", 36, 260);
        Pokemon nidoranm = new Pokemon("Nidoran♂", "Poison", null, 5, 105);
        Pokemon nidorino = new Pokemon("Nidorino", "Poison", null, 16, 165);
        Pokemon nidoking = new Pokemon("Nidoking", "Poison", "Ground", 36, 260);
        Pokemon clefairy = new Pokemon("Clefairy", "Fairy", null, 5, 140);
        Pokemon clefable = new Pokemon("Clefable", "Fairy", null, 36, 260);
        Pokemon vulpix = new Pokemon("Vulpix", "Fire", null, 5, 115);
        Pokemon ninetales = new Pokemon("Ninetales", "Fire", null, 36, 245);
        Pokemon jigglypuff = new Pokemon("Jigglypuff", "Normal", "Fairy", 5, 160);
        Pokemon wigglytuff = new Pokemon("Wigglytuff", "Normal", "Fairy", 36, 280);
        Pokemon zubat = new Pokemon("Zubat", "Poison", "Flying", 5, 105);
        Pokemon golbat = new Pokemon("Golbat", "Poison", "Flying", 22, 210);
        Pokemon oddish = new Pokemon("Oddish", "Grass", "Poison", 5, 120);
        Pokemon gloom = new Pokemon("Gloom", "Grass", "Poison", 21, 180);
        Pokemon vileplume = new Pokemon("Vileplume", "Grass", "Poison", 36, 260);
        Pokemon paras = new Pokemon("Paras", "Bug", "Grass", 5, 115);
        Pokemon parasect = new Pokemon("Parasect", "Bug", "Grass", 25, 190);
        Pokemon venonat = new Pokemon("Venonat", "Bug", "Poison", 5, 120);
        Pokemon venomoth = new Pokemon("Venomoth", "Bug", "Poison", 31, 200);
        Pokemon diglett = new Pokemon("Diglett", "Ground", null, 5, 100);
        Pokemon dugtrio = new Pokemon("Dugtrio", "Ground", null, 26, 190);
        Pokemon meowth = new Pokemon("Meowth", "Normal", null, 5, 110);
        Pokemon persian = new Pokemon("Persian", "Normal", null, 28, 200);
        Pokemon psyduck = new Pokemon("Psyduck", "Water", null, 5, 120);
        Pokemon golduck = new Pokemon("Golduck", "Water", null, 33, 230);
        Pokemon mankey = new Pokemon("Mankey", "Fighting", null, 5, 115);
        Pokemon primeape = new Pokemon("Primeape", "Fighting", null, 28, 200);
        Pokemon growlithe = new Pokemon("Growlithe", "Fire", null, 5, 130);
        Pokemon arcanine = new Pokemon("Arcanine", "Fire", null, 36, 270);
        Pokemon poliwag = new Pokemon("Poliwag", "Water", null, 5, 110);
        Pokemon poliwhirl = new Pokemon("Poliwhirl", "Water", null, 25, 180);
        Pokemon poliwrath = new Pokemon("Poliwrath", "Water", "Fighting", 36, 260);
        Pokemon abra = new Pokemon("Abra", "Psychic", null, 5, 105);
        Pokemon kadabra = new Pokemon("Kadabra", "Psychic", null, 16, 170);
        Pokemon alakazam = new Pokemon("Alakazam", "Psychic", null, 36, 240);
        Pokemon machop = new Pokemon("Machop", "Fighting", null, 5, 110);
        Pokemon machoke = new Pokemon("Machoke", "Fighting", null, 28, 200);
        Pokemon machamp = new Pokemon("Machamp", "Fighting", null, 36, 260);
        Pokemon bellsprout = new Pokemon("Bellsprout", "Grass", "Poison", 5, 110);
        Pokemon weepinbell = new Pokemon("Weepinbell", "Grass", "Poison", 21, 180);
        Pokemon victreebel = new Pokemon("Victreebel", "Grass", "Poison", 36, 250);
        Pokemon tentacool = new Pokemon("Tentacool", "Water", "Poison", 5, 120);
        Pokemon tentacruel = new Pokemon("Tentacruel", "Water", "Poison", 36, 260);
        Pokemon geodude = new Pokemon("Geodude", "Rock", "Ground", 5, 120);
        Pokemon graveler = new Pokemon("Graveler", "Rock", "Ground", 25, 200);
        Pokemon golem = new Pokemon("Golem", "Rock", "Ground", 36, 300);
        Pokemon ponyta = new Pokemon("Ponyta", "Fire", null, 5, 110);
        Pokemon rapidash = new Pokemon("Rapidash", "Fire", null, 40, 230);
        Pokemon slowpoke = new Pokemon("Slowpoke", "Water", "Psychic", 5, 130);
        Pokemon slowbro = new Pokemon("Slowbro", "Water", "Psychic", 37, 260);
        Pokemon magnemite = new Pokemon("Magnemite", "Electric", "Steel", 5, 110);
        Pokemon magneton = new Pokemon("Magneton", "Electric", "Steel", 30, 220);
        Pokemon farfetchd = new Pokemon("Farfetch'd", "Normal", "Flying", 5, 120);
        Pokemon doduo = new Pokemon("Doduo", "Normal", "Flying", 5, 130);
        Pokemon dodrio = new Pokemon("Dodrio", "Normal", "Flying", 31, 240);
        Pokemon seel = new Pokemon("Seel", "Water", null, 5, 120);
        Pokemon dewgong = new Pokemon("Dewgong", "Water", "Ice", 34, 220);
        Pokemon grimer = new Pokemon("Grimer", "Poison", null, 5, 120);
        Pokemon muk = new Pokemon("Muk", "Poison", null, 34, 230);
        Pokemon shellder = new Pokemon("Shellder", "Water", null, 5, 110);
        Pokemon cloyster = new Pokemon("Cloyster", "Water", "Ice", 35, 250);
        Pokemon gastly = new Pokemon("Gastly", "Ghost", "Poison", 5, 100);
        Pokemon haunter = new Pokemon("Haunter", "Ghost", "Poison", 25, 130);
        Pokemon gengar = new Pokemon("Gengar", "Ghost", "Poison", 36, 190);
        Pokemon onix = new Pokemon("Onix", "Rock", "Ground", 10, 160);
        Pokemon drowzee = new Pokemon("Drowzee", "Psychic", null, 5, 100);
        Pokemon hypno = new Pokemon("Hypno", "Psychic", null, 26, 180);
        Pokemon krabby = new Pokemon("Krabby", "Water", null, 5, 90);
        Pokemon kingler = new Pokemon("Kingler", "Water", null, 28, 180);
        Pokemon voltorb = new Pokemon("Voltorb", "Electric", null, 5, 90);
        Pokemon electrode = new Pokemon("Electrode", "Electric", null, 30, 170);
        Pokemon exeggcute = new Pokemon("Exeggcute", "Grass", "Psychic", 5, 85);
        Pokemon exeggutor = new Pokemon("Exeggutor", "Grass", "Psychic", 36, 220);
        Pokemon cubone = new Pokemon("Cubone", "Ground", null, 5, 90);
        Pokemon marowak = new Pokemon("Marowak", "Ground", null, 28, 180);
        Pokemon hitmonlee = new Pokemon("Hitmonlee", "Fighting", null, 32, 190);
        Pokemon hitmonchan = new Pokemon("Hitmonchan", "Fighting", null, 32, 190);
        Pokemon lickitung = new Pokemon("Lickitung", "Normal", null, 15, 160);
        Pokemon koffing = new Pokemon("Koffing", "Poison", null, 5, 85);
        Pokemon weezing = new Pokemon("Weezing", "Poison", null, 32, 190);
        Pokemon rhyhorn = new Pokemon("Rhyhorn", "Ground", "Rock", 5, 110);
        Pokemon rhydon = new Pokemon("Rhydon", "Ground", "Rock", 40, 230);
        Pokemon chansey = new Pokemon("Chansey", "Normal", null, 30, 350);
        Pokemon tangela = new Pokemon("Tangela", "Grass", null, 25, 190);
        Pokemon kangaskhan = new Pokemon("Kangaskhan", "Normal", null, 35, 230);
        Pokemon horsea = new Pokemon("Horsea", "Water", null, 5, 85);
        Pokemon seadra = new Pokemon("Seadra", "Water", null, 30, 170);
        Pokemon goldeen = new Pokemon("Goldeen", "Water", null, 5, 90);
        Pokemon seaking = new Pokemon("Seaking", "Water", null, 33, 180);
        Pokemon staryu = new Pokemon("Staryu", "Water", null, 5, 85);
        Pokemon starmie = new Pokemon("Starmie", "Water", "Psychic", 36, 200);
        Pokemon mrMime = new Pokemon("Mr. Mime", "Psychic", "Fairy", 30, 190);
        Pokemon scyther = new Pokemon("Scyther", "Bug", "Flying", 35, 210);
        Pokemon jynx = new Pokemon("Jynx", "Ice", "Psychic", 30, 190);
        Pokemon electabuzz = new Pokemon("Electabuzz", "Electric", null, 30, 190);
        Pokemon magmar = new Pokemon("Magmar", "Fire", null, 30, 190);
        Pokemon pinsir = new Pokemon("Pinsir", "Bug", null, 30, 200);
        Pokemon tauros = new Pokemon("Tauros", "Normal", null, 30, 210);
        Pokemon magikarp = new Pokemon("Magikarp", "Water", null, 5, 45);
        Pokemon gyarados = new Pokemon("Gyarados", "Water", "Flying", 40, 280);
        Pokemon lapras = new Pokemon("Lapras", "Water", "Ice", 35, 270);
        Pokemon ditto = new Pokemon("Ditto", "Normal", null, 5, 90);
        Pokemon vaporeon = new Pokemon("Vaporeon", "Water", null, 30, 230);
        Pokemon jolteon = new Pokemon("Jolteon", "Electric", null, 30, 210);
        Pokemon flareon = new Pokemon("Flareon", "Fire", null, 30, 220);
        Pokemon porygon = new Pokemon("Porygon", "Normal", null, 25, 180);
        Pokemon omanyte = new Pokemon("Omanyte", "Rock", "Water", 5, 80);
        Pokemon omastar = new Pokemon("Omastar", "Rock", "Water", 40, 210);
        Pokemon kabuto = new Pokemon("Kabuto", "Rock", "Water", 5, 80);
        Pokemon kabutops = new Pokemon("Kabutops", "Rock", "Water", 40, 210);
        Pokemon aerodactyl = new Pokemon("Aerodactyl", "Rock", "Flying", 40, 220);
        Pokemon snorlax = new Pokemon("Snorlax", "Normal", null, 35, 300);
        Pokemon articuno = new Pokemon("Articuno", "Ice", "Flying", 50, 260);
        Pokemon zapdos = new Pokemon("Zapdos", "Electric", "Flying", 50, 260);
        Pokemon moltres = new Pokemon("Moltres", "Fire", "Flying", 50, 260);
        Pokemon dratini = new Pokemon("Dratini", "Dragon", null, 5, 90);
        Pokemon dragonair = new Pokemon("Dragonair", "Dragon", null, 30, 180);
        Pokemon dragonite = new Pokemon("Dragonite", "Dragon", "Flying", 55, 300);
        Pokemon mewtwo = new Pokemon("Mewtwo", "Psychic", null, 70, 320);
        Pokemon mew = new Pokemon("Mew", "Psychic", null, 50, 280);

        listaPokemon.add(pikachu);
        listaPokemon.add(evee);
        listaPokemon.add(bulbasaur);
        listaPokemon.add(ivysaur);
        listaPokemon.add(venusaur);
        listaPokemon.add(charmander);
        listaPokemon.add(charmeleon);
        listaPokemon.add(charizard);
        listaPokemon.add(squirtle);
        listaPokemon.add(wartortle);
        listaPokemon.add(blastoise);
        listaPokemon.add(caterpie);
        listaPokemon.add(metapod);
        listaPokemon.add(butterfree);
        listaPokemon.add(weedle);
        listaPokemon.add(kakuna);
        listaPokemon.add(beedrill);
        listaPokemon.add(pidgey);
        listaPokemon.add(pidgeotto);
        listaPokemon.add(pidgeot);
        listaPokemon.add(rattata);
        listaPokemon.add(raticate);
        listaPokemon.add(spearow);
        listaPokemon.add(fearow);
        listaPokemon.add(ekans);
        listaPokemon.add(arbok);
        listaPokemon.add(raichu);
        listaPokemon.add(sandshrew);
        listaPokemon.add(sandslash);
        listaPokemon.add(nidoranf);
        listaPokemon.add(nidorina);
        listaPokemon.add(nidoqueen);
        listaPokemon.add(nidoranm);
        listaPokemon.add(nidorino);
        listaPokemon.add(nidoking);
        listaPokemon.add(clefairy);
        listaPokemon.add(clefable);
        listaPokemon.add(vulpix);
        listaPokemon.add(ninetales);
        listaPokemon.add(jigglypuff);
        listaPokemon.add(wigglytuff);
        listaPokemon.add(zubat);
        listaPokemon.add(golbat);
        listaPokemon.add(oddish);
        listaPokemon.add(gloom);
        listaPokemon.add(vileplume);
        listaPokemon.add(paras);
        listaPokemon.add(parasect);
        listaPokemon.add(venonat);
        listaPokemon.add(venomoth);
        listaPokemon.add(diglett);
        listaPokemon.add(dugtrio);
        listaPokemon.add(meowth);
        listaPokemon.add(persian);
        listaPokemon.add(psyduck);
        listaPokemon.add(golduck);
        listaPokemon.add(mankey);
        listaPokemon.add(primeape);
        listaPokemon.add(growlithe);
        listaPokemon.add(arcanine);
        listaPokemon.add(poliwag);
        listaPokemon.add(poliwhirl);
        listaPokemon.add(poliwrath);
        listaPokemon.add(abra);
        listaPokemon.add(kadabra);
        listaPokemon.add(alakazam);
        listaPokemon.add(machop);
        listaPokemon.add(machoke);
        listaPokemon.add(machamp);
        listaPokemon.add(bellsprout);
        listaPokemon.add(weepinbell);
        listaPokemon.add(victreebel);
        listaPokemon.add(tentacool);
        listaPokemon.add(tentacruel);
        listaPokemon.add(geodude);
        listaPokemon.add(graveler);
        listaPokemon.add(golem);
        listaPokemon.add(ponyta);
        listaPokemon.add(rapidash);
        listaPokemon.add(slowpoke);
        listaPokemon.add(slowbro);
        listaPokemon.add(magnemite);
        listaPokemon.add(magneton);
        listaPokemon.add(farfetchd);
        listaPokemon.add(doduo);
        listaPokemon.add(dodrio);
        listaPokemon.add(seel);
        listaPokemon.add(dewgong);
        listaPokemon.add(grimer);
        listaPokemon.add(muk);
        listaPokemon.add(shellder);
        listaPokemon.add(cloyster);
        listaPokemon.add(gastly);
        listaPokemon.add(haunter);
        listaPokemon.add(gengar);
        listaPokemon.add(onix);
        listaPokemon.add(drowzee);
        listaPokemon.add(hypno);
        listaPokemon.add(krabby);
        listaPokemon.add(kingler);
        listaPokemon.add(voltorb);
        listaPokemon.add(electrode);
        listaPokemon.add(exeggcute);
        listaPokemon.add(exeggutor);
        listaPokemon.add(cubone);
        listaPokemon.add(marowak);
        listaPokemon.add(hitmonlee);
        listaPokemon.add(hitmonchan);
        listaPokemon.add(lickitung);
        listaPokemon.add(koffing);
        listaPokemon.add(weezing);
        listaPokemon.add(rhyhorn);
        listaPokemon.add(rhydon);
        listaPokemon.add(chansey);
        listaPokemon.add(tangela);
        listaPokemon.add(kangaskhan);
        listaPokemon.add(horsea);
        listaPokemon.add(seadra);
        listaPokemon.add(goldeen);
        listaPokemon.add(seaking);
        listaPokemon.add(staryu);
        listaPokemon.add(starmie);
        listaPokemon.add(mrMime);
        listaPokemon.add(scyther);
        listaPokemon.add(jynx);
        listaPokemon.add(electabuzz);
        listaPokemon.add(magmar);
        listaPokemon.add(pinsir);
        listaPokemon.add(tauros);
        listaPokemon.add(magikarp);
        listaPokemon.add(gyarados);
        listaPokemon.add(lapras);
        listaPokemon.add(ditto);
        listaPokemon.add(vaporeon);
        listaPokemon.add(jolteon);
        listaPokemon.add(flareon);
        listaPokemon.add(porygon);
        listaPokemon.add(omanyte);
        listaPokemon.add(omastar);
        listaPokemon.add(kabuto);
        listaPokemon.add(kabutops);
        listaPokemon.add(aerodactyl);
        listaPokemon.add(snorlax);
        listaPokemon.add(articuno);
        listaPokemon.add(zapdos);
        listaPokemon.add(moltres);
        listaPokemon.add(dratini);
        listaPokemon.add(dragonair);
        listaPokemon.add(dragonite);
        listaPokemon.add(mewtwo);
        listaPokemon.add(mew);

        pokemonController.insereListaPokemons(listaPokemon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

}