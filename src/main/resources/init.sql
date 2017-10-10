DROP TABLE IF EXISTS TestResults;
CREATE TABLE IdeTestResults (
  `id` bigint auto_increment primary key,
  `projectName` varchar(256),
  `testName` varchar(256),
  `duration` bigint
)