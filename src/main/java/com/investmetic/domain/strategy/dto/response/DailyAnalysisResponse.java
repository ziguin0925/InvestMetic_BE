package com.investmetic.domain.strategy.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.investmetic.domain.strategy.exceldownload.ExcelColumn;
import com.investmetic.domain.strategy.exceldownload.ExcelSheet;
import com.querydsl.core.annotations.QueryProjection;
import java.time.LocalDate;
import lombok.Getter;

@Getter
@ExcelSheet(name = "전략 일간 분석")
public class DailyAnalysisResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @ExcelColumn(headerName = "날짜")
    private final LocalDate dailyDate;
    @ExcelColumn(headerName = "원금")
    private final long principal;                    // 원금
    @ExcelColumn(headerName = "입출금")
    private final long transaction;                  // 입출금
    @ExcelColumn(headerName = "일손익")
    private final long dailyProfitLoss;              // 일손익
    @ExcelColumn(headerName = "일 수익률")
    private final double dailyProfitLossRate;        // 일 수익률
    @ExcelColumn(headerName = "누적 손익")
    private final long cumulativeProfitLoss;       // 누적 손익
    @ExcelColumn(headerName = "누적 손익률")
    private final double cumulativeProfitLossRate;   // 누적 수익률

    @QueryProjection
    public DailyAnalysisResponse(LocalDate dailyDate, long principal, long transaction, long dailyProfitLoss,
                                 double dailyProfitLossRate, long cumulativeProfitLoss,
                                 double cumulativeProfitLossRate) {
        this.dailyDate = dailyDate;
        this.principal = principal;
        this.transaction = transaction;
        this.dailyProfitLoss = dailyProfitLoss;
        this.dailyProfitLossRate = dailyProfitLossRate;
        this.cumulativeProfitLoss = cumulativeProfitLoss;
        this.cumulativeProfitLossRate = cumulativeProfitLossRate;
    }
}
