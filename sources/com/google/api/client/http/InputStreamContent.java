package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class InputStreamContent extends AbstractInputStreamContent {

    /* renamed from: a, reason: collision with root package name */
    private long f2470a;
    private boolean b;
    private final InputStream c;

    public InputStreamContent(String str, InputStream inputStream) {
        super(str);
        this.f2470a = -1L;
        this.c = (InputStream) Preconditions.a(inputStream);
    }

    @Override // com.google.api.client.http.HttpContent
    public long a() {
        return this.f2470a;
    }

    @Override // com.google.api.client.http.HttpContent
    public boolean f() {
        return this.b;
    }

    public InputStreamContent b(boolean z) {
        this.b = z;
        return this;
    }

    @Override // com.google.api.client.http.AbstractInputStreamContent
    public InputStream b() {
        return this.c;
    }

    @Override // com.google.api.client.http.AbstractInputStreamContent
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public InputStreamContent a(String str) {
        return (InputStreamContent) super.a(str);
    }

    @Override // com.google.api.client.http.AbstractInputStreamContent
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InputStreamContent a(boolean z) {
        return (InputStreamContent) super.a(z);
    }

    public InputStreamContent a(long j) {
        this.f2470a = j;
        return this;
    }
}
