package com.dcorepay.controller;


import com.dcorepay.entities.Mch;
import com.dcorepay.services.ICibMchService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class SyncMchController {
    @Resource
    private ICibMchService cibMchService;


    @RequestMapping("/")
    @ResponseBody
    public ModelAndView helloWorld() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/mchChange")
    @ResponseBody
    public Map<String,String> mchChange(HttpServletRequest request) {
        Map<String,String> map = new HashMap<String, String>();
        try {
            String topbankId = request.getParameter("bankid");
            String sourceId = request.getParameter("source");
            String pid = request.getParameter("pid");
            List<Mch> mchList = cibMchService.selectListByTopBankId(Long.parseLong(topbankId));
            if(!StringUtils.isEmpty(mchList)&&mchList.size()>0){
                System.out.println("商户数："+mchList.size());
                int count=0;
                List<Map<String,String>> err = new ArrayList<Map<String, String>>();
                Map<String,String> errmap = new HashMap<String, String>();
                for(Mch m:mchList){
                    errmap = new HashMap<String, String>();
                    m.setSource(sourceId);
                    m.setAliPid(pid);
                    Map<String,String> wr = cibMchService.getCodeOrGenerate(m);
                    Map<String,String> ar = cibMchService.generateCodeAli(m);
                    if(!StringUtils.isEmpty(wr)&&"1".equals(wr.get("result"))){
                        m.setNewWxMchId(wr.get("code"));
                    }else{
                        errmap.put("mchid",m.getId());
                        errmap.put("wxmsg","微信识别码生成失败："+wr.get("errmsg"));
                    }
                    if(!StringUtils.isEmpty(ar)&&"1".equals(ar.get("result"))){
                        m.setNewAliMchId(ar.get("code"));
                    }else{
                        errmap.put("mchid",m.getId());
                        errmap.put("alimsg","支付宝识别码生成失败："+ar.get("errmsg"));
                    }
                    if(StringUtils.isEmpty(errmap.get("mchid"))){
                        int i = cibMchService.update(m);
                        count+=i;
                    }else{
                        err.add(errmap);
                    }
                }
                map.put("code","0");
                map.put("msg","生成新识别码商户数"+count);
                map.put("error",err.toArray().toString());
                return  map;
            }else{
                map.put("code","1");
                map.put("msg","没有查询到商户");
                return  map;
            }
        } catch (Exception e) {
            map.put("code","1");
            map.put("msg","出现异常"+e);
            return  map;
        }
    }
}
