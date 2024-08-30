package com.strada.clinica_odontologia.persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.strada.clinica_odontologia.logica.Odontologo;
import com.strada.clinica_odontologia.logica.Paciente;
import com.strada.clinica_odontologia.logica.Turno;
import com.strada.clinica_odontologia.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TurnoJpaController implements Serializable {

    public TurnoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public TurnoJpaController() {
        emf = Persistence.createEntityManagerFactory("clinica_odontologia_PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Turno turno) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Odontologo odonto = turno.getOdonto();
            if (odonto != null) {
                odonto = em.getReference(odonto.getClass(), odonto.getId());
                turno.setOdonto(odonto);
            }
            Paciente pacien = turno.getPacien();
            if (pacien != null) {
                pacien = em.getReference(pacien.getClass(), pacien.getId());
                turno.setPacien(pacien);
            }
            em.persist(turno);
            if (odonto != null) {
                odonto.getListaTurnos().add(turno);
                odonto = em.merge(odonto);
            }
            if (pacien != null) {
                pacien.getListaTurnos().add(turno);
                pacien = em.merge(pacien);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Turno turno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turno persistentTurno = em.find(Turno.class, turno.getId_turno());
            Odontologo odontoOld = persistentTurno.getOdonto();
            Odontologo odontoNew = turno.getOdonto();
            Paciente pacienOld = persistentTurno.getPacien();
            Paciente pacienNew = turno.getPacien();
            if (odontoNew != null) {
                odontoNew = em.getReference(odontoNew.getClass(), odontoNew.getId());
                turno.setOdonto(odontoNew);
            }
            if (pacienNew != null) {
                pacienNew = em.getReference(pacienNew.getClass(), pacienNew.getId());
                turno.setPacien(pacienNew);
            }
            turno = em.merge(turno);
            if (odontoOld != null && !odontoOld.equals(odontoNew)) {
                odontoOld.getListaTurnos().remove(turno);
                odontoOld = em.merge(odontoOld);
            }
            if (odontoNew != null && !odontoNew.equals(odontoOld)) {
                odontoNew.getListaTurnos().add(turno);
                odontoNew = em.merge(odontoNew);
            }
            if (pacienOld != null && !pacienOld.equals(pacienNew)) {
                pacienOld.getListaTurnos().remove(turno);
                pacienOld = em.merge(pacienOld);
            }
            if (pacienNew != null && !pacienNew.equals(pacienOld)) {
                pacienNew.getListaTurnos().add(turno);
                pacienNew = em.merge(pacienNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = turno.getId_turno();
                if (findTurno(id) == null) {
                    throw new NonexistentEntityException("The turno with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turno turno;
            try {
                turno = em.getReference(Turno.class, id);
                turno.getId_turno();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The turno with id " + id + " no longer exists.", enfe);
            }
            Odontologo odonto = turno.getOdonto();
            if (odonto != null) {
                odonto.getListaTurnos().remove(turno);
                odonto = em.merge(odonto);
            }
            Paciente pacien = turno.getPacien();
            if (pacien != null) {
                pacien.getListaTurnos().remove(turno);
                pacien = em.merge(pacien);
            }
            em.remove(turno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Turno> findTurnoEntities() {
        return findTurnoEntities(true, -1, -1);
    }

    public List<Turno> findTurnoEntities(int maxResults, int firstResult) {
        return findTurnoEntities(false, maxResults, firstResult);
    }

    private List<Turno> findTurnoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Turno.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Turno findTurno(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Turno.class, id);
        } finally {
            em.close();
        }
    }

    public int getTurnoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Turno> rt = cq.from(Turno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
