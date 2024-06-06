package madsilver.repository;

import madsilver.base.repository.BaseRepository;
import madsilver.model.Expert;
import madsilver.model.SubServiceExpert;
import madsilver.model.SubServices;

import java.util.Optional;

public interface SubServiceExpertRepository extends BaseRepository<SubServiceExpert, Long> {
    Optional<SubServiceExpert> findSubServiceExpert(Expert expert, SubServices subServices);
}
