package com.karalexsandr.coreservice.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "integrations.auth-service")
@Data
public class AuthServiceIntegrationProperties {
    private String url;
    private Integer connect;
    private Integer read;
    private Integer write;
}
