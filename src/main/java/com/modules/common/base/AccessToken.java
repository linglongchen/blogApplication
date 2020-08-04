package com.modules.common.base;

import lombok.Data;

/**
 * @author admin
 */
@Data
public class AccessToken {
	private String access_token;
    private String token_type;
    private long expires_in;
}
