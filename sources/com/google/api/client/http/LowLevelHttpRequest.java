package com.google.api.client.http;

import com.google.api.client.util.StreamingContent;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class LowLevelHttpRequest {

    /* renamed from: a */
    private long f14791a = -1;

    /* renamed from: b */
    private String f14792b;

    /* renamed from: c */
    private String f14793c;

    /* renamed from: d */
    private StreamingContent f14794d;

    public abstract LowLevelHttpResponse a() throws IOException;

    public void a(int i, int i2) throws IOException {
    }

    public final void a(long j) throws IOException {
        this.f14791a = j;
    }

    public abstract void a(String str, String str2) throws IOException;

    public final String b() {
        return this.f14792b;
    }

    public final long c() {
        return this.f14791a;
    }

    public final String d() {
        return this.f14793c;
    }

    public final StreamingContent e() {
        return this.f14794d;
    }

    public final void a(String str) throws IOException {
        this.f14792b = str;
    }

    public final void b(String str) throws IOException {
        this.f14793c = str;
    }

    public final void a(StreamingContent streamingContent) throws IOException {
        this.f14794d = streamingContent;
    }
}
