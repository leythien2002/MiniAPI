package example.api;

import example.dto.NewDTO;
import example.services.impl.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//controller thi se can responseBody
//@Controller
@RestController
public class NewAPI {
    @Autowired
    private NewService newService;

//    @RequestMapping(value = "/new", method = RequestMethod.POST)

    //    @ResponseBody
//
//    public NewDTO createNew(@RequestBody NewDTO model) {
//
//        return model;
//
//    }
    @PostMapping(value = "/new")
    public NewDTO addNew(@RequestBody NewDTO model) {
        return newService.save(model);
    }
    //thay vi dung new?q=id. su dung /id de lay param se khac

    @PutMapping(value = "/new/{id}")
    public NewDTO updateNew(@RequestBody NewDTO model,@PathVariable("id")long id) {
        model.setId(id);
        newService.save(model);
        return model;
    }

    @DeleteMapping(value="/new")
    public void deleteNew(@RequestBody long[]id) {
        newService.delete(id);

    }


}
