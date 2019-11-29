package com.squaddois.centralerros.service;

import com.squaddois.centralerros.dto.ErrorDTO;
import com.squaddois.centralerros.mapper.ErrorMapper;
import com.squaddois.centralerros.entity.Environment;
import com.squaddois.centralerros.entity.Error;
import com.squaddois.centralerros.repository.ErrorRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ErrorService {

    private final ErrorRepository errorRepository;

    @Autowired
    public ErrorService(ErrorRepository errorRepository) {
        this.errorRepository = errorRepository;
    }

    public ErrorDTO findError(Long id) {
        return ErrorMapper.toErrorDTO(errorRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Error not found", Error.class.getName())));
    }

    public List<ErrorDTO> findAllErrors() {
        return ErrorMapper.toListErrorDTO(errorRepository.findAll());
    }

    public List<ErrorDTO> findErrorByEnviroment(Environment environment) {
        return ErrorMapper.toListErrorDTO(errorRepository.findErrorByEnvironment(environment));
    }
    public List<ErrorDTO> findErrorsByArchived(Boolean archived) {
        return ErrorMapper.toListErrorDTO(errorRepository.findErrorsByArchived(archived));
    }

    public List<ErrorDTO> findErrorsByEnvironmentAndArchived(Environment environment, Boolean archived) {
        return ErrorMapper.toListErrorDTO(errorRepository.findErrorsByEnvironmentAndArchived(environment, archived));
    }

    public void saveError(ErrorDTO errorDTO) {
        errorRepository.save(ErrorMapper.toError(errorDTO));
    }

    public void updateError(ErrorDTO errorDTO) {
        errorRepository.save(ErrorMapper.toError(errorDTO));
    }

    public void deleteError(Long id) {
        ErrorDTO errorDTO = findError(id);
        errorRepository.delete(ErrorMapper.toError(errorDTO));
    }
}