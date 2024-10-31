package com.nexstreaming.kinemaster.ui.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexSimpleLoadingDialog.java */
/* loaded from: classes.dex */
public class s implements Runnable {

    /* renamed from: a */
    final /* synthetic */ t f21371a;

    public s(t tVar) {
        this.f21371a = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f21371a.dismiss();
    }
}
