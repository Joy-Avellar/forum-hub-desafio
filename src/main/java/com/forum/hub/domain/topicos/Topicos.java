package com.forum.hub.domain.topicos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;


@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataCriacao;

    private Boolean ativo;
    private String autor;
    private String curso;


    @PrePersist
    protected void onCreate() {
        // Adjust the time zone to the desired one, e.g., America/Sao_Paulo
        ZoneId zoneId = ZoneId.of("America/Sao_Paulo");
        this.dataCriacao = LocalDateTime.now(zoneId);
    }

    public Topicos(DadosNovoTopico dados) {
        this.mensagem = dados.mensagem();
        this.titulo = dados.titulo();
        this.ativo = true;
        this.autor = dados.autor();
        this.curso = dados.curso();
    }

    public void atualizarInformacoes(DadosAtualizacaoTopicos dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.curso = dados.curso();
    }

    public void excluir() {
        this.ativo = false;
    }
}