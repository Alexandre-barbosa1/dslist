package com.devsuperior.dslist.services;

import com.devsuperior.dslist.entities.DTO.GameDTO;
import com.devsuperior.dslist.entities.DTO.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    @Transactional
    public List<GameMinDTO> findAll(){
      List<Game> result =  gameRepository.findAll();
      List<GameMinDTO> dto = result.stream().map(x-> new GameMinDTO(x)).toList();
      return dto;
    }
    @Transactional
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;


    }
    @Transactional
    public  List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> result =  gameRepository.searchByList(listId);
        return result.stream().map(x-> new GameMinDTO(x)).toList();

    }


}
