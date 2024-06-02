package madsilver.repository;

import madsilver.base.repository.BaseRepository;
import madsilver.model.Services;

import java.util.List;

public interface ServicesRepository extends BaseRepository<Services, Long> {
    List<Services> findAll();
}
