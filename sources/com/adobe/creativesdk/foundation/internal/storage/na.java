package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0432l;
import com.adobe.creativesdk.foundation.storage.AdobeAssetDataSourceType;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: MobileCreationsDataSourceFactory.java */
/* loaded from: classes.dex */
public class na {

    /* renamed from: a */
    private static na f6630a;

    /* renamed from: b */
    private Map<AdobeAssetDataSourceType, C0507f> f6631b;

    /* renamed from: c */
    private List<AdobeAssetDataSourceType> f6632c;

    /* renamed from: e */
    private int f6634e;

    /* renamed from: f */
    private AdobeCloud f6635f;

    /* renamed from: d */
    private boolean f6633d = false;

    /* renamed from: g */
    private boolean f6636g = false;

    private na() {
    }

    public static Set<AdobeAssetDataSourceType> b() {
        return EnumSet.of(AdobeAssetDataSourceType.AdobeAssetDataSourcePSMix, AdobeAssetDataSourceType.AdobeAssetDataSourceCompositions, AdobeAssetDataSourceType.AdobeAssetDataSourceDraw, AdobeAssetDataSourceType.AdobeAssetDataSourceSketches, AdobeAssetDataSourceType.AdobeAssetDataSourcePSFix);
    }

    public static na c() {
        if (f6630a == null) {
            f6630a = new na();
        }
        return f6630a;
    }

    private void e() {
        this.f6631b = new HashMap();
        this.f6633d = false;
        this.f6632c = new ArrayList();
        for (AdobeAssetDataSourceType adobeAssetDataSourceType : b()) {
            if (C0432l.a(adobeAssetDataSourceType, c().a())) {
                C0507f c0507f = new C0507f(adobeAssetDataSourceType, c().a());
                c0507f.a(new fa(adobeAssetDataSourceType));
                this.f6631b.put(adobeAssetDataSourceType, c0507f);
            }
        }
        this.f6634e = this.f6631b.size();
    }

    private void f() {
        if (this.f6633d) {
            return;
        }
        for (Map.Entry<AdobeAssetDataSourceType, C0507f> entry : this.f6631b.entrySet()) {
        }
    }

    public void a(boolean z) {
        if (com.adobe.creativesdk.foundation.adobeinternal.net.a.b().b()) {
            this.f6631b = null;
            this.f6632c = null;
            e();
            f();
        }
    }

    public List<AdobeAssetDataSourceType> d() {
        return this.f6632c;
    }

    public boolean b(AdobeAssetDataSourceType adobeAssetDataSourceType) {
        return ((EnumSet) b()).contains(adobeAssetDataSourceType);
    }

    public void c(AdobeAssetDataSourceType adobeAssetDataSourceType) {
        this.f6634e--;
        if (c().a(adobeAssetDataSourceType).getCount() != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("DataSourceReady", adobeAssetDataSourceType);
            com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(AdobeInternalNotificationID.AdobeDataSourceReady, hashMap));
            this.f6632c.add(adobeAssetDataSourceType);
        }
        if (this.f6634e == 0) {
            this.f6633d = true;
        }
    }

    public C0507f a(AdobeAssetDataSourceType adobeAssetDataSourceType) {
        Map<AdobeAssetDataSourceType, C0507f> map = this.f6631b;
        if (map == null || !map.containsKey(adobeAssetDataSourceType)) {
            return null;
        }
        return this.f6631b.get(adobeAssetDataSourceType);
    }

    public AdobeCloud a() {
        return this.f6635f;
    }

    public void a(AdobeCloud adobeCloud) {
        this.f6635f = adobeCloud;
    }
}
