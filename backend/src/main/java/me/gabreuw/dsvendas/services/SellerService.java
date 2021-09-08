package me.gabreuw.dsvendas.services;

import me.gabreuw.dsvendas.dto.SellerDTO;
import me.gabreuw.dsvendas.entities.Seller;
import me.gabreuw.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired
    private SellerRepository repository;

    public List<SellerDTO> findAll() {
        List<Seller> result = repository.findAll();

        return result
                .stream()
                .map(SellerDTO::new)
                .collect(Collectors.toList());
    }

}
