package kushagra.digipodium.menus_01;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ShareCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    private TextView textNote1;

    private TextView textNote2;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textNote1 = view.findViewById(R.id.textNote1);
        ImageView imgMenu = view.findViewById(R.id.imgMenu);
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context;
                PopupMenu pop = new PopupMenu(getActivity(), v);
                pop.getMenuInflater().inflate(R.menu.menu_notes_popup, pop.getMenu());
                pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.note_pop_copy:
                                 String data = textNote1.getText().toString();
                                ClipboardManager manager = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                                ClipData clipData = ClipData.newPlainText("note1", data);
                                manager.setPrimaryClip(clipData);
                                Toast.makeText(getActivity(), "Copied to clipboard", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.note_pop_edit:
                                break;
                            case R.id.note_pop_share:
                                String notes = textNote1.getText().toString();
                                Intent intent = ShareCompat.IntentBuilder.from(getActivity()).setSubject("note 1").setText(notes).createChooserIntent();
                                startActivity(intent);
                                break;

                        }
                        return true;
                    }
                });
                pop.show();
            }

        });
        textNote2 = view.findViewById(R.id.textNote2);
        ImageView imgMenu1 = view.findViewById(R.id.imgMenu1);
        imgMenu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context;
                PopupMenu pop = new PopupMenu(getActivity(), v);
                pop.getMenuInflater().inflate(R.menu.menu_notes_popup, pop.getMenu());
                pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.note_pop_copy:
                                String data = textNote1.getText().toString();
                                ClipboardManager manager = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                                ClipData clipData = ClipData.newPlainText("note1", data);
                                manager.setPrimaryClip(clipData);
                                Toast.makeText(getActivity(), "Copied to clipboard", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.note_pop_edit:
                                break;
                            case R.id.note_pop_share:
                                String notes = textNote1.getText().toString();
                                Intent intent = ShareCompat.IntentBuilder.from(getActivity()).setSubject("note 1").setText(notes).createChooserIntent();
                                startActivity(intent);
                                break;

                        }
                        return true;
                    }
                });
                pop.show();
            }

        });
    }
}


