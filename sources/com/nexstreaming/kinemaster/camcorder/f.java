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
public class f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CamcorderActivity f19993a;

    public f(CamcorderActivity camcorderActivity) {
        this.f19993a = camcorderActivity;
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
        int u;
        int t;
        list = this.f19993a.M;
        String[] strArr = new String[list.size()];
        int i = -1;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            list2 = this.f19993a.M;
            CamcorderProfile camcorderProfile = (CamcorderProfile) list2.get(i2);
            strArr[i2] = camcorderProfile.videoFrameWidth + " x " + camcorderProfile.videoFrameHeight;
            u = this.f19993a.u();
            if (u == camcorderProfile.videoFrameWidth) {
                t = this.f19993a.t();
                if (t == camcorderProfile.videoFrameHeight) {
                    i = i2;
                }
            }
        }
        view2 = this.f19993a.E;
        view2.setVisibility(0);
        this.f19993a.F = true;
        listView = this.f19993a.D;
        listView.setAdapter((ListAdapter) new ArrayAdapter(this.f19993a, R.layout.simple_list_item_single_choice, strArr));
        listView2 = this.f19993a.D;
        listView2.setChoiceMode(1);
        listView3 = this.f19993a.D;
        listView3.setItemChecked(i, true);
        listView4 = this.f19993a.D;
        listView4.setVisibility(0);
        listView5 = this.f19993a.D;
        listView5.setOnItemClickListener(new e(this));
    }
}
