package com.yukibuwana;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

@Path("/")
public class ServerResouce {

    final String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");
    private final KubernetesClient kubernetesClient;

    public ServerResouce() {
        this.kubernetesClient = new DefaultKubernetesClient();
    }

    @GET
    @Path("hostname")
    @Produces(MediaType.TEXT_PLAIN)
    public String hostname() {
        return hostname;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/pod")
    public List<Pod> pods() {
        return kubernetesClient.pods().inNamespace("default").list().getItems();
    }
}
