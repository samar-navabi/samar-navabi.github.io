package samar.org.finantial_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import samar.org.finantial_app.model.Project;

@Service
public class TestRestExternalService
{

    public void getProject()
    {
        RestTemplate restTemplate = new RestTemplate();


        String url = "http://localhost:8080/project/part/materials";
        String response = restTemplate.getForObject(url, String.class);

        System.out.println(response);
    }
}
