package com.adobe.creativesdk.foundation.internal.settings;

import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CloudPickerActivity.java */
/* loaded from: classes.dex */
public class c implements c.a.a.a.b<ArrayList<AdobeCloud>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ArrayList f5203a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ CloudPickerActivity f5204b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(CloudPickerActivity cloudPickerActivity, ArrayList arrayList) {
        this.f5204b = cloudPickerActivity;
        this.f5203a = arrayList;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(ArrayList<AdobeCloud> arrayList) {
        if (!arrayList.isEmpty()) {
            Iterator<AdobeCloud> it = arrayList.iterator();
            while (it.hasNext()) {
                this.f5203a.add(it.next());
            }
        }
        CloudPickerActivity cloudPickerActivity = this.f5204b;
        cloudPickerActivity.f5198f = this.f5203a;
        cloudPickerActivity.u();
    }
}
