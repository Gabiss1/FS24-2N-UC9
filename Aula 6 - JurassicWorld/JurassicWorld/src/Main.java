import Conexao.ConexaoPostgresDB;
import DAO.DinossauroDAO;
import Model.Dinossauro;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        DinossauroDAO alunoDAO = new DinossauroDAO();

        // CREATE
        Dinossauro dinossauro1 = new Dinossauro("Brachiosaurus", "Brachiosaurus atithorax", "Herbívoro", "150M", 20, "Seguro");
        Dinossauro dinossauro2 = new Dinossauro("T-Rex", "Tyrannosaurus Rex", "Carnívoro", "66M", 15, "Seguro");
        Dinossauro dinossauro3 = new Dinossauro("Dilophosaurus", "Dilophosaurus wetherilli", "Carnívoro", "193M", 8, "Contido");
                ;

        // READ
        System.out.println("> Testando READ:");
        ArrayList<Dinossauro> dinossauros = DinossauroDAO.getDinossauro();
        if (!dinossauros.isEmpty()) {
            for (Dinossauro aluno : dinossauros) {
                System.out.println(dinossauros.getNome());
            }
        }

        // UPDATE
        System.out.println("> Testando UPDATE:");
        Dinossauro dinossauroAtualizado = new Dinossauro//(1, "Lucas", 11, 947213124);
        DinossauroDAO.updateDinossauro(dinossauroAtualizado);

        // REMOVE
        System.out.println("> Testando REMOVE");
        alunoDAO.removeDinossauro(2);

    }
}