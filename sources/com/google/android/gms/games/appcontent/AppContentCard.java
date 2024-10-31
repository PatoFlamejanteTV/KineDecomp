package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import java.util.List;

/* loaded from: classes.dex */
public interface AppContentCard extends Parcelable, Freezable<AppContentCard> {
    List<AppContentAction> b();

    List<AppContentAnnotation> c();

    List<AppContentCondition> d();

    String e();

    int f();

    String g();

    Bundle h();

    String i();

    String j();

    String k();

    int l();

    String m();
}
