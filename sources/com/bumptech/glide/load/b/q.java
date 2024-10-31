package com.bumptech.glide.load.b;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.b.u;
import java.io.File;
import java.io.FileNotFoundException;

/* compiled from: MediaStoreFileLoader.java */
/* loaded from: classes.dex */
public final class q implements u<Uri, File> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f8635a;

    /* compiled from: MediaStoreFileLoader.java */
    /* loaded from: classes.dex */
    public static final class a implements v<Uri, File> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f8636a;

        public a(Context context) {
            this.f8636a = context;
        }

        @Override // com.bumptech.glide.load.b.v
        public u<Uri, File> a(y yVar) {
            return new q(this.f8636a);
        }
    }

    public q(Context context) {
        this.f8635a = context;
    }

    @Override // com.bumptech.glide.load.b.u
    public u.a<File> a(Uri uri, int i, int i2, com.bumptech.glide.load.g gVar) {
        return new u.a<>(new com.bumptech.glide.f.c(uri), new b(this.f8635a, uri));
    }

    @Override // com.bumptech.glide.load.b.u
    public boolean a(Uri uri) {
        return com.bumptech.glide.load.a.a.b.b(uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MediaStoreFileLoader.java */
    /* loaded from: classes.dex */
    public static class b implements com.bumptech.glide.load.a.d<File> {

        /* renamed from: a, reason: collision with root package name */
        private static final String[] f8637a = {"_data"};

        /* renamed from: b, reason: collision with root package name */
        private final Context f8638b;

        /* renamed from: c, reason: collision with root package name */
        private final Uri f8639c;

        b(Context context, Uri uri) {
            this.f8638b = context;
            this.f8639c = uri;
        }

        @Override // com.bumptech.glide.load.a.d
        public void a(Priority priority, d.a<? super File> aVar) {
            Cursor query = this.f8638b.getContentResolver().query(this.f8639c, f8637a, null, null, null);
            if (query != null) {
                try {
                    r0 = query.moveToFirst() ? query.getString(query.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(r0)) {
                aVar.a((Exception) new FileNotFoundException("Failed to find file path for: " + this.f8639c));
                return;
            }
            aVar.a((d.a<? super File>) new File(r0));
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
        public Class<File> a() {
            return File.class;
        }
    }
}
