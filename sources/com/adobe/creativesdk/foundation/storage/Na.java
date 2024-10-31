package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheOptions;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetPSDFile.java */
/* loaded from: classes.dex */
public class Na implements com.adobe.creativesdk.foundation.adobeinternal.imageservice.v {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f7065a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.adobeinternal.imageservice.c f7066b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ sd f7067c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AdobeAssetPSDFile f7068d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Na(AdobeAssetPSDFile adobeAssetPSDFile, String str, com.adobe.creativesdk.foundation.adobeinternal.imageservice.c cVar, sd sdVar) {
        this.f7068d = adobeAssetPSDFile;
        this.f7065a = str;
        this.f7066b = cVar;
        this.f7067c = sdVar;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.imageservice.v
    public void a(com.adobe.creativesdk.foundation.adobeinternal.imageservice.b bVar) {
        Lock lock;
        LinkedHashMap linkedHashMap;
        Lock lock2;
        FileInputStream fileInputStream;
        Throwable th;
        LinkedHashMap linkedHashMap2;
        lock = this.f7068d.lock;
        lock.lock();
        linkedHashMap = this.f7068d._layerRenditionRequests;
        if (linkedHashMap != null) {
            linkedHashMap2 = this.f7068d._layerRenditionRequests;
            linkedHashMap2.remove(this.f7065a);
        }
        lock2 = this.f7068d.lock;
        lock2.unlock();
        this.f7068d._layerRenditionRequest = null;
        File file = new File(this.f7066b.f3998e);
        byte[] bArr = new byte[(int) file.length()];
        try {
        } catch (FileNotFoundException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeAssetPSDFile.getRenditionFromServerForLayer", e2.getMessage());
        } catch (IOException e3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeAssetPSDFile.getRenditionFromServerForLayer", e3.getMessage());
        }
        try {
            fileInputStream = new FileInputStream(file);
            int i = 0;
            while (i < bArr.length) {
                try {
                    int read = fileInputStream.read(bArr, i, bArr.length - i);
                    if (read > 0) {
                        i += read;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream.close();
                    throw th;
                }
            }
            fileInputStream.close();
            sd sdVar = this.f7067c;
            if (sdVar != null) {
                sdVar.b(bArr);
            }
            if (!file.exists() || !file.delete()) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeAssetPSDFile.getRenditionFromServerForLayer", String.format("Attempt to delete temporary layer rendition file %s ended in error", this.f7066b.f3998e));
            }
            com.adobe.creativesdk.foundation.internal.cache.d.b().a(bArr, this.f7068d.resourceItem().f6609a, this.f7065a, EnumSet.of(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache, AdobeCommonCacheOptions.AdobeCommonCacheKeepOnDiskCache), "com.adobe.cc.storage", new Ma(this));
            if (this.f7068d.md5Hash != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("md5", this.f7068d.md5Hash);
                hashMap.put("modified", this.f7068d.modificationDate);
                hashMap.put("etag", this.f7068d.etag);
                if (com.adobe.creativesdk.foundation.internal.cache.d.b().a((Map) hashMap, this.f7068d.resourceItem().f6609a, "modified-data", EnumSet.of(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache, AdobeCommonCacheOptions.AdobeCommonCacheKeepOnDiskCache), "com.adobe.cc.storage")) {
                    return;
                }
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeAssetPSDFile.getRenditionFromServerForLayer", String.format("Image service rendition request for %s ended in error:", this.f7068d.href));
            }
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.imageservice.v
    public void a(AdobeNetworkException adobeNetworkException) {
        Lock lock;
        LinkedHashMap linkedHashMap;
        Lock lock2;
        LinkedHashMap linkedHashMap2;
        lock = this.f7068d.lock;
        lock.lock();
        linkedHashMap = this.f7068d._layerRenditionRequests;
        if (linkedHashMap != null) {
            linkedHashMap2 = this.f7068d._layerRenditionRequests;
            linkedHashMap2.remove(this.f7065a);
        }
        lock2 = this.f7068d.lock;
        lock2.unlock();
        this.f7068d._layerRenditionRequest = null;
        if (adobeNetworkException.getErrorCode().equals(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorCancelled)) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "AdobeAssetPSDFile.getRenditionFromServerForLayer", String.format("Image service rendition request for %s has been cancelled.", this.f7068d.href));
            sd sdVar = this.f7067c;
            if (sdVar != null) {
                sdVar.a();
                return;
            }
            return;
        }
        sd sdVar2 = this.f7067c;
        if (sdVar2 != null) {
            sdVar2.a((sd) adobeNetworkException);
        }
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
        sd sdVar = this.f7067c;
        if (sdVar != null) {
            sdVar.a(d2);
        }
    }
}
