package samar.org.finantial_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import samar.org.finantial_app.model.Part;
import samar.org.finantial_app.model.Project;
import samar.org.finantial_app.repo.PartRepo;
import samar.org.finantial_app.repo.ProjectRepo;

import java.util.List;

@Service
public class PartService
{
    @Autowired
    private PartRepo partRepo;

    @Autowired
    private ProjectRepo projectRepo;

    public ResponseEntity<String> addPart(String name, String type, int projectId) {
        try{
            //partRepo.save(part);
            Project project = projectRepo.findById(projectId).get();
            Part part = new Part(name, type, project);
            partRepo.save(part);
            return new ResponseEntity<>("Created", HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Part>> getAllParts() {
        List<Part> parts = partRepo.findAll();
        return new ResponseEntity<>(parts, HttpStatus.OK);
    }

}
