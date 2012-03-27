package org.springframework.security.oauth2.client.context;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

/**
 * The OAuth 2 security context (for a specific user or client).
 * 
 * @author Dave Syer
 */
public class DefaultOAuth2ClientContext implements OAuth2ClientContext {

	private OAuth2AccessToken accessToken;

	private AccessTokenRequest accessTokenRequest;

	private Map<String, Object> state = new HashMap<String, Object>();

	public DefaultOAuth2ClientContext() {
		this(new DefaultAccessTokenRequest());
	}

	public DefaultOAuth2ClientContext(AccessTokenRequest accessTokenRequest) {
		this.accessTokenRequest = accessTokenRequest;
	}

	public DefaultOAuth2ClientContext(OAuth2AccessToken accessToken) {
		this.accessToken = accessToken;
		this.accessTokenRequest = new DefaultAccessTokenRequest();
	}

	public OAuth2AccessToken getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(OAuth2AccessToken accessToken) {
		this.accessToken = accessToken;
	}
	
	public void setAccessTokenRequest(AccessTokenRequest accessTokenRequest) {
		this.accessTokenRequest = accessTokenRequest;
	}

	public AccessTokenRequest getAccessTokenRequest() {
		return accessTokenRequest;
	}
	
	public void setPreservedState(String stateKey, Object preservedState) {
		state.put(stateKey, preservedState);
	}
	
	public Object getPreservedState(String stateKey) {
		return state.get(stateKey);
	}
	
}