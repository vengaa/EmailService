package me.venga.email.emailservice.mapper;

import java.util.List;

public interface GenericMapper {
    <T> T entidadeParaDTO(Object entidade, Class<T> dto);
    <T> T dtoParaEntidade(Object dto, Class<T> entidade);
    <T> List<T> entidadesParaDTOs(List<?> entidades, Class<T> dto);
    <T> List<T> dtosParaEntidades(List<?> dtos, Class<T> entidade);
}
