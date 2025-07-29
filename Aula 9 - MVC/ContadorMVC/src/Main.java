import Controller.ContadorController;
import Model.Contador;
import View.ContadorView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Contador model = new Contador();
        ContadorView view = new ContadorView();
        ContadorController controller = new ContadorController(model, view);

        controller.startCount();
        }
    }
