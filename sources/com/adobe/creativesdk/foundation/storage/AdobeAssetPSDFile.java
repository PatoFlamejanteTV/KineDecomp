package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;
import android.util.DisplayMetrics;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloudServiceType;
import com.adobe.creativesdk.foundation.adobeinternal.imageservice.AdobeImageFitType;
import com.adobe.creativesdk.foundation.adobeinternal.imageservice.AdobeImageOutputDispositionType;
import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheOptions;
import com.adobe.creativesdk.foundation.internal.storage.AdobeAssetFileInternal;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.nextreaming.nexeditorui.NexTimeline;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class AdobeAssetPSDFile extends AdobeAssetFileInternal {
    private com.adobe.creativesdk.foundation.internal.net.E _layerRenditionRequest;
    private LinkedHashMap<String, com.adobe.creativesdk.foundation.internal.net.E> _layerRenditionRequests;
    private com.adobe.creativesdk.foundation.internal.net.E _previewPSDCompositeRequest;
    private com.adobe.creativesdk.foundation.internal.net.E _pullPSDCompositeRequestHandle;
    private com.adobe.creativesdk.foundation.internal.net.E _pushPSDCompositeRequestHandle;
    private final Lock lock;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdobeAssetPSDFile(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar) {
        super(fVar, eVar);
        this._layerRenditionRequests = null;
        this._layerRenditionRequest = null;
        this.lock = new ReentrantLock();
        this._pullPSDCompositeRequestHandle = null;
        this._pushPSDCompositeRequestHandle = null;
        this._previewPSDCompositeRequest = null;
    }

    private com.adobe.creativesdk.foundation.adobeinternal.imageservice.t b() {
        return (com.adobe.creativesdk.foundation.adobeinternal.imageservice.t) getCloud().getSessionForService(AdobeCloudServiceType.AdobeCloudServiceTypeImage);
    }

    private com.adobe.creativesdk.foundation.internal.storage.a.b.ra c() {
        return (com.adobe.creativesdk.foundation.internal.storage.a.b.ra) getCloud().getSessionForService(AdobeCloudServiceType.AdobeCloudServiceTypeStorage);
    }

    public static AdobeAssetPSDFile create(String str, C0578la c0578la, com.adobe.creativesdk.foundation.adobeinternal.storage.agc.b bVar, com.adobe.creativesdk.foundation.adobeinternal.storage.agc.a aVar, boolean z, sd<AdobeAssetPSDFile, AdobeCSDKException> sdVar, Handler handler) {
        String uri = c0578la.getHref().toString();
        if (!uri.endsWith("/")) {
            uri = uri + "/";
        }
        String str2 = uri + str;
        com.adobe.creativesdk.foundation.internal.storage.model.resources.f b2 = com.adobe.creativesdk.foundation.internal.storage.model.resources.f.b(str2);
        b2.f6611c = str;
        AdobeAssetPSDFile adobeAssetPSDFile = new AdobeAssetPSDFile(b2, com.adobe.creativesdk.foundation.internal.storage.model.resources.e.a(str2));
        adobeAssetPSDFile.setCloud(c0578la.getCloud());
        adobeAssetPSDFile.setCreationDate(new Date());
        b2.f6612d = "image/vnd.adobe.photoshop";
        adobeAssetPSDFile.type = "image/vnd.adobe.photoshop";
        if (c0578la.getCloud() != null) {
            ((com.adobe.creativesdk.foundation.adobeinternal.imageservice.t) c0578la.getCloud().getSessionForService(AdobeCloudServiceType.AdobeCloudServiceTypeImage)).a(b2, bVar, aVar, z, handler, new Ea(sdVar, adobeAssetPSDFile, b2));
        } else {
            sdVar.a((sd<AdobeAssetPSDFile, AdobeCSDKException>) null);
        }
        return adobeAssetPSDFile;
    }

    public static AdobeAssetPSDFile createWithPSDComposite(Lb lb, boolean z, sd<AdobeAssetPSDFile, AdobeCSDKException> sdVar, Handler handler) {
        return createWithPSDComposite(lb, z, com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e().c(), sdVar, handler);
    }

    String cacheKeyForLayer(Integer num, Integer num2, AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma) {
        String str;
        String str2;
        Object[] objArr = new Object[5];
        if (num == null) {
            str = NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE;
        } else {
            str = "" + num;
        }
        objArr[0] = str;
        if (num2 == null) {
            str2 = "default";
        } else {
            str2 = "" + num2;
        }
        objArr[1] = str2;
        objArr[2] = Integer.valueOf(adobeAssetFileRenditionType.getIntVal());
        objArr[3] = Integer.valueOf((int) c0582ma.f7348a);
        objArr[4] = Integer.valueOf((int) c0582ma.f7349b);
        return String.format("%s_%s_%d_%d-%d", objArr);
    }

    public void cancelLayerRenditionRequest(String str) {
        com.adobe.creativesdk.foundation.internal.net.E e2;
        if (str != null) {
            this.lock.lock();
            try {
                if (this._layerRenditionRequests != null && (e2 = this._layerRenditionRequests.get(str)) != null) {
                    e2.a();
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    public void cancelPullPSDCompositeRequest() {
        com.adobe.creativesdk.foundation.internal.net.E e2 = this._pullPSDCompositeRequestHandle;
        if (e2 != null) {
            e2.a();
            this._pullPSDCompositeRequestHandle = null;
        }
    }

    public void cancelPushPSDCompositeRequest() {
        com.adobe.creativesdk.foundation.internal.net.E e2 = this._pushPSDCompositeRequestHandle;
        if (e2 != null) {
            e2.a();
        }
    }

    String createLayerRenditionTmpDir() {
        String str = org.apache.commons.io.b.a() + "PSDLayerRenditionTemp";
        File file = new File(str);
        if (file.exists()) {
            try {
                org.apache.commons.io.b.b(file);
            } catch (IOException unused) {
            }
        }
        file.mkdirs();
        return str;
    }

    String createLayerRenditionTmpFileWithExtension(String str) {
        return com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.c(createLayerRenditionTmpDir(), String.format("temp%s.%s", com.adobe.creativesdk.foundation.internal.storage.model.util.i.a(), str));
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.AdobeAssetFileInternal, com.adobe.creativesdk.foundation.storage.AdobeAssetFile, com.adobe.creativesdk.foundation.storage.C0533a
    public boolean equals(Object obj) {
        if (obj instanceof AdobeAssetPSDFile) {
            return super.equals(obj);
        }
        return false;
    }

    public void getPreviewWithAppliedLayerCompId(Integer num, sd<com.adobe.creativesdk.foundation.adobeinternal.storage.psd.a, AdobeCSDKException> sdVar, Handler handler) {
        String str = org.apache.commons.io.b.a() + String.format("psd%d", Long.valueOf(new Date().getTime()));
        File file = new File(str);
        if (file.exists()) {
            try {
                org.apache.commons.io.b.b(file);
            } catch (IOException unused) {
            }
        }
        file.mkdirs();
        String c2 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.c(str, "preview.json");
        com.adobe.creativesdk.foundation.adobeinternal.imageservice.c cVar = new com.adobe.creativesdk.foundation.adobeinternal.imageservice.c();
        cVar.f3994a = AdobeImageOutputDispositionType.AdobeImageOutputDispositionDownload;
        cVar.f3998e = c2;
        cVar.f3996c = null;
        cVar.f3995b = null;
        Fa fa = new Fa(this, c2, sdVar);
        com.adobe.creativesdk.foundation.adobeinternal.imageservice.t b2 = b();
        if (b2 == null) {
            return;
        }
        this._previewPSDCompositeRequest = b2.a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f.a(this.href), cVar, fa, handler);
    }

    public String getRenditionForLayer(Integer num, Integer num2, AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma, sd<byte[], AdobeCSDKException> sdVar, Handler handler) {
        String cacheKeyForLayer = cacheKeyForLayer(num, num2, adobeAssetFileRenditionType, scaledDimensions(c0582ma));
        try {
            if (!com.adobe.creativesdk.foundation.internal.cache.d.b().a(resourceItem().f6609a, String.format("%d_%d-%d", Integer.valueOf(adobeAssetFileRenditionType.getIntVal()), Integer.valueOf((int) c0582ma.f7348a), Integer.valueOf((int) c0582ma.f7349b)), EnumSet.of(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache), "com.adobe.cc.storage", new La(this, sdVar, num, num2, adobeAssetFileRenditionType, c0582ma, cacheKeyForLayer, handler), handler)) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeAssetFile:GetRenditionFromCache", String.format("Rendition request for %s ended in error.", this.href));
                if (sdVar != null) {
                    sdVar.a((sd<byte[], AdobeCSDKException>) null);
                }
            }
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeAssetPSDFile.getRenditionForLayer", e2.getMessage());
        }
        return cacheKeyForLayer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.adobe.creativesdk.foundation.internal.net.E getRenditionFromServerForLayer(Integer num, Integer num2, AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma, String str, sd<byte[], AdobeCSDKException> sdVar, Handler handler) {
        String str2;
        String str3;
        int i = Da.f6948a[adobeAssetFileRenditionType.ordinal()];
        if (i == 1) {
            str2 = "image/gif";
            str3 = "gif";
        } else if (i == 2) {
            str2 = "image/jpeg";
            str3 = "jpeg";
        } else if (i != 3) {
            str2 = "image/png";
            str3 = "png";
        } else {
            str2 = "image/tiff";
            str3 = "tiff";
        }
        String str4 = str2;
        C0582ma scaledDimensions = scaledDimensions(c0582ma);
        com.adobe.creativesdk.foundation.adobeinternal.imageservice.t b2 = b();
        if (b2 == null) {
            return null;
        }
        com.adobe.creativesdk.foundation.adobeinternal.imageservice.c cVar = new com.adobe.creativesdk.foundation.adobeinternal.imageservice.c();
        cVar.f3994a = AdobeImageOutputDispositionType.AdobeImageOutputDispositionDownload;
        cVar.f3998e = createLayerRenditionTmpFileWithExtension(str3);
        cVar.f3996c = null;
        cVar.f3995b = str4;
        AdobeImageFitType adobeImageFitType = AdobeImageFitType.AdobeImageConstrain;
        Na na = new Na(this, str, cVar, sdVar);
        com.adobe.creativesdk.foundation.internal.storage.model.resources.f resourceItem = resourceItem();
        float f2 = scaledDimensions.f7348a;
        Float valueOf = f2 >= scaledDimensions.f7349b ? Float.valueOf(f2) : null;
        float f3 = scaledDimensions.f7349b;
        com.adobe.creativesdk.foundation.internal.net.E a2 = b2.a(resourceItem, num, null, null, valueOf, f3 >= scaledDimensions.f7348a ? Float.valueOf(f3) : null, adobeImageFitType, null, num2, null, cVar, na, handler);
        this.lock.lock();
        try {
            if (this._layerRenditionRequests == null) {
                this._layerRenditionRequests = new LinkedHashMap<>();
            }
            this._layerRenditionRequests.put(str, a2);
            return a2;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.AdobeAssetFileInternal, com.adobe.creativesdk.foundation.storage.AdobeAssetFile, com.adobe.creativesdk.foundation.storage.C0533a
    public int hashCode() {
        return super.hashCode();
    }

    boolean isCachedForKey(String str) {
        return com.adobe.creativesdk.foundation.internal.cache.d.b().a(resourceItem().f6609a, str, "com.adobe.cc.storage");
    }

    public void pullPSDCompositeAt(String str, sd<Lb, AdobeAssetException> sdVar, Handler handler) {
        com.adobe.creativesdk.foundation.internal.storage.a.b.ra c2;
        Lb lb = new Lb(getHref().getPath(), str);
        Ga ga = new Ga(this, sdVar);
        com.adobe.creativesdk.foundation.adobeinternal.imageservice.t b2 = b();
        if (b2 == null || (c2 = c()) == null) {
            return;
        }
        this._pullPSDCompositeRequestHandle = _b.a(lb, b2, c2, new Ha(this, lb, sdVar, ga), handler);
        this._pullPSDCompositeRequestHandle.a(ga);
    }

    public void pushPSDComposite(Lb lb, boolean z, sd<Lb, AdobeCSDKException> sdVar, Handler handler) {
        com.adobe.creativesdk.foundation.internal.storage.a.b.ra c2;
        Ia ia = new Ia(this, sdVar);
        com.adobe.creativesdk.foundation.adobeinternal.imageservice.t b2 = b();
        if (b2 == null || (c2 = c()) == null) {
            return;
        }
        this._pushPSDCompositeRequestHandle = _b.a(lb, z, b2, c2, new Ja(this, lb, sdVar, ia), handler);
        this._pushPSDCompositeRequestHandle.a(ia);
    }

    C0582ma scaledDimensions(C0582ma c0582ma) {
        float f2 = new DisplayMetrics().density;
        return c0582ma;
    }

    protected static AdobeAssetPSDFile createWithPSDComposite(Lb lb, boolean z, AdobeCloud adobeCloud, sd<AdobeAssetPSDFile, AdobeCSDKException> sdVar, Handler handler) {
        if (adobeCloud == null) {
            adobeCloud = com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e().c();
        }
        try {
            String d2 = lb.d();
            AdobeAssetPSDFile adobeAssetPSDFile = new AdobeAssetPSDFile(com.adobe.creativesdk.foundation.internal.storage.model.resources.f.b(d2), com.adobe.creativesdk.foundation.internal.storage.model.resources.e.a(com.adobe.creativesdk.foundation.internal.storage.model.util.g.b(d2)));
            adobeAssetPSDFile.setCloud(adobeCloud);
            adobeAssetPSDFile.pushPSDComposite(lb, z, new Oa(sdVar, adobeAssetPSDFile), handler);
            adobeAssetPSDFile.setCreationDate(new Date());
            return adobeAssetPSDFile;
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, AdobeAssetPSDFile.class.getSimpleName(), e2.getMessage(), e2);
            if (sdVar != null) {
                sdVar.a((sd<AdobeAssetPSDFile, AdobeCSDKException>) com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorBadRequest, (String) null));
            }
            return null;
        }
    }

    public boolean pushPSDComposite(Lb lb, boolean z) {
        com.adobe.creativesdk.foundation.internal.storage.a.b.ra c2;
        com.adobe.creativesdk.foundation.adobeinternal.imageservice.t b2 = b();
        if (b2 == null || (c2 = c()) == null) {
            return false;
        }
        try {
            boolean a2 = _b.a(lb, z, b2, c2);
            if (!a2) {
                return a2;
            }
            boolean a3 = lb.a();
            if (a3) {
                com.adobe.creativesdk.foundation.internal.analytics.q.b("Product Saves", "Creative Cloud");
            }
            return a3;
        } catch (AdobeCSDKException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, AdobeAssetPSDFile.class.getSimpleName(), "PSD composite push request for %@ has failed" + getHref().getPath(), e2);
            return false;
        }
    }

    protected static boolean pushPSDComposite(boolean z, Lb lb, AdobeCloud adobeCloud) {
        com.adobe.creativesdk.foundation.adobeinternal.imageservice.t tVar = adobeCloud != null ? (com.adobe.creativesdk.foundation.adobeinternal.imageservice.t) adobeCloud.getSessionForService(AdobeCloudServiceType.AdobeCloudServiceTypeImage) : null;
        if (tVar == null) {
            return false;
        }
        com.adobe.creativesdk.foundation.internal.storage.a.b.ra raVar = adobeCloud != null ? (com.adobe.creativesdk.foundation.internal.storage.a.b.ra) adobeCloud.getSessionForService(AdobeCloudServiceType.AdobeCloudServiceTypeStorage) : null;
        if (raVar == null) {
            return false;
        }
        try {
            boolean a2 = _b.a(lb, z, tVar, raVar);
            if (a2) {
                a2 = lb.a();
            }
            return a2;
        } catch (AdobeCSDKException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, AdobeAssetPSDFile.class.getSimpleName(), "PSD composite push request for %@ has failed" + lb.d(), e2);
            return false;
        }
    }
}
