package com.nexstreaming.kinemaster.ui.share;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: ShareEventFragment.java */
/* loaded from: classes2.dex */
public class qa extends Fragment {

    /* renamed from: a */
    private TextView f23376a = null;

    /* renamed from: b */
    private Button f23377b = null;

    /* renamed from: c */
    private TextView f23378c = null;

    /* renamed from: d */
    private a f23379d = null;

    /* compiled from: ShareEventFragment.java */
    /* loaded from: classes2.dex */
    public interface a {
        void o();

        void q();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() == null || !(getActivity() instanceof a)) {
            return;
        }
        this.f23379d = (a) getActivity();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(qa.class.getName());
        return a(layoutInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    private View a(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_event, (ViewGroup) null);
        this.f23376a = (TextView) inflate.findViewById(R.id.tv_fragment_share_event_later);
        this.f23377b = (Button) inflate.findViewById(R.id.btn_fragment_share_event_share);
        this.f23378c = (TextView) inflate.findViewById(R.id.tv_fragment_share_event_message);
        this.f23378c.setText(Html.fromHtml(getString(R.string.wechat_share_event_message_html)));
        this.f23376a.setOnClickListener(new oa(this));
        this.f23377b.setOnClickListener(new pa(this));
        inflate.setOnClickListener(null);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getActivity() == null || !(getActivity() instanceof a)) {
            return;
        }
        this.f23379d = (a) getActivity();
    }
}
