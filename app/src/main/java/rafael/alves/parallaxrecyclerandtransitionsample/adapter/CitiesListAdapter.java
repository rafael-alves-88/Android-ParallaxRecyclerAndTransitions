package rafael.alves.parallaxrecyclerandtransitionsample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yayandroid.parallaxrecyclerview.ParallaxViewHolder;

import java.util.List;

import rafael.alves.parallaxrecyclerandtransitionsample.R;
import rafael.alves.parallaxrecyclerandtransitionsample.model.City;

public class CitiesListAdapter extends RecyclerView.Adapter<CitiesListAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private List<City> cityList;
    private final OnCityClickListener listener;

    public interface OnCityClickListener {
        void onCityClick(String cityImage);
    }

    public CitiesListAdapter(Context context, List<City> cityList, OnCityClickListener listener) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.cityList = cityList;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        return new ViewHolder(inflater.inflate(R.layout.item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        // viewHolder.getBackgroundImage().setImageResource(imageIds[position % imageIds.length]);
        Picasso.with(context).load(cityList.get(position).Image).into(viewHolder.getBackgroundImage());
        viewHolder.getTextView().setText(cityList.get(position).Name);

        // Click
        viewHolder.bind(cityList.get(position).Image, listener);

        // # CAUTION:
        // Important to call this method
        viewHolder.getBackgroundImage().reuse();
    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }

    /**
     * # CAUTION:
     * ViewHolder must extend from ParallaxViewHolder
     */
    public static class ViewHolder extends ParallaxViewHolder {

        private final TextView textView;

        public ViewHolder(View v) {
            super(v);

            textView = (TextView) v.findViewById(R.id.label);
        }

        @Override
        public int getParallaxImageId() {
            return R.id.backgroundImage;
        }

        public TextView getTextView() {
            return textView;
        }

        public void bind(final String cityImage, final OnCityClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onCityClick(cityImage);
                }
            });
        }
    }
}