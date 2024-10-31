package com.google.android.gms.tagmanager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends zzct {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f2212a = new Object();
    private static ae k;
    private l b;
    private volatile k c;
    private int d = 1800000;
    private boolean e = true;
    private boolean f = false;
    private boolean g = true;
    private boolean h = true;
    private m i = new af(this);
    private boolean j = false;

    private ae() {
    }

    public static ae b() {
        if (k == null) {
            k = new ae();
        }
        return k;
    }

    @Override // com.google.android.gms.tagmanager.zzct
    public synchronized void a() {
        if (this.f) {
            this.c.a(new ag(this));
        } else {
            zzbg.d("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.e = true;
        }
    }
}
