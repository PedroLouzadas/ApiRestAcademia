package com.residencia.academia.dto;

import java.util.List;

import javax.persistence.Column;

import com.residencia.academia.entity.Instrutor;
import com.residencia.academia.entity.Turma;

public class AtividadeDTO {
	private Integer idAtividade;
	private String nomeAtividade;
	private Instrutor instrutor;
	private List<TurmaDTO> turmaList;
	
	public Integer getIdAtividade() {
		return idAtividade;
	}
	public void setIdAtividade(Integer idAtividade) {
		this.idAtividade = idAtividade;
	}
	public String getNomeAtividade() {
		return nomeAtividade;
	}
	public void setNomeAtividade(String nomeAtividade) {
		this.nomeAtividade = nomeAtividade;
	}
	public Instrutor getInstrutor() {
		return instrutor;
	}
	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}
	
	public List<TurmaDTO> getTurmaList() {
		return turmaList;
	}
	public void setTurmaList(List<TurmaDTO> turmaList) {
		this.turmaList = turmaList;
	}
	@Override
	public String toString() {
		return "AtividadeDTO [idAtividade=" + idAtividade + ", nomeAtividade=" + nomeAtividade + ", instrutor="
				+ instrutor + ", turmaList=" + turmaList + "]";
	}

}
