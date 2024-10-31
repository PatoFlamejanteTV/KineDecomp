package com.adobe.creativesdk.foundation.internal.storage.controllers.upload;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0455p;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Xc;
import com.adobe.creativesdk.foundation.internal.storage.controllers.upload.AdobeUploadAssetData;

/* compiled from: UploadAssetCellView.java */
/* loaded from: classes.dex */
public abstract class z extends Xc {
    private AdobeUploadAssetData.UploadStatus S = AdobeUploadAssetData.UploadStatus.YetToStart;
    protected ProgressBar T;

    private void e(boolean z) {
        b(z ? 0.5f : 1.0f);
    }

    private void f(int i) {
        this.T.getProgressDrawable().setColorFilter(i, PorterDuff.Mode.SRC);
    }

    public void A() {
        b(g().getContext());
        B().addView(this.T);
    }

    protected abstract RelativeLayout B();

    public void C() {
    }

    public void D() {
        this.T.setVisibility(0);
        f(Color.rgb(32, 152, 245));
        e(true);
    }

    public void E() {
        this.T.setVisibility(8);
        e(false);
    }

    public void F() {
    }

    public void G() {
        D();
        e(true);
    }

    public void a(AdobeUploadAssetData.UploadStatus uploadStatus) {
        this.S = uploadStatus;
        AdobeUploadAssetData.UploadStatus uploadStatus2 = this.S;
        if (uploadStatus2 == AdobeUploadAssetData.UploadStatus.YetToStart) {
            G();
            return;
        }
        if (uploadStatus2 == AdobeUploadAssetData.UploadStatus.Completed) {
            E();
            return;
        }
        if (uploadStatus2 == AdobeUploadAssetData.UploadStatus.Error) {
            F();
        } else if (uploadStatus2 == AdobeUploadAssetData.UploadStatus.Started || uploadStatus2 == AdobeUploadAssetData.UploadStatus.InProgress) {
            D();
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void b(float f2) {
        AdobeUploadAssetData.UploadStatus uploadStatus = this.S;
        if (uploadStatus == AdobeUploadAssetData.UploadStatus.YetToStart || uploadStatus == AdobeUploadAssetData.UploadStatus.InProgress) {
            f2 = 0.5f;
        }
        super.b(f2);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    protected void k() {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Xc, com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void m() {
        super.m();
        A();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Xc, com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    protected boolean v() {
        return false;
    }

    protected void b(Context context) {
        this.T = new ProgressBar(context, null, R.attr.progressBarStyleHorizontal);
        this.T.setProgressDrawable(context.getResources().getDrawable(c.a.a.a.b.d.asset_upload_progress_bar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, C0455p.a(2));
        a(layoutParams);
        this.T.setLayoutParams(layoutParams);
        this.T.setVisibility(0);
        this.T.setIndeterminate(false);
        this.T.setMax(100);
        this.T.setProgress(0);
    }

    public void a(double d2) {
        if (d2 >= 100.0d) {
            C();
        }
        this.T.setProgress((int) d2);
    }

    public void a(RelativeLayout.LayoutParams layoutParams) {
        layoutParams.addRule(12);
    }
}
