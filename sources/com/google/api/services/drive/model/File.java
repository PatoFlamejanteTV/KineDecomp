package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Base64;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class File extends GenericJson {

    @Key
    private Map<String, String> appProperties;

    @Key
    private Capabilities capabilities;

    @Key
    private ContentHints contentHints;

    @Key
    private Boolean copyRequiresWriterPermission;

    @Key
    private DateTime createdTime;

    @Key
    private String description;

    @Key
    private String driveId;

    @Key
    private Boolean explicitlyTrashed;

    @Key
    private Map<String, String> exportLinks;

    @Key
    private String fileExtension;

    @Key
    private String folderColorRgb;

    @Key
    private String fullFileExtension;

    @Key
    private Boolean hasAugmentedPermissions;

    @Key
    private Boolean hasThumbnail;

    @Key
    private String headRevisionId;

    @Key
    private String iconLink;

    @Key
    private String id;

    @Key
    private ImageMediaMetadata imageMediaMetadata;

    @Key
    private Boolean isAppAuthorized;

    @Key
    private String kind;

    @Key
    private User lastModifyingUser;

    @Key
    private String md5Checksum;

    @Key
    private String mimeType;

    @Key
    private Boolean modifiedByMe;

    @Key
    private DateTime modifiedByMeTime;

    @Key
    private DateTime modifiedTime;

    @Key
    private String name;

    @Key
    private String originalFilename;

    @Key
    private Boolean ownedByMe;

    @Key
    private List<User> owners;

    @Key
    private List<String> parents;

    @Key
    private List<String> permissionIds;

    @Key
    private List<Permission> permissions;

    @Key
    private Map<String, String> properties;

    @JsonString
    @Key
    private Long quotaBytesUsed;

    @Key
    private Boolean shared;

    @Key
    private DateTime sharedWithMeTime;

    @Key
    private User sharingUser;

    @JsonString
    @Key
    private Long size;

    @Key
    private List<String> spaces;

    @Key
    private Boolean starred;

    @Key
    private String teamDriveId;

    @Key
    private String thumbnailLink;

    @JsonString
    @Key
    private Long thumbnailVersion;

    @Key
    private Boolean trashed;

    @Key
    private DateTime trashedTime;

    @Key
    private User trashingUser;

    @JsonString
    @Key
    private Long version;

    @Key
    private VideoMediaMetadata videoMediaMetadata;

    @Key
    private Boolean viewedByMe;

    @Key
    private DateTime viewedByMeTime;

    @Key
    private Boolean viewersCanCopyContent;

    @Key
    private String webContentLink;

    @Key
    private String webViewLink;

    @Key
    private Boolean writersCanShare;

    /* loaded from: classes2.dex */
    public static final class ContentHints extends GenericJson {

        @Key
        private String indexableText;

        @Key
        private Thumbnail thumbnail;

        public String getIndexableText() {
            return this.indexableText;
        }

        public Thumbnail getThumbnail() {
            return this.thumbnail;
        }

        public ContentHints setIndexableText(String str) {
            this.indexableText = str;
            return this;
        }

        public ContentHints setThumbnail(Thumbnail thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        /* loaded from: classes2.dex */
        public static final class Thumbnail extends GenericJson {

            @Key
            private String image;

            @Key
            private String mimeType;

            public byte[] decodeImage() {
                return Base64.a(this.image);
            }

            public Thumbnail encodeImage(byte[] bArr) {
                this.image = Base64.c(bArr);
                return this;
            }

            public String getImage() {
                return this.image;
            }

            public String getMimeType() {
                return this.mimeType;
            }

            public Thumbnail setImage(String str) {
                this.image = str;
                return this;
            }

            public Thumbnail setMimeType(String str) {
                this.mimeType = str;
                return this;
            }

            @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
            public Thumbnail set(String str, Object obj) {
                return (Thumbnail) super.set(str, obj);
            }

            @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
            public Thumbnail clone() {
                return (Thumbnail) super.clone();
            }
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public ContentHints set(String str, Object obj) {
            return (ContentHints) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public ContentHints clone() {
            return (ContentHints) super.clone();
        }
    }

    /* loaded from: classes2.dex */
    public static final class ImageMediaMetadata extends GenericJson {

        @Key
        private Float aperture;

        @Key
        private String cameraMake;

        @Key
        private String cameraModel;

        @Key
        private String colorSpace;

        @Key
        private Float exposureBias;

        @Key
        private String exposureMode;

        @Key
        private Float exposureTime;

        @Key
        private Boolean flashUsed;

        @Key
        private Float focalLength;

        @Key
        private Integer height;

        @Key
        private Integer isoSpeed;

        @Key
        private String lens;

        @Key
        private Location location;

        @Key
        private Float maxApertureValue;

        @Key
        private String meteringMode;

        @Key
        private Integer rotation;

        @Key
        private String sensor;

        @Key
        private Integer subjectDistance;

        @Key
        private String time;

        @Key
        private String whiteBalance;

        @Key
        private Integer width;

        public Float getAperture() {
            return this.aperture;
        }

        public String getCameraMake() {
            return this.cameraMake;
        }

        public String getCameraModel() {
            return this.cameraModel;
        }

        public String getColorSpace() {
            return this.colorSpace;
        }

        public Float getExposureBias() {
            return this.exposureBias;
        }

        public String getExposureMode() {
            return this.exposureMode;
        }

        public Float getExposureTime() {
            return this.exposureTime;
        }

        public Boolean getFlashUsed() {
            return this.flashUsed;
        }

        public Float getFocalLength() {
            return this.focalLength;
        }

        public Integer getHeight() {
            return this.height;
        }

        public Integer getIsoSpeed() {
            return this.isoSpeed;
        }

        public String getLens() {
            return this.lens;
        }

        public Location getLocation() {
            return this.location;
        }

        public Float getMaxApertureValue() {
            return this.maxApertureValue;
        }

        public String getMeteringMode() {
            return this.meteringMode;
        }

        public Integer getRotation() {
            return this.rotation;
        }

        public String getSensor() {
            return this.sensor;
        }

        public Integer getSubjectDistance() {
            return this.subjectDistance;
        }

        public String getTime() {
            return this.time;
        }

        public String getWhiteBalance() {
            return this.whiteBalance;
        }

        public Integer getWidth() {
            return this.width;
        }

        public ImageMediaMetadata setAperture(Float f2) {
            this.aperture = f2;
            return this;
        }

        public ImageMediaMetadata setCameraMake(String str) {
            this.cameraMake = str;
            return this;
        }

        public ImageMediaMetadata setCameraModel(String str) {
            this.cameraModel = str;
            return this;
        }

        public ImageMediaMetadata setColorSpace(String str) {
            this.colorSpace = str;
            return this;
        }

        public ImageMediaMetadata setExposureBias(Float f2) {
            this.exposureBias = f2;
            return this;
        }

        public ImageMediaMetadata setExposureMode(String str) {
            this.exposureMode = str;
            return this;
        }

        public ImageMediaMetadata setExposureTime(Float f2) {
            this.exposureTime = f2;
            return this;
        }

        public ImageMediaMetadata setFlashUsed(Boolean bool) {
            this.flashUsed = bool;
            return this;
        }

        public ImageMediaMetadata setFocalLength(Float f2) {
            this.focalLength = f2;
            return this;
        }

        public ImageMediaMetadata setHeight(Integer num) {
            this.height = num;
            return this;
        }

        public ImageMediaMetadata setIsoSpeed(Integer num) {
            this.isoSpeed = num;
            return this;
        }

        public ImageMediaMetadata setLens(String str) {
            this.lens = str;
            return this;
        }

        public ImageMediaMetadata setLocation(Location location) {
            this.location = location;
            return this;
        }

        public ImageMediaMetadata setMaxApertureValue(Float f2) {
            this.maxApertureValue = f2;
            return this;
        }

        public ImageMediaMetadata setMeteringMode(String str) {
            this.meteringMode = str;
            return this;
        }

        public ImageMediaMetadata setRotation(Integer num) {
            this.rotation = num;
            return this;
        }

        public ImageMediaMetadata setSensor(String str) {
            this.sensor = str;
            return this;
        }

        public ImageMediaMetadata setSubjectDistance(Integer num) {
            this.subjectDistance = num;
            return this;
        }

        public ImageMediaMetadata setTime(String str) {
            this.time = str;
            return this;
        }

        public ImageMediaMetadata setWhiteBalance(String str) {
            this.whiteBalance = str;
            return this;
        }

        public ImageMediaMetadata setWidth(Integer num) {
            this.width = num;
            return this;
        }

        /* loaded from: classes2.dex */
        public static final class Location extends GenericJson {

            @Key
            private Double altitude;

            @Key
            private Double latitude;

            @Key
            private Double longitude;

            public Double getAltitude() {
                return this.altitude;
            }

            public Double getLatitude() {
                return this.latitude;
            }

            public Double getLongitude() {
                return this.longitude;
            }

            public Location setAltitude(Double d2) {
                this.altitude = d2;
                return this;
            }

            public Location setLatitude(Double d2) {
                this.latitude = d2;
                return this;
            }

            public Location setLongitude(Double d2) {
                this.longitude = d2;
                return this;
            }

            @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
            public Location set(String str, Object obj) {
                return (Location) super.set(str, obj);
            }

            @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
            public Location clone() {
                return (Location) super.clone();
            }
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public ImageMediaMetadata set(String str, Object obj) {
            return (ImageMediaMetadata) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public ImageMediaMetadata clone() {
            return (ImageMediaMetadata) super.clone();
        }
    }

    public Map<String, String> getAppProperties() {
        return this.appProperties;
    }

    public Capabilities getCapabilities() {
        return this.capabilities;
    }

    public ContentHints getContentHints() {
        return this.contentHints;
    }

    public Boolean getCopyRequiresWriterPermission() {
        return this.copyRequiresWriterPermission;
    }

    public DateTime getCreatedTime() {
        return this.createdTime;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDriveId() {
        return this.driveId;
    }

    public Boolean getExplicitlyTrashed() {
        return this.explicitlyTrashed;
    }

    public Map<String, String> getExportLinks() {
        return this.exportLinks;
    }

    public String getFileExtension() {
        return this.fileExtension;
    }

    public String getFolderColorRgb() {
        return this.folderColorRgb;
    }

    public String getFullFileExtension() {
        return this.fullFileExtension;
    }

    public Boolean getHasAugmentedPermissions() {
        return this.hasAugmentedPermissions;
    }

    public Boolean getHasThumbnail() {
        return this.hasThumbnail;
    }

    public String getHeadRevisionId() {
        return this.headRevisionId;
    }

    public String getIconLink() {
        return this.iconLink;
    }

    public String getId() {
        return this.id;
    }

    public ImageMediaMetadata getImageMediaMetadata() {
        return this.imageMediaMetadata;
    }

    public Boolean getIsAppAuthorized() {
        return this.isAppAuthorized;
    }

    public String getKind() {
        return this.kind;
    }

    public User getLastModifyingUser() {
        return this.lastModifyingUser;
    }

    public String getMd5Checksum() {
        return this.md5Checksum;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public Boolean getModifiedByMe() {
        return this.modifiedByMe;
    }

    public DateTime getModifiedByMeTime() {
        return this.modifiedByMeTime;
    }

    public DateTime getModifiedTime() {
        return this.modifiedTime;
    }

    public String getName() {
        return this.name;
    }

    public String getOriginalFilename() {
        return this.originalFilename;
    }

    public Boolean getOwnedByMe() {
        return this.ownedByMe;
    }

    public List<User> getOwners() {
        return this.owners;
    }

    public List<String> getParents() {
        return this.parents;
    }

    public List<String> getPermissionIds() {
        return this.permissionIds;
    }

    public List<Permission> getPermissions() {
        return this.permissions;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public Long getQuotaBytesUsed() {
        return this.quotaBytesUsed;
    }

    public Boolean getShared() {
        return this.shared;
    }

    public DateTime getSharedWithMeTime() {
        return this.sharedWithMeTime;
    }

    public User getSharingUser() {
        return this.sharingUser;
    }

    public Long getSize() {
        return this.size;
    }

    public List<String> getSpaces() {
        return this.spaces;
    }

    public Boolean getStarred() {
        return this.starred;
    }

    public String getTeamDriveId() {
        return this.teamDriveId;
    }

    public String getThumbnailLink() {
        return this.thumbnailLink;
    }

    public Long getThumbnailVersion() {
        return this.thumbnailVersion;
    }

    public Boolean getTrashed() {
        return this.trashed;
    }

    public DateTime getTrashedTime() {
        return this.trashedTime;
    }

    public User getTrashingUser() {
        return this.trashingUser;
    }

    public Long getVersion() {
        return this.version;
    }

    public VideoMediaMetadata getVideoMediaMetadata() {
        return this.videoMediaMetadata;
    }

    public Boolean getViewedByMe() {
        return this.viewedByMe;
    }

    public DateTime getViewedByMeTime() {
        return this.viewedByMeTime;
    }

    public Boolean getViewersCanCopyContent() {
        return this.viewersCanCopyContent;
    }

    public String getWebContentLink() {
        return this.webContentLink;
    }

    public String getWebViewLink() {
        return this.webViewLink;
    }

    public Boolean getWritersCanShare() {
        return this.writersCanShare;
    }

    public File setAppProperties(Map<String, String> map) {
        this.appProperties = map;
        return this;
    }

    public File setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
        return this;
    }

    public File setContentHints(ContentHints contentHints) {
        this.contentHints = contentHints;
        return this;
    }

    public File setCopyRequiresWriterPermission(Boolean bool) {
        this.copyRequiresWriterPermission = bool;
        return this;
    }

    public File setCreatedTime(DateTime dateTime) {
        this.createdTime = dateTime;
        return this;
    }

    public File setDescription(String str) {
        this.description = str;
        return this;
    }

    public File setDriveId(String str) {
        this.driveId = str;
        return this;
    }

    public File setExplicitlyTrashed(Boolean bool) {
        this.explicitlyTrashed = bool;
        return this;
    }

    public File setExportLinks(Map<String, String> map) {
        this.exportLinks = map;
        return this;
    }

    public File setFileExtension(String str) {
        this.fileExtension = str;
        return this;
    }

    public File setFolderColorRgb(String str) {
        this.folderColorRgb = str;
        return this;
    }

    public File setFullFileExtension(String str) {
        this.fullFileExtension = str;
        return this;
    }

    public File setHasAugmentedPermissions(Boolean bool) {
        this.hasAugmentedPermissions = bool;
        return this;
    }

    public File setHasThumbnail(Boolean bool) {
        this.hasThumbnail = bool;
        return this;
    }

    public File setHeadRevisionId(String str) {
        this.headRevisionId = str;
        return this;
    }

    public File setIconLink(String str) {
        this.iconLink = str;
        return this;
    }

    public File setId(String str) {
        this.id = str;
        return this;
    }

    public File setImageMediaMetadata(ImageMediaMetadata imageMediaMetadata) {
        this.imageMediaMetadata = imageMediaMetadata;
        return this;
    }

    public File setIsAppAuthorized(Boolean bool) {
        this.isAppAuthorized = bool;
        return this;
    }

    public File setKind(String str) {
        this.kind = str;
        return this;
    }

    public File setLastModifyingUser(User user) {
        this.lastModifyingUser = user;
        return this;
    }

    public File setMd5Checksum(String str) {
        this.md5Checksum = str;
        return this;
    }

    public File setMimeType(String str) {
        this.mimeType = str;
        return this;
    }

    public File setModifiedByMe(Boolean bool) {
        this.modifiedByMe = bool;
        return this;
    }

    public File setModifiedByMeTime(DateTime dateTime) {
        this.modifiedByMeTime = dateTime;
        return this;
    }

    public File setModifiedTime(DateTime dateTime) {
        this.modifiedTime = dateTime;
        return this;
    }

    public File setName(String str) {
        this.name = str;
        return this;
    }

    public File setOriginalFilename(String str) {
        this.originalFilename = str;
        return this;
    }

    public File setOwnedByMe(Boolean bool) {
        this.ownedByMe = bool;
        return this;
    }

    public File setOwners(List<User> list) {
        this.owners = list;
        return this;
    }

    public File setParents(List<String> list) {
        this.parents = list;
        return this;
    }

    public File setPermissionIds(List<String> list) {
        this.permissionIds = list;
        return this;
    }

    public File setPermissions(List<Permission> list) {
        this.permissions = list;
        return this;
    }

    public File setProperties(Map<String, String> map) {
        this.properties = map;
        return this;
    }

    public File setQuotaBytesUsed(Long l) {
        this.quotaBytesUsed = l;
        return this;
    }

    public File setShared(Boolean bool) {
        this.shared = bool;
        return this;
    }

    public File setSharedWithMeTime(DateTime dateTime) {
        this.sharedWithMeTime = dateTime;
        return this;
    }

    public File setSharingUser(User user) {
        this.sharingUser = user;
        return this;
    }

    public File setSize(Long l) {
        this.size = l;
        return this;
    }

    public File setSpaces(List<String> list) {
        this.spaces = list;
        return this;
    }

    public File setStarred(Boolean bool) {
        this.starred = bool;
        return this;
    }

    public File setTeamDriveId(String str) {
        this.teamDriveId = str;
        return this;
    }

    public File setThumbnailLink(String str) {
        this.thumbnailLink = str;
        return this;
    }

    public File setThumbnailVersion(Long l) {
        this.thumbnailVersion = l;
        return this;
    }

    public File setTrashed(Boolean bool) {
        this.trashed = bool;
        return this;
    }

    public File setTrashedTime(DateTime dateTime) {
        this.trashedTime = dateTime;
        return this;
    }

    public File setTrashingUser(User user) {
        this.trashingUser = user;
        return this;
    }

    public File setVersion(Long l) {
        this.version = l;
        return this;
    }

    public File setVideoMediaMetadata(VideoMediaMetadata videoMediaMetadata) {
        this.videoMediaMetadata = videoMediaMetadata;
        return this;
    }

    public File setViewedByMe(Boolean bool) {
        this.viewedByMe = bool;
        return this;
    }

    public File setViewedByMeTime(DateTime dateTime) {
        this.viewedByMeTime = dateTime;
        return this;
    }

    public File setViewersCanCopyContent(Boolean bool) {
        this.viewersCanCopyContent = bool;
        return this;
    }

    public File setWebContentLink(String str) {
        this.webContentLink = str;
        return this;
    }

    public File setWebViewLink(String str) {
        this.webViewLink = str;
        return this;
    }

    public File setWritersCanShare(Boolean bool) {
        this.writersCanShare = bool;
        return this;
    }

    /* loaded from: classes2.dex */
    public static final class Capabilities extends GenericJson {

        @Key
        private Boolean canAddChildren;

        @Key
        private Boolean canChangeCopyRequiresWriterPermission;

        @Key
        private Boolean canChangeViewersCanCopyContent;

        @Key
        private Boolean canComment;

        @Key
        private Boolean canCopy;

        @Key
        private Boolean canDelete;

        @Key
        private Boolean canDeleteChildren;

        @Key
        private Boolean canDownload;

        @Key
        private Boolean canEdit;

        @Key
        private Boolean canListChildren;

        @Key
        private Boolean canMoveChildrenOutOfDrive;

        @Key
        private Boolean canMoveChildrenOutOfTeamDrive;

        @Key
        private Boolean canMoveChildrenWithinDrive;

        @Key
        private Boolean canMoveChildrenWithinTeamDrive;

        @Key
        private Boolean canMoveItemIntoTeamDrive;

        @Key
        private Boolean canMoveItemOutOfDrive;

        @Key
        private Boolean canMoveItemOutOfTeamDrive;

        @Key
        private Boolean canMoveItemWithinDrive;

        @Key
        private Boolean canMoveItemWithinTeamDrive;

        @Key
        private Boolean canMoveTeamDriveItem;

        @Key
        private Boolean canReadDrive;

        @Key
        private Boolean canReadRevisions;

        @Key
        private Boolean canReadTeamDrive;

        @Key
        private Boolean canRemoveChildren;

        @Key
        private Boolean canRename;

        @Key
        private Boolean canShare;

        @Key
        private Boolean canTrash;

        @Key
        private Boolean canTrashChildren;

        @Key
        private Boolean canUntrash;

        public Boolean getCanAddChildren() {
            return this.canAddChildren;
        }

        public Boolean getCanChangeCopyRequiresWriterPermission() {
            return this.canChangeCopyRequiresWriterPermission;
        }

        public Boolean getCanChangeViewersCanCopyContent() {
            return this.canChangeViewersCanCopyContent;
        }

        public Boolean getCanComment() {
            return this.canComment;
        }

        public Boolean getCanCopy() {
            return this.canCopy;
        }

        public Boolean getCanDelete() {
            return this.canDelete;
        }

        public Boolean getCanDeleteChildren() {
            return this.canDeleteChildren;
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

        public Boolean getCanMoveChildrenOutOfDrive() {
            return this.canMoveChildrenOutOfDrive;
        }

        public Boolean getCanMoveChildrenOutOfTeamDrive() {
            return this.canMoveChildrenOutOfTeamDrive;
        }

        public Boolean getCanMoveChildrenWithinDrive() {
            return this.canMoveChildrenWithinDrive;
        }

        public Boolean getCanMoveChildrenWithinTeamDrive() {
            return this.canMoveChildrenWithinTeamDrive;
        }

        public Boolean getCanMoveItemIntoTeamDrive() {
            return this.canMoveItemIntoTeamDrive;
        }

        public Boolean getCanMoveItemOutOfDrive() {
            return this.canMoveItemOutOfDrive;
        }

        public Boolean getCanMoveItemOutOfTeamDrive() {
            return this.canMoveItemOutOfTeamDrive;
        }

        public Boolean getCanMoveItemWithinDrive() {
            return this.canMoveItemWithinDrive;
        }

        public Boolean getCanMoveItemWithinTeamDrive() {
            return this.canMoveItemWithinTeamDrive;
        }

        public Boolean getCanMoveTeamDriveItem() {
            return this.canMoveTeamDriveItem;
        }

        public Boolean getCanReadDrive() {
            return this.canReadDrive;
        }

        public Boolean getCanReadRevisions() {
            return this.canReadRevisions;
        }

        public Boolean getCanReadTeamDrive() {
            return this.canReadTeamDrive;
        }

        public Boolean getCanRemoveChildren() {
            return this.canRemoveChildren;
        }

        public Boolean getCanRename() {
            return this.canRename;
        }

        public Boolean getCanShare() {
            return this.canShare;
        }

        public Boolean getCanTrash() {
            return this.canTrash;
        }

        public Boolean getCanTrashChildren() {
            return this.canTrashChildren;
        }

        public Boolean getCanUntrash() {
            return this.canUntrash;
        }

        public Capabilities setCanAddChildren(Boolean bool) {
            this.canAddChildren = bool;
            return this;
        }

        public Capabilities setCanChangeCopyRequiresWriterPermission(Boolean bool) {
            this.canChangeCopyRequiresWriterPermission = bool;
            return this;
        }

        public Capabilities setCanChangeViewersCanCopyContent(Boolean bool) {
            this.canChangeViewersCanCopyContent = bool;
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

        public Capabilities setCanDelete(Boolean bool) {
            this.canDelete = bool;
            return this;
        }

        public Capabilities setCanDeleteChildren(Boolean bool) {
            this.canDeleteChildren = bool;
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

        public Capabilities setCanMoveChildrenOutOfDrive(Boolean bool) {
            this.canMoveChildrenOutOfDrive = bool;
            return this;
        }

        public Capabilities setCanMoveChildrenOutOfTeamDrive(Boolean bool) {
            this.canMoveChildrenOutOfTeamDrive = bool;
            return this;
        }

        public Capabilities setCanMoveChildrenWithinDrive(Boolean bool) {
            this.canMoveChildrenWithinDrive = bool;
            return this;
        }

        public Capabilities setCanMoveChildrenWithinTeamDrive(Boolean bool) {
            this.canMoveChildrenWithinTeamDrive = bool;
            return this;
        }

        public Capabilities setCanMoveItemIntoTeamDrive(Boolean bool) {
            this.canMoveItemIntoTeamDrive = bool;
            return this;
        }

        public Capabilities setCanMoveItemOutOfDrive(Boolean bool) {
            this.canMoveItemOutOfDrive = bool;
            return this;
        }

        public Capabilities setCanMoveItemOutOfTeamDrive(Boolean bool) {
            this.canMoveItemOutOfTeamDrive = bool;
            return this;
        }

        public Capabilities setCanMoveItemWithinDrive(Boolean bool) {
            this.canMoveItemWithinDrive = bool;
            return this;
        }

        public Capabilities setCanMoveItemWithinTeamDrive(Boolean bool) {
            this.canMoveItemWithinTeamDrive = bool;
            return this;
        }

        public Capabilities setCanMoveTeamDriveItem(Boolean bool) {
            this.canMoveTeamDriveItem = bool;
            return this;
        }

        public Capabilities setCanReadDrive(Boolean bool) {
            this.canReadDrive = bool;
            return this;
        }

        public Capabilities setCanReadRevisions(Boolean bool) {
            this.canReadRevisions = bool;
            return this;
        }

        public Capabilities setCanReadTeamDrive(Boolean bool) {
            this.canReadTeamDrive = bool;
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

        public Capabilities setCanShare(Boolean bool) {
            this.canShare = bool;
            return this;
        }

        public Capabilities setCanTrash(Boolean bool) {
            this.canTrash = bool;
            return this;
        }

        public Capabilities setCanTrashChildren(Boolean bool) {
            this.canTrashChildren = bool;
            return this;
        }

        public Capabilities setCanUntrash(Boolean bool) {
            this.canUntrash = bool;
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
    public static final class VideoMediaMetadata extends GenericJson {

        @JsonString
        @Key
        private Long durationMillis;

        @Key
        private Integer height;

        @Key
        private Integer width;

        public Long getDurationMillis() {
            return this.durationMillis;
        }

        public Integer getHeight() {
            return this.height;
        }

        public Integer getWidth() {
            return this.width;
        }

        public VideoMediaMetadata setDurationMillis(Long l) {
            this.durationMillis = l;
            return this;
        }

        public VideoMediaMetadata setHeight(Integer num) {
            this.height = num;
            return this;
        }

        public VideoMediaMetadata setWidth(Integer num) {
            this.width = num;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public VideoMediaMetadata set(String str, Object obj) {
            return (VideoMediaMetadata) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public VideoMediaMetadata clone() {
            return (VideoMediaMetadata) super.clone();
        }
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public File set(String str, Object obj) {
        return (File) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public File clone() {
        return (File) super.clone();
    }
}
