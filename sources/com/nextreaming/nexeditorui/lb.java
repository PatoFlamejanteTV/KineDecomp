package com.nextreaming.nexeditorui;

/* compiled from: RelaunchActivity.java */
/* loaded from: classes.dex */
class lb implements Runnable {

    /* renamed from: a */
    final /* synthetic */ mb f24313a;

    public lb(mb mbVar) {
        this.f24313a = mbVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f24313a.f24317a.setResult(-1);
        this.f24313a.f24317a.finish();
    }
}
