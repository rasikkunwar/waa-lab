package Assignment.service.impl;

import Assignment.domain.Logger;
import Assignment.repo.LoggerRepo;
import Assignment.service.LoggerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoggerServiceImpl implements LoggerService {
    public final LoggerRepo loggerRepo;
    @Override
    public void save(Logger logger) {
        loggerRepo.save(logger);
    }
}
