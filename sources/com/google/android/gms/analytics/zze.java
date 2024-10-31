package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LogPrinter;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;

@VisibleForTesting
/* loaded from: classes.dex */
public final class zze implements zzo {

    /* renamed from: a */
    private static final Uri f10361a;

    /* renamed from: b */
    private final LogPrinter f10362b = new LogPrinter(4, "GA/LogCatTransport");

    static {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(ShareConstants.MEDIA_URI);
        builder.authority("local");
        f10361a = builder.build();
    }

    @Override // com.google.android.gms.analytics.zzo
    public final void a(zzg zzgVar) {
        ArrayList arrayList = new ArrayList(zzgVar.b());
        Collections.sort(arrayList, new b(this));
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            String obj2 = ((zzi) obj).toString();
            if (!TextUtils.isEmpty(obj2)) {
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                sb.append(obj2);
            }
        }
        this.f10362b.println(sb.toString());
    }

    @Override // com.google.android.gms.analytics.zzo
    public final Uri c() {
        return f10361a;
    }
}
