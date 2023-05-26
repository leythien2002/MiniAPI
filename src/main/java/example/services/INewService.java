package example.services;

import example.dto.NewDTO;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface INewService {
    NewDTO save(NewDTO newDTO);
    void delete(long[]id);
    List<NewDTO> findAll(Pageable pageable);
    int totalItem();
}
