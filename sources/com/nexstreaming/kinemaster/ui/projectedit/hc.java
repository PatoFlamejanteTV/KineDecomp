package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Handler;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionExpressionFragment.java */
/* loaded from: classes2.dex */
public class Hc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Jc f21890a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Hc(Jc jc) {
        this.f21890a = jc;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        handler = this.f21890a.p;
        handler.removeCallbacks(this);
        if (this.f21890a.isAdded()) {
            handler2 = this.f21890a.p;
            handler2.postDelayed(this, 16L);
            this.f21890a.da().a(NexEditor.FastPreviewOption.normal, 0, true);
        }
    }
}
