package android.support.v4.app;

import android.arch.lifecycle.r;
import java.util.List;

/* loaded from: classes.dex */
public class FragmentManagerNonConfig {

    /* renamed from: a */
    private final List<Fragment> f768a;

    /* renamed from: b */
    private final List<FragmentManagerNonConfig> f769b;

    /* renamed from: c */
    private final List<r> f770c;

    public FragmentManagerNonConfig(List<Fragment> list, List<FragmentManagerNonConfig> list2, List<r> list3) {
        this.f768a = list;
        this.f769b = list2;
        this.f770c = list3;
    }

    public List<FragmentManagerNonConfig> a() {
        return this.f769b;
    }

    public List<Fragment> b() {
        return this.f768a;
    }

    public List<r> c() {
        return this.f770c;
    }
}
