package info.maccac.recorder.db;

import info.maccac.recorder.api.TestResults;

public interface TestResultsStore {

    void save(TestResults testResults);
}
