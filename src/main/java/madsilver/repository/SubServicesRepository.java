package madsilver.repository;

import madsilver.base.repository.BaseRepository;
import madsilver.model.Services;
import madsilver.model.SubServices;

import java.util.List;

public interface SubServicesRepository extends BaseRepository<SubServices, Long> {
    List<SubServices> findAllSubServicesOfaService(Services services);
}
