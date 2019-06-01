/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Entidades.*;
import java.util.Date;
import java.util.List;
import Entidades.Personal;
import javax.persistence.Query;

/**
 *
 * @author jesus
 */
@Stateless
public class InterfazImplementada implements Interfaz {

    @PersistenceContext(unitName = "Proyecto-Final-ejbPU")
    private EntityManager em;

    @Override
    public Socio buscarSocio(String nif) throws AplicacionException {

        Socio user = em.find(Socio.class, nif);

        return user;

    }

    @Override
    public Personal buscarPersonal(String id) throws AplicacionException {

        Personal pl = em.find(Personal.class, id);

        return pl;
    }

    @Override
    public void add(Object obj) {
        if (obj instanceof Beneficiario) {
            em.persist((Beneficiario) obj);
        } else if (obj instanceof Casapopulorum) {
            em.persist((Casapopulorum) obj);
        } else if (obj instanceof Centro) {
            em.persist((Centro) obj);
        } else if (obj instanceof Centroeducacion) {
            em.persist((Centroeducacion) obj);
        } else if (obj instanceof Envios) {
            em.persist((Envios) obj);
        } else if (obj instanceof Proyecto) {
            em.persist((Proyecto) obj);
        } else if (obj instanceof Socio) {
            em.persist((Socio) obj);
        } else if (obj instanceof Personal) {
            em.persist((Personal) obj);
        } else if (obj instanceof Ingresosegresos) {
            em.persist((Ingresosegresos) obj);
        }
    }

    @Override
    public void update(Object obj) {
        if (obj instanceof Beneficiario) {
            em.merge((Beneficiario) obj);
        } else if (obj instanceof Casapopulorum) {
            em.merge((Casapopulorum) obj);
        } else if (obj instanceof Centro) {
            em.merge((Centro) obj);
        } else if (obj instanceof Centroeducacion) {
            em.merge((Centroeducacion) obj);
        } else if (obj instanceof Envios) {
            em.merge((Envios) obj);
        } else if (obj instanceof Proyecto) {
            em.merge((Proyecto) obj);
        } else if (obj instanceof Socio) {
            em.merge((Socio) obj);
        } else if (obj instanceof Personal) {
            em.merge((Personal) obj);
        } else if (obj instanceof Ingresosegresos) {
            em.merge((Ingresosegresos) obj);
        }
    }

    @Override
    public void delete(Object obj) {
        if (obj instanceof Beneficiario) {
            em.remove(em.merge((Beneficiario) obj));
        } else if (obj instanceof Casapopulorum) {
            em.remove(em.merge((Casapopulorum) obj));
        } else if (obj instanceof Centro) {
            em.remove(em.merge((Centro) obj));
        } else if (obj instanceof Centroeducacion) {
            em.remove(em.merge((Centroeducacion) obj));
        } else if (obj instanceof Envios) {
            em.remove(em.merge((Envios) obj));
        } else if (obj instanceof Proyecto) {
            em.remove(em.merge((Proyecto) obj));
        } else if (obj instanceof Socio) {
            em.remove(em.merge((Socio) obj));
        } else if (obj instanceof Personal) {
            em.remove(em.merge((Personal) obj));
        } else if (obj instanceof Ingresosegresos) {
            em.remove(em.merge((Ingresosegresos) obj));
        }
    }

    // Utils 
    @Override
    public void registrar(Socio socio) throws Exception {
        Socio user = em.find(Socio.class, socio.getNif());

        if (user == null) {
            socio.setEstado("Activo");
            socio.setRelacion("Miembro");
            socio.setSector("A");
            socio.setCertificado(Boolean.FALSE);
            socio.setFechadealta(new Date());

            add(socio);
        } else {
            throw new CuentaExistenteException();
        }
    }

    public void registrarUsuario(Object o) throws Exception {
        if (o instanceof Beneficiario) {
            Beneficiario user = em.find(Beneficiario.class, ((Beneficiario) o).getId());
            if (user == null) {
                add((Beneficiario) o);
            } else {
                throw new CuentaExistenteException();
            }

        } else if (o instanceof Personal) {
            Personal user = em.find(Personal.class, ((Personal) o).getId());
            if (user == null) {
                add((Personal) o);
            } else {
                throw new CuentaExistenteException();
            }

        }

    }

