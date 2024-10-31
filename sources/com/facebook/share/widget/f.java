package com.facebook.share.widget;

import android.view.View;
import com.facebook.share.DeviceShareDialog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceShareButton.java */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DeviceShareButton f9629a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(DeviceShareButton deviceShareButton) {
        this.f9629a = deviceShareButton;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DeviceShareDialog dialog;
        this.f9629a.callExternalOnClickListener(view);
        dialog = this.f9629a.getDialog();
        dialog.show(this.f9629a.getShareContent());
    }
}
