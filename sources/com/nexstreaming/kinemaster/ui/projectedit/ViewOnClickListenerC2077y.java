package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.general.nexasset.assetpackage.s;
import com.nexstreaming.app.general.util.IconView;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: AssetSettingsManager.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.y, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC2077y implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ s.a f22784a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2085z f22785b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC2077y(C2085z c2085z, s.a aVar) {
        this.f22785b = c2085z;
        this.f22784a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NexTimelineItem.l lVar;
        lVar = this.f22785b.f22798d.f21808b;
        lVar.getEffectOptions().put(this.f22785b.f22796b.getId(), this.f22784a.getValue());
        this.f22785b.f22798d.a(true);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof IconView) {
                childAt.setActivated(childAt == view);
            }
        }
    }
}
