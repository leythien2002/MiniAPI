package example.converter;

import example.dto.NewDTO;
import example.entity.NewEntity;
import org.springframework.stereotype.Component;

@Component
public class NewConverter {
    public NewEntity toEntity(NewDTO dto){
        NewEntity entity=new NewEntity();
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setThumbnail(dto.getThumbnail());
        entity.setShortDescription(dto.getShortDescription());
        return entity;
    }
    public NewDTO toDTO(NewEntity entity){
        NewDTO dto=new NewDTO();
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setThumbnail(entity.getThumbnail());
        dto.setShortDescription(entity.getShortDescription());
        return dto;
    }
}
