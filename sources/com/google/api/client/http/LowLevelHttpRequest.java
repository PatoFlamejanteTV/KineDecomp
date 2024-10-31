package com.google.api.client.http;

import com.google.api.client.util.StreamingContent;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class LowLevelHttpRequest {

    /* renamed from: a, reason: collision with root package name */
    private long f2471a = -1;
    private String b;
    private String c;
    private StreamingContent d;

    public abstract LowLevelHttpResponse a() throws IOException;

    public abstract void a(String str, String str2) throws IOException;

    public final void a(long j) throws IOException {
        this.f2471a = j;
    }

    public final long b() {
        return this.f2471a;
    }

    public final void a(String str) throws IOException {
        this.b = str;
    }

    public final String c() {
        return this.b;
    }

    public final void b(String str) throws IOException {
        this.c = str;
    }

    public final String d() {
        return this.c;
    }

    public final void a(StreamingContent streamingContent) throws IOException {
        this.d = streamingContent;
    }

    public final StreamingContent e() {
        return this.d;
    }

    public void a(int i, int i2) throws IOException {
    }
}
