package com.google.api.client.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class FileContent extends AbstractInputStreamContent {

    /* renamed from: a, reason: collision with root package name */
    private final File f2455a;

    @Override // com.google.api.client.http.HttpContent
    public long a() {
        return this.f2455a.length();
    }

    @Override // com.google.api.client.http.HttpContent
    public boolean f() {
        return true;
    }

    @Override // com.google.api.client.http.AbstractInputStreamContent
    public InputStream b() throws FileNotFoundException {
        return new FileInputStream(this.f2455a);
    }

    @Override // com.google.api.client.http.AbstractInputStreamContent
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FileContent a(String str) {
        return (FileContent) super.a(str);
    }

    @Override // com.google.api.client.http.AbstractInputStreamContent
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FileContent a(boolean z) {
        return (FileContent) super.a(z);
    }
}
