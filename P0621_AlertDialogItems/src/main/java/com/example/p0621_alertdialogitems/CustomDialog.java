package com.example.p0621_alertdialogitems;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

public class CustomDialog extends DialogFragment {
    String tag;
    final String LOG_TAG = "myLogs";
    Dialog dialog;

    @Override
    public void show(@NonNull FragmentManager manager, @Nullable String tag) {
        super.show(manager, tag);
        this.tag = tag;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "Create");
        final String[] catNamesArray = {"Васька", "Рыжик", "Мурзик"};
        final String[] dogNamesArray = {"Рики", "Шарик", "Хатико"};
        AlertDialog.Builder builder;



        switch (tag) {
            case "dialog":
                builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Выберите кота")
                        .setItems(catNamesArray, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getActivity(),
                                        "Выбранный кот: " + catNamesArray[which],
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                break;
            case "dialog2":
                builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Выберите собакена")
                        .setMultiChoiceItems(dogNamesArray, null, new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i,
                                                        boolean b) {
                                        Toast.makeText(getActivity(),
                                                "Выбранный собакен: " + dogNamesArray[i],
                                                Toast.LENGTH_SHORT).show();
                                    }
                        });
                break;
            case "dialog3":
                builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Выберите собакена")
                        .setSingleChoiceItems(dogNamesArray, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(),
                                        "Выбранный собакен: " + dogNamesArray[i],
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                break;
            case "dialog4":
                builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Напишите своё имя и email и ещё что то напишите пожожда напишите так надо")
                        .setView(R.layout.my_dialog);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + tag);
        }
        dialog = builder.create();

        // обработчик отображения
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            public void onShow(DialogInterface dialog) {
                Log.d(LOG_TAG, "Show");
            }
        });

        // обработчик отмены
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                Log.d(LOG_TAG, "Cancel");
            }
        });

        // обработчик закрытия
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialog) {
                Log.d(LOG_TAG, "Dismiss");
            }
        });
        return dialog;
    }

}
