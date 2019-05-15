/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

/**
 *
 * @author jesus
 */
@Named(value = "user")
@ManagedBean
@RequestScoped
public class user {

    
    private int nif;
    private String name;
    private String subname;
    private String prov;
    private String pop;
    private int pos;
    private String dir;
    private int fijo;
    private int movil;
    private String corr;
    
    private String contra;
    private String reContra;
    /**
     * Creates a new instance of user
     */
    public user() {
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public int getFijo() {
        return fijo;
    }

    public void setFijo(int fijo) {
        this.fijo = fijo;
    }

    public int getMovil() {
        return movil;
    }

    public void setMovil(int movil) {
        this.movil = movil;
    }

    public String getCorr() {
        return corr;
    }

    public void setCorr(String corr) {
        this.corr = corr;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getReContra() {
        return reContra;
    }

    public void setReContra(String reContra) {
        this.reContra = reContra;
    }
    

    public String run(){
        return "registrocon.xhtml";
    }
    
    public String fin(){
        
        if (this.getContra().equals(reContra)){return "index.xhtml";}
        else{return null;}
    }
}
