package Controller;

import Model.Contador;
import View.ContadorView;

public class ContadorController {
    private Contador model;
    private ContadorView view;

    public ContadorController(Contador model, ContadorView view){
        this.model = model;
        this.view = view;

        this.view.incrementListener(func -> {
            model.incrementar();
            view.setValor(model.getValor());
        });

        this.view.decrementListener(func -> {
            model.decrementar();
            view.setValor(model.getValor());
        });

        view.setValor(model.getValor());
    }

    public void startCount(){
        view.setVisible(true);
    }
}
