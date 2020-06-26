package pt.ipg.gestaohospitais;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterList extends ArrayAdapter<User> {

    private LayoutInflater mInflater;
    private ArrayList<User> users;
    private int mViewResourceId;

    public AdapterList(Context context, int textViewResourceId, ArrayList<User> users){
        super(context, textViewResourceId, users);
        this.users = users;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;

    }

    public View getView(int position, View convertView, ViewGroup parents){
        convertView = mInflater.inflate(mViewResourceId, null);

        User user = users.get(position);

        if(user != null){
            TextView nome = (TextView) convertView.findViewById(R.id.textNome);
            TextView numeroCC = (TextView) convertView.findViewById(R.id.textNumeroCC);
            TextView idade = (TextView) convertView.findViewById(R.id.textIdade);
            TextView morada = (TextView) convertView.findViewById(R.id.textMorada);
            TextView telefone = (TextView) convertView.findViewById(R.id.textTelefone);

            if(nome != null){
                nome.setText((user.getNome()));
            }
            if(numeroCC != null){
                numeroCC.setText((user.getNumeroCC()));
            }
            if(idade != null){
                idade.setText((user.getIdade()));
            }
            if(morada != null){
                morada.setText((user.getMorada()));
            }
            if(telefone != null){
                telefone.setText((user.getTelefone()));
            }
        }
        return convertView;
    }
}
