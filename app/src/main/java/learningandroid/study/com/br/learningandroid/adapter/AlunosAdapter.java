package learningandroid.study.com.br.learningandroid.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import learningandroid.study.com.br.learningandroid.MainActivity;
import learningandroid.study.com.br.learningandroid.Modelos.Aluno;
import learningandroid.study.com.br.learningandroid.R;

/**
 * Created by heitorpaino on 1/9/18.
 */

public class AlunosAdapter extends BaseAdapter {
    private final List<Aluno> alunos;
    private final Context context;

    public AlunosAdapter(List<Aluno> alunos, Context context) {
        this.alunos = alunos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int i) {
        return alunos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return alunos.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Aluno aluno = alunos.get(i);
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = view;
        if(view == null){
            v = inflater.inflate(R.layout.list_item,null);
        }
        TextView campoNome = v.findViewById(R.id.item_nome);
        TextView campoTelefone = v.findViewById(R.id.item_telefone);
        ImageView campoFoto = v.findViewById(R.id.item_foto);
        campoNome.setText(aluno.getNome());
        campoTelefone.setText(aluno.getTelefone());
        if(aluno.getCaminhoFoto() != null){
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 8;
            Bitmap bitmap = BitmapFactory.decodeFile(aluno.getCaminhoFoto(), options);
            Bitmap bitmapReduzido = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
            campoFoto.setImageBitmap(bitmapReduzido);
            campoFoto.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        return v;
    }
}
