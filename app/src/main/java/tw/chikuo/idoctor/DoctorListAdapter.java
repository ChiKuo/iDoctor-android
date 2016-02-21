package tw.chikuo.idoctor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by chikuo on 2015/9/21.
 */
public class DoctorListAdapter extends RecyclerView.Adapter<DoctorListAdapter.ViewHolder> {

    private Context context;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.card_doctor, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        switch (position) {
            case 0 :
                holder.nameTextView.setText("郭文樂醫生");
                holder.clinicTextView.setText("安安泌尿診所");
//                holder.image.setImageDrawable(context.getResources().getDrawable(R.drawable.boy));
//                holder.image.setImageDrawable(context.getResources().getDrawable(R.mipmap.ic_launcher));
                break;
            case 1 :
                holder.nameTextView.setText("劉詩彬醫生");
                holder.clinicTextView.setText("安安泌尿診所");
                break;
            case 2 :
                holder.nameTextView.setText("陳國豐醫生");
                holder.clinicTextView.setText("三重泌尿診所");
                break;
            case 3 :
                holder.nameTextView.setText("張家豪醫生");
                holder.clinicTextView.setText("保潔歡樂診所");
                break;
            case 4 :
                holder.nameTextView.setText("蔡忠祐醫生");
                holder.clinicTextView.setText("安安泌尿診所");
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView nameTextView;
        private TextView clinicTextView;
        private ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            nameTextView = (TextView) itemView.findViewById(R.id.name);
            clinicTextView = (TextView) itemView.findViewById(R.id.clinic);
            image = (ImageView) itemView.findViewById(R.id.image);

        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, DoctorActivity.class);
            context.startActivity(intent);
        }
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
