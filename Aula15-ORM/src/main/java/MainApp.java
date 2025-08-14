import Model.Aluno;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args){
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(Aluno.class);

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Aluno aluno = new Aluno();
        aluno.setNome("Jorge");
        aluno.setIdade(72);
        aluno.setContato("40028922");

        session.save(aluno);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}
