package adrian.lai;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ComputerDAO {

//method to save a Computer Object
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

    //method to update Computer Object
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

//Method to delete a Computer Object
    public void deleteComputer(Computer id){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.delete(id);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
        }

    }

    //method to get all Computer objects in the form of  a list
    public List<Computer> getComputers(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from computer").list();
        }
    }

    //method to get all Computer objects that need revision
    public List<Computer> getAllDefectiveComputers(){

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            //System.out.println("\nChecking for any dried up thermalpaste...");
            List<Computer> defComp = session.createQuery("from computer where needs_revision = 1", Computer.class).list();
            return defComp;
        }
    }
    //    public Computer getByIdComputer(int id){
//        Transaction transaction = null;
//        Computer computer = null;
//        try(Session session = HibernateUtil.getSessionFactory().openSession()){
//            transaction = session.beginTransaction();
//            session.get(Computer.class, id);
//            transaction.commit();
//        } catch (Exception e) {
//            if(transaction != null){
//                transaction.rollback();
//            }
//        }
//        return computer;
//    }


}
