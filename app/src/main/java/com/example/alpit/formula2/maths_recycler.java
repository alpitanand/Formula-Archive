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

class Maths_recycler extends RecyclerView.Adapter<Maths_recycler.MathView> {

    String[] name;
    String[] des;
    Drawable[] pic;

    public Maths_recycler(Context context) {
        Resources r = context.getResources();
        name = r.getStringArray(R.array.mat_name);
        des = r.getStringArray(R.array.mat_descript);
        TypedArray t = r.obtainTypedArray(R.array.mat_img);
        pic = new Drawable[t.length()];
        for (int i = 0; i < pic.length; i++) {
            pic[i] = t.getDrawable(i);
        }
        t.recycle();

    }

    @Override
    public Maths_recycler.MathView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_cardview, parent, false);
        MathView mathView = new MathView(view);
        return mathView;
    }

    @Override
    public void onBindViewHolder(Maths_recycler.MathView holder, int position) {
        holder.tx_sci.setText(name[position]);
        holder.img_sci.setImageDrawable(pic[position]);
        holder.tx_scides.setText(des[position]);

    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class MathView extends RecyclerView.ViewHolder {
        private TextView tx_sci, tx_scides;
        private ImageView img_sci;

        public MathView(final View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() == 0) {
                                itemView.getContext().startActivity(new Intent(itemView.getContext(), Algebricformulas.class));
                            }
                    if (getAdapterPosition() == 1) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), Functionformulas.class));
                    }
                    if (getAdapterPosition() == 2) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), AnalyticGeometry.class));
                    }
                    if (getAdapterPosition() == 3) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), Limits.class));
                    }
                    if (getAdapterPosition() == 4) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), indefiniteIntegral.class));
                    }
                    if (getAdapterPosition() == 5) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), definiteIntegral.class));
                    }
                    if (getAdapterPosition() == 6) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), Series.class));
                    }
                    if (getAdapterPosition() == 7) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), laplace.class));
                    }
                    if (getAdapterPosition() == 8) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(),Most.class));
                    }




                }
            });
            tx_sci = (TextView) itemView.findViewById(R.id.phy_text);
            img_sci = (ImageView) itemView.findViewById(R.id.phy_image1);
            tx_scides = (TextView) itemView.findViewById(R.id.phy_des);
        }
    }
}