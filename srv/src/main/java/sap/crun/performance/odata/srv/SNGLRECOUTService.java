package sap.crun.performance.odata.srv;

import java.util.ArrayList;
import java.util.List;

import com.sap.cloud.sdk.service.prov.api.*;
import com.sap.cloud.sdk.service.prov.api.annotations.*;
import com.sap.cloud.sdk.service.prov.api.exits.*;
import com.sap.cloud.sdk.service.prov.api.request.*;
import com.sap.cloud.sdk.service.prov.api.response.*;
import org.slf4j.*;

public class SNGLRECOUTService {
	
	private static final Logger LOG = LoggerFactory.getLogger (SNGLRECOUTService.class.getName());
	
	@BeforeRead (entity="SNGLRECOUT", serviceName="PerformanceDataService")
	public BeforeReadResponse beforeReadSNGLRECOUT (ReadRequest req, ExtensionHelper h){
		LOG.error ("##### SNGLRECOUT - beforeReadSNGLRECOUT ########");
		return BeforeReadResponse.setSuccess().response();
	}
	
	@AfterRead (entity = "SNGLRECOUT", serviceName="PerformanceDataService")
	public ReadResponse afterReadSNGLRECOUT (ReadRequest req, ReadResponseAccessor res, ExtensionHelper h) {
		EntityData ed = res.getEntityData();
		EntityData ex = EntityData.getBuilder(ed).addElement("CALLINGTIME", 8.888).buildEntityData("SNGLRECOUT");
		return ReadResponse.setSuccess().setData(ex).response();
	}
	
	@AfterQuery (entity = "SNGLRECOUT", serviceName="PerformanceDataService")
	public QueryResponse afterQuerySNGLRECOUT (QueryRequest req, QueryResponseAccessor res, ExtensionHelper h) {
		List<EntityData> dataList = res.getEntityDataList(); //original list
		List<EntityData> modifiedList = new ArrayList<EntityData>(dataList.size()); //modified list
		for(EntityData ed : dataList){
			EntityData ex = EntityData.getBuilder(ed).addElement("CALLINGTIME", 8.888).buildEntityData("SNGLRECOUT");
			modifiedList.add(ex);
		}
		return QueryResponse.setSuccess().setData(modifiedList).response();
	}
	
}
