package com.rexus.dft.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

/**
 * Classe que representa a paginação de registros.
 * 
 * @author Renato Dantas <rexdantas@gmail.com>
 */
public final class Pagination {

    private static final int DEFAULT_PAGE = 0;
    private static final int DEFAULT_SIZE = 10;

    private Integer page;
    private Integer size;
    private String sort;
    private String order;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    /**
     * Objeto para paginação do Spring Data.
     *
     * @return objeto de paginação
     */
    public Pageable toPageable() {
        int page = this.page != null ? this.page : DEFAULT_PAGE;
        int size = this.size != null ? this.size : DEFAULT_SIZE;
        Sort.Direction order = Sort.Direction
                .fromOptionalString(this.order)
                .orElse(Sort.Direction.ASC);
        Sort sort = Optional.ofNullable(this.sort)
                .map(s -> Sort.by(order, this.sort))
                .orElse(Sort.unsorted());
        return PageRequest.of(page, size, sort);
    }

//    /**
//     * Retorna uma lista como paginação do objeto {@link Page}
//     * do Spring Data.
//     *
//     * @param paged registros originais pesquisados do {@link org.springframework.stereotype.Repository}
//     * @param listaDestino coleção de itens a serem retornados no formato {@link Page}
//     * @param <T> coleção de objetos
//     * @return a quantidade de objetos no formato paginado
//     */
//    public <T> PageImpl<T> toPage(Page paged, List<T> listaDestino) {
//        return new PageImpl<T>(listaDestino, toPageable(), paged.getTotalElements());
//    }

    @Override
    public String toString() {
        final var pageable = toPageable();
        return String.format(
                "Pagination [page=%s, size=%s, sort=%s]",
                pageable.getPageNumber(),
                pageable.getPageSize(),
                pageable.getSort());
    }
}