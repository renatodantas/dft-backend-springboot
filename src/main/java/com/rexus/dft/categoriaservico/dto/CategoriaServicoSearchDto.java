package com.rexus.dft.categoriaservico.dto;

import com.rexus.dft.enums.TipoMetodologiaEnum;

public class CategoriaServicoSearchDto {

    private String filtro;
    private TipoMetodologiaEnum metodologia;

    public String getFiltro() {
        return filtro;
    }
    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }
    public TipoMetodologiaEnum getMetodologia() {
        return metodologia;
    }
    public void setMetodologia(TipoMetodologiaEnum metodologia) {
        this.metodologia = metodologia;
    }

    @Override
    public String toString() {
        return "CategoriaServicoSearchDto{" +
                "filtro=" + filtro +
                ", tipoMetodologia=" + metodologia +
                '}';
    }
}