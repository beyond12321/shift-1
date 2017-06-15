package cn.mldn.fastdfs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID; 

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

public class FastDFSUploadFile {
	/**
	 * 把用户上传的文件保存在服务器中
	 * @param request 请求封装后的对象
	 * @param file 用户上传的文件
	 * @return results[0]: the group name to store the file 
				results[1]: the new created filename
	 * @throws FileNotFoundException 文件未找到则抛出此异常
	 * @throws IOException IO错误
	 * @throws MyException 。。。
	 */
	public static String[] fileUpload(HttpServletRequest request, MultipartFile file)
			throws FileNotFoundException, IOException, MyException {
		// 将用户上传的文件先临时保存在一个地方，之后进行删除
		File imgFile = new File(
				request.getServletContext().getRealPath("/WEB-INF/images/temp/" + createFileName(file)));
		FileUtils.copyInputStreamToFile(file.getInputStream(), imgFile);
		// 得到文件的扩展名称
		String extName = imgFile.getName().substring(imgFile.getName().lastIndexOf(".") + 1);
		// 取得要使用的配置文件
		ClassPathResource classPathResource = new ClassPathResource("fastdfs_client.properties");
		// 进行客户端访问的整体配置，需要知道配置文件的完整路径
		ClientGlobal.init(classPathResource.getClassLoader().getResource("fastdfs_client.properties").getPath());
		// 定义tracker客户端
		TrackerClient trackerClient = new TrackerClient();
		// 定义TrackerServer的配置信息
		TrackerServer trackerServer = trackerClient.getConnection();
		// 在整个FastDFS之中真正负责干活的就是Storage
		StorageServer storageServer = null;
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		// 定义上传文件的元数据
		NameValuePair[] metaList = new NameValuePair[3];
		metaList[0] = new NameValuePair("fileName", imgFile.getName());
		metaList[1] = new NameValuePair("fileExtName", extName);
		metaList[2] = new NameValuePair("fileLength", String.valueOf(imgFile.length()));
		// 如果要上传则使用trackerClient对象完成
		String[] upload_file = storageClient.upload_file(imgFile.getPath(), extName, metaList);
		// storageClient.delete_file("group1",
		// "M00/00/00/wKhtqFk7xE6ACpYGAABAnTpordQ064.png");
		trackerServer.close();
		imgFile.delete();
		return upload_file; 
	}

	public static String createFileName(MultipartFile file) {
		return UUID.randomUUID() + "." + file.getContentType().substring(file.getContentType().lastIndexOf("/") + 1);
	}
}
