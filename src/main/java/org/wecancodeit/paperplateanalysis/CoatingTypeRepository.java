package org.wecancodeit.paperplateanalysis;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CoatingTypeRepository extends CrudRepository<CoatingType, Long> {

    Optional<CoatingType> findByMaterialType(String materialType);

}
