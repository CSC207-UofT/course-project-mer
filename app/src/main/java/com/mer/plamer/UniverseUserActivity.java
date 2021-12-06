package com.mer.plamer;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.mer.plamer.controller.TrackAdapter;
import com.mer.plamer.controller.UserAdapter;
import com.mer.plamer.entities.User;
import com.mer.plamer.entities.UserLibrary;
import com.mer.plamer.usecases.TrackLibraryAction;

import java.util.ArrayList;

public class UniverseUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universe_user_layout);

        // back to the last page
        ImageButton back = findViewById(R.id.universe_user_back_last_page);
        back.setOnClickListener(v -> finish());

        ArrayList<User> user_list = new ArrayList<>();
        ListView UserListView;
        UserListView = findViewById(R.id.universe_user_list);
        UserListView.setAdapter(new UserAdapter(getApplicationContext(), user_list));
    }
}