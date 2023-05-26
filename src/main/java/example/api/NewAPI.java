package example.api;

import example.api.output.NewOutput;
import example.dto.NewDTO;
import example.services.impl.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.naming.ldap.SortControl;

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
    @GetMapping(value = "/new")
    public NewOutput showNew(@RequestParam("page") int page,@RequestParam("limit")int limit) {
        NewOutput result=new NewOutput();
        result.setPage(page);
//        Pageable pageable=new PageRequest.of(page,limit,Sort.by("id")); deprecated
        //offset bat dau tu 0 ( bat dau tu phan tu thu 0)
        Pageable pageable=PageRequest.of(page-1,limit);
        result.setListResult(newService.findAll(pageable));
        result.setTotalPage((int) Math.ceil((double) (newService.totalItem())/limit));
        //khi muon lay du lieu ma ko can phan tranng page&limit==null
        //su dung them required=false va viet them ham findAll khong param
        //value="page"
        return result;
    }
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
