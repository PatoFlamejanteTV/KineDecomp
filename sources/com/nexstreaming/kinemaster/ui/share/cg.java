package com.nexstreaming.kinemaster.ui.share;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.nexstreaming.kinemaster.ui.projectedit.FullScreenInputActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareSNSActivity.java */
/* loaded from: classes.dex */
public class cg implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareSNSActivity f4345a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(ShareSNSActivity shareSNSActivity) {
        this.f4345a = shareSNSActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Activity D;
        TextView textView;
        if (motionEvent.getActionMasked() == 1) {
            ShareSNSActivity shareSNSActivity = this.f4345a;
            D = this.f4345a.D();
            FullScreenInputActivity.a c = FullScreenInputActivity.a(D).c(true);
            textView = this.f4345a.f;
            shareSNSActivity.startActivityForResult(c.a(textView.getText().toString()).f(true).a(), FullScreenInputActivity.a());
            return false;
        }
        return false;
    }
}
