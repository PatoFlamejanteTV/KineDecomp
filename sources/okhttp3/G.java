package okhttp3;

import okio.C2576c;

/* compiled from: RealCall.java */
/* loaded from: classes3.dex */
class G extends C2576c {
    final /* synthetic */ H k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public G(H h2) {
        this.k = h2;
    }

    @Override // okio.C2576c
    protected void j() {
        this.k.cancel();
    }
}
