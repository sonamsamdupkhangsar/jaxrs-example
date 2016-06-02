package com.sonam.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.model.wadl.Description;
import org.apache.cxf.jaxrs.model.wadl.Descriptions;
import org.apache.cxf.jaxrs.model.wadl.DocTarget;

@Path("/address")
public interface AddressService {

    @Descriptions(@Description(value = "This method will retrieve person's address", target = DocTarget.METHOD))
    @Path("/personId/{personId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAddress(@PathParam("personId") long personId);
}
