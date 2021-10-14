package com.rexus.dft.categoriaservico;

import com.rexus.dft.categoriaservico.dto.CategoriaServicoDto;
import com.rexus.dft.categoriaservico.dto.CategoriaServicoSearchDto;
import com.rexus.dft.util.Pagination;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaServicoService {

    private final CategoriaServicoRepository repository;
    private final CategoriaServicoMapper mapper;

    public CategoriaServicoService(CategoriaServicoRepository repository, CategoriaServicoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Realiza a busca de categorias de serviço por um tipo específico.
     * 
     * @param params      o valor para filtrar os registros
     * @param pagination  informações de paginação
     * @return as {@link CategoriaServico}s cadastradas
     */
    public Page<CategoriaServicoDto> listar(CategoriaServicoSearchDto params, Pagination pagination) {
//        if (StringUtils.isEmpty(params.filtro)) {
//            Page<CategoriaServico> paginado = repository.findAll(pagination.toPageable());
//            List<CategoriaServicoDto> dtos = paginado.stream().map(mapper::toDto).collect(toList());
//            return pagination.toPage(paginado, dtos);
//        }

//        Example<CategoriaServico> example = Example.of(new CategoriaServico(params.filtro, params.metodologia),
//                matching().withMatcher("descricao", match -> match.startsWith().endsWith().ignoreCase()));
//
//        Page<CategoriaServico> paginados = repository.findAll(example, pagination.toPageable());
//        List<CategoriaServicoDto> dtosPaginados = paginados.stream().map(mapper::toDto).collect(toList());
//        return pagination.toPage(paginados, dtosPaginados);
        return repository.findAll(pagination.toPageable()).map(mapper::toDto);
    }

    public Optional<CategoriaServicoDto> listar(long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    public void salvar(CategoriaServicoDto categoria) {
        CategoriaServico entity = mapper.toEntity(categoria);
        if (categoria.getId() != null) {
            CategoriaServicoDto dto = listar(categoria.getId())
        	    .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
            entity = mapper.toEntity(dto);
        }

        entity.setDescricao(categoria.getDescricao());
        entity.setTipo(categoria.getTipo());
        repository.save(entity);
    }

    public void excluir(Long id) {
        CategoriaServico categoria = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoria inexistente"));
        try {
            repository.delete(categoria);
        } catch (Exception e) {
            if (e.getCause() instanceof ConstraintViolationException) {
                throw new RuntimeException("Categoria em uso e não pode ser excluída");
            }
            throw e;
        }
    }
}