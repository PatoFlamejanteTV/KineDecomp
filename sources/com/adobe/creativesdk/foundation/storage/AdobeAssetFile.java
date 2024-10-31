package com.adobe.creativesdk.foundation.storage;

import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import com.adobe.creativesdk.foundation.adobeinternal.analytics.AdobeAnalyticsEventParams;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeEntitlementServices;
import com.adobe.creativesdk.foundation.adobeinternal.entitlement.AdobeEntitlementException;
import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheOptions;
import com.adobe.creativesdk.foundation.internal.storage.AdobeAssetFileInternal;
import com.adobe.creativesdk.foundation.internal.storage.model.util.AdobeStorageAssetFileInfo;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.io.Externalizable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AdobeAssetFile extends C0533a implements Externalizable {
    public static final String STREAMING_VIDEO_TYPE = "application/vnd.adobe.ccv.videometadata";
    protected static final C0582ma THUMBNAIL_SIZED_RENDITION = new C0582ma(250.0f, 250.0f);
    protected transient com.adobe.creativesdk.foundation.internal.storage.model.resources.f asrItem;
    protected int currentVersion;
    protected transient com.adobe.creativesdk.foundation.internal.net.j dataRequest;
    protected long fileSize;
    protected String md5Hash;
    protected JSONObject optionalMetadata;
    protected boolean pendingRendRequestCancellation;
    protected transient com.adobe.creativesdk.foundation.internal.net.E renditionRequest;
    protected String type;
    protected transient com.adobe.creativesdk.foundation.internal.net.j uploadRequest;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdobeAssetFile(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar) {
        this.asrItem = fVar;
        this.GUID = fVar.f6609a;
        this.href = fVar.f6610b;
        this.etag = fVar.f6613e;
        this.name = fVar.f6611c;
        this.mCloud = fVar.a();
        this.parentHref = eVar.f6610b;
        this.creationDate = com.adobe.creativesdk.foundation.internal.storage.model.util.i.b(fVar.f6614f);
        this.modificationDate = com.adobe.creativesdk.foundation.internal.storage.model.util.i.b(fVar.f6615g);
        this.type = fVar.f6612d;
        this.links = fVar.j;
        this.pendingRendRequestCancellation = false;
        String str = this.type;
        if (str != null && str.startsWith("application/vnd.adobe.file+json") && fVar.h().has("content-type")) {
            if (!this.type.equals("application/vnd.adobe.file+json")) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, "AdobeAssetFile", "Ignoring additional information in type: " + this.type);
            }
            try {
                this.type = fVar.h().getString("content-type");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (fVar.e() != null) {
            this.fileSize = fVar.e().intValue();
        }
        this.md5Hash = fVar.f();
        this.optionalMetadata = fVar.h();
    }

    static AdobeAssetFile AdobeAssetFileFromInfo(AdobeStorageAssetFileInfo adobeStorageAssetFileInfo) {
        AdobeAssetFileInternal adobeAssetFileInternal = new AdobeAssetFileInternal();
        adobeAssetFileInternal.GUID = adobeStorageAssetFileInfo.GUID;
        adobeAssetFileInternal.href = adobeStorageAssetFileInfo.href;
        adobeAssetFileInternal.parentHref = adobeStorageAssetFileInfo.parentHref;
        adobeAssetFileInternal.etag = adobeStorageAssetFileInfo.etag;
        adobeAssetFileInternal.name = adobeStorageAssetFileInfo.name;
        adobeAssetFileInternal.creationDate = adobeStorageAssetFileInfo.creationDate;
        adobeAssetFileInternal.modificationDate = adobeStorageAssetFileInfo.modificationDate;
        adobeAssetFileInternal.type = adobeStorageAssetFileInfo.type;
        adobeAssetFileInternal.md5Hash = adobeStorageAssetFileInfo.md5Hash;
        adobeAssetFileInternal.fileSize = adobeStorageAssetFileInfo.fileSize;
        adobeAssetFileInternal.currentVersion = adobeStorageAssetFileInfo.currentVersion;
        adobeAssetFileInternal.optionalMetadata = adobeStorageAssetFileInfo.getOptionalMetadata();
        adobeAssetFileInternal.links = adobeStorageAssetFileInfo.getLinks();
        adobeAssetFileInternal.hlsHref = adobeStorageAssetFileInfo.hlsHref;
        return adobeAssetFileInternal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(URL url, String str, boolean z, sd<AdobeAssetFile, AdobeCSDKException> sdVar, Handler handler) {
        String file;
        try {
            file = URLDecoder.decode(URLEncoder.encode(url.getFile(), "UTF-8"), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            file = url.getFile();
        }
        File file2 = new File(file);
        long length = file2.exists() ? file2.length() : 0L;
        com.adobe.creativesdk.foundation.internal.analytics.d dVar = new com.adobe.creativesdk.foundation.internal.analytics.d((z ? AdobeAnalyticsEventParams.Type.AdobeEventTypeAppUpdate : AdobeAnalyticsEventParams.Type.AdobeEventTypeAppCreate).getValue(), str);
        dVar.a(this.etag, this.name, "", str, "" + length);
        if (c.a.a.a.a.a.a.b().b(new D(this, sdVar, handler), "Update requires an authenticated user.")) {
            return;
        }
        this.asrItem.d(file);
        this.type = str;
        com.adobe.creativesdk.foundation.internal.storage.a.b.ra session = getSession();
        if (session == null) {
            return;
        }
        this.uploadRequest = session.a(resourceItem(), z, new F(this, dVar, str, sdVar, this), handler);
    }

    private void b(AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma, int i, sd<byte[], AdobeAssetException> sdVar) {
        C0632z c0632z = new C0632z(this);
        try {
            c0632z.f7482a = new Handler();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (com.adobe.creativesdk.foundation.internal.cache.d.b().a(a(), a(adobeAssetFileRenditionType, c0582ma, i), EnumSet.of(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache), "com.adobe.cc.storage", new U(this, sdVar, adobeAssetFileRenditionType, c0582ma, i, c0632z), c0632z.f7482a)) {
            return;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeAssetFile:GetRenditionFromCache", String.format("Rendition request for %s ended in error.", this.href));
        sdVar.a((sd<byte[], AdobeAssetException>) null);
    }

    public static AdobeAssetFile create(String str, C0578la c0578la, URL url, String str2, sd<AdobeAssetFile, AdobeCSDKException> sdVar, Handler handler) {
        return create(str, c0578la, com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e().c(), url, str2, sdVar, handler);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static AdobeAssetFile createFromStream(String str, C0578la c0578la, AdobeCloud adobeCloud, InputStream inputStream, String str2, sd<AdobeAssetFile, AdobeCSDKException> sdVar, Handler handler) {
        String str3;
        AdobeAssetFileInternal adobeAssetFileInternal;
        if (c0578la == null) {
            return null;
        }
        String validatedAssetName = C0533a.getValidatedAssetName(str);
        if (validatedAssetName == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("ADOBE_ASSET_DETAILS_STRING_KEY", "Illegal Characters in name");
            hashMap.put(AdobeEntitlementException.AdobeNetworkHTTPStatusKey, 400);
            AdobeAssetException adobeAssetException = new AdobeAssetException(AdobeAssetErrorCode.AdobeAssetErrorFileReadFailure, hashMap);
            if (handler != null) {
                handler.post(new RunnableC0620w(sdVar, adobeAssetException));
            } else {
                sdVar.a((sd<AdobeAssetFile, AdobeCSDKException>) adobeAssetException);
            }
            return null;
        }
        String rawPath = c0578la.getHref().getRawPath();
        if (rawPath.endsWith("/")) {
            str3 = rawPath + validatedAssetName;
        } else {
            str3 = rawPath + "/" + validatedAssetName;
        }
        try {
            com.adobe.creativesdk.foundation.internal.storage.model.resources.f a2 = com.adobe.creativesdk.foundation.internal.storage.model.resources.f.a(new URI(str3));
            a2.f6612d = str2;
            a2.a(adobeCloud);
            adobeAssetFileInternal = new AdobeAssetFileInternal(a2, c0578la.g());
            try {
                adobeAssetFileInternal.a(inputStream, str2, false, sdVar, handler);
                adobeAssetFileInternal.setCreationDate(new Date());
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return adobeAssetFileInternal;
            }
        } catch (Exception e3) {
            e = e3;
            adobeAssetFileInternal = null;
        }
        return adobeAssetFileInternal;
    }

    public void cancelCreationRequest() {
        cancelUpdateRequest();
    }

    public void cancelDataRequest() {
        com.adobe.creativesdk.foundation.internal.storage.a.b.ra session = getSession();
        if (session == null) {
            return;
        }
        session.a(this.dataRequest);
    }

    public void cancelRenditionRequest() {
        com.adobe.creativesdk.foundation.internal.net.E e2 = this.renditionRequest;
        if (e2 != null) {
            e2.a();
        } else {
            this.pendingRendRequestCancellation = true;
        }
    }

    public void cancelUpdateRequest() {
        com.adobe.creativesdk.foundation.internal.storage.a.b.ra session = getSession();
        if (session == null) {
            return;
        }
        session.a(this.uploadRequest);
    }

    public void downloadAssetFile(URI uri, sd<Boolean, AdobeAssetException> sdVar) {
        downloadAssetFileForPage(uri, 0, sdVar);
    }

    public void downloadAssetFileForPage(URI uri, int i, sd<Boolean, AdobeAssetException> sdVar) {
        C0585n c0585n = new C0585n(this, sdVar, i);
        com.adobe.creativesdk.foundation.internal.storage.a.b.ra session = getSession();
        if (session == null) {
            return;
        }
        this.dataRequest = session.a(resourceItem(), c0585n, uri.getPath());
    }

    @Override // com.adobe.creativesdk.foundation.storage.C0533a
    public boolean equals(Object obj) {
        if (obj instanceof AdobeAssetFile) {
            return super.equals(obj);
        }
        return false;
    }

    public int getCurrentVersion() {
        return this.currentVersion;
    }

    public void getData(sd<byte[], AdobeAssetException> sdVar) {
        B b2 = new B(this);
        try {
            b2.f6928a = new Handler();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (com.adobe.creativesdk.foundation.internal.cache.d.b().a(a(), a(), EnumSet.of(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache), "com.adobe.cc.storage", new C0593p(this, sdVar, b2), b2.f6928a)) {
            return;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeAssetFile:GetDataFromCache", String.format("Rendition request for %s ended in error.", this.href));
        sdVar.a((sd<byte[], AdobeAssetException>) null);
    }

    public void getDataForPage(int i, sd<byte[], AdobeAssetException> sdVar) {
        C0612u c0612u = new C0612u(this, sdVar, i);
        com.adobe.creativesdk.foundation.internal.storage.a.b.ra session = getSession();
        if (session == null) {
            return;
        }
        this.dataRequest = session.a(resourceItem(), c0612u, (String) null);
    }

    public void getDataForPageSaveToDevice(int i, sd<Uri, AdobeAssetException> sdVar, String str) {
        C0604s c0604s = new C0604s(this, sdVar, i);
        com.adobe.creativesdk.foundation.internal.storage.a.b.ra session = getSession();
        if (session == null) {
            return;
        }
        this.dataRequest = session.b(resourceItem(), c0604s, str);
    }

    public void getDataForSaveToDevice(sd<Uri, AdobeAssetException> sdVar, String str) {
        E e2 = new E(this);
        try {
            e2.f6953a = new Handler();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        if (com.adobe.creativesdk.foundation.internal.cache.d.b().a(a(), a(), EnumSet.of(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache), "com.adobe.cc.storage", new r(this, sdVar, str, e2), e2.f6953a)) {
            return;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeAssetFile:GetDataFromCache", String.format("Rendition request for %s ended in error.", this.href));
        sdVar.a((sd<Uri, AdobeAssetException>) null);
    }

    public String getDescription() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.GUID != null) {
                jSONObject.put("guid", this.GUID);
            }
            if (this.etag != null) {
                jSONObject.put("etag", this.etag);
            }
            if (this.href != null) {
                jSONObject.put("getHref", this.href);
            }
            if (this.parentHref != null) {
                jSONObject.put("parent-getHref", this.parentHref);
            }
            if (this.name != null) {
                jSONObject.put("name", this.name);
            }
            if (this.creationDate != null) {
                jSONObject.put("created", this.creationDate.toString());
            }
            if (this.modificationDate != null) {
                jSONObject.put("modified", this.modificationDate.toString());
            }
            if (this.type != null) {
                jSONObject.put("type", this.type);
            }
            jSONObject.put("fileSize", this.fileSize);
            if (this.md5Hash != null) {
                jSONObject.put("md5Hash", this.md5Hash);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getMd5Hash() {
        return this.md5Hash;
    }

    public JSONObject getOptionalMetadata() {
        return this.optionalMetadata;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C0578la getParentFolder() {
        return C0578la.a(this.href, getCloud());
    }

    public void getRenditionWithType(AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma, sd<byte[], AdobeAssetException> sdVar) {
        getRenditionWithType(adobeAssetFileRenditionType, c0582ma, 0, sdVar);
    }

    public String getType() {
        return this.type;
    }

    @Override // com.adobe.creativesdk.foundation.storage.C0533a
    public int hashCode() {
        return super.hashCode();
    }

    @Override // java.io.Externalizable
    @Deprecated
    public void readExternal(ObjectInput objectInput) throws ClassNotFoundException {
        try {
            this.GUID = (String) objectInput.readObject();
            this.href = (URI) objectInput.readObject();
            this.parentHref = (URI) objectInput.readObject();
            this.etag = (String) objectInput.readObject();
            this.name = (String) objectInput.readObject();
            this.creationDate = (Date) objectInput.readObject();
            this.modificationDate = (Date) objectInput.readObject();
            this.type = (String) objectInput.readObject();
            this.md5Hash = (String) objectInput.readObject();
            this.fileSize = objectInput.readLong();
            this.currentVersion = objectInput.readInt();
            String str = (String) objectInput.readObject();
            if (str != null) {
                try {
                    this.optionalMetadata = new JSONObject(str);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (IOException e3) {
            Log.d("Parcel Adobe", " " + e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.adobe.creativesdk.foundation.internal.storage.model.resources.f resourceItem() {
        if (this.asrItem == null) {
            this.asrItem = com.adobe.creativesdk.foundation.internal.storage.model.resources.f.a(this.href);
            com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar = this.asrItem;
            fVar.f6611c = this.name;
            fVar.f6613e = this.etag;
            fVar.f6609a = this.GUID;
            fVar.c(this.md5Hash);
        }
        return this.asrItem;
    }

    public void setVersion(int i) {
    }

    public void update(URL url, String str, sd<AdobeAssetFile, AdobeCSDKException> sdVar, Handler handler) {
        if (c.a.a.a.a.a.a.b().b(new C0628y(this, sdVar, handler), "Update requires an authenticated user.")) {
            return;
        }
        if (this.GUID != null) {
            a(url, str, true, sdVar, handler);
            return;
        }
        com.adobe.creativesdk.foundation.internal.storage.a.b.ra session = getSession();
        if (session == null) {
            return;
        }
        session.a(resourceItem(), new A(this, url, str, sdVar, handler), handler);
    }

    @Override // java.io.Externalizable
    @Deprecated
    public void writeExternal(ObjectOutput objectOutput) {
        try {
            objectOutput.writeObject(this.GUID);
            objectOutput.writeObject(this.href);
            objectOutput.writeObject(this.parentHref);
            objectOutput.writeObject(this.etag);
            objectOutput.writeObject(this.name);
            objectOutput.writeObject(this.creationDate);
            objectOutput.writeObject(this.modificationDate);
            objectOutput.writeObject(this.type);
            objectOutput.writeObject(this.md5Hash);
            objectOutput.writeLong(this.fileSize);
            objectOutput.writeInt(this.currentVersion);
            if (this.optionalMetadata != null) {
                objectOutput.writeObject(this.optionalMetadata.toString());
            }
        } catch (IOException e2) {
            Log.d("Parcel Adobe", "" + e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static AdobeAssetFile create(String str, C0578la c0578la, AdobeCloud adobeCloud, URL url, String str2, sd<AdobeAssetFile, AdobeCSDKException> sdVar, Handler handler) {
        String str3;
        AdobeAssetFileInternal adobeAssetFileInternal;
        if (str == null) {
            str = com.adobe.creativesdk.foundation.internal.storage.model.util.g.a(url.getPath());
        }
        if (c0578la == null) {
            return null;
        }
        String validatedAssetName = C0533a.getValidatedAssetName(str);
        if (validatedAssetName == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("ADOBE_ASSET_DETAILS_STRING_KEY", "Illegal Characters in name");
            hashMap.put(AdobeEntitlementException.AdobeNetworkHTTPStatusKey, 400);
            AdobeAssetException adobeAssetException = new AdobeAssetException(AdobeAssetErrorCode.AdobeAssetErrorFileReadFailure, hashMap);
            if (handler != null) {
                handler.post(new RunnableC0616v(sdVar, adobeAssetException));
            } else {
                sdVar.a((sd<AdobeAssetFile, AdobeCSDKException>) adobeAssetException);
            }
            return null;
        }
        String rawPath = c0578la.getHref().getRawPath();
        if (rawPath.endsWith("/")) {
            str3 = rawPath + validatedAssetName;
        } else {
            str3 = rawPath + "/" + validatedAssetName;
        }
        try {
            com.adobe.creativesdk.foundation.internal.storage.model.resources.f a2 = com.adobe.creativesdk.foundation.internal.storage.model.resources.f.a(new URI(str3));
            a2.f6612d = str2;
            a2.a(adobeCloud);
            adobeAssetFileInternal = new AdobeAssetFileInternal(a2, c0578la.g());
            try {
                adobeAssetFileInternal.update(url, str2, sdVar, handler);
                adobeAssetFileInternal.setCreationDate(new Date());
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return adobeAssetFileInternal;
            }
        } catch (Exception e3) {
            e = e3;
            adobeAssetFileInternal = null;
        }
        return adobeAssetFileInternal;
    }

    public void getRenditionWithType(AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma, int i, sd<byte[], AdobeAssetException> sdVar) {
        Handler handler;
        boolean a2 = AdobeEntitlementServices.b().a("ccv", getCloud());
        String str = this.type;
        if (str == null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeGetRendition:Invalid Type", String.format("Failed to get type of the image for %s", this.name));
            sdVar.a((sd<byte[], AdobeAssetException>) null);
            return;
        }
        if (str.equals(STREAMING_VIDEO_TYPE) || this.type.startsWith("video/")) {
            AdobeAssetFileInternal adobeAssetFileInternal = (AdobeAssetFileInternal) this;
            if (a2) {
                S s = new S(this, this, adobeAssetFileInternal);
                try {
                    handler = new Handler();
                } catch (Exception unused) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "GetRendition", "failure:handler creation failed");
                    handler = null;
                }
                if (!com.adobe.creativesdk.foundation.internal.cache.d.b().a(a(), "video-data", EnumSet.of(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache), "com.adobe.cc.storage", s, handler)) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeAssetFile:GetRenditionFromCache", String.format("Rendition request for %s ended in error.", this.href));
                    sdVar.a((sd<byte[], AdobeAssetException>) null);
                }
            } else {
                adobeAssetFileInternal.hlsHref = null;
            }
        }
        b(adobeAssetFileRenditionType, c0582ma, i, sdVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.io.InputStream r15, java.lang.String r16, boolean r17, com.adobe.creativesdk.foundation.storage.sd<com.adobe.creativesdk.foundation.storage.AdobeAssetFile, com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException> r18, android.os.Handler r19) {
        /*
            r14 = this;
            r9 = r14
            r7 = r16
            com.adobe.creativesdk.foundation.internal.analytics.d r8 = new com.adobe.creativesdk.foundation.internal.analytics.d
            if (r17 == 0) goto La
            com.adobe.creativesdk.foundation.adobeinternal.analytics.AdobeAnalyticsEventParams$Type r0 = com.adobe.creativesdk.foundation.adobeinternal.analytics.AdobeAnalyticsEventParams.Type.AdobeEventTypeAppUpdate
            goto Lc
        La:
            com.adobe.creativesdk.foundation.adobeinternal.analytics.AdobeAnalyticsEventParams$Type r0 = com.adobe.creativesdk.foundation.adobeinternal.analytics.AdobeAnalyticsEventParams.Type.AdobeEventTypeAppCreate
        Lc:
            java.lang.String r0 = r0.getValue()
            r8.<init>(r0, r7)
            int r10 = r15.available()     // Catch: java.io.IOException -> L37
            java.lang.String r2 = r9.etag     // Catch: java.io.IOException -> L35
            java.lang.String r3 = r9.name     // Catch: java.io.IOException -> L35
            java.lang.String r4 = ""
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L35
            r0.<init>()     // Catch: java.io.IOException -> L35
            java.lang.String r1 = ""
            r0.append(r1)     // Catch: java.io.IOException -> L35
            r0.append(r10)     // Catch: java.io.IOException -> L35
            java.lang.String r6 = r0.toString()     // Catch: java.io.IOException -> L35
            r1 = r8
            r5 = r16
            r1.a(r2, r3, r4, r5, r6)     // Catch: java.io.IOException -> L35
            goto L3c
        L35:
            r0 = move-exception
            goto L39
        L37:
            r0 = move-exception
            r10 = 0
        L39:
            r0.printStackTrace()
        L3c:
            r5 = r10
            c.a.a.a.a.a.a r0 = c.a.a.a.a.a.a.b()
            com.adobe.creativesdk.foundation.storage.H r1 = new com.adobe.creativesdk.foundation.storage.H
            r10 = r18
            r11 = r19
            r1.<init>(r14, r10, r11)
            java.lang.String r2 = "Update requires an authenticated user."
            boolean r0 = r0.b(r1, r2)
            if (r0 == 0) goto L53
            return
        L53:
            r9.type = r7
            com.adobe.creativesdk.foundation.internal.storage.a.b.ra r0 = r14.getSession()
            if (r0 != 0) goto L5c
            return
        L5c:
            com.adobe.creativesdk.foundation.internal.storage.model.resources.f r12 = r14.resourceItem()
            com.adobe.creativesdk.foundation.storage.M r13 = new com.adobe.creativesdk.foundation.storage.M
            r1 = r13
            r2 = r14
            r3 = r8
            r4 = r16
            r6 = r19
            r7 = r18
            r8 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            r1 = r0
            r2 = r12
            r3 = r15
            r4 = r17
            r5 = r13
            com.adobe.creativesdk.foundation.internal.net.j r0 = r1.a(r2, r3, r4, r5, r6)
            r9.uploadRequest = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.storage.AdobeAssetFile.a(java.io.InputStream, java.lang.String, boolean, com.adobe.creativesdk.foundation.storage.sd, android.os.Handler):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c.a.a.a.b<JSONObject> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        C0573k c0573k = new C0573k(this, bVar, cVar);
        com.adobe.creativesdk.foundation.internal.storage.a.b.ra session = getSession();
        if (session == null) {
            return;
        }
        session.a(resourceItem(), this.type, c0573k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AdobeAssetFile() {
        this.pendingRendRequestCancellation = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma, int i, sd<byte[], AdobeAssetException> sdVar) {
        int i2 = C0624x.f7464a[adobeAssetFileRenditionType.ordinal()];
        String str = i2 != 1 ? i2 != 2 ? "image/jpeg" : "image/pdf" : "image/png";
        float f2 = c0582ma.f7349b;
        float f3 = c0582ma.f7348a;
        float f4 = f2 > f3 ? f2 : f3;
        C0581m c0581m = new C0581m(this, adobeAssetFileRenditionType, c0582ma, i, sdVar);
        com.adobe.creativesdk.foundation.internal.storage.a.b.ra session = getSession();
        if (!this.pendingRendRequestCancellation) {
            this.renditionRequest = session != null ? session.a(resourceItem(), (int) f4, str, i, c0581m) : null;
        } else {
            sdVar.a();
            this.pendingRendRequestCancellation = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a() {
        String str = resourceItem().f6609a;
        if (str == null) {
            return this.href.getPath().split("/")[r0.length - 1];
        }
        String replace = str.replace("/", io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR);
        AdobeCloud c2 = com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e().c();
        if (c2 == null || !c2.isPrivateCloud()) {
            return replace;
        }
        return replace + c2.getGUID();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma, int i) {
        return String.format("%d_%d-%d-%d", Integer.valueOf(adobeAssetFileRenditionType.getIntVal()), Integer.valueOf((int) c0582ma.f7348a), Integer.valueOf((int) c0582ma.f7349b), Integer.valueOf(i));
    }
}
