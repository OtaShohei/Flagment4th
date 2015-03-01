package and1107.andoroid.fragment4th;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.Toast;

/**
 * 疎結合フラグメントの実装を行うクラス。
 *
 * fragment2側のtextViewがeditTextになってもfragment1側の修正が不要になるようにする。
 * 詳しくは、http://android.keicode.com/basics/fragments-communicate-improved.php
 *
 * MainActivityにインターフェースを実装してもらい、fragment側からメソッドを呼び出す。疎結合を行うためfindViewByIdはしない。
 *
 * ・アクティビティに実装するインターフェイスを定義 ・文字を表示する(青色の)側のフラグメントで文字設定用のメソッドを実装 ・これによって、
 * 外部から直接フラグメント内の UI 要素を取得する必要性を排除
 * ・リストやフラグメント側のイベントハンドラにて、アクティビティのイベントハンドラメソッドを呼び出す ・フラグメント内では getActivity()
 * メソッドでアクティビティを取得可能。 ・アクティビティでは FragmentManager
 *
 * を利用して特定のフラグメントがロードされているか確認し（横向きか縦向きを判断）、 フラグメントのメソッドを呼び出すなり、必要な処理を行なう
 *
 * @author 1107AND
 *
 */
public class MainActivity extends Activity implements
		OnSampleListChangeListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	/**
	 * fragmentの管理に関するもろもろを引っ張ってくる。 List側のfragment(ListFragment1)ではこのメソッドを呼び出す。
	 */
	public void onListSelectedChanged(String s) {
		FragmentManager fragmentManager = getFragmentManager();
		/**
		 * ContentFragment1はTextを表示する側。これをコンテントマネジャーから引っ張ってくる。
		 * "contentFragment"という名前のタグをコンテントマネジャーからfindFragmentByTagして引っ張ってきている。
		 */
		ContentFragment1 contentFragment = (ContentFragment1) fragmentManager
				.findFragmentByTag("contentFragment");
		/**
		 * 縦レイアウトならば…
		 */
		if (contentFragment == null || !contentFragment.isVisible()) {
			Toast.makeText(getBaseContext(), s, Toast.LENGTH_SHORT).show();
			/**
			 * 横レイアウトだったら。
			 */
		} else {
			contentFragment.setText(s);
		}
	}
}