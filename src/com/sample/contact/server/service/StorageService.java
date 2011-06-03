package com.sample.contact.server.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public interface StorageService {
  void storeFile(MultipartFile multipartFile) throws IOException;
}
