package com.para.portal.web.controller.api;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import java.rmi.RemoteException;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.encoding.XMLType;
import javax.xml.namespace.QName;
import java.rmi.RemoteException;


@WebService
public class WebServiceApi {


    /** 供客户端调用方法  该方法是非静态的，会被发布
     * @param name  传入参数
     * @return String 返回结果
     * */
    public String getValue(@WebParam(name = "name",targetNamespace="http://api.controller.web.portal.para.com/")String name){
        System.out.print("name:"+name);
        return "你好"+name;
    }


    /**
     * 方法上加@WebMentod(exclude=true)后，此方法不被发布；
     * @param name
     * @return
     */
    @WebMethod(exclude = true)
    public String getHello(String name){
        return "你好"+name;
    }

    /** 静态方法不会被发布
     * @param name
     * @return
     */
    public static String getString(String name){
        return "再见！"+name;
    }


    //通过EndPoint(端点服务)发布一个WebService
    public static void publishService(){
        //发布成功后 在浏览器输入 http://127.0.0.1:8088/Service/ServiceHello?wsdl
        /*参数:1,本地的服务地址;
              2,提供服务的类;*/
        Endpoint.publish("http://127.0.0.1:8088/Service/ServiceHello", new WebServiceApi());
        System.out.println("发布成功!");
    }


    public static void main(String[] args) {
        //远程调用路径
        String endpoint = "http://127.0.0.1:8088/Service/ServiceHello?wsdl";
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
            call.setOperationName(new QName("http://api.controller.web.portal.para.com/", "getValue"));
            //设置参数名，第二个参数表示类型，第三个表示入参
            call.addParameter("name", XMLType.XSD_STRING, ParameterMode.IN);
            //call.addParameter(new QName("http://api.controller.web.portal.para.com","arg0"), XMLType.XSD_STRING, ParameterMode.IN);
            call.setReturnType(XMLType.XSD_STRING);
            String name = "sunle";
            result = (String) call.invoke(new Object[]{name});// 远程调用
        }catch(ServiceException e){
            e.printStackTrace();
        }catch(RemoteException e){
            e.printStackTrace();
        }
        System.out.println("result:"+result);
        System.exit(0);
    }





}
