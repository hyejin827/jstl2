package conf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.iot.test.common.MybatisSessionFactory;
import com.iot.test.vo.Customer;

public class Exam2 {
	public static void main(String[] args) {
		SqlSessionFactory ssf = MybatisSessionFactory.getSqlSessionFactory();
		SqlSession ss = ssf.openSession(); //ssf.openSession(true)로 주면 오토커밋
		Customer c = new Customer();
		c.setCustomerName("김명재애애애");
		c.setCustomerID(1);
		System.out.println(ss.update("customer.updateCustomer", c));//값이 들어왔으면 1, 안들어왔으면 0
		ss.commit();
		Map<String,String> map = new HashMap<String,String>();
		map.put("str", "customerid desc");
		List<Customer> ctList = ss.selectList("customer.selectCustomer", map);
		for(Customer ct : ctList) {
			System.out.println(ct);
		}
	}
}
