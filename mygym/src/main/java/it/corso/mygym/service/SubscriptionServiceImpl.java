package it.corso.mygym.service;

import it.corso.mygym.model.Subscription;
import it.corso.mygym.model.dto.SubscriptionDto;
import it.corso.mygym.repositories.SubscriptionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepo;

    @Override
    public Subscription save(SubscriptionDto dto) {
        ModelMapper mapper = new ModelMapper();
        Subscription sub = mapper.map(dto, Subscription.class);
        return subscriptionRepo.save(sub);
    }

    @Override
    public Subscription findById(long id) {
        Optional<Subscription> opt = subscriptionRepo.findById(id);
        return opt.orElse(null);
    }

    @Override
    public boolean deleteById(long id) {
        try {
            subscriptionRepo.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Subscription update(long id, SubscriptionDto dto) {
        Optional<Subscription> opt = subscriptionRepo.findById(id);
        dto.setId(id);
        if (opt.isPresent()) {
            Subscription subscription = opt.get();
            dto.setId(id);
            return subscriptionRepo.saveAndFlush(subscription);

        } else throw new ResourceNotFoundException();
    }

}
