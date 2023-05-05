SET 'execution.runtime-mode' = 'streaming';
SET 'sql-client.execution.result-mode' = 'table';
SET 'pipeline.auto-watermark-interval' = '200';
SET 'pipeline.time-characteristic' = 'EventTime';
SET 'sql-client.execution.max-table-result.rows' = '1000000';
SET 'pipeline.max-parallelism' = '128';
SET 'restart-strategy.type' = 'fixed-delay';
