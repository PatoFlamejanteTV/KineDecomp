package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: HttpRequest.java */
/* loaded from: classes3.dex */
public class d extends HttpRequest.a<HttpRequest> {

    /* renamed from: c */
    final /* synthetic */ InputStream f26980c;

    /* renamed from: d */
    final /* synthetic */ OutputStream f26981d;

    /* renamed from: e */
    final /* synthetic */ HttpRequest f26982e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(HttpRequest httpRequest, Closeable closeable, boolean z, InputStream inputStream, OutputStream outputStream) {
        super(closeable, z);
        this.f26982e = httpRequest;
        this.f26980c = inputStream;
        this.f26981d = outputStream;
    }

    @Override // io.fabric.sdk.android.services.network.HttpRequest.c
    public HttpRequest b() throws IOException {
        int i;
        i = this.f26982e.j;
        byte[] bArr = new byte[i];
        while (true) {
            int read = this.f26980c.read(bArr);
            if (read != -1) {
                this.f26981d.write(bArr, 0, read);
            } else {
                return this.f26982e;
            }
        }
    }
}
