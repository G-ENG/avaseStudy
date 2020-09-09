import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class 配置文件 {
	public static void main(String args[]) throws IOException {
		System.out.println(System.getProperty("java.home"));
		System.out.println(System.getProperty("user.dir"));
		String str=System.getProperty("user.dir");
		FileReader fr=new  FileReader(str+"/ss.properties");
		Properties prop=new Properties();
		prop.load(fr);
		System.out.println(prop.getProperty("driver"));
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("user"));
		System.out.println(prop.getProperty("pass"));
//		NodeInfo head = new NodeInfo(1, "aaa");
//		NodeInfo n2 = new NodeInfo(2, "bbb");
//		NodeInfo n3 = new NodeInfo(3, "ccc");
//		Set<NodeInfo> set = new HashSet<>();
//		set.add(head);
//		set.add(head);
//		System.out.println(set.size());
//		set.add(null);
//		System.out.println(set.size());
//		set.add(n2);
//		System.out.println(set.size());
	}
}