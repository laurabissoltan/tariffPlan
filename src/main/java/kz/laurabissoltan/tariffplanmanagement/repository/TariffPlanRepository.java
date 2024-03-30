package kz.laurabissoltan.tariffplanmanagement.repository;

import kz.laurabissoltan.tariffplanmanagement.entity.TariffPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TariffPlanRepository extends JpaRepository<TariffPlan, Long>, JpaSpecificationExecutor<TariffPlan> {
}
