using UnityEngine;
using System.Collections;
using System.Collections.Generic;

public class FloorGenerator : MonoBehaviour {

	const int FloorTipSize=120;
	int currentTipIndex;

	public Transform character;//ターゲットキャラクターの指定
	public GameObject[] stageTips = new GameObject[]{};//ステージチッププレファブ配列
	public int startTipIndex;//自動生成開始index
	public int preInstantiate;//先読み個数
	public List<GameObject> StageList=new List<GameObject>();

	// Use this for initialization
	void Start () {
		currentTipIndex = startTipIndex - 1;
		UpdateStage(preInstantiate);
	}
	
	// Update is called once per frame
	void Update () {
		// キャラクターの位置から現在のステージチップのインデックスを計算
		int charaPositionIndex = (int)(character.position.z / FloorTipSize);

		// 次のステージチップに入ったらステージの更新処理をおこなう
		if (charaPositionIndex + preInstantiate > currentTipIndex) 
		{
			UpdateStage(charaPositionIndex + preInstantiate);	
		}
	}

	void UpdateStage(int toTipIndex){
		if(toTipIndex <= currentTipIndex) return;

		// 指定のステージチップまでを作成 
		for (int i = currentTipIndex + 1; i <= toTipIndex; i++)
		{
			GameObject stageObject = GenerateStage(i);

			// 生成したステージチップを管理リストに追加し
			StageList.Add(stageObject);
		}

		// ステージ保持上限内になるまで古いステージを削除
		while (StageList.Count > preInstantiate + 2) DestroyOldestStage();

		currentTipIndex = toTipIndex;
	}

	// 指定のインデックス位置にStageオブジェクトをランダムに生成
	GameObject GenerateStage (int tipIndex)
	{
		int nextStageTip = Random.Range(0, stageTips.Length);

		GameObject stageObject = (GameObject)Instantiate(
			stageTips[nextStageTip],
			new Vector3(0, 0, tipIndex * FloorTipSize),
			Quaternion.identity
		);

		return stageObject;
	}

	// 一番古いステージを削除
	void DestroyOldestStage ()
	{
		GameObject oldStage = StageList[0];
		StageList.RemoveAt(0);
		Destroy(oldStage);
	}


}
