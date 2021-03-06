package mike.galitsky.poststat;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class ComentatorsFragment extends Fragment {
    private RecyclerAdapter adapter;
    private RecyclerView recyclerView;
    private ArrayList<Person> persons;
    private TextView textView;


    private static  final String EXTRA_ITEMS = "mike.galitsky.myshop.EXTRA.ITEMS";



    public static ComentatorsFragment newInstance(ArrayList<Person> persons){

        ComentatorsFragment comentatorsFragment = new ComentatorsFragment();

        Bundle args = new Bundle();
        args.putParcelableArrayList(EXTRA_ITEMS, persons);

        comentatorsFragment.setArguments(args);

        return comentatorsFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        persons = getArguments().getParcelableArrayList(EXTRA_ITEMS);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_main, container, false);

        textView = view.findViewById(R.id.textViewTop);
        textView.setText("Commentators: " + persons.size());
        recyclerView = view.findViewById(R.id.recycler);
        LinearLayoutManager layout = new LinearLayoutManager(getContext());
        layout.setOrientation(LinearLayout.HORIZONTAL);
        recyclerView.setLayoutManager(layout);

        init();
        return view;
    }

    private void init() {

        adapter = new RecyclerAdapter(
                getContext(),
                persons
        );

        recyclerView.setAdapter(adapter);
    }
}
