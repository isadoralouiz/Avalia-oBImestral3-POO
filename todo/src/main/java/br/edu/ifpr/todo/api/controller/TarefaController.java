package br.edu.ifpr.todo.api.controller;

import br.edu.ifpr.todo.api.dto.TarefaRequest;
import br.edu.ifpr.todo.api.dto.TarefaResponse;
import br.edu.ifpr.todo.domain.model.Tarefa;
import br.edu.ifpr.todo.domain.model.TodoStatus;
import br.edu.ifpr.todo.domain.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
// @CrossOrigin(origins = "*") // Libere se for consumir de um front rodando em
// outra origem
public class TarefaController {
    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    // Exemplo: GET
    // http://localhost:8080/tarefas/add?nome=Teste&descricao=Primeira%20tarefa&importante=true&status=FAZENDO&dataEntrega=2025-09-20
    @GetMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public TarefaResponse criarViaGet(
            @RequestParam String nome,
            @RequestParam(required = false) String descricao,
            @RequestParam(required = false, defaultValue = "A_FAZER") TodoStatus status,
            @RequestParam(required = false) Boolean importante,
            @RequestParam(required = false) String dataEntrega) {
        var dto = new TarefaRequest();
        dto.setNome(nome);
        dto.setDescricao(descricao);
        dto.setStatus(status);
        dto.setImportante(importante);
        if (dataEntrega != null && !dataEntrega.isBlank()) {
            dto.setDataEntrega(LocalDate.parse(dataEntrega)); // yyyy-MM-dd
        }
        Tarefa salvo = service.criar(dto);
        return new TarefaResponse(
                salvo.getId(),
                salvo.getNome(),
                salvo.getDescricao(),
                salvo.getStatus(),
                salvo.getDataCriacao(),
                salvo.getDataEntrega(),
                salvo.getImportante());
    }
}