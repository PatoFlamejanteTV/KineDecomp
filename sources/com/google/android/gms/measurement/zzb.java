package com.google.android.gms.measurement;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LogPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class zzb implements zzi {

    /* renamed from: a, reason: collision with root package name */
    private static final Uri f2076a;
    private final LogPrinter b = new LogPrinter(4, "GA/LogCatTransport");

    static {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("uri");
        builder.authority("local");
        f2076a = builder.build();
    }

    @Override // com.google.android.gms.measurement.zzi
    public Uri a() {
        return f2076a;
    }

    @Override // com.google.android.gms.measurement.zzi
    public void a(zzc zzcVar) {
        ArrayList arrayList = new ArrayList(zzcVar.b());
        Collections.sort(arrayList, new c(this));
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String obj = ((zze) it.next()).toString();
            if (!TextUtils.isEmpty(obj)) {
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                sb.append(obj);
            }
        }
        this.b.println(sb.toString());
    }
}
