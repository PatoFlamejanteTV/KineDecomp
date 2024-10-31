package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;

/* loaded from: classes.dex */
public class zzg {

    /* renamed from: a */
    final String f2057a;
    final String b;
    final String c;
    final long d;
    final long e;
    final EventParams f;

    public zzg(zzv zzvVar, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzx.a(str2);
        zzx.a(str3);
        this.f2057a = str2;
        this.b = str3;
        this.c = TextUtils.isEmpty(str) ? null : str;
        this.d = j;
        this.e = j2;
        if (this.e != 0 && this.e > this.d) {
            zzvVar.f().o().a("Event created with reverse previous/current timestamps");
        }
        if (bundle == null || bundle.isEmpty()) {
            this.f = new EventParams(new Bundle());
            return;
        }
        Bundle bundle2 = new Bundle(bundle);
        Iterator<String> it = bundle2.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next == null) {
                it.remove();
            } else {
                Object a2 = zzvVar.j().a(bundle2.get(next));
                if (a2 == null) {
                    it.remove();
                } else {
                    zzvVar.j().a(bundle2, next, a2);
                }
            }
        }
        this.f = new EventParams(bundle2);
    }

    private zzg(zzv zzvVar, String str, String str2, String str3, long j, long j2, EventParams eventParams) {
        zzx.a(str2);
        zzx.a(str3);
        zzx.a(eventParams);
        this.f2057a = str2;
        this.b = str3;
        this.c = TextUtils.isEmpty(str) ? null : str;
        this.d = j;
        this.e = j2;
        if (this.e != 0 && this.e > this.d) {
            zzvVar.f().o().a("Event created with reverse previous/current timestamps");
        }
        this.f = eventParams;
    }

    public zzg a(zzv zzvVar, long j) {
        return new zzg(zzvVar, this.c, this.f2057a, this.b, this.d, j, this.f);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Event{");
        sb.append("appId='").append(this.f2057a).append('\'');
        sb.append(", name='").append(this.b).append('\'');
        sb.append(", params=").append(this.f);
        sb.append('}');
        return sb.toString();
    }
}
