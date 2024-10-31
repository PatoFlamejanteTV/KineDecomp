package com.nexstreaming.kinemaster.ui.share;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectedit.FullScreenInputActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareSNSActivity.java */
/* loaded from: classes.dex */
public class cf implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareSNSActivity f4344a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(ShareSNSActivity shareSNSActivity) {
        this.f4344a = shareSNSActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Activity D;
        TextView textView;
        if (motionEvent.getActionMasked() == 0) {
            ShareSNSActivity shareSNSActivity = this.f4344a;
            D = this.f4344a.D();
            FullScreenInputActivity.a a2 = FullScreenInputActivity.a(D);
            textView = this.f4344a.e;
            shareSNSActivity.startActivityForResult(a2.a(textView.getText().toString()).c(false).b(false).f(false).a(), R.id.edit_project_title_for_sns);
        }
        return false;
    }
}
