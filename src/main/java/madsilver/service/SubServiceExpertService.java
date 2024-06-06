package madsilver.service;

import madsilver.base.service.BaseService;
import madsilver.model.Expert;
import madsilver.model.Services;
import madsilver.model.SubServiceExpert;
import madsilver.model.SubServices;

import java.util.Optional;

public interface SubServiceExpertService extends BaseService<SubServiceExpert,Long> {
    SubServiceExpert findSubServiceExpert(Expert expert, SubServices subServices);
}
