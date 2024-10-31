package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.content.Intent;
import android.view.View;
import com.nexstreaming.app.general.nexasset.assetpackage.AssetCategoryAlias;
import com.nexstreaming.kinemaster.ui.store.controller.StoreActivity;

/* compiled from: AudioBrowserFragment.kt */
/* loaded from: classes.dex */
final class g implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f21441a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.f21441a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        String str2;
        kotlin.jvm.internal.h.a((Object) view, "v");
        if (view.getVisibility() == 0) {
            Intent intent = new Intent(this.f21441a.getActivity(), (Class<?>) StoreActivity.class);
            str = this.f21441a.r;
            if (str != null) {
                str2 = this.f21441a.r;
                intent.putExtra("SELECTED_PROJECT", str2);
            }
            intent.putExtra("SPECIFIC_URL", AssetCategoryAlias.Audio.name());
            this.f21441a.startActivity(intent);
        }
    }
}
