package com.squareup.okhttp.internal.framed;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* compiled from: FrameReader.java */
/* renamed from: com.squareup.okhttp.internal.framed.a */
/* loaded from: classes3.dex */
public interface InterfaceC2384a extends Closeable {

    /* compiled from: FrameReader.java */
    /* renamed from: com.squareup.okhttp.internal.framed.a$a */
    /* loaded from: classes3.dex */
    public interface InterfaceC0130a {
        void a(int i, int i2, int i3, boolean z);

        void a(int i, int i2, List<q> list) throws IOException;

        void a(int i, long j);

        void a(int i, ErrorCode errorCode);

        void a(int i, ErrorCode errorCode, ByteString byteString);

        void a(boolean z, int i, int i2);

        void a(boolean z, int i, okio.i iVar, int i2) throws IOException;

        void a(boolean z, A a2);

        void a(boolean z, boolean z2, int i, int i2, List<q> list, HeadersMode headersMode);

        void b();
    }

    void H() throws IOException;

    boolean a(InterfaceC0130a interfaceC0130a) throws IOException;
}
