package br.com.LojaLucas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.LojaLucas.domain.Calcado;
import br.com.LojaLucas.dto.CalcadoDTO;
import br.com.LojaLucas.repository.CalcadoRepository;
import br.com.LojaLucas.service.ServiceException;

@Service
public class CalcadoService {
	
	private CalcadoRepository calcadoRepository;

	@Autowired
	public CalcadoService(CalcadoRepository calcadoRepository) {
		this.calcadoRepository = calcadoRepository;
	}

	public void save(CalcadoDTO calcadoDTO) {
		int tipo = calcadoDTO.getTipo();
		String modelo = calcadoDTO.getModelo();
		int tamanho = calcadoDTO.getTamanho();

		Calcado calcado = new Calcado(tipo, modelo, tamanho);
		this.calcadoRepository.saveAndFlush(calcado);
	}

	public Calcado findById(Integer id) {
		Optional<Calcado> calcado = calcadoRepository.findById(id);
		if (calcado.isPresent()) {
			return calcado.get();
		}
		throw new ServiceException("Calcado não encontrado");
	}

	public List<CalcadoDTO> findAll() {
		List<CalcadoDTO> calcadoParaRetorno = new ArrayList<CalcadoDTO>();
		List<Calcado> calcados = calcadoRepository.findAll();

		for (Calcado calcado : calcados) {
			CalcadoDTO calcadoDTO = criarCalcadoDTO(calcado);
			calcadoParaRetorno.add(calcadoDTO);
		}

		return calcadoParaRetorno;
	}

	private CalcadoDTO criarCalcadoDTO(Calcado calcado) {
		CalcadoDTO calcadoDTO = new CalcadoDTO();
		calcadoDTO.setId(calcado.getId());
		calcadoDTO.setTipo(calcado.getTipo());
		calcadoDTO.setModelo(calcado.getModelo());
		calcadoDTO.setTamanho(calcado.getTamanho());
		return calcadoDTO;
	}

	public void delete(Integer id) {
		this.calcadoRepository.deleteById(id);
	}

	public CalcadoDTO findByModelo(String modelo) {
		Optional<Calcado> calcado = calcadoRepository.findByName(modelo);
		if (calcado.isPresent()) {
			CalcadoDTO calcadoDTO = criarCalcadoDTO(calcado.get());
			return calcadoDTO;
		}
		throw new ServiceException("Calcado não encontrado");
	}

}