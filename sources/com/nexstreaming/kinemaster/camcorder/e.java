package com.nexstreaming.kinemaster.camcorder;

import android.R;
import android.media.CamcorderProfile;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.List;

/* compiled from: CamcorderActivity.java */
/* loaded from: classes.dex */
class e implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CamcorderActivity f3269a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CamcorderActivity camcorderActivity) {
        this.f3269a = camcorderActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List list;
        View view2;
        ListView listView;
        ListView listView2;
        ListView listView3;
        ListView listView4;
        ListView listView5;
        List list2;
        int b;
        int c;
        list = this.f3269a.K;
        String[] strArr = new String[list.size()];
        int i = -1;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            list2 = this.f3269a.K;
            CamcorderProfile camcorderProfile = (CamcorderProfile) list2.get(i2);
            strArr[i2] = camcorderProfile.videoFrameWidth + " x " + camcorderProfile.videoFrameHeight;
            b = this.f3269a.b();
            if (b == camcorderProfile.videoFrameWidth) {
                c = this.f3269a.c();
                if (c == camcorderProfile.videoFrameHeight) {
                    i = i2;
                }
            }
        }
        view2 = this.f3269a.E;
        view2.setVisibility(0);
        this.f3269a.F = true;
        listView = this.f3269a.D;
        listView.setAdapter((ListAdapter) new ArrayAdapter(this.f3269a, R.layout.simple_list_item_single_choice, strArr));
        listView2 = this.f3269a.D;
        listView2.setChoiceMode(1);
        listView3 = this.f3269a.D;
        listView3.setItemChecked(i, true);
        listView4 = this.f3269a.D;
        listView4.setVisibility(0);
        listView5 = this.f3269a.D;
        listView5.setOnItemClickListener(new f(this));
    }
}
