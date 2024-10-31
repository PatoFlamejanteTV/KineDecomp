package com.adobe.creativesdk.foundation.internal.storage.a.a;

import android.content.Context;
import android.os.Handler;
import c.a.a.a.c;
import com.adobe.creativesdk.foundation.adobeinternal.storage.library.E;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService;
import com.adobe.creativesdk.foundation.internal.net.A;
import com.adobe.creativesdk.foundation.internal.net.AdobeNetworkHttpRequestMethod;
import com.adobe.creativesdk.foundation.internal.net.AdobeNetworkRequestPriority;
import com.adobe.creativesdk.foundation.internal.net.G;
import com.adobe.creativesdk.foundation.internal.net.j;
import com.adobe.creativesdk.foundation.internal.net.l;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.Gb;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AdobeLibraryXferUtils.java */
/* loaded from: classes.dex */
public class b implements G {

    /* renamed from: a, reason: collision with root package name */
    private static b f5283a;

    /* renamed from: b, reason: collision with root package name */
    private static Map<String, A> f5284b;

    private b() {
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f5283a == null) {
                f5283a = new b();
            }
            bVar = f5283a;
        }
        return bVar;
    }

    public static boolean a(String str) {
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.G
    public void a(A a2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.G
    public boolean b(A a2) {
        if (a2 != null && a2.c() != null) {
            String c2 = AdobeAuthIdentityManagementService.K().c();
            if (!a2.c().equals(c2)) {
                a2.a(c2);
                a2.a(false);
                return true;
            }
        }
        return false;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.G
    public void c(A a2) {
    }

    public A a(URL url) {
        String str;
        synchronized (this) {
            if (f5284b == null) {
                f5284b = new HashMap();
            }
        }
        String url2 = url.toString();
        if (!url2.endsWith("/")) {
            url2 = url2 + "/";
        }
        A a2 = f5284b.get(url2);
        if (a2 != null) {
            return a2;
        }
        String lowerCase = url.getHost().toLowerCase();
        boolean z = false;
        int i = 0;
        while (true) {
            String[] strArr = E.f4521c;
            if (i >= strArr.length) {
                break;
            }
            if (lowerCase.startsWith(strArr[i])) {
                z = true;
                break;
            }
            i++;
        }
        HashMap hashMap = new HashMap();
        if (z) {
            AdobeAuthIdentityManagementService K = AdobeAuthIdentityManagementService.K();
            str = K.c();
            if (K.h() != null) {
                hashMap.put("x-api-key", K.h());
            }
        } else {
            str = null;
        }
        Context a3 = c.a.a.a.c.a.a.b().a();
        A a4 = new A(url2, a3 != null ? a3.getPackageName() : null, hashMap);
        if (z) {
            a4.a(str);
            a4.a(this);
        }
        f5284b.put(url2, a4);
        return a4;
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(URL url, String str, c.a.a.a.b<Void> bVar, c<AdobeNetworkException> cVar) {
        if (!Gb.f().k()) {
            return null;
        }
        A a2 = new A(url.toString(), AdobeAuthIdentityManagementService.K().h(), null);
        a2.a(AdobeAuthIdentityManagementService.K().c());
        j jVar = new j();
        jVar.a(url);
        jVar.a(AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET);
        a aVar = new a(this, bVar, cVar);
        if (str != null) {
            return a2.a(jVar, str, AdobeNetworkRequestPriority.NORMAL, aVar, (Handler) null);
        }
        return a2.a(jVar, AdobeNetworkRequestPriority.NORMAL, aVar, null);
    }

    public static boolean a(l lVar) {
        int g2 = lVar.g();
        lVar.f();
        return g2 > 0 && g2 != 401 && g2 != 407 && g2 != 408 && g2 >= 400 && g2 < 500;
    }
}
