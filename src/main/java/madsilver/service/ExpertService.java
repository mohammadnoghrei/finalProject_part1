package madsilver.service;

import madsilver.base.service.BaseService;
import madsilver.model.Expert;
import madsilver.model.Person;

import java.util.List;

public interface ExpertService extends BaseService<Expert,Long> {
    Expert findByUsername(String username);
    List<Expert> findAllNotConfirmedExpert();
    List<Expert> findAllConfirmedExpert();
}
