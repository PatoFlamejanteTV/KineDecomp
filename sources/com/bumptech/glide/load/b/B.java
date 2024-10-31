package com.bumptech.glide.load.b;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.bumptech.glide.load.b.u;
import java.io.File;
import java.io.InputStream;

/* compiled from: StringLoader.java */
/* loaded from: classes.dex */
public class B<Data> implements u<String, Data> {

    /* renamed from: a, reason: collision with root package name */
    private final u<Uri, Data> f8575a;

    /* compiled from: StringLoader.java */
    /* loaded from: classes.dex */
    public static final class a implements v<String, AssetFileDescriptor> {
        @Override // com.bumptech.glide.load.b.v
        public u<String, AssetFileDescriptor> a(y yVar) {
            return new B(yVar.a(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* compiled from: StringLoader.java */
    /* loaded from: classes.dex */
    public static class b implements v<String, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.b.v
        public u<String, ParcelFileDescriptor> a(y yVar) {
            return new B(yVar.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* compiled from: StringLoader.java */
    /* loaded from: classes.dex */
    public static class c implements v<String, InputStream> {
        @Override // com.bumptech.glide.load.b.v
        public u<String, InputStream> a(y yVar) {
            return new B(yVar.a(Uri.class, InputStream.class));
        }
    }

    public B(u<Uri, Data> uVar) {
        this.f8575a = uVar;
    }

    private static Uri b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return c(str);
        }
        Uri parse = Uri.parse(str);
        return parse.getScheme() == null ? c(str) : parse;
    }

    private static Uri c(String str) {
        return Uri.fromFile(new File(str));
    }

    @Override // com.bumptech.glide.load.b.u
    public boolean a(String str) {
        return true;
    }

    @Override // com.bumptech.glide.load.b.u
    public u.a<Data> a(String str, int i, int i2, com.bumptech.glide.load.g gVar) {
        Uri b2 = b(str);
        if (b2 == null || !this.f8575a.a(b2)) {
            return null;
        }
        return this.f8575a.a(b2, i, i2, gVar);
    }
}
