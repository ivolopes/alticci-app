package org.alticci.exceptions;

import org.alticci.dto.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.time.LocalDateTime;

@Provider
public class AlticciExceptionHandler implements ExceptionMapper<AlticciException> {

    @Override
    public Response toResponse(AlticciException alticciException) {

        ErrorMessage error = ErrorMessage.builder()
                .timestamp(LocalDateTime.now())
                .message(alticciException.getMessage()).build();

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(error).build();
    }
}
