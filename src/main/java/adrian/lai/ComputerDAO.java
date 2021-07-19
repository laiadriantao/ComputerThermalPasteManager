package adrian.lai;

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
            return session.createQuery("from computer", Computer.class).list();
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
    }

}
