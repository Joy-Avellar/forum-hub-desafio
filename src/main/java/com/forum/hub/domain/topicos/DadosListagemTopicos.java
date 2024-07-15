package com.forum.hub.domain.topicos;

import java.time.LocalDateTime;

public record DadosListagemTopicos(Long id, String titulo, String mensagem, String autor, String curso, LocalDateTime dataCriacao, Boolean estado_do_topico) {

    public DadosListagemTopicos(Topicos topico) {
        this (topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getAutor(),
                topico.getCurso(),
                topico.getDataCriacao(),
                topico.getAtivo());}
}