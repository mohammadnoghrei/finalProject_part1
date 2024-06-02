package madsilver.service;

import madsilver.base.service.BaseService;
import madsilver.model.Services;
import madsilver.model.SubServices;

import java.util.List;

public interface SubServicesService extends BaseService<SubServices,Long> {
    List<SubServices> findAllSubServicesOfaService(Services services);
}
