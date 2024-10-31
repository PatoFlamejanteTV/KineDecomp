package com.facebook.ads.redexgen.X;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: assets/audience_network.dex */
public class GR implements Callable<Boolean> {
    public final /* synthetic */ SharedPreferences A00;
    public final /* synthetic */ C0361Eb A01;
    public final /* synthetic */ String A02;

    public GR(C0361Eb c0361Eb, SharedPreferences sharedPreferences, String str) {
        this.A01 = c0361Eb;
        this.A00 = sharedPreferences;
        this.A02 = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final Boolean call() throws Exception {
        String A02;
        String str;
        AtomicInteger atomicInteger;
        A02 = GS.A02(this.A01, this.A01.getPackageName());
        String unused = GS.A02 = A02;
        SharedPreferences.Editor edit = this.A00.edit();
        String str2 = this.A02;
        str = GS.A02;
        edit.putString(str2, str).apply();
        atomicInteger = GS.A06;
        atomicInteger.set(2);
        return true;
    }
}
