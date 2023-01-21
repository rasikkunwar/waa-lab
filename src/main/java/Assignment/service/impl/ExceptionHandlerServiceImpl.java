package Assignment.service.impl;

import Assignment.domain.ExceptionHandler;
import Assignment.domain.Logger;
import Assignment.repo.ExceptionHandlerRepo;
import Assignment.repo.LoggerRepo;
import Assignment.service.ExceptionHandlerService;
import Assignment.service.LoggerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExceptionHandlerServiceImpl implements ExceptionHandlerService {
    public final ExceptionHandlerRepo exceptionHandlerRepo;
    @Override
    public void save(ExceptionHandler exceptionHandler) {
        exceptionHandlerRepo.save(exceptionHandler);
    }
}
