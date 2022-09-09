package com.api.cliniconect.repositories;

import com.api.cliniconect.models.PacientsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PacientsRepository extends JpaRepository<PacientsModel, UUID> {

    boolean existsByLicenseCpf(String licenseCpf);

    boolean existsByLicenseEmail(String licenseEmail);
}
