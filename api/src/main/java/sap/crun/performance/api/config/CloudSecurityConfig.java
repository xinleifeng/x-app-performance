package sap.crun.performance.api.config;

import com.sap.xs2.security.commons.SAPOfflineTokenServicesCloud;
import com.sap.xs2.security.container.SecurityContext;
import com.sap.xs2.security.container.UserInfo;
import com.sap.xs2.security.container.UserInfoException;
import org.springframework.context.annotation.*;
import org.springframework.web.context.WebApplicationContext;

/**
 * This config provides the "real" cloud version of the userInfoBean for
 * productive usage against the real xsuaa instance.
 */
@Profile("cloud")
@Configuration
public class CloudSecurityConfig {

	@Bean
	protected SAPOfflineTokenServicesCloud sapOfflineTokenServices() {
		return new SAPOfflineTokenServicesCloud();
	}

	/**
	 * UserInfo is provided as a Request Scoped Bean rather than pulling it directly
	 * from the SecurityContext. The advantage of this is being able to override it
	 * when run in the default profile locally, this way we can override the
	 * xsappname with a local testing default value.
	 * 
	 * @throws UserInfoException
	 */
	@Bean
	@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public UserInfo userInfoBean() throws UserInfoException {
//		try {
		return SecurityContext.getUserInfo();
//		} catch (UserInfoException e) {
//			return null;
//		}
	}

}