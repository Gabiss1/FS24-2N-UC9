import Dao.AlunoDAO;
import Model.Aluno;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AlunoDAO alunoDAO = new AlunoDAO();

        System.out.println("\n--- Testando Inserção ---");
        Aluno novoAluno1 = new Aluno("Joana", 20, "99997777");
        alunoDAO.setAluno(novoAluno1);

        Aluno novoAluno2 = new Aluno("Roberto", 25, "99667755");
        alunoDAO.setAluno(novoAluno2);

        System.out.println("\n--- Testando Listagem ---");
        List<Aluno> listaAlunos = alunoDAO.getAlunos();
        if (!listaAlunos.isEmpty()){
            for (Aluno a : listaAlunos){
                System.out.println(a.getNome());
            }

        }
        System.out.println("\n--- Testando Atualização ---");
        Aluno alunoParaAtualizar = new Aluno(1, "Joana Silva", 21, "00099456");
        alunoDAO.atualizar(alunoParaAtualizar);
        System.out.println("\n--- Listagem após Atualização ---");
        alunoDAO.getAlunos();

        System.out.println("\n--- Testando Remoção ---");
        alunoDAO.removerAluno(2);
        System.out.println("\n--- Listagem após Remoção ---");
        alunoDAO.getAlunos();
    }
}