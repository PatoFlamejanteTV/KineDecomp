package com.adobe.creativesdk.foundation.internal.storage.controllers.upload;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa;
import com.adobe.creativesdk.foundation.internal.storage.controllers.upload.A;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;
import com.adobe.creativesdk.foundation.storage.C0578la;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: AdobeUploadManager.java */
/* loaded from: classes.dex */
public class r<EndPointType extends A<EndPointType>> {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f6459a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f6460b = true;

    /* renamed from: c, reason: collision with root package name */
    private static Map<Class<? extends A>, r> f6461c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private Map<String, t<EndPointType>> f6462d = new HashMap();

    private r() {
    }

    public static <T extends A<T>> r<T> a(Class<T> cls) {
        if (f6461c.get(cls) == null) {
            f6461c.put(cls, new r());
        }
        return f6461c.get(cls);
    }

    public List<String> b() {
        return new ArrayList(this.f6462d.keySet());
    }

    public int c() {
        return this.f6462d.size();
    }

    public t<EndPointType> a(String str) {
        return this.f6462d.get(str);
    }

    public t<EndPointType> a(EndPointType endpointtype) {
        return this.f6462d.get(endpointtype.getId());
    }

    public static Boolean a() {
        if (a(C0578la.class).c() + a(Fa.class).c() + a(AdobePhotoCollection.class).c() == 0) {
            return true;
        }
        return false;
    }
}
