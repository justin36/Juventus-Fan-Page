package global.sesoc.test6.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

/**
 * ���� ���� ��ƿ
 * ���ε��� ������ ���� & ������ ����� ���� ���� ���� ��� ����
 */
public class FileService {

	/**
	 * ���ε� �� ������ ������ ��ο� �����ϰ�, ����� ���ϸ��� ����
	 * @param mfile ���ε�� ����
	 * @param path ������ ���
	 * @return ����� ���ϸ�
	 */
	public static String saveFile(MultipartFile mfile, String uploadPath) {
		//���ε�� ������ ���ų� ũ�Ⱑ 0�̸� �������� �ʰ� null�� ����
		if (mfile == null || mfile.isEmpty() || mfile.getSize() == 0) {
			return null;
		}
		
		//���� ������ ������ ����
		File path = new File(uploadPath);
		if (!path.isDirectory()) {
			path.mkdirs();
		}
		
		//���� ���ϸ�
		String originalFilename = mfile.getOriginalFilename();
		
		//������ ���ϸ��� ���� ��¥�� ����Ϸ� ����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String savedFilename = sdf.format(new Date());
		
		//���� ������ Ȯ����
		String ext;
		int lastIndex = originalFilename.lastIndexOf('.');
		//Ȯ���ڰ� ���� ���
		if (lastIndex == -1) {
			ext = "";
		}
		//Ȯ���ڰ� �ִ� ���
		else {
			ext = "." + originalFilename.substring(lastIndex + 1);
		}

		//������ ��ü ��θ� ������ File ��ü
		File serverFile = null;
		
		//���� �̸��� ������ �ִ� ����� ó��
		while (true) {
			serverFile = new File(uploadPath + "/" + savedFilename + ext);
			//���� �̸��� ������ ������ ����.
			if ( !serverFile.isFile()) break;	
			//���� �̸��� ������ ������ �̸� �ڿ� long Ÿ���� �ð������� ������.
			savedFilename = savedFilename + new Date().getTime();	
		}		
		
		//���� ����
		try {
			mfile.transferTo(serverFile);
		} catch (Exception e) {
			savedFilename = null;
			e.printStackTrace();
		}
		
		return savedFilename + ext;
	}
	
	/**
	 * ������ ����� ������ ��ü ��θ� ���޹޾�, �ش� ������ ����
	 * @param fullpath ������ ������ ���
	 * @return ���� ����
	 */
	public static boolean deleteFile(String fullpath) {
		//���� ���� ���θ� ������ ����
		boolean result = false;
		
		//���޵� ��ü ��η� File��ü ����
		File delFile = new File(fullpath);
		
		//�ش� ������ �����ϸ� ����
		if (delFile.isFile()) {
			delFile.delete();
			result = true;
		}
		
		return result;
	}
}
