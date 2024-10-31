package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.storage.C0578la;
import java.util.ArrayList;

/* compiled from: AdobeAssetDataSourceMgr.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0363b {

    /* renamed from: a, reason: collision with root package name */
    private static C0363b f5946a;

    /* renamed from: b, reason: collision with root package name */
    ArrayList<String> f5947b = new ArrayList<>();

    public static C0363b a() {
        if (f5946a == null) {
            f5946a = new C0363b();
        }
        return f5946a;
    }

    public boolean a(C0578la c0578la, boolean z) {
        if (this.f5947b.size() == 0) {
            return false;
        }
        String uri = c0578la.getHref().toString();
        for (int i = 0; i < this.f5947b.size(); i++) {
            if (this.f5947b.get(i).equalsIgnoreCase(uri)) {
                if (!z) {
                    return true;
                }
                this.f5947b.remove(i);
                return true;
            }
        }
        return false;
    }

    public void a(C0578la c0578la) {
        if (a(c0578la, false)) {
            return;
        }
        this.f5947b.add(c0578la.getHref().toString());
    }
}
