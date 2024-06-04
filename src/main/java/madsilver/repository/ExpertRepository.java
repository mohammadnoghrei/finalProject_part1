package madsilver.repository;

import madsilver.base.repository.BaseRepository;
import madsilver.model.Customer;
import madsilver.model.Expert;

import java.util.List;
import java.util.Optional;

public interface ExpertRepository extends BaseRepository<Expert, Long> {
    Optional<Expert> findByUsername(String username);
    public List<Expert> findAllNotConfirmedExpert();
}
