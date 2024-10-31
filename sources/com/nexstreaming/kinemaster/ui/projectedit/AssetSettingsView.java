package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.util.AttributeSet;
import com.nexstreaming.kinemaster.ui.projectedit.D;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* loaded from: classes2.dex */
public class AssetSettingsView extends AbstractC1855bd {
    private D n;

    public AssetSettingsView(Context context) {
        super(context);
        f();
    }

    private void f() {
        this.n = new D(getContext());
    }

    public void a(NexTimelineItem.l lVar) {
        this.n.a(lVar);
        setOptionMenuHost(this.n.a());
        b();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.AbstractC1855bd
    protected int[] getOptionMenuItems() {
        return this.n.b();
    }

    public void setOnAssetSettingsChangeListener(D.a aVar) {
        this.n.a(aVar);
    }

    public AssetSettingsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f();
    }

    public AssetSettingsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        f();
    }

    public AssetSettingsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        f();
    }
}
