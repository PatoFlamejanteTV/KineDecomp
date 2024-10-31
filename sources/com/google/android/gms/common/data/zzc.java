package com.google.android.gms.common.data;

import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public abstract class zzc {
    protected final DataHolder a_;
    protected int b_;
    private int c;

    public zzc(DataHolder dataHolder, int i) {
        this.a_ = (DataHolder) zzx.a(dataHolder);
        a(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
        zzx.a(i >= 0 && i < this.a_.g());
        this.b_ = i;
        this.c = this.a_.a(this.b_);
    }

    public boolean a_(String str) {
        return this.a_.a(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long b(String str) {
        return this.a_.a(str, this.b_, this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c(String str) {
        return this.a_.b(str, this.b_, this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(String str) {
        return this.a_.d(str, this.b_, this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String e(String str) {
        return this.a_.c(str, this.b_, this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e_() {
        return this.b_;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzc)) {
            return false;
        }
        zzc zzcVar = (zzc) obj;
        return zzw.a(Integer.valueOf(zzcVar.b_), Integer.valueOf(this.b_)) && zzw.a(Integer.valueOf(zzcVar.c), Integer.valueOf(this.c)) && zzcVar.a_ == this.a_;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float f(String str) {
        return this.a_.e(str, this.b_, this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] g(String str) {
        return this.a_.f(str, this.b_, this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Uri h(String str) {
        return this.a_.g(str, this.b_, this.c);
    }

    public int hashCode() {
        return zzw.a(Integer.valueOf(this.b_), Integer.valueOf(this.c), this.a_);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i(String str) {
        return this.a_.h(str, this.b_, this.c);
    }
}
