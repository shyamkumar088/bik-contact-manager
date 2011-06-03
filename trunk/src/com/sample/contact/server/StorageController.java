/* Copyright (c) 2006 celumsolutions. All Rights Reserved. */
package com.sample.contact.server;

import com.sample.contact.server.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * User: nawaraj
 * Date: 5/27/11
 */
@Controller
@RequestMapping(value = "/upload")
public class StorageController {

  private static final Logger logger = LoggerFactory.getLogger(StorageController.class);
  StorageService storageService;

  public void setStorageService(StorageService storageService) {
    this.storageService = storageService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String test(/*@RequestParam("uploadedfile") MultipartFile multipartFile*/) {
    return "upload";
  }

  @RequestMapping(method = RequestMethod.POST)
  public
  @ResponseBody
  String storeUploadedFile(@RequestParam(value = "uploadedfile", required = false) MultipartFile multipartFile) {
    try {
      storageService.storeFile(multipartFile);
    } catch (IOException e) {
      e.printStackTrace();
      return "Error";
    }
    return "Ok";
  }

  @RequestMapping(value = "{filename}", method = RequestMethod.DELETE)
  public void deleteUploadedFile(@PathVariable String filename) {
    logger.info("requested for file deletion: " + filename);
  }

  @RequestMapping(method = RequestMethod.PUT)
  public void modifyUploadedFile(@PathVariable String filename) {
    logger.info("requested for file deletion: " + filename);
  }
}
