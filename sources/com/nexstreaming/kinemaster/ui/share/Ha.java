package com.nexstreaming.kinemaster.ui.share;

import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: ShareSubscriptionActivity.java */
/* loaded from: classes2.dex */
class Ha implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareSubscriptionActivity f23281a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ha(ShareSubscriptionActivity shareSubscriptionActivity) {
        this.f23281a = shareSubscriptionActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_sub_30days /* 2131362395 */:
                ShareSubscriptionActivity shareSubscriptionActivity = this.f23281a;
                shareSubscriptionActivity.a(shareSubscriptionActivity.y().k(), "share");
                return;
            case R.id.button_sub_annual /* 2131362396 */:
                ShareSubscriptionActivity shareSubscriptionActivity2 = this.f23281a;
                shareSubscriptionActivity2.a(shareSubscriptionActivity2.y().s(), "share");
                return;
            case R.id.button_sub_monthly /* 2131362397 */:
                ShareSubscriptionActivity shareSubscriptionActivity3 = this.f23281a;
                shareSubscriptionActivity3.a(shareSubscriptionActivity3.y().o(), "share");
                return;
            default:
                return;
        }
    }
}
