package main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class PersonDAO {
//Function insert new peron
    PersonDaoDisplay personDaoDisplay =new PersonDaoDisplay();
    public void savePerson(Person person) {
        Transaction tx = null;
        try(Session session = HibernateUtil.createSessionFactory().openSession()){
            tx = session.beginTransaction();
            session.save(person);
            tx.commit();
        }catch(HibernateException e) {
            if(tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        }
        finally {
            HibernateUtil.close();
            //System.out.println("Operatiune executata cu succes");
            personDaoDisplay.successOperation();
        }
    }
    //Function for get all person from DB
    //@SuppressWarnings("unchecked")
    public List<Person>getAllPersons(){
        Transaction tx=null;
        List<Person> personList=null;
        try(Session session=HibernateUtil.createSessionFactory().openSession()){
            tx=session.beginTransaction();
            personList=session.createQuery("from Person").list();
            tx.commit();
        }catch(HibernateException e) {
            if(tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        }
        finally {
            HibernateUtil.close();
            //System.out.println("Operatiune executata cu succes");
            personDaoDisplay.successOperation();
        }
        return personList;
    }
    //Function for update data from person in DB
    public void updatePerson(Person person){
        Transaction tx=null;
        try(Session session=HibernateUtil.createSessionFactory().openSession()){
            tx= session.beginTransaction();
            session.saveOrUpdate(person);
            tx.commit();
        }catch(HibernateException e) {
            if(tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        }finally {
            HibernateUtil.close();
            //System.out.println("Operatiune executata cu succes");
            personDaoDisplay.successOperation();
        }
    }
    //Function for delete person in DB using ID
    public void deletePersom(int id){
        Transaction tx=null;
        Person person=null;
        try(Session session=HibernateUtil.createSessionFactory().openSession()){
            tx= session.beginTransaction();
            person=session.get(Person.class, id);
            session.delete(person);
            tx.commit();
        }catch(HibernateException e) {
            if(tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        }finally {
            HibernateUtil.close();
            //System.out.println("Operatiune executata cu succes");
            personDaoDisplay.successOperation();
        }
    }
    //Function for find a person by category
    public List<Person>getFindPerson(String category){
        Transaction tx=null;
        List<Person> personList=null;
        try(Session session=HibernateUtil.createSessionFactory().openSession()){
            tx=session.beginTransaction();
            switch (category){
                case "prenumele":
                    Scanner scanner14=new Scanner(System.in);
                    //System.out.print("Introduceti numele de cautare: ");
                    personDaoDisplay.inserNameSearch();
                    String hql1="from Person as p where p.prenumele='"+scanner14.nextLine()+"'";
                    Query query1= session.createQuery(hql1);
                    List<Person>personList1=query1.getResultList();
                    for(Person p:personList1){
                        System.out.println(p);
                    }
                    break;
                case "varsta":
                    Scanner scanner20=new Scanner(System.in);
                    Scanner scanner21=new Scanner(System.in);
                    //System.out.println("Introduceti varsta de cautare: ");
                    personDaoDisplay.insertAgeSearch();
                    System.out.print("min: "); int varMin= scanner20.nextInt();
                    System.out.print("max: "); int varMax= scanner21.nextInt();
                    //System.out.println(varMin+"  "+""+varMax);
                    String hql2="from Person as p where p.varsta between'"+varMin+"' and '"+varMax+"'";
                    Query query2= session.createQuery(hql2);
                    List<Person>personList2=query2.getResultList();
                    for(Person p:personList2){
                        System.out.println(p);
                    }
                    break;
                case "adresa":
                    Scanner scanner3=new Scanner(System.in);
                    //System.out.print("Introduceti adresa de cautare: ");
                    personDaoDisplay.insertAddressSearch();
                    String hql3="from Person as p where p.adresa='"+scanner3.nextLine()+"'";
                    Query query3= session.createQuery(hql3);
                    List<Person>personList3=query3.getResultList();
                    for(Person p:personList3){
                        System.out.println(p);
                    }
                    break;
                case "salariu":
                    Scanner scanner4=new Scanner(System.in);
                    Scanner scanner5=new Scanner(System.in);
                    //System.out.println("Introduceti salariu de cautare");
                    personDaoDisplay.insertSalarySearch();
                    System.out.print("min: "); int salMin= scanner4.nextInt();
                    System.out.print("max: "); int salMax= scanner5.nextInt();
                    String hql4="from Person as p where p.salariu between'"+salMin+"' and '"+salMax+"'";
                    Query query4= session.createQuery(hql4);
                    List<Person>personList4=query4.getResultList();
                    for(Person p:personList4){
                        System.out.println(p);
                    }
                    break;
                default:
                    //System.out.println("Criteriu neindentificat");
                    personDaoDisplay.categoryNotFind();
            }
            tx.commit();
        }catch(HibernateException e) {
            if(tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        }
        finally {
            HibernateUtil.close();
            //System.out.println("Operatiune executata cu succes");
            personDaoDisplay.successOperation();
        }
        return personList;
    }
}
