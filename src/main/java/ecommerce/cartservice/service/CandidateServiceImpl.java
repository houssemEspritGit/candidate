package ecommerce.cartservice.service;

import ecommerce.cartservice.exception.CandidateNotFoundException;
import ecommerce.cartservice.repository.CandidateRepository;
import ecommerce.cartservice.model.Candidate;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor

public class CandidateServiceImpl implements CandidateService {

    CandidateRepository candidateRepository;
    private static final Logger logger = LogManager.getLogger(CandidateServiceImpl.class);

    @Override
    public List<Candidate> getAllCandidates() {

        logger.trace("Users are just fetched");

        return candidateRepository.findAll();
    }

    @Override
    public Optional<Candidate> getCandidateById(String id) {

        logger.trace("User fetched");


        return candidateRepository.findById(id);
    }

    @Override
    public Candidate createCandidate(Candidate candidate) {

        logger.trace("User created");

        return candidateRepository.save(candidate);
    }

    @Override
    public Candidate updateCandidate(Candidate candidateDto, String id) throws CandidateNotFoundException {
        Optional<Candidate> candidate = this.candidateRepository.findById(id);
        if (candidate.isPresent()) {
            return this.candidateRepository.save(candidateDto);
        } else {
            throw new CandidateNotFoundException(id);
        }
    }

    @Override
    public void deleteCandidate(String id) {
        candidateRepository.deleteById(id);
    }
}
