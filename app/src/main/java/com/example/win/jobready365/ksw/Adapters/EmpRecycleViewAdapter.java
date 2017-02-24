package com.example.win.jobready365.ksw.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.win.jobready365.ksw.PojoJavaClasses.Employer;
import com.example.win.jobready365.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Win on 2/15/2017.
 */

 public class EmpRecycleViewAdapter extends RecyclerView.Adapter<EmpRecycleViewAdapter.EmpObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<Employer> employers;
    private static MyClickListener myClickListener;
    private Context context;

    public EmpRecycleViewAdapter(Context applicationContext, ArrayList<Employer> employers) {
        this.context =applicationContext;
        this.employers = employers;

    }

    public  class EmpObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView companyNameTextview;
        TextView updatedAtTextview;
        ImageView logoImageView;


        public EmpObjectHolder(View itemView) {
            super(itemView);
            companyNameTextview = (TextView) itemView.findViewById(R.id.textView_company_name);
            updatedAtTextview = (TextView) itemView.findViewById(R.id.textView_update_at);
            logoImageView = (ImageView)itemView.findViewById(R.id.imageView_logo);
            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // get position
                        int pos = getAdapterPosition();
                        // check if item still exists
                        if(pos != RecyclerView.NO_POSITION){
                            Employer clickedDataItem = employers.get(pos);
                          //  Intent intent = new Intent(context, DetailActivity.class);
                          //  intent.putExtra("movie_title", movies.get(pos).getTitle());
                           // intent.putExtra("movie_actors", movies.get(pos).getActors());
                          //  intent.putExtra("movie_cover", movies.get(pos).getCover());
                           // intent.putExtra("movie_director", movies.get(pos).getDirector());
                          //  intent.putExtra("movie_year", movies.get(pos).getYear());
                          //  intent.putExtra("movie_plot", movies.get(pos).getPlot());
                           // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                           // context.startActivity(intent);
                            Toast.makeText(v.getContext(), "You clicked " + clickedDataItem.getCompanyName(), Toast.LENGTH_SHORT).show();
                        }
                    }

            });
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }




    @Override
    public EmpObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.employer_cardview_row, parent, false);

        EmpObjectHolder dataObjectHolder = new EmpObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(EmpObjectHolder holder, int position) {
        holder.companyNameTextview.setText(employers.get(position).getCompanyName());
        holder.updatedAtTextview.setText(employers.get(position).getUpdatedAt());

        // This is how we use Picasso to load images from the internet.
        Picasso.with(context)
                .load(employers.get(position).getLogo())
                .placeholder(R.drawable.load)
                .into(holder.logoImageView);
    }



    public void addItem(Employer employerObj, int index) {
        employers.add(index, employerObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        employers.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return employers.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}

