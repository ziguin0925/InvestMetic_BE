package com.investmetic.domain.strategy.repository;

import com.investmetic.domain.strategy.model.entity.TradeType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeTypeRepository extends JpaRepository<TradeType, Long> {
    Optional<TradeType> findByTradeTypeId(Long tradeTypeId);
}
