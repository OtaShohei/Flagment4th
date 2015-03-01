package and1107.andoroid.fragment4th;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListFragment1 extends Fragment implements OnItemClickListener {

	static List<String> dataList = new ArrayList<String>();
	static ArrayAdapter<String> adapter;
	ListView listView;//あとから使えるようにメンバ変数で用意。

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_list, container, false);
		listView = (ListView) v.findViewById(R.id.listView1);
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		// データ初期化。サイズが0かを見ているのは、画面が縦横切り替わるときに重ならないようにするため。
		if (dataList.size() == 0) {
			dataList.add("Foo");
			dataList.add("Bar");
			dataList.add("Baz");
		}

		// アダプターの作成と設定。第1引数はcontext。第2引数がデータで第3引数が一行のレイアウト。
		adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, dataList);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
	}

	/**
	 *MainActivityのonListSelectedChanged()を呼び出すのはこのメソッド。
	 */
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		/**
		 * 自分が属するActivityをまず取得する。
		 */
		Activity a = getActivity();
		/**
		 * instanceofで、OnSampleListChangeListenerにキャストできるかどうかを判定した上で、キャストして代入。
		 */
		if (a instanceof OnSampleListChangeListener) {
			/**
			 *
			 */
			OnSampleListChangeListener listener = (OnSampleListChangeListener) getActivity();
			/**
			 * OnSampleListChangeListenerを実装したMainActivityのonListSelectedChangedメソッドを呼び出す。
			 * そうすることで、縦レイアウト横レイアウトを判定して動作を変えている。
			 */
			listener.onListSelectedChanged(dataList.get(position));
		}

	}
}