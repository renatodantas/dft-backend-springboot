package com.rexus.dft.converter;

import com.rexus.dft.enums.TipoMetodologiaEnum;

import javax.persistence.AttributeConverter;

public class TipoMetodologiaEnumConverter implements AttributeConverter<TipoMetodologiaEnum, Character> {

    @Override
    public Character convertToDatabaseColumn(TipoMetodologiaEnum tipo) {
        return tipo == null ? null : tipo.getCodigo();
    }

    @Override
    public TipoMetodologiaEnum convertToEntityAttribute(Character codigo) {
        return TipoMetodologiaEnum.of(codigo);
    }

}