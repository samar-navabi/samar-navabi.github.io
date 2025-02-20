package samar.org.finantial_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import samar.org.finantial_app.model.Part;
import samar.org.finantial_app.model.Project;

@Repository
public interface PartRepo extends JpaRepository<Part, Integer>
{
    //@Query(value = "SELECT * FROM part p WHERE p.name=:name", nativeQuery = true)
    boolean existsByName(String name);
    boolean existsByType(String type);
}
