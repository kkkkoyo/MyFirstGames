using UnityEngine;
using System.Collections;

public class GameStart : MonoBehaviour {



	public void OnStartButtonClicked ()
	{

		Application.LoadLevel("GameScene");
	}
}