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

    public List<Computer> getComputers(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from computer").list();
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

//    }
//    public List<Computer> getAllDefectiveComputers(){
//
//        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
//            System.out.println("\nChecking for any dried up thermalpaste...");
//            List<Computer> defComp = session.createQuery("from computer where needs_revision = 1", Computer.class).list();
//            if(defComp.isEmpty() == true){
//                System.out.println("It's all good!");
//            } else {
//                System.out.println("\nIt's revision day!");
//            }
//            return session.createQuery("from computer where needs_revision = 1", Computer.class).list();
//        }
//    }



}
