package conf;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapExam {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		//상속받았을때, 구현받았을때 map을 쓸수있쪄
		map.put("key1", "value1");
		Iterator<String> it = map.keySet().iterator();
		System.out.println(it.hasNext()); //true
		System.out.println(it.hasNext()); //true
		System.out.println(it.hasNext()); //true
		System.out.println(it.next()); //key1
		System.out.println(it.hasNext()); //false
	}
}
