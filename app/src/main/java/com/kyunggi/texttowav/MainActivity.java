package com.kyunggi.texttowav;

import android.app.*;
import android.os.*;
import android.speech.tts.*;
import android.view.*;
import android.widget.*;
import java.util.*;

public class MainActivity extends Activity implements View.OnClickListener, TextToSpeech.OnInitListener
{

	@Override
	public void onInit(int p1)
	{
		// TODO: Implement this method
		Locale enUs = new Locale("korea");  //Locale("en_US");
        if (tts.isLanguageAvailable(enUs) == TextToSpeech.LANG_AVAILABLE)
        {
			tts.setLanguage(enUs);
		}
        else
		{
            tts.setLanguage(Locale.KOREA);
        }
        //myTTS.setLanguage(Locale.US);   // 언어 설정 , 단말기에 언어 없는 버전에선 안되는듯
        tts.setPitch((float) 0.1);  // 높낮이 설정 1이 보통, 6.0미만 버전에선 높낮이도 설정이 안됨
        tts.setSpeechRate((float)2); // 빠르기 설정 1이 보
		tts.synthesizeToFile(text,null,path);
	}
	

	@Override
	public void onClick(View p1)
	{
		// TODO: Implement this method
		path=etPath.getText().toString();
		text=etText.getText().toString();
		tts=new TextToSpeech(this,this);
		
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		btGo=(Button) findViewById(R.id.btGo);
		btGo.setOnClickListener(this);
		etPath=(EditText) findViewById(R.id.etPath);
		etText=(EditText) findViewById(R.id.etText);
		sbRate=(SeekBar) findViewById(R.id.sbRate);
		sbPitch=(SeekBar) findViewById(R.id.sbPitch);
		
    }
	EditText etText,etPath;
	SeekBar sbRate,sbPitch;
	Button btGo;
	TextToSpeech tts;
	String path;
	String text;
}
