package com.residencia.academia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.academia.dto.InstrutorDTO;
import com.residencia.academia.dto.TurmaDTO;
import com.residencia.academia.entity.Instrutor;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.repository.InstrutorRepository;

@Service
public class InstrutorService {
	@Autowired
	InstrutorRepository instrutorRepository;
	
	public List<Instrutor> findAllInstrutor(){
		return instrutorRepository.findAll(); /* Método do repository para listar todos */
	}

	public Instrutor findInstrutorById(Integer id) {
		return instrutorRepository.findById(id).isPresent() ?
				instrutorRepository.findById(id).get() : null;
	}
	
	
	public InstrutorDTO findInstrutorDTOById(Integer id) {
		Instrutor instrutor = instrutorRepository.findById(id).isPresent() ?
				instrutorRepository.findById(id).get() : null; 
		
		InstrutorDTO instrutorDTO = new InstrutorDTO();
		if(null != instrutor) {
			instrutorDTO = converterEntidadeParaDto(instrutor);
			}
		return instrutorDTO;
		}
	
	private InstrutorDTO converterEntidadeParaDto(Instrutor instrutor) {
		InstrutorDTO instrutorDTO = new InstrutorDTO();
		instrutorDTO.setDataNascimento(instrutor.getDataNascimento());
		instrutorDTO.setIdInstrutor(instrutor.getIdInstrutor());
		instrutorDTO.setNomeInstrutor(instrutor.getNomeInstrutor());
		instrutorDTO.setRg(instrutor.getRg());
		instrutorDTO.setTitulacaoInstrutor(instrutor.getTitulacaoInstrutor());
		
		List<TurmaDTO> listTurmaDTO = new ArrayList<>();
		if(null != instrutor.getTurmaList()) {
			
		
		for(Turma turma : instrutor.getTurmaList()) {
			TurmaDTO turmaDTO = new TurmaDTO();
			turmaDTO.setDataFim(turma.getDataFim());
			turmaDTO.setDataInicio(turma.getDataInicio());
			turmaDTO.setDuracaoTurma(turma.getDuracaoTurma());
			turmaDTO.setHorarioTurma(turma.getHorarioTurma());
			turmaDTO.setIdTurma(turma.getIdTurma());
			
			listTurmaDTO.add(turmaDTO);
		}
		
		instrutorDTO.setTurmaDTOList(listTurmaDTO);
		}
		return instrutorDTO;
		
	}
	
	private Instrutor convertDTOtoEntidade(InstrutorDTO instrutorDTO) {
		Instrutor instrutor = new Instrutor();
		instrutor.setDataNascimento(instrutorDTO.getDataNascimento());
		instrutor.setIdInstrutor(instrutorDTO.getIdInstrutor());
		instrutor.setRg(instrutorDTO.getRg());
		instrutor.setTitulacaoInstrutor(instrutorDTO.getTitulacaoInstrutor());
		instrutor.setNomeInstrutor(instrutorDTO.getNomeInstrutor());
	
		return instrutor;
	}
	
	public InstrutorDTO saveInstrutorDTO(InstrutorDTO instrutorDTO) {
		Instrutor instrutor = convertDTOtoEntidade(instrutorDTO);
		Instrutor novoInstrutor = instrutorRepository.save(instrutor);
		
		return converterEntidadeParaDto(novoInstrutor);
		
	}
	
	
	public Instrutor saveInstrutor(Instrutor instrutor) {
		return instrutorRepository.save(instrutor);
	}
	
	public Instrutor updateInstrutor(Instrutor instrutor) {
		return instrutorRepository.save(instrutor); /* O método save, no banco, atualiza o arquivo se já existir e se não existir ele cria */
	}
	
	public void deleteInstrutor(Integer id) {
		Instrutor inst = instrutorRepository.findById(id).get();
		instrutorRepository.delete(inst);
	}
	
	public void deleteInstrutor(Instrutor instrutor) { /* deleta todo o Instrutor */
		instrutorRepository.delete(instrutor);
    }
}
