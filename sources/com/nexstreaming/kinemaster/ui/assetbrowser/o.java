package com.nexstreaming.kinemaster.ui.assetbrowser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.assetbrowser.i;
import com.nexstreaming.kinemaster.ui.projectedit.Bg;
import java.util.HashMap;

/* compiled from: OverlaysBrowserFragment.kt */
/* loaded from: classes.dex */
public final class o extends i {
    public static final a H = new a(null);
    private i.b I;
    private boolean J;
    private HashMap K;

    /* compiled from: OverlaysBrowserFragment.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.assetbrowser.i, com.nexstreaming.kinemaster.ui.projectedit.Bg
    public boolean ja() {
        return true;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void oa() {
        if (Y() == null) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_share, R.drawable.action_icon_share, R.id.action_settings, R.drawable.action_icon_settings);
        } else {
            super.oa();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.assetbrowser.i, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.b(layoutInflater, "inflater");
        String name = o.class.getName();
        kotlin.jvm.internal.h.a((Object) name, "this.javaClass.name");
        com.nexstreaming.kinemaster.usage.analytics.b.a(name);
        this.I = new p(this);
        na();
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        z();
    }

    @Override // com.nexstreaming.kinemaster.ui.assetbrowser.i, android.support.v4.app.Fragment
    public void onPause() {
        if (this.J) {
            this.J = false;
            Bg.a(this, null, 1, null);
        }
        super.onPause();
    }

    @Override // com.nexstreaming.kinemaster.ui.assetbrowser.i
    public AssetBrowserType wa() {
        return AssetBrowserType.Overlay;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void z() {
        HashMap hashMap = this.K;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
