package com.prinstonsam.edisoft.rest;

import com.prinstonsam.edisoft.model.TypeBody;
import com.prinstonsam.edisoft.service.TypeBodyService;
import com.prinstonsam.edisoft.service.TypeBodyServiceImpl;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

@Path("/typebodies")
//@RequestScoped
@Stateless
public class TypeBodies {
    @EJB
    private TypeBodyServiceImpl typeBodyService;

    @GET
    @Produces("application/xml")
    public StreamingOutput getTypeBodies() {
        return new StreamingOutput() {
            List<TypeBody> typeBodies = typeBodyService.getAll();
            public void write(OutputStream outputStream) throws IOException, WebApplicationException {
                outputXMLTypeBodies(outputStream, typeBodies);
            }
        };
    }

    protected void outputXMLTypeBodies(OutputStream os, List<TypeBody> typeBodies) throws IOException {
        PrintStream writer = new PrintStream(os);
        for (TypeBody typeBody : typeBodies) {
            writer.println("<type-body>");
            writer.println("   <id>" + typeBody.getId() + "</id>");
            writer.println("   <name>" + typeBody.getName() + "</name>");
            writer.println("</type-body>");
        }
    }
}
