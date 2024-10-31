package com.nexstreaming.kinemaster.codeccaps;

import android.preference.PreferenceManager;
import com.nextreaming.nexeditorui.KineMasterApplication;

/* compiled from: BlacklistManagerFactory.java */
/* renamed from: com.nexstreaming.kinemaster.codeccaps.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1719g {

    /* renamed from: a, reason: collision with root package name */
    public static final InterfaceC1716d f20098a = new C1718f();

    public static InterfaceC1716d a() {
        return new C1717e(PreferenceManager.getDefaultSharedPreferences(KineMasterApplication.f24056d.getApplicationContext()));
    }
}
