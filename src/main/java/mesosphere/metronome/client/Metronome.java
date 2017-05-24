package mesosphere.metronome.client;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import mesosphere.client.common.HeaderUtils;
import mesosphere.metronome.client.model.v1.Job;
import mesosphere.metronome.client.model.v1.Run;
import mesosphere.metronome.client.model.v1.Schedule;

import java.util.Collection;
import java.util.Map;

public interface Metronome {
    @RequestLine("GET /v1/jobs")
    @Headers(HeaderUtils.METRONOME_API_SOURCE_HEADER)
    Collection<Job> getJobs() throws MetronomeException;

    @RequestLine("POST /v1/jobs")
    @Headers(HeaderUtils.METRONOME_API_SOURCE_HEADER)
    Job createJob(Job job) throws MetronomeException;

    @RequestLine("GET /v1/jobs/{jobId}")
    @Headers(HeaderUtils.METRONOME_API_SOURCE_HEADER)
    Job getJob(@Param("jobId") String jobId, @QueryMap Map<String, Object> queryMap) throws MetronomeException;

    @RequestLine("PUT /v1/jobs/{jobId}")
    @Headers(HeaderUtils.METRONOME_API_SOURCE_HEADER)
    Job updateJob(@Param("jobId") String jobId, Job job) throws MetronomeException;

    @RequestLine("DELETE /v1/jobs/{jobId}")
    @Headers(HeaderUtils.METRONOME_API_SOURCE_HEADER)
    Job deleteJob(@Param("jobId") String jobId) throws MetronomeException;

    @RequestLine("GET /v1/jobs/{jobId}/schedules")
    @Headers(HeaderUtils.METRONOME_API_SOURCE_HEADER)
    Collection<Schedule> getSchedules(@Param("jobId") String jobId) throws MetronomeException;

    @RequestLine("POST /v1/jobs/{jobId}/schedules")
    @Headers(HeaderUtils.METRONOME_API_SOURCE_HEADER)
    Schedule createSchedule(@Param("jobId") String jobId, Schedule schedule) throws MetronomeException;

    @RequestLine("GET /v1/jobs/{jobId}/schedules/{scheduleId}")
    @Headers(HeaderUtils.METRONOME_API_SOURCE_HEADER)
    Schedule getSchedule(@Param("jobId") String jobId, @Param("scheduleId") String scheduleId) throws MetronomeException;

    @RequestLine("PUT /v1/jobs/{jobId}/schedules/{scheduleId}")
    @Headers(HeaderUtils.METRONOME_API_SOURCE_HEADER)
    Schedule replaceSchedule(@Param("jobId") String jobId, @Param("scheduleId") String scheduleId, Schedule schedule) throws MetronomeException;

    @RequestLine("DELETE /v1/jobs/{jobId}/schedules/{scheduleId}")
    @Headers(HeaderUtils.METRONOME_API_SOURCE_HEADER)
    Schedule deleteSchedule(@Param("jobId") String jobId, @Param("scheduleId") String scheduleId) throws MetronomeException;

    @RequestLine("GET /v1/jobs/{jobId}/runs")
    @Headers(HeaderUtils.METRONOME_API_SOURCE_HEADER)
    Collection<Run> getRuns(@Param("jobId") String jobId) throws MetronomeException;

    @RequestLine("POST /v1/jobs/{jobId}/runs")
    @Headers(HeaderUtils.METRONOME_API_SOURCE_HEADER)
    Run triggerRun(@Param("jobId") String jobId) throws MetronomeException;

    @RequestLine("GET /v1/jobs/{jobId}/runs/{runId}")
    @Headers(HeaderUtils.METRONOME_API_SOURCE_HEADER)
    Run getRun(@Param("jobId") String jobId, @Param("runId") String runId) throws MetronomeException;

    @RequestLine("POST /v1/jobs/{jobId}/runs/{runId}/action/stop")
    @Headers(HeaderUtils.METRONOME_API_SOURCE_HEADER)
    Run stopRun(@Param("jobId") String jobId, @Param("runId") String runId) throws MetronomeException;
}
