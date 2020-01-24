package com.example.roarman.pushmanager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import com.unity3d.player.UnityPlayer;

public class PushController {

    private static PushController instance;

    public static PushController Instance() {
        if (instance == null)
            instance = new PushController();

        return instance;
    }


    private void ShowToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    private void ShowDialog(final Context context, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                UnityPlayer.UnitySendMessage("NativeBridge", "ResponseDialog", "Yes");
            }
        });

        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                UnityPlayer.UnitySendMessage("NativeBridge", "ResponseDialog", "No");
            }
        });

        builder.show();
    }
}
