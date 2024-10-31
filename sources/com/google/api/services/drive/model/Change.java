package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;

/* loaded from: classes2.dex */
public final class Change extends GenericJson {

    @Key
    private String changeType;

    @Key
    private Drive drive;

    @Key
    private String driveId;

    @Key
    private File file;

    @Key
    private String fileId;

    @Key
    private String kind;

    @Key
    private Boolean removed;

    @Key
    private TeamDrive teamDrive;

    @Key
    private String teamDriveId;

    @Key
    private DateTime time;

    @Key
    private String type;

    public String getChangeType() {
        return this.changeType;
    }

    public Drive getDrive() {
        return this.drive;
    }

    public String getDriveId() {
        return this.driveId;
    }

    public File getFile() {
        return this.file;
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getKind() {
        return this.kind;
    }

    public Boolean getRemoved() {
        return this.removed;
    }

    public TeamDrive getTeamDrive() {
        return this.teamDrive;
    }

    public String getTeamDriveId() {
        return this.teamDriveId;
    }

    public DateTime getTime() {
        return this.time;
    }

    public String getType() {
        return this.type;
    }

    public Change setChangeType(String str) {
        this.changeType = str;
        return this;
    }

    public Change setDrive(Drive drive) {
        this.drive = drive;
        return this;
    }

    public Change setDriveId(String str) {
        this.driveId = str;
        return this;
    }

    public Change setFile(File file) {
        this.file = file;
        return this;
    }

    public Change setFileId(String str) {
        this.fileId = str;
        return this;
    }

    public Change setKind(String str) {
        this.kind = str;
        return this;
    }

    public Change setRemoved(Boolean bool) {
        this.removed = bool;
        return this;
    }

    public Change setTeamDrive(TeamDrive teamDrive) {
        this.teamDrive = teamDrive;
        return this;
    }

    public Change setTeamDriveId(String str) {
        this.teamDriveId = str;
        return this;
    }

    public Change setTime(DateTime dateTime) {
        this.time = dateTime;
        return this;
    }

    public Change setType(String str) {
        this.type = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Change set(String str, Object obj) {
        return (Change) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Change clone() {
        return (Change) super.clone();
    }
}
