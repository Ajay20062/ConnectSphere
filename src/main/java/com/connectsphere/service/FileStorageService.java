package com.connectsphere.service;
import org.springframework.beans.factory.annotation.Value; import org.springframework.stereotype.Service; import org.springframework.web.multipart.MultipartFile;
import java.nio.file.*; import java.util.UUID;
@Service
public class FileStorageService {
 @Value("${app.upload.dir:uploads}") private String uploadDir;
 public String save(MultipartFile file) throws Exception {
  if(file==null || file.isEmpty()) return null;
  String original=Path.of(file.getOriginalFilename()==null?"upload":file.getOriginalFilename()).getFileName().toString();
  String ext=original.contains(".")?original.substring(original.lastIndexOf(".")):"";
  String name=UUID.randomUUID()+ext; Path dir=Paths.get(uploadDir).toAbsolutePath().normalize();
  Files.createDirectories(dir); Files.copy(file.getInputStream(),dir.resolve(name),StandardCopyOption.REPLACE_EXISTING);
  return "/uploads/"+name;
 }
}
