package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes2.dex */
public final class Permission extends GenericJson {

    @Key
    private Boolean allowFileDiscovery;

    @Key
    private Boolean deleted;

    @Key
    private String displayName;

    @Key
    private String domain;

    @Key
    private String emailAddress;

    @Key
    private DateTime expirationTime;

    @Key
    private String id;

    @Key
    private String kind;

    @Key
    private List<PermissionDetails> permissionDetails;

    @Key
    private String photoLink;

    @Key
    private String role;

    @Key
    private List<TeamDrivePermissionDetails> teamDrivePermissionDetails;

    @Key
    private String type;

    static {
        Data.b((Class<?>) PermissionDetails.class);
        Data.b((Class<?>) TeamDrivePermissionDetails.class);
    }

    public Boolean getAllowFileDiscovery() {
        return this.allowFileDiscovery;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public DateTime getExpirationTime() {
        return this.expirationTime;
    }

    public String getId() {
        return this.id;
    }

    public String getKind() {
        return this.kind;
    }

    public List<PermissionDetails> getPermissionDetails() {
        return this.permissionDetails;
    }

    public String getPhotoLink() {
        return this.photoLink;
    }

    public String getRole() {
        return this.role;
    }

    public List<TeamDrivePermissionDetails> getTeamDrivePermissionDetails() {
        return this.teamDrivePermissionDetails;
    }

    public String getType() {
        return this.type;
    }

    public Permission setAllowFileDiscovery(Boolean bool) {
        this.allowFileDiscovery = bool;
        return this;
    }

    public Permission setDeleted(Boolean bool) {
        this.deleted = bool;
        return this;
    }

    public Permission setDisplayName(String str) {
        this.displayName = str;
        return this;
    }

    public Permission setDomain(String str) {
        this.domain = str;
        return this;
    }

    public Permission setEmailAddress(String str) {
        this.emailAddress = str;
        return this;
    }

    public Permission setExpirationTime(DateTime dateTime) {
        this.expirationTime = dateTime;
        return this;
    }

    public Permission setId(String str) {
        this.id = str;
        return this;
    }

    public Permission setKind(String str) {
        this.kind = str;
        return this;
    }

    public Permission setPermissionDetails(List<PermissionDetails> list) {
        this.permissionDetails = list;
        return this;
    }

    public Permission setPhotoLink(String str) {
        this.photoLink = str;
        return this;
    }

    public Permission setRole(String str) {
        this.role = str;
        return this;
    }

    public Permission setTeamDrivePermissionDetails(List<TeamDrivePermissionDetails> list) {
        this.teamDrivePermissionDetails = list;
        return this;
    }

    public Permission setType(String str) {
        this.type = str;
        return this;
    }

    /* loaded from: classes2.dex */
    public static final class PermissionDetails extends GenericJson {

        @Key
        private Boolean inherited;

        @Key
        private String inheritedFrom;

        @Key
        private String permissionType;

        @Key
        private String role;

        public Boolean getInherited() {
            return this.inherited;
        }

        public String getInheritedFrom() {
            return this.inheritedFrom;
        }

        public String getPermissionType() {
            return this.permissionType;
        }

        public String getRole() {
            return this.role;
        }

        public PermissionDetails setInherited(Boolean bool) {
            this.inherited = bool;
            return this;
        }

        public PermissionDetails setInheritedFrom(String str) {
            this.inheritedFrom = str;
            return this;
        }

        public PermissionDetails setPermissionType(String str) {
            this.permissionType = str;
            return this;
        }

        public PermissionDetails setRole(String str) {
            this.role = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public PermissionDetails set(String str, Object obj) {
            return (PermissionDetails) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public PermissionDetails clone() {
            return (PermissionDetails) super.clone();
        }
    }

    /* loaded from: classes2.dex */
    public static final class TeamDrivePermissionDetails extends GenericJson {

        @Key
        private Boolean inherited;

        @Key
        private String inheritedFrom;

        @Key
        private String role;

        @Key
        private String teamDrivePermissionType;

        public Boolean getInherited() {
            return this.inherited;
        }

        public String getInheritedFrom() {
            return this.inheritedFrom;
        }

        public String getRole() {
            return this.role;
        }

        public String getTeamDrivePermissionType() {
            return this.teamDrivePermissionType;
        }

        public TeamDrivePermissionDetails setInherited(Boolean bool) {
            this.inherited = bool;
            return this;
        }

        public TeamDrivePermissionDetails setInheritedFrom(String str) {
            this.inheritedFrom = str;
            return this;
        }

        public TeamDrivePermissionDetails setRole(String str) {
            this.role = str;
            return this;
        }

        public TeamDrivePermissionDetails setTeamDrivePermissionType(String str) {
            this.teamDrivePermissionType = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public TeamDrivePermissionDetails set(String str, Object obj) {
            return (TeamDrivePermissionDetails) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public TeamDrivePermissionDetails clone() {
            return (TeamDrivePermissionDetails) super.clone();
        }
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Permission set(String str, Object obj) {
        return (Permission) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Permission clone() {
        return (Permission) super.clone();
    }
}
