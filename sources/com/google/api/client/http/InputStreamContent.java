package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class InputStreamContent extends AbstractInputStreamContent {

    /* renamed from: c */
    private long f14788c;

    /* renamed from: d */
    private boolean f14789d;

    /* renamed from: e */
    private final InputStream f14790e;

    public InputStreamContent(String str, InputStream inputStream) {
        super(str);
        this.f14788c = -1L;
        Preconditions.a(inputStream);
        this.f14790e = inputStream;
    }

    public InputStreamContent b(boolean z) {
        this.f14789d = z;
        return this;
    }

    @Override // com.google.api.client.http.AbstractInputStreamContent
    public InputStream c() {
        return this.f14790e;
    }

    @Override // com.google.api.client.http.HttpContent
    public long getLength() {
        return this.f14788c;
    }

    @Override // com.google.api.client.http.HttpContent
    public boolean a() {
        return this.f14789d;
    }

    @Override // com.google.api.client.http.AbstractInputStreamContent
    public InputStreamContent a(String str) {
        super.a(str);
        return this;
    }

    @Override // com.google.api.client.http.AbstractInputStreamContent
    public InputStreamContent a(boolean z) {
        super.a(z);
        return this;
    }

    public InputStreamContent a(long j) {
        this.f14788c = j;
        return this;
    }
}
