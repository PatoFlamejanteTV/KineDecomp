package c.d.b.l;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.nexstreaming.kinemaster.layer.SplitScreenType;
import com.nextreaming.nexeditorui.KineMasterApplication;

/* compiled from: UserDefaults.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3846a = new a();

    private a() {
    }

    private SharedPreferences b() {
        return PreferenceManager.getDefaultSharedPreferences(KineMasterApplication.f24056d.getApplicationContext());
    }

    public SplitScreenType a() {
        return (SplitScreenType) a("defaultSplitScreenType", SplitScreenType.OFF);
    }

    private <T extends Enum> void b(String str, T t) {
        b().edit().putString("com.kinemaster.userdefault." + str, t.name()).apply();
    }

    public void a(SplitScreenType splitScreenType) {
        b("defaultSplitScreenType", splitScreenType);
    }

    private <T extends Enum<T>> T a(String str, T t) {
        return (T) Enum.valueOf(t.getClass(), b().getString("com.kinemaster.userdefault." + str, t.name()));
    }
}
