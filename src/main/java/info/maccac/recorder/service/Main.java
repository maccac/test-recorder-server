package info.maccac.recorder.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ratpack.handling.Handler;
import ratpack.http.Status;
import ratpack.server.RatpackServer;

public class Main {
    public static void main(String... args) throws Exception {
        RatpackServer.start(server -> server
                .serverConfig(c -> c.port(8080))
                .registryOf(r -> r.add(ObjectMapper.class, new ObjectMapper().disableDefaultTyping()))
                .handlers(chain -> chain
                        .post("results", handlePostedResults())
                )
        );
    }

    private static Handler handlePostedResults() {
        return ctx -> {
            ctx.getRequest().getBody().then(data ->
                System.out.println(data.getText())
            );
            ctx.getResponse().status(Status.OK);
        };
    }
}
