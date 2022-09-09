package com.api.cliniconect.services;

import com.api.cliniconect.models.PacientsModel;
import com.api.cliniconect.repositories.PacientsRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class PacientsService {

    final PacientsRepository pacientsRepository;

    public PacientsService(PacientsRepository pacientsRepository){

        this.pacientsRepository = pacientsRepository;
    }

    @Transactional
    public PacientsModel save(PacientsModel pacientsModel){
        return pacientsRepository.save(pacientsModel);
    }

    public boolean existsByLicenseCpf(String licenseCpf){
        return pacientsRepository.existByLicenseCpf(licenseCpf);
    }

    public boolean existsByLicenseEmail(String LincenseEmail){
        return pacientsRepository.existsByLicenseEmail(LincenseEmail);
    }

    public List<PacientsModel> finAll(){
        return pacientsRepository.findAll();
    }

    public Optional<PacientsModel> findById(UUID id){
        return pacientsRepository.findById(id);
    }

    @Transactional
    public void delete(PacientsModel pacientsModel){
        pacientsRepository.delete(pacientsModel);
    }
}
