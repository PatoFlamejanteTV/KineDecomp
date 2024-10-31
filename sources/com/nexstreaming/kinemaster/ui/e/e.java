package com.nexstreaming.kinemaster.ui.e;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import kotlin.jvm.internal.h;

/* compiled from: PermissionRationaleFragment.kt */
/* loaded from: classes.dex */
final class e implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f21578a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.f21578a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        Context requireContext = this.f21578a.requireContext();
        h.a((Object) requireContext, "requireContext()");
        intent.setData(Uri.fromParts("package", requireContext.getPackageName(), null));
        intent.addFlags(268435456);
        this.f21578a.startActivityForResult(intent, 8211);
    }
}
