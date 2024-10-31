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

/* loaded from: classes.dex */
public class NexSwitchPreference extends SwitchPreference {

    /* renamed from: a, reason: collision with root package name */
    private final a f3180a;

    public NexSwitchPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3180a = new a(this, null);
        a();
    }

    public NexSwitchPreference(Context context) {
        super(context);
        this.f3180a = new a(this, null);
        a();
    }

    public NexSwitchPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3180a = new a(this, null);
        a();
    }

    private void a() {
        setLayoutResource(R.layout.layout_preference_list_item_switch);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        private a() {
        }

        /* synthetic */ a(NexSwitchPreference nexSwitchPreference, com.nexstreaming.app.general.preferences.a aVar) {
            this();
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!NexSwitchPreference.this.callChangeListener(Boolean.valueOf(z))) {
                compoundButton.setChecked(!z);
            } else {
                NexSwitchPreference.this.setChecked(z);
            }
        }
    }

    @Override // android.preference.SwitchPreference, android.preference.Preference
    protected void onBindView(View view) {
        KeyEvent.Callback findViewById;
        if (view != null && (findViewById = view.findViewById(R.id.switchWidget)) != null && (findViewById instanceof Checkable)) {
            if (findViewById instanceof SwitchCompat) {
                ((SwitchCompat) findViewById).setOnCheckedChangeListener(null);
            }
            ((Checkable) findViewById).setChecked(isChecked());
            if (findViewById instanceof SwitchCompat) {
                SwitchCompat switchCompat = (SwitchCompat) findViewById;
                switchCompat.setTextOn(getSwitchTextOn());
                switchCompat.setTextOff(getSwitchTextOff());
                switchCompat.setOnCheckedChangeListener(this.f3180a);
                view.setOnClickListener(new com.nexstreaming.app.general.preferences.a(this, switchCompat));
            }
        }
        super.onBindView(view);
    }
}
