package learningandroid.study.com.br.learningandroid;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.List;

import learningandroid.study.com.br.learningandroid.DAO.AlunoDAO;
import learningandroid.study.com.br.learningandroid.Modelos.Aluno;
import learningandroid.study.com.br.learningandroid.converter.AlunoConverter;

/**
 * Created by heitorpaino on 2/28/18.
 */

public class EnviaAlunosTask extends AsyncTask<Object, Object, String> {


    private Context context;
    ProgressDialog dialog;

    public EnviaAlunosTask(Context context){
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context, "aguarde", "Enviando alunos...", true, true);
    }

    @Override
    protected String doInBackground(Object[] objects) {
        AlunoDAO dao = new AlunoDAO(context);
        List<Aluno> alunos = dao.buscaAlunos();
        dao.close();

        AlunoConverter conversor = new AlunoConverter();
        String json = conversor.converteParaJson(alunos);

        WebClient client = new WebClient();
        String resposta = client.post(json);
        return resposta;
    }

    @Override
    protected void onPostExecute(String o) {
        dialog.dismiss();
        Toast.makeText(context, o, Toast.LENGTH_SHORT).show();
    }
}
