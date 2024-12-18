package samar.org.finantial_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import samar.org.finantial_app.model.Project;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer>
{
    @Query(value = "SELECT * FROM project p WHERE p.name=:name", nativeQuery = true)
    Project findByName(String name);
}
