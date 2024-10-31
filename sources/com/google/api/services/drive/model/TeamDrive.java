package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;

/* loaded from: classes2.dex */
public final class TeamDrive extends GenericJson {

    @Key
    private BackgroundImageFile backgroundImageFile;

    @Key
    private String backgroundImageLink;

    @Key
    private Capabilities capabilities;

    @Key
    private String colorRgb;

    @Key
    private DateTime createdTime;

    @Key
    private String id;

    @Key
    private String kind;

    @Key
    private String name;

    @Key
    private Restrictions restrictions;

    @Key
    private String themeId;

    public BackgroundImageFile getBackgroundImageFile() {
        return this.backgroundImageFile;
    }

    public String getBackgroundImageLink() {
        return this.backgroundImageLink;
    }

    public Capabilities getCapabilities() {
        return this.capabilities;
    }

    public String getColorRgb() {
        return this.colorRgb;
    }

    public DateTime getCreatedTime() {
        return this.createdTime;
    }

    public String getId() {
        return this.id;
    }

    public String getKind() {
        return this.kind;
    }

    public String getName() {
        return this.name;
    }

    public Restrictions getRestrictions() {
        return this.restrictions;
    }

    public String getThemeId() {
        return this.themeId;
    }

    public TeamDrive setBackgroundImageFile(BackgroundImageFile backgroundImageFile) {
        this.backgroundImageFile = backgroundImageFile;
        return this;
    }

    public TeamDrive setBackgroundImageLink(String str) {
        this.backgroundImageLink = str;
        return this;
    }

