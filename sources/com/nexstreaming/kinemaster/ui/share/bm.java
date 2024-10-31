package com.nexstreaming.kinemaster.ui.share;

import android.widget.BaseAdapter;
import com.nextreaming.nexeditorui.NexExportProfile;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareQualityActivity.java */
/* loaded from: classes.dex */
public class bm extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareQualityActivity f4324a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(ShareQualityActivity shareQualityActivity) {
        this.f4324a = shareQualityActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        NexExportProfile[] nexExportProfileArr;
        nexExportProfileArr = this.f4324a.c;
        return nexExportProfileArr.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        NexExportProfile[] nexExportProfileArr;
        nexExportProfileArr = this.f4324a.c;
        return nexExportProfileArr[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        NexExportProfile[] nexExportProfileArr;
        nexExportProfileArr = this.f4324a.c;
        return nexExportProfileArr[i].id();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0151  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View getView(int r17, android.view.View r18, android.view.ViewGroup r19) {
        /*
            Method dump skipped, instructions count: 505
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.share.bm.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        boolean z;
        z = this.f4324a.j;
        if (z) {
            return false;
        }
        return super.isEnabled(i);
    }
}
