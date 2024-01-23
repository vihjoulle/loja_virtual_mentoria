package vaja.mentoria.lojavirtual2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vaja.mentoria.lojavirtual2.model.Acesso;


@Repository
@Transactional
public interface AcessoRepository extends JpaRepository<Acesso, Long> {

}
