package learningandroid.study.com.br.learningandroid.converter;

import org.json.JSONException;
import org.json.JSONStringer;

import java.util.List;

import learningandroid.study.com.br.learningandroid.Modelos.Aluno;

/**
 * Created by heitorpaino on 2/26/18.
 */

public class AlunoConverter {
    public String converteParaJson(List<Aluno> alunos) {
        JSONStringer js = new JSONStringer();
        try {
            js.object().key("list").array().object().key("aluno").array();
            for(Aluno aluno : alunos){
                js.object();
                js.key("nome").value(aluno.getNome());
                js.key("nota").value(aluno.getRate());
                js.endObject();
            }
            js.endArray().endObject().endArray().endObject();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return js.toString();
    }
}
