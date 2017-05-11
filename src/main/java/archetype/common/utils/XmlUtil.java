package archetype.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;


public class XmlUtil {
	
	/*
	 * XML 转 list返回
	 */

	
	
	/*
	 * 返回节点list 
	 */
	private static void getChildNodes(Element elem, List array) {
		array.add(elem.getName());
		Iterator<Node> it = elem.nodeIterator();
		while (it.hasNext()) {
			Node node = it.next();
			if (node instanceof Element) {
				Element e1 = (Element) node;
				getChildNodes(e1, array);
			}

		}
	}
	
}
