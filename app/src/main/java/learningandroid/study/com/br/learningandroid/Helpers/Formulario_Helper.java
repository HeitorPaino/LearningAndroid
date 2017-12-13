package learningandroid.study.com.br.learningandroid.Helpers;

import android.widget.EditText;
import android.widget.RatingBar;

import learningandroid.study.com.br.learningandroid.Formulario;
import learningandroid.study.com.br.learningandroid.Modelos.Aluno;
import learningandroid.study.com.br.learningandroid.R;

/**
 * Created by heitorpaino on 12/12/17.
 */

public class Formulario_Helper {

    Aluno aluno = new Aluno();
    EditText CampoNome;
    EditText CampoTelefone;
    EditText CampoEndereco;
    RatingBar CampoRate;
    EditText CampoSite;

    public Formulario_Helper(Formulario formActivity){
        CampoNome = (EditText)formActivity.findViewById(R.id.formulario_nome);
        CampoTelefone = (EditText)formActivity.findViewById(R.id.formulario_telefone);
        CampoEndereco = (EditText)formActivity.findViewById(R.id.formulario_endereco);
        CampoSite = (EditText)formActivity.findViewById(R.id.formulario_site);
        CampoRate = (RatingBar)formActivity.findViewById(R.id.formulario_avaliacao);
    }

    public Aluno PegaAluno(){
        SetAluno();
        return this.aluno;
    }

    public void SetAluno(){
        this.aluno.setNome((CampoNome).getText().toString());
        this.aluno.setTelefone((CampoTelefone).getText().toString());
        this.aluno.setEndereco((CampoEndereco).getText().toString());
        this.aluno.setRate(Double.valueOf((CampoRate).getProgress()));
        this.aluno.setSite((CampoSite).getText().toString());
    }

    public void preencheForm(Aluno aluno) {
        CampoNome.setText(aluno.getNome());
        CampoEndereco.setText(aluno.getEndereco());
        CampoTelefone.setText(aluno.getTelefone());
        CampoRate.setProgress((int)aluno.getRate());
        CampoSite.setText(aluno.getSite());
        this.aluno = aluno;
    }
}
