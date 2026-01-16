package de.iu.ipwa.ghostnetfishing.model;

import javax.persistence.*;

@Entity
@Table(name = "geisternetz")
public class Geisternetz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Standort
    private Double breitengrad;
    private Double laengengrad;

    // Größe (frei als String, weil im Fachkonzept "geschätzt")
    private String groesse;

    @Enumerated(EnumType.STRING)
    private Status status;

    // Meldende Person (optional / anonym)
    private String meldendePersonName;
    private String meldendePersonTelefonnummer;

    // Bergende Person (max. 1 je Netz)
    private String bergendePersonName;
    private String bergendePersonTelefonnummer;

    public Geisternetz() {
        this.status = Status.GEMELDET;
    }

    public Long getId() { return id; }

    public Double getBreitengrad() { return breitengrad; }
    public void setBreitengrad(Double breitengrad) { this.breitengrad = breitengrad; }

    public Double getLaengengrad() { return laengengrad; }
    public void setLaengengrad(Double laengengrad) { this.laengengrad = laengengrad; }

    public String getGroesse() { return groesse; }
    public void setGroesse(String groesse) { this.groesse = groesse; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public String getMeldendePersonName() { return meldendePersonName; }
    public void setMeldendePersonName(String meldendePersonName) { this.meldendePersonName = meldendePersonName; }

    public String getMeldendePersonTelefonnummer() { return meldendePersonTelefonnummer; }
    public void setMeldendePersonTelefonnummer(String meldendePersonTelefonnummer) { this.meldendePersonTelefonnummer = meldendePersonTelefonnummer; }

    public String getBergendePersonName() { return bergendePersonName; }
    public void setBergendePersonName(String bergendePersonName) { this.bergendePersonName = bergendePersonName; }

    public String getBergendePersonTelefonnummer() { return bergendePersonTelefonnummer; }
    public void setBergendePersonTelefonnummer(String bergendePersonTelefonnummer) { this.bergendePersonTelefonnummer = bergendePersonTelefonnummer; }
}
