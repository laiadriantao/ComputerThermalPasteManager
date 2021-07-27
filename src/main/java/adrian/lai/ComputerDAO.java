package adrian.lai;

import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ComputerDAO {

    public void saveComputer(Computer computer){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(computer);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
    public void updateComputer(Computer computer){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(computer);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
    public Computer getByIdComputer(int id){
        Transaction transaction = null;
        Computer computer = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.get(Computer.class, id);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
        }
        return computer;
    }
    public List<Computer> getAllComputers(){

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            //System.out.println("\nYour computer list");
            return session.createQuery("from computer", Computer.class).list();
        }
    }
    public List<Computer> getAllDefectiveComputers(){

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("\nChecking for any dried up thermalpaste...");
            List<Computer> defComp = session.createQuery("from computer where needs_revision = 1", Computer.class).list();
            if(defComp.isEmpty() == true){
                System.out.println("It's all good!");
            } else {
                System.out.println("\nIt's revision day!");
            }
            return session.createQuery("from computer where needs_revision = 1", Computer.class).list();
        }
    }
    public Computer deleteByIdComputers(int id){
        Transaction transaction = null;
        Computer computer = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            computer = session.get(Computer.class,id);
            session.remove(computer);
            transaction.commit();

        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }

        }
        return computer;
        //if it deletes the wrong id I get an exception that doesn't allow the program to continue.
    }



}
