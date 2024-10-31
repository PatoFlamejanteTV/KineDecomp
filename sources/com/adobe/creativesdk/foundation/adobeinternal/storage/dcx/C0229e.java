package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXComposite.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0229e implements C0231f.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map f4349a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0231f f4350b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0229e(C0231f c0231f, Map map) {
        this.f4350b = c0231f;
        this.f4349a = map;
    }

    public void a() {
        Iterator it = this.f4349a.entrySet().iterator();
        while (it.hasNext()) {
            String str = (String) ((Map.Entry) it.next()).getValue();
            new File(str).delete();
            this.f4350b.b(str);
        }
    }
}
