package com.nexstreaming.kinemaster.ui.settings;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.settings.Ua;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.ExpiredActivity;
import java.util.Date;

/* compiled from: KineInfoFragment.java */
/* loaded from: classes2.dex */
public class U extends Fragment {

    /* renamed from: a */
    private View f23082a;

    /* renamed from: b */
    private Ua.a f23083b;

    public static String b(Context context) {
        String a2 = a(context);
        if (EditorGlobal.f24026e != EditorGlobal.VersionType.Release && EditorGlobal.f24026e != EditorGlobal.VersionType.RC) {
            a2 = a2 + " " + EditorGlobal.f24026e;
        }
        if (!EditorGlobal.t()) {
            return a2;
        }
        return a2 + " DFO";
    }

    private String c() {
        Date s = ExpiredActivity.s();
        if (s == null) {
            return "";
        }
        return "(expires " + s.toString() + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f23083b = (Ua.a) activity;
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString() + " must implement OnSettingFragmentListener");
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getArguments();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f23082a = layoutInflater.inflate(R.layout.fragment_kine_info, viewGroup, false);
        TextView textView = (TextView) this.f23082a.findViewById(R.id.textView_setting_app_version);
        TextView textView2 = (TextView) this.f23082a.findViewById(R.id.textView_setting_engine_version);
        TextView textView3 = (TextView) this.f23082a.findViewById(R.id.textView_setting_expires);
        TextView textView4 = (TextView) this.f23082a.findViewById(R.id.textView_setting_license_infomation);
        TextView textView5 = (TextView) this.f23082a.findViewById(R.id.textView_setting_privacy_info);
        TextView textView6 = (TextView) this.f23082a.findViewById(R.id.textView_setting_terms);
        if (EditorGlobal.f24026e != EditorGlobal.VersionType.Release && EditorGlobal.f24026e != EditorGlobal.VersionType.RC) {
            if (EditorGlobal.t()) {
                textView.setText("* * * " + a(getActivity()) + " " + EditorGlobal.f24026e + " (Demo Files Only) * * *");
            } else {
                textView.setText("* * * " + a(getActivity()) + " " + EditorGlobal.f24026e + " * * *");
            }
            textView.setTextColor(getResources().getColor(R.color.km_salmon));
        } else {
            textView.setText(a(getActivity()));
        }
        textView2.setText(b());
        textView3.setText(c());
        textView4.setOnClickListener(new Q(this));
        textView5.setOnClickListener(new S(this));
        textView6.setOnClickListener(new T(this));
        if (Resources.getSystem().getConfiguration().locale.toString().startsWith("zh")) {
            ImageView imageView = (ImageView) this.f23082a.findViewById(R.id.imageView);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = getResources().getDimensionPixelOffset(R.dimen.frag_kine_info_logo_width_cn);
            layoutParams.height = getResources().getDimensionPixelOffset(R.dimen.frag_kine_info_logo_height_cn);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.settings_logo_cn));
        }
        return this.f23082a;
    }

    public static U a() {
        U u = new U();
        u.setArguments(new Bundle());
        return u;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.f23083b = (Ua.a) context;
        } catch (ClassCastException unused) {
            throw new ClassCastException(context.toString() + " must implement OnSettingFragmentListener");
        }
    }

    public static String a(Context context) {
        String str;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str = "?";
        }
        return str.endsWith(".FREE") ? str.substring(0, str.length() - 5) : str;
    }

    private String b() {
        return EditorGlobal.e();
    }
}
