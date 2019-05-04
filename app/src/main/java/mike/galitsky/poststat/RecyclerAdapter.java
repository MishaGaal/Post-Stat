package mike.galitsky.poststat;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemsViewHolder> {

    private    ArrayList<Person> mPersons;
  private    LayoutInflater mInflater;

    public RecyclerAdapter(Context context, ArrayList<Person> persons){

        mPersons = persons;
        mInflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = mInflater.inflate(R.layout.person, viewGroup, false);
        return new ItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsViewHolder itemsViewHolder, int i) {
        final Person person = mPersons.get(i);
        itemsViewHolder.set(person);
    }

    @Override
    public int getItemCount() {
        return mPersons.size();
    }

    public class ItemsViewHolder extends RecyclerView.ViewHolder{

        TextView textViewName;
        ImageView imageView;


        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName =  itemView.findViewById(R.id.textViewName);
            imageView = itemView.findViewById(R.id.imageView4);
        }

        public void set (Person person){
            textViewName.setText(person.getNickname());
            new DownloadImageFromInternet(imageView)
                    .execute(person.getAvatar().url_small);
        }
    }


    private class DownloadImageFromInternet extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public DownloadImageFromInternet(ImageView imageView) {
            this.imageView = imageView;
        }

        protected Bitmap doInBackground(String... urls) {
            String imageURL = urls[0];
            Bitmap bimage = null;
            try {
                InputStream in = new java.net.URL(imageURL).openStream();
                bimage = BitmapFactory.decodeStream(in);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return bimage;
        }

        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }

}
