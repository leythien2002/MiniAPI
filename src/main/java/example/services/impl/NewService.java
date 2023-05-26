package example.services.impl;

import example.converter.NewConverter;
import example.dto.NewDTO;
import example.entity.CategoryEntity;
import example.entity.NewEntity;
import example.repository.CategoryRepository;
import example.repository.NewRepository;
import example.services.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NewService implements INewService {
    //nhung cai repository vao cho nay de su dung
    @Autowired
    private NewRepository newRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private NewConverter converter;
    @Override
    public NewDTO save(NewDTO newDTO){
        NewEntity newEntity=new NewEntity();
        if(newDTO.getId()!=null){
            //findOne da bi thay thanh` findById
            Optional<NewEntity> tmp=newRepository.findById(newDTO.getId());
            NewEntity oldNew=new NewEntity();
            if(tmp.isPresent()){
                //neu findById !=null
                oldNew=tmp.get();
            }
            newEntity=converter.toEntity(newDTO,oldNew);
        }
        else{
            newEntity=converter.toEntity(newDTO);
        }
        CategoryEntity category=categoryRepository.findOneByCode(newDTO.getCategoryCode());
        newEntity.setCategory(category);
        newEntity=newRepository.save(newEntity);
        return converter.toDTO(newEntity);
    }
    public void delete(long[]id){
        for(long item:id){
            newRepository.deleteById(item);
        }
    }
    public List<NewDTO> findAll(Pageable pageable){
        //pageble nay giup ho tro phan trang
        List<NewDTO> results=new ArrayList<>();
        //findAll(pageable) --> cai nay no se them Limit vao cau SQL findAll
        List<NewEntity> entities=newRepository.findAll(pageable).getContent();
        for(NewEntity item:entities){
            NewDTO newDTO=converter.toDTO(item);
            results.add(newDTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) newRepository.count();
        //null se khac rong~
        //ds rong thi no da count
        //
    }

}

    //save--> co id thi se updat/ khong thi se them moi
    //o day khi gan lai properties cho newEntity thi Entity nay co id roi -->update
    //tuy nhien khi code co nhugn doan giong nhau thi hay toi uu sang mot ham
//    public NewDTO update(NewDTO newDTO){
//        NewEntity oldNew=newRepository.findOne(newDTO.getId());
//        NewEntity newEntity=converter.toEntity(newDTO,oldNew);
//        CategoryEntity category=categoryRepository.findOneByCode(newDTO.getCategoryCode());
//        newEntity.setCategory(category);
//
//        newEntity=newRepository.save(newEntity);
//        return converter.toDTO(newEntity);
//    }
//}
