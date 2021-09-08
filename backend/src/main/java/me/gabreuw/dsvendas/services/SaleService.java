package me.gabreuw.dsvendas.services;

import me.gabreuw.dsvendas.dto.SaleDTO;
import me.gabreuw.dsvendas.entities.Sale;
import me.gabreuw.dsvendas.repositories.SaleRepository;
import me.gabreuw.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable) {
        sellerRepository.findAll(); // Os vendedores recuperados do banco de dados serão armazenadas em cache
        Page<Sale> result = saleRepository.findAll(pageable);

        return result.map(SaleDTO::new);
    }

}
