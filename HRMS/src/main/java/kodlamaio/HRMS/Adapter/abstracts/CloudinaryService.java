package kodlamaio.HRMS.Adapter.abstracts;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {
	public Map ImageoUpload(MultipartFile multipartFile) throws IOException;
	
	public File convert(MultipartFile multipartFile) throws IOException;
}
