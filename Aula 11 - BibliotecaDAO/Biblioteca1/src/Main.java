import Model.DAO.AlunoDAO;
import Model.Aluno;
import Model.DAO.EmprestimoDAO;
import Model.DAO.LivroDAO;
import Model.Emprestimo;
import Model.Livro;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AlunoDAO alunoDAO = new AlunoDAO();

        System.out.println("\n--- Testando Inserção de ALUNOS ---");
        Aluno novoAluno1 = new Aluno(1,"Joana", 20, "99997777");
        alunoDAO.setAluno(novoAluno1);

        Aluno novoAluno2 = new Aluno(2,"Roberto", 25, "99667755");
        alunoDAO.setAluno(novoAluno2);

        Aluno novoAluno3 = new Aluno(3,"Bruno", 23, "99889975");
        alunoDAO.setAluno(novoAluno3);

        System.out.println("\n--- Testando Listagem de ALUNOS ---");
        List<Aluno> listaAlunos = alunoDAO.getAlunos();
        if (!listaAlunos.isEmpty()) {
            for (Aluno a : listaAlunos) {
                System.out.println(a.getNome());
            }

        }
        System.out.println("\n--- Testando Atualização de ALUNOS ---");
        Aluno alunoParaAtualizar = new Aluno(1, "Joana Silva", 21, "00099456");
        alunoDAO.atualizar(alunoParaAtualizar);
        System.out.println("\n--- Listagem após Atualização de ALUNOS ---");
        alunoDAO.getAlunos();

        System.out.println("\n--- Testando Remoção de ALUNOS ---");
        alunoDAO.removerAluno(2);
        System.out.println("\n--- Listagem de ALUNOS após Remoção ---");
        alunoDAO.getAlunos();

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        LivroDAO livroDAO = new LivroDAO();

        System.out.println("\n--- Testando Inserção de LIVROS ---");
        Livro novoLivro1 = new Livro(1, "Crepúsculo", "Stephanie Meyer", "Romance", "abc1");
        livroDAO.setLivro(novoLivro1);

        Livro novoLivro2 = new Livro(2, "Eclipse", "Stephanie Meyer", "Romance", "abc2");
        livroDAO.setLivro(novoLivro2);

        Livro novoLivro3 = new Livro(3, "Eclipse", "Stephanie Meyer", "Romance", "abc3");
        livroDAO.setLivro(novoLivro3);

        Livro novoLivro4 = new Livro(4, "Amanhecer", "Stephanie Meyer", "Romance", "abc4");
        livroDAO.setLivro(novoLivro4);

        System.out.println("\n--- Testando Listagem de LIVROS ---");
        List<Livro> listaLivros = livroDAO.getLivro();
        if (!listaLivros.isEmpty()) {
            for (Livro a : listaLivros) {
                System.out.println(a.getTitulo());
            }

        }
        System.out.println("\n--- Testando Atualização de LIVROS ---");
        Livro livroParaAtualizar = new Livro(2, "Lua Nova", "Stephanie Meyer", "Romance", "abc2");
        livroDAO.atualizarLivro(livroParaAtualizar);
        System.out.println("\n--- Listagem após Atualização de LIVROS ---");
        alunoDAO.getAlunos();

        System.out.println("\n--- Testando Remoção de LIVROS ---");
        livroDAO.removerLivro(3);
        System.out.println("\n--- Listagem de LIVROS após Remoção ---");
        livroDAO.getLivro();

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();

        System.out.println("\n--- Testando Inserção de EMPRESTIMOS ---");
        Emprestimo novoEmprestimo1 = new Emprestimo("20/07/2025", "24/07/2025", 1, 2, 1);
        emprestimoDAO.setEmprestimo(novoEmprestimo1);

        Emprestimo novoEmprestimo2 = new Emprestimo("18/06/2025", "20/06/2025", 2, 1, 2);
        emprestimoDAO.setEmprestimo(novoEmprestimo2);

        Emprestimo novoEmprestimo3 = new Emprestimo("10/04/2025", "13/04/2025", 1, 1, 3);
        emprestimoDAO.setEmprestimo(novoEmprestimo3);

        Emprestimo novoEmprestimo4 = new Emprestimo("15/03/2025", "18/03/2025", 4, 1, 4);
        emprestimoDAO.setEmprestimo(novoEmprestimo4);

        System.out.println("\n--- Testando Listagem de EMPRESTIMOS ---");
        List<Emprestimo> listaEmprestimos = emprestimoDAO.getEmprestimo();
        if (!listaEmprestimos.isEmpty()) {
        for (Emprestimo a : listaEmprestimos) {
            System.out.println(a.getId_emprestimo());
        }

    }
        System.out.println("\n--- Testando Atualização de EMPRESTIMOS ---");
        Emprestimo emprestimoParaAtualizar = new Emprestimo("16/06/2025", "21/06/2025", 2, 1, 2);
        emprestimoDAO.atualizarEmprestimo(emprestimoParaAtualizar);
        System.out.println("\n--- Listagem após Atualização de EMPRESTIMOS ---");
        emprestimoDAO.getEmprestimo();

        System.out.println("\n--- Testando Remoção de EMPRESTIMOS ---");
        emprestimoDAO.removerEmprestimo(3);
        System.out.println("\n--- Listagem de EMPRESTIMOS após Remoção ---");
        emprestimoDAO.getEmprestimo();
}
}