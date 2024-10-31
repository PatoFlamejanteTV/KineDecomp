package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.appcontent.AppContentUtils;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements AppContentUtils.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DataHolder f1312a;
    final /* synthetic */ Bundle b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(DataHolder dataHolder, Bundle bundle) {
        this.f1312a = dataHolder;
        this.b = bundle;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentUtils.a
    public void a(ArrayList<DataHolder> arrayList, int i) {
        AppContentTupleRef appContentTupleRef = new AppContentTupleRef(this.f1312a, i);
        this.b.putString(appContentTupleRef.b(), appContentTupleRef.c());
    }
}
