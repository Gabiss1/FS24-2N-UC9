package Controller;

import Model.Aluno;
import Model.DAO.AlunoDAO;

import java.time.LocalDate; //para usar date
import java.util.List;

public class AlunoController {
        private AlunoDAO alunoDAO;

public AlunoController() {
            this.alunoDAO = new AlunoDAO();
        }

public void cadastrarAluno(int id_aluno, String nome, int idade, String telefone) throws Exception {

            if (String.valueOf(id_aluno) == null || String.valueOf(id_aluno).trim().isEmpty()) {
            throw new Exception("O ID do aluno é obrigatório.");
            }
            if (nome == null || nome.trim().isEmpty()) {
                throw new Exception("O nome do aluno é obrigatório.");
            }
            if (String.valueOf(idade) == null || String.valueOf(idade).trim().isEmpty()) {
                throw new Exception("A idade do aluno é obrigatória.");
            }
            if (telefone == null || telefone.trim().isEmpty()) {
                throw new Exception("Telefone é obrigatório.");
            }

Aluno aluno = new Aluno(id_aluno, nome, idade, telefone);
            alunoDAO.inserir(aluno);
        }

public Aluno buscarAlunoPorId(int id_aluno) {
            return alunoDAO.buscarPorId(id_aluno);
        }

public void atualizarAluno(int id_aluno, String nome, int idade, String telefone) throws Exception {
            if (nome == null || nome.trim().isEmpty() || String.valueOf(idade) == null || telefone.trim().isEmpty()) {
                throw new Exception("Todos os campos do dinossauro são obrigatórios e devem ser válidos.");
            }

Dinossauro dinossauro = new Dinossauro(id, nome, especie, dieta, idade_estimada, idade, status);
            dinossauroDAO.atualizar(dinossauro);
        }

public List<Dinossauro> listarTodosDinossauros() {
            return dinossauroDAO.listarTodos();
        }

public void removerDinossauro(int id) {
            dinossauroDAO.remover(id);
        }

public List<Dinossauro> buscarDinossauroPorNome(String nome) {
            return dinossauroDAO.buscarPorNome(nome);
        }
}

