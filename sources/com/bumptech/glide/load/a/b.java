package com.bumptech.glide.load.a;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.d;
import java.io.IOException;

/* compiled from: AssetPathFetcher.java */
/* loaded from: classes.dex */
public abstract class b<T> implements d<T> {

    /* renamed from: a */
    private final String f8546a;

    /* renamed from: b */
    private final AssetManager f8547b;

    /* renamed from: c */
    private T f8548c;

    public b(AssetManager assetManager, String str) {
        this.f8547b = assetManager;
        this.f8546a = str;
    }

    protected abstract T a(AssetManager assetManager, String str) throws IOException;

    @Override // com.bumptech.glide.load.a.d
    public void a(Priority priority, d.a<? super T> aVar) {
        try {
            this.f8548c = a(this.f8547b, this.f8546a);
            aVar.a((d.a<? super T>) this.f8548c);
        } catch (IOException e2) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e2);
            }
            aVar.a((Exception) e2);
        }
    }

    protected abstract void a(T t) throws IOException;

    @Override // com.bumptech.glide.load.a.d
    public void b() {
        T t = this.f8548c;
        if (t == null) {
            return;
        }
        try {
            a(t);
        } catch (IOException unused) {
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
