package com.adobe.creativesdk.foundation.internal.storage;

import android.os.Handler;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloudServiceType;
import com.adobe.creativesdk.foundation.adobeinternal.entitlement.AdobeEntitlementException;
import com.adobe.creativesdk.foundation.internal.net.AdobeNetworkHttpRequestMethod;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.C0533a;
import com.adobe.creativesdk.foundation.storage.C0578la;
import com.adobe.creativesdk.foundation.storage.sd;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;

/* loaded from: classes.dex */
public class AdobeAssetFileInternal extends AdobeAssetFile {
    public int _videDuration;
    public String hlsHref;

    public AdobeAssetFileInternal() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.adobe.creativesdk.foundation.internal.net.j jVar, String str, String str2, String str3, ra raVar, sd<AdobeAssetFile, AdobeAssetException> sdVar) {
        URI uri;
        URI uri2;
        try {
            uri = new URI("temp/");
        } catch (URISyntaxException e2) {
            e2.printStackTrace();
            uri = null;
        }
        com.adobe.creativesdk.foundation.internal.storage.model.resources.e a2 = com.adobe.creativesdk.foundation.internal.storage.model.resources.e.a(uri);
        try {
            uri2 = new URI(a2.f6610b + str2);
        } catch (URISyntaxException e3) {
            e3.printStackTrace();
            uri2 = null;
        }
        if (uri2 == null) {
            sdVar.a((sd<AdobeAssetFile, AdobeAssetException>) new AdobeAssetException(AdobeAssetErrorCode.AdobeAssetErrorBadRequest));
            return;
        }
        com.adobe.creativesdk.foundation.internal.storage.model.resources.f a3 = com.adobe.creativesdk.foundation.internal.storage.model.resources.f.a(uri2);
        a3.f6612d = str3;
        raVar.a(jVar, str, (byte[]) null, new C0509h(a3, a2, sdVar, raVar));
    }

    public static void createFromURL(String str, sd<AdobeAssetFile, AdobeAssetException> sdVar, Handler handler, AdobeCloud adobeCloud) {
        com.adobe.creativesdk.foundation.internal.storage.model.resources.f b2 = com.adobe.creativesdk.foundation.internal.storage.model.resources.f.b(str);
        com.adobe.creativesdk.foundation.internal.storage.model.resources.e a2 = com.adobe.creativesdk.foundation.internal.storage.model.resources.e.a(str.substring(str.lastIndexOf("/")));
        if (adobeCloud == null) {
            return;
        }
        ((ra) adobeCloud.getSessionForService(AdobeCloudServiceType.AdobeCloudServiceTypeStorage)).a(b2, new C0508g(sdVar, b2, a2), handler);
    }

    public static void createTmpFile(String str, String str2, String str3, sd<AdobeAssetFile, AdobeAssetException> sdVar, Handler handler) {
        URI uri;
        URI uri2;
        String validatedAssetName = C0533a.getValidatedAssetName(str);
        if (validatedAssetName != null && !str.equals("")) {
            try {
                uri = new URI("temp/");
            } catch (URISyntaxException e2) {
                e2.printStackTrace();
                uri = null;
            }
            try {
                uri2 = new URI(com.adobe.creativesdk.foundation.internal.storage.model.resources.e.a(uri).f6610b + validatedAssetName);
            } catch (URISyntaxException e3) {
                e3.printStackTrace();
                uri2 = null;
            }
            if (uri2 == null) {
                sdVar.a((sd<AdobeAssetFile, AdobeAssetException>) new AdobeAssetException(AdobeAssetErrorCode.AdobeAssetErrorBadRequest));
                return;
            }
            com.adobe.creativesdk.foundation.internal.storage.model.resources.f a2 = com.adobe.creativesdk.foundation.internal.storage.model.resources.f.a(uri2);
            a2.f6612d = str3;
            ra raVar = (ra) com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e().c().getSessionForService(AdobeCloudServiceType.AdobeCloudServiceTypeStorage);
            raVar.a(a2, new C0511j(raVar.a((com.adobe.creativesdk.foundation.internal.storage.model.resources.b) a2, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPUT, (String) null, true), str2, validatedAssetName, str3, raVar, sdVar));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ADOBE_ASSET_DETAILS_STRING_KEY", "Illegal Characters in name");
        hashMap.put(AdobeEntitlementException.AdobeNetworkHTTPStatusKey, 400);
        AdobeAssetException adobeAssetException = new AdobeAssetException(AdobeAssetErrorCode.AdobeAssetErrorFileReadFailure, hashMap);
        if (handler != null) {
            handler.post(new RunnableC0510i(sdVar, adobeAssetException));
        } else {
            sdVar.a((sd<AdobeAssetFile, AdobeAssetException>) adobeAssetException);
        }
    }

    public static AdobeAssetFile internalCreate(String str, C0578la c0578la, AdobeCloud adobeCloud, URL url, String str2, sd<AdobeAssetFile, AdobeCSDKException> sdVar, Handler handler) {
        return AdobeAssetFile.create(str, c0578la, adobeCloud, url, str2, sdVar, handler);
    }

    public static AdobeAssetFile internalCreateFromStream(String str, C0578la c0578la, AdobeCloud adobeCloud, InputStream inputStream, String str2, sd<AdobeAssetFile, AdobeCSDKException> sdVar, Handler handler) {
        return AdobeAssetFile.createFromStream(str, c0578la, adobeCloud, inputStream, str2, sdVar, handler);
    }

    public boolean canStreamVideo() {
        String str = this.hlsHref;
        if (str != null) {
            try {
                new URL(str);
                return true;
            } catch (MalformedURLException unused) {
            }
        }
        return false;
    }

    @Override // com.adobe.creativesdk.foundation.storage.AdobeAssetFile, com.adobe.creativesdk.foundation.storage.C0533a
    public boolean equals(Object obj) {
        if (obj instanceof AdobeAssetFileInternal) {
            return super.equals(obj);
        }
        return false;
    }

    public String getHlsHref() {
        return this.hlsHref;
    }

    public C0578la getParentAssetFolder() {
        return getParentFolder();
    }

    public com.adobe.creativesdk.foundation.internal.storage.model.resources.f getStorageResourceItem() {
        return this.asrItem;
    }

    public int getVideoDuration() {
        return this._videDuration;
    }

    @Override // com.adobe.creativesdk.foundation.storage.AdobeAssetFile, com.adobe.creativesdk.foundation.storage.C0533a
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.adobe.creativesdk.foundation.storage.C0533a
    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setModifiedDate(Date date) {
        this.modificationDate = date;
    }

    public void setType(String str) {
        this.type = str;
    }

    public AdobeAssetFileInternal(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar) {
        super(fVar, eVar);
    }
}
