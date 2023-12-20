package fr.insa.soa.RESST;

public class Volontaire {
    private String nom;
    private String prenom;
    private boolean aAntecedentsJudiciaires;
    private int age;

    public Volontaire(String nom, String prenom, boolean aAntecedentsJudiciaires, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.aAntecedentsJudiciaires = aAntecedentsJudiciaires;
        this.age = age;
    }

    // Getters et Setters ici

    @Override
    public String toString() {
        return "Volontaire{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", aAntecedentsJudiciaires=" + aAntecedentsJudiciaires +
                ", age=" + age +
                '}';
    }
}
