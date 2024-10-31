package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.widget.AdapterView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectedit.Qb;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MultiSelectOptionFragment.java */
/* loaded from: classes2.dex */
public class Ob implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Qb f21979a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ob(Qb qb) {
        this.f21979a = qb;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Qb.b bVar;
        int i2;
        Qb.b bVar2;
        bVar = this.f21979a.m;
        if (bVar != null) {
            bVar2 = this.f21979a.m;
            Qb.a aVar = (Qb.a) bVar2.getItem(i);
            if (this.f21979a.p.b(aVar.f22030a)) {
                return;
            } else {
                i2 = aVar.f22030a;
            }
        } else {
            i2 = 0;
        }
        switch (i2) {
            case R.id.multi_opt_align_endtime /* 2131363021 */:
                this.f21979a.va();
                this.f21979a.da().H();
                this.f21979a.da().J();
                return;
            case R.id.multi_opt_align_starttime /* 2131363022 */:
                this.f21979a.wa();
                this.f21979a.da().H();
                this.f21979a.da().J();
                return;
            case R.id.multi_opt_grouping /* 2131363023 */:
                this.f21979a.ya();
                return;
            case R.id.multi_opt_split_at_playhead /* 2131363024 */:
                this.f21979a.za();
                this.f21979a.da().H();
                this.f21979a.da().J();
                return;
            case R.id.multi_opt_trim_to_left /* 2131363025 */:
                this.f21979a.Aa();
                this.f21979a.da().H();
                this.f21979a.da().J();
                return;
            case R.id.multi_opt_trim_to_right /* 2131363026 */:
                this.f21979a.Ba();
                this.f21979a.da().H();
                this.f21979a.da().J();
                return;
            default:
                return;
        }
    }
}
