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

/*
    С этим вариантом
    22:15:33,731 ERROR [org.jboss.as.server] (management-handler-thread - 9) JBAS015860: Redeploy of deployment "edisoft.war" was rolled back with the following failure message:
    {"JBAS014671: Failed services" => {"jboss.deployment.unit.\"edisoft.war\".INSTALL" => "org.jboss.msc.service.StartException in service jboss.deployment.unit.\"edisoft.war\".INSTALL: JBAS018733: Failed to process phase INSTALL of deployment \"edisoft.war\"
        Caused by: org.jboss.as.server.deployment.DeploymentUnitProcessingException: JBAS014544: No EJB found with interface of type 'com.prinstonsam.edisoft.service.TypeBodyServiceImpl' for binding com.prinstonsam.edisoft.rest.TypeBodies/typeBodyService"}}
*/
        @EJB
    private TypeBodyServiceImpl typeBodyService;

/*
    С этим вариантом
    22:06:53,785 ERROR [org.jboss.as.server] (management-handler-thread - 5) JBAS015860: Redeploy of deployment "edisoft.war" was rolled b
    ack with the following failure message:
    {"JBAS014671: Failed services" => {"jboss.deployment.unit.\"edisoft.war\".INSTALL" => "org.jboss.msc.service.StartException in service
        jboss.deployment.unit.\"edisoft.war\".INSTALL: JBAS018733: Failed to process phase INSTALL of deployment \"edisoft.war\"
        Caused by: org.jboss.as.server.deployment.DeploymentUnitProcessingException: JBAS014544: No EJB found with interface of type 'com.
        prinstonsam.edisoft.service.TypeBodyServiceImpl' for binding com.prinstonsam.edisoft.rest.TypeBodies/typeBodyService"}}
*/
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
