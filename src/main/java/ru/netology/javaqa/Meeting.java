package ru.netology.javaqa;

import java.util.Objects;

public class Meeting extends Task {
    private String topic;
    private String project;
    private String start;

    public Meeting(int id, String topic, String project, String start) {
        super(id);
        this.topic = topic;
        this.project = project;
        this.start = start;
    }

    public String getTopic() {
        return topic;
    }

    public String getProject() {
        return project;
    }

    public String getStart() {
        return start;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Meeting meeting = (Meeting) o;
        return Objects.equals(topic, meeting.topic) &&
                Objects.equals(project, meeting.project) &&
                Objects.equals(start, meeting.start);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), topic, project, start);
    }

    @Override
    public boolean matches(String query) {
        if (topic.contains(query)) {
            return true;
        }
        if (project.contains(query)) {
            return true;
        }
        return false;
    }
}
