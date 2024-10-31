package com.nexstreaming.app.general.preferences;

import android.content.Context;
import android.preference.SwitchPreference;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.CompoundButton;
import com.nexstreaming.app.kinemasterfree.R;

/* loaded from: classes2.dex */
public class NexSwitchPreference extends SwitchPreference {

    /* renamed from: a */
    private final a f19660a;

    /* loaded from: classes2.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        private a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!NexSwitchPreference.this.callChangeListener(Boolean.valueOf(z))) {
                compoundButton.setChecked(!z);
            } else {
                NexSwitchPreference.this.setChecked(z);
            }
        }

        /* synthetic */ a(NexSwitchPreference nexSwitchPreference, c cVar) {
            this();
        }
    }

    public NexSwitchPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19660a = new a(this, null);
        a();
    }

    @Override // android.preference.SwitchPreference, android.preference.Preference
    protected void onBindView(View view) {
        KeyEvent.Callback findViewById;
        if (view != null && (findViewById = view.findViewById(R.id.switchWidget)) != null && (findViewById instanceof Checkable)) {
            boolean z = findViewById instanceof SwitchCompat;
            if (z) {
                ((SwitchCompat) findViewById).setOnCheckedChangeListener(null);
            }
            ((Checkable) findViewById).setChecked(isChecked());
            if (z) {
                SwitchCompat switchCompat = (SwitchCompat) findViewById;
                switchCompat.setTextOn(getSwitchTextOn());
                switchCompat.setTextOff(getSwitchTextOff());
                switchCompat.setOnCheckedChangeListener(this.f19660a);
                view.setOnClickListener(new c(this, switchCompat));
                view.setOnKeyListener(new d(this, switchCompat));
            }
        }
        super.onBindView(view);
    }

    private void a() {
        setLayoutResource(R.layout.layout_preference_list_item_switch);
    }

    public NexSwitchPreference(Context context) {
        super(context);
        this.f19660a = new a(this, null);
        a();
    }

    public NexSwitchPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19660a = new a(this, null);
        a();
    }
}
