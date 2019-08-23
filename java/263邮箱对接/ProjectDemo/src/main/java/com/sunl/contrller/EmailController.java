package com.sunl.contrller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import net.sf.json.xml.XMLSerializer;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.encoding.XMLType;
import java.rmi.RemoteException;
import java.util.*;


@RestController
@RequestMapping("/email")
public class EmailController {


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


    /*public static void main(String[] args) {
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
    @RequestMapping(value = "/getDomainUserlist", method = RequestMethod.POST)
    public String getDomainUserlist(@RequestParam Map<String,Object> mapValue){
        /*if(null == mapValue){
            return null;
        }*/
        String result = "call failed";
        String namespaceURI = "http://xmapi.webservices.ma.net263.com";
        String serviceName = "getDomainUserlist_New";
        try{
            Call call = commCreateService(namespaceURI,serviceName);
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


    //根据userid获取用户信息
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public String getUserInfo(@RequestParam Map<String,Object> mapValue){
        /*if(null == mapValue){
            return null;
        }*/
        String result = "call failed";
        String namespaceURI = "http://xmapi.webservices.ma.net263.com/";
        String serviceName = "getDomainUserlist_New";
        try{
            Call call = commCreateService(namespaceURI,serviceName);
            //设置参数名，第二个参数表示类型，第三个表示入参
            call.addParameter("userid", XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter("domain", XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter("account", XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter("sign", XMLType.XSD_STRING, ParameterMode.IN);
            //设置返回值类型
            call.setReturnType(XMLType.XSD_STRING);
            /*
            mapValue.get("userid")
            mapValue.get("domain");
            mapValue.get("account");
            mapValue.get("sign");*/
            //用户ID（不包含@和域名），不能为空，最大长度为20字节
            String userid = "";
            //域名(domain)
            String domain = "test.263.net";
            //接口账号
            String account = "test";
            //263邮箱规则sign = 32位MD5小写 （ domain + 接口账号 + 接口密钥 ）/* 等式中的“+”号表示字符串连接 * /
            String sign = "7f1c2885c29b76b85c55901970127dce";
            result = (String) call.invoke(new Object[]{userid,domain,account,sign});// 远程调用
        }catch(RemoteException e){
            e.printStackTrace();
        }
        System.out.println("result:"+result);
        return result;
    }


    //注册邮箱
    @RequestMapping(value = "/regUser", method = RequestMethod.POST)
    public String regUser(@RequestParam Map<String,Object> mapValue){
        //远程调用路径
        String endpoint = "http://macom.263.net/axis/xmapi?wsdl";
        String result = "call failed";
        // 创建一个服务(service)调用(call) 
        Service service = new Service();
        String namespaceURI = "http://xmapi.webservices.ma.net263.com";
        String serviceName = "regUser_New";
        try{
            Call call = commCreateService(namespaceURI,serviceName);
            //用户ID（不包含@和域名），最大长度20字节
            call.addParameter("userid", XMLType.XSD_STRING, ParameterMode.IN);
            //域名，最大长度40字节
            call.addParameter("domain", XMLType.XSD_STRING, ParameterMode.IN);
            //用户密码，可以是密码明文或者密码的32位MD5小写加密串，最大长度20字节
            call.addParameter("passwd", XMLType.XSD_STRING, ParameterMode.IN);
            //密码类型（0：密码的明文，4：密码的32位MD5小写加密串）
            call.addParameter("crypttype", XMLType.XSD_INT, ParameterMode.IN);
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
            String userid="0001";
            //域名，最大长度40字节
            String domain="test.263.net";
            //用户密码，可以是密码明文或者密码的32位MD5小写加密串，最大长度20字节
            String passwd="ttttt";
            //密码类型（0：密码的明文，4：密码的32位MD5小写加密串）
            int crypttype=0;
            //组ID（空间大小ID），不能为空、263G-5万封>33、263G-10万封>43
            int gid=33;
            //部门ID（未分配部门ID为-1，如选择相应部门请填写对应部门ID，不存在的部门会导致用户在管理界面不显示）
            int departmentid = 0;
            //姓名，需采用base64编码格式（GBK字符集）
            String username="fff";
            //职位，需采用base64编码格式（GBK字符集）
            String offic = "fff";
            //手机
            String mobile="17621255655";
            //电话
            String phone = "17621255655";
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
        }catch(RemoteException e){
            e.printStackTrace();
        }
        System.out.println("result:"+result);
        return result;
    }


    //注册邮箱--多部门
    @RequestMapping(value = "/regUserMulti", method = RequestMethod.POST)
    public String regUserMulti(@RequestParam Map<String,Object> mapValue){
        //远程调用路径
        String endpoint = "http://macom.263.net/axis/xmapi?wsdl";
        String result = "call failed";
        // 创建一个服务(service)调用(call) 
        Service service = new Service();
        String namespaceURI = "http://xmapi.webservices.ma.net263.com/";
        String serviceName = "regUser_New";
        try{
            Call call = commCreateService(namespaceURI,serviceName);
            //用户ID（不包含@和域名），最大长度20字节
            call.addParameter("userid", XMLType.XSD_STRING, ParameterMode.IN);
            //域名，最大长度40字节
            call.addParameter("domain", XMLType.XSD_STRING, ParameterMode.IN);
            //用户密码，可以是密码明文或者密码的32位MD5小写加密串，最大长度20字节
            call.addParameter("passwd", XMLType.XSD_STRING, ParameterMode.IN);
            //密码类型（0：密码的明文，4：密码的32位MD5小写加密串）
            call.addParameter("crypttype", XMLType.XSD_INT, ParameterMode.IN);
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
            String userid="0001";
            //域名，最大长度40字节
            String domain="test.263.net";
            //用户密码，可以是密码明文或者密码的32位MD5小写加密串，最大长度20字节
            String passwd="ttttt";
            //密码类型（0：密码的明文，4：密码的32位MD5小写加密串）
            int crypttype=0;
            //组ID（空间大小ID），不能为空、263G-5万封>33、263G-10万封>43
            int gid=33;
            //部门ID（未分配部门ID为-1，如选择相应部门请填写对应部门ID，不存在的部门会导致用户在管理界面不显示）
            int departmentid = 0;
            //姓名，需采用base64编码格式（GBK字符集）
            String username="fff";
            //职位，需采用base64编码格式（GBK字符集）
            String offic = "fff";
            //手机
            String mobile="17621255655";
            //电话
            String phone = "17621255655";
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
        }catch(RemoteException e){
            e.printStackTrace();
        }
        System.out.println("result:"+result);
        return result;
    }

    //修改用户信息。
    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    public String updateUserInfo(@RequestParam Map<String,Object> mapValue){
        //远程调用路径
        String endpoint = "http://macom.263.net/axis/xmapi?wsdl";
        String result = "call failed";
        // 创建一个服务(service)调用(call) 
        Service service = new Service();
        String namespaceURI = "http://xmapi.webservices.ma.net263.com";
        String serviceName = "modUserInfo_New";
        try{
            Call call = commCreateService(namespaceURI,serviceName);
            //用户ID（不包含@和域名），最大长度20字节
            call.addParameter("userid", XMLType.XSD_STRING, ParameterMode.IN);
            //域名，最大长度40字节
            call.addParameter("domain", XMLType.XSD_STRING, ParameterMode.IN);
            //部门ID（未分配部门ID为-1，如选择相应部门请填写对应部门ID，不存在的部门会导致用户在管理界面不显示）
            call.addParameter("departmentid", XMLType.XSD_INT, ParameterMode.IN);
            //姓名，需采用base64编码格式（GBK字符集）
            call.addParameter("username", XMLType.XSD_BASE64, ParameterMode.IN);
            //职位，需采用base64编码格式（GBK字符集）
            call.addParameter("office", XMLType.XSD_STRING, ParameterMode.IN);
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
            //接口账号
            call.addParameter("account", XMLType.XSD_STRING, ParameterMode.IN);
            //加密标识
            call.addParameter("sign", XMLType.XSD_STRING, ParameterMode.IN);
            //设置返回值类型
            call.setReturnType(XMLType.XSD_STRING);

            //用户ID（不包含@和域名），最大长度20字节
            String userid="0001";
            //域名，最大长度40字节
            String domain="test.263.net";
            //部门ID（未分配部门ID为-1，如选择相应部门请填写对应部门ID，不存在的部门会导致用户在管理界面不显示）
            int departmentid = 0;
            //姓名，需采用base64编码格式（GBK字符集）
            String username="fff";
            //职位，需采用base64编码格式（GBK字符集）
            String office = "fff";
            //手机
            String mobile="17621255655";
            //电话
            String phone = "17621255655";
            //传值
            String fax="";
            //邮箱别名1
            String alias="";
            //邮箱别名2
            String alias2="";
            // 接口账号
            String account = "test";
            //加密标识
            String sign ="7f1c2885c29b76b85c55901970127dce";

            result = (String) call.invoke(new Object[]{userid,
                    domain,
                    departmentid,
                    username,
                    office,
                    mobile,
                    phone,
                    fax,
                    alias,
                    alias2,
                    account,
                    sign});// 远程调用
        }catch(RemoteException e){
            e.printStackTrace();
        }
        System.out.println("result:"+result);
        return result;
    }


    //修改邮箱密码
    @RequestMapping(value = "/updateUserEmailPasswd", method = RequestMethod.POST)
    public String updateUserEmailPasswd(@RequestParam Map<String,Object> mapValue) {
        //远程调用路径
        String endpoint = "http://macom.263.net/axis/xmapi?wsdl";
        String result = "call failed";
        // 创建一个服务(service)调用(call) 
        Service service = new Service();
        String namespaceURI = "http://xmapi.webservices.ma.net263.com/";
        String serviceName = "modPasswd_New";
        try{
            Call call = commCreateService(namespaceURI,serviceName);
            call.addParameter("userid", XMLType.XSD_STRING, ParameterMode.IN);
            //域名，最大长度40字节
            call.addParameter("domain", XMLType.XSD_STRING, ParameterMode.IN);
            //用户密码，可以是密码明文或者密码的32位MD5小写加密串，最大长度20字节
            call.addParameter("passwd", XMLType.XSD_STRING, ParameterMode.IN);
            //密码类型（0：密码的明文，4：密码的32位MD5小写加密串）
            call.addParameter("crypttype", XMLType.XSD_INT, ParameterMode.IN);
            // 接口账号
            call.addParameter("account", XMLType.XSD_STRING, ParameterMode.IN);
            //加密标识
            call.addParameter("sign", XMLType.XSD_STRING, ParameterMode.IN);
            //设置返回值类型
            call.setReturnType(XMLType.XSD_STRING);

            //用户ID（不包含@和域名），最大长度20字节
            String userid="1";
            //域名，最大长度40字节
            String domain="test.263.net";
            //用户密码，可以是密码明文或者密码的32位MD5小写加密串，最大长度20字节
            String passwd="12435";
            //密码类型（0：密码的明文，4：密码的32位MD5小写加密串）//int类型 文档说明有误String类型会报错
            int crypttype=0;
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
        }catch(RemoteException e){
            e.printStackTrace();
        }
        System.out.println("result:"+result);
        return result;
    }


    //根据userid删除邮箱
    @RequestMapping(value = "/deleteUserEmail", method = RequestMethod.POST)
    public String deleteUserEmail(@RequestParam Map<String,Object> mapValue) {
        //远程调用路径
        String endpoint = "http://macom.263.net/axis/xmapi?wsdl";
        String result = "call failed";
        // 创建一个服务(service)调用(call) 
        Service service = new Service();
        String namespaceURI = "http://xmapi.webservices.ma.net263.com/";
        String serviceName = "delUser_New";
        try{
            Call call = this.commCreateService(namespaceURI,serviceName);
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
            String userid="1";
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
        }catch(RemoteException e){
            e.printStackTrace();
        }
        System.out.println("result:"+result);
        return result;
    }


    //获取部门信息
    @RequestMapping(value = "/getDepartment", method = RequestMethod.POST)
    public String getDepartment (@RequestParam Map<String,Object> mapValue) {
        //远程调用路径
        String endpoint = "http://macom.263.net/axis/xmapi?wsdl";
        String result = "call failed";
        // 创建一个服务(service)调用(call) 
        Service service = new Service();
        String namespaceURI = "http://xmapi.webservices.ma.net263.com/";
        String serviceName = "getDepartment";
        try{
            Call call = this.commCreateService(namespaceURI,serviceName);
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
            String userid="1";
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
        }catch(RemoteException e){
            e.printStackTrace();
        }
        System.out.println("result:"+result);
        return result;
    }

    //创建部门
    @RequestMapping(value = "/createDepartment", method = RequestMethod.POST)
    public String createDepartment(@RequestParam Map<String,Object> mapValue) {
        //远程调用路径
        String endpoint = "http://macom.263.net/axis/xmapi?wsdl";
        String result = "call failed";
        // 创建一个服务(service)调用(call) 
        Service service = new Service();
        String namespaceURI = "http://xmapi.webservices.ma.net263.com";
        String serviceName = "createDepartment";
        try{
            Call call = this.commCreateService(namespaceURI,serviceName);
            //用户ID（不包含@和域名），最大长度20字节
            call.addParameter("userid", XMLType.XSD_STRING, ParameterMode.IN);
            //域名，最大长度40字节
            call.addParameter("domain", XMLType.XSD_STRING, ParameterMode.IN);

            //部门名称，不能为空，最大长度64字节
            call.addParameter("departmentName", XMLType.XSD_STRING, ParameterMode.IN);

            //父部门ID，不能为空，最高一级部门的父部门ID设为0
            call.addParameter("depId", XMLType.XSD_INT, ParameterMode.IN);

            //description（部门描述）
            call.addParameter("description", XMLType.XSD_STRING, ParameterMode.IN);

            // 保留参数，当前版本不生效，部门列表名称，必须为英文，最大长度为20字节
            call.addParameter("listName", XMLType.XSD_STRING, ParameterMode.IN);

            // 保留参数，当前版本不生效，是否成员变化时同步更新邮件列表，1同步0不同步 默认0
            call.addParameter("listSync", XMLType.XSD_STRING, ParameterMode.IN);

            //保留参数，当前版本不生效，手机号码
            call.addParameter("mobile", XMLType.XSD_STRING, ParameterMode.IN);

            // 接口账号
            call.addParameter("account", XMLType.XSD_STRING, ParameterMode.IN);

            //加密标识
            call.addParameter("sign", XMLType.XSD_STRING, ParameterMode.IN);

            //设置返回值类型
            call.setReturnType(XMLType.XSD_STRING);

            //用户ID（不包含@和域名），最大长度20字节
            String userid="1";
            //域名，最大长度40字节
            String domain="test.263.net";
            //部门名称，不能为空，最大长度64字节
            String departmentName="研发部";
            //父部门ID，不能为空，最高一级部门的父部门ID设为0
            int depId=0;
            //description（部门描述）
            String description="";
            // 保留参数，当前版本不生效，部门列表名称，必须为英文，最大长度为20字节
            String listName="";
            // 保留参数，当前版本不生效，是否成员变化时同步更新邮件列表，1同步0不同步 默认0
            String listSync="";
            //保留参数，当前版本不生效，手机号码
            String mobile="";
            // 接口账号
            String account = "test";
            //加密标识
            String sign ="7f1c2885c29b76b85c55901970127dce";

            result = (String) call.invoke(new Object[]{
                    userid,
                    domain,
                    departmentName,
                    depId,
                    description,
                    listName,
                    listSync,
                    mobile,
                    account,
                    sign});// 远程调用
        }catch(RemoteException e){
            e.printStackTrace();
        }
        System.out.println("result:"+result);
        return result;
    }

    //删除部门信息
    @RequestMapping(value = "/deleteDepartment", method = RequestMethod.POST)
    public String deleteDepartment(@RequestParam Map<String,Object> mapValue) {
        //远程调用路径
        String endpoint = "http://macom.263.net/axis/xmapi?wsdl";
        String result = "call failed";
        // 创建一个服务(service)调用(call) 
        Service service = new Service();
        String namespaceURI = "http://xmapi.webservices.ma.net263.com/";
        String serviceName = "deleteDepartment";
        try{
            Call call = this.commCreateService(namespaceURI,serviceName);
            //域名，最大长度40字节
            call.addParameter("domain", XMLType.XSD_STRING, ParameterMode.IN);

            //部门ID，不能为空
            call.addParameter("departmentId", XMLType.XSD_STRING, ParameterMode.IN);

            // 接口账号
            call.addParameter("account", XMLType.XSD_STRING, ParameterMode.IN);

            //加密标识
            call.addParameter("sign", XMLType.XSD_STRING, ParameterMode.IN);

            //设置返回值类型
            call.setReturnType(XMLType.XSD_STRING);

            //域名，最大长度40字节
            String domain="test.263.net";

            //部门ID，不能为空
            String departmentId = "1";

            // 接口账号
            String account = "test";
            //加密标识
            String sign ="7f1c2885c29b76b85c55901970127dce";

            result = (String) call.invoke(new Object[]{
                    domain,
                    departmentId,
                    account,
                    sign});// 远程调用
        }catch(RemoteException e){
            e.printStackTrace();
        }
        System.out.println("result:"+result);
        return result;
    }


    //修改部门
    @RequestMapping(value = "/updateDepartment", method = RequestMethod.POST)
    public String updateDepartment(@RequestParam Map<String,Object> mapValue) {
        //远程调用路径
        String endpoint = "http://macom.263.net/axis/xmapi?wsdl";
        String result = "call failed";
        // 创建一个服务(service)调用(call) 
        Service service = new Service();
        String namespaceURI = "http://xmapi.webservices.ma.net263.com";
        String serviceName = "updateDepartment";
        try{
            Call call = this.commCreateService(namespaceURI,serviceName);
            //用户ID（不包含@和域名），最大长度20字节
            call.addParameter("userid", XMLType.XSD_STRING, ParameterMode.IN);
            //域名，最大长度40字节
            call.addParameter("domain", XMLType.XSD_STRING, ParameterMode.IN);
            //部门ID，不能为空
            call.addParameter("departmentId", XMLType.XSD_INT, ParameterMode.IN);

            //部门名称，不能为空，最大长度64字节
            call.addParameter("departmentName", XMLType.XSD_STRING, ParameterMode.IN);

            //父部门ID，不能为空，最高一级部门的父部门ID设为0
            call.addParameter("depId", XMLType.XSD_INT, ParameterMode.IN);

            //description（部门描述）
            call.addParameter("description", XMLType.XSD_STRING, ParameterMode.IN);

            // 保留参数，当前版本不生效，部门列表名称，必须为英文，最大长度为20字节
            call.addParameter("listName", XMLType.XSD_STRING, ParameterMode.IN);

            // 保留参数，当前版本不生效，是否成员变化时同步更新邮件列表，1同步0不同步 默认0
            call.addParameter("listSync", XMLType.XSD_STRING, ParameterMode.IN);

            //保留参数，当前版本不生效，手机号码
            call.addParameter("mobile", XMLType.XSD_STRING, ParameterMode.IN);

            // 接口账号
            call.addParameter("account", XMLType.XSD_STRING, ParameterMode.IN);

            //加密标识
            call.addParameter("sign", XMLType.XSD_STRING, ParameterMode.IN);

            //设置返回值类型
            call.setReturnType(XMLType.XSD_STRING);

            //用户ID（不包含@和域名），最大长度20字节
            String userid="1";
            //域名，最大长度40字节
            String domain="test.263.net";
            //部门ID，不能为空
            int departmentId=1;
            //部门名称，不能为空，最大长度64字节
            String departmentName="大数据部门";
            //父部门ID，不能为空，最高一级部门的父部门ID设为0
            int depId=1;
            //description（部门描述）
            String description="";
            // 保留参数，当前版本不生效，部门列表名称，必须为英文，最大长度为20字节
            String listName="";
            // 保留参数，当前版本不生效，是否成员变化时同步更新邮件列表，1同步0不同步 默认0
            String listSync="";
            //保留参数，当前版本不生效，手机号码
            String mobile="";
            // 接口账号
            String account = "test";
            //加密标识
            String sign ="7f1c2885c29b76b85c55901970127dce";

            result = (String) call.invoke(new Object[]{
                    userid,
                    domain,
                    departmentId,
                    departmentName,
                    depId,
                    description,
                    listName,
                    listSync,
                    mobile,
                    account,
                    sign});// 远程调用
        }catch(RemoteException e){
            e.printStackTrace();
        }
        System.out.println("result:"+result);
        return result;
    }


    //公共创建服务方法
    public  Call commCreateService(String namespaceURI,String serviceName) {
        //远程调用路径
        String endpoint = "http://macom.263.net/axis/xmapi?wsdl";
        String result = "call failed";
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


    //将字符串xml 转换成json 再组装成map
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

}
