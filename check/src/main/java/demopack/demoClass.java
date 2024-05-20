package demopack;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class demoClass {

	@Autowired
	private JdbcTemplate pobj;

	public JdbcTemplate getPobj() {
		return pobj;
	}

	public void setPobj(JdbcTemplate pobj) {
		this.pobj = pobj;
	}

	// redirection of client
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home_page() {
		return "redirect:c1";
	}

	// method to catch request to a url end point
	// usage of jdbc in controller
	@RequestMapping(value = "/c1", method = RequestMethod.GET)
	public String show_c1() {
		System.out.println(this.pobj);
		pobj.query("select * from HSNCodes6", new ResultSetExtractor<>() {

			@Override
			public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
				while (resultSet.next()) {
					int hsnc_id = resultSet.getInt("hsnc_id");
					String hsnc_hsncode = resultSet.getString("hsnc_hsncode");
					double hsnc_gstc_percentage = resultSet.getDouble("hsnc_gstc_percentage");

					System.out.println("hsnc_id: " + hsnc_id + ", hsnc_hsncode: " + hsnc_hsncode
							+ ", hsnc_gstc_percentage: " + hsnc_gstc_percentage);
				}
				return null;
			}

		});
		return "c1";
	}

	// method to catch request to a url end point
	@RequestMapping(value = "/c2", method = RequestMethod.GET)
	public String show_c2() {
		return "c2";
	}

	// server side redirection i.e. forward
	@RequestMapping(value = "/internal_forward", method = RequestMethod.GET)
	public String forward_internally() {
		return "forward:c2";
	}

	// client side redirection internally
	@RequestMapping(value = "/internal_redirect", method = RequestMethod.GET)
	public String redirect_internally() {
		return "redirect:c2";
	}

	// client side redirection to external url
	@RequestMapping(value = "/external_redirect", method = RequestMethod.GET)
	public String redirect_externally() {
		return "redirect:https://docs.spring.io/spring-framework/docs/6.0.0/reference/pdf/spring-framework.pdf";
	}

	// catching request parameters from user i.e payload
	@RequestMapping(value = "/catch_req_parameter", method = RequestMethod.POST)
	public String Single_parameter(@RequestParam String user_name) {
		System.out.println("Given user name is : " + user_name);
		return "c2";
	}

	// injection of dependency from user data i.e. payload
	@RequestMapping(value = "/catch_form_data", method = RequestMethod.POST)
	@Autowired
	public String catch_form_data(MyUser mu) {
		System.out.println(mu);
		System.out.println("User id is : " + mu.getUser_id());
		System.out.println("User password is : " + mu.getUser_pwd());
		System.out.println("Catched Form Data");
		return "c1";
	}

}