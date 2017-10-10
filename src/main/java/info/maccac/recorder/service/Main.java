package info.maccac.recorder.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ratpack.guice.Guice;
import ratpack.handling.ByMethodSpec;
import ratpack.hikari.HikariModule;
import ratpack.server.RatpackServer;

public class Main {
    public static void main(String... args) throws Exception {
        RatpackServer.start(server -> server
                .serverConfig(c -> c.port(8080))
                .registryOf(r -> r.add(ObjectMapper.class, new ObjectMapper().disableDefaultTyping()))
                .registry(Guice.registry(b -> b
                        .module(TestRecorderModule.class)
                        .module(HikariModule.class, hm -> {
                            hm.setDataSourceClassName("org.h2.jdbcx.JdbcDataSource");
                            hm.addDataSourceProperty("URL", "jdbc:h2:mem:tood;INIT=RUNSCRIPT FROM 'classpath:/init.sql'");

                        }))
                )
                .handlers(chain -> chain
                        .path("results", ctx -> {
                            ctx.byMethod(Main::resultMethodHandlers);
                        })
                )
        );
    }

    private static void resultMethodHandlers(ByMethodSpec m) {
        m.get(TestResultsGetHandler.class).post(TestResultsPostHandler.class);
    }
}
