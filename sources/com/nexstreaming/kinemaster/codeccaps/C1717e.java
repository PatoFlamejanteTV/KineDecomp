package com.nexstreaming.kinemaster.codeccaps;

import android.content.SharedPreferences;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BlacklistManagerFactory.java */
/* renamed from: com.nexstreaming.kinemaster.codeccaps.e */
/* loaded from: classes.dex */
public class C1717e implements InterfaceC1716d {

    /* renamed from: a */
    final /* synthetic */ SharedPreferences f20096a;

    public C1717e(SharedPreferences sharedPreferences) {
        this.f20096a = sharedPreferences;
    }

    @Override // com.nexstreaming.kinemaster.codeccaps.InterfaceC1716d
    public void a() {
        this.f20096a.edit().remove("km.capacheck.blacklist.inprogress").commit();
    }

    @Override // com.nexstreaming.kinemaster.codeccaps.InterfaceC1716d
    public String b() {
        return this.f20096a.getString("km.capacheck.blacklist.inprogress", null);
    }

    @Override // com.nexstreaming.kinemaster.codeccaps.InterfaceC1716d
    public boolean c(String str) {
        Set<String> stringSet = this.f20096a.getStringSet("km.capacheck.blacklist.content", null);
        return stringSet != null && stringSet.contains(str);
    }

    @Override // com.nexstreaming.kinemaster.codeccaps.InterfaceC1716d
    public void a(String str) {
        Set<String> stringSet = this.f20096a.getStringSet("km.capacheck.blacklist.content", null);
        HashSet hashSet = new HashSet();
        if (stringSet != null) {
            hashSet.addAll(stringSet);
        }
        hashSet.add(str);
        this.f20096a.edit().putStringSet("km.capacheck.blacklist.content", hashSet).commit();
    }

    @Override // com.nexstreaming.kinemaster.codeccaps.InterfaceC1716d
    public void b(String str) {
        this.f20096a.edit().putString("km.capacheck.blacklist.inprogress", str).commit();
    }
}
