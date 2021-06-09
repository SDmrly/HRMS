package kodlamaio.HRMS.Adapter.concretes;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.Adapter.abstracts.CloudinaryService;
import kodlamaio.HRMS.CloudinaryUpload.CloudinaryUploadManager;

@Service
public class CloudinaryManager implements CloudinaryService{
	private CloudinaryUploadManager cloudinaryUploadManager;
	
	@Autowired
	public CloudinaryManager(CloudinaryUploadManager cloudinaryUploadManager) {
		super();
		this.cloudinaryUploadManager = cloudinaryUploadManager;
	}

	@Override
	public Map ImageoUpload(MultipartFile multipartFile) throws IOException {
		return this.cloudinaryUploadManager.upload(multipartFile);
	}

	@Override
	public File convert(MultipartFile multipartFile) throws IOException {
		return this.cloudinaryUploadManager.convert(multipartFile);
	}

}
