package com.google.android.gms.dynamic;

import android.content.Context;
import android.view.View;
import com.google.android.gms.common.GooglePlayServicesUtil;

/* loaded from: classes.dex */
final class e implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f1205a;
    final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, int i) {
        this.f1205a = context;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1205a.startActivity(GooglePlayServicesUtil.a(this.b));
    }
}
