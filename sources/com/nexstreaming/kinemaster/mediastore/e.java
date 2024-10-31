package com.nexstreaming.kinemaster.mediastore;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: FavoriteManager.kt */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: d */
    private final Context f20892d;

    /* renamed from: c */
    public static final a f20891c = new a(null);

    /* renamed from: a */
    private static final String f20889a = "favorite";

    /* renamed from: b */
    private static final String f20890b = f20890b;

    /* renamed from: b */
    private static final String f20890b = f20890b;

    /* compiled from: FavoriteManager.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public e(Context context) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.h.a((Object) applicationContext, "context.applicationContext");
        this.f20892d = applicationContext;
        SharedPreferences a2 = a(this.f20892d);
        Set<String> stringSet = a2.getStringSet(f20889a, null);
        Set<String> stringSet2 = a2.getStringSet(f20890b, null);
        if (stringSet == null || stringSet.size() <= 0) {
            return;
        }
        if (stringSet2 == null || stringSet2.size() < 1) {
            HashSet hashSet = new HashSet();
            Iterator<String> it = stringSet.iterator();
            while (it.hasNext()) {
                hashSet.add("AndroidMediaStore:I" + it.next());
            }
            a2.edit().remove(f20889a).putStringSet(f20890b, hashSet).apply();
        }
    }

    public final Set<MediaStoreItemId> a() {
        SharedPreferences a2 = a(this.f20892d);
        HashSet hashSet = new HashSet();
        Set<String> stringSet = a2.getStringSet(f20890b, null);
        if (stringSet != null) {
            Iterator<String> it = stringSet.iterator();
            while (it.hasNext()) {
                hashSet.add(new MediaStoreItemId(it.next()));
            }
        }
        return hashSet;
    }

    public final void b(MediaStoreItemId mediaStoreItemId) {
        kotlin.jvm.internal.h.b(mediaStoreItemId, "item");
        SharedPreferences a2 = a(this.f20892d);
        HashSet hashSet = new HashSet();
        Set<String> stringSet = a2.getStringSet(f20890b, null);
        if (stringSet != null) {
            hashSet.addAll(stringSet);
        }
        hashSet.remove(mediaStoreItemId.toString());
        a2.edit().putStringSet(f20890b, hashSet).apply();
    }

    public final boolean c(MediaStoreItemId mediaStoreItemId) {
        kotlin.jvm.internal.h.b(mediaStoreItemId, "item");
        Set<String> stringSet = a(this.f20892d).getStringSet(f20890b, null);
        if (stringSet != null) {
            return stringSet.contains(mediaStoreItemId.toString());
        }
        return false;
    }

    private final SharedPreferences a(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        kotlin.jvm.internal.h.a((Object) defaultSharedPreferences, "PreferenceManager.getDef…haredPreferences(context)");
        return defaultSharedPreferences;
    }

    public final void a(MediaStoreItemId mediaStoreItemId) {
        kotlin.jvm.internal.h.b(mediaStoreItemId, "item");
        SharedPreferences a2 = a(this.f20892d);
        HashSet hashSet = new HashSet();
        Set<String> stringSet = a2.getStringSet(f20890b, null);
        if (stringSet != null) {
            hashSet.addAll(stringSet);
        }
        hashSet.add(mediaStoreItemId.toString());
        a2.edit().putStringSet(f20890b, hashSet).apply();
    }
}
