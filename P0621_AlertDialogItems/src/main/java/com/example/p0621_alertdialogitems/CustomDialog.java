package com.example.p0621_alertdialogitems;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

public class CustomDialog extends DialogFragment {
    String tag;

    @Override
    public void show(@NonNull FragmentManager manager, @Nullable String tag) {
        super.show(manager, tag);
        this.tag = tag;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
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
                        .setItems(dogNamesArray, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getActivity(),
                                        "Выбранный собакен: " + dogNamesArray[which],
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + tag);
        }
        return builder.create();
    }

}
