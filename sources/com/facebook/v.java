package com.facebook;

import com.facebook.GraphRequest;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GraphRequest.java */
/* loaded from: classes.dex */
public class v implements GraphRequest.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ArrayList f9665a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ GraphRequest f9666b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(GraphRequest graphRequest, ArrayList arrayList) {
        this.f9666b = graphRequest;
        this.f9665a = arrayList;
    }

    @Override // com.facebook.GraphRequest.b
    public void a(String str, String str2) throws IOException {
        this.f9665a.add(String.format(Locale.US, "%s=%s", str, URLEncoder.encode(str2, "UTF-8")));
    }
}
