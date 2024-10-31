package com.bumptech.glide.load.b;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.b.u;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: ByteArrayLoader.java */
/* renamed from: com.bumptech.glide.load.b.c */
/* loaded from: classes.dex */
public class C0708c<Data> implements u<byte[], Data> {

    /* renamed from: a */
    private final b<Data> f8602a;

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: com.bumptech.glide.load.b.c$a */
    /* loaded from: classes.dex */
    public static class a implements v<byte[], ByteBuffer> {
        @Override // com.bumptech.glide.load.b.v
        public u<byte[], ByteBuffer> a(y yVar) {
            return new C0708c(new C0707b(this));
        }
    }

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: com.bumptech.glide.load.b.c$b */
    /* loaded from: classes.dex */
    public interface b<Data> {
        Class<Data> a();

        Data a(byte[] bArr);
    }

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: com.bumptech.glide.load.b.c$d */
    /* loaded from: classes.dex */
    public static class d implements v<byte[], InputStream> {
        @Override // com.bumptech.glide.load.b.v
        public u<byte[], InputStream> a(y yVar) {
            return new C0708c(new C0709d(this));
        }
    }

    public C0708c(b<Data> bVar) {
        this.f8602a = bVar;
    }

    @Override // com.bumptech.glide.load.b.u
    public boolean a(byte[] bArr) {
        return true;
    }

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: com.bumptech.glide.load.b.c$c */
    /* loaded from: classes.dex */
    public static class C0051c<Data> implements com.bumptech.glide.load.a.d<Data> {

        /* renamed from: a */
        private final byte[] f8603a;

        /* renamed from: b */
        private final b<Data> f8604b;

        C0051c(byte[] bArr, b<Data> bVar) {
            this.f8603a = bArr;
            this.f8604b = bVar;
        }

        @Override // com.bumptech.glide.load.a.d
        public void a(Priority priority, d.a<? super Data> aVar) {
            aVar.a((d.a<? super Data>) this.f8604b.a(this.f8603a));
        }

        @Override // com.bumptech.glide.load.a.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.a.d
        public DataSource c() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.a.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.a.d
        public Class<Data> a() {
            return this.f8604b.a();
        }
    }

    @Override // com.bumptech.glide.load.b.u
    public u.a<Data> a(byte[] bArr, int i, int i2, com.bumptech.glide.load.g gVar) {
        return new u.a<>(new com.bumptech.glide.f.c(bArr), new C0051c(bArr, this.f8602a));
    }
}
