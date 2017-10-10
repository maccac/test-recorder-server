package info.maccac.recorder.service;

import com.google.inject.Inject;
import info.maccac.recorder.db.TestResultsStore;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.jackson.JsonRender;

import static ratpack.jackson.Jackson.json;

public class TestResultsGetHandler implements Handler {

    private TestResultsStore testResultsStore;

    @Inject
    public TestResultsGetHandler(TestResultsStore testResultsStore) {
        this.testResultsStore = testResultsStore;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        System.out.println("Here");
        JsonRender json = json(testResultsStore.getAll());
        ctx.render(json);
    }
}
