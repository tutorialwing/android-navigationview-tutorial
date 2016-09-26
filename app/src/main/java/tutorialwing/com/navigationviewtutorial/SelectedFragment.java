package tutorialwing.com.navigationviewtutorial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SelectedFragment extends Fragment {

	private String title;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_selected, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		// Set selected fragment name.
		TextView txvTitle = (TextView) view.findViewById(R.id.title);
		txvTitle.setText(title);
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
