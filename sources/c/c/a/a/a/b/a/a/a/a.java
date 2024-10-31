package c.c.a.a.a.b.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/* compiled from: AuthLocalCache.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f3501a;

    /* renamed from: b, reason: collision with root package name */
    private final Gson f3502b = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSz").create();

    public a(Context context, String str) {
        this.f3501a = context.getSharedPreferences(str, 0);
    }

    public SharedPreferences a() {
        return this.f3501a;
    }

    public void b(String str, String str2) {
        a().edit().putString(str, str2).apply();
    }

    public String a(String str, String str2) {
        return a().getString(str, str2);
    }
}
