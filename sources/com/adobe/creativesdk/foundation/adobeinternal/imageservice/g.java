package com.adobe.creativesdk.foundation.adobeinternal.imageservice;

import com.adobe.creativesdk.foundation.internal.net.F;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import java.io.FileNotFoundException;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeImageSession.java */
/* loaded from: classes.dex */
public class g implements F {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4007a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ b f4008b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f4009c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.net.j f4010d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ v f4011e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ t f4012f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(t tVar, String str, b bVar, String str2, com.adobe.creativesdk.foundation.internal.net.j jVar, v vVar) {
        this.f4012f = tVar;
        this.f4007a = str;
        this.f4008b = bVar;
        this.f4009c = str2;
        this.f4010d = jVar;
        this.f4011e = vVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        String str;
        String str2;
        Map map;
        int g2 = lVar.g();
        Level level = Level.DEBUG;
        str = t.j;
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, str, "onSuccess : " + g2);
        if (g2 != 200 && g2 != 201 && g2 != 204) {
            t.a(this.f4007a, this.f4009c);
            this.f4011e.a(this.f4012f.a(lVar));
            return;
        }
        try {
            b a2 = b.a(this.f4007a, this.f4008b, lVar);
            t.a(this.f4007a, this.f4009c);
            map = this.f4012f.k;
            map.remove(this.f4010d);
            this.f4011e.a(a2);
        } catch (AdobeNetworkException | AdobeAssetException | FileNotFoundException e2) {
            Level level2 = Level.ERROR;
            str2 = t.j;
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level2, str2, "", e2);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(AdobeNetworkException adobeNetworkException) {
        String str;
        Level level = Level.ERROR;
        str = t.j;
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, str, "exception : " + adobeNetworkException.getMessage());
        t.a(this.f4007a, this.f4009c);
        this.f4011e.a(adobeNetworkException);
    }
}
