package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import java.util.List;

/* loaded from: classes.dex */
public interface AppContentSection extends Parcelable, Freezable<AppContentSection> {
    List<AppContentAction> b();

    List<AppContentAnnotation> c();

    List<AppContentCard> d();

    String e();

    String f();

    Bundle g();

    String h();

    String i();

    String j();

    String k();
}
