package info.maccac.recorder.service;

import com.google.inject.Inject;
import info.maccac.recorder.db.TestResultsStore;
import ratpack.exec.Blocking;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import static ratpack.jackson.Jackson.json;

public class TestResultsGetHandler implements Handler {

    private TestResultsStore testResultsStore;

    @Inject
    public TestResultsGetHandler(TestResultsStore testResultsStore) {
        this.testResultsStore = testResultsStore;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        Blocking.get(() -> testResultsStore.getAll()).then(t -> ctx.render(json(t)));
    }
}