    /**
     *
     * @param usuario
     * @return
     * @throws AplicacionException
     */
    @Override
    public synchronized Object refrescarUsuario(Object usuario) throws AplicacionException {

        if (usuario != null) {
            if (usuario instanceof Personal) {
                Personal user = em.find(Personal.class, ((Personal) usuario).getId());
                em.refresh(user);
                return user;
            } else if (usuario instanceof Socio) {
                Socio user = em.find(Socio.class, ((Socio) usuario).getNif());
                em.refresh(user);
                return user;
            }
        } else {
            throw new AplicacionException();
        }
        return null;
    }

    @Override
    public synchronized Proyecto refrescarProyecto(Proyecto proyecto) throws AplicacionException {

        if (proyecto != null) {
            Proyecto project = em.find(Proyecto.class, proyecto.getId());
            em.refresh(project);
            return project;
        } else {
            throw new AplicacionException();
        }
    }

    @Override
    public List<Personal> listar_personal() {
        Query query = em.createQuery("SELECT e FROM Personal e");
        return query.getResultList();
    }

    @Override
    public List<Beneficiario> listar_beneficiarios() {
        Query query = em.createQuery("SELECT e FROM Beneficiario e");
        return (List<Beneficiario>) query.getResultList();
    }

    @Override
    public List<Socio> listar_socios() {
        Query query = em.createQuery("SELECT e FROM Socio e");
        return query.getResultList();
    }

    @Override
    public List<Proyecto> getProyectos() {
        Query query = em.createQuery("SELECT p FROM Proyecto p");
        return query.getResultList();
    }

    @Override
    public List<Envios> getEnvios() {
        Query query = em.createQuery("SELECT e FROM Envios e");
        return query.getResultList();
    }

    @Override
    public void añadirProyecto(Proyecto proyecto) throws Exception {
        Proyecto project = em.find(Proyecto.class, proyecto.getId());

        if (project == null) {
            proyecto.setFechadecreacion(new Date());
            add(proyecto);
        } else {
            throw new AplicacionException();
        }
    }

    @Override
    public void actualizarProyecto(String idProyecto, String nombreProyecto, String descripcionProyecto) {
        Proyecto project = em.find(Proyecto.class, idProyecto);

        if (project != null) {
            project.setNombreproyecto(nombreProyecto);
            project.setDescripciondelproyecto(descripcionProyecto);
            update(project);
        }

    }

    @Override
    public void eliminarProyecto(String idProyecto) throws AplicacionException {
        Proyecto project = em.find(Proyecto.class, idProyecto);

        if (project != null) {
            em.remove(project);
        } else {
            throw new AplicacionException();
        }
    }

    @Override
    public void añadirPersonalAProyecto(String idProyecto, String idPersonal) throws AplicacionException {
        Proyecto proyecto = em.find(Proyecto.class, idProyecto);
        Personal personal = em.find(Personal.class, idPersonal);

        if (proyecto != null && personal != null) {
            if (!(proyecto.getPersonalProyecto().contains(personal) && personal.getProyectos().contains(proyecto))) {
                proyecto.getPersonalProyecto().add(personal);
                personal.getProyectos().add(proyecto);
            }
        } else {
            throw new AplicacionException();
        }
    }

    @Override
    public void eliminarPersonalDeProyecto(String idProyecto, String idPersonal) throws AplicacionException {
        Proyecto proyecto = em.find(Proyecto.class, idProyecto);
        Personal personal = em.find(Personal.class, idPersonal);

        if (proyecto != null && personal != null) {
            if (proyecto.getPersonalProyecto().contains(personal) && personal.getProyectos().contains(proyecto)) {
                proyecto.getPersonalProyecto().remove(personal);
                personal.getProyectos().remove(proyecto);
            }
        } else {
            throw new AplicacionException();
        }
    }

    @Override
    public void añadirEnvio(Envios envio) throws AplicacionException {
        Envios delivery = em.find(Envios.class, envio.getTipodeenvio());

        if (delivery == null) {
            add(envio);
        } else {
            throw new AplicacionException();
        }
    }

    @Override
    public void actualizarEnvio(String tipoDeEnvio, String contenidoEnvio, Date fechaEnvio) {
        Envios envio = em.find(Envios.class, tipoDeEnvio);

        if (envio != null) {
            envio.setContenido(contenidoEnvio);
            envio.setFecha(fechaEnvio);
            update(envio);
        }

    }

    @Override
    public void eliminarEnvio(String tipoDeEnvio) throws AplicacionException {
        Envios envio = em.find(Envios.class, tipoDeEnvio);

        if (envio != null) {
            em.remove(envio);
        } else {
            throw new AplicacionException();
        }
    }

}
