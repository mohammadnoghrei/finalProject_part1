package madsilver.service;

import madsilver.base.service.BaseService;
import madsilver.model.Services;

import java.util.List;

public interface ServicesService extends BaseService<Services,Long> {
    List<Services> findAll();
}
