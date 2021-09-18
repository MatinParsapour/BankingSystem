package service.impl;

import base.service.BaseServiceImpl;
import domain.CEO;
import repository.CEORepository;

public class CEOServiceImpl extends BaseServiceImpl<CEO,Long, CEORepository> {
    public CEOServiceImpl(CEORepository repository) {
        super(repository);
    }
}
