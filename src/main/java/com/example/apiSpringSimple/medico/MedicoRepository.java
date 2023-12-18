package com.example.apiSpringSimple.medico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}


/*
JpaRepository é uma classe do proprio JPA e seus atributos são
relacionados ao tipo de entidade com quem esse repository vai
trabalhar e o tipo do atributo da chave primaria dessa entidade.
 */