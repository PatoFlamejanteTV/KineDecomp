package com.adobe.creativesdk.foundation.adobeinternal.cloud;

import com.adobe.creativesdk.foundation.adobeinternal.entitlement.AdobeEntitlementException;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAsset;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AdobeEntitlementServices implements Observer {

    /* renamed from: a */
    private static volatile AdobeEntitlementServices f3933a;

    /* renamed from: b */
    private HashMap<String, AdobeCloudServicePrerequisite> f3934b;

    /* renamed from: d */
    private boolean f3936d;

    /* renamed from: e */
    private boolean f3937e;

    /* renamed from: f */
    private boolean f3938f = false;

    /* renamed from: c */
    private JSONObject f3935c = new JSONObject();

    /* loaded from: classes.dex */
    public enum AdobeCloudServicePrerequisite {
        AdobeCloudServicePrerequisiteNone,
        AdobeCloudServicePrerequisiteStorageFile,
        AdobeCloudServicePrerequisiteStorageAsset,
        AdobeCloudServicePrerequisiteStorageLibrary,
        AdobeCloudServicePrerequisiteStorageArchive,
        AdobeCloudServicePrerequisitePhoto,
        AdobeCloudServicePrerequisiteMarket,
        AdobeCloudServicePrerequisiteImage
    }

    private AdobeEntitlementServices() {
        this.f3934b = null;
        this.f3934b = new HashMap<>();
        this.f3934b.put("private_cloud", AdobeCloudServicePrerequisite.AdobeCloudServicePrerequisiteStorageFile);
        this.f3934b.put("public_cloud", AdobeCloudServicePrerequisite.AdobeCloudServicePrerequisiteStorageFile);
        this.f3934b.put("cc_storage", AdobeCloudServicePrerequisite.AdobeCloudServicePrerequisiteStorageFile);
        this.f3934b.put("behance", AdobeCloudServicePrerequisite.AdobeCloudServicePrerequisiteNone);
        this.f3934b.put("story", AdobeCloudServicePrerequisite.AdobeCloudServicePrerequisiteNone);
        this.f3934b.put("phonegap_build", AdobeCloudServicePrerequisite.AdobeCloudServicePrerequisiteNone);
        this.f3934b.put("lightroom", AdobeCloudServicePrerequisite.AdobeCloudServicePrerequisitePhoto);
        this.f3934b.put("edge_inspect", AdobeCloudServicePrerequisite.AdobeCloudServicePrerequisiteNone);
        this.f3934b.put("premiere_clip", AdobeCloudServicePrerequisite.AdobeCloudServicePrerequisiteNone);
        this.f3934b.put(MessengerShareContentUtility.MEDIA_IMAGE, AdobeCloudServicePrerequisite.AdobeCloudServicePrerequisiteImage);
        this.f3934b.put("extract", AdobeCloudServicePrerequisite.AdobeCloudServicePrerequisiteNone);
        this.f3934b.put(AdobePhotoAsset.AdobePhotoAssetRenditionImagePreview, AdobeCloudServicePrerequisite.AdobeCloudServicePrerequisiteNone);
        this.f3934b.put("allow_mobile", AdobeCloudServicePrerequisite.AdobeCloudServicePrerequisiteNone);
        this.f3934b.put("file_sync", AdobeCloudServicePrerequisite.AdobeCloudServicePrerequisiteNone);
        this.f3934b.put("collaboration", AdobeCloudServicePrerequisite.AdobeCloudServicePrerequisiteNone);
        this.f3934b.put(AdobeCloud.STORAGE, AdobeCloudServicePrerequisite.AdobeCloudServicePrerequisiteStorageFile);
        this.f3934b.put("libraries", AdobeCloudServicePrerequisite.AdobeCloudServicePrerequisiteStorageLibrary);
        this.f3934b.put("design_assets", AdobeCloudServicePrerequisite.AdobeCloudServicePrerequisiteMarket);
        this.f3934b.put("color", AdobeCloudServicePrerequisite.AdobeCloudServicePrerequisiteNone);
        this.f3934b.put("sync_settings", AdobeCloudServicePrerequisite.AdobeCloudServicePrerequisiteNone);
        this.f3934b.put("sync_metadata", AdobeCloudServicePrerequisite.AdobeCloudServicePrerequisiteNone);
        this.f3934b.put("stock", AdobeCloudServicePrerequisite.AdobeCloudServicePrerequisiteNone);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeEntilementUserProfileDataFetchNotification, this);
    }

    public JSONObject a() {
        return this.f3935c;
    }

    public void b(boolean z) {
        this.f3936d = z;
    }

    public boolean c() {
        return this.f3937e;
    }

    public boolean d() {
        return this.f3936d;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        com.adobe.creativesdk.foundation.internal.notification.c cVar = (com.adobe.creativesdk.foundation.internal.notification.c) obj;
        if (cVar.a() == AdobeInternalNotificationID.AdobeEntilementUserProfileDataFetchNotification) {
            if (this.f3938f) {
                this.f3938f = false;
                return;
            }
            JSONObject jSONObject = (JSONObject) cVar.b().get("AdobeEntitlementSessionUserProfileData");
            b(jSONObject.opt("public_cloud") != null ? jSONObject.optBoolean("public_cloud") : true);
            a(jSONObject.opt("private_cloud") != null ? jSONObject.optBoolean("private_cloud") : true);
            try {
                JSONObject a2 = c.a.a.a.c.b.b.a(jSONObject);
                if (c.a.a.a.c.b.b.a(a2, a())) {
                    return;
                }
                a(a2);
            } catch (AdobeEntitlementException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, AdobeEntitlementServices.class.getSimpleName(), null, e2);
            }
        }
    }

    public static AdobeEntitlementServices b() {
        synchronized (AdobeEntitlementServices.class) {
            if (f3933a == null) {
                f3933a = new AdobeEntitlementServices();
                JSONObject l = com.adobe.creativesdk.foundation.adobeinternal.entitlement.h.k().l();
                if (l != null) {
                    f3933a.b(l.opt("public_cloud") != null ? l.optBoolean("public_cloud") : true);
                    f3933a.a(l.opt("private_cloud") != null ? l.optBoolean("private_cloud") : true);
                    try {
                        f3933a.a(c.a.a.a.c.b.b.a(l));
                    } catch (AdobeEntitlementException e2) {
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, AdobeEntitlementServices.class.getSimpleName(), null, e2);
                    }
                }
            }
        }
        return f3933a;
    }

    public void a(boolean z) {
        this.f3937e = z;
    }

    protected void a(JSONObject jSONObject) {
        this.f3935c = jSONObject;
    }

    public boolean a(String str, AdobeCloud adobeCloud) {
        JSONObject jSONObject;
        if (adobeCloud == null) {
            adobeCloud = d.e().c();
        }
        if (adobeCloud == null) {
            return true;
        }
        boolean b2 = b(str, adobeCloud);
        if (!b2 || (jSONObject = this.f3935c) == null || jSONObject.opt(str) == null) {
            return b2;
        }
        if (this.f3935c.opt(str) != null) {
            return this.f3935c.optJSONObject(str).optBoolean("entitled");
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean b(String str, AdobeCloud adobeCloud) {
        if (this.f3934b.get(str) != null) {
            AdobeCloudServicePrerequisite adobeCloudServicePrerequisite = this.f3934b.get(str);
            switch (i.f3962a[adobeCloudServicePrerequisite.ordinal()]) {
                case 2:
                    if (adobeCloud.getSessionForService(AdobeCloudServiceType.AdobeCloudServiceTypeImage) == null) {
                        return false;
                    }
                    break;
                case 3:
                    if (adobeCloud.getSessionForService(AdobeCloudServiceType.AdobeCloudServiceTypeMarket) == null) {
                        return false;
                    }
                    break;
                case 4:
                    if (adobeCloud.getSessionForService(AdobeCloudServiceType.AdobeCloudServiceTypePhoto) == null) {
                        return false;
                    }
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                    g sessionForService = adobeCloud.getSessionForService(AdobeCloudServiceType.AdobeCloudServiceTypeStorage);
                    if (sessionForService == null) {
                        return false;
                    }
                    if (adobeCloudServicePrerequisite == AdobeCloudServicePrerequisite.AdobeCloudServicePrerequisiteStorageAsset) {
                        if (sessionForService.c("assets") == null) {
                            return false;
                        }
                    } else if (adobeCloudServicePrerequisite == AdobeCloudServicePrerequisite.AdobeCloudServicePrerequisiteStorageFile) {
                        if (sessionForService.c("files") == null) {
                            return false;
                        }
                    } else if (adobeCloudServicePrerequisite == AdobeCloudServicePrerequisite.AdobeCloudServicePrerequisiteStorageLibrary) {
                        if (sessionForService.c("libraries") == null) {
                            return false;
                        }
                    } else if (adobeCloudServicePrerequisite == AdobeCloudServicePrerequisite.AdobeCloudServicePrerequisiteStorageArchive && sessionForService.c("archive") == null) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}
