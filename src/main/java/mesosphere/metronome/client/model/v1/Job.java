package mesosphere.metronome.client.model.v1;

import mesosphere.marathon.client.model.v2.Volume;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

public class Job {
    private String description;
    private String id;
    private Map<String,String> labels;
    private Run run;
    private History history;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String,String> getLabels() {
        return labels;
    }

    public void setLabels(Map<String,String> labels) {
        this.labels = labels;
    }

    public Run getRun() {
        return run;
    }

    public void setRun(Run run) {
        this.run = run;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    public static class Run {
        private Collection<Artifact> artifacts;
        private String cmd;
        private float cpus;
        private int mem;
        private int disk;
        private Docker docker;
        private Map<String, Object> env;
        private int maxLaunchDelay;
        private Restart restart;
        private String user;
        private Collection<Volume> volumes;

        public Collection<Artifact> getArtifacts() {
            return artifacts;
        }

        public void setArtifacts(Collection<Artifact> artifacts) {
            this.artifacts = artifacts;
        }

        public String getCmd() {
            return cmd;
        }

        public void setCmd(String cmd) {
            this.cmd = cmd;
        }

        public float getCpus() {
            return cpus;
        }

        public void setCpus(float cpus) {
            this.cpus = cpus;
        }

        public int getMem() {
            return mem;
        }

        public void setMem(int mem) {
            this.mem = mem;
        }

        public int getDisk() {
            return disk;
        }

        public void setDisk(int disk) {
            this.disk = disk;
        }

        public Docker getDocker() {
            return docker;
        }

        public void setDocker(Docker docker) {
            this.docker = docker;
        }

        public Map<String, Object> getEnv() {
            return env;
        }

        public void setEnv(Map<String, Object> env) {
            this.env = env;
        }

        public int getMaxLaunchDelay() {
            return maxLaunchDelay;
        }

        public void setMaxLaunchDelay(int maxLaunchDelay) {
            this.maxLaunchDelay = maxLaunchDelay;
        }

        public Restart getRestart() {
            return restart;
        }

        public void setRestart(Restart restart) {
            this.restart = restart;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public Collection<Volume> getVolumes() {
            return volumes;
        }

        public void setVolumes(Collection<Volume> volumes) {
            this.volumes = volumes;
        }

        public static class Docker {
            private String image;

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }
        }
        public static class Artifact {
            private String uri;
            private boolean extract;
            private boolean executable;
            private boolean cache;

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public boolean isExtract() {
                return extract;
            }

            public void setExtract(boolean extract) {
                this.extract = extract;
            }

            public boolean isExecutable() {
                return executable;
            }

            public void setExecutable(boolean executable) {
                this.executable = executable;
            }

            public boolean isCache() {
                return cache;
            }

            public void setCache(boolean cache) {
                this.cache = cache;
            }
        }

        public static class Placement {
            private Collection<Constraint> constraints;

            public Collection<Constraint> getConstraints() {
                return constraints;
            }

            public void setConstraints(Collection<Constraint> constraints) {
                this.constraints = constraints;
            }

            public static class Constraint {
                private String attribute;
                private String operator;
                private String value;

                public String getAttribute() {
                    return attribute;
                }

                public void setAttribute(String attribute) {
                    this.attribute = attribute;
                }

                public String getOperator() {
                    return operator;
                }

                public void setOperator(String operator) {
                    this.operator = operator;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }
        }

        public static class Restart {
            private int activeDeadlineSeconds;
            private String policy;

            public int getActiveDeadlineSeconds() {
                return activeDeadlineSeconds;
            }

            public void setActiveDeadlineSeconds(int activeDeadlineSeconds) {
                this.activeDeadlineSeconds = activeDeadlineSeconds;
            }

            public String getPolicy() {
                return policy;
            }

            public void setPolicy(String policy) {
                this.policy = policy;
            }
        }
    }

    public static class History {
        private Collection<FinishedRun> failedFinishedRuns;
        private int failureCount;
        private Date lastFailureAt;
        private Date lastSuccessAt;
        private int successCount;
        private Collection<FinishedRun> successfulFinishedRuns;

        public Collection<FinishedRun> getFailedFinishedRuns() {
            return failedFinishedRuns;
        }

        public void setFailedFinishedRuns(Collection<FinishedRun> failedFinishedRuns) {
            this.failedFinishedRuns = failedFinishedRuns;
        }

        public int getFailureCount() {
            return failureCount;
        }

        public void setFailureCount(int failureCount) {
            this.failureCount = failureCount;
        }

        public Date getLastFailureAt() {
            return lastFailureAt;
        }

        public void setLastFailureAt(Date lastFailureAt) {
            this.lastFailureAt = lastFailureAt;
        }

        public Date getLastSuccessAt() {
            return lastSuccessAt;
        }

        public void setLastSuccessAt(Date lastSuccessAt) {
            this.lastSuccessAt = lastSuccessAt;
        }

        public int getSuccessCount() {
            return successCount;
        }

        public void setSuccessCount(int successCount) {
            this.successCount = successCount;
        }

        public Collection<FinishedRun> getSuccessfulFinishedRuns() {
            return successfulFinishedRuns;
        }

        public void setSuccessfulFinishedRuns(Collection<FinishedRun> successfulFinishedRuns) {
            this.successfulFinishedRuns = successfulFinishedRuns;
        }

        public static class FinishedRun {
            private String id;
            private Date createdAt;
            private Date finishedAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public Date getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(Date createdAt) {
                this.createdAt = createdAt;
            }

            public Date getFinishedAt() {
                return finishedAt;
            }

            public void setFinishedAt(Date finishedAt) {
                this.finishedAt = finishedAt;
            }
        }
    }
}
