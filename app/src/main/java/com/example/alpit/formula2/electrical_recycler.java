package com.example.alpit.formula2;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 1407268 on 22-03-2017.
 */

public class electrical_recycler extends RecyclerView.Adapter<electrical_recycler.chem_holder> {
    String[] title;
    Drawable[] picture;
    String[] des;
    public electrical_recycler(Context context){
        Resources r = context.getResources();
        title = r.getStringArray(R.array.ele_name);
        des = r.getStringArray(R.array.ele_descrip);
        TypedArray t = r.obtainTypedArray(R.array.ele_images);
        picture = new Drawable[t.length()];
        for (int i = 0; i < picture.length; i++) {
            picture[i] = t.getDrawable(i);
        }
        t.recycle();

    }

    @Override
    public chem_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_cardview, parent, false);
        electrical_recycler.chem_holder chem_holder = new electrical_recycler.chem_holder(view);
        return chem_holder;
    }

    @Override
    public void onBindViewHolder(chem_holder holder, int position) {
        holder.tx_sci.setText(title[position]);
        holder.img_sci.setImageDrawable(picture[position]);
        holder.tx_scides.setText(des[position]);

    }

    @Override
    public int getItemCount() {
        return title.length;

    }
    class chem_holder extends RecyclerView.ViewHolder {
        private TextView tx_sci, tx_scides;
        private ImageView img_sci;

        public chem_holder(final View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() == 0) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), Abbreviation.class));
                    }
                    if (getAdapterPosition() == 1) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), Ohmslaw.class));
                    }
                    if (getAdapterPosition() == 2) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), Resistorcodes.class));
                    }
                    if (getAdapterPosition() == 3) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), Circuitsymbol.class));
                    }
                    if (getAdapterPosition() == 4) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), Basicdefinations.class));
                    }
                    if (getAdapterPosition() == 5) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), Electroniccircuit.class));
                    }
                    if (getAdapterPosition() == 6) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), EMspectrum.class));
                    }
                    if (getAdapterPosition() == 7) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), Greeksymbol.class));
                    }
                    if (getAdapterPosition() == 8) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), Importantfrequency.class));
                    }
                    if (getAdapterPosition() == 9) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), Numbersystem.class));
                    }
                    if (getAdapterPosition() == 10) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), Signal.class));
                    }
                    if (getAdapterPosition() == 11) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), Standards.class));
                    }





                }
            });

            tx_sci = (TextView) itemView.findViewById(R.id.phy_text);
            img_sci = (ImageView) itemView.findViewById(R.id.phy_image1);
            tx_scides = (TextView) itemView.findViewById(R.id.phy_des);
        }

    }

}
