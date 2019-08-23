package com.sunl.contrller;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.encoding.XMLType;
import java.rmi.RemoteException;
import java.util.Map;
import java.util.Random;

public class TestController {


    /*public void doSelectRiskReportForm(HttpServletRequest request,
                                       HttpServletResponse response){
        //调用接口
        //方法一:直接AXIS调用远程的web service
        try {
            String endpoint = "http://macom.263.net/axis/xmapi?wsdl";
            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(endpoint);
            String parametersName = "settle_num"; 		// 参数名//对应的是 public String printWord(@WebParam(name = "settle_num") String settle_num);
//	            call.setOperationName("printWord");  		// 调用的方法名//当这种调用不到的时候,可以使用下面的,加入命名空间名
            call.setOperationName(new QName("http://xmapi.webservices.ma.net263.com/", "printWord"));// 调用的方法名
            call.addParameter(parametersName, XMLType.XSD_STRING, ParameterMode.IN);//参数名//XSD_STRING:String类型//.IN入参
            call.setReturnType(XMLType.XSD_STRING); 	// 返回值类型：String
            String message = "123456789";
            String result = (String) call.invoke(new Object[] { message });// 远程调用
            System.out.println("result is " + result);
        } catch (Exception e) {
            System.err.println(e.toString());
        }


    }*/


   /* public static void main(String[] args) {
        String result = "call failed";
        String namespaceURI = "http://xmapi.webservices.ma.net263.com";
        String serviceName = "getDomainUserlist_New";
        Call call = commCreateService(namespaceURI,serviceName);
        try{
            //设置参数名，第二个参数表示类型，第三个表示入参
            call.addParameter("domain", XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter("account", XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter("sign", XMLType.XSD_STRING, ParameterMode.IN);
            //设置返回值类型
            call.setReturnType(XMLType.XSD_STRING);
            //域名(domain)
            String domain = "test.263.net";
            //接口账号
            String account = "test";
            //263邮箱规则sign = 32位MD5小写 （ domain + 接口账号 + 接口密钥 ）/* 等式中的“+”号表示字符串连接 * /
            String sign = "7f1c2885c29b76b85c55901970127dce";
            result = (String) call.invoke(new Object[]{domain,account,sign});// 远程调用
        }catch(RemoteException e){
            e.printStackTrace();
        }
        System.out.println("result:"+result);
        System.exit(0);
    }*/

