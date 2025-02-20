package samar.org.finantial_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import samar.org.finantial_app.model.Part;
import samar.org.finantial_app.model.PartMaterials;
import samar.org.finantial_app.model.PartMaterialsWrapper;
import samar.org.finantial_app.repo.PartMaterialsRepo;
import samar.org.finantial_app.repo.PartRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartMaterialsService
{
    @Autowired
    private PartMaterialsRepo partMaterialsRepo;

    @Autowired
    private PartRepo partRepo;

    public ResponseEntity<String> createPartMaterials(PartMaterialsWrapper partMaterialsWrapper, int partId)
    {

        //mapping the wrapper to the real obj

                try{
                    //getting the part object
                    Part part = partRepo.findById(partId).get();

                    PartMaterials pm = new PartMaterials(partMaterialsWrapper.getName(), partMaterialsWrapper.getDescription(), partMaterialsWrapper.getQuantity(),
                            partMaterialsWrapper.getPriceUtd(), partMaterialsWrapper.getBuyDate(), part);

                    //save pm in the repo
                    partMaterialsRepo.save(pm);

                    return new ResponseEntity<>("Part Saved.", HttpStatus.CREATED);

                }catch (Exception e){
                    e.printStackTrace();
                }

                return new ResponseEntity<>("Part Not Saved.", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<PartMaterials>> getAllPartMaterials()
    {
        try{
            List<PartMaterials> partMaterials = partMaterialsRepo.findAll();
            return new ResponseEntity<>(partMaterials, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<String> bulkAddition(List<PartMaterialsWrapper> partMaterialsWrapper, int partId) {

        List<PartMaterials> pm = new ArrayList<>();

        try{
            //getting the part object
            Part part = partRepo.findById(partId).get();

//            PartMaterials pm = new PartMaterials(partMaterialsWrapper.getName(), partMaterialsWrapper.getDescription(), partMaterialsWrapper.getQuantity(),
//                    partMaterialsWrapper.getPriceUtd(), partMaterialsWrapper.getBuyDate(), part);

            for(PartMaterialsWrapper partMaterials : partMaterialsWrapper){

                pm.add(new PartMaterials(partMaterials.getName(), partMaterials.getDescription(), partMaterials.getQuantity(), partMaterials.getPriceUtd(),
                        partMaterials.getBuyDate(), part));
            }

            //save the list of part materials in the repo
            partMaterialsRepo.saveAll(pm);

            return new ResponseEntity<>("All the Part Materials were Saved.", HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>("Some Error had occurred.", HttpStatus.BAD_REQUEST);
    }
}
