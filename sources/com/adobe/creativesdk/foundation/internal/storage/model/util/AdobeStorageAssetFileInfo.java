package com.adobe.creativesdk.foundation.internal.storage.model.util;

import android.net.Uri;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.internal.storage.AdobeAssetFileInternal;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAsset;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAssetRendition;
import java.io.Serializable;
import java.net.URI;
import java.util.Date;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AdobeStorageAssetFileInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public String GUID;
    public AdobeCloud cloud;
    public Date creationDate;
    public int currentVersion;
    public String etag;
    public long fileSize;
    public String hlsHref;
    public URI href;
    public String links;
    public String md5Hash;
    public Date modificationDate;
    public String name;
    private String optionalMetadata;
    public URI parentHref;
    public Map<String, AdobePhotoAssetRendition> photoAssetRenditionMap;
    public String type;

    public AdobeStorageAssetFileInfo(AdobeAssetFile adobeAssetFile) {
        this.GUID = adobeAssetFile.getGUID();
        this.href = adobeAssetFile.getHref();
        this.parentHref = adobeAssetFile.getParentHref();
        this.etag = adobeAssetFile.getEtag();
        this.name = adobeAssetFile.getName();
        this.creationDate = adobeAssetFile.getCreationDate();
        this.modificationDate = adobeAssetFile.getModificationDate();
        this.type = adobeAssetFile.getType();
        this.md5Hash = adobeAssetFile.getMd5Hash();
        this.fileSize = adobeAssetFile.getFileSize();
        this.currentVersion = adobeAssetFile.getCurrentVersion();
        this.hlsHref = adobeAssetFile instanceof AdobeAssetFileInternal ? ((AdobeAssetFileInternal) adobeAssetFile).getHlsHref() : null;
        if (adobeAssetFile.getLinks() != null) {
            this.links = adobeAssetFile.getLinks().toString();
        }
        JSONObject optionalMetadata = adobeAssetFile.getOptionalMetadata();
        if (optionalMetadata != null) {
            this.optionalMetadata = optionalMetadata.toString();
        }
        this.cloud = adobeAssetFile.getCloud();
    }

    public JSONObject getLinks() {
        String str = this.links;
        if (str == null) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public JSONObject getOptionalMetadata() {
        String str = this.optionalMetadata;
        if (str == null) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public AdobeStorageAssetFileInfo(AdobePhotoAsset adobePhotoAsset) {
        this.GUID = adobePhotoAsset.getGUID();
        try {
            this.href = new URI(Uri.parse(adobePhotoAsset.getHref()).toString());
            this.parentHref = new URI(Uri.parse(adobePhotoAsset.getBaseHref()).toString());
        } catch (Exception unused) {
        }
        this.name = adobePhotoAsset.getName();
        this.creationDate = adobePhotoAsset.getCreationDate();
        this.modificationDate = adobePhotoAsset.getModificationDate();
        this.type = adobePhotoAsset.getType().toString();
        this.fileSize = adobePhotoAsset.getSize();
        JSONObject metadata = adobePhotoAsset.getMetadata();
        if (metadata != null) {
            this.optionalMetadata = metadata.toString();
        }
        this.cloud = adobePhotoAsset.getCloud();
        this.photoAssetRenditionMap = adobePhotoAsset.getRenditions();
    }
}
