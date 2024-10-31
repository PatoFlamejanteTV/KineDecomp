package com.nexstreaming.kinemaster.ui.share;

import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: ShareSubscriptionActivity.java */
/* loaded from: classes.dex */
class cj implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ShareSubscriptionActivity f4348a;

    public cj(ShareSubscriptionActivity shareSubscriptionActivity) {
        this.f4348a = shareSubscriptionActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_sub_30days /* 2131821496 */:
                this.f4348a.a(this.f4348a.A().g(), "share");
                return;
            case R.id.sub_just_a_month_price /* 2131821497 */:
            case R.id.sub_monthly_price /* 2131821499 */:
            default:
                return;
            case R.id.button_sub_monthly /* 2131821498 */:
                this.f4348a.a(this.f4348a.A().h(), "share");
                return;
            case R.id.button_sub_annual /* 2131821500 */:
                this.f4348a.a(this.f4348a.A().i(), "share");
                return;
        }
    }
}
