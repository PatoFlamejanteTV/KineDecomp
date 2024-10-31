package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AssetSettingsManager.java */
/* loaded from: classes2.dex */
public class D {

    /* renamed from: a, reason: collision with root package name */
    private Context f21807a;

    /* renamed from: b, reason: collision with root package name */
    private NexTimelineItem.l f21808b;

    /* renamed from: c, reason: collision with root package name */
    private a f21809c;

    /* renamed from: d, reason: collision with root package name */
    private List<OptionMenuItem> f21810d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private InterfaceC1997rd f21811e = new B(this);

    /* compiled from: AssetSettingsManager.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a(boolean z);
    }

    public D(Context context) {
        this.f21807a = context;
    }

    private Context c() {
        return this.f21807a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int[] b() {
        int[] iArr = new int[this.f21810d.size()];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = this.f21810d.get(i).f21997c;
        }
        return iArr;
    }

    public void a(NexTimelineItem.l lVar) {
        OptionMenuItem a2;
        this.f21808b = lVar;
        String effectItemID = lVar.getEffectItemID();
        com.nexstreaming.app.general.nexasset.assetpackage.r a3 = com.nexstreaming.app.general.nexasset.assetpackage.h.a(this.f21807a).a(effectItemID);
        this.f21810d.clear();
        try {
            for (com.nexstreaming.app.general.nexasset.assetpackage.s sVar : com.nexstreaming.app.general.nexasset.assetpackage.y.a(c(), effectItemID).e()) {
                if (!sVar.isHidden() && (a2 = a(a3, sVar)) != null) {
                    this.f21810d.add(a2);
                }
            }
        } catch (IOException | XmlPullParserException e2) {
            throw new RuntimeException("Failed to get parameter definitions for: " + effectItemID, e2);
        }
    }

    public void a(a aVar) {
        this.f21809c = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x015f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x014b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0137 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.nexstreaming.kinemaster.ui.projectedit.OptionMenuItem a(com.nexstreaming.app.general.nexasset.assetpackage.r r10, com.nexstreaming.app.general.nexasset.assetpackage.s r11) {
        /*
            Method dump skipped, instructions count: 574
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.D.a(com.nexstreaming.app.general.nexasset.assetpackage.r, com.nexstreaming.app.general.nexasset.assetpackage.s):com.nexstreaming.kinemaster.ui.projectedit.OptionMenuItem");
    }

    public InterfaceC1997rd a() {
        return this.f21811e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        a aVar = this.f21809c;
        if (aVar != null) {
            aVar.a(z);
        }
    }
}
