package info.maccac.recorder.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestResults {

    private String projectName;
    private TestResult testResult;

    @JsonCreator
    public TestResults(@JsonProperty("projectName") String projectName, @JsonProperty("testResult") TestResult testResult) {
        this.projectName = projectName;
        this.testResult = testResult;
    }
}
