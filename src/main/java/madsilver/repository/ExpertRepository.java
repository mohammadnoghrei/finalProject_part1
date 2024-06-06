package madsilver.repository;

import madsilver.base.repository.BaseRepository;
import madsilver.model.Expert;

import java.util.List;
import java.util.Optional;

public interface ExpertRepository extends BaseRepository<Expert, Long> {
    Optional<Expert> findByUsername(String username);

    List<Expert> findAllNotConfirmedExpert();

    List<Expert> findAllConfirmedExpert();
}
