package com.google.api.client.http.apache;

import com.google.api.client.util.Preconditions;
import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

/* compiled from: HttpExtensionMethod.java */
/* loaded from: classes.dex */
final class d extends HttpEntityEnclosingRequestBase {

    /* renamed from: a, reason: collision with root package name */
    private final String f2481a;

    public d(String str, String str2) {
        this.f2481a = (String) Preconditions.a(str);
        setURI(URI.create(str2));
    }
}
