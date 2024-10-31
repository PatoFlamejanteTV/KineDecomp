package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.general.nexasset.assetpackage.s;
import com.nexstreaming.app.general.util.IconView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectedit.C1935kd;
import com.nexstreaming.kinemaster.ui.projectedit.OptionMenuItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetSettingsManager.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.z, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2085z implements OptionMenuItem.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f22795a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.app.general.nexasset.assetpackage.s f22796b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.app.general.nexasset.assetpackage.r f22797c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ D f22798d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2085z(D d2, int i, com.nexstreaming.app.general.nexasset.assetpackage.s sVar, com.nexstreaming.app.general.nexasset.assetpackage.r rVar) {
        this.f22798d = d2;
        this.f22795a = i;
        this.f22796b = sVar;
        this.f22797c = rVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionMenuItem.b
    public View a(int i, View view, ViewGroup viewGroup, NexTimelineItem nexTimelineItem, OptionMenuItem optionMenuItem, C1935kd.a aVar) {
        NexTimelineItem.l lVar;
        Context context;
        if (view == null) {
            context = this.f22798d.f21807a;
            view = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.asset_setting_icon_choice, viewGroup, false);
        }
        int[] iArr = {R.id.opt1, R.id.opt2, R.id.opt3, R.id.opt4};
        view.findViewById(R.id.div3).setVisibility(this.f22795a < 4 ? 8 : 0);
        view.findViewById(R.id.div2).setVisibility(this.f22795a < 3 ? 8 : 0);
        view.findViewById(R.id.div1).setVisibility(this.f22795a < 2 ? 8 : 0);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            IconView iconView = (IconView) view.findViewById(iArr[i2]);
            Bitmap bitmap = null;
            if (i2 >= this.f22795a) {
                iconView.setVisibility(8);
                iconView.setOnClickListener(null);
            } else {
                s.a aVar2 = this.f22796b.a().get(i2);
                iconView.setVisibility(0);
                try {
                    bitmap = com.nexstreaming.app.general.nexasset.assetpackage.q.a(view.getContext(), this.f22797c, aVar2.getIconPath());
                } catch (IOException e2) {
                    Log.e("AssetSettingsManager", "Error getting icon", e2);
                }
                iconView.setImageBitmap(bitmap);
                lVar = this.f22798d.f21808b;
                String str = lVar.getEffectOptions().get(this.f22796b.getId());
                if (str == null && (str = this.f22796b.i()) == null) {
                    str = "";
                }
                iconView.setActivated(aVar2.getValue().equals(str));
                iconView.setOnClickListener(new ViewOnClickListenerC2077y(this, aVar2));
            }
        }
        return view;
    }
}
