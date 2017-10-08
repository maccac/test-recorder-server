package info.maccac.recorder.service;

import com.google.inject.AbstractModule;
import info.maccac.recorder.db.TestResultsStore;
import info.maccac.recorder.db.TestResultsStoreImpl;

public class TestRecorderModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TestResultsStore.class).to(TestResultsStoreImpl.class);
        bind(TestResultsPostHandler.class);
    }
}
