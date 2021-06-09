package kodlamaio.HRMS.CloudinaryUpload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryUploadManager {
	Cloudinary cloudinary;

	private Map<String, String> valuesMap = new HashMap<>();
	
	@Autowired
	public CloudinaryUploadManager() {
		super();
		valuesMap.put("cloud_name", "sdmrly");
		valuesMap.put("api_key", "488768624758548");
		valuesMap.put("api_secret", "nv-TPEa4N7KAJpdam_1tDl_Y55Q");
		cloudinary = new Cloudinary(valuesMap);
	}

	public Map upload(MultipartFile multipartFile) throws IOException {
		File file = convert(multipartFile);
		Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		file.delete();
		return result;
	}

	public File convert(MultipartFile multipartFile) throws IOException {
		File file = new File(multipartFile.getOriginalFilename());
		FileOutputStream fo = new FileOutputStream(file);
		fo.write(multipartFile.getBytes());
		fo.close();
		return file;

	}
}
