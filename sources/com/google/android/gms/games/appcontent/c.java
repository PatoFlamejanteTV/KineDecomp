package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.appcontent.AppContentUtils;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements AppContentUtils.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ArrayList f1311a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ArrayList arrayList) {
        this.f1311a = arrayList;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentUtils.a
    public void a(ArrayList<DataHolder> arrayList, int i) {
        this.f1311a.add(new AppContentConditionRef(arrayList, i));
    }
}
