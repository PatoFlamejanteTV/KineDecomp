package com.bumptech.glide.load.a;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.d;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: LocalUriFetcher.java */
/* loaded from: classes.dex */
public abstract class m<T> implements d<T> {

    /* renamed from: a */
    private final Uri f8570a;

    /* renamed from: b */
    private final ContentResolver f8571b;

    /* renamed from: c */
    private T f8572c;

    public m(ContentResolver contentResolver, Uri uri) {
        this.f8571b = contentResolver;
        this.f8570a = uri;
    }

    protected abstract T a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    @Override // com.bumptech.glide.load.a.d
    public final void a(Priority priority, d.a<? super T> aVar) {
        try {
            this.f8572c = a(this.f8570a, this.f8571b);
            aVar.a((d.a<? super T>) this.f8572c);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e2);
            }
            aVar.a((Exception) e2);
        }
    }

    protected abstract void a(T t) throws IOException;

    @Override // com.bumptech.glide.load.a.d
    public void b() {
        T t = this.f8572c;
        if (t != null) {
            try {
                a(t);
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.a.d
    public DataSource c() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.a.d
    public void cancel() {
    }
}
