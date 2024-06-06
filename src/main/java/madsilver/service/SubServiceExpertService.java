package madsilver.service;

import madsilver.base.service.BaseService;
import madsilver.model.Expert;

import madsilver.model.SubServiceExpert;
import madsilver.model.SubServices;



public interface SubServiceExpertService extends BaseService<SubServiceExpert,Long> {
    SubServiceExpert findSubServiceExpert(Expert expert, SubServices subServices);
}
