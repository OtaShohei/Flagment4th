package and1107.andoroid.fragment4th;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ContentFragment1 extends Fragment {

	TextView textView;

	/**
	 * inflater.inflateで参照を引っ張ってくるのはこれまでのフラグメントと同じ。
	 *
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_content, container, false);
		textView = (TextView) v.findViewById(R.id.textView1);
		return v;
	}

	/**
	 * このメソッドは、ActivityがTextを設定する場合に利用される。
	 * なぜわざわざこうするのかというと、Activity内でFindViewById()をしなくて済ませるため。
	 * このように、メソッドを呼ぶだけとしておけば、Text周りにエフェクトをかける場合もこのメソッドを呼べばOKという利便性が生まれる。
	 *
	 * @param s
	 */
	public void setText(String s) {
		textView.setText(s);
	}
}