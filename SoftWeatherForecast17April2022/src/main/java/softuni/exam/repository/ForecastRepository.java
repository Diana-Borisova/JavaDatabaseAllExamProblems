package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.DayOfWeek;
import softuni.exam.models.entity.Forecast;


import java.util.List;
import java.util.Optional;

import java.util.Set;

@Repository
public interface ForecastRepository extends JpaRepository<Forecast, Long> {
    @Query(value = "select f from Forecast as f where f.dayOfWeek = :dayOfWeek and f.city =:city")
Optional<Forecast> findByCityAndDayOfWeek(DayOfWeek dayOfWeek, City city);
@Query(value = "select f from Forecast f where f.dayOfWeek =:dayOfWeek and f.city.population< :population order by f.maxTemperature desc , f.id")
List<Forecast> findAllByDayOfWeekAndCity_PopulationOrderByMaxTemperatureDescIdAsc(DayOfWeek dayOfWeek, int population);

}
