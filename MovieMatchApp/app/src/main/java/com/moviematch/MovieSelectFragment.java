package com.moviematch;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.fragment.app.Fragment;

/**
 * A fragment with a Google +1 button.
 * Activities that contain this fragment must implement the
 * {@link MovieSelectFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MovieSelectFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MovieSelectFragment extends Fragment implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        System.out.println("Received onclick from view " + v.getId());
        switch (v.getId()) {
            case R.id.ThumbsUpButton: sendOpinion(true);
            break;
            case R.id.ThumbsDownButton: sendOpinion(false);
            break;
        }
    }

    class MovieMatchClient extends AsyncTask<MovieMatchProtos.MovieOpinion, Void, Boolean> {

        Socket clientSocket = new Socket();

        public MovieMatchClient(MovieMatchProtos.MovieOpinion opinion) {
            this.opinion = opinion;
        }

        MovieMatchProtos.MovieOpinion opinion;

        @Override
        protected Boolean doInBackground(MovieMatchProtos.MovieOpinion... opinions) {
            try {
                System.out.println("Localhost is " + InetAddress.getLocalHost());
                System.out.println("Creating socket...");
//                clientSocket = new Socket("10.0.0.79", 44444);
                clientSocket.connect(new InetSocketAddress("10.0.0.79", 44444), 250);
                if (clientSocket.isConnected()) {
                    System.out.println("Connected to socket.");
                }
                else {
                    System.out.println("Failed to connect to socket.");
                    throw new IOException();
                }
                System.out.println("Sending opinion: " + opinion.toString());
                opinion.writeDelimitedTo(clientSocket.getOutputStream());
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            if (result) {
                signalOpinionSuccess();
            }
            else {
                signalOpinionFail("Error: Can't connect to server.");
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
    }

    final Animation fadeOutAnimation = new AlphaAnimation(1.0f, 0.0f);


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // The request code must be 0 or greater.
    private static final int PLUS_ONE_REQUEST_CODE = 0;
    // The URL to +1.  Must be a valid URL.
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View fragmentView;
    Map<String, String> movieMap = new HashMap<>();


    public MovieSelectFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MovieSelectFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MovieSelectFragment newInstance(String param1, String param2) {
        MovieSelectFragment fragment = new MovieSelectFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        fadeOutAnimation.setDuration(3000);
        fadeOutAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                getActivity().findViewById(R.id.confirmationText).setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void setAutoCompleteSuggestions() {
        List<String> movieList = new ArrayList<>(Arrays.asList("The Matrix", "The Lion King", "Step Brothers", "Oh Brother Where Are Thou", "Avatar The Last Airbender"));
        for (String movie : movieList) {
            movieMap.put(movie.toLowerCase(), movie);
        }
        AutoCompleteTextView textView = fragmentView.findViewById(R.id.MovieTextBox);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this.getContext(), android.R.layout.simple_list_item_1, movieList.toArray(new String[movieList.size()]));
        textView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.movie_select_fragment, container, false);
        fragmentView = view;
        view.findViewById(R.id.ThumbsUpButton).setOnClickListener(this);
        view.findViewById(R.id.ThumbsDownButton).setOnClickListener(this);
        setAutoCompleteSuggestions();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        // Refresh the state of the +1 button each time the activity receives focus.
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void sendOpinion(boolean thumbsUp) {
        EditText movieTextBox = getActivity().findViewById(R.id.MovieTextBox);
        Editable movieText = movieTextBox.getText();
        String movieName = movieText.toString();
        if (movieName.isEmpty()) return;
        if (!movieMap.containsKey(movieName.toLowerCase())) {
            signalOpinionFail("Movie \"" + movieName + "\" not found.");
            return;
        }

        MovieMatchProtos.MovieOpinion opinion = MovieMatchProtos.MovieOpinion.newBuilder().
                setUserId(0).setMovieName(movieName).setThumbsUp(thumbsUp).build();

        MovieMatchClient client = new MovieMatchClient(opinion);
        client.execute();
    }

    private void signalOpinionFail(String reason) {
        System.out.println("Signaling opinion fail...");
        final TextView confirmationText = getActivity().findViewById(R.id.confirmationText);
        confirmationText.setText(reason);
        confirmationText.setVisibility(View.VISIBLE);
        confirmationText.startAnimation(fadeOutAnimation);
    }

    private void signalOpinionSuccess() {
        System.out.println("Signaling opinion success...");
        final TextView confirmationText = getActivity().findViewById(R.id.confirmationText);
        confirmationText.setText("Opinion saved!");
        confirmationText.setVisibility(View.VISIBLE);
        confirmationText.startAnimation(fadeOutAnimation);
        ((EditText)getActivity().findViewById(R.id.MovieTextBox)).getText().clear();
    }

}
