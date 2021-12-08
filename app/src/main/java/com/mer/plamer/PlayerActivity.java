package com.mer.plamer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mer.plamer.controller.PlayControl;

import com.mer.plamer.databinding.PlayerLayoutBinding;
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
    private final int DELAY = 1000;

    /**
     * Constructs view and defines actions of the music player UI.
     * @param savedInstanceState the previously saved state of this activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeViews();
        defineActions();
    }

    private void initializeViews(){
        setContentView(R.layout.player_layout);
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
        updateSeekBarPosition = () -> {
            metadataUpdate();
            mSeekBarHandler = new Handler();
            int currentPosition = PlayAction.getCurrentPosition();
            mSeekBar.setProgress(PlayControl.toSeconds(currentPosition));
            mCurrentTrackPosition.setText(PlayControl.toMinuteSeconds(currentPosition));
            mSeekBarHandler.postDelayed(updateSeekBarPosition, DELAY);
        };
        this.runOnUiThread(updateSeekBarPosition);
    }

    private void defineActions(){
        mPlayPauseButton.setOnClickListener(v -> {
            PlayControl.playPause();
            if (PlayAction.isPlaying()) {
                ((ImageButton)v).setImageResource(R.drawable.pause);
            } else{
                ((ImageButton) v).setImageResource(R.drawable.play);
            }
        });

        mBackButton.setOnClickListener(v -> finish());

        mLoopButton.setOnClickListener(v -> {
//            if (check status == List){
//                ((ImageButton)v).setImageResource(R.drawable.repeat_one);
//            }else if(check status == repeat 1){
//                ((ImageButton)v).setImageResource(R.drawable.random);
//            }else{
//                ((ImageButton)v).setImageResource(R.drawable.repeat_list);
//            }
            Toast.makeText(PlayerActivity.this,
                    PlayControl.changePlayMode(), Toast.LENGTH_SHORT).show();
        });

        mNextButton.setOnClickListener(v -> {
            PlayControl.next();
            metadataUpdate();
        });

        mPreviousButton.setOnClickListener(v -> {
            PlayControl.prev();
            metadataUpdate();
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

    private void metadataUpdate(){
        mSeekBar.setMax(PlayControl.toSeconds(PlayAction.getTrackLength()));
        mCurrentTrackName.setText(PlayAction.getTitle());
        mCurrentTrackArtist.setText(PlayAction.getArtist());
        mCurrentTrackDuration.setText(PlayControl.toMinuteSeconds(PlayAction.getTrackLength()));
    }

}