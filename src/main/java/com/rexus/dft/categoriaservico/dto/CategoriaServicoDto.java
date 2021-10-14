package com.rexus.dft.categoriaservico.dto;

import com.rexus.dft.enums.TipoMetodologiaEnum;

public class CategoriaServicoDto {

    private Long id;
    private String descricao;
    private TipoMetodologiaEnum tipo;

    public CategoriaServicoDto() {}

    public CategoriaServicoDto(String descricao, TipoMetodologiaEnum tipo) {
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public TipoMetodologiaEnum getTipo() {
	    return tipo;
    }

    public void setTipo(TipoMetodologiaEnum tipo) {
	this.tipo = tipo;
    }

}