package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;
import com.adobe.creativesdk.foundation.adobeinternal.analytics.AdobeAnalyticsEventParams;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloudServiceType;
import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheOptions;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAssetRendition;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.URI;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AdobePhotoAsset extends AdobePhoto implements Externalizable {
    public static final String AdobePhotoAssetRenditionImage1024 = "1024";
    public static final String AdobePhotoAssetRenditionImage2048 = "2048";
    public static final String AdobePhotoAssetRenditionImageFavorite = "favorite";
    public static final String AdobePhotoAssetRenditionImageFullSize = "fullsize";
    public static final String AdobePhotoAssetRenditionImagePreview = "preview";
    public static final String AdobePhotoAssetRenditionImageThumbnail = "144h";
    public static final String AdobePhotoAssetRenditionImageThumbnail2x = "thumbnail2x";
    private AdobePhotoCatalog _catalog;
    private String _contentType;
    private AdobePhotoAssetRevision _latestRevision;
    private JSONObject _metadata;
    private String _name;
    private String _order;
    private Map<String, AdobePhotoAssetRendition> _renditions;
    private AdobePhotoAssetRevision _revision;
    private long _size;
    private AdobePhotoAssetType _type;
    private com.adobe.creativesdk.foundation.internal.net.E _uploadRequestHandle = null;
    private com.adobe.creativesdk.foundation.internal.net.H _progressListener = null;
    private com.adobe.creativesdk.foundation.internal.net.E _downloadRequestHandle = null;
    private com.adobe.creativesdk.foundation.internal.net.H _downloadProgressListener = null;

    /* loaded from: classes.dex */
    public enum AdobePhotoAssetType {
        AdobePhotoAssetTypeImage(0);

        private int _val;

        AdobePhotoAssetType(int i) {
            this._val = i;
        }

        public int getValue() {
            return this._val;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AdobePhotoAsset() {
    }

    static AdobePhotoAsset create(String str, AdobePhotoCatalog adobePhotoCatalog, URI uri, String str2, sd<AdobePhotoAsset, AdobePhotoException> sdVar) {
        if (adobePhotoCatalog == null) {
            sdVar.a((sd<AdobePhotoAsset, AdobePhotoException>) new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE));
            return null;
        }
        AdobePhotoAsset adobePhotoAsset = new AdobePhotoAsset(str, null, adobePhotoCatalog);
        com.adobe.creativesdk.foundation.internal.storage.photo.F f2 = (com.adobe.creativesdk.foundation.internal.storage.photo.F) adobePhotoCatalog.getCloud().getSessionForService(AdobeCloudServiceType.AdobeCloudServiceTypePhoto);
        if (f2 == null) {
            return null;
        }
        adobePhotoAsset._uploadRequestHandle = null;
        adobePhotoAsset._progressListener = new C0580lc(sdVar);
        adobePhotoAsset._uploadRequestHandle = f2.a(adobePhotoAsset, adobePhotoCatalog, uri, str2, new C0627xc(sdVar), new C0631yc(adobePhotoAsset, sdVar, str));
        adobePhotoAsset._uploadRequestHandle.a(adobePhotoAsset._progressListener);
        return adobePhotoAsset;
    }

    void addRenditionLink(JSONObject jSONObject, AdobePhotoAssetRendition.AdobePhotoAssetRenditionType adobePhotoAssetRenditionType, Map<String, AdobePhotoAssetRendition> map, String str) {
        if (jSONObject != null) {
            map.put(str, new AdobePhotoAssetRendition(URI.create(jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_HREF, null)), adobePhotoAssetRenditionType));
        }
    }

    public void cancelCreationRequest() {
        cancelUploadRequest();
    }

    public void cancelDownloadRequest() {
        com.adobe.creativesdk.foundation.internal.net.E e2 = this._downloadRequestHandle;
        if (e2 != null) {
            com.adobe.creativesdk.foundation.internal.net.H h2 = this._downloadProgressListener;
            if (h2 != null) {
                e2.b(h2);
                this._downloadProgressListener = null;
            }
            this._downloadRequestHandle.a();
            this._downloadRequestHandle = null;
        }
    }

    public void cancelUploadRequest() {
        com.adobe.creativesdk.foundation.internal.net.E e2 = this._uploadRequestHandle;
        if (e2 != null) {
            com.adobe.creativesdk.foundation.internal.net.H h2 = this._progressListener;
            if (h2 != null) {
                e2.b(h2);
                this._progressListener = null;
            }
            this._uploadRequestHandle.a();
            this._uploadRequestHandle = null;
        }
    }

    public void delete(vd vdVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        com.adobe.creativesdk.foundation.internal.analytics.l lVar = new com.adobe.creativesdk.foundation.internal.analytics.l(AdobeAnalyticsEventParams.Type.AdobeEventTypeAppDelete.getValue());
        lVar.a(getCloud());
        lVar.a(this._GUID, this._name, "", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO, "" + this._size);
        if (c.a.a.a.a.a.a.b().b(new C0540bc(this, cVar), "Delete requires an authenticated user.")) {
            return;
        }
        C0544cc c0544cc = new C0544cc(this, lVar, vdVar);
        C0548dc c0548dc = new C0548dc(this, lVar, cVar);
        if (getSession() == null) {
            return;
        }
        getSession().a(this, c0544cc, c0548dc);
    }

    public void downloadMasterData(sd<byte[], AdobePhotoException> sdVar) {
        Handler handler;
        AdobePhotoAssetRevision adobePhotoAssetRevision = this._revision;
        String format = String.format("%s-master", adobePhotoAssetRevision == null ? "(null)" : adobePhotoAssetRevision.getGUID());
        C0603rc c0603rc = new C0603rc(this, sdVar, format);
        try {
            handler = new Handler();
        } catch (Exception unused) {
            handler = null;
        }
        if (com.adobe.creativesdk.foundation.internal.cache.d.b().a(this._GUID, format, EnumSet.of(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache), "com.adobe.cc.photo", c0603rc, handler)) {
            return;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, AdobePhotoAsset.class.getSimpleName(), "Request for cache com.adobe.cc.photoended in Error");
        sdVar.a((sd<byte[], AdobePhotoException>) new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_FILE_READ_FAILURE));
    }

    public void downloadRendition(AdobePhotoAssetRendition adobePhotoAssetRendition, sd<byte[], AdobePhotoException> sdVar) {
        Handler handler;
        AdobePhotoAssetRevision adobePhotoAssetRevision = this._revision;
        String format = String.format("%s_%s_%s", adobePhotoAssetRendition.getGUID(), adobePhotoAssetRevision == null ? "(null)" : adobePhotoAssetRevision.getGUID(), Integer.valueOf(adobePhotoAssetRendition.getType().getValue()));
        C0623wc c0623wc = new C0623wc(this, sdVar, format, adobePhotoAssetRendition);
        try {
            handler = new Handler();
        } catch (Exception unused) {
            handler = null;
        }
        if (com.adobe.creativesdk.foundation.internal.cache.d.b().a(this._GUID, format, EnumSet.of(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache), "com.adobe.cc.photo", c0623wc, handler)) {
            return;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, AdobePhotoAsset.class.getSimpleName(), "Request for cache com.adobe.cc.photoended in Error");
        sdVar.a((sd<byte[], AdobePhotoException>) new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_FILE_READ_FAILURE));
    }

    public AdobePhotoCatalog getCatalog() {
        return this._catalog;
    }

    @Override // com.adobe.creativesdk.foundation.storage.AdobePhoto
    public AdobeCloud getCloud() {
        return super.getCloud();
    }

    public String getContentType() {
        return this._contentType;
    }

    public AdobePhotoAssetRevision getLatestRevision() {
        return this._latestRevision;
    }

    public JSONObject getMetadata() {
        return this._metadata;
    }

    public String getName() {
        return this._name;
    }

    public String getOrder() {
        return this._order;
    }

    public Map<String, AdobePhotoAssetRendition> getRenditions() {
        return this._renditions;
    }

    public AdobePhotoAssetRevision getRevision() {
        return this._revision;
    }

    public long getSize() {
        return this._size;
    }

    public AdobePhotoAssetType getType() {
        return this._type;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleCommonDownloadCompletionBookKeeping() {
        com.adobe.creativesdk.foundation.internal.net.E e2 = this._downloadRequestHandle;
        if (e2 != null) {
            e2.b(this._downloadProgressListener);
        }
        this._downloadRequestHandle = null;
        this._downloadProgressListener = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleCommonUploadCompletionBookKeeping() {
        com.adobe.creativesdk.foundation.internal.net.E e2 = this._uploadRequestHandle;
        if (e2 != null) {
            e2.b(this._progressListener);
        }
        this._uploadRequestHandle = null;
        this._progressListener = null;
    }

    public boolean isEqualToAsset(AdobePhotoAsset adobePhotoAsset) {
        return this._GUID.equals(adobePhotoAsset._GUID) && this._catalog.isEqualToCatalog(adobePhotoAsset._catalog);
    }

    @Override // com.adobe.creativesdk.foundation.storage.AdobePhoto, java.io.Externalizable
    @Deprecated
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        super.readExternal(objectInput);
        this._name = (String) objectInput.readObject();
        this._catalog = (AdobePhotoCatalog) objectInput.readObject();
        this._contentType = (String) objectInput.readObject();
        try {
            this._metadata = new JSONObject((String) objectInput.readObject());
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobePhotoAsset.readExternal", e2.getMessage());
        }
        this._latestRevision = (AdobePhotoAssetRevision) objectInput.readObject();
        this._revision = (AdobePhotoAssetRevision) objectInput.readObject();
        this._renditions = (Map) objectInput.readObject();
        this._order = (String) objectInput.readObject();
        this._size = objectInput.readLong();
        this._type = AdobePhotoAssetType.values()[objectInput.readInt()];
    }

    public void refresh(c.a.a.a.b<AdobePhotoAsset> bVar, c.a.a.a.c<AdobePhotoException> cVar) {
        Dc dc = new Dc(this, bVar);
        Ec ec = new Ec(this, cVar);
        if (getSession() == null) {
            return;
        }
        getSession().c(this, dc, ec);
    }

    void setCatalog(AdobePhotoCatalog adobePhotoCatalog) {
        this._catalog = adobePhotoCatalog;
    }

    void setContentType(String str) {
        this._contentType = str;
    }

    void setLatestRevision(AdobePhotoAssetRevision adobePhotoAssetRevision) {
        this._latestRevision = adobePhotoAssetRevision;
    }

    void setMetadata(JSONObject jSONObject) {
        this._metadata = jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setName(String str) {
        this._name = str;
    }

    void setOrder(String str) {
        this._order = str;
    }

    public void setRenditions(Map<String, AdobePhotoAssetRendition> map) {
        this._renditions = map;
    }

    void setRevision(AdobePhotoAssetRevision adobePhotoAssetRevision) {
        this._revision = adobePhotoAssetRevision;
    }

    void setSize(long j) {
        this._size = j;
    }

    void setType(AdobePhotoAssetType adobePhotoAssetType) {
        this._type = adobePhotoAssetType;
    }

    boolean updateFromData(String str, AdobePhotoCatalog adobePhotoCatalog) throws AdobePhotoException {
        JSONObject a2 = c.a.a.a.c.e.b.a(str);
        if (a2 != null) {
            return updateFromDictionary(a2, adobePhotoCatalog);
        }
        throw new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE, null, "Parsed asset data is not of type dictionary.");
    }

    public boolean updateFromDictionary(JSONObject jSONObject, AdobePhotoCatalog adobePhotoCatalog) throws AdobePhotoException {
        Date date;
        if (jSONObject.optString("id", null) != null) {
            this._internalID = jSONObject.optString("id", null);
        }
        if (jSONObject.optString("_id", null) != null) {
            this._GUID = jSONObject.optString("_id", null);
        }
        if (jSONObject.opt("created") != null) {
            this._creationDate = com.adobe.creativesdk.foundation.internal.storage.model.util.i.b(jSONObject.optString("created"));
        }
        if (jSONObject.opt("updated") != null) {
            this._modificationDate = com.adobe.creativesdk.foundation.internal.storage.model.util.i.b(jSONObject.optString("updated"));
        }
        if (this._modificationDate == null && (date = this._creationDate) != null) {
            this._modificationDate = date;
        }
        this._catalog = adobePhotoCatalog;
        this._cloud = adobePhotoCatalog.getCloud();
        String optString = jSONObject.optString("subtype", null);
        if (optString != null && optString.equals("jpeg")) {
            this._type = AdobePhotoAssetType.AdobePhotoAssetTypeImage;
        }
        if (jSONObject.optString("order", null) != null) {
            this._order = jSONObject.optString("order", null);
        }
        this._metadata = jSONObject.optJSONObject(MessengerShareContentUtility.ATTACHMENT_PAYLOAD);
        JSONObject jSONObject2 = this._metadata;
        if (jSONObject2 != null) {
            JSONObject optJSONObject = jSONObject2.optJSONObject("importSource");
            if (optJSONObject != null) {
                this._name = optJSONObject.optString("fileName", null);
                this._size = optJSONObject.optLong("fileSize");
                this._contentType = optJSONObject.optString("contentType", null);
            }
        } else {
            this._metadata = new JSONObject();
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("links");
        if (optJSONObject2 != null) {
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("self");
            if (optJSONObject3 != null) {
                this._href = optJSONObject3.optString(ShareConstants.WEB_DIALOG_PARAM_HREF, null);
            }
            JSONObject optJSONObject4 = optJSONObject2.optJSONObject("/rels/latest_revision");
            if (optJSONObject4 != null) {
                this._latestRevision = new AdobePhotoAssetRevision(optJSONObject4.optString(ShareConstants.WEB_DIALOG_PARAM_HREF, null), false);
                this._revision = this._latestRevision;
            }
            JSONObject optJSONObject5 = optJSONObject2.optJSONObject("/rels/master");
            if (optJSONObject5 != null && this._contentType == null) {
                this._contentType = optJSONObject5.optString("content_type", null);
            }
            HashMap hashMap = new HashMap();
            addRenditionLink(optJSONObject2.optJSONObject("/rels/rendition_type/144h"), AdobePhotoAssetRendition.AdobePhotoAssetRenditionType.ADOBE_PHOTO_ASSET_RENDITION_TYPE_IMAGE_THUMBNAIL, hashMap, AdobePhotoAssetRenditionImageThumbnail);
            addRenditionLink(optJSONObject2.optJSONObject("/rels/rendition_type/thumbnail2x"), AdobePhotoAssetRendition.AdobePhotoAssetRenditionType.ADOBE_PHOTO_ASSET_RENDITION_TYPE_IMAGE_THUMBNAIL_2X, hashMap, AdobePhotoAssetRenditionImageThumbnail2x);
            addRenditionLink(optJSONObject2.optJSONObject("/rels/rendition_type/2048"), AdobePhotoAssetRendition.AdobePhotoAssetRenditionType.ADOBE_PHOTO_ASSET_RENDITION_TYPE_IMAGE_2048, hashMap, AdobePhotoAssetRenditionImage2048);
            addRenditionLink(optJSONObject2.optJSONObject("/rels/rendition_type/1024"), AdobePhotoAssetRendition.AdobePhotoAssetRenditionType.ADOBE_PHOTO_ASSET_RENDITION_TYPE_IMAGE_1024, hashMap, AdobePhotoAssetRenditionImage1024);
            addRenditionLink(optJSONObject2.optJSONObject("/rels/rendition_type/fullsize"), AdobePhotoAssetRendition.AdobePhotoAssetRenditionType.ADOBE_PHOTO_ASSET_RENDITION_TYPE_IMAGE_FULL_SIZE, hashMap, AdobePhotoAssetRenditionImageFullSize);
            addRenditionLink(optJSONObject2.optJSONObject("/rels/rendition_type/favorite"), AdobePhotoAssetRendition.AdobePhotoAssetRenditionType.ADOBE_PHOTO_ASSET_RENDITION_TYPE_IMAGE_FAVORITE, hashMap, AdobePhotoAssetRenditionImageFavorite);
            addRenditionLink(optJSONObject2.optJSONObject("/rels/rendition_type/preview"), AdobePhotoAssetRendition.AdobePhotoAssetRenditionType.ADOBE_PHOTO_ASSET_RENDITION_TYPE_IMAGE_PREVIEW, hashMap, AdobePhotoAssetRenditionImagePreview);
            this._renditions = hashMap;
            return true;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, AdobePhotoAsset.class.getSimpleName(), "Asset doesn't have any links.");
        this._href = null;
        return true;
    }

    public void uploadMasterDataFromPath(URI uri, boolean z, sd<AdobePhotoAsset, AdobeCSDKException> sdVar) {
        if (c.a.a.a.a.a.a.b().b(new C0552ec(this, sdVar), "Upload requires an authenticated user.")) {
            return;
        }
        this._uploadRequestHandle = null;
        this._progressListener = new C0556fc(this, sdVar);
        C0560gc c0560gc = new C0560gc(this, sdVar);
        C0564hc c0564hc = new C0564hc(this, sdVar);
        if (getSession() == null) {
            return;
        }
        this._uploadRequestHandle = getSession().a(this, uri, z, c0560gc, c0564hc);
        this._uploadRequestHandle.a(this._progressListener);
    }

    public void uploadRendition(AdobePhotoAssetRendition adobePhotoAssetRendition, sd<AdobePhotoAsset, AdobeCSDKException> sdVar) {
        if (c.a.a.a.a.a.a.b().b(new C0568ic(this, sdVar), "Upload requires an authenticated user.")) {
            return;
        }
        this._uploadRequestHandle = null;
        this._progressListener = new C0572jc(this, sdVar);
        C0576kc c0576kc = new C0576kc(this, sdVar);
        C0584mc c0584mc = new C0584mc(this, sdVar);
        if (getSession() == null) {
            return;
        }
        this._uploadRequestHandle = getSession().b(adobePhotoAssetRendition, this, c0576kc, c0584mc);
        this._uploadRequestHandle.a(this._progressListener);
    }

    @Override // com.adobe.creativesdk.foundation.storage.AdobePhoto, java.io.Externalizable
    @Deprecated
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        super.writeExternal(objectOutput);
        objectOutput.writeObject(this._name);
        objectOutput.writeObject(this._catalog);
        objectOutput.writeObject(this._contentType);
        objectOutput.writeObject(this._metadata.toString());
        objectOutput.writeObject(this._latestRevision);
        objectOutput.writeObject(this._revision);
        objectOutput.writeObject(this._renditions);
        objectOutput.writeObject(this._order);
        objectOutput.writeLong(this._size);
        objectOutput.writeInt(this._type.getValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AdobePhotoAsset(String str, String str2, AdobePhotoCatalog adobePhotoCatalog) {
        str2 = str2 == null ? c.a.a.a.c.e.b.a() : str2;
        this._GUID = str2;
        this._href = "/v1.0/catalogs/" + adobePhotoCatalog.getGUID() + "/assets/" + str2;
        this._catalog = adobePhotoCatalog;
        this._cloud = adobePhotoCatalog.getCloud();
        this._name = str;
        this._order = null;
        this._renditions = new HashMap();
        this._metadata = new JSONObject();
        this._type = null;
    }

    public static AdobePhotoAsset create(String str, AdobePhotoCollection adobePhotoCollection, URI uri, String str2, sd<AdobePhotoAsset, AdobeCSDKException> sdVar) {
        if (c.a.a.a.a.a.a.b().b(new C0635zc(sdVar), "Create requires an authenticated user.")) {
            return null;
        }
        if (adobePhotoCollection == null) {
            sdVar.a((sd<AdobePhotoAsset, AdobeCSDKException>) new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE, null, "Input Validation failed"));
            return null;
        }
        AdobePhotoAsset adobePhotoAsset = new AdobePhotoAsset(str, null, adobePhotoCollection.getCatalog());
        com.adobe.creativesdk.foundation.internal.storage.photo.F f2 = (com.adobe.creativesdk.foundation.internal.storage.photo.F) adobePhotoCollection.getCloud().getSessionForService(AdobeCloudServiceType.AdobeCloudServiceTypePhoto);
        if (f2 == null) {
            return null;
        }
        adobePhotoAsset._uploadRequestHandle = null;
        adobePhotoAsset._progressListener = new Ac(sdVar);
        com.adobe.creativesdk.foundation.internal.analytics.l lVar = new com.adobe.creativesdk.foundation.internal.analytics.l(AdobeAnalyticsEventParams.Type.AdobeEventTypeAppCreate.getValue());
        lVar.a(adobePhotoAsset.getCloud());
        lVar.a(adobePhotoAsset._GUID, adobePhotoAsset._name, "", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO, "" + adobePhotoAsset._size);
        adobePhotoAsset._uploadRequestHandle = f2.a(adobePhotoAsset, adobePhotoCollection, uri, str2, new Bc(lVar, sdVar), new Cc(adobePhotoAsset, lVar, sdVar, str));
        adobePhotoAsset._uploadRequestHandle.a(adobePhotoAsset._progressListener);
        return adobePhotoAsset;
    }
}
