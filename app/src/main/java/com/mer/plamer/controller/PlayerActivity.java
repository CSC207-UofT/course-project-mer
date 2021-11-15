package com.mer.plamer.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.mer.plamer.R;
import com.mer.plamer.usecases.PlayAction;

/**
 * Activity and view of the music player UI.
 */
public class PlayerActivity extends AppCompatActivity {
    Button mPlayPauseButton;
    Button mPreviousButton;
    Button mNextButton;
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
        setContentView(R.layout.activity_player);
        initializeViews();
        defineActions();
    }

    @SuppressLint("SetTextI18n")
    private void initializeViews(){
        mPlayPauseButton = findViewById(R.id.playPauseButtonFull);
        mPreviousButton = findViewById(R.id.previousButtonFull);
        mNextButton = findViewById(R.id.nextButtonFull);
        mSeekBar = findViewById(R.id.seekBarFull);
        mSeekBar.setMax(PlayAction.getTrackLength()/1000);
        mCurrentTrackName = findViewById(R.id.currentTrackNameFull);
        mCurrentTrackArtist = findViewById(R.id.currentTrackArtistFull);
        mCurrentTrackPosition = findViewById(R.id.currentTrackPositionFull);
        mCurrentTrackDuration = findViewById(R.id.currentTrackDuractionFull);
        mSeekBarHandler = new Handler();
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
        mPlayPauseButton.setOnClickListener(v -> {
            PlayAction.playPause();
        });

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