package io.fabric.sdk.android.a.c;

import android.content.Context;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.l;
import java.io.File;

/* compiled from: FileStoreImpl.java */
/* loaded from: classes3.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private final Context f26827a;

    /* renamed from: b, reason: collision with root package name */
    private final String f26828b;

    /* renamed from: c, reason: collision with root package name */
    private final String f26829c;

    public b(l lVar) {
        if (lVar.getContext() != null) {
            this.f26827a = lVar.getContext();
            this.f26828b = lVar.getPath();
            this.f26829c = "Android/" + this.f26827a.getPackageName();
            return;
        }
        throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }

    @Override // io.fabric.sdk.android.a.c.a
    public File a() {
        return a(this.f26827a.getFilesDir());
    }

    File a(File file) {
        if (file != null) {
            if (file.exists() || file.mkdirs()) {
                return file;
            }
            f.f().b("Fabric", "Couldn't create file");
            return null;
        }
        f.f().d("Fabric", "Null File");
        return null;
    }
}
