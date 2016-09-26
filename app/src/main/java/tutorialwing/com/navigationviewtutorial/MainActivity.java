package tutorialwing.com.navigationviewtutorial;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	private Toolbar toolbar;
	private NavigationView navigationView;
	private DrawerLayout drawerLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Find the toolbar by id and set it as actionBar.
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		// Find the navigationView and DrawerLayout by their ids.
		navigationView = (NavigationView) findViewById(R.id.navigation_view_left);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

		setDrawerLayout();
		setItemSelectListener();
	}

	private void setDrawerLayout() {
		ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
				toolbar, R.string.openDrawer, R.string.closeDrawer) {

			@Override
			public void onDrawerClosed(View drawerView) {
				// Write code to perform action when drawer is closed.
				super.onDrawerClosed(drawerView);
			}

			@Override
			public void onDrawerSlide(View drawerView, float slideOffset) {
				// Write code to perform action when drawer is sliding.
				super.onDrawerSlide(drawerView, slideOffset);
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				// Write code to perform action when drawer is opened.
				super.onDrawerOpened(drawerView);
			}
		};

		// Set the actionbarToggle to drawer layout.
		drawerLayout.addDrawerListener(actionBarDrawerToggle);

		// Calling sync state is necessary or else your hamburger icon wont show up.
		actionBarDrawerToggle.syncState();
	}

	private void setItemSelectListener() {
		if (navigationView == null)
			return;

		// Set item click listener to perform action on menu item click.
		navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

			@Override
			public boolean onNavigationItemSelected(MenuItem menuItem) {

				// Toggle the checked state of menuItem.
				menuItem.setChecked(!menuItem.isChecked());

				// Close the drawer
				drawerLayout.closeDrawers();

				// Get the menu by Id and perform desired actions. Here, we are showing a common
				// fragment(SelectedFragment) on click of any menu item. You can do any action
				// on click of a menu item similarly. You just need to write code as below
				// case R.id.menu_item_id:
				// 		some action to perform
				// 		break;
				switch (menuItem.getItemId()) {
					case R.id.inbox:
					case R.id.starred:
					case R.id.sent_mail:
					case R.id.drafts:
					case R.id.allmail:
					case R.id.trash:
					case R.id.spam:
						SelectedFragment selectedFragment = new SelectedFragment();
						selectedFragment.setTitle(String.valueOf(menuItem.getTitle()));
						FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
						fragmentTransaction.replace(R.id.frame, selectedFragment);
						fragmentTransaction.commit();
						break;
				}

				Toast.makeText(getApplicationContext(), menuItem.getTitle() + " Selected", Toast.LENGTH_SHORT).show();
				return true;
			}
		});
	}
}
