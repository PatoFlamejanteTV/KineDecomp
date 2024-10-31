package io.fabric.sdk.android.a.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import io.fabric.sdk.android.l;

/* compiled from: PreferenceStoreImpl.java */
/* loaded from: classes3.dex */
public class d implements c {

    /* renamed from: a */
    private final SharedPreferences f26830a;

    /* renamed from: b */
    private final String f26831b;

    /* renamed from: c */
    private final Context f26832c;

    public d(Context context, String str) {
        if (context != null) {
            this.f26832c = context;
            this.f26831b = str;
            this.f26830a = this.f26832c.getSharedPreferences(this.f26831b, 0);
            return;
        }
        throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }

    @Override // io.fabric.sdk.android.a.c.c
    @TargetApi(9)
    public boolean a(SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT >= 9) {
            editor.apply();
            return true;
        }
        return editor.commit();
    }

    @Override // io.fabric.sdk.android.a.c.c
    public SharedPreferences.Editor edit() {
        return this.f26830a.edit();
    }

    @Override // io.fabric.sdk.android.a.c.c
    public SharedPreferences get() {
        return this.f26830a;
    }

    @Deprecated
    public d(l lVar) {
        this(lVar.getContext(), lVar.getClass().getName());
    }
}
