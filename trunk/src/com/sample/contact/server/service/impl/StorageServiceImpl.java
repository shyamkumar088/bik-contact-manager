package com.sample.contact.server.service.impl;

import com.sample.contact.server.service.StorageService;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * User: nawaraj
 * Date: 5/27/11
 */
public class StorageServiceImpl implements StorageService {
  private Resource storageLocation;

  public void setStorageLocation(Resource storageLocation) {
    this.storageLocation = storageLocation;
  }

  public void storeFile(MultipartFile multipartFile) throws IOException{
      Resource fileLocation = storageLocation.createRelative(multipartFile.getOriginalFilename());
      multipartFile.transferTo(fileLocation.getFile());
  }
}
