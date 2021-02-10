package stud11318012.develops.wonderfulindonesia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListPemainAdapter extends BaseAdapter {

    Context abc;
    ArrayList<Pemain> players;

    public ListPemainAdapter(Context context, ArrayList<Pemain> ourPlayers){
        this.abc = context;
        this.players = ourPlayers;
    }

    @Override
    public int getCount() {
        return players.size();
    }

    @Override
    public Object getItem(int i) {
        return players.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view==null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) abc.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.layout_player_item, null);

            holder.imgFoto = view.findViewById(R.id.pemain);
            holder.txtNama = view.findViewById(R.id.nama);
            holder.txtNationality = view.findViewById(R.id.nationality);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        holder.imgFoto.setImageResource(players.get(i).getImgResource());
        holder.imgFoto.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.txtNama.setText(players.get(i).getNamaPemain());
        holder.txtNationality.setText(players.get(i).getNationality());

        return view;
    }

    static class ViewHolder {
        ImageView imgFoto;
        TextView txtNama;
        TextView txtNationality;
    }
}