    //获取用户信息列表
    public String getDomainUserlist(@RequestParam Map<String,Object> mapValue){
        /*if(null == mapValue){
            return null;
        }*/
        String result = "call failed";
        String namespaceURI = "http://xmapi.webservices.ma.net263.com";
        String serviceName = "getDomainUserlist_New";
        Call call = commCreateService(namespaceURI,serviceName);
        try{
            //设置参数名，第二个参数表示类型，第三个表示入参
            call.addParameter("domain", XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter("account", XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter("sign", XMLType.XSD_STRING, ParameterMode.IN);
            //设置返回值类型
            call.setReturnType(XMLType.XSD_STRING);
            /*mapValue.get("domain");
            mapValue.get("account");
            mapValue.get("sign");*/
            //域名(domain)
            String domain = "test.263.net";
            //接口账号
            String account = "test";
            //263邮箱规则sign = 32位MD5小写 （ domain + 接口账号 + 接口密钥 ）/* 等式中的“+”号表示字符串连接 * /
            String sign = "7f1c2885c29b76b85c55901970127dce";
            result = (String) call.invoke(new Object[]{domain,account,sign});// 远程调用
        }catch(RemoteException e){
            e.printStackTrace();
        }
        System.out.println("result:"+result);
        return result;
    }

    //创建邮箱
    public String createUserEmail(){
        //远程调用路径
        String endpoint = "http://macom.263.net/axis/xmapi?wsdl";
        String result = "call failed";
        // 创建一个服务(service)调用(call) 
        Service service = new Service();
        Call call;
        try{
            // 通过service创建call对象   
            call = (Call) service.createCall();
            // 设置service所在URL 
            call.setTargetEndpointAddress(endpoint);
            //调用的接口地址，调用的方法名
            call.setOperationName(new QName("http://xmapi.webservices.ma.net263.com", "regUser_New"));
            //设置参数名，第二个参数表示类型，第三个表示入参
            //用户ID（不包含@和域名），最大长度20字节
            call.addParameter("userid", XMLType.XSD_STRING, ParameterMode.IN);
            //域名，最大长度40字节
            call.addParameter("domain", XMLType.XSD_STRING, ParameterMode.IN);
            //用户密码，可以是密码明文或者密码的32位MD5小写加密串，最大长度20字节
            call.addParameter("passwd", XMLType.XSD_STRING, ParameterMode.IN);
            //密码类型（0：密码的明文，4：密码的32位MD5小写加密串）
            call.addParameter("crypttype", XMLType.XSD_STRING, ParameterMode.IN);
            //组ID（空间大小ID），不能为空
            call.addParameter("gid", XMLType.XSD_INT, ParameterMode.IN);
           //部门ID（未分配部门ID为-1，如选择相应部门请填写对应部门ID，不存在的部门会导致用户在管理界面不显示）
            call.addParameter("departmentid", XMLType.XSD_INT, ParameterMode.IN);
            //姓名，需采用base64编码格式（GBK字符集）
            call.addParameter("username", XMLType.XSD_STRING, ParameterMode.IN);
            //职位，需采用base64编码格式（GBK字符集）
            call.addParameter("offic", XMLType.XSD_STRING, ParameterMode.IN);
            //手机
            call.addParameter("mobile", XMLType.XSD_STRING, ParameterMode.IN);
            //电话
            call.addParameter("phone", XMLType.XSD_STRING, ParameterMode.IN);
            //传值
            call.addParameter("fax", XMLType.XSD_STRING, ParameterMode.IN);
            //邮箱别名1
            call.addParameter("alias", XMLType.XSD_STRING, ParameterMode.IN);
            //邮箱别名2
            call.addParameter("alias2", XMLType.XSD_STRING, ParameterMode.IN);
            //角色ID，不能为空，默认角色ID 为 0
            call.addParameter("roleId", XMLType.XSD_INT, ParameterMode.IN);
            //首次登录是否需要修改密码，不能为空，0为不需修改，1为需要修改
            call.addParameter("changepwd", XMLType.XSD_INT, ParameterMode.IN);
           // 接口账号
            call.addParameter("account", XMLType.XSD_STRING, ParameterMode.IN);
            //加密标识
            call.addParameter("sign", XMLType.XSD_STRING, ParameterMode.IN);
            //设置返回值类型
            call.setReturnType(XMLType.XSD_STRING);


            //用户ID（不包含@和域名），最大长度20字节
            String userid="";
            //域名，最大长度40字节
            String domain="test.263.net";
            //用户密码，可以是密码明文或者密码的32位MD5小写加密串，最大长度20字节
            String passwd="";
            //密码类型（0：密码的明文，4：密码的32位MD5小写加密串）
            String crypttype="";
            //组ID（空间大小ID），不能为空、263G-5万封>33、263G-10万封>43
            int gid=33;
            //部门ID（未分配部门ID为-1，如选择相应部门请填写对应部门ID，不存在的部门会导致用户在管理界面不显示）
            int departmentid = 0;
            //姓名，需采用base64编码格式（GBK字符集）
            String username="";
            //职位，需采用base64编码格式（GBK字符集）
            String offic = "";
            //手机
            String mobile="";
            //电话
            String phone = "";
            //传值
            String fax="";
            //邮箱别名1
            String alias="";
            //邮箱别名2
            String alias2="";
            //角色ID，不能为空，默认角色ID 为 0
            int roleId = 0;
            //首次登录是否需要修改密码，不能为空，0为不需修改，1为需要修改
            int changepwd = 1;
            // 接口账号
            String account = "test";
            //加密标识
            String sign ="7f1c2885c29b76b85c55901970127dce";

            result = (String) call.invoke(new Object[]{userid,
                    domain,
                    passwd,
                    crypttype,
                    gid,
                    departmentid,
                    username,
                    offic,
                    mobile,
                    phone,
                    fax,
                    alias,
                    alias2,
                    roleId,
                    changepwd,
                    account,
                    sign});// 远程调用
        }catch(ServiceException e){
            e.printStackTrace();
        }catch(RemoteException e){
            e.printStackTrace();
        }
        System.out.println("result:"+result);
        return result;
    }


    //修改邮箱密码,密码格式为随机字符串。
    public String updateUserEmailPasswd() {
        //远程调用路径
        String endpoint = "http://macom.263.net/axis/xmapi?wsdl";
        String result = "call failed";
        // 创建一个服务(service)调用(call) 
        Service service = new Service();
        Call call;
        try{
            // 通过service创建call对象   
            call = (Call) service.createCall();
            // 设置service所在URL 
            call.setTargetEndpointAddress(endpoint);
            //调用的接口地址，调用的方法名
            call.setOperationName(new QName("http://xmapi.webservices.ma.net263.com", "modPasswd_New"));
            //设置参数名，第二个参数表示类型，第三个表示入参
            //用户ID（不包含@和域名），最大长度20字节
            call.addParameter("userid", XMLType.XSD_STRING, ParameterMode.IN);
            //域名，最大长度40字节
            call.addParameter("domain", XMLType.XSD_STRING, ParameterMode.IN);
            //用户密码，可以是密码明文或者密码的32位MD5小写加密串，最大长度20字节
            call.addParameter("passwd", XMLType.XSD_STRING, ParameterMode.IN);
            //密码类型（0：密码的明文，4：密码的32位MD5小写加密串）
            call.addParameter("crypttype", XMLType.XSD_STRING, ParameterMode.IN);
            // 接口账号
            call.addParameter("account", XMLType.XSD_STRING, ParameterMode.IN);
            //加密标识
            call.addParameter("sign", XMLType.XSD_STRING, ParameterMode.IN);
            //设置返回值类型
            call.setReturnType(XMLType.XSD_STRING);

            //用户ID（不包含@和域名），最大长度20字节
            String userid="";
            //域名，最大长度40字节
            String domain="test.263.net";
            //用户密码，可以是密码明文或者密码的32位MD5小写加密串，最大长度20字节
            String passwd=this.generatePassword(8);
            //密码类型（0：密码的明文，4：密码的32位MD5小写加密串）
            String crypttype="0";
            // 接口账号
            String account = "test";
            //加密标识
            String sign ="7f1c2885c29b76b85c55901970127dce";

            result = (String) call.invoke(new Object[]{
                    userid,
                    domain,
                    passwd,
                    crypttype,
                    account,
                    sign});// 远程调用
        }catch(ServiceException e){
            e.printStackTrace();
        }catch(RemoteException e){
            e.printStackTrace();
        }
        System.out.println("result:"+result);
        return result;
    }

    //删除邮箱
    public String deleteUserEmail() {
        //远程调用路径
        String endpoint = "http://macom.263.net/axis/xmapi?wsdl";
        String result = "call failed";
        // 创建一个服务(service)调用(call) 
        Service service = new Service();
        Call call;
        try{
            // 通过service创建call对象   
            call = (Call) service.createCall();
            // 设置service所在URL 
            call.setTargetEndpointAddress(endpoint);
            //调用的接口地址，调用的方法名
            call.setOperationName(new QName("http://xmapi.webservices.ma.net263.com", "delUser_New"));
            //设置参数名，第二个参数表示类型，第三个表示入参
            //用户ID（不包含@和域名），最大长度20字节
            call.addParameter("userid", XMLType.XSD_STRING, ParameterMode.IN);
            //域名，最大长度40字节
            call.addParameter("domain", XMLType.XSD_STRING, ParameterMode.IN);
            // 接口账号
            call.addParameter("account", XMLType.XSD_STRING, ParameterMode.IN);
            //加密标识
            call.addParameter("sign", XMLType.XSD_STRING, ParameterMode.IN);
            //设置返回值类型
            call.setReturnType(XMLType.XSD_STRING);

            //用户ID（不包含@和域名），最大长度20字节
            String userid="";
            //域名，最大长度40字节
            String domain="test.263.net";
            // 接口账号
            String account = "test";
            //加密标识
            String sign ="7f1c2885c29b76b85c55901970127dce";

            result = (String) call.invoke(new Object[]{
                    userid,
                    domain,
                    account,
                    sign});// 远程调用
        }catch(ServiceException e){
            e.printStackTrace();
        }catch(RemoteException e){
            e.printStackTrace();
        }
        System.out.println("result:"+result);
        return result;
    }

    public static Call commCreateService(String namespaceURI,String serviceName) {
        //远程调用路径
        String endpoint = "http://macom.263.net/axis/xmapi?wsdl";
        String result = "call failed";
        // 创建一个服务(service)调用(call) 
        // 创建一个服务(service)调用(call) 
        Service service = new Service();
        Call call = null;
        try {
            // 通过service创建call对象   
            call = (Call) service.createCall();
            // 设置service所在URL 
            call.setTargetEndpointAddress(endpoint);
            //调用的接口地址，调用的方法名
            call.setOperationName(new QName(namespaceURI, serviceName));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return call;

    }


    public static String generatePassword (int length) {
        // 最终生成的密码
        String password = "";
        Random random = new Random();
        for (int i = 0; i < length; i ++) {
            // 随机生成0或1，用来确定是当前使用数字还是字母 (0则输出数字，1则输出字母)
            int charOrNum = random.nextInt(2);
            if (charOrNum == 1) {
                // 随机生成0或1，用来判断是大写字母还是小写字母 (0则输出小写字母，1则输出大写字母)
                int temp = random.nextInt(2) == 1 ? 65 : 97;
                password += (char) (random.nextInt(26) + temp);
            } else {
                // 生成随机数字
                password += random.nextInt(10);
            }
        }
        return password;
    }


}
