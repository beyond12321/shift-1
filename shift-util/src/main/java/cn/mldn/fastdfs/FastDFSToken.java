package cn.mldn.fastdfs;


import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.ProtoCommon;
import org.csource.fastdfs.TrackerClient; 
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;

public class FastDFSToken {
	public static void main(String[] args) throws Exception {
		ClassPathResource classPathResource = new ClassPathResource("fastdfs_client.properties");
		// 进行客户端访问的整体配置，需要知道配置文件的完整路径
		ClientGlobal.init(classPathResource.getClassLoader().getResource("fastdfs_client.properties").getPath());
		// 定义tracker客户端
		TrackerClient trackerClient = new TrackerClient();
		// 定义TrackerServer的配置信息
		TrackerServer trackerServer = trackerClient.getConnection();
		String fileId = "M00/00/00/wKgcKllAoLqAdpbXAAArVq8ZsB8371.png";
		int ts = (int) (System.currentTimeMillis() / 1000);// 时间参考
		StringBuffer fileUrl = new StringBuffer();
		fileUrl.append("http://");
		fileUrl.append(trackerServer.getInetSocketAddress().getHostString());
		fileUrl.append("/group2/").append(fileId);
		fileUrl.append("?token=").append(ProtoCommon.getToken(fileId, ts, ClientGlobal.g_secret_key));
		fileUrl.append("&ts=").append(ts);
		System.out.println(fileUrl);
		trackerServer.close(); 
	}
}
