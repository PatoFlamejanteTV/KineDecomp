package com.facebook.applinks;

import a.f;
import a.g;
import android.net.Uri;
import java.util.Map;

/* compiled from: FacebookAppLinkResolver.java */
/* loaded from: classes.dex */
class b implements f<Map<Uri, a.b>, a.b> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Uri f258a;
    final /* synthetic */ FacebookAppLinkResolver b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FacebookAppLinkResolver facebookAppLinkResolver, Uri uri) {
        this.b = facebookAppLinkResolver;
        this.f258a = uri;
    }

    @Override // a.f
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a.b a(g<Map<Uri, a.b>> gVar) throws Exception {
        return gVar.e().get(this.f258a);
    }
}
