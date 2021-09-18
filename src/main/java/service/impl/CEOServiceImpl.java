package service.impl;

import base.service.BaseServiceImpl;
import domain.CEO;
import repository.CEORepository;
import service.CEOService;

public class CEOServiceImpl extends BaseServiceImpl<CEO,Long, CEORepository> implements CEOService {
    public CEOServiceImpl(CEORepository repository) {
        super(repository);
    }
}
