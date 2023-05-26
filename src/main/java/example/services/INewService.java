package example.services;

import example.dto.NewDTO;

public interface INewService {
    NewDTO save(NewDTO newDTO);
    void delete(long[]id);
}
