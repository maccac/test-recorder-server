package info.maccac.recorder.db;

import info.maccac.recorder.api.TestResult;
import info.maccac.recorder.api.TestResults;

import java.util.List;

public interface TestResultsStore {

    void save(TestResults testResults);

    List<TestResult> getAll();
}
