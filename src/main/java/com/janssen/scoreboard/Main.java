package com.janssen.scoreboard;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.jboss.logging.Logger;

@QuarkusMain
public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String ... args) {
        LOG.info("Starting KBBC Oostkamp Scoreboard App");

        Quarkus.run(ScoreboardApp.class, args);
    }
}
