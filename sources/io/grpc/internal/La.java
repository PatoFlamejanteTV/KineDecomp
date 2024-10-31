package io.grpc.internal;

import com.google.common.base.MoreObjects;
import io.grpc.C2528x;
import io.grpc.InterfaceC2521p;
import io.grpc.Status;
import java.io.InputStream;

/* compiled from: ForwardingClientStream.java */
/* loaded from: classes3.dex */
abstract class La implements X {
    @Override // io.grpc.internal.Nc
    public void a(int i) {
        b().a(i);
    }

    protected abstract X b();

    @Override // io.grpc.internal.X
    public void b(int i) {
        b().b(i);
    }

    @Override // io.grpc.internal.X
    public void c(int i) {
        b().c(i);
    }

    @Override // io.grpc.internal.Nc
    public void flush() {
        b().flush();
    }

    public String toString() {
        return MoreObjects.a(this).a("delegate", b()).toString();
    }

    @Override // io.grpc.internal.Nc
    public void a(InputStream inputStream) {
        b().a(inputStream);
    }

    @Override // io.grpc.internal.Nc
    public void a(InterfaceC2521p interfaceC2521p) {
        b().a(interfaceC2521p);
    }

    @Override // io.grpc.internal.X
    public void a(Status status) {
        b().a(status);
    }

    @Override // io.grpc.internal.X
    public void a() {
        b().a();
    }

    @Override // io.grpc.internal.X
    public void a(String str) {
        b().a(str);
    }

    @Override // io.grpc.internal.X
    public void a(boolean z) {
        b().a(z);
    }

    @Override // io.grpc.internal.X
    public void a(C2528x c2528x) {
        b().a(c2528x);
    }

    @Override // io.grpc.internal.X
    public void a(ClientStreamListener clientStreamListener) {
        b().a(clientStreamListener);
    }
}
