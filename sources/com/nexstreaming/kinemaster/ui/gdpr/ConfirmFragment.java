package com.nexstreaming.kinemaster.ui.gdpr;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;

/* loaded from: classes.dex */
public class ConfirmFragment extends DialogFragment {

    /* renamed from: a */
    private String f21586a = "";

    /* renamed from: b */
    private a f21587b = null;

    /* loaded from: classes.dex */
    public enum BUTTON {
        OK,
        CANCEL
    }

    /* loaded from: classes.dex */
    public interface a {
        void a(BUTTON button);
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        a aVar = this.f21587b;
        if (aVar != null) {
            aVar.a(BUTTON.CANCEL);
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f21586a = arguments.getString(NotificationCompat.CATEGORY_MESSAGE, "");
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_confirm, (ViewGroup) null);
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ((TextView) inflate.findViewById(R.id.text)).setText(this.f21586a);
        Button button = (Button) inflate.findViewById(R.id.ok_button);
        Button button2 = (Button) inflate.findViewById(R.id.cancel_button);
        com.nexstreaming.kinemaster.ui.gdpr.a aVar = new com.nexstreaming.kinemaster.ui.gdpr.a(this);
        button.setOnClickListener(aVar);
        button2.setOnClickListener(aVar);
        Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(1);
        dialog.setContentView(inflate);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().setLayout(-1, -1);
        return dialog;
    }

    public static ConfirmFragment a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(NotificationCompat.CATEGORY_MESSAGE, str);
        ConfirmFragment confirmFragment = new ConfirmFragment();
        confirmFragment.setArguments(bundle);
        return confirmFragment;
    }

    public void a(a aVar) {
        this.f21587b = aVar;
    }
}
