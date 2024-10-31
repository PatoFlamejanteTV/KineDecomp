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
import com.nexstreaming.kinemaster.ui.settings.x;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.ExpiredActivity;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.util.Date;

/* compiled from: KineInfoFragment.java */
/* loaded from: classes.dex */
public class r extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private View f4268a;
    private x.a b;

    public static r a() {
        r rVar = new r();
        rVar.setArguments(new Bundle());
        return rVar;
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f4268a = layoutInflater.inflate(R.layout.fragment_kine_info, viewGroup, false);
        TextView textView = (TextView) this.f4268a.findViewById(R.id.textView_setting_app_version);
        TextView textView2 = (TextView) this.f4268a.findViewById(R.id.textView_setting_engine_version);
        TextView textView3 = (TextView) this.f4268a.findViewById(R.id.textView_setting_expires);
        TextView textView4 = (TextView) this.f4268a.findViewById(R.id.textView_setting_license_infomation);
        TextView textView5 = (TextView) this.f4268a.findViewById(R.id.textView_setting_privacy_info);
        if (EditorGlobal.f != EditorGlobal.VersionType.Release && EditorGlobal.f != EditorGlobal.VersionType.RC) {
            textView.setText("* * * " + b() + " " + EditorGlobal.f + " * * *");
            textView.setTextColor(getResources().getColor(R.color.km_salmon));
        } else {
            textView.setText(b());
        }
        textView2.setText(c());
        textView3.setText(d());
        textView4.setOnClickListener(new s(this));
        textView5.setOnClickListener(new t(this));
        if (Resources.getSystem().getConfiguration().locale.toString().startsWith("zh")) {
            ((ImageView) this.f4268a.findViewById(R.id.imageView)).setImageDrawable(getResources().getDrawable(R.drawable.settings_logo_cn));
        }
        return this.f4268a;
    }

    private String b() {
        try {
            return getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "?";
        }
    }

    private String c() {
        NexEditor a2 = EditorGlobal.a();
        return "(engine " + a2.getVersionNumber(1) + "." + a2.getVersionNumber(2) + "." + a2.getVersionNumber(3) + "." + a2.getVersionNumber(4) + ")";
    }

    private String d() {
        Date a2 = ExpiredActivity.a();
        return a2 == null ? "" : "(expires " + a2.toString() + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.b = (x.a) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnSettingFragmentListener");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.b = (x.a) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnSettingFragmentListener");
        }
    }
}
