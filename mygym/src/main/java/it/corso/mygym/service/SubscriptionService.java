package it.corso.mygym.service;

import it.corso.mygym.model.Subscription;
import it.corso.mygym.model.dto.SubscriptionDto;

public interface SubscriptionService {

    Subscription save(SubscriptionDto dto);

    Subscription findById(long id);

    boolean deleteById(long id);

    Subscription update(long id, SubscriptionDto dto);
}
