package com.bumptech.glide.load.b;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.b.u;
import java.io.InputStream;

/* compiled from: ResourceLoader.java */
/* loaded from: classes.dex */
public class z<Data> implements u<Integer, Data> {

    /* renamed from: a, reason: collision with root package name */
    private final u<Uri, Data> f8671a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources f8672b;

    /* compiled from: ResourceLoader.java */
    /* loaded from: classes.dex */
    public static final class a implements v<Integer, AssetFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f8673a;

        public a(Resources resources) {
            this.f8673a = resources;
        }

        @Override // com.bumptech.glide.load.b.v
        public u<Integer, AssetFileDescriptor> a(y yVar) {
            return new z(this.f8673a, yVar.a(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* compiled from: ResourceLoader.java */
    /* loaded from: classes.dex */
    public static class b implements v<Integer, ParcelFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f8674a;

        public b(Resources resources) {
            this.f8674a = resources;
        }

        @Override // com.bumptech.glide.load.b.v
        public u<Integer, ParcelFileDescriptor> a(y yVar) {
            return new z(this.f8674a, yVar.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* compiled from: ResourceLoader.java */
    /* loaded from: classes.dex */
    public static class c implements v<Integer, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f8675a;

        public c(Resources resources) {
            this.f8675a = resources;
        }

        @Override // com.bumptech.glide.load.b.v
        public u<Integer, InputStream> a(y yVar) {
            return new z(this.f8675a, yVar.a(Uri.class, InputStream.class));
        }
    }

    /* compiled from: ResourceLoader.java */
    /* loaded from: classes.dex */
    public static class d implements v<Integer, Uri> {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f8676a;

        public d(Resources resources) {
            this.f8676a = resources;
        }

        @Override // com.bumptech.glide.load.b.v
        public u<Integer, Uri> a(y yVar) {
            return new z(this.f8676a, C.a());
        }
    }

    public z(Resources resources, u<Uri, Data> uVar) {
        this.f8672b = resources;
        this.f8671a = uVar;
    }

    private Uri b(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f8672b.getResourcePackageName(num.intValue()) + '/' + this.f8672b.getResourceTypeName(num.intValue()) + '/' + this.f8672b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e2) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            Log.w("ResourceLoader", "Received invalid resource id: " + num, e2);
            return null;
        }
    }

    @Override // com.bumptech.glide.load.b.u
    public boolean a(Integer num) {
        return true;
    }

    @Override // com.bumptech.glide.load.b.u
    public u.a<Data> a(Integer num, int i, int i2, com.bumptech.glide.load.g gVar) {
        Uri b2 = b(num);
        if (b2 == null) {
            return null;
        }
        return this.f8671a.a(b2, i, i2, gVar);
    }
}
