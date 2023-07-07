package main;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="persons")
public class Person implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "prenumele")
    private String prenumele;

    @Column(name = "varsta")
    private int varsta;

    @Column(name = "adresa")
    private String adresa;

    @Column(name = "salariu")
    private double salariu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenumele() {
        return prenumele;
    }

    public void setPrenumele(String prenumele) {
        this.prenumele = prenumele;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }

    public Person(int id, String prenumele, int varsta, String adresa, double salariu) {
        this.id = id;
        this.prenumele = prenumele;
        this.varsta = varsta;
        this.adresa = adresa;
        this.salariu = salariu;
    }

    public Person(String prenumele, int varsta, String adresa, double salariu) {
        this.prenumele = prenumele;
        this.varsta = varsta;
        this.adresa = adresa;
        this.salariu = salariu;
    }

    public Person(){

    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", prenumele='" + prenumele + '\'' +
                ", varsta=" + varsta +
                ", adresa='" + adresa + '\'' +
                ", salariu=" + salariu +
                '}';
    }
}
