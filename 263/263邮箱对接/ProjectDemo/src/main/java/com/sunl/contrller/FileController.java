package com.sunl.contrller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/v1/fileApi")
public class FileController {
	
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String hello(){
		return "hello";
	}
	
	/**
	 * 直接通过@RequestBody 的方式，直接将json的数据注入到了JSONObject里面了。
	 * */
	@ResponseBody
	@RequestMapping(value = "/json/data", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String getByJSON(@RequestBody JSONObject jsonParam) {
	    // 直接将json信息打印出来
	    System.out.println(jsonParam.toJSONString());

	    // 将获取的json数据封装一层，然后在给返回
	    JSONObject result = new JSONObject();
	    result.put("msg", "ok");
	    result.put("method", "json");
	    result.put("data", jsonParam);

	    return result.toJSONString();
	}
	
	/**
	 * 功能描述:通过request的方式来获取到json数据<br/>
	 * @param jsonobject 这个是阿里的 fastjson对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/request/data", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String getByRequest(HttpServletRequest request) {
	    //获取到JSONObject
	    JSONObject jsonParam = this.getJSONParam(request);

	    // 将获取的json数据封装一层，然后在给返回
	    JSONObject result = new JSONObject();
	    result.put("msg", "ok");
	    result.put("method", "request");
	    result.put("data", jsonParam);

	    return result.toJSONString();
	}
	
	/**
	 * 功能描述:通过request来获取到json数据<br/>
	 * @param request
	 * @return
	 */
	public JSONObject getJSONParam(HttpServletRequest request){
	    JSONObject jsonParam = null;
	    try {
	        // 获取输入流
	        BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

	        // 写入数据到Stringbuilder
	        StringBuilder sb = new StringBuilder();
	        String line = null;
	        while ((line = streamReader.readLine()) != null) {
	            sb.append(line);
	        }
	        jsonParam = JSONObject.parseObject(sb.toString());
	        // 直接将json信息打印出来
	        System.out.println(jsonParam.toJSONString());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return jsonParam;
	}
}
