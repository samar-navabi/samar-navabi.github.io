package samar.org.finantial_app.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import samar.org.finantial_app.model.Project;
import samar.org.finantial_app.repo.ProjectRepo;

@Aspect
@Component
public class PartValidation
{
    @Autowired
    ProjectRepo projectRepo;

    private static final Logger LOGGER = LoggerFactory.getLogger(PartValidation.class);


    //VALIDAR SE O PROJECTO JÁ EXISTE NA BASE DE DADOS
    @Around("execution(* samar.org.finantial_app.service.ProjectService.addProject(..)) && args(project)")
    public Object validatingInputs(ProceedingJoinPoint joinPoint, Project project) throws Throwable
    {
        //System.out.println("ID: " + prj.getId() + "---- Name : " + prj.getName());
        if(!(projectRepo.findByName(project.getName()) == null))
        {
            LOGGER.info("Project name already exists");
            throw new IllegalArgumentException("Ja existe um projecto com o mesmo nome. O ID e: " + project.getName());//joinPoint.finalize();
        }
        Object obj = joinPoint.proceed(new Object[]{project});
        return obj;
    }
}
