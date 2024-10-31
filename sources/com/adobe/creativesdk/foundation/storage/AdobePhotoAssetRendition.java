package com.adobe.creativesdk.foundation.storage;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class AdobePhotoAssetRendition implements Externalizable {
    private String _GUID;
    private URI _dataPath;
    private AdobePhotoAssetRenditionType _type;

    /* loaded from: classes.dex */
    public enum AdobePhotoAssetRenditionType {
        ADOBE_PHOTO_ASSET_RENDITION_TYPE_IMAGE_FULL_SIZE(0),
        ADOBE_PHOTO_ASSET_RENDITION_TYPE_IMAGE_FAVORITE(1),
        ADOBE_PHOTO_ASSET_RENDITION_TYPE_IMAGE_PREVIEW(2),
        ADOBE_PHOTO_ASSET_RENDITION_TYPE_IMAGE_2048(3),
        ADOBE_PHOTO_ASSET_RENDITION_TYPE_IMAGE_1024(4),
        ADOBE_PHOTO_ASSET_RENDITION_TYPE_IMAGE_THUMBNAIL_2X(5),
        ADOBE_PHOTO_ASSET_RENDITION_TYPE_IMAGE_THUMBNAIL(6);

        private int _val;

        AdobePhotoAssetRenditionType(int i) {
            this._val = i;
        }

        public int getValue() {
            return this._val;
        }
    }

    public AdobePhotoAssetRendition() {
    }

    public AdobePhotoAssetRendition getCopy() {
        return new AdobePhotoAssetRendition(this._GUID, this._dataPath, this._type);
    }

    public URI getDataPath() {
        return this._dataPath;
    }

    public String getGUID() {
        return this._GUID;
    }

    public AdobePhotoAssetRenditionType getType() {
        return this._type;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this._GUID = (String) objectInput.readObject();
        this._dataPath = (URI) objectInput.readObject();
        this._type = AdobePhotoAssetRenditionType.values()[objectInput.readInt()];
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(this._GUID);
        objectOutput.writeObject(this._dataPath);
        objectOutput.writeInt(this._type.getValue());
    }

    public AdobePhotoAssetRendition(URI uri, AdobePhotoAssetRenditionType adobePhotoAssetRenditionType) {
        this._dataPath = uri;
        this._type = adobePhotoAssetRenditionType;
        this._GUID = c.a.a.a.c.e.b.a();
    }

    AdobePhotoAssetRendition(String str, URI uri, AdobePhotoAssetRenditionType adobePhotoAssetRenditionType) {
        this._GUID = str;
        this._dataPath = uri;
        this._type = adobePhotoAssetRenditionType;
    }

    AdobePhotoAssetRendition(String str, AdobePhotoAssetRevision adobePhotoAssetRevision, AdobePhotoAssetRenditionType adobePhotoAssetRenditionType) {
        this._GUID = str;
        this._dataPath = null;
        this._type = adobePhotoAssetRenditionType;
    }

    AdobePhotoAssetRendition(String str, AdobePhotoAssetRenditionType adobePhotoAssetRenditionType) {
        Matcher matcher = Pattern.compile("/revisions/(.\\\\w+)/renditions/(.\\\\w+)$", 2).matcher(str);
        matcher.region(0, str.length());
        if (matcher.find() && matcher.groupCount() == 2) {
            this._GUID = matcher.group(2);
        }
        this._dataPath = URI.create(str);
        this._type = adobePhotoAssetRenditionType;
    }
}
