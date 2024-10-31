package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Handler;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionExpressionFragment.java */
/* loaded from: classes.dex */
public class dz implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ dt f3861a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dz(dt dtVar) {
        this.f3861a = dtVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        handler = this.f3861a.f;
        handler.removeCallbacks(this);
        if (this.f3861a.isAdded()) {
            handler2 = this.f3861a.f;
            handler2.postDelayed(this, 16L);
            this.f3861a.o().a(NexEditor.FastPreviewOption.normal, 0, true);
        }
    }
}
