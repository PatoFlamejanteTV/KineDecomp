package com.nexstreaming.kinemaster.ui.assetbrowser;

import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexTransitionItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import java.util.HashMap;

/* compiled from: FxBrowserFragment.kt */
/* loaded from: classes.dex */
public final class n extends i {
    private HashMap J;
    public static final a I = new a(null);
    private static final String H = n.class.getSimpleName();

    /* compiled from: FxBrowserFragment.kt */
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

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        z();
    }

    @Override // com.nexstreaming.kinemaster.ui.assetbrowser.i
    public AssetBrowserType wa() {
        NexTimelineItem Y = Y();
        return Y instanceof NexTransitionItem ? AssetBrowserType.Transition : Y instanceof NexVideoClipItem ? AssetBrowserType.ClipEffect : AssetBrowserType.EffectLayer;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void z() {
        HashMap hashMap = this.J;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
