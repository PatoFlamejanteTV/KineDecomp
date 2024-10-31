package com.nexstreaming.app.general.preferences;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.TransparentTextButton;

/* loaded from: classes2.dex */
public class NexButtonPreference extends Preference {
    public NexButtonPreference(Context context) {
        super(context);
        a();
    }

    private void a() {
        setLayoutResource(R.layout.layout_preference_list_item_button);
    }

    @Override // android.preference.Preference
    protected void onBindView(View view) {
        if (view != null) {
            TransparentTextButton transparentTextButton = (TransparentTextButton) view.findViewById(R.id.buttonWidget);
            if (transparentTextButton != null) {
                transparentTextButton.setOnClickListener(new a(this));
            }
            view.setOnClickListener(new b(this));
        }
        super.onBindView(view);
    }

    public NexButtonPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public NexButtonPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
