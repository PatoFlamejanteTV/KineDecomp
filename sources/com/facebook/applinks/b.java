package com.facebook.applinks;

import android.net.Uri;
import bolts.i;
import bolts.p;
import java.util.Map;

/* compiled from: FacebookAppLinkResolver.java */
/* loaded from: classes.dex */
class b implements i<Map<Uri, bolts.c>, bolts.c> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Uri f9238a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ FacebookAppLinkResolver f9239b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FacebookAppLinkResolver facebookAppLinkResolver, Uri uri) {
        this.f9239b = facebookAppLinkResolver;
        this.f9238a = uri;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // bolts.i
    public bolts.c a(p<Map<Uri, bolts.c>> pVar) throws Exception {
        return pVar.d().get(this.f9238a);
    }
}
