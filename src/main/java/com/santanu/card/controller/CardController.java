package com.santanu.card.controller;

import com.santanu.card.model.Card;
import com.santanu.card.model.Customer;
import com.santanu.card.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @GetMapping("/card-details")
    public List<Card> getCardDetails(@RequestBody @Validated Customer customer) {
        return cardService.findByCustomerId(customer.getCustomerId()).orElse(null);
    }
}
