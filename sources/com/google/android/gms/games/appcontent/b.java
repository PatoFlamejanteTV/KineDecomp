package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.appcontent.AppContentUtils;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements AppContentUtils.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ArrayList f1310a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ArrayList arrayList) {
        this.f1310a = arrayList;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentUtils.a
    public void a(ArrayList<DataHolder> arrayList, int i) {
        this.f1310a.add(new AppContentAnnotationRef(arrayList, i));
    }
}
