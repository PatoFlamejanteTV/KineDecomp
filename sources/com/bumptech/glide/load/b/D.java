package com.bumptech.glide.load.b;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.b.u;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: UriLoader.java */
/* loaded from: classes.dex */
public class D<Data> implements u<Uri, Data> {

    /* renamed from: a, reason: collision with root package name */
    private static final Set<String> f8579a = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "android.resource", "content")));

    /* renamed from: b, reason: collision with root package name */
    private final c<Data> f8580b;

    /* compiled from: UriLoader.java */
    /* loaded from: classes.dex */
    public static final class a implements v<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f8581a;

        public a(ContentResolver contentResolver) {
            this.f8581a = contentResolver;
        }

        @Override // com.bumptech.glide.load.b.v
        public u<Uri, AssetFileDescriptor> a(y yVar) {
            return new D(this);
        }

        @Override // com.bumptech.glide.load.b.D.c
        public com.bumptech.glide.load.a.d<AssetFileDescriptor> a(Uri uri) {
            return new com.bumptech.glide.load.a.a(this.f8581a, uri);
        }
    }

    /* compiled from: UriLoader.java */
    /* loaded from: classes.dex */
    public static class b implements v<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f8582a;

        public b(ContentResolver contentResolver) {
            this.f8582a = contentResolver;
        }

        @Override // com.bumptech.glide.load.b.D.c
        public com.bumptech.glide.load.a.d<ParcelFileDescriptor> a(Uri uri) {
            return new com.bumptech.glide.load.a.j(this.f8582a, uri);
        }

        @Override // com.bumptech.glide.load.b.v
        public u<Uri, ParcelFileDescriptor> a(y yVar) {
            return new D(this);
        }
    }

    /* compiled from: UriLoader.java */
    /* loaded from: classes.dex */
    public interface c<Data> {
        com.bumptech.glide.load.a.d<Data> a(Uri uri);
    }

    /* compiled from: UriLoader.java */
    /* loaded from: classes.dex */
    public static class d implements v<Uri, InputStream>, c<InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f8583a;

        public d(ContentResolver contentResolver) {
            this.f8583a = contentResolver;
        }

        @Override // com.bumptech.glide.load.b.D.c
        public com.bumptech.glide.load.a.d<InputStream> a(Uri uri) {
            return new com.bumptech.glide.load.a.o(this.f8583a, uri);
        }

        @Override // com.bumptech.glide.load.b.v
        public u<Uri, InputStream> a(y yVar) {
            return new D(this);
        }
    }

    public D(c<Data> cVar) {
        this.f8580b = cVar;
    }

    @Override // com.bumptech.glide.load.b.u
    public u.a<Data> a(Uri uri, int i, int i2, com.bumptech.glide.load.g gVar) {
        return new u.a<>(new com.bumptech.glide.f.c(uri), this.f8580b.a(uri));
    }

    @Override // com.bumptech.glide.load.b.u
    public boolean a(Uri uri) {
        return f8579a.contains(uri.getScheme());
    }
}
