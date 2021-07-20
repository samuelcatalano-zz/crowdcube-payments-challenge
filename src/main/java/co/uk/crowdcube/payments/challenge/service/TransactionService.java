package co.uk.crowdcube.payments.challenge.service;

import co.uk.crowdcube.payments.challenge.repository.TransactionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository repository;
    private final ObjectMapper objectMapper;

    @Autowired
    public TransactionService(final TransactionRepository repository, final ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

}
