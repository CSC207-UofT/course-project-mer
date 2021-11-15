package com.mer.plamer.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.mer.plamer.R;
import com.mer.plamer.usecases.PlayAction;

/**
 * Activity and view of the music player UI.
 */
public class PlayerActivity extends AppCompatActivity {
    ImageButton mPlayPauseButton;
    ImageButton mPreviousButton;
    ImageButton mNextButton;
    ImageButton mBackButton;
    ImageButton mLoopButton;
    SeekBar mSeekBar;
    TextView mCurrentTrackName;
    TextView mCurrentTrackArtist;
    TextView mCurrentTrackPosition;
    TextView mCurrentTrackDuration;
    private Handler mSeekBarHandler;
    private Runnable updateSeekBarPosition;

    /**
     * Constructs view and defines actions of the music player UI.
     * @param savedInstanceState the previously saved state of this activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_layout);
        initializeViews();
        defineActions();
    }

    @SuppressLint("SetTextI18n")
    private void initializeViews(){
        mPlayPauseButton = findViewById(R.id.playlist_play);
        mPreviousButton = findViewById(R.id.playlist_prev);
        mNextButton = findViewById(R.id.playlist_next);
        mBackButton = findViewById(R.id.player_back_last_page);
        mSeekBar = findViewById(R.id.seekBar);
        mLoopButton = findViewById(R.id.playlist_repeat_list);
        mCurrentTrackName = findViewById(R.id.track_name);
        mCurrentTrackArtist = findViewById(R.id.artist_name);
        mCurrentTrackPosition = findViewById(R.id.current_time);
        mCurrentTrackDuration = findViewById(R.id.total_length);
        mSeekBarHandler = new Handler();
        mSeekBar.setMax(PlayAction.getTrackLength()/1000);
        mCurrentTrackName.setText(PlayAction.getTitle());
        mCurrentTrackArtist.setText(PlayAction.getArtist());
        int duration = PlayAction.getTrackLength();
        mCurrentTrackDuration.setText((duration / 1000) / 60 +":"+ (duration / 1000) % 60);
        updateSeekBarPosition = () -> {
            int currentPosition = PlayAction.getCurrentPosition()/1000;
            mSeekBar.setProgress(currentPosition);
            mCurrentTrackPosition.setText(currentPosition / 60+":"+currentPosition % 60);
            mSeekBarHandler.postDelayed(updateSeekBarPosition, 1000);
        };
        this.runOnUiThread(updateSeekBarPosition);
    }

    private void defineActions(){
        mPlayPauseButton.setOnClickListener(v -> PlayAction.playPause());

        mBackButton.setOnClickListener(v -> finish());

        mLoopButton.setOnClickListener(v -> PlayAction.loop());
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    PlayAction.setPosition(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}