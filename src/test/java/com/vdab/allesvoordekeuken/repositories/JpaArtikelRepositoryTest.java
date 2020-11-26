package com.vdab.allesvoordekeuken.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(JpaArtikelRepository.class)
@Sql("/insertArtikel.sql")
class JpaArtikelRepositoryTest
        extends AbstractTransactionalJUnit4SpringContextTests{
    public JpaArtikelRepositoryTest(JpaArtikelRepository repository) {
        this.repository = repository;
    }

    private final JpaArtikelRepository repository;
    // constructor met parameter
    private long idVanTestArtikel() {
        return super.jdbcTemplate.queryForObject(
                "select id from artikels where naam='test'", Long.class);
    }
    @Test
    void findById() {
        assertThat(repository.findById(idVanTestArtikel()).get().getNaam())
                .isEqualTo("test");
    }
    @Test
    void findByOnbestaandeId() {
        assertThat(repository.findById(-1)).isNotPresent();
    }
}
