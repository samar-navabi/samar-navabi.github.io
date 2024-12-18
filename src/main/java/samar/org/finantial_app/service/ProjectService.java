package samar.org.finantial_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import samar.org.finantial_app.model.Project;
import samar.org.finantial_app.repo.ProjectRepo;

import java.util.List;

@Service
public class ProjectService
{
    @Autowired
    private ProjectRepo projectRepo;

    public ResponseEntity<List<Project>> getAllProjects()
    {
        return new ResponseEntity<>(projectRepo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<String> addProject(Project project)
    {
        try{
            projectRepo.save(project);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
    }
}
