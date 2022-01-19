package be.helha.aemt.control;

import java.io.Serializable; 
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

import be.helha.aemt.dao.ActiviteDAO;
import be.helha.aemt.dao.SeanceDAO;
import be.helha.aemt.ejb.ActiviteEJB;
import be.helha.aemt.ejb.AtelierEJB;
import be.helha.aemt.ejb.CoursEJB;
import be.helha.aemt.ejb.EvenementEJB;
import be.helha.aemt.ejb.SeanceEJB;
import be.helha.aemt.entities.Activite;
import be.helha.aemt.entities.Atelier;
import be.helha.aemt.entities.Cours;
import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.Seance;

@ManagedBean
@ViewScoped
public class ScheduleBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private AtelierEJB ejbAt;
	@EJB
	private EvenementEJB ejbEv;
	@EJB
	private CoursEJB ejbCours;
	@EJB
	private SeanceEJB ejbSess;
	private ScheduleModel eventModel;
	private Activite event;
	private Seance seance;
	private List<Atelier> ateliers;
	private List<Evenement> evenements;
	private List<Cours> cours;
	private List<Seance> seances;
	@EJB
	private ActiviteEJB ejbAct;
	
	public Activite getEvent() {
		return event;
	}
	
	public void setActivite(Activite activite) {
		this.event = activite;
	}
	
	public Seance getSeance() {
		return seance;
	}
	
	public void setSeance(Seance seance) {
		this.seance = seance;
	}
	
	public ScheduleModel getEventModel() {
		return eventModel;
	}
	
	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}
	
	public List<Atelier> getActivitees(){
		return ateliers;
	}
	
	public void setActivitees(List<Atelier> activitees) {
		this.ateliers = activitees;
	}
	
	public List<Seance> getSeances(){
		return seances;
	}
	
	public void setSeances(List<Seance> seances) {
		this.seances = seances;
	}
	
	
	@PostConstruct
	public void init() {
		event = new Activite();
		eventModel = new DefaultScheduleModel();
		seance = new Seance();
		seances = new ArrayList<Seance>();
		ateliers = new ArrayList<Atelier>();
		evenements = new ArrayList<Evenement>();
		cours = new ArrayList<Cours>();
		
		ateliers = ejbAt.findAll();
		
		for(Atelier a : ateliers) {
			if(a != null) {
					
				seances = ejbSess.getAtelierSeance(a.getId());

				for(Seance seance : seances) {
					
					if(seance != null) {
						DefaultScheduleEvent evt = new DefaultScheduleEvent();
						evt.setEndDate(convertToLocalDateTimeViaInstant(seance.getDateFin()));
						evt.setStartDate(convertToLocalDateTimeViaInstant(seance.getDateDebut()));
						evt.setTitle(a.getNom());
						evt.setData(seance.getId());
						evt.setDescription(a.getDescription());
						evt.setAllDay(false);
						evt.setEditable(false);
						System.out.println(evt.getStartDate());
						eventModel.addEvent(evt);
					
					}
				}			
			}
		}
		
		evenements = ejbEv.findAll();
		
		for(Evenement a : evenements) {
			if(a != null) {
					
				seances = ejbSess.getEvenementSeance(a.getId());

				for(Seance seance : seances) {
					
					if(seance != null) {
						DefaultScheduleEvent evt = new DefaultScheduleEvent();
						evt.setEndDate(convertToLocalDateTimeViaInstant(seance.getDateFin()));
						evt.setStartDate(convertToLocalDateTimeViaInstant(seance.getDateDebut()));
						evt.setTitle(a.getNom());
						evt.setData(seance.getId());
						evt.setDescription(a.getDescription());
						evt.setAllDay(false);
						evt.setEditable(false);	
						eventModel.addEvent(evt);
					}
				}			
			}
		}
		
		cours = ejbCours.findAll();
		
		for(Cours a : cours) {
			if(a != null) {
					
				seances = ejbSess.getCoursSeance(a.getId());

				for(Seance seance : seances) {
					
					if(seance != null) {
						DefaultScheduleEvent evt = new DefaultScheduleEvent();
						evt.setEndDate(convertToLocalDateTimeViaInstant(seance.getDateFin()));
						evt.setStartDate(convertToLocalDateTimeViaInstant(seance.getDateDebut()));
						evt.setTitle(a.getNom());
						evt.setData(seance.getId());
						evt.setDescription(a.getDescription());
						evt.setAllDay(false);
						evt.setEditable(false);	
						eventModel.addEvent(evt);
					}
				}			
			}
		}
		
	
	}
	
	public LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
		System.out.println("GOURJISUHG"+dateToConvert);
		System.out.println("ICI :"+dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDateTime());
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDateTime();
	}
	

}