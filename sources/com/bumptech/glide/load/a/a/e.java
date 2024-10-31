package com.bumptech.glide.load.a.a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: ThumbnailStreamOpener.java */
/* loaded from: classes.dex */
class e {

    /* renamed from: a */
    private static final a f8540a = new a();

    /* renamed from: b */
    private final a f8541b;

    /* renamed from: c */
    private final d f8542c;

    /* renamed from: d */
    private final com.bumptech.glide.load.engine.a.b f8543d;

    /* renamed from: e */
    private final ContentResolver f8544e;

    /* renamed from: f */
    private final List<ImageHeaderParser> f8545f;

    public e(List<ImageHeaderParser> list, d dVar, com.bumptech.glide.load.engine.a.b bVar, ContentResolver contentResolver) {
        this(list, f8540a, dVar, bVar, contentResolver);
    }

    private String c(Uri uri) {
        Cursor a2 = this.f8542c.a(uri);
        if (a2 != null) {
            try {
                if (a2.moveToFirst()) {
                    return a2.getString(0);
                }
            } finally {
                if (a2 != null) {
                    a2.close();
                }
            }
        }
        if (a2 != null) {
            a2.close();
        }
        return null;
    }

    public int a(Uri uri) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = this.f8544e.openInputStream(uri);
                int a2 = com.bumptech.glide.load.b.a(this.f8545f, inputStream, this.f8543d);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return a2;
            } catch (IOException | NullPointerException e2) {
                if (Log.isLoggable("ThumbStreamOpener", 3)) {
                    Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e2);
                }
                if (inputStream == null) {
                    return -1;
                }
                try {
                    inputStream.close();
                    return -1;
                } catch (IOException unused2) {
                    return -1;
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    public InputStream b(Uri uri) throws FileNotFoundException {
        String c2 = c(uri);
        if (TextUtils.isEmpty(c2)) {
            return null;
        }
        File a2 = this.f8541b.a(c2);
        if (!a(a2)) {
            return null;
        }
        Uri fromFile = Uri.fromFile(a2);
        try {
            return this.f8544e.openInputStream(fromFile);
        } catch (NullPointerException e2) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e2));
        }
    }

    e(List<ImageHeaderParser> list, a aVar, d dVar, com.bumptech.glide.load.engine.a.b bVar, ContentResolver contentResolver) {
        this.f8541b = aVar;
        this.f8542c = dVar;
        this.f8543d = bVar;
        this.f8544e = contentResolver;
        this.f8545f = list;
    }

    private boolean a(File file) {
        return this.f8541b.a(file) && 0 < this.f8541b.b(file);
    }
}
