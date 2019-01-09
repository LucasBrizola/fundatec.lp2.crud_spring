package com.loja.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja.domain.RoupaVerao;
import com.loja.dto.RoupaVeraoDTO;
import com.loja.repository.RoupaVeraoRepository;

@Service
public class RoupaVeraoService {

	private RoupaVeraoRepository roupaVeraoRepository;

	@Autowired
	public RoupaVeraoService(RoupaVeraoRepository roupaVeraoRepository) {
		this.roupaVeraoRepository = roupaVeraoRepository;
	}

	public void save(RoupaVeraoDTO roupaVeraoDTO) {
		int tipo = roupaVeraoDTO.getTipo();
		String modelo = roupaVeraoDTO.getModelo();
		String tamanho = roupaVeraoDTO.getTamanho();

		RoupaVerao roupaVerao = new RoupaVerao(tipo, modelo, tamanho);
		this.roupaVeraoRepository.saveAndFlush(roupaVerao);
	}

	public RoupaVerao findById(Integer id) {
		Optional<RoupaVerao> roupaVerao = roupaVeraoRepository.findById(id);
		if (roupaVerao.isPresent()) {
			return roupaVerao.get();
		}
		throw new ServiceException("Roupa de verão não encontrada");
	}

	public List<RoupaVeraoDTO> findAll() {
		List<RoupaVeraoDTO> roupaVeraoParaRetorno = new ArrayList<RoupaVeraoDTO>();
		List<RoupaVerao> roupasVerao = roupaVeraoRepository.findAll();

		for (RoupaVerao roupaVerao : roupasVerao) {
			RoupaVeraoDTO roupaVeraoDTO = criarRoupaVeraoDTO(roupaVerao);
			roupaVeraoParaRetorno.add(roupaVeraoDTO);
		}

		return roupaVeraoParaRetorno;
	}

	private RoupaVeraoDTO criarRoupaVeraoDTO(RoupaVerao roupaVerao) {
		RoupaVeraoDTO roupaVeraoDTO = new RoupaVeraoDTO();
		roupaVeraoDTO.setId(roupaVerao.getId());
		roupaVeraoDTO.setTipo(roupaVerao.getTipo());
		roupaVeraoDTO.setModelo(roupaVerao.getModelo());
		roupaVeraoDTO.setTamanho(roupaVerao.getTamanho());
		return roupaVeraoDTO;
	}

	public void delete(Integer id) {
		this.roupaVeraoRepository.deleteById(id);
	}

	public RoupaVeraoDTO findByModelo(String modelo) {
		Optional<RoupaVerao> roupaVerao = roupaVeraoRepository.findByName(modelo);
		if (roupaVerao.isPresent()) {
			RoupaVeraoDTO roupaVeraoDTO = criarRoupaVeraoDTO(roupaVerao.get());
			return roupaVeraoDTO;
		}
		throw new ServiceException("Roupa de Verao não encontrado");
	}
}