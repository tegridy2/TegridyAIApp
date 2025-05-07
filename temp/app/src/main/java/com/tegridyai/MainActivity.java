package com.tegridyai;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private RandyAssistant randy;
    private TextToSpeech tts;
    private TextView chatOutput;
    private EditText inputText;
    private Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randy = new RandyAssistant();

        chatOutput = findViewById(R.id.chat_output);
        inputText = findViewById(R.id.input_text);
        sendBtn = findViewById(R.id.send_btn);

        tts = new TextToSpeech(getApplicationContext(), status -> {
            if (status != TextToSpeech.ERROR) {
                tts.setLanguage(Locale.US);
            }
        });

        sendBtn.setOnClickListener(v -> {
            String input = inputText.getText().toString();
            String reply = randy.respond(input);
            chatOutput.append("You: " + input + "\\nRandy: " + reply + "\\n");
            tts.speak(reply, TextToSpeech.QUEUE_FLUSH, null, null);
            inputText.setText("");
        });
    }
}
