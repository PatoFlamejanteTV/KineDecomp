package com.bumptech.glide.load.a.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.a.h;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ThumbFetcher.java */
/* loaded from: classes.dex */
public class c implements com.bumptech.glide.load.a.d<InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final Uri f8533a;

    /* renamed from: b, reason: collision with root package name */
    private final e f8534b;

    /* renamed from: c, reason: collision with root package name */
    private InputStream f8535c;

    /* compiled from: ThumbFetcher.java */
    /* loaded from: classes.dex */
    static class a implements d {

        /* renamed from: a, reason: collision with root package name */
        private static final String[] f8536a = {"_data"};

        /* renamed from: b, reason: collision with root package name */
        private final ContentResolver f8537b;

        a(ContentResolver contentResolver) {
            this.f8537b = contentResolver;
        }

        @Override // com.bumptech.glide.load.a.a.d
        public Cursor a(Uri uri) {
            return this.f8537b.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f8536a, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* compiled from: ThumbFetcher.java */
    /* loaded from: classes.dex */
    static class b implements d {

        /* renamed from: a, reason: collision with root package name */
        private static final String[] f8538a = {"_data"};

        /* renamed from: b, reason: collision with root package name */
        private final ContentResolver f8539b;

        b(ContentResolver contentResolver) {
            this.f8539b = contentResolver;
        }

        @Override // com.bumptech.glide.load.a.a.d
        public Cursor a(Uri uri) {
            return this.f8539b.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f8538a, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    c(Uri uri, e eVar) {
        this.f8533a = uri;
        this.f8534b = eVar;
    }

    public static c a(Context context, Uri uri) {
        return a(context, uri, new a(context.getContentResolver()));
    }

    public static c b(Context context, Uri uri) {
        return a(context, uri, new b(context.getContentResolver()));
    }

    private InputStream d() throws FileNotFoundException {
        InputStream b2 = this.f8534b.b(this.f8533a);
        int a2 = b2 != null ? this.f8534b.a(this.f8533a) : -1;
        return a2 != -1 ? new h(b2, a2) : b2;
    }

    @Override // com.bumptech.glide.load.a.d
    public DataSource c() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.a.d
    public void cancel() {
    }

    private static c a(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.bumptech.glide.c.a(context).g().a(), dVar, com.bumptech.glide.c.a(context).b(), context.getContentResolver()));
    }

    @Override // com.bumptech.glide.load.a.d
    public void b() {
        InputStream inputStream = this.f8535c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.a.d
    public void a(Priority priority, d.a<? super InputStream> aVar) {
        try {
            this.f8535c = d();
            aVar.a((d.a<? super InputStream>) this.f8535c);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e2);
            }
            aVar.a((Exception) e2);
        }
    }

    @Override // com.bumptech.glide.load.a.d
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
