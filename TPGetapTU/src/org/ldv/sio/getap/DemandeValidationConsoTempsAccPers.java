package org.ldv.sio.getap;

import java.sql.Date;

/**
 * Demande de validation d'un temps d'accompagnement personnalisé
 * 
 * 
 */

public class DemandeValidationConsoTempsAccPers {
	private static final int DVCTAP_CREE = 0;
	
	private static final int DVCTAP_ACCEPT_ELEVE_APRES_MODIF_PROF = 1;
	private static final int DVCTAP_REFUS_ELEVE_APRES_MODIF_PROF = 2;
	private static final int DVCTAP_MODIF_ELEVE = 4;
	private static final int DVCTAP_ANNULE_ELEVE = 8;
	
	private static final int DVCTAP_ACCEPT_PROF = 32;
	private static final int DVCTAP_REFUS_PROF = 64;
	
	private static final int DVCTAP_DATE_MODIF_PROF = 1024;
	private static final int DVCTAP_DUREE_MODIF_PROF = 2048;
	private static final int DVCTAP_AP_MODIF_PROF = 4096;

	/**
	 * Identifiant de la DCTAP
	 */
	private Long id;
	/**
	 * Année scolaire de la demande, par exemple "2011-2012"
	 */
	private String anneeScolaire;
	/**
	 * Date de réalisation de l'accompagnement
	 * 
	 */
	private java.sql.Date dateAction;
	/**
	 * Nombre de minutes d'accompagnement personnalisé à valider
	 */
	private Integer minutes;
	/**
	 * Professeur ayant assuré l'accompagnement personnalisé
	 */
	private User prof;
	/**
	 * Nature de l'accompagnement personnalisé associé à la demande
	 */
	private AccPersonalise accPers;
	/**
	 * Identifiant de l'élève ayant réalisé l'accompagnement personnalisé
	 */
	private User eleve;

	/**
	 * 
	 */
	private int etat;

	/**
	 * constructeur par défaut
	 */
	public DemandeValidationConsoTempsAccPers() {

	}

	/**
	 * Constructeur permettant de créer une demande complète.
	 * 
	 * @param id peut être null (moment de la creation)
	 *            
	 * @param anneeScolaire
	 * @param date
	 * @param minutes
	 * @param prof
	 * @param accPers
	 * @param eleve 
	 * @param etat
	 */
	public DemandeValidationConsoTempsAccPers(Long id, String anneeScolaire, Date date,
			Integer minutes, User prof, AccPersonalise accPers, User eleve,
			int etat) {
		super();
		this.id = id;
		this.anneeScolaire = anneeScolaire;
		this.dateAction = date;
		this.minutes = minutes;
		this.prof = prof;
		this.accPers = accPers;
		this.eleve = eleve;
		this.etat = etat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnneeScolaire() {
		return anneeScolaire;
	}

	public void setAnneeScolaire(String anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}

	public java.sql.Date getDateAction() {
		return dateAction;
	}

	public void setDateAction(java.sql.Date date) {
		this.dateAction = date;
	}

	public Integer getMinutes() {
		return minutes;
	}

	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}

	public User getProf() {
		return prof;
	}

	public void setProf(User prof) {
		this.prof = prof;
	}

	public AccPersonalise getAccPers() {
		return accPers;
	}

	public void setAccPers(AccPersonalise accPers) {
		this.accPers = accPers;
	}

	public User getEleve() {
		return eleve;
	}

	public void setEleve(User eleve) {
		this.eleve = eleve;
	}

	public int getEtat() {
		return etat;
	}

	/**
	 * Permet de modifier l'état de la demande
	 * 
	 * @param etat
	 *            prend ses valeur dans :
	 *            <ul>
	 *            <li>0 - demande créée par l'élève</li>
	 *            <li>1 - demande acceptée par l'élève aprés modification du
	 *            professeur</li>
	 *            <li>2 - demande rejetée par l'élève aprés modification du
	 *            professeur</li>
	 *            <li>4 - demande modifiée par l'élève</li>
	 *            <li>8 - demande annulée par l'élève</li>
	 *            <li>32 - demande validée par le professeur</li>
	 *            <li>64 - demande refusée par le professeur</li>
	 *            <li>1024 - demande où la date a été modifiée par le professeur
	 *            </li>
	 *            <li>2048 - demande où la durée a été modifiée par le
	 *            professeur</li>
	 *            <li>4096 - demande où l'accompagnement personnalisé a été
	 *            modifiée par le professeur</li>
	 *            </ul>
	 */
	public void setEtat(int etat) {
		this.etat = etat;
	}

	
	@Override
	public String toString() {
		return "DemandeConsoTempsAccPers [id=" + id + ", anneeScolaire="
				+ anneeScolaire + ", dateAction=" + dateAction + ", minutes="
				+ minutes + ", prof=" + prof + ", accPers=" + accPers
				+ ", eleve=" + eleve + ", etat=" + etat + "]";
	}

	
	public boolean isEtatInitial() {

		boolean bool = ((this.getEtat() & DVCTAP_CREE) == DVCTAP_CREE);
		return bool;
	}
	
