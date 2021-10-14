package com.rexus.dft.categoriaservico;

import org.springframework.data.jpa.repository.JpaRepository;

interface CategoriaServicoRepository extends JpaRepository<CategoriaServico, Long> {

    /**
     * Busca {@link CategoriaServico} de acordo com o tipo de metodologia informado.
     * 
     * @param filtro informações de paginação
     * @param pageable paginação
     * @return lista de {@link CategoriaServico} encontrados
     */
//    Page<CategoriaServico> findByDescricaoLikeIgnoreCase(String filtro, Pageable pageable);
}