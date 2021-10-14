package com.rexus.dft.categoriaservico;

import com.rexus.dft.categoriaservico.dto.CategoriaServicoDto;
import com.rexus.dft.categoriaservico.dto.CategoriaServicoSearchDto;
import com.rexus.dft.util.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Classe responsável pelas invocações da API de categorias de serviço.
 */
// Link para como declarar as APIs no OpenAPI:
// https://download.eclipse.org/microprofile/microprofile-open-api-1.0/microprofile-openapi-spec.html
@RestController
@RequestMapping("/categorias")
public class CategoriaServicoApi {

    private static final Logger log = LoggerFactory.getLogger(CategoriaServicoApi.class);

    private final CategoriaServicoService service;

    public CategoriaServicoApi(CategoriaServicoService service) {
        this.service = service;
    }

    @GetMapping
    public Page<CategoriaServicoDto> listar(
            final CategoriaServicoSearchDto params,
            final Pagination pagination) {

        log.info("Pesquisando categorias de serviço: " + params);
        return service.listar(params, pagination);
    }

    @GetMapping("/{id}")
    public Optional<CategoriaServicoDto> listarPorId(@PathVariable("id") Long id) {
        return service.listar(id);
    }

    @PostMapping
    public void criar(@RequestBody CategoriaServicoDto categoria) {
        service.salvar(categoria);
    }

    @PutMapping("/{id}")
    public void atualizar(
            @PathVariable("id") Long id,
            @RequestBody CategoriaServicoDto categoria) {
        if (service.listar(id).isEmpty()) {
            throw new IllegalArgumentException("ID inexistente");
        }
        categoria.setId(id);
        service.salvar(categoria);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id) {
        service.excluir(id);
    }
}