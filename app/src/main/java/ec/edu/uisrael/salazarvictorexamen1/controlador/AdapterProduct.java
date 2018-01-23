package ec.edu.uisrael.salazarvictorexamen1.controlador;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import ec.edu.uisrael.salazarvictorexamen1.R;
import ec.edu.uisrael.salazarvictorexamen1.model.producto;


/**
 * Created by Victor on 29/11/2017.
 */

public class AdapterProduct extends ArrayAdapter<producto> {
    NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault());
    List<producto> aListproducto = new ArrayList<>();
    private static class ViewHolder {
        TextView id;
        TextView name;
        TextView pvp;

    }

    public AdapterProduct(@NonNull Context context, @LayoutRes int resource, @NonNull List<producto> objects) {
        super(context, resource, objects);
        aListproducto = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        //LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //v = inflater.inflate(R.layout.activity_sale, null);
       // Get the data item for this position
        producto vh = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_product, parent, false);
            viewHolder.id = (TextView) convertView.findViewById(R.id.idproduct);
            viewHolder.pvp = (TextView) convertView.findViewById(R.id.txtvalor);

            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data from the data object via the viewHolder object
        // into the template view.

        viewHolder.id.setText(vh.getIdProducto()+ ".- "+ vh.getNombre());
        String pvp = nf.format(vh.getPvp());
        viewHolder.pvp.setText("" + pvp);


        // Return the completed view to render on screen
        return convertView;


    }
}
