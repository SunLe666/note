import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import net.sf.json.xml.XMLSerializer; 
import java.util.*;

public class XMLJson {

	//将字符串xml 转换成json 再组装成map,最后再遍历map
	public static String xmlToJson(String xml) {
		XMLSerializer xmlSerializer = new XMLSerializer();
		//解析成json数组
		String resutStr = xmlSerializer.read(xml).toString();
		System.out.print(resutStr);
		StringBuffer sb=new StringBuffer();
		Map<String,Object> jsonMap = new HashMap<>();
		List<Map<String,Object>> jsonMapList = new ArrayList<>();
		//需要使用的JSON的parseArray方法，将jsonArray解析为object类型的数组
		JSONArray objects = JSON.parseArray(resutStr);
		for(int i=0;i<objects.size();i++){
			//通过数组下标取到object，使用强转转为JSONObject，之后进行操作
			JSONObject object = (JSONObject) objects.get(i);
			jsonMap.put("userid",object.getString("userid"));
			jsonMap.put("name",object.getString("name"));
			jsonMap.put("departmentid",object.getString("departmentid"));
			jsonMap.put("office",object.getString("office"));
			jsonMap.put("mobile",object.getString("mobile"));
			jsonMap.put("phone",object.getString("phone"));
			jsonMap.put("fax",object.getString("fax"));
			jsonMapList.add(jsonMap);
		}
		for (int i =0; i<jsonMapList.size(); i++) {
			for (Map.Entry<String, Object> entry : jsonMapList.get(i).entrySet()) {
				String mapKey = entry.getKey();
				Object mapValue = entry.getValue();
				System.out.println(mapKey+":"+mapValue.toString());
			}
		}
	  //  System.out.println(jsonMap);
		return resutStr;
	}

	public static void main(String agrs[]){
		String xmlStr = "<?xml version=\"1.0\" encoding=\"GB2312\" ?>\n" +
				"\n" +
				"<userlist>\n" +
				"\n" +
				"       <user>\n" +
				"\n" +
				"              <userid>test@test.com</userid>\n" +
				"\n" +
				"              <name>test123</name>\n" +
				"\n" +
				"              <departmentid>1</departmentid>\n" +
				"\n" +
				"              <office>CEO</office>\n" +
				"\n" +
				"              <mobile>13800138000</mobile>\n" +
				"\n" +
				"              <phone>01084291263</phone>\n" +
				"\n" +
				"              <fax>01084291263001</fax>\n" +
				"\n" +
				"       </user>\n" +
				"\n" +
				" \n" +
				"\n" +
				"       <user>\n" +
				"\n" +
				"              <userid>test2@test.com</userid>\n" +
				"\n" +
				"              <name>test333</name>\n" +
				"\n" +
				"              <departmentid>2</departmentid>\n" +
				"\n" +
				"              <office>CEO</office>\n" +
				"\n" +
				"              <mobile>138001380444</mobile>\n" +
				"\n" +
				"              <phone>0108429145</phone>\n" +
				"\n" +
				"              <fax>01084291263001</fax>\n" +
				"\n" +
				"       </user>\n" +
				"\n" +
				"</userlist>\n";
		System.out.print(xmlToJson(xmlStr));
	}
	
	//jar包依赖
	/**<dependency>
		<groupId>javax.xml</groupId>
		<artifactId>jaxrpc-api</artifactId>
		<version>1.1</version>
	</dependency>
	<dependency>
		<groupId>net.sf.json-lib</groupId>
		<artifactId>json-lib</artifactId>
		<version>2.2.2</version>
		<classifier>jdk15</classifier>
	</dependency>
	<dependency>
		<groupId>xom</groupId>
		<artifactId>xom</artifactId>
		<version>1.2.5</version>
	</dependency>
	<dependency>
		<groupId>com.alibaba</groupId>
		<artifactId>fastjson</artifactId>
		<version>1.2.59</version>
	</dependency>*/
	

}





