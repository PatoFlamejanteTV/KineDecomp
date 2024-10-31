package io.grpc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: Codec.java */
/* renamed from: io.grpc.o */
/* loaded from: classes3.dex */
public interface InterfaceC2514o extends InterfaceC2521p, InterfaceC2527w {

    /* compiled from: Codec.java */
    /* renamed from: io.grpc.o$a */
    /* loaded from: classes3.dex */
    public static final class a implements InterfaceC2514o {
        @Override // io.grpc.InterfaceC2521p
        public OutputStream a(OutputStream outputStream) throws IOException {
            return new GZIPOutputStream(outputStream);
        }

        @Override // io.grpc.InterfaceC2521p, io.grpc.InterfaceC2527w
        public String a() {
            return "gzip";
        }

        @Override // io.grpc.InterfaceC2527w
        public InputStream a(InputStream inputStream) throws IOException {
            return new GZIPInputStream(inputStream);
        }
    }

    /* compiled from: Codec.java */
    /* renamed from: io.grpc.o$b */
    /* loaded from: classes3.dex */
    public static final class b implements InterfaceC2514o {

        /* renamed from: a */
        public static final InterfaceC2514o f27821a = new b();

        private b() {
        }

        @Override // io.grpc.InterfaceC2527w
        public InputStream a(InputStream inputStream) throws IOException {
            return inputStream;
        }

        @Override // io.grpc.InterfaceC2521p
        public OutputStream a(OutputStream outputStream) throws IOException {
            return outputStream;
        }

        @Override // io.grpc.InterfaceC2521p, io.grpc.InterfaceC2527w
        public String a() {
            return "identity";
        }
    }
}
