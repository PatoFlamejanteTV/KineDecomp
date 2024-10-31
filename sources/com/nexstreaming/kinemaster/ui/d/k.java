package com.nexstreaming.kinemaster.ui.d;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionGroupFragment.java */
/* loaded from: classes.dex */
public class k implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f21555a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(m mVar) {
        this.f21555a = mVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        f fVar;
        f fVar2;
        g gVar = this.f21555a.v;
        if (gVar == null || gVar.getCount() > i) {
            if (i != this.f21555a.v.a()) {
                this.f21555a.va();
            }
            m mVar = this.f21555a;
            if (i == mVar.x) {
                return;
            }
            mVar.x = i;
            mVar.v.a(i);
            n nVar = (n) this.f21555a.v.getItem(i);
            if (nVar.getType() == 0) {
                this.f21555a.a(r1.getResources().getDimensionPixelOffset(R.dimen.pedit_expand_option_panel_width));
                this.f21555a.v.a(i);
                this.f21555a.z = null;
                m mVar2 = this.f21555a;
                mVar2.n(mVar2.za());
                return;
            }
            this.f21555a.a(r2.getResources().getDimensionPixelOffset(R.dimen.pedit_expand_option_panel_width_half));
            m mVar3 = this.f21555a;
            if (mVar3.w == null) {
                mVar3.w = new e(mVar3.requireContext(), this.f21555a.Aa());
                m mVar4 = this.f21555a;
                mVar4.t.setAdapter((ListAdapter) mVar4.w);
            }
            this.f21555a.w.a(false);
            this.f21555a.w.a(nVar.a());
            fVar = this.f21555a.z;
            if (fVar != null) {
                for (int i2 = 0; i2 < this.f21555a.w.getCount(); i2++) {
                    fVar2 = this.f21555a.z;
                    if (fVar2.equals(this.f21555a.w.getItem(i2))) {
                        this.f21555a.w.a(i2);
                        this.f21555a.t.setSelection(i2);
                        return;
                    }
                }
                return;
            }
            this.f21555a.t.setSelection(0);
        }
    }
}
