package com.adobe.creativesdk.foundation.internal.storage.controllers.commands;

import com.adobe.creativesdk.foundation.internal.storage.controllers.C0358a;
import java.util.EnumSet;
import java.util.Iterator;

/* compiled from: AdobeAssetViewCommandsHandler.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    l f5977a;

    private void a(boolean z) {
        Iterator it = a().iterator();
        while (it.hasNext()) {
            AdobeAssetViewBrowserCommandName adobeAssetViewBrowserCommandName = (AdobeAssetViewBrowserCommandName) it.next();
            if (z) {
                C0358a.a().a(adobeAssetViewBrowserCommandName, this.f5977a);
            } else {
                C0358a.a().b(adobeAssetViewBrowserCommandName, this.f5977a);
            }
        }
    }

    protected EnumSet<AdobeAssetViewBrowserCommandName> a() {
        throw null;
    }

    public void a(AdobeAssetViewBrowserCommandName adobeAssetViewBrowserCommandName, Object obj) {
        throw null;
    }

    public void b() {
        d();
    }

    public void c() {
        e();
    }

    protected void d() {
        if (this.f5977a == null) {
            this.f5977a = new b(this);
        }
        a(true);
    }

    protected void e() {
        a(false);
    }
}
