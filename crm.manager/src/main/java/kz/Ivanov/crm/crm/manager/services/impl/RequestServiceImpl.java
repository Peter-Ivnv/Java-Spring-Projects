package kz.Ivanov.crm.crm.manager.services.impl;

import kz.Ivanov.crm.crm.manager.entities.Request;
import kz.Ivanov.crm.crm.manager.repositories.RequestRepository;
import kz.Ivanov.crm.crm.manager.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    RequestRepository requestRepository;
    @Override
    public Request addRequest(Request request) {
        return requestRepository.save(request);
    }

    @Override
    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    @Override
    public Request findRequestById(Long id) {
        return requestRepository.findById(id).orElse(null);
    }

    }

