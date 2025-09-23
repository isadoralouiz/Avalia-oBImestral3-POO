package br.edu.ifpr.todo.api.dto;

import br.edu.ifpr.todo.domain.model.TodoStatus;
import java.time.LocalDate;
public class TarefaResponse {
private Long id;
private String nome;
private String descricao;
private TodoStatus status;
private LocalDate dataCriacao;
private LocalDate dataEntrega;
private Boolean importante;

public TarefaResponse(Long id, String nome, String descricao, TodoStatus status,LocalDate dataCriacao, LocalDate dataEntrega, Boolean importante){
this.id = id;
this.nome = nome;
this.descricao = descricao;
this.status = status;
this.dataCriacao = dataCriacao;
this.dataEntrega = dataEntrega;
this.importante = importante;
}
// Getters/Setters

public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
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
public LocalDate getDataCriacao() {
    return dataCriacao;
}
public void setDataCriacao(LocalDate dataCriacao) {
    this.dataCriacao = dataCriacao;
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