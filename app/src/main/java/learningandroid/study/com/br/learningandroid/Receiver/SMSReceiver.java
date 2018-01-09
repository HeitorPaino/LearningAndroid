package learningandroid.study.com.br.learningandroid.Receiver;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.telephony.SmsMessage;
import android.widget.Toast;

import learningandroid.study.com.br.learningandroid.DAO.AlunoDAO;
import learningandroid.study.com.br.learningandroid.R;

/**
 * Created by heitorpaino on 1/9/18.
 */

public class SMSReceiver extends BroadcastReceiver {
    @SuppressLint("NewApi")
    @Override
    public void onReceive(Context context, Intent intent) {
        AlunoDAO dao = new AlunoDAO(context);
        Object[] pdus = (Object[]) intent.getSerializableExtra("pdus");
        byte[] pdu = (byte[])pdus[0];
        String formato = (String)intent.getSerializableExtra("format");
        SmsMessage sms = SmsMessage.createFromPdu(pdu, formato);
        String Telefone = sms.getDisplayOriginatingAddress();
        if(dao.CheckIfIsAluno(Telefone)){
            Toast.makeText(context, "Chegou um SMS de alguém aqui", Toast.LENGTH_SHORT).show();
            MediaPlayer m = MediaPlayer.create(context,R.raw.hora);
            m.start();
        }
    }
}
