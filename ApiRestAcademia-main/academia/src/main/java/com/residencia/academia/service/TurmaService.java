package com.residencia.academia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.academia.dto.TurmaDTO;
import com.residencia.academia.entity.Instrutor;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.repository.TurmaRepository;

@Service
public class TurmaService {
	@Autowired
	TurmaRepository turmaRepository;
	@Autowired
	InstrutorService instrutorService;
	
	public List<Turma> findAllTurma(){
		return turmaRepository.findAll();
	}
	
	public Turma findTurmaById(Integer id) {
		return turmaRepository.findById(id).isPresent() ?
			turmaRepository.findById(id).get() : null;
	}
	
	public TurmaDTO findTurmaDTOById(Integer id) {
		Turma turma = turmaRepository.findById(id).isPresent() ?
				turmaRepository.findById(id).get() : null; 
		
		TurmaDTO turmaDTO = new TurmaDTO();
		if(null != turma) {
			turmaDTO = convertendoEntidadeParaDto(turma);
			}
		return turmaDTO;
		}
	
	public Turma saveTurma(Turma turma) {
		return turmaRepository.save(turma);
	}
	
	public TurmaDTO saveTurmaDTO(TurmaDTO turmaDTO) {
		Turma turma = convertendoDTOparaEntidade(turmaDTO);
		Turma turma2 = turmaRepository.save(turma);
		return convertendoEntidadeParaDto(turma2);
	}
	
	public Turma updateTurma(Turma turma) {
		return turmaRepository.save(turma);
	}
	
	public void deleteTurma(Integer id) {
		turmaRepository.deleteById(id);
	}
	
	public TurmaDTO convertendoEntidadeParaDto(Turma turma) {
		TurmaDTO turmaDTO = new TurmaDTO();
		turmaDTO.setDataFim(turma.getDataFim());
		turmaDTO.setDataInicio(turma.getDataInicio());
		turmaDTO.setDuracaoTurma(turma.getDuracaoTurma());
		turmaDTO.setHorarioTurma(turma.getHorarioTurma());
		turmaDTO.setIdTurma(turma.getIdTurma());
		
	
		return turmaDTO;
	
	}
	
	private Turma convertendoDTOparaEntidade(TurmaDTO turmadto) {
        Turma turma = new Turma();
        turma.setDataFim(turmadto.getDataFim());
        turma.setDataInicio(turmadto.getDataInicio());
        turma.setDuracaoTurma(turmadto.getDuracaoTurma());
        turma.setHorarioTurma(turmadto.getHorarioTurma());
        turma.setIdTurma(turmadto.getIdTurma());

        Instrutor instrutor = instrutorService.findInstrutorById(turmadto.getInstrutorDTO().getIdInstrutor());
        if (null != instrutor) {
            turma.setInstrutor(instrutor);
        }

        return turma;

    }
}
	

