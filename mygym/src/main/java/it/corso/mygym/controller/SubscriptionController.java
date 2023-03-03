package it.corso.mygym.controller;

import it.corso.mygym.model.Subscription;
import it.corso.mygym.model.dto.SubscriptionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/subscriptions")
public interface SubscriptionController {

    @PostMapping()
    ResponseEntity<Subscription> save(@RequestBody SubscriptionDto dto);

    @GetMapping("/subscriptions/{id}")
    ResponseEntity<Subscription> findById(@PathVariable("id") long id);
}