	public boolean isModifEleve() {
		boolean bool = ((this.getEtat() & DVCTAP_MODIF_ELEVE) == DVCTAP_MODIF_ELEVE);
		return bool;
	}
	public boolean isAnnuleEleve() {
		boolean bool = ((this.getEtat() & DVCTAP_ANNULE_ELEVE) == DVCTAP_ANNULE_ELEVE);
		return bool;
	}
		
	public boolean isAcceptProf() {
		boolean bool = ((this.getEtat() & DVCTAP_ACCEPT_PROF) == DVCTAP_ACCEPT_PROF);
		return bool;
	}
	public boolean isRefusProf() {
		boolean bool = ((this.getEtat() & DVCTAP_REFUS_PROF) == DVCTAP_REFUS_PROF);
		return bool;
	}

	public boolean isModifDureeProf() {
		boolean bool = ((this.getEtat() & DVCTAP_DUREE_MODIF_PROF) == DVCTAP_DUREE_MODIF_PROF);
		return bool;		
	}
	public boolean isModifDateProf() {
		boolean bool = ((this.getEtat() & DVCTAP_DATE_MODIF_PROF) == DVCTAP_DATE_MODIF_PROF);
		return bool;		
	}
	public boolean isModifApProf() {
		boolean bool = ((this.getEtat() & DVCTAP_AP_MODIF_PROF) == DVCTAP_AP_MODIF_PROF);
		return bool;		
	}
	
	public boolean isAcceptEleveModifProf() {
		boolean bool = ((this.getEtat() & DVCTAP_ACCEPT_ELEVE_APRES_MODIF_PROF) == DVCTAP_ACCEPT_ELEVE_APRES_MODIF_PROF);
		return bool;
	}
	public boolean isRefusEleveModifProf() {
		boolean bool = ((this.getEtat() & DVCTAP_REFUS_ELEVE_APRES_MODIF_PROF) == DVCTAP_REFUS_ELEVE_APRES_MODIF_PROF);
		return bool;
	}
	
	
	public void setModifEleve() throws DVCTAPException{
		if(this.isEtatInitial() || this.isModifEleve())
			this.setEtat(DVCTAP_MODIF_ELEVE);
	}
	public void setAnnuleEleve()throws DVCTAPException{
		if(this.isEtatInitial() || this.isModifEleve())
			this.setEtat(DVCTAP_ANNULE_ELEVE);
	}

	public void setAcceptProf()throws DVCTAPException{
		if(this.isEtatInitial() || this.isModifEleve())
			this.setEtat(DVCTAP_ACCEPT_PROF);
	}
	public void setRefusProf()throws DVCTAPException{
		if(this.isEtatInitial() || this.isModifEleve())
			this.setEtat(DVCTAP_REFUS_PROF);
	}

	public void setModifDureeProf()throws DVCTAPException{
		if(this.isEtatInitial() || this.isModifEleve() || this.isModifDureeProf()
				|| this.isModifDateProf()|| this.isModifApProf())
			this.setEtat(DVCTAP_DUREE_MODIF_PROF);
	}
	public void setModifDateProf()throws DVCTAPException{
		if(this.isEtatInitial() || this.isModifEleve() || this.isModifDureeProf()
				|| this.isModifDateProf() || this.isModifApProf())
			this.setEtat(DVCTAP_DATE_MODIF_PROF);
	}
	public void setModifApProf()throws DVCTAPException{
		if(this.isEtatInitial() || this.isModifEleve() || this.isModifDureeProf()
				|| this.isModifDateProf() || this.isModifApProf())
			this.setEtat(DVCTAP_AP_MODIF_PROF);
	}

	public void setAcceptEleveModifProf()throws DVCTAPException{
		if(this.isModifDateProf() || this.isModifDureeProf()
				|| this.isModifApProf())
			this.setEtat(DVCTAP_ACCEPT_ELEVE_APRES_MODIF_PROF);
	}
	public void setRefusEleveModifProf()throws DVCTAPException{
		if(this.isModifDateProf() || this.isModifDureeProf()
				|| this.isModifApProf())
			this.setEtat(DVCTAP_REFUS_ELEVE_APRES_MODIF_PROF);
	}
}
