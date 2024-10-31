package com.nexstreaming.kinemaster.ui.share;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareSNSActivity.java */
/* loaded from: classes.dex */
public class bw implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareSNSActivity f4334a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(ShareSNSActivity shareSNSActivity) {
        this.f4334a = shareSNSActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Activity D;
        if (motionEvent.getActionMasked() == 0) {
            D = this.f4334a.D();
            new a.C0074a(D).a("Are you sure you want to delete this tag?").a(R.string.button_delete, new by(this, view)).b(R.string.button_cancel, new bx(this)).a().show();
        }
        return false;
    }
}
