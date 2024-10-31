package com.google.api.client.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class FileContent extends AbstractInputStreamContent {

    /* renamed from: c */
    private final File f14733c;

    @Override // com.google.api.client.http.HttpContent
    public boolean a() {
        return true;
    }

    @Override // com.google.api.client.http.AbstractInputStreamContent
    public InputStream c() throws FileNotFoundException {
        return new FileInputStream(this.f14733c);
    }

    @Override // com.google.api.client.http.HttpContent
    public long getLength() {
        return this.f14733c.length();
    }

    @Override // com.google.api.client.http.AbstractInputStreamContent
    public FileContent a(String str) {
        super.a(str);
        return this;
    }
}
