package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class zzbb extends i {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2232a = zzad.LANGUAGE.toString();

    public zzbb() {
        super(f2232a, new String[0]);
    }

    @Override // com.google.android.gms.tagmanager.i
    public zzag.zza a(Map<String, zzag.zza> map) {
        String language;
        Locale locale = Locale.getDefault();
        if (locale != null && (language = locale.getLanguage()) != null) {
            return zzdf.c(language.toLowerCase());
        }
        return zzdf.b();
    }

    @Override // com.google.android.gms.tagmanager.i
    public boolean a() {
        return false;
    }

    @Override // com.google.android.gms.tagmanager.i
    public /* bridge */ /* synthetic */ Set b() {
        return super.b();
    }
}
