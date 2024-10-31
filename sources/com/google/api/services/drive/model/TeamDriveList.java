package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes2.dex */
public final class TeamDriveList extends GenericJson {

    @Key
    private String kind;

    @Key
    private String nextPageToken;

    @Key
    private List<TeamDrive> teamDrives;

    static {
        Data.b((Class<?>) TeamDrive.class);
    }

    public String getKind() {
        return this.kind;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public List<TeamDrive> getTeamDrives() {
        return this.teamDrives;
    }

    public TeamDriveList setKind(String str) {
        this.kind = str;
        return this;
    }

    public TeamDriveList setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public TeamDriveList setTeamDrives(List<TeamDrive> list) {
        this.teamDrives = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public TeamDriveList set(String str, Object obj) {
        return (TeamDriveList) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public TeamDriveList clone() {
        return (TeamDriveList) super.clone();
    }
}
