package samar.org.finantial_app.controller;

import org.hibernate.dialect.function.array.ArraysOfSameTypeArgumentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import samar.org.finantial_app.model.Part;
import samar.org.finantial_app.model.PartMaterials;
import samar.org.finantial_app.model.PartMaterialsWrapper;
import samar.org.finantial_app.model.Project;
import samar.org.finantial_app.service.PartMaterialsService;
import samar.org.finantial_app.service.PartService;
import samar.org.finantial_app.service.ProjectService;
import samar.org.finantial_app.service.TestRestExternalService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController
{
    @Autowired
    private ProjectService projectService;
    @Autowired
    private PartService partService;

    @Autowired
    private PartMaterialsService partMaterialsService;

    @Autowired
    private TestRestExternalService testRestExternalService;

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getProjects()
    {
        return projectService.getAllProjects();
    }

    @PostMapping("/add")
    public ResponseEntity<String> createProject(@RequestBody Project project)
    {
        //System.out.println(project.getName());
        return projectService.addProject(project);
    }

    @PostMapping("/part/add")
    public ResponseEntity<String> createProjectPart(@RequestParam String name, @RequestParam String type, @RequestParam int projectId)
    {
//        System.out.println(name);
//        System.out.println(type);
//        System.out.println(projectId);
        //return null;
        return partService.addPart(name,type,projectId);
    }

    @GetMapping("/part/parts")
    public ResponseEntity<List<Part>> getParts()
    {
        return partService.getAllParts();
    }

    @GetMapping("part/materials")
    public ResponseEntity<List<PartMaterials>> getPartMaterials()
    {
        return partMaterialsService.getAllPartMaterials();
    }

    @PostMapping("part/materials/{partId}")
    public ResponseEntity<String> addPartMaterials(@RequestBody PartMaterialsWrapper partMaterialsWrapper, @PathVariable int partId)
    {
        //return null;
        return partMaterialsService.createPartMaterials(partMaterialsWrapper, partId);
    }

    @GetMapping("testing")
    public void testingExternal()
    {
        testRestExternalService.getProject();
    }

}
