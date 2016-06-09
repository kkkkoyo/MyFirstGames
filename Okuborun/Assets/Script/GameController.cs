using UnityEngine;
using System.Collections;
using UnityEngine.UI;

public class GameController: MonoBehaviour {

	public SeisanController seisan;
	public Text ScoreLabel;
	public LifePanel lifePanel;

	// Update is called once per frame
	void Update () {
		// スコアラベルを更新
		int score = CalcScore();
		ScoreLabel.text = "Score : " + score + "m";

		// ライフパネルを更新
		lifePanel.UpdateLife(seisan.Life());

//		// ねじ子のライフが0になったらゲームオーバー
//		if (seisan.Life() <= 0)
//		{
//			// これ以降のUpdateは止める
//			enabled = false;
//			// ハイスコアを更新
//			if (PlayerPrefs.GetInt("HighScore") < score)
//			{
//				PlayerPrefs.SetInt("HighScore", score);
//			}
//
//			// 2秒後にReturnToTitleを呼びだす
//			Invoke("ReturnToTitle", 2.0f);
		}

	int CalcScore(){

		//Debug.Log ((int)transform.position.z/10);
		//return  (int)seisan.transform.position.z/10;
		int PosZ = (int) Mathf.Abs( seisan.gameObject.transform.position.z);

		return PosZ / 10;
	
	}

	}

