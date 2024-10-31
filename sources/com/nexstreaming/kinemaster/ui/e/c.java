package com.nexstreaming.kinemaster.ui.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.TransparentTextButton;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.jvm.internal.h;

/* compiled from: PermissionRationaleFragment.kt */
/* loaded from: classes.dex */
public final class c extends Fragment {

    /* renamed from: c, reason: collision with root package name */
    private String[] f21571c;

    /* renamed from: d, reason: collision with root package name */
    private int f21572d = -1;

    /* renamed from: e, reason: collision with root package name */
    private final long f21573e = 1000;

    /* renamed from: f, reason: collision with root package name */
    private final long f21574f = 500;

    /* renamed from: g, reason: collision with root package name */
    private final long f21575g = 200;

    /* renamed from: h, reason: collision with root package name */
    private int f21576h;
    private boolean i;
    private b j;
    private HashMap k;

    /* renamed from: b, reason: collision with root package name */
    public static final a f21570b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private static final String f21569a = c.class.getSimpleName();

    /* compiled from: PermissionRationaleFragment.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public final c a(String[] strArr) {
            h.b(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
            c cVar = new c();
            Bundle bundle = new Bundle();
            bundle.putStringArray(NativeProtocol.RESULT_ARGS_PERMISSIONS, strArr);
            bundle.putInt("request_code", 8227);
            cVar.setArguments(bundle);
            return cVar;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: PermissionRationaleFragment.kt */
    /* loaded from: classes.dex */
    public interface b {
        void a(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        if (getActivity() != null) {
            if (this.i) {
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    h.a();
                    throw null;
                }
                h.a((Object) activity, "activity!!");
                activity.getSupportFragmentManager().popBackStack();
                return;
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                h.a((Object) activity2, "activity!!");
                activity2.getSupportFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
            } else {
                h.a();
                throw null;
            }
        }
    }

