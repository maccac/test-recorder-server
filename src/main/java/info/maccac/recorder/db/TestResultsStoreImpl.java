package info.maccac.recorder.db;

import com.google.inject.Inject;
import info.maccac.recorder.api.TestResult;
import info.maccac.recorder.api.TestResults;

import jooq.tables.records.IdetestresultsRecord;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import javax.sql.DataSource;

import java.util.List;
import java.util.stream.Collectors;

import static jooq.tables.Idetestresults.IDETESTRESULTS;

public class TestResultsStoreImpl implements TestResultsStore {


    private DataSource dataSource;

    @Inject
    public TestResultsStoreImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(final TestResults testResults) {
        DSL.using(this.dataSource, SQLDialect.H2)
                .transaction(ctx -> {
                    testResults
                            .getTestResult()
                            .getChildren()
                            .forEach(t ->
                                    DSL.using(ctx)
                                        .insertInto(IDETESTRESULTS, IDETESTRESULTS.PROJECTNAME, IDETESTRESULTS.TESTNAME, IDETESTRESULTS.DURATION)
                                        .values(testResults.getProjectName(), t.getName(), t.getDuration())
                                        .execute()
                            );
                });
    }

    @Override
    public List<TestResult> getAll() {
        DSLContext ctx = DSL.using(this.dataSource, SQLDialect.H2);
        return ctx.selectFrom(IDETESTRESULTS).fetch().stream().map(
                t -> new TestResult(t.getProjectname(), t.getTestname(), t.getDuration(), null)
        ).collect(Collectors.toList());
    }
}
