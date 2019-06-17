package sap.crun.performance.api.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import sap.crun.performance.api.model.SnglRecOutRowMapper;
//@Repository
//public interface SnglRecOutRepository extends JpaRepository<SnglRecOut, Long> {
//	
//
//}

@Repository
public class SnglRecOutRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	//get all the SNGLRECOUT
	public List<SnglRecOut> findAll() {

		String sql = "SELECT * FROM SAP_CRUN_PERFORMANCE_SNGLRECOUT";
		List<SnglRecOut> snglRecOuts = this.jdbcTemplate.query(sql, new SnglRecOutRowMapper());

		return snglRecOuts;
	}
	
	//get all the SNGLRECOUT
	public List<SnglRecOut> findAllTransId(String transId) {

		String sql = "SELECT * FROM SAP_CRUN_PERFORMANCE_SNGLRECOUT WHERE TRANSID='" + transId + "'";
		List<SnglRecOut> snglRecOuts = this.jdbcTemplate.query(sql, new SnglRecOutRowMapper());

		return snglRecOuts;
	}

	
	
	

}
