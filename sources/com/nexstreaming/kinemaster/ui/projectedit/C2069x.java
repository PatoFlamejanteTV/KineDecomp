package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nexstreaming.kinemaster.ui.projectedit.D;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: AssetSettingsFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.x, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2069x extends Xc {
    private D C;
    private D.a D = new C2061w(this);

    protected void a(NexTimelineItem.l lVar) {
        this.C.a(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        Fa.a Y = Y();
        if (this.C == null) {
            this.C = new D(getActivity());
            this.C.a(this.D);
            a(this.C.a());
        }
        if (Y instanceof NexTimelineItem.l) {
            a((NexTimelineItem.l) Y);
        }
        f(true);
        super.na();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected boolean r(int i) {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected int[] ua() {
        D d2 = this.C;
        if (d2 != null) {
            return d2.b();
        }
        return new int[0];
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected String wa() {
        return getString(R.string.settings_toolbar_title);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected boolean ya() {
        return true;
    }
}
