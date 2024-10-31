package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.appcontent.AppContentUtils;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a implements AppContentUtils.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ArrayList f1309a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ArrayList arrayList) {
        this.f1309a = arrayList;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentUtils.a
    public void a(ArrayList<DataHolder> arrayList, int i) {
        this.f1309a.add(new AppContentActionRef(arrayList, i));
    }
}
