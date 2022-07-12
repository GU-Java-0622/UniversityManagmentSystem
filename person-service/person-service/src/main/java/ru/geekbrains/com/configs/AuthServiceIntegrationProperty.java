package ru.geekbrains.com.configs;

public class AuthServiceIntegrationProperty {
    private final String authServiceUrl="http://localhost:5555/auth";
    private final Long readTimeout= 2000L;
    private final Long writeTimeout = 2000L;
    private final Integer connectionTimeout = 10000;

    public String getAuthServiceUrl() {
        return authServiceUrl;
    }

    public Long getReadTimeout() {
        return readTimeout;
    }

    public Long getWriteTimeout() {
        return writeTimeout;
    }

    public Integer getConnectionTimeout() {
        return connectionTimeout;
    }
}
