package com.investmetic.domain.strategy.controller;

import com.investmetic.domain.strategy.dto.response.DailyAnalysisResponse;
import com.investmetic.domain.strategy.dto.response.MonthlyAnalysisResponse;
import com.investmetic.domain.strategy.dto.response.StrategyAnalysisResponse;
import com.investmetic.domain.strategy.dto.response.StrategyDetailResponse;
import com.investmetic.domain.strategy.dto.response.statistic.StrategyStatisticsResponse;
import com.investmetic.domain.strategy.model.AnalysisOption;
import com.investmetic.domain.strategy.service.StrategyDetailService;
import com.investmetic.global.common.PageResponseDto;
import com.investmetic.global.exception.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/strategies/{strategyId}")
public class StrategyDetailController {

    private final StrategyDetailService strategyDetailService;

    @GetMapping("/statistics")
    public ResponseEntity<BaseResponse<StrategyStatisticsResponse>> getStrategyStatistics(
            @PathVariable Long strategyId) {
        StrategyStatisticsResponse result = strategyDetailService.getStatistics(strategyId);
        return BaseResponse.success(result);
    }

    @GetMapping("/daily-analysis")
    public ResponseEntity<BaseResponse<PageResponseDto<DailyAnalysisResponse>>> getDailyAnalysis(
            @PathVariable Long strategyId,
            @PageableDefault(size = 5, sort = "dailyDate", direction = Direction.DESC) Pageable pageable) {
        PageResponseDto<DailyAnalysisResponse> result = strategyDetailService.getDailyAnalysis(strategyId, pageable);
        return BaseResponse.success(result);
    }

    @GetMapping("/monthly-analysis")
    public ResponseEntity<BaseResponse<PageResponseDto<MonthlyAnalysisResponse>>> getMonthlyAnalysis(
            @PathVariable Long strategyId,
            @PageableDefault(size = 5, sort = "monthlyDate", direction = Direction.DESC) Pageable pageable) {
        PageResponseDto<MonthlyAnalysisResponse> result = strategyDetailService.
                getMonthlyAnalysis(strategyId, pageable);
        return BaseResponse.success(result);
    }

    @GetMapping("/detail")
    public ResponseEntity<BaseResponse<StrategyDetailResponse>> getStrategyDetail(
            @PathVariable Long strategyId,
            @RequestParam Long userId) {
        StrategyDetailResponse result = strategyDetailService.getStrategyDetail(strategyId, userId);
        return BaseResponse.success(result);
    }

    @GetMapping("/analysis")
    public ResponseEntity<BaseResponse<StrategyAnalysisResponse>> getStrategyAnalyisis(
            @PathVariable Long strategyId,
            @RequestParam AnalysisOption option1,
            @RequestParam AnalysisOption option2) {
        StrategyAnalysisResponse result = strategyDetailService.getStrategyAnalysis(strategyId, option1, option2);
        return BaseResponse.success(result);
    }
}
