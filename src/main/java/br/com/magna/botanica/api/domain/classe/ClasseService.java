package br.com.magna.botanica.api.domain.classe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magna.botanica.api.domain.caule.DadosDetalhamentoCaule;
import br.com.magna.botanica.api.domain.caule.DadosListagemCaule;
import br.com.magna.botanica.api.domain.planta.DadosAtualizacaoPlanta;
import br.com.magna.botanica.api.domain.planta.DadosCadastroPlanta;

@Service
public class ClasseService {

	@Autowired
	private ClasseRepository classeRepository;
	
	public DadosDetalhamentoClasse detalhar(Long id) {
		var classe = classeRepository.getReferenceById(id);  
		return new DadosDetalhamentoClasse(classe);
	}
	public Page<DadosListagemClasse> listagem( Pageable paginacao) {
	var page = classeRepository.findAllByAtivoTrue(paginacao).map(DadosListagemClasse::new);
	return page;
	}
	
	public Classe valiadandoDadosDeClasse(DadosCadastroPlanta dados) {
		return classeRepository.validandoClasseComFilo(dados.classeId(),dados.filoId());
	}
	public Classe valiadandoDadosAtuliazacaoClasse(DadosAtualizacaoPlanta dados) {
		return classeRepository.validandoClasseComFilo(dados.classeId(),dados.filoId());
	}
}



