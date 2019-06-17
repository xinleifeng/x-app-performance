package sap.crun.performance.api.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SnglRecOutRowMapper implements RowMapper<SnglRecOut> {
	
	@Override
	public SnglRecOut mapRow(ResultSet rs, int rownumber) throws SQLException {
		
		SnglRecOut e = new SnglRecOut();
		
		e.setTransId(rs.getString("TRANSID"));
		e.setConnId(rs.getString("CONNID"));
		e.setConnCounter(rs.getInt("CONNCOUNTER"));
		e.setcDate(rs.getString("CDATE"));
		e.setcTime(rs.getString("CTIME"));
		
		e.setServiceId(rs.getString("SERVICEID"));
		e.setConnIdOut(rs.getString("CONNIDOUT"));
		e.setConnCounterOut(rs.getInt("CONNCOUNTERCOUT"));
		e.setsId(rs.getString("SID"));
		e.setSystemType(rs.getString("SYSTEMTYPE"));
		
		e.setType(rs.getString("TYPE"));
		e.setName1(rs.getString("NAME1"));
		e.setName2(rs.getString("NAME2"));
		e.setUserName(rs.getString("USERNAME"));
		e.setTargetInstance(rs.getString("TARGETINSTANCE"));
		
		e.setCallingTime(rs.getFloat("CALLINGTIME"));
		e.setSendBypes(rs.getFloat("SENTBYTES"));
		e.setReceivedBypes(rs.getFloat("RECEIVEDBYTES"));
		//e.setReceivedBypes(90.98f);
		
		return e;
	}
}