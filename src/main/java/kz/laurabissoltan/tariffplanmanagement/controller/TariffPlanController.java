package kz.laurabissoltan.tariffplanmanagement.controller;

import kz.laurabissoltan.tariffplanmanagement.repository.TariffPlanRepository;
import kz.laurabissoltan.tariffplanmanagement.service.TariffPlanSpecifications;
import kz.laurabissoltan.tariffplanmanagement.entity.TariffPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TariffPlanController {

    @Autowired
    private TariffPlanRepository tariffPlanRepository;

    @GetMapping("/tariffPlans")
    public Page<TariffPlan> getTariffPlans(
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Double minDataAllowance,
            Pageable pageable) {
        return tariffPlanRepository.findAll(TariffPlanSpecifications
                .withDynamicQuery(minPrice,maxPrice, minDataAllowance), pageable);
    }
}
