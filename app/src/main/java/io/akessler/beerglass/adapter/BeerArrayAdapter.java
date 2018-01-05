package io.akessler.beerglass.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import io.akessler.beerglass.R;
import io.akessler.beerglass.model.Beer;

public class BeerArrayAdapter extends ArrayAdapter<Beer> {
    private final Context context;
    private final List<Beer> values;

    public BeerArrayAdapter(Context context, List<Beer> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values; // do we need deep copy?
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_beer, parent, false);
        ImageView imageView = rowView.findViewById(R.id.icon);
        TextView firstLine = rowView.findViewById(R.id.firstLine);
        TextView secondLine = rowView.findViewById(R.id.secondLine);

        Beer b = values.get(position);
        imageView.setImageResource(R.drawable.ic_launcher_foreground); // TODO Change me!
        firstLine.setText(b.name);
        secondLine.setText(b.description);

        return rowView;
    }
}