package com.nexstreaming.kinemaster.mediastore.v2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: FavoriteManager.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Context f3558a;

    public b(Context context) {
        this.f3558a = context.getApplicationContext();
        SharedPreferences a2 = a(this.f3558a);
        Set<String> stringSet = a2.getStringSet("favorite", null);
        Set<String> stringSet2 = a2.getStringSet("favorite_msid", null);
        if (stringSet == null || stringSet.size() <= 0) {
            return;
        }
        if (stringSet2 == null || stringSet2.size() < 1) {
            HashSet hashSet = new HashSet();
            Iterator<String> it = stringSet.iterator();
            while (it.hasNext()) {
                hashSet.add("AndroidMediaStore:I" + it.next());
            }
            a2.edit().remove("favorite").putStringSet("favorite_msid", hashSet).apply();
        }
    }

    private SharedPreferences a(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public Set<MSID> a() {
        SharedPreferences a2 = a(this.f3558a);
        HashSet hashSet = new HashSet();
        Set<String> stringSet = a2.getStringSet("favorite_msid", null);
        if (stringSet != null) {
            Iterator<String> it = stringSet.iterator();
            while (it.hasNext()) {
                hashSet.add(new MSID(it.next()));
            }
        }
        return hashSet;
    }

    public boolean a(MSID msid) {
        Set<String> stringSet = a(this.f3558a).getStringSet("favorite_msid", null);
        if (stringSet == null) {
            return false;
        }
        return stringSet.contains(msid.toString());
    }

    public void b(MSID msid) {
        SharedPreferences a2 = a(this.f3558a);
        HashSet hashSet = new HashSet();
        Set<String> stringSet = a2.getStringSet("favorite_msid", null);
        if (stringSet != null) {
            hashSet.addAll(stringSet);
        }
        hashSet.add(msid.toString());
        a2.edit().putStringSet("favorite_msid", hashSet).apply();
    }

    public void c(MSID msid) {
        SharedPreferences a2 = a(this.f3558a);
        HashSet hashSet = new HashSet();
        Set<String> stringSet = a2.getStringSet("favorite_msid", null);
        if (stringSet != null) {
            hashSet.addAll(stringSet);
        }
        hashSet.remove(msid.toString());
        a2.edit().putStringSet("favorite_msid", hashSet).apply();
    }
}
