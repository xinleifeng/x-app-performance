package sap.crun.performance.api.util;

import com.sap.xs2.security.container.UserInfo;
import com.sap.xs2.security.container.UserInfoException;

public class UserInfoWrapper extends UserInfo {

	public UserInfoWrapper(String xsappname) throws UserInfoException {
		super();
		this.setXSAppname(xsappname);
	}
	
}