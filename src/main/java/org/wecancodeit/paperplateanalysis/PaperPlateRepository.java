package org.wecancodeit.paperplateanalysis;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PaperPlateRepository extends CrudRepository<PaperPlate, Long> {
    Optional<PaperPlate> findByBrand(String brand);
}
