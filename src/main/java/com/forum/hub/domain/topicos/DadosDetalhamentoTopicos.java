package com.forum.hub.domain.topicos;

import java.time.LocalDateTime;
import java.util.Date;

public record DadosDetalhamentoTopicos(Long id, String titulo, String mensagem, String autor, String curso, LocalDateTime dataCriacao) {

    public DadosDetalhamentoTopicos(Topicos topico) {
        this (topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getAutor(),
                topico.getCurso(),
                topico.getDataCriacao());
    }
}
