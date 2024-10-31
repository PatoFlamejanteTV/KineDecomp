package io.grpc.a.a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import io.grpc.I;
import io.grpc.InterfaceC2529y;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;

/* compiled from: ProtoInputStream.java */
/* loaded from: classes3.dex */
class a extends InputStream implements InterfaceC2529y, I {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private MessageLite f27148a;

    /* renamed from: b, reason: collision with root package name */
    private final Parser<?> f27149b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private ByteArrayInputStream f27150c;

    public a(MessageLite messageLite, Parser<?> parser) {
        this.f27148a = messageLite;
        this.f27149b = parser;
    }

    @Override // io.grpc.InterfaceC2529y
    public int a(OutputStream outputStream) throws IOException {
        MessageLite messageLite = this.f27148a;
        if (messageLite != null) {
            int d2 = messageLite.d();
            this.f27148a.writeTo(outputStream);
            this.f27148a = null;
            return d2;
        }
        ByteArrayInputStream byteArrayInputStream = this.f27150c;
        if (byteArrayInputStream == null) {
            return 0;
        }
        int a2 = (int) d.a(byteArrayInputStream, outputStream);
        this.f27150c = null;
        return a2;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        MessageLite messageLite = this.f27148a;
        if (messageLite != null) {
            return messageLite.d();
        }
        ByteArrayInputStream byteArrayInputStream = this.f27150c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.available();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parser<?> b() {
        return this.f27149b;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        MessageLite messageLite = this.f27148a;
        if (messageLite != null) {
            this.f27150c = new ByteArrayInputStream(messageLite.toByteArray());
            this.f27148a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f27150c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        MessageLite messageLite = this.f27148a;
        if (messageLite != null) {
            int d2 = messageLite.d();
            if (d2 == 0) {
                this.f27148a = null;
                this.f27150c = null;
                return -1;
            }
            if (i2 >= d2) {
                CodedOutputStream b2 = CodedOutputStream.b(bArr, i, d2);
                this.f27148a.a(b2);
                b2.d();
                b2.c();
                this.f27148a = null;
                this.f27150c = null;
                return d2;
            }
            this.f27150c = new ByteArrayInputStream(this.f27148a.toByteArray());
            this.f27148a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f27150c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read(bArr, i, i2);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageLite a() {
        MessageLite messageLite = this.f27148a;
        if (messageLite != null) {
            return messageLite;
        }
        throw new IllegalStateException("message not available");
    }
}
