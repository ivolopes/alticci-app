package org.alticci.configurations;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        tags = {
                @Tag(name = "Alticci Rest API",
                description = "API that provides an alticci sequence")
        },
        info = @Info(
                title = "Alticci Swagger",
                version = "1.0.1",
                contact = @Contact(
                        name = "Ivo Lopes",
                        url = "",
                        email = "ivolopes.o@outlook.com"
                )
        )
)
public class CustomApi extends Application {
}
