package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.ib, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC0939ib implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzakt f12207a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzaku f12208b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0939ib(zzaku zzakuVar, zzakt zzaktVar) {
        this.f12208b = zzakuVar;
        this.f12207a = zzaktVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        int i;
        zzalj zzuo;
        zzalj zzaljVar;
        boolean zzup;
        boolean zzcp;
        String str;
        obj = this.f12208b.mLock;
        synchronized (obj) {
            i = this.f12208b.zzdmv;
            if (i != -2) {
                return;
            }
            zzaku zzakuVar = this.f12208b;
            zzuo = this.f12208b.zzuo();
            zzakuVar.zzdmu = zzuo;
            zzaljVar = this.f12208b.zzdmu;
            if (zzaljVar != null) {
                zzup = this.f12208b.zzup();
                if (zzup) {
                    zzcp = this.f12208b.zzcp(1);
                    if (!zzcp) {
                        str = this.f12208b.zzdml;
                        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 56);
                        sb.append("Ignoring adapter ");
                        sb.append(str);
                        sb.append(" as delayed impression is not supported");
                        zzbbd.zzeo(sb.toString());
                        this.f12208b.zzco(2);
                        return;
                    }
                }
                this.f12207a.zza(this.f12208b);
                this.f12208b.zza(this.f12207a);
                return;
            }
            this.f12208b.zzco(4);
        }
    }
}
