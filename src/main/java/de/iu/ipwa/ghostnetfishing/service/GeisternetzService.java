package de.iu.ipwa.ghostnetfishing.service;

import de.iu.ipwa.ghostnetfishing.model.Geisternetz;
import de.iu.ipwa.ghostnetfishing.model.Status;
import de.iu.ipwa.ghostnetfishing.repository.GeisternetzRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class GeisternetzService {

    @Inject
    private GeisternetzRepository repository;

    public void meldeNetz(Geisternetz netz, boolean anonym) {
        if (netz == null) return;

        if (anonym) {
            netz.setMeldendePersonName(null);
            netz.setMeldendePersonTelefonnummer(null);
        }

        netz.setStatus(Status.GEMELDET);
        repository.save(netz);
    }

    public List<Geisternetz> alleNetze() {
        return repository.findAll();
    }

    public List<Geisternetz> offeneNetze() {
        return repository.findAll().stream()
                .filter(n -> n.getStatus() != Status.GEBORGEN)
                .collect(Collectors.toList());
    }

    public void uebernehmeBergung(Long netzId, String name, String telefon) {
        if (netzId == null || name == null || name.trim().isEmpty()) return;

        Geisternetz netz = repository.findById(netzId);
        if (netz == null) return;

        netz.setBergendePersonName(name);
        netz.setBergendePersonTelefonnummer(telefon);
        netz.setStatus(Status.BERGUNG_BEVORSTEHEND);

        repository.save(netz);
    }

    public void alsGeborgenMelden(Long netzId) {
        if (netzId == null) return;

        Geisternetz netz = repository.findById(netzId);
        if (netz == null) return;

        netz.setStatus(Status.GEBORGEN);
        repository.save(netz);
    }

    public void alsVerschollenMelden(Long netzId) {
        if (netzId == null) return;

        Geisternetz netz = repository.findById(netzId);
        if (netz == null) return;

        netz.setStatus(Status.VERSCHOLLEN);
        repository.save(netz);
    }
}
