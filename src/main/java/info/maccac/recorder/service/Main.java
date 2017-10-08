package info.maccac.recorder.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ratpack.guice.Guice;
import ratpack.server.RatpackServer;

public class Main {
    public static void main(String... args) throws Exception {
        RatpackServer.start(server -> server
                .serverConfig(c -> c.port(8080))
                .registryOf(r -> r.add(ObjectMapper.class, new ObjectMapper().disableDefaultTyping()))
                .registry(Guice.registry(b -> b.module(TestRecorderModule.class)))
                .handlers(chain -> chain
                        .post("results", TestResultsPostHandler.class)
                )
        );
    }
}
