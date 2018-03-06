package br.com.andrecouto.games.service

import br.com.andrecouto.games.model.Game
import br.com.andrecouto.games.repository.GameRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GameServices {

    @Autowired
    lateinit var gameRepository : GameRepository

    fun buscarTodos() : List<Game>{
        return gameRepository.findAll()
    }

    fun salvar(game: Game) {
        gameRepository.save(game)
    }

    fun buscarPor(nome: String) : List<Game> {
        return gameRepository.findByNomeIgnoreCaseContaining(nome)
    }

    fun deletar(id: String) {
        gameRepository.deleteById(id)
    }
}