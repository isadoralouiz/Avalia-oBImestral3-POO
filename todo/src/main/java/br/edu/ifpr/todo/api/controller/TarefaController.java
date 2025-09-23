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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tarefas")
// @CrossOrigin(origins = "*") // Libere se for consumir de um front rodando em outra origem
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    // ✅ Criar tarefa (POST)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TarefaResponse criar(@Valid @RequestBody TarefaRequest dto) {
        Tarefa salvo = service.criar(dto);
        return toResponse(salvo);
    }

    // ✅ Listar todas (com filtros opcionais)
    @GetMapping
    public List<TarefaResponse> listar(
            @RequestParam(required = false) TodoStatus status,
            @RequestParam(required = false) Boolean importante) {
        return service.listar(null, status, importante, null)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    // ✅ Buscar por ID
    @GetMapping("/{id}")
    public TarefaResponse buscarPorId(@PathVariable Long id) {
        Tarefa tarefa = service.buscarPorId(id);
        return toResponse(tarefa);
    }

    // ✅ Atualização parcial (PATCH)
    @PatchMapping("/{id}")
    public TarefaResponse atualizarParcial(
            @PathVariable Long id,
            @RequestBody TarefaRequest atualizacao) {
        Tarefa atualizado = service.atualizar(id, atualizacao);
        return toResponse(atualizado);
    }

    // ✅ remover
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }

    // 🔄 Conversor para DTO de resposta
    private TarefaResponse toResponse(Tarefa salvo) {
        return new TarefaResponse(
                salvo.getId(),
                salvo.getNome(),
                salvo.getDescricao(),
                salvo.getStatus(),
                salvo.getDataCriacao(),
                salvo.getDataEntrega(),
                salvo.getImportante()
        );
    }
}
