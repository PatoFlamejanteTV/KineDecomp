package com.nexstreaming.kinemaster.ui.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* compiled from: NexSimpleLoadingDialog.java */
/* loaded from: classes.dex */
public class t extends ProgressDialog {

    /* renamed from: a */
    private long f21372a;

    public t(Context context) {
        super(context);
        this.f21372a = 0L;
    }

    public void a(long j) {
        this.f21372a = j;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        setContentView(R.layout.layout_transparent_progress_dialog);
        getWindow().setDimAmount(0.0f);
        setMax(NexVideoClipItem.ABSTRACT_DIMENSION);
        getWindow().setBackgroundDrawable(getContext().getResources().getDrawable(android.R.color.transparent));
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        if (this.f21372a > 0) {
            new Handler().postDelayed(new s(this), this.f21372a);
        }
    }
}
