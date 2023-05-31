package kz.Ivanov.crm.crm.manager.services;

import kz.Ivanov.crm.crm.manager.entities.Request;

import java.util.List;

public interface RequestService {
    Request addRequest (Request request);
    List<Request> getAllRequests();
    Request findRequestById (Long id);

}
