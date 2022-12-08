/**
 * 
 */
package com.yonier.apirest.models.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author yonie
 *
 */
public interface IUploadFileService {
	
	public Resource cargar(String nombreFoto) throws MalformedURLException;
	
	public String guardar(MultipartFile archivo) throws IOException;
	
	public boolean eliminar(String nombreFoto);
	
	public Path getPath(String nombreFoto);
 
}