    public TeamDrive setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
        return this;
    }

    public TeamDrive setColorRgb(String str) {
        this.colorRgb = str;
        return this;
    }

    public TeamDrive setCreatedTime(DateTime dateTime) {
        this.createdTime = dateTime;
        return this;
    }

    public TeamDrive setId(String str) {
        this.id = str;
        return this;
    }

    public TeamDrive setKind(String str) {
        this.kind = str;
        return this;
    }

    public TeamDrive setName(String str) {
        this.name = str;
        return this;
    }

    public TeamDrive setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
        return this;
    }

    public TeamDrive setThemeId(String str) {
        this.themeId = str;
        return this;
    }

    /* loaded from: classes2.dex */
    public static final class BackgroundImageFile extends GenericJson {

        @Key
        private String id;

        @Key
        private Float width;

        @Key
        private Float xCoordinate;

        @Key
        private Float yCoordinate;

        public String getId() {
            return this.id;
        }

        public Float getWidth() {
            return this.width;
        }

        public Float getXCoordinate() {
            return this.xCoordinate;
        }

        public Float getYCoordinate() {
            return this.yCoordinate;
        }

        public BackgroundImageFile setId(String str) {
            this.id = str;
            return this;
        }

        public BackgroundImageFile setWidth(Float f2) {
            this.width = f2;
            return this;
        }

        public BackgroundImageFile setXCoordinate(Float f2) {
            this.xCoordinate = f2;
            return this;
        }

        public BackgroundImageFile setYCoordinate(Float f2) {
            this.yCoordinate = f2;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public BackgroundImageFile set(String str, Object obj) {
            return (BackgroundImageFile) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public BackgroundImageFile clone() {
            return (BackgroundImageFile) super.clone();
        }
    }

    /* loaded from: classes2.dex */
    public static final class Capabilities extends GenericJson {

        @Key
        private Boolean canAddChildren;

        @Key
        private Boolean canChangeCopyRequiresWriterPermissionRestriction;

        @Key
        private Boolean canChangeDomainUsersOnlyRestriction;

        @Key
        private Boolean canChangeTeamDriveBackground;

        @Key
        private Boolean canChangeTeamMembersOnlyRestriction;

        @Key
        private Boolean canComment;

        @Key
        private Boolean canCopy;

        @Key
        private Boolean canDeleteChildren;

        @Key
        private Boolean canDeleteTeamDrive;

        @Key
        private Boolean canDownload;

        @Key
        private Boolean canEdit;

        @Key
        private Boolean canListChildren;

        @Key
        private Boolean canManageMembers;

        @Key
        private Boolean canReadRevisions;

        @Key
        private Boolean canRemoveChildren;

        @Key
        private Boolean canRename;

        @Key
        private Boolean canRenameTeamDrive;

        @Key
        private Boolean canShare;

        @Key
        private Boolean canTrashChildren;

        public Boolean getCanAddChildren() {
            return this.canAddChildren;
        }

        public Boolean getCanChangeCopyRequiresWriterPermissionRestriction() {
            return this.canChangeCopyRequiresWriterPermissionRestriction;
        }

        public Boolean getCanChangeDomainUsersOnlyRestriction() {
            return this.canChangeDomainUsersOnlyRestriction;
        }

        public Boolean getCanChangeTeamDriveBackground() {
            return this.canChangeTeamDriveBackground;
        }

        public Boolean getCanChangeTeamMembersOnlyRestriction() {
            return this.canChangeTeamMembersOnlyRestriction;
        }

        public Boolean getCanComment() {
            return this.canComment;
        }

        public Boolean getCanCopy() {
            return this.canCopy;
        }

        public Boolean getCanDeleteChildren() {
            return this.canDeleteChildren;
        }

        public Boolean getCanDeleteTeamDrive() {
            return this.canDeleteTeamDrive;
        }

        public Boolean getCanDownload() {
            return this.canDownload;
        }

        public Boolean getCanEdit() {
            return this.canEdit;
        }

        public Boolean getCanListChildren() {
            return this.canListChildren;
        }

        public Boolean getCanManageMembers() {
            return this.canManageMembers;
        }

        public Boolean getCanReadRevisions() {
            return this.canReadRevisions;
        }

        public Boolean getCanRemoveChildren() {
            return this.canRemoveChildren;
        }

        public Boolean getCanRename() {
            return this.canRename;
        }

        public Boolean getCanRenameTeamDrive() {
            return this.canRenameTeamDrive;
        }

        public Boolean getCanShare() {
            return this.canShare;
        }

        public Boolean getCanTrashChildren() {
            return this.canTrashChildren;
        }

        public Capabilities setCanAddChildren(Boolean bool) {
            this.canAddChildren = bool;
            return this;
        }

        public Capabilities setCanChangeCopyRequiresWriterPermissionRestriction(Boolean bool) {
            this.canChangeCopyRequiresWriterPermissionRestriction = bool;
            return this;
        }

        public Capabilities setCanChangeDomainUsersOnlyRestriction(Boolean bool) {
            this.canChangeDomainUsersOnlyRestriction = bool;
            return this;
        }

        public Capabilities setCanChangeTeamDriveBackground(Boolean bool) {
            this.canChangeTeamDriveBackground = bool;
            return this;
        }

        public Capabilities setCanChangeTeamMembersOnlyRestriction(Boolean bool) {
            this.canChangeTeamMembersOnlyRestriction = bool;
            return this;
        }

        public Capabilities setCanComment(Boolean bool) {
            this.canComment = bool;
            return this;
        }

        public Capabilities setCanCopy(Boolean bool) {
            this.canCopy = bool;
            return this;
        }

        public Capabilities setCanDeleteChildren(Boolean bool) {
            this.canDeleteChildren = bool;
            return this;
        }

        public Capabilities setCanDeleteTeamDrive(Boolean bool) {
            this.canDeleteTeamDrive = bool;
            return this;
        }

        public Capabilities setCanDownload(Boolean bool) {
            this.canDownload = bool;
            return this;
        }

        public Capabilities setCanEdit(Boolean bool) {
            this.canEdit = bool;
            return this;
        }

        public Capabilities setCanListChildren(Boolean bool) {
            this.canListChildren = bool;
            return this;
        }

        public Capabilities setCanManageMembers(Boolean bool) {
            this.canManageMembers = bool;
            return this;
        }

        public Capabilities setCanReadRevisions(Boolean bool) {
            this.canReadRevisions = bool;
            return this;
        }

        public Capabilities setCanRemoveChildren(Boolean bool) {
            this.canRemoveChildren = bool;
            return this;
        }

        public Capabilities setCanRename(Boolean bool) {
            this.canRename = bool;
            return this;
        }

        public Capabilities setCanRenameTeamDrive(Boolean bool) {
            this.canRenameTeamDrive = bool;
            return this;
        }

        public Capabilities setCanShare(Boolean bool) {
            this.canShare = bool;
            return this;
        }

        public Capabilities setCanTrashChildren(Boolean bool) {
            this.canTrashChildren = bool;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Capabilities set(String str, Object obj) {
            return (Capabilities) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Capabilities clone() {
            return (Capabilities) super.clone();
        }
    }

    /* loaded from: classes2.dex */
    public static final class Restrictions extends GenericJson {

        @Key
        private Boolean adminManagedRestrictions;

        @Key
        private Boolean copyRequiresWriterPermission;

        @Key
        private Boolean domainUsersOnly;

        @Key
        private Boolean teamMembersOnly;

        public Boolean getAdminManagedRestrictions() {
            return this.adminManagedRestrictions;
        }

        public Boolean getCopyRequiresWriterPermission() {
            return this.copyRequiresWriterPermission;
        }

        public Boolean getDomainUsersOnly() {
            return this.domainUsersOnly;
        }

        public Boolean getTeamMembersOnly() {
            return this.teamMembersOnly;
        }

        public Restrictions setAdminManagedRestrictions(Boolean bool) {
            this.adminManagedRestrictions = bool;
            return this;
        }

        public Restrictions setCopyRequiresWriterPermission(Boolean bool) {
            this.copyRequiresWriterPermission = bool;
            return this;
        }

        public Restrictions setDomainUsersOnly(Boolean bool) {
            this.domainUsersOnly = bool;
            return this;
        }

        public Restrictions setTeamMembersOnly(Boolean bool) {
            this.teamMembersOnly = bool;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Restrictions set(String str, Object obj) {
            return (Restrictions) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Restrictions clone() {
            return (Restrictions) super.clone();
        }
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public TeamDrive set(String str, Object obj) {
        return (TeamDrive) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public TeamDrive clone() {
        return (TeamDrive) super.clone();
    }
}
