package com.offlinepay.merchant.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Merchant Management API",
                version = "v1",
                description = "This app provides REST APIs for Merchant management",
                contact = @Contact(
                        name = "Offline Pay",
                        email = "admin@offlinepay.com",
                        url = "http://offline-pay.com/support"
                )
        ),
        servers = {
                @Server(
                        url = "http://localhost:20002/",
                        description = "DEV Server"
                ),
                @Server(
                        url = "<prod url>",
                        description = "PROD Server"
                )
        }
)

public class OpenApiConfig {
}
