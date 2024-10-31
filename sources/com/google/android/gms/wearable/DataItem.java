package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.common.data.Freezable;
import java.util.Map;

/* loaded from: classes.dex */
public interface DataItem extends Freezable<DataItem> {
    Uri b();

    byte[] c();

    Map<String, DataItemAsset> d();
}
