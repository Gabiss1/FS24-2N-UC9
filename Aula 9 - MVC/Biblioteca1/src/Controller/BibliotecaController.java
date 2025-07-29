//package Controller;
//
//import Model.Biblioteca.EmprestimoDAO;
//import Model.Emprestimo;
//import View.BibliotecaView;
//
//public class BibliotecaController {
//    private EmprestimoDAO model;
//    private BibliotecaView view;
//
//    public BibliotecaController(EmprestimoDAO model, BibliotecaView view){
//        this.model = model;
//        this.view = view;
//
//        this.view.incrementListener(func -> {
//            model.incrementar();
//            view.setValor(model.getValor());
//        });
//
//        this.view.decrementListener(func -> {
//            model.decrementar();
//            view.setValor(model.getValor());
//        });
//
//        view.setValor(model.getValor());
//    }
//
//    public void startCount(){
//        view.setVisible(true);
//    }
//}
