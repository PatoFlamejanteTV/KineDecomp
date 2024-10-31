package com.google.android.gms.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fm implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzlg f1557a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fm(zzlg zzlgVar) {
        this.f1557a = zzlgVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1557a.zzaaP.b(this.f1557a.mContext);
    }
}
