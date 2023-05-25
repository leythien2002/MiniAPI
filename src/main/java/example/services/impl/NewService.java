package example.services.impl;

import example.converter.NewConverter;
import example.dto.NewDTO;
import example.entity.CategoryEntity;
import example.entity.NewEntity;
import example.repository.CategoryRepository;
import example.repository.NewRepository;
import example.services.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        CategoryEntity category=categoryRepository.findOneByCode(newDTO.getCategoryCode());
        NewEntity newEntity=converter.toEntity(newDTO);
        newEntity.setCategory(category);
        newEntity=newRepository.save(newEntity);
        return converter.toDTO(newEntity);
    }
    @Override
    public NewDTO update(NewDTO newDTO){
        CategoryEntity category=categoryRepository.findOneByCode(newDTO.getCategoryCode());
        NewEntity newEntity=converter.toEntity(newDTO);
        newEntity.setCategory(category);
        newEntity=newRepository.save(newEntity);
        return converter.toDTO(newEntity);
    }
}
