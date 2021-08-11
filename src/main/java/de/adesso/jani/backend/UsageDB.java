package de.adesso.jani.backend;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface UsageDB extends JpaRepository<DayData, Long> {

    public Optional<DayData> getDayDataByID(Long id);
    public Optional<DayData> getDayDataByDate(LocalDate d);

}
