package com.nexstreaming.kinemaster.ui.welcome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectgallery.ProjectGalleryActivity;
import com.nexstreaming.kinemaster.ui.settings.tb;
import com.nextreaming.nexeditorui.I;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import kotlin.k;
import me.relex.circleindicator.CircleIndicator;

/* compiled from: WelcomeFragment.kt */
/* loaded from: classes2.dex */
public final class c extends Fragment implements com.nexstreaming.kinemaster.ui.welcome.a {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.g[] f23694a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f23695b;

    /* renamed from: c, reason: collision with root package name */
    private final String f23696c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f23697d;

    /* renamed from: e, reason: collision with root package name */
    private int f23698e;

    /* renamed from: f, reason: collision with root package name */
    private final ArrayList<b> f23699f;

    /* renamed from: g, reason: collision with root package name */
    private final kotlin.d f23700g;

    /* renamed from: h, reason: collision with root package name */
    private final kotlin.jvm.a.a<k> f23701h;
    private HashMap i;

    /* compiled from: WelcomeFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final c a(boolean z) {
            c cVar = new c();
            Bundle bundle = new Bundle();
            bundle.putBoolean("IS_FIRST_USER", z);
            cVar.setArguments(bundle);
            return cVar;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    static {
        PropertyReference1Impl propertyReference1Impl = new PropertyReference1Impl(j.a(c.class), "welcomeAdapter", "getWelcomeAdapter()Lcom/nexstreaming/kinemaster/ui/welcome/WelcomeViewPagerAdapter;");
        j.a(propertyReference1Impl);
        f23694a = new kotlin.reflect.g[]{propertyReference1Impl};
        f23695b = new a(null);
    }

    public c() {
        ArrayList<b> a2;
        kotlin.d a3;
        String simpleName = c.class.getSimpleName();
        h.a((Object) simpleName, "WelcomeFragment::class.java.simpleName");
        this.f23696c = simpleName;
        a2 = kotlin.collections.k.a((Object[]) new b[]{new b(R.string.app_promotion_page1_a, R.string.app_promotion_page1_b, R.raw.v1_1280x506, "v1_1280x506.mp4"), new b(R.string.app_promotion_page2_a, R.string.app_promotion_page2_b, R.raw.v2_1280x506, "v2_1280x506.mp4"), new b(R.string.app_promotion_page3_a, R.string.app_promotion_page3_b, R.raw.v3_1280x506, "v3_1280x506"), new b(-1, R.string.app_promotion_page4_b, R.raw.v4_1280x506, "v4_1280x506")});
        this.f23699f = a2;
        a3 = kotlin.f.a(new kotlin.jvm.a.a<g>() { // from class: com.nexstreaming.kinemaster.ui.welcome.WelcomeFragment$welcomeAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.a.a
            public final g invoke() {
                ArrayList arrayList;
                kotlin.jvm.a.a aVar;
                c cVar = c.this;
                arrayList = cVar.f23699f;
                aVar = c.this.f23701h;
                return new g(cVar, arrayList, aVar);
            }
        });
        this.f23700g = a3;
        this.f23701h = new kotlin.jvm.a.a<k>() { // from class: com.nexstreaming.kinemaster.ui.welcome.WelcomeFragment$onClickStartButton$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.a.a
            public /* bridge */ /* synthetic */ k invoke() {
                invoke2();
                return k.f28545a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Context context = c.this.getContext();
                if (context != null) {
                    c.d.b.m.c.d(context);
                }
                FragmentActivity activity = c.this.getActivity();
                if (activity == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.nextreaming.nexeditorui.KineMasterBaseActivity");
                }
                if (((I) activity).C()) {
                    c.this.C();
                } else {
                    c.this.A();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g B() {
        kotlin.d dVar = this.f23700g;
        kotlin.reflect.g gVar = f23694a[0];
        return (g) dVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            h.a((Object) activity, "fragmentActivity");
            Intent intent = activity.getIntent();
            if (intent != null) {
                startActivity(intent.setClass(activity, ProjectGalleryActivity.class));
                activity.finish();
            }
        }
    }

    public void A() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (activity != null) {
                I i = (I) activity;
                i.getSupportFragmentManager().beginTransaction().replace(android.R.id.content, tb.a(i.y(), 0, this.f23696c, "Welcome Page"), tb.f23200a).addToBackStack(tb.f23200a).commitAllowingStateLoss();
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.nextreaming.nexeditorui.KineMasterBaseActivity");
        }
    }

    public View m(int i) {
        if (this.i == null) {
            this.i = new HashMap();
        }
        View view = (View) this.i.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this.i.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        CircleIndicator circleIndicator = (CircleIndicator) m(com.nexstreaming.app.kinemasterfree.b.indicator);
        ViewPager viewPager = (ViewPager) m(com.nexstreaming.app.kinemasterfree.b.vpWelcome);
        viewPager.addOnPageChangeListener(new d(this));
        viewPager.setOffscreenPageLimit(this.f23699f.size());
        viewPager.setAdapter(B());
        circleIndicator.setViewPager(viewPager);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f23697d = arguments.getBoolean("IS_FIRST_USER");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.b(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_welcome, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        z();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        B().b();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        B().a(this.f23698e);
    }

    public void show(FragmentManager fragmentManager) {
        h.b(fragmentManager, "fragmentManager");
        fragmentManager.beginTransaction().replace(android.R.id.content, this, this.f23696c).commitAllowingStateLoss();
    }

    public void z() {
        HashMap hashMap = this.i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