    private final void B() {
        String[] strArr = com.nexstreaming.kinemaster.ui.e.b.f21565c;
        String[] strArr2 = this.f21571c;
        if (strArr2 == null) {
            h.b(NativeProtocol.RESULT_ARGS_PERMISSIONS);
            throw null;
        }
        if (Arrays.equals(strArr, strArr2)) {
            ((TextView) m(com.nexstreaming.app.kinemasterfree.b.permission_contentPrimary)).setText(R.string.permission_content_camcorder_primary);
            ((TextView) m(com.nexstreaming.app.kinemasterfree.b.permission_contentSecondary)).setText(R.string.permission_content_camcorder_secondary);
            if (D()) {
                TextView textView = (TextView) m(com.nexstreaming.app.kinemasterfree.b.permission_contentSecondary);
                h.a((Object) textView, "permission_contentSecondary");
                textView.setVisibility(8);
                TransparentTextButton transparentTextButton = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonAllow);
                h.a((Object) transparentTextButton, "permission_buttonAllow");
                transparentTextButton.setVisibility(0);
                TransparentTextButton transparentTextButton2 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonAppInfo);
                h.a((Object) transparentTextButton2, "permission_buttonAppInfo");
                transparentTextButton2.setVisibility(8);
                TransparentTextButton transparentTextButton3 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonCancel);
                h.a((Object) transparentTextButton3, "permission_buttonCancel");
                transparentTextButton3.setVisibility(0);
                return;
            }
            TextView textView2 = (TextView) m(com.nexstreaming.app.kinemasterfree.b.permission_contentSecondary);
            h.a((Object) textView2, "permission_contentSecondary");
            textView2.setVisibility(0);
            TransparentTextButton transparentTextButton4 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonAllow);
            h.a((Object) transparentTextButton4, "permission_buttonAllow");
            transparentTextButton4.setVisibility(8);
            TransparentTextButton transparentTextButton5 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonAppInfo);
            h.a((Object) transparentTextButton5, "permission_buttonAppInfo");
            transparentTextButton5.setVisibility(0);
            TransparentTextButton transparentTextButton6 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonCancel);
            h.a((Object) transparentTextButton6, "permission_buttonCancel");
            transparentTextButton6.setVisibility(0);
            return;
        }
        String[] strArr3 = com.nexstreaming.kinemaster.ui.e.b.f21568f;
        String[] strArr4 = this.f21571c;
        if (strArr4 != null) {
            if (!Arrays.equals(strArr3, strArr4)) {
                String[] strArr5 = com.nexstreaming.kinemaster.ui.e.b.f21563a;
                String[] strArr6 = this.f21571c;
                if (strArr6 == null) {
                    h.b(NativeProtocol.RESULT_ARGS_PERMISSIONS);
                    throw null;
                }
                if (!Arrays.equals(strArr5, strArr6)) {
                    String[] strArr7 = com.nexstreaming.kinemaster.ui.e.b.f21567e;
                    String[] strArr8 = this.f21571c;
                    if (strArr8 == null) {
                        h.b(NativeProtocol.RESULT_ARGS_PERMISSIONS);
                        throw null;
                    }
                    if (Arrays.equals(strArr7, strArr8)) {
                        ((TextView) m(com.nexstreaming.app.kinemasterfree.b.permission_contentPrimary)).setText(R.string.permission_content_phone_primary);
                        ((TextView) m(com.nexstreaming.app.kinemasterfree.b.permission_contentSecondary)).setText(R.string.permission_content_phone_secondary);
                        if (D()) {
                            TextView textView3 = (TextView) m(com.nexstreaming.app.kinemasterfree.b.permission_contentSecondary);
                            h.a((Object) textView3, "permission_contentSecondary");
                            textView3.setVisibility(8);
                            TransparentTextButton transparentTextButton7 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonAllow);
                            h.a((Object) transparentTextButton7, "permission_buttonAllow");
                            transparentTextButton7.setVisibility(0);
                            TransparentTextButton transparentTextButton8 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonAppInfo);
                            h.a((Object) transparentTextButton8, "permission_buttonAppInfo");
                            transparentTextButton8.setVisibility(8);
                            TransparentTextButton transparentTextButton9 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonCancel);
                            h.a((Object) transparentTextButton9, "permission_buttonCancel");
                            transparentTextButton9.setVisibility(8);
                            return;
                        }
                        TextView textView4 = (TextView) m(com.nexstreaming.app.kinemasterfree.b.permission_contentSecondary);
                        h.a((Object) textView4, "permission_contentSecondary");
                        textView4.setVisibility(0);
                        TransparentTextButton transparentTextButton10 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonAllow);
                        h.a((Object) transparentTextButton10, "permission_buttonAllow");
                        transparentTextButton10.setVisibility(8);
                        TransparentTextButton transparentTextButton11 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonAppInfo);
                        h.a((Object) transparentTextButton11, "permission_buttonAppInfo");
                        transparentTextButton11.setVisibility(0);
                        TransparentTextButton transparentTextButton12 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonCancel);
                        h.a((Object) transparentTextButton12, "permission_buttonCancel");
                        transparentTextButton12.setVisibility(8);
                        return;
                    }
                    String[] strArr9 = com.nexstreaming.kinemaster.ui.e.b.f21564b;
                    String[] strArr10 = this.f21571c;
                    if (strArr10 == null) {
                        h.b(NativeProtocol.RESULT_ARGS_PERMISSIONS);
                        throw null;
                    }
                    if (Arrays.equals(strArr9, strArr10)) {
                        ((TextView) m(com.nexstreaming.app.kinemasterfree.b.permission_contentPrimary)).setText(R.string.permission_content_camera_primary);
                        ((TextView) m(com.nexstreaming.app.kinemasterfree.b.permission_contentSecondary)).setText(R.string.permission_content_camera_secondary);
                        if (D()) {
                            TextView textView5 = (TextView) m(com.nexstreaming.app.kinemasterfree.b.permission_contentSecondary);
                            h.a((Object) textView5, "permission_contentSecondary");
                            textView5.setVisibility(8);
                            TransparentTextButton transparentTextButton13 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonAllow);
                            h.a((Object) transparentTextButton13, "permission_buttonAllow");
                            transparentTextButton13.setVisibility(0);
                            TransparentTextButton transparentTextButton14 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonAppInfo);
                            h.a((Object) transparentTextButton14, "permission_buttonAppInfo");
                            transparentTextButton14.setVisibility(8);
                            TransparentTextButton transparentTextButton15 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonCancel);
                            h.a((Object) transparentTextButton15, "permission_buttonCancel");
                            transparentTextButton15.setVisibility(0);
                            return;
                        }
                        TextView textView6 = (TextView) m(com.nexstreaming.app.kinemasterfree.b.permission_contentSecondary);
                        h.a((Object) textView6, "permission_contentSecondary");
                        textView6.setVisibility(0);
                        TransparentTextButton transparentTextButton16 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonAllow);
                        h.a((Object) transparentTextButton16, "permission_buttonAllow");
                        transparentTextButton16.setVisibility(8);
                        TransparentTextButton transparentTextButton17 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonAppInfo);
                        h.a((Object) transparentTextButton17, "permission_buttonAppInfo");
                        transparentTextButton17.setVisibility(0);
                        TransparentTextButton transparentTextButton18 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonCancel);
                        h.a((Object) transparentTextButton18, "permission_buttonCancel");
                        transparentTextButton18.setVisibility(0);
                        return;
                    }
                    String[] strArr11 = com.nexstreaming.kinemaster.ui.e.b.f21566d;
                    String[] strArr12 = this.f21571c;
                    if (strArr12 == null) {
                        h.b(NativeProtocol.RESULT_ARGS_PERMISSIONS);
                        throw null;
                    }
                    if (!Arrays.equals(strArr11, strArr12)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("we don't need this permission : ");
                        String[] strArr13 = this.f21571c;
                        if (strArr13 == null) {
                            h.b(NativeProtocol.RESULT_ARGS_PERMISSIONS);
                            throw null;
                        }
                        sb.append(strArr13);
                        throw new UnsupportedOperationException(sb.toString());
                    }
                    ((TextView) m(com.nexstreaming.app.kinemasterfree.b.permission_contentPrimary)).setText(R.string.permission_content_audio_record_primary);
                    ((TextView) m(com.nexstreaming.app.kinemasterfree.b.permission_contentSecondary)).setText(R.string.permission_content_audio_record_secondary);
                    if (D()) {
                        TextView textView7 = (TextView) m(com.nexstreaming.app.kinemasterfree.b.permission_contentSecondary);
                        h.a((Object) textView7, "permission_contentSecondary");
                        textView7.setVisibility(8);
                        TransparentTextButton transparentTextButton19 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonAllow);
                        h.a((Object) transparentTextButton19, "permission_buttonAllow");
                        transparentTextButton19.setVisibility(0);
                        TransparentTextButton transparentTextButton20 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonAppInfo);
                        h.a((Object) transparentTextButton20, "permission_buttonAppInfo");
                        transparentTextButton20.setVisibility(8);
                        TransparentTextButton transparentTextButton21 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonCancel);
                        h.a((Object) transparentTextButton21, "permission_buttonCancel");
                        transparentTextButton21.setVisibility(0);
                        return;
                    }
                    TextView textView8 = (TextView) m(com.nexstreaming.app.kinemasterfree.b.permission_contentSecondary);
                    h.a((Object) textView8, "permission_contentSecondary");
                    textView8.setVisibility(0);
                    TransparentTextButton transparentTextButton22 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonAllow);
                    h.a((Object) transparentTextButton22, "permission_buttonAllow");
                    transparentTextButton22.setVisibility(8);
                    TransparentTextButton transparentTextButton23 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonAppInfo);
                    h.a((Object) transparentTextButton23, "permission_buttonAppInfo");
                    transparentTextButton23.setVisibility(0);
                    TransparentTextButton transparentTextButton24 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonCancel);
                    h.a((Object) transparentTextButton24, "permission_buttonCancel");
                    transparentTextButton24.setVisibility(0);
                    return;
                }
            }
            ((TextView) m(com.nexstreaming.app.kinemasterfree.b.permission_contentPrimary)).setText(R.string.permission_content_storage_primary);
            ((TextView) m(com.nexstreaming.app.kinemasterfree.b.permission_contentSecondary)).setText(R.string.permission_content_storage_secondary);
            if (D()) {
                TextView textView9 = (TextView) m(com.nexstreaming.app.kinemasterfree.b.permission_contentSecondary);
                h.a((Object) textView9, "permission_contentSecondary");
                textView9.setVisibility(8);
                TransparentTextButton transparentTextButton25 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonAllow);
                h.a((Object) transparentTextButton25, "permission_buttonAllow");
                transparentTextButton25.setVisibility(0);
                TransparentTextButton transparentTextButton26 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonAppInfo);
                h.a((Object) transparentTextButton26, "permission_buttonAppInfo");
                transparentTextButton26.setVisibility(8);
                TransparentTextButton transparentTextButton27 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonCancel);
                h.a((Object) transparentTextButton27, "permission_buttonCancel");
                transparentTextButton27.setVisibility(8);
                return;
            }
            TextView textView10 = (TextView) m(com.nexstreaming.app.kinemasterfree.b.permission_contentSecondary);
            h.a((Object) textView10, "permission_contentSecondary");
            textView10.setVisibility(0);
            TransparentTextButton transparentTextButton28 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonAllow);
            h.a((Object) transparentTextButton28, "permission_buttonAllow");
            transparentTextButton28.setVisibility(8);
            TransparentTextButton transparentTextButton29 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonAppInfo);
            h.a((Object) transparentTextButton29, "permission_buttonAppInfo");
            transparentTextButton29.setVisibility(0);
            TransparentTextButton transparentTextButton30 = (TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonCancel);
            h.a((Object) transparentTextButton30, "permission_buttonCancel");
            transparentTextButton30.setVisibility(8);
            return;
        }
        h.b(NativeProtocol.RESULT_ARGS_PERMISSIONS);
        throw null;
    }

    private final void C() {
        Fade fade = new Fade();
        fade.setStartDelay(this.f21573e);
        fade.setDuration(this.f21574f);
        setEnterTransition(fade);
        Fade fade2 = new Fade();
        fade2.setDuration(this.f21575g);
        setExitTransition(fade2);
    }

    private final boolean D() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
        }
        String[] strArr = this.f21571c;
        if (strArr != null) {
            return com.nexstreaming.kinemaster.ui.e.b.a((Activity) activity, strArr);
        }
        h.b(NativeProtocol.RESULT_ARGS_PERMISSIONS);
        throw null;
    }

    public static final c a(String[] strArr) {
        return f21570b.a(strArr);
    }

    public static final /* synthetic */ String[] b(c cVar) {
        String[] strArr = cVar.f21571c;
        if (strArr != null) {
            return strArr;
        }
        h.b(NativeProtocol.RESULT_ARGS_PERMISSIONS);
        throw null;
    }

    public View m(int i) {
        if (this.k == null) {
            this.k = new HashMap();
        }
        View view = (View) this.k.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this.k.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 8211 && i2 == -1) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
            }
            String[] strArr = this.f21571c;
            if (strArr == null) {
                h.b(NativeProtocol.RESULT_ARGS_PERMISSIONS);
                throw null;
            }
            if (com.nexstreaming.kinemaster.ui.e.b.a((Context) activity, strArr)) {
                this.f21576h = -1;
                A();
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String[] stringArray = arguments.getStringArray(NativeProtocol.RESULT_ARGS_PERMISSIONS);
            h.a((Object) stringArray, "it.getStringArray(ARG_PERMISSIONS)");
            this.f21571c = stringArray;
            this.f21572d = arguments.getInt("request_code");
        }
        C();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.b(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_permission_rationable, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        z();
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        b bVar = this.j;
        if (bVar != null) {
            bVar.a(this.f21576h);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        h.b(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        h.b(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == this.f21572d) {
            if (com.nexstreaming.kinemaster.ui.e.b.a(getActivity(), strArr, iArr)) {
                this.f21576h = -1;
                A();
            } else {
                B();
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
        }
        String[] strArr = this.f21571c;
        if (strArr == null) {
            h.b(NativeProtocol.RESULT_ARGS_PERMISSIONS);
            throw null;
        }
        if (com.nexstreaming.kinemaster.ui.e.b.a((Context) activity, strArr)) {
            this.f21576h = -1;
            A();
        } else {
            B();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        h.b(view, "view");
        super.onViewCreated(view, bundle);
        a(view);
    }

    public void z() {
        HashMap hashMap = this.k;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    private final void a(View view) {
        view.getParent().requestDisallowInterceptTouchEvent(true);
        ((TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonAllow)).setOnClickListener(new d(this));
        ((TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonAppInfo)).setOnClickListener(new e(this));
        ((TransparentTextButton) m(com.nexstreaming.app.kinemasterfree.b.permission_buttonCancel)).setOnClickListener(new f(this));
    }

    public final void a(AppCompatActivity appCompatActivity, b bVar) {
        h.b(appCompatActivity, "activity");
        h.b(bVar, "listener");
        a(appCompatActivity, bVar, false);
    }

    public final void a(AppCompatActivity appCompatActivity, b bVar, boolean z) {
        h.b(appCompatActivity, "activity");
        h.b(bVar, "listener");
        this.j = bVar;
        FragmentTransaction replace = appCompatActivity.getSupportFragmentManager().beginTransaction().replace(android.R.id.content, this, f21569a);
        this.i = z;
        if (z) {
            replace.addToBackStack(f21569a);
        }
        replace.commitAllowingStateLoss();
    }
}
