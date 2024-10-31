package com.nexstreaming.kinemaster.ui.assetbrowser;

import android.content.Intent;
import android.view.View;
import com.nexstreaming.kinemaster.ui.store.controller.StoreActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetBrowserBaseFragment.java */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f21374a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(i iVar) {
        this.f21374a = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f21374a.getActivity(), (Class<?>) StoreActivity.class);
        if (this.f21374a.da() != null && this.f21374a.da().t() != null) {
            intent.putExtra("SELECTED_PROJECT", this.f21374a.da().t().getAbsolutePath());
        }
        intent.putExtra("SPECIFIC_URL", this.f21374a.xa().name());
        this.f21374a.startActivity(intent);
    }
}
