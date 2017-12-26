package learningandroid.study.com.br.learningandroid.Helpers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;
import android.widget.ImageView;
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
    ImageView CampoFoto;

    public Formulario_Helper(Formulario formActivity){
        CampoNome = (EditText)formActivity.findViewById(R.id.formulario_nome);
        CampoTelefone = (EditText)formActivity.findViewById(R.id.formulario_telefone);
        CampoEndereco = (EditText)formActivity.findViewById(R.id.formulario_endereco);
        CampoSite = (EditText)formActivity.findViewById(R.id.formulario_site);
        CampoRate = (RatingBar)formActivity.findViewById(R.id.formulario_avaliacao);
        CampoFoto = (ImageView)formActivity.findViewById(R.id.formulario_foto);
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
        this.aluno.setCaminhoFoto((String)CampoFoto.getTag());
    }

    public void preencheForm(Aluno aluno) {
        CampoNome.setText(aluno.getNome());
        CampoEndereco.setText(aluno.getEndereco());
        CampoTelefone.setText(aluno.getTelefone());
        CampoRate.setProgress((int)aluno.getRate());
        CampoSite.setText(aluno.getSite());
        carregaImagem(aluno.getCaminhoFoto());
        this.aluno = aluno;
    }

    public void carregaImagem(String caminhoFoto){
        if(caminhoFoto != null){
            Bitmap bitmap = BitmapFactory.decodeFile(caminhoFoto);
            Bitmap bitmapReduzido = Bitmap.createScaledBitmap(bitmap, 300, 300, true);
            CampoFoto.setImageBitmap(bitmapReduzido);
            CampoFoto.setScaleType(ImageView.ScaleType.FIT_XY);
            CampoFoto.setTag(caminhoFoto);
        }
    }
}
