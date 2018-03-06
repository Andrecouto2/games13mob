package br.com.andrecouto.games.controller

import br.com.andrecouto.games.model.Game
import br.com.andrecouto.games.service.GameServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping(value = "/game")
class GameController {

    @Autowired
    lateinit var gameServices : GameServices

    @GetMapping
    fun buscarTodos(): List<Game> {
        return gameServices.buscarTodos()
    }

    @PostMapping
    fun salvar(@RequestBody game: Game) {
        gameServices.salvar(game)
    }

    @GetMapping(value = "/titulo/{titulo}")
    fun buscarPor(@PathVariable(value = "titulo") titulo: String) : List<Game> {
        return gameServices.buscarPor(nome = titulo)
    }

    @DeleteMapping("{id}")
    fun apagar(@PathVariable("id") id : String) {
        gameServices.deletar(id)
    }
}