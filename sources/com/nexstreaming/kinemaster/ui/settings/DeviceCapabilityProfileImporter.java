package com.nexstreaming.kinemaster.ui.settings;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.codeccaps.CapabilityReport;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nextreaming.nexeditorui.AbstractActivityC2299ba;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class DeviceCapabilityProfileImporter extends AbstractActivityC2299ba<com.nexstreaming.app.kinemasterfree.a.k> {
    private static final String TAG = "DeviceCapabilityProfileImporter";
    private b I;
    private b J;

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a */
        int f23030a;

        /* renamed from: b */
        String f23031b;

        public a(int i, String str) {
            this.f23030a = i;
            this.f23031b = str;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends RecyclerView.Adapter<C2203y<?>> {

        /* renamed from: c */
        private final List<a> f23033c = new ArrayList();

        /* loaded from: classes2.dex */
        public abstract class a<T> implements View.OnClickListener {

            /* renamed from: a */
            T f23035a;

            public a(T t) {
                this.f23035a = t;
            }

            public abstract void a(View view, T t);

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a(view, this.f23035a);
            }
        }

        b() {
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(C2203y<?> c2203y, int i) {
            a item = getItem(i);
            if (item.f23030a == 0) {
                com.nexstreaming.app.kinemasterfree.a.q qVar = (com.nexstreaming.app.kinemasterfree.a.q) c2203y.t();
                qVar.a(item.f23031b);
                qVar.a((View.OnClickListener) new N(this, item));
                qVar.d();
                return;
            }
            com.nexstreaming.app.kinemasterfree.a.s sVar = (com.nexstreaming.app.kinemasterfree.a.s) c2203y.t();
            File file = new File(item.f23031b);
            sVar.a(file.getName());
            sVar.b(file.getParentFile().getAbsolutePath());
            sVar.a((View.OnClickListener) new O(this, item));
            sVar.d();
        }

        public void f() {
            this.f23033c.clear();
        }

        public b g() {
            Collections.sort(this.f23033c, new P(this));
            return this;
        }

        public a getItem(int i) {
            return this.f23033c.get(i);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f23033c.size();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return this.f23033c.get(i).f23030a;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public C2203y<?> onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                return new C2203y<>(com.nexstreaming.app.kinemasterfree.a.q.a(DeviceCapabilityProfileImporter.this.getLayoutInflater(), viewGroup, false));
            }
            return new C2203y<>(com.nexstreaming.app.kinemasterfree.a.s.a(DeviceCapabilityProfileImporter.this.getLayoutInflater(), viewGroup, false));
        }

        public void a(a aVar) {
            this.f23033c.add(aVar);
        }
    }

    public void K() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        try {
            startActivityForResult(intent, 1000);
        } catch (ActivityNotFoundException unused) {
        }
    }

    private void L() {
        new J(this).execute(new Void[0]);
    }

    public void M() {
        getFragmentManager().beginTransaction().replace(R.id.container, G.a()).addToBackStack(null).commit();
        H().C.setTitleMode(Toolbar.TitleMode.Back);
        H().C.setTitle(getString(R.string.pref_information_device_capability));
    }

    @Override // com.nextreaming.nexeditorui.AbstractActivityC2299ba
    protected int G() {
        return R.layout.device_capability_profile_importer;
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Uri data;
        if (i != 1000) {
            super.onActivityResult(i, i2, intent);
        } else {
            if (i2 != -1 || (data = intent.getData()) == null) {
                return;
            }
            a(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.AbstractActivityC2299ba, com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(getLocalClassName());
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(ViewCompat.MEASURED_STATE_MASK);
        }
        getFragmentManager().addOnBackStackChangedListener(new H(this));
        H().C.setClickListener(new I(this));
        H().C.setRightButton(R.drawable.audio_cat_folder);
        this.I = new b();
        H().z.setAdapter(this.I);
        ViewCompat.setNestedScrollingEnabled(H().z, false);
        this.J = new b();
        H().A.setAdapter(this.J);
        ViewCompat.setNestedScrollingEnabled(H().A, false);
        L();
    }

    public void c(String str) {
        new L(this).execute(str);
    }

    public static Intent c(Context context) {
        return new Intent(context, (Class<?>) DeviceCapabilityProfileImporter.class);
    }

    public void a(CapabilityReport.CapabilityInfo capabilityInfo) {
        if (capabilityInfo == null) {
            return;
        }
        new AlertDialog.Builder(this).setMessage("Do you want to apply this profile to KineMaster?").setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).setPositiveButton(android.R.string.ok, new K(this, capabilityInfo)).create().show();
    }

    public void a(Uri uri) {
        new M(this).execute(uri);
    }
}
