package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import java.util.List;

/* loaded from: classes.dex */
public interface AppContentAction extends Parcelable, Freezable<AppContentAction> {
    AppContentAnnotation b();

    List<AppContentCondition> c();

    String d();

    Bundle e();

    String f();

    String g();

    String h();
}
