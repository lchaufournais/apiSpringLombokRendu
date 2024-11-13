CREATE MATERIALIZED VIEW project_task_count AS
SELECT
    p.project_id,
    p.title AS project_title,
    COUNT(t.task_id) AS task_count
FROM
    project p
        LEFT JOIN
    task t ON p.project_id = t.project_id
GROUP BY
    p.project_id;
