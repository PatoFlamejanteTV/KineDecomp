package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import android.view.View;

/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.ab, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class DialogInterfaceOnDismissListenerC2095ab implements DialogInterface.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewOnClickListenerC2098bb f22904a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterfaceOnDismissListenerC2095ab(ViewOnClickListenerC2098bb viewOnClickListenerC2098bb) {
        this.f22904a = viewOnClickListenerC2098bb;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        View view;
        Runnable runnable;
        View view2;
        Runnable runnable2;
        this.f22904a.f22908b.f22914a.Aa = null;
        view = this.f22904a.f22908b.f22914a.ca;
        if (view != null) {
            runnable = this.f22904a.f22908b.f22914a.Ma;
            if (runnable != null) {
                view2 = this.f22904a.f22908b.f22914a.ca;
                runnable2 = this.f22904a.f22908b.f22914a.Ma;
                view2.post(runnable2);
            }
        }
    }
}
