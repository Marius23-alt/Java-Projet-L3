package fr.miage.toulouse.maven.cours;

/**
 * Classe qui créer des étudiants
 */

public class Etudiant {

    private String nom;
    private String prenom;
    private String numEtudiant;

    /**
     * Créer un étudiant
     * @param nom le nom de l'étudiant
     * @param prenom le prénom de l'étudiant
     * @param numEtudiant le numéro étudiant de l'étudiant
     */
    public Etudiant(String nom, String prenom, String numEtudiant) {
        this.nom = nom;
        this.prenom = prenom;
        this.numEtudiant = numEtudiant;
    }

    /**
     * donne le nom de l'étudiant
     * @return le nom de l'étudiant
     */
    public String getNom() {
        return nom;
    }

    /**
     * donne le prenom de l'étudiant
     * @return le prenom de l'étudiant
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * donne le numéro étudiant de l'étudiant
     * @return le numéro étudiant de l'étudiant
     */
    public String getNumEtudiant() {
        return numEtudiant;
    }

    /**
     * Pour modifier le nom de l'étudiant
     * @param nom le nom mis à jour de l'étudiant
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Pour modifier le prénom de l'étudiant
     * @param prenom le nom mis à jour de l'étudiant
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Pour modifier le numéro étudiant
     * @param numEtudiant le numéro étudiant mis à jour de l'étudiant
     */
    public void setNumEtudiant(String numEtudiant) {
        this.numEtudiant = numEtudiant;
    }
}
