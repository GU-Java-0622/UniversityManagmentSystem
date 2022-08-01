package com.karalexsandr.coreservice.config;

import com.karalexsandr.coreservice.properties.AuthServiceIntegrationProperties;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableConfigurationProperties(AuthServiceIntegrationProperties.class)
@RequiredArgsConstructor
public class AppConfig {
    private final AuthServiceIntegrationProperties authServiceIntegrationProperties;

    @Bean
    public WebClient authServiceWebClient(){
        TcpClient tcpClient = TcpClient
                .create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, authServiceIntegrationProperties.getConnect())
                .doOnConnected(connection ->{
                    connection.addHandlerLast(new ReadTimeoutHandler(authServiceIntegrationProperties.getRead(), TimeUnit.MILLISECONDS ));
                    connection.addHandlerLast(new WriteTimeoutHandler(authServiceIntegrationProperties.getWrite(),TimeUnit.MILLISECONDS));
                });
        return WebClient
                .builder()
                .baseUrl(authServiceIntegrationProperties.getUrl())
                .clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
                .build();
    }
}
