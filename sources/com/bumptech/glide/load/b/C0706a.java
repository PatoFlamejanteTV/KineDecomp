package com.bumptech.glide.load.b;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.b.u;
import java.io.InputStream;

/* compiled from: AssetUriLoader.java */
/* renamed from: com.bumptech.glide.load.b.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0706a<Data> implements u<Uri, Data> {

    /* renamed from: a, reason: collision with root package name */
    private static final int f8586a = 22;

    /* renamed from: b, reason: collision with root package name */
    private final AssetManager f8587b;

    /* renamed from: c, reason: collision with root package name */
    private final InterfaceC0049a<Data> f8588c;

    /* compiled from: AssetUriLoader.java */
    /* renamed from: com.bumptech.glide.load.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0049a<Data> {
        com.bumptech.glide.load.a.d<Data> a(AssetManager assetManager, String str);
    }

    /* compiled from: AssetUriLoader.java */
    /* renamed from: com.bumptech.glide.load.b.a$b */
    /* loaded from: classes.dex */
    public static class b implements v<Uri, ParcelFileDescriptor>, InterfaceC0049a<ParcelFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final AssetManager f8594a;

        public b(AssetManager assetManager) {
            this.f8594a = assetManager;
        }

        @Override // com.bumptech.glide.load.b.v
        public u<Uri, ParcelFileDescriptor> a(y yVar) {
            return new C0706a(this.f8594a, this);
        }

        @Override // com.bumptech.glide.load.b.C0706a.InterfaceC0049a
        public com.bumptech.glide.load.a.d<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.a.i(assetManager, str);
        }
    }

    /* compiled from: AssetUriLoader.java */
    /* renamed from: com.bumptech.glide.load.b.a$c */
    /* loaded from: classes.dex */
    public static class c implements v<Uri, InputStream>, InterfaceC0049a<InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final AssetManager f8596a;

        public c(AssetManager assetManager) {
            this.f8596a = assetManager;
        }

        @Override // com.bumptech.glide.load.b.v
        public u<Uri, InputStream> a(y yVar) {
            return new C0706a(this.f8596a, this);
        }

        @Override // com.bumptech.glide.load.b.C0706a.InterfaceC0049a
        public com.bumptech.glide.load.a.d<InputStream> a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.a.n(assetManager, str);
        }
    }

    public C0706a(AssetManager assetManager, InterfaceC0049a<Data> interfaceC0049a) {
        this.f8587b = assetManager;
        this.f8588c = interfaceC0049a;
    }

    @Override // com.bumptech.glide.load.b.u
    public u.a<Data> a(Uri uri, int i, int i2, com.bumptech.glide.load.g gVar) {
        return new u.a<>(new com.bumptech.glide.f.c(uri), this.f8588c.a(this.f8587b, uri.toString().substring(f8586a)));
    }

    @Override // com.bumptech.glide.load.b.u
    public boolean a(Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}
