package com.yonier.apirest.models.services;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service

public class UploadFileServiceImpl  implements IUploadFileService{
	private final static String DIRECTORIO_UPLOAD = "uploads";

	@Override
	public Resource cargar(String nombreFoto) throws MalformedURLException {
		Path ruta = getPath(nombreFoto);
		
		Resource recurso = new UrlResource(ruta.toUri());
		
		if (!recurso.exists() && !recurso.isReadable()) {
			throw new RuntimeException("Error, no se pudo cargar la imagen: "+nombreFoto);
		}else {
			
			return recurso;
		}
		
	}

	@Override
	public String guardar(MultipartFile archivo) throws IOException {
		
		String nombreArchivo = UUID.randomUUID().toString()+"_"+ archivo.getOriginalFilename().replace(" ", "");
		Path ruta = getPath(nombreArchivo);

		Files.copy(archivo.getInputStream(), ruta);
		return nombreArchivo;
	}

	@Override
	public boolean eliminar(String nombreFoto) {
		if (nombreFoto != null && nombreFoto.length() > 0) {
			Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFoto).toAbsolutePath();
			File archivoFotoAnterior = rutaFotoAnterior.toFile();
			if (archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
				archivoFotoAnterior.delete();
				return true;
			}
		}
		return false;
	}

	@Override
	public Path getPath(String nombreFoto) {
		// TODO Auto-generated method stub
		return Paths.get(DIRECTORIO_UPLOAD).resolve(nombreFoto).toAbsolutePath();
	}

}
