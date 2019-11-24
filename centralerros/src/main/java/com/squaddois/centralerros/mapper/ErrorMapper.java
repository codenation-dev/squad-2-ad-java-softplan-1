package com.squaddois.centralerros.mapper;

import com.squaddois.centralerros.dto.ErrorDTO;
import com.squaddois.centralerros.model.Error;

import java.util.List;
import java.util.stream.Collectors;

public class ErrorMapper {

    private ErrorMapper(){
        super();
    }

    public static ErrorDTO toErrorDTO(Error error) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setId(error.getId());
        errorDTO.setCreatedAt(error.getCreatedAt());
        errorDTO.setDetails(error.getDetails());
        errorDTO.setEnvironment(error.getEnvironment());
        errorDTO.setErrorType(error.getErrorType());
        errorDTO.setHostname(error.getHostname());
        errorDTO.setTitle(error.getTitle());
        return errorDTO;
    }
    public static Error toError(ErrorDTO errorDTO) {
        Error error = new Error();
        error.setId(errorDTO.getId());
        error.setCreatedAt(errorDTO.getCreatedAt());
        error.setDetails(errorDTO.getDetails());
        error.setEnvironment(errorDTO.getEnvironment());
        error.setErrorType(errorDTO.getErrorType());
        error.setHostname(errorDTO.getHostname());
        error.setTitle(errorDTO.getTitle());
        return error;
    }

    public static List<ErrorDTO> toListErrorDTO(List<Error> errors) {
        return errors.stream().map(ErrorMapper::toErrorDTO).collect(Collectors.toList());
    }

    public static List<Error> toListErrors(List<ErrorDTO> errorDTOS) {
        return errorDTOS.stream().map(ErrorMapper::toError).collect(Collectors.toList());
    }
}