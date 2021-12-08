package com.mer.plamer;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.mer.plamer.controller.PlaylistControl;
import com.mer.plamer.controller.TrackAdapter;
import com.mer.plamer.controller.UserAdapter;
import com.mer.plamer.entities.User;
import com.mer.plamer.entities.UserLibrary;
import com.mer.plamer.usecases.TrackLibraryAction;
import com.mer.plamer.usecases.UserLibraryAction;

import java.util.ArrayList;

public class UniverseUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universe_user_layout);

        // back to the last page
        ImageButton back = findViewById(R.id.universe_user_back_last_page);
        back.setOnClickListener(v -> finish());

        // set adapter
        ArrayList<String> nameList = UserLibraryAction.getAllUserName();
        ListView UserListView;
        UserListView = findViewById(R.id.universe_user_list);
        UserAdapter adapter = new UserAdapter(UniverseUserActivity.this, nameList);
        UserListView.setAdapter(adapter);

        // delete user
        AdapterView.OnItemLongClickListener deleteUser = new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(UniverseUserActivity.this);
                builder.setMessage("Do you want to delete this user?");
                String name = nameList.get(position);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Change here!!!
                        nameList.remove(position);
                        // ↑
                        adapter.notifyDataSetChanged();
                        Toast.makeText(UniverseUserActivity.this,
                                "You have deleted a playlist.", Toast.LENGTH_LONG).show();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();

                return true;
            }
        };

        UserListView.setOnItemLongClickListener(deleteUser);
    }
}