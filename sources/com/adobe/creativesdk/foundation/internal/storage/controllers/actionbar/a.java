package com.adobe.creativesdk.foundation.internal.storage.controllers.actionbar;

import android.R;
import com.adobe.creativesdk.foundation.internal.utils.b;
import com.facebook.internal.NativeProtocol;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AdobeUxActionBarController.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private static a f5943a;

    /* renamed from: b */
    private com.adobe.creativesdk.foundation.internal.base.a f5944b;

    /* renamed from: c */
    private Map<String, String> f5945c = new HashMap<String, String>() { // from class: com.adobe.creativesdk.foundation.internal.storage.controllers.actionbar.AdobeUxActionBarController$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            put("area", "browser");
            put(NativeProtocol.WEB_DIALOG_ACTION, "view");
        }
    };

    public static void a(a aVar) {
        if (f5943a != aVar) {
            return;
        }
        c();
    }

    public static void b(a aVar) {
        a aVar2 = f5943a;
        if (aVar2 != null && aVar2 != aVar) {
            c();
        }
        f5943a = aVar;
    }

    private static void c() {
        a aVar = f5943a;
        if (aVar != null) {
            aVar.b();
        }
        f5943a = null;
    }

    public static a a() {
        return f5943a;
    }

    private void b() {
        this.f5944b = null;
    }

    public void a(com.adobe.creativesdk.foundation.internal.base.a aVar) {
        this.f5944b = aVar;
    }

    public static void a(String str) {
        b.a(a().f5944b.findViewById(R.id.content), str);
    }
}
