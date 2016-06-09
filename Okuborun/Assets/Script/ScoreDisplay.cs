using UnityEngine;
using System.Collections;
using UnityEngine.UI;

public class ScoreDisplay: MonoBehaviour {

	public SeisanController game;
	public Text ScoreLabel;

	// Update is called once per frame
	void Start () {
		// スコアラベルを更新
		int score=PlayerPrefs.GetInt("AllScore");//layerPrefs.GetInt("HighScore");
		ScoreLabel.text = "Score : " + score + "m";
	}



}
