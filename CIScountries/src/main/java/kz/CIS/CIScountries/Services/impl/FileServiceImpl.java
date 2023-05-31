package kz.CIS.CIScountries.Services.impl;

import kz.CIS.CIScountries.Country;
import kz.CIS.CIScountries.CountryRepository;
import kz.CIS.CIScountries.Services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private CountryRepository countryRepository;
    @Override
    public boolean uploadPhoto(MultipartFile file,Long id) {
        try {
            byte bytes[] = file.getBytes();
            String fileName = "photo" + id;
            String filePath = "build/resources/main/static/" + fileName + ".jpg";
            Path path = Paths.get(filePath);
            Files.write(path,bytes);
            Country country = countryRepository.findAllById(id);
            country.setPicture(fileName);
            countryRepository.save(country);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}