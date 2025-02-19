package samar.org.finantial_app.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import samar.org.finantial_app.model.Part;
import samar.org.finantial_app.model.Project;
import samar.org.finantial_app.repo.PartRepo;
import samar.org.finantial_app.repo.ProjectRepo;

@Aspect
@Component
public class PartValidation
{
    @Autowired
    ProjectRepo projectRepo;

    @Autowired
    PartRepo partRepo;

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

    //VALIDAR SE O PART JÁ EXISTE NA BASE DE DADOS
    @Around("execution(* samar.org.finantial_app.service.PartService.addPart(..))")
    public Object validatingPartName(ProceedingJoinPoint joinPoint) throws Throwable
    {
        //System.out.println("ID: " + prj.getId() + "---- Name : " + prj.getName());
        Object[] args = joinPoint.getArgs();

        if (args != null && args.length > 0 && args[0] instanceof String)
        {
            String partName = (String) args[0];

            if(partRepo.existsByName(partName))
            {
                LOGGER.info("Part name already exists");
                throw new IllegalArgumentException("Ja existe uma divisão do Projecto com o mesmo nome: " + partName);//joinPoint.finalize();
            }
        }

        return joinPoint.proceed();

    }
}
