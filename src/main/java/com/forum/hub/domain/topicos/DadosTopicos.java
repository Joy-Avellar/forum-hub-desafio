package com.forum.hub.domain.topicos;

import java.time.LocalDateTime;
import java.util.Date;

public record DadosTopicos(Long id, String titulo, String mensagem, LocalDateTime dataCriacao, String autor, String curso) {

    public DadosTopicos(Topicos topicos) {
        this(topicos.getId(), topicos.getTitulo(),
                topicos.getMensagem(), topicos.getDataCriacao(), topicos.getAutor(),
                topicos.getCurso());
    }
}
