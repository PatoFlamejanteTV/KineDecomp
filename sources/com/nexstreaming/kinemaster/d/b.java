package com.nexstreaming.kinemaster.d;

import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.af;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PurchaseDialog.java */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f3293a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f3293a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        af b;
        af b2;
        af b3;
        switch (view.getId()) {
            case R.id.button_sub_30days /* 2131821496 */:
                a aVar = this.f3293a;
                b3 = this.f3293a.b();
                aVar.a(b3.g());
                return;
            case R.id.sub_just_a_month_price /* 2131821497 */:
            case R.id.sub_monthly_price /* 2131821499 */:
            default:
                return;
            case R.id.button_sub_monthly /* 2131821498 */:
                a aVar2 = this.f3293a;
                b2 = this.f3293a.b();
                aVar2.a(b2.h());
                return;
            case R.id.button_sub_annual /* 2131821500 */:
                a aVar3 = this.f3293a;
                b = this.f3293a.b();
                aVar3.a(b.i());
                return;
        }
    }
}
