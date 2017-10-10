package info.maccac.recorder.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import info.maccac.recorder.api.TestResults;
import info.maccac.recorder.db.TestResultsStore;
import ratpack.exec.Blocking;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.http.Status;

import static ratpack.jackson.Jackson.fromJson;

@Singleton
public class TestResultsPostHandler implements Handler {

    private TestResultsStore resultsStore;

    @Inject
    public TestResultsPostHandler(TestResultsStore resultsStore) {
        this.resultsStore = resultsStore;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        ctx.parse(fromJson(TestResults.class))
                .then(t -> Blocking.op(() -> resultsStore.save(t)).then(() -> ctx.getResponse().status(Status.OK).send()));
    }
}
