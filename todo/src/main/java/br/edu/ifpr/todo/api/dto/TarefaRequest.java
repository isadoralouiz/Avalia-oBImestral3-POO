package br.edu.ifpr.todo.api.dto;

import br.edu.ifpr.todo.domain.model.TodoStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class TarefaRequest {
    @NotBlank
    @Size(max = 120)
    private String nome;
   
    @Size(max = 500)
    private String descricao;
    // Opcional no POST. No PUT/PATCH você pode enviar para atualizar
    private TodoStatus status;
    // Opcional
    private LocalDate dataEntrega;
    // Opcional (padrão false)
    private Boolean importante;
    // Getters/Setters

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public TodoStatus getStatus() {
        return status;
    }
    public void setStatus(TodoStatus status) {
        this.status = status;
    }
    public LocalDate getDataEntrega() {
        return dataEntrega;
    }
    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
    public Boolean getImportante() {
        return importante;
    }
    public void setImportante(Boolean importante) {
        this.importante = importante;
    }
}
