package com.forum.hub.domain.topicos;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopicos(
                                      String titulo,
                                      String mensagem,
                                      String curso) {
}
