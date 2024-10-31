package com.google.api.client.http.apache;

import com.google.api.client.util.Preconditions;
import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

/* compiled from: HttpExtensionMethod.java */
/* loaded from: classes2.dex */
final class d extends HttpEntityEnclosingRequestBase {

    /* renamed from: a */
    private final String f14810a;

    public d(String str, String str2) {
        Preconditions.a(str);
        this.f14810a = str;
        setURI(URI.create(str2));
    }

    @Override // org.apache.http.client.methods.HttpRequestBase, org.apache.http.client.methods.HttpUriRequest
    public String getMethod() {
        return this.f14810a;
    }
}
