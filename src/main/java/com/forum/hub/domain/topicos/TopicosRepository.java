package com.forum.hub.domain.topicos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicosRepository extends JpaRepository<Topicos, Long> {
    Page<Topicos> findAllByAtivoTrue(Pageable paginacao);
}
