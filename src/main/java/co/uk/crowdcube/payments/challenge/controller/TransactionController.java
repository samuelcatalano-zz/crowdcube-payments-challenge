package co.uk.crowdcube.payments.challenge.controller;

import co.uk.crowdcube.payments.challenge.dto.TransactionDTO;
import co.uk.crowdcube.payments.challenge.exception.InvalidInformationException;
import co.uk.crowdcube.payments.challenge.exception.TransactionException;
import co.uk.crowdcube.payments.challenge.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {

    private final TransactionService service;

    @Autowired
    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping(value = "", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> save(@RequestBody final TransactionDTO transactionDTO) throws TransactionException {
        try {
            return ResponseEntity.ok(service.createTransaction(transactionDTO));
        } catch (final InvalidInformationException e) {
            throw new TransactionException(e);
        }
    }
}
