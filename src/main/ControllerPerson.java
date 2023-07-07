package main;

import java.util.Scanner;
public class ControllerPerson {
    private static int numberSellOp;
    boolean repeta=false;
    public int getNumberSellOp() {
        return numberSellOp;
    }

    public void setNumberSellOp(int numberSellOp) {
        this.numberSellOp = numberSellOp;
    }
        public void operationSet(){
            do {
                System.out.println("va rugam sa alegeti una din optiuni:\n"+
                        "1.Adaugare persoana noua \n"+
                        "2.Afisare toti angajatii \n"+
                        "3.Modificare date dupa ID angajat \n"+
                        "4.Stergere persoana dupa ID \n"+
                        "5.Gaseste persoana dupa criteriu \n"+
                        "6.Inchide aplicatia");
            Scanner scanner=new Scanner(System.in);

            System.out.print("Introdu numarul: ");setNumberSellOp(scanner.nextInt());
            PersonDAO personDAO=new PersonDAO();
            switch (getNumberSellOp()) {
                case 1://insert person
                    System.out.println("Introduceti date despre persoana: ");
                    Person person=new Person();
                    Scanner scanner1=new Scanner(System.in);
                    Scanner scanner2=new Scanner(System.in);
                    Scanner scanner10=new Scanner(System.in);
                    Scanner scanner11=new Scanner(System.in);
                    System.out.print("Prenumele: ");person.setPrenumele(scanner1.nextLine());
                    System.out.print("Varsta: ");person.setVarsta(scanner2.nextInt());
                    System.out.print("Adresa: ");person.setAdresa(scanner10.nextLine());
                    System.out.print("Salariu: ");person.setSalariu(scanner11.nextDouble());
                    personDAO.savePerson(person);
                    break;
                case 2://read al persons from DB
                    System.out.println("Lista cu toti angajatii: ");
                    for (Person p : personDAO.getAllPersons()) {
                        System.out.println(p);
                    }
                    break;
                case 3://update person with ID
                    Scanner scanner3=new Scanner(System.in);
                    Scanner scanner4=new Scanner(System.in);
                    Scanner scanner7=new Scanner(System.in);
                    Scanner scanner8=new Scanner(System.in);
                    Scanner scanner9=new Scanner(System.in);
                    System.out.println("Introduceti date pentru persoana care doriti s-a modificati: ");
                    Person person1=new Person();
                    System.out.print("ID: "); person1.setId(scanner3.nextInt());
                    System.out.print("Prenumele: ");person1.setPrenumele(scanner7.nextLine());
                    System.out.print("Varsta: ");person1.setVarsta(scanner4.nextInt());
                    System.out.print("Adresa: ");person1.setAdresa(scanner8.nextLine());
                    System.out.print("Salariu: ");person1.setSalariu(scanner9.nextDouble());
                    personDAO.updatePerson(person1);
                    break;
                case 4://delete person with ID
                    Scanner scanner5=new Scanner(System.in);
                    System.out.println("Introduceti ID pentru stergere persoana: ");
                    System.out.print("ID: ");personDAO.deletePersom(scanner5.nextInt());
                    break;
                case 5://find a person from category
                    Scanner scanner13=new Scanner(System.in);
                    System.out.println("Introduceti date pentru a gasi persoana dupa criteriu: ");
                    System.out.println("introduceti unul din criteriile:prenumele/varsta/adresa/salariu");
                    personDAO.getFindPerson(scanner13.nextLine());
                    break;
                case 6:
                    repeta=false;
                    break;
                default:
                    System.out.println("valoare neindentificta");
            }
            System.out.println("doresti sa executi o alta operatiune y/n");
            Scanner scanner6=new Scanner(System.in);
                if (scanner6.nextLine().equals("y")) {
                    repeta = true;
                }
        }while (repeta);
    }
}
