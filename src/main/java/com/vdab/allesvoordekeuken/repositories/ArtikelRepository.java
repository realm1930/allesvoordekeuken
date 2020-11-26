package com.vdab.allesvoordekeuken.repositories;


import com.vdab.allesvoordekeuken.domain.Artikel;

import java.util.Optional;

public interface ArtikelRepository {

    Optional<Artikel> findById(long id);

}
