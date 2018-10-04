package com.tiqueliro.projetopi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by android on 02/10/2018.
 */

public class AdapterProduto extends BaseAdapter {


    private Context contexto;
    private List<Produto> listaDeProdutos;
    private LayoutInflater inflater;

    public AdapterProduto(Context context, List<Produto> lista) {
        this.contexto = context;
        this.listaDeProdutos = lista;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listaDeProdutos.size();
    }

    @Override
    public Object getItem(int i) {
        return listaDeProdutos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listaDeProdutos.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Suporte item;

        if (view == null) {
            view = inflater.inflate(R.layout.layout_produto, null);
            item = new Suporte();
            item.tvNome = (TextView) view.findViewById(R.id.tvNome);
            item.tvQuantidade = (TextView) view.findViewById(R.id.tvQuantidade);
            item.tvCategoria = (TextView) view.findViewById(R.id.tvCategoria);
            item.tvFabricacao = (TextView)view.findViewById(R.id.tvFabricacao);
            item.tvValidade = (TextView)view.findViewById(R.id.tvValidade);
            item.tvLote = (TextView)view.findViewById(R.id.tvLote);
            view.setTag(item);

        } else {
            item = (Suporte) view.getTag();
        }

        Produto produto = listaDeProdutos.get(i);
        item.tvNome.setText(produto.getNome());
        item.tvQuantidade.setText(produto.getQuantidade());
        item.tvFabricacao.setText(produto.getFabricacao());
        item.tvValidade.setText(produto.getValidade());
        item.tvLote.setText(String.valueOf(produto.getLote()));
        item.tvCategoria.setText(produto.getCategoria().getNome());
        return view;
    }

    private class Suporte {

        TextView tvNome, tvQuantidade, tvCategoria, tvLote , tvValidade ,tvFabricacao;

    }
}