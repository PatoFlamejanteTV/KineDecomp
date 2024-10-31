package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import com.nexstreaming.app.general.nexasset.assetpackage.ItemParameterType;
import com.nexstreaming.app.general.nexasset.assetpackage.s;
import com.nexstreaming.app.general.util.C1703g;
import com.nexstreaming.kinemaster.ui.widget.PopoutListMenu;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetSettingsManager.java */
/* loaded from: classes2.dex */
public class B implements InterfaceC1997rd {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ D f21773a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(D d2) {
        this.f21773a = d2;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1997rd
    public void a(OptionMenuItem optionMenuItem, int i) {
        NexTimelineItem.l lVar;
        Object obj = optionMenuItem.A;
        if (obj instanceof com.nexstreaming.app.general.nexasset.assetpackage.s) {
            lVar = this.f21773a.f21808b;
            lVar.getEffectOptions().put(((com.nexstreaming.app.general.nexasset.assetpackage.s) obj).getId(), C1703g.b(i));
            this.f21773a.a(true);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1997rd
    public float b(OptionMenuItem optionMenuItem) {
        NexTimelineItem.l lVar;
        Object obj = optionMenuItem.A;
        if (!(obj instanceof com.nexstreaming.app.general.nexasset.assetpackage.s)) {
            return 0.0f;
        }
        com.nexstreaming.app.general.nexasset.assetpackage.s sVar = (com.nexstreaming.app.general.nexasset.assetpackage.s) obj;
        Log.d("charles", sVar.getId());
        lVar = this.f21773a.f21808b;
        String str = lVar.getEffectOptions().get(sVar.getId());
        if (str == null) {
            str = sVar.i();
        }
        if (str == null) {
            return 0.0f;
        }
        try {
            float parseFloat = Float.parseFloat(str);
            return ((double) parseFloat) > sVar.l() ? Float.parseFloat(sVar.i()) : parseFloat;
        } catch (NumberFormatException unused) {
            return 0.0f;
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1997rd
    public boolean c(OptionMenuItem optionMenuItem) {
        NexTimelineItem.l lVar;
        Object obj = optionMenuItem.A;
        if (obj instanceof com.nexstreaming.app.general.nexasset.assetpackage.s) {
            com.nexstreaming.app.general.nexasset.assetpackage.s sVar = (com.nexstreaming.app.general.nexasset.assetpackage.s) obj;
            lVar = this.f21773a.f21808b;
            String str = lVar.getEffectOptions().get(sVar.getId());
            if (str == null) {
                str = sVar.i();
            }
            if (sVar.m().equals(str)) {
                return true;
            }
            if (sVar.h().equals(str)) {
            }
        }
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1997rd
    public int d(OptionMenuItem optionMenuItem) {
        NexTimelineItem.l lVar;
        Object obj = optionMenuItem.A;
        if (!(obj instanceof com.nexstreaming.app.general.nexasset.assetpackage.s)) {
            return 0;
        }
        com.nexstreaming.app.general.nexasset.assetpackage.s sVar = (com.nexstreaming.app.general.nexasset.assetpackage.s) obj;
        lVar = this.f21773a.f21808b;
        String str = lVar.getEffectOptions().get(sVar.getId());
        if (str == null) {
            str = sVar.i();
        }
        int a2 = C1703g.a(str);
        return sVar.getType() != ItemParameterType.RGBA ? a2 | ViewCompat.MEASURED_STATE_MASK : a2;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1997rd
    public void a(OptionMenuItem optionMenuItem, float f2, boolean z) {
        NexTimelineItem.l lVar;
        Object obj = optionMenuItem.A;
        if (obj instanceof com.nexstreaming.app.general.nexasset.assetpackage.s) {
            lVar = this.f21773a.f21808b;
            lVar.getEffectOptions().put(((com.nexstreaming.app.general.nexasset.assetpackage.s) obj).getId(), String.valueOf(f2));
            this.f21773a.a(z);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1997rd
    public String a(OptionMenuItem optionMenuItem) {
        NexTimelineItem.l lVar;
        Object obj = optionMenuItem.A;
        if (!(obj instanceof com.nexstreaming.app.general.nexasset.assetpackage.s)) {
            return null;
        }
        com.nexstreaming.app.general.nexasset.assetpackage.s sVar = (com.nexstreaming.app.general.nexasset.assetpackage.s) obj;
        lVar = this.f21773a.f21808b;
        String str = lVar.getEffectOptions().get(sVar.getId());
        return str == null ? sVar.i() : str;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1997rd
    public void a(OptionMenuItem optionMenuItem, String str) {
        NexTimelineItem.l lVar;
        Object obj = optionMenuItem.A;
        if (obj instanceof com.nexstreaming.app.general.nexasset.assetpackage.s) {
            lVar = this.f21773a.f21808b;
            lVar.getEffectOptions().put(((com.nexstreaming.app.general.nexasset.assetpackage.s) obj).getId(), str);
            this.f21773a.a(true);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1997rd
    public void a(OptionMenuItem optionMenuItem, boolean z) {
        NexTimelineItem.l lVar;
        Object obj = optionMenuItem.A;
        if (obj instanceof com.nexstreaming.app.general.nexasset.assetpackage.s) {
            com.nexstreaming.app.general.nexasset.assetpackage.s sVar = (com.nexstreaming.app.general.nexasset.assetpackage.s) obj;
            lVar = this.f21773a.f21808b;
            lVar.getEffectOptions().put(sVar.getId(), z ? sVar.m() : sVar.h());
            this.f21773a.a(true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1997rd
    public boolean a(ListView listView, OptionMenuItem optionMenuItem, View view) {
        Context context;
        Context context2;
        Object obj = optionMenuItem.A;
        if (obj instanceof com.nexstreaming.app.general.nexasset.assetpackage.s) {
            com.nexstreaming.app.general.nexasset.assetpackage.s sVar = (com.nexstreaming.app.general.nexasset.assetpackage.s) obj;
            if (C.f21796a[sVar.getType().ordinal()] == 6) {
                context = this.f21773a.f21807a;
                PopoutListMenu popoutListMenu = new PopoutListMenu(context, PopoutListMenu.ArrowDirection.RIGHT_CENTER);
                List<s.a> a2 = sVar.a();
                for (int i = 0; i < a2.size(); i++) {
                    s.a aVar = a2.get(i);
                    context2 = this.f21773a.f21807a;
                    popoutListMenu.a(i, com.nexstreaming.app.general.util.J.a(context2, aVar.b().get("label")));
                }
                if (view != 0) {
                    listView = view;
                }
                popoutListMenu.a(listView, 19);
                popoutListMenu.a(new A(this, sVar, view, optionMenuItem));
            }
        }
        return false;
    }
}
