package info.maccac.recorder.db;

import info.maccac.recorder.api.TestResults;

import java.util.ArrayList;
import java.util.List;

public class TestResultsStoreImpl implements TestResultsStore {

    private List<TestResults> results = new ArrayList<>();

    @Override
    public void save(TestResults testResults) {
        results.add(testResults);
    }
}
