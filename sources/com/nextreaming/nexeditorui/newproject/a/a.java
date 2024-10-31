package com.nextreaming.nexeditorui.newproject.a;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import java.util.ArrayList;

/* compiled from: InputTextFragment.java */
/* loaded from: classes.dex */
public class a extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private View f4660a;
    private Toolbar b;
    private TextView c;
    private TextView d;
    private TextView e;
    private int f;
    private ArrayList<String> g;
    private InterfaceC0084a h;

    /* compiled from: InputTextFragment.java */
    /* renamed from: com.nextreaming.nexeditorui.newproject.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0084a {
        void a(ArrayList<String> arrayList);
    }

    public static a a(int i, ArrayList<String> arrayList) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putInt("TITLE_COUNT", i);
        bundle.putStringArrayList("TITLE_STRINGS", arrayList);
        aVar.setArguments(bundle);
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.h = (InterfaceC0084a) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnMediaBrowserFragmentListener");
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f = getArguments().getInt("TITLE_COUNT", 1);
            this.g = getArguments().getStringArrayList("TITLE_STRINGS");
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f4660a = layoutInflater.inflate(R.layout.fragment_intput_text, viewGroup, false);
        this.b = (Toolbar) this.f4660a.findViewById(R.id.toolbar_text_input);
        this.c = (TextView) this.f4660a.findViewById(R.id.editText_new_project_opening);
        this.d = (TextView) this.f4660a.findViewById(R.id.editText_new_project_middle);
        this.e = (TextView) this.f4660a.findViewById(R.id.editText_new_project_ending);
        return this.f4660a;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.b.setLogo(R.drawable.icon_input_text_title_logo);
        this.b.setTitle(getResources().getString(R.string.new_project_toolbar_title_text_input));
        b(this.g);
    }

    public void a(ArrayList<String> arrayList) {
        if (this.h != null) {
            this.h.a(arrayList);
        }
    }

    @Override // android.app.Fragment
    public void onDetach() {
        a(a());
        super.onDetach();
        this.h = null;
    }

    private ArrayList<String> a() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < this.f; i++) {
            String str = null;
            switch (i) {
                case 0:
                    str = this.c.getText().toString();
                    break;
                case 1:
                    str = this.e.getText().toString();
                    break;
                case 2:
                    str = this.d.getText().toString();
                    break;
            }
            arrayList.add(str);
        }
        return arrayList;
    }

    private void b(ArrayList<String> arrayList) {
        TextView textView;
        int i = 0;
        while (i < 3) {
            switch (i) {
                case 0:
                    textView = this.c;
                    break;
                case 1:
                    textView = this.e;
                    break;
                case 2:
                    textView = this.d;
                    break;
                default:
                    textView = null;
                    break;
            }
            if (textView != null) {
                String str = (arrayList == null || i >= arrayList.size()) ? null : arrayList.get(i);
                if (str == null) {
                    str = "";
                }
                textView.setText(str);
                textView.setVisibility(i < this.f ? 0 : 8);
            }
            i++;
        }
    }
}
