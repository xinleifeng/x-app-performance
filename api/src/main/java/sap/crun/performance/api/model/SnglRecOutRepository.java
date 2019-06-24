package sap.crun.performance.api.model;

//import java.util.ArrayList;
import java.util.List;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import sap.crun.performance.api.model.SnglRecOutRowMapper;

//@Repository
//public interface SnglRecOutRepository extends JpaRepository<SnglRecOut, Long> {
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

	
	//insert a new SNGLRECOUT
	public void insertNewSnglRecOut(SnglRecOut oSnglRecOut) {

		 String sql = "INSERT INTO SAP_CRUN_PERFORMANCE_SNGLRECOUT(TRANSID, CONNID, CONNCOUNTER, CDATE, CTIME, "
		 		                                                + "SERVICEID, CONNIDOUT, CONNCOUNTERCOUT, SID, SYSTEMTYPE, "
		 		                                                + "TYPE, NAME1, NAME2, USERNAME, TARGETINSTANCE, "
		 		                                                + "CALLINGTIME, SENTBYTES, RECEIVEDBYTES) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	     Object[] params = new Object[] {
	    		 oSnglRecOut.getTransId(), 
	    		 oSnglRecOut.getConnId(),
	    		 oSnglRecOut.getConnCounter(),
	    		 oSnglRecOut.getcDate(),
	    		 oSnglRecOut.getcTime(),
	    			
	    		 oSnglRecOut.getServiceId(),
	    		 oSnglRecOut.getConnIdOut(),
	    		 oSnglRecOut.getConnCounterOut(),
	    		 oSnglRecOut.getsId(),
	    		 oSnglRecOut.getSystemType(),
	    			
	    		 oSnglRecOut.getType(),
	    		 oSnglRecOut.getName1(),
	    		 oSnglRecOut.getName2(),
	    		 oSnglRecOut.getUserName(),
	    		 oSnglRecOut.getTargetInstance(),
	    			
	    		 oSnglRecOut.getCallingTime(),
	    		 oSnglRecOut.getSendBypes(),
	    		 oSnglRecOut.getReceivedBypes()
	     };
	     
         this.jdbcTemplate.update(sql, params);
		
	}
	
	//update existing SNGLRECOUT
	public void updateByTransId(SnglRecOut oSnglRecOut){
	      String sql = "UPDATE SAP_CRUN_PERFORMANCE_SNGLRECOUT SET "
	      		+ "CONNID = ?, CONNCOUNTER = ?, CDATE = ?, CTIME = ?, "
	      		+ "SERVICEID = ?, CONNIDOUT = ?, CONNCOUNTERCOUT = ?, SID = ?, SYSTEMTYPE = ?,"
	      		+ "TYPE = ?, NAME1 = ?, NAME2 = ?, USERNAME = ?, TARGETINSTANCE = ?, "
	      		+ "CALLINGTIME = ?, SENTBYTES = ?, RECEIVEDBYTES = ? WHERE TRANSID = ?";
	      
	      Object[] params = new Object[] {
		    		 //oSnglRecOut.getTransId(), 
		    		 oSnglRecOut.getConnId(),
		    		 oSnglRecOut.getConnCounter(),
		    		 oSnglRecOut.getcDate(),
		    		 oSnglRecOut.getcTime(),
		    			
		    		 oSnglRecOut.getServiceId(),
		    		 oSnglRecOut.getConnIdOut(),
		    		 oSnglRecOut.getConnCounterOut(),
		    		 oSnglRecOut.getsId(),
		    		 oSnglRecOut.getSystemType(),
		    			
		    		 oSnglRecOut.getType(),
		    		 oSnglRecOut.getName1(),
		    		 oSnglRecOut.getName2(),
		    		 oSnglRecOut.getUserName(),
		    		 oSnglRecOut.getTargetInstance(),
		    			
		    		 oSnglRecOut.getCallingTime(),
		    		 oSnglRecOut.getSendBypes(),
		    		 oSnglRecOut.getReceivedBypes(),
		    		 
		    		 oSnglRecOut.getTransId()
		     };
	      
	      this.jdbcTemplate.update(sql, params);
   }
	
	//delete SNGLRECOUT by TransId
	public void deleteByTransId(String transId) {
		String deleteQuery = "DELETE FROM SAP_CRUN_PERFORMANCE_SNGLRECOUT WHERE TRANSID = ?";
		this.jdbcTemplate.update(deleteQuery, transId);
	}
	
}
