package and1107.andoroid.fragment4th;

/**
 * フラグメントは動的に入れ替えることが可能ですが、横向き・縦向きというだけでロードするフラグメントがきまるなら、
 * ランドスケープ用のリソースを定義するのが簡単。
 *
 * アクティビティのイベント処理インターフェイス: OnSampleListChangeListener.java
 *
 * このインターフェースをMainActivityに実装させる。
 *
 * @author 1107AND
 *
 */
public interface OnSampleListChangeListener {
	void onListSelectedChanged(String s);
}