package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag;
import java.util.Map;

/* loaded from: classes.dex */
public class zzaf extends aj {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2230a = zzad.EQUALS.toString();

    public zzaf() {
        super(f2230a);
    }

    @Override // com.google.android.gms.tagmanager.aj
    protected boolean a(String str, String str2, Map<String, zzag.zza> map) {
        return str.equals(str2);
    }
}
