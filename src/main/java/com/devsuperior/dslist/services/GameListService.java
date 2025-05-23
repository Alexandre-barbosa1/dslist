package com.devsuperior.dslist.services;

import com.devsuperior.dslist.entities.DTO.GameDTO;
import com.devsuperior.dslist.entities.DTO.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;
    @Transactional
    public List<GameListDTO> findAll(){
      List<GameList> result =  gameListRepository.findAll();
      List<GameListDTO> dto = result.stream().map(x-> new GameListDTO(x)).toList();
      return dto;
    }
    @Transactional
    public GameListDTO findById(Long id){
        GameList result = gameListRepository.findById(id).get();
        GameListDTO dto = new GameListDTO(result);
        return dto;


    }

}
