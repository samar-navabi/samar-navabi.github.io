package samar.org.finantial_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import samar.org.finantial_app.model.Part;

@Repository
public interface PartRepo extends JpaRepository<Part, Integer>
{

}
