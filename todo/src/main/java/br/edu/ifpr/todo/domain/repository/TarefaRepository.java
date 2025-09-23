package br.edu.ifpr.todo.domain.repository;

import br.edu.ifpr.todo.domain.model.Tarefa;
import br.edu.ifpr.todo.domain.model.TodoStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findByStatus(TodoStatus status);

    List<Tarefa> findByImportanteTrue();

    List<Tarefa> findByStatusAndImportanteTrue(TodoStatus status);

    List<Tarefa> findByDataEntregaBefore(LocalDate limite);

    List<Tarefa> findByNomeContainingIgnoreCase(String q);
}
