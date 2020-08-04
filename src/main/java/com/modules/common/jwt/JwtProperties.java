package com.modules.common.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author v_vllchen
 */
@Configuration
@Data
@ConfigurationProperties(prefix = "config.jwt")
public class JwtProperties {

    /**
     *密钥
     */
    public  String secret;
    /**
     * 过期时间
     */
    public int expire;
    /**
     * 名称
     */
    public String header;


}
