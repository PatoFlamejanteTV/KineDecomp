package com.nextreaming.nexeditorui.newproject.a;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nexstreaming.kinemaster.usage.analytics.b;
import java.util.ArrayList;

/* compiled from: InputTextFragment.java */
/* loaded from: classes3.dex */
public class a extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private View f24325a;

    /* renamed from: b, reason: collision with root package name */
    private Toolbar f24326b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f24327c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f24328d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f24329e;

    /* renamed from: f, reason: collision with root package name */
    private int f24330f;

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<String> f24331g;

    /* renamed from: h, reason: collision with root package name */
    private InterfaceC0118a f24332h;

    /* compiled from: InputTextFragment.java */
    /* renamed from: com.nextreaming.nexeditorui.newproject.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0118a {
        void b(ArrayList<String> arrayList);
    }

    public static a a(int i, ArrayList<String> arrayList) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putInt("TITLE_COUNT", i);
        bundle.putStringArrayList("TITLE_STRINGS", arrayList);
        aVar.setArguments(bundle);
        return aVar;
    }

    private void b(ArrayList<String> arrayList) {
        TextView textView;
        int i = 0;
        while (i < 3) {
            String str = null;
            if (i == 0) {
                textView = this.f24327c;
            } else if (i != 1) {
                textView = i != 2 ? null : this.f24328d;
            } else {
                textView = this.f24329e;
            }
            if (textView != null) {
                if (arrayList != null && i < arrayList.size()) {
                    str = arrayList.get(i);
                }
                if (str == null) {
                    str = "";
                }
                textView.setText(str);
                textView.setVisibility(i < this.f24330f ? 0 : 8);
            }
            i++;
        }
    }

    private ArrayList<String> z() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < this.f24330f; i++) {
            String str = null;
            if (i == 0) {
                str = this.f24327c.getText().toString();
            } else if (i == 1) {
                str = this.f24329e.getText().toString();
            } else if (i == 2) {
                str = this.f24328d.getText().toString();
            }
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f24326b.setLogo(R.drawable.icon_input_text_title_logo);
        this.f24326b.setTitle(getResources().getString(R.string.new_project_toolbar_title_text_input));
        b(this.f24331g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f24332h = (InterfaceC0118a) activity;
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString() + " must implement OnMediaBrowserFragmentListener");
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f24330f = getArguments().getInt("TITLE_COUNT", 1);
            this.f24331g = getArguments().getStringArrayList("TITLE_STRINGS");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        b.a(a.class.getName());
        this.f24325a = layoutInflater.inflate(R.layout.fragment_intput_text, viewGroup, false);
        this.f24326b = (Toolbar) this.f24325a.findViewById(R.id.toolbar_text_input);
        this.f24327c = (TextView) this.f24325a.findViewById(R.id.editText_new_project_opening);
        this.f24328d = (TextView) this.f24325a.findViewById(R.id.editText_new_project_middle);
        this.f24329e = (TextView) this.f24325a.findViewById(R.id.editText_new_project_ending);
        return this.f24325a;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        a(z());
        super.onDetach();
        this.f24332h = null;
    }

    public void a(ArrayList<String> arrayList) {
        InterfaceC0118a interfaceC0118a = this.f24332h;
        if (interfaceC0118a != null) {
            interfaceC0118a.b(arrayList);
        }
    }
}
