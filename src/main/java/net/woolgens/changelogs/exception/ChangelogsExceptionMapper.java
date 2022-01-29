package net.woolgens.changelogs.exception;

import net.woolgens.changelogs.exception.response.ErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Copyright (c) Maga, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Maga
 **/
@Provider
public class ChangelogsExceptionMapper implements ExceptionMapper<ChangelogsException> {
    @Override
    public Response toResponse(ChangelogsException exception) {
        return Response.status(exception.getStatus()).entity(new ErrorResponse(exception.getStatus(), exception.getMessage())).build();
    }
}
