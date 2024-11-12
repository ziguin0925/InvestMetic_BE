package com.investmetic.domain.strategy.dto.request;

import com.investmetic.domain.strategy.model.entity.StockType;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StockTypeRequestDTO {
    private String stockTypeName; // 종목명

    private int size;

    @Column(length = 1000)
    private String stockTypeIconURL; // 종목아이콘 경로

    @Builder
    public StockTypeRequestDTO(String stockTypeName, String stockTypeIconURL, int size){

        this.stockTypeName = stockTypeName;
        this.stockTypeIconURL = stockTypeIconURL;
        this.size = size;
    }
    public StockType toEntity(){
        return StockType.builder()
                .stockTypeName(stockTypeName)
                .activateState(true)
                .stockTypeIconURL(stockTypeIconURL).build();
    }
}
