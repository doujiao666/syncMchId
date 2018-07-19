package com.dcorepay.common;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class XmlUtils {

	public static String parseXML(SortedMap<String, String> parameters) {
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		Set es = parameters.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if (null != v && !"".equals(v) && !"appkey".equals(k)) {
				sb.append("<" + k + ">" + parameters.get(k) + "</" + k + ">\n");
			}
		}
		sb.append("</xml>");
		return sb.toString();
	}

	/**
	 * 转XMLmap
	 * 
	 * @author
	 * @param xmlBytes
	 * @param charset
	 * @return
	 * @throws Exception
	 */
	public static Map<String, String> toMap(byte[] xmlBytes, String charset)
			throws Exception {
		SAXReader reader = new SAXReader(false);
		InputSource source = new InputSource(new ByteArrayInputStream(xmlBytes));
		source.setEncoding(charset);
		Document doc = reader.read(source);
		Map<String, String> params = XmlUtils.toMap(doc.getRootElement());
		return params;
	}

	/**
	 * 转MAP
	 * 
	 * @author
	 * @param element
	 * @return
	 */
	public static Map<String, String> toMap(Element element) {
		Map<String, String> rest = new HashMap<String, String>();
		List<Element> els = element.elements();
		for (Element el : els) {
			rest.put(el.getName().toLowerCase(), el.getTextTrim());
		}
		return rest;
	}

	/**
	 * 转MAP
	 * 
	 * @param xmlStr
	 * @return
	 */
	public static Map<String, String> toMap(String xmlStr) {
		try {
			Document doc = DocumentHelper.parseText(xmlStr);
			if (doc != null) {
				return XmlUtils.toMap(doc.getRootElement());
			}
			return null;
		} catch (DocumentException e) {
			// e.printStackTrace();
			return null;
		}
	}

	public static String toXml(Map<String, String> params) {
		StringBuilder buf = new StringBuilder();
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		buf.append("<xml>");
		for (String key : keys) {
			buf.append("<").append(key).append(">");
			buf.append("<![CDATA[").append(params.get(key)).append("]]>");
			buf.append("</").append(key).append(">\n");
		}
		buf.append("</xml>");
		return buf.toString();
	}

	public static Map<String, Object> toMap2(String xmlStr)
			throws DocumentException {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Document doc = DocumentHelper.parseText(xmlStr);
			if (doc != null) {
				ele2map(map, doc.getRootElement());
			}
		} catch (DocumentException e) {
			return null;
		}
		return map;
	}

	/***
	 * 核心方法，里面有递归调用
	 * 
	 * @param map
	 * @param ele
	 */
	private static void ele2map(Map map, Element ele) {
		System.out.println(ele);
		// 获得当前节点的子节点
		List<Element> elements = ele.elements();
		for (int i = 0; i < elements.size(); i++) {
			Element e = elements.get(i);
			if (e.elements().size() == 0) {
				map.put(e.getName().toLowerCase(), e.getTextTrim());
			} else if (e.elements().size() == 1) {// 只有一个子节点说明不用考虑list的情况，直接继续递归即可
				Map<String, Object> tempMap = new HashMap<String, Object>();
				ele2map(tempMap, e);
				map.put(ele.getName(), tempMap);
				// map.put(e.getName().toLowerCase(), null);
			} else {
				
			}

		}
		int total=Integer.valueOf(map.get("total")==null?"0":map.get("total").toString());
		if(total<=0)
		{
			return;
		}
		else
		{
			Namespace namespace = elements.get(0).getNamespace();
			List<Element> elements2 = ele.elements(new QName("mchinfo",
					namespace));
			// 如果同名的数目大于1则表示要构建list
			if (elements2.size() > 1) {
				List<Map> list = new ArrayList<Map>();
				for (Element element : elements2) {
					Map<String, Object> tempMap1 = new HashMap<String, Object>();
					ele2map(tempMap1, element);
					list.add(tempMap1);
				}
				map.put("mchinfo", list);
			} else {
				// 同名的数量不大于1则直接递归去
				Map<String, Object> tempMap1 = new HashMap<String, Object>();
				ele2map(tempMap1, elements2.get(0));
				map.put("mchinfo", tempMap1);
			}
		}
				 
		//

	}
}