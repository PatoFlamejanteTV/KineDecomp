package io.grpc.okhttp.internal.framed;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import okio.i;

/* compiled from: FrameReader.java */
/* loaded from: classes3.dex */
public interface a extends Closeable {

    /* compiled from: FrameReader.java */
    /* renamed from: io.grpc.okhttp.internal.framed.a$a */
    /* loaded from: classes3.dex */
    public interface InterfaceC0159a {
        void a(int i, int i2, int i3, boolean z);

        void a(int i, int i2, List<c> list) throws IOException;

        void a(int i, long j);

        void a(int i, ErrorCode errorCode);

        void a(int i, ErrorCode errorCode, ByteString byteString);

        void a(boolean z, int i, int i2);

        void a(boolean z, int i, i iVar, int i2) throws IOException;

        void a(boolean z, g gVar);

        void a(boolean z, boolean z2, int i, int i2, List<c> list, HeadersMode headersMode);

        void b();
    }

    boolean a(InterfaceC0159a interfaceC0159a) throws IOException;
}
