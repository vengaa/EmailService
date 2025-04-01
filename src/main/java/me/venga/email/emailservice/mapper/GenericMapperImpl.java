package me.venga.email.emailservice.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GenericMapperImpl implements GenericMapper {

    private final ModelMapper mapper;

    public <T> T entidadeParaDTO(Object entidade, Class<T> dto){
        return mapper.map(entidade, dto);
    }

    public <T> T dtoParaEntidade(Object dto, Class<T> entidade){

        return mapper.map(dto, entidade);
    }

    public <T> List<T> entidadesParaDTOs(List<?> entidades, Class<T> dto){

        return entidades.stream().map(entidade -> mapper.map(entidade, dto))
                .collect(Collectors.toList());
    }

    @Override
    public <T> List<T> dtosParaEntidades(List<?> dtos, Class<T> entidade) {

        return dtos.stream().map(dto -> mapper.map(dto, entidade))
                .collect(Collectors.toList());
    }
}
