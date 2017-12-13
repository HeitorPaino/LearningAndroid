package learningandroid.study.com.br.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import learningandroid.study.com.br.learningandroid.DAO.AlunoDAO;
import learningandroid.study.com.br.learningandroid.Helpers.Formulario_Helper;
import learningandroid.study.com.br.learningandroid.Modelos.Aluno;

public class Formulario extends AppCompatActivity {
    Formulario_Helper formHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        formHelper = new Formulario_Helper(Formulario.this);
        Intent intent = getIntent();
        Aluno aluno = (Aluno)intent.getSerializableExtra("aluno");
        if(aluno != null) {
            formHelper.preencheForm(aluno);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.formulario_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.formulario_menu_ok:
                AlunoDAO dao = new AlunoDAO(this);
                Aluno aluno = formHelper.PegaAluno();
                if(aluno.getId() != null)
                {
                    dao.altera(aluno);
                }
                else
                {
                    dao.InsereAluno(aluno);
                }
                dao.close();
                Toast.makeText(Formulario.this,"Aluno " + aluno.getNome() + " Cadastrado",Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
