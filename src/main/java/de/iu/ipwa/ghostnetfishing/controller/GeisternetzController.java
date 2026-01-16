package de.iu.ipwa.ghostnetfishing.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.iu.ipwa.ghostnetfishing.model.Geisternetz;
import de.iu.ipwa.ghostnetfishing.service.GeisternetzService;

@Named("geisternetzController")
@SessionScoped
public class GeisternetzController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private GeisternetzService service;

    private Geisternetz neuesNetz = new Geisternetz();
    private boolean anonym = true;

    private Long ausgewaehltesNetzId;
    private String bergungName;
    private String bergungTelefon;

    public Geisternetz getNeuesNetz() {
        return neuesNetz;
    }

    public void setNeuesNetz(Geisternetz neuesNetz) {
        this.neuesNetz = neuesNetz;
    }

    public boolean isAnonym() {
        return anonym;
    }

    public void setAnonym(boolean anonym) {
        this.anonym = anonym;
    }

    public Long getAusgewaehltesNetzId() {
        return ausgewaehltesNetzId;
    }

    public void setAusgewaehltesNetzId(Long ausgewaehltesNetzId) {
        this.ausgewaehltesNetzId = ausgewaehltesNetzId;
    }

    public String getBergungName() {
        return bergungName;
    }

    public void setBergungName(String bergungName) {
        this.bergungName = bergungName;
    }

    public String getBergungTelefon() {
        return bergungTelefon;
    }

    public void setBergungTelefon(String bergungTelefon) {
        this.bergungTelefon = bergungTelefon;
    }

    public String meldeNetz() {
        service.meldeNetz(neuesNetz, anonym);
        neuesNetz = new Geisternetz();
        anonym = true;
        return "index.xhtml?faces-redirect=true";
    }

    public String zurStartseite() {
        return "index.xhtml?faces-redirect=true";
    }

    public List<Geisternetz> getOffeneNetze() {
        return service.offeneNetze();
    }

    public String uebernehmeBergung() {
        if (ausgewaehltesNetzId == null) {
            return null;
        }
        service.uebernehmeBergung(ausgewaehltesNetzId, bergungName, bergungTelefon);
        ausgewaehltesNetzId = null;
        bergungName = null;
        bergungTelefon = null;
        return "offen.xhtml?faces-redirect=true";
    }

    public String alsGeborgenMelden(Long netzId) {
        service.alsGeborgenMelden(netzId);
        return "offen.xhtml?faces-redirect=true";
    }

    public String alsVerschollenMelden(Long netzId) {
        service.alsVerschollenMelden(netzId);
        return "offen.xhtml?faces-redirect=true";
    }
}
