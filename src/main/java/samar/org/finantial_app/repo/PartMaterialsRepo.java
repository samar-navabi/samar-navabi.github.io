package samar.org.finantial_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import samar.org.finantial_app.model.PartMaterials;

@Repository
public interface PartMaterialsRepo extends JpaRepository<PartMaterials, Integer>
{
}
