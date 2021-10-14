package com.rexus.dft.categoriaservico;

import com.rexus.dft.categoriaservico.dto.CategoriaServicoDto;
import com.rexus.dft.util.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface CategoriaServicoMapper extends BaseMapper<CategoriaServico, CategoriaServicoDto> {

}