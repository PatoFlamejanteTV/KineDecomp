package com.nexstreaming.kinemaster.ui.share;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.NexExportProfile;

/* compiled from: ShareQualityActivity.java */
/* loaded from: classes.dex */
class bl implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareQualityActivity f4323a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(ShareQualityActivity shareQualityActivity) {
        this.f4323a = shareQualityActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean z;
        NexExportProfile[] nexExportProfileArr;
        ListView listView;
        z = this.f4323a.j;
        if (!z) {
            SupportLogger.Event.Activity_ShareQuality_ExportQualityClick.log(new int[0]);
            nexExportProfileArr = this.f4323a.c;
            listView = this.f4323a.f4280a;
            NexExportProfile nexExportProfile = nexExportProfileArr[i - listView.getHeaderViewsCount()];
            switch (this.f4323a.d()) {
                case R.id.sns_share_gallery /* 2131821505 */:
                case R.id.sns_share_youtube /* 2131821507 */:
                case R.id.sns_share_facebook /* 2131821508 */:
                case R.id.sns_share_gplus /* 2131821509 */:
                case R.id.sns_share_dropbox /* 2131821510 */:
                case R.id.sns_share_wechat /* 2131821511 */:
                case R.id.sns_share_other /* 2131821512 */:
                    this.f4323a.a(nexExportProfile);
                    return;
                case R.id.shareGridLayout /* 2131821506 */:
                default:
                    return;
            }
        }
    }
}
