SET 'execution.runtime-mode' = 'streaming';
SET 'sql-client.execution.result-mode' = 'table';
SET 'pipeline.auto-watermark-interval' = '200';
SET 'sql-client.execution.max-table-result.rows' = '1000000';
SET 'parallelism.default' = '8';
SET 'pipeline.max-parallelism' = '128';
SET 'restart-strategy.type' = 'fixed-delay';
