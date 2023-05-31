package kz.CIS.CIScountries.Services;

import org.springframework.web.multipart.MultipartFile;


public interface FileService {
    boolean uploadPhoto(MultipartFile file, Long id);
}
