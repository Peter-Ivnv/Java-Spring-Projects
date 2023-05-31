package kz.Ivanov.crm.crm.manager.services.impl;
import kz.Ivanov.crm.crm.manager.entities.Operators;
import kz.Ivanov.crm.crm.manager.repositories.OperatorsRepository;
import kz.Ivanov.crm.crm.manager.services.OperatorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OperatorsServiceImpl implements OperatorsService {

    @Autowired
    private OperatorsRepository operatorsRepository;
    @Override
    public List<Operators> getAllOperators() {
        return operatorsRepository.findAll();
    }
}
