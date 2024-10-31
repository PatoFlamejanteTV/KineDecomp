package com.nexstreaming.kinemaster.ui.share;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: ShareEventFragment.java */
/* loaded from: classes.dex */
public class aq extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private TextView f4301a = null;
    private Button b = null;
    private TextView c = null;
    private a d = null;

    /* compiled from: ShareEventFragment.java */
    /* loaded from: classes.dex */
    public interface a {
        void c();

        void d();
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() != null && (getActivity() instanceof a)) {
            this.d = (a) getActivity();
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getActivity() != null && (getActivity() instanceof a)) {
            this.d = (a) getActivity();
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return a(layoutInflater);
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    private View a(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_event, (ViewGroup) null);
        this.f4301a = (TextView) inflate.findViewById(R.id.tv_fragment_share_event_later);
        this.b = (Button) inflate.findViewById(R.id.btn_fragment_share_event_share);
        this.c = (TextView) inflate.findViewById(R.id.tv_fragment_share_event_message);
        this.c.setText(Html.fromHtml(getString(R.string.wechat_share_event_message_html)));
        this.f4301a.setOnClickListener(new ar(this));
        this.b.setOnClickListener(new as(this));
        inflate.setOnClickListener(null);
        return inflate;
    }
}
