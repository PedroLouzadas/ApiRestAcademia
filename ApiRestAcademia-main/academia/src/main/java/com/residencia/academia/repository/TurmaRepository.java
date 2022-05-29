package com.residencia.academia.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.academia.entity.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Integer> {
	/* Turma findyByDataInicio(Date dataInicio);
	Turma findyByDataInicioAndDataFim(Date dataInicio, Date dataFim); */
}